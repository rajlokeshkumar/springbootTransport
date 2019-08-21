package com.codenotfound.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.codenotfound.dto.DriverInfodto;
import com.codenotfound.dto.VehicleDto;
import com.codenotfound.entity.DriverInfo;
import com.codenotfound.entity.Vehicle;
import com.codenotfound.repo.VehicleRepository;

@Controller
@Named
@ViewScoped
public class VehicleInfoController implements PhaseListener {

	private static final long serialVersionUID = 1L;

	@Autowired
	private VehicleRepository vehicleRepository;

	private VehicleDto vehicleDto;

	private List<String> vehicleLists;

	private List<VehicleDto> vechileDtos;

	private String vehicleId;

	private VehicleDto selectedVehicleInfoDto;

	public VehicleDto getSelectedVehicleInfoDto() {
		return selectedVehicleInfoDto;
	}

	public void setSelectedVehicleInfoDto(VehicleDto selectedVehicleInfoDto) {
		this.selectedVehicleInfoDto = selectedVehicleInfoDto;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public List<VehicleDto> getVechileDtos() {
		if (vechileDtos == null) {
			vechileDtos = new ArrayList<>();
		}
		return vechileDtos;
	}

	public void setVechileDtos(List<VehicleDto> vechileDtos) {
		this.vechileDtos = vechileDtos;
	}

	public VehicleRepository getVehicleRepository() {
		return vehicleRepository;
	}

	public void setVehicleRepository(VehicleRepository vehicleRepository) {
		this.vehicleRepository = vehicleRepository;
	}

	public VehicleDto getVehicleDto() {

		if (this.vehicleDto == null) {
			this.vehicleDto = new VehicleDto();
		}
		return vehicleDto;

	}

	public void setVehicleDto(VehicleDto vehicleDto) {
		this.vehicleDto = vehicleDto;
	}

	public VehicleInfoController() {

	}

	@PostConstruct
	public void init() {
		getVehicleList();

		if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("vehicleId") != null) {
			String vehicleId = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("vehicleId")
					.toString();
			Vehicle aVehicle = this.vehicleRepository.findById(vehicleId).get();
			BeanUtils.copyProperties(aVehicle, this.getVehicleDto());
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("vehicleId");
		}
	}

	public void performtheAction() {
		Vehicle aVehicle = new Vehicle();
		BeanUtils.copyProperties(this.vehicleDto, aVehicle);
		this.vehicleRepository.save(aVehicle);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Vehicle Information updated"));
	}

	public void getVehicleList() {
		Iterable<Vehicle> a = this.vehicleRepository.findAll();
		for (Vehicle b : a) {
			VehicleDto vehicleDto = new VehicleDto();
			BeanUtils.copyProperties(b, vehicleDto);
			this.getVechileDtos().add(vehicleDto);
			this.getVehicleLists().add(vehicleDto.getRegistrationNumber());
		}
	}

	public List<String> getVehicleLists() {
		if (this.vehicleLists == null) {
			this.vehicleLists = new ArrayList<>();
		}
		return vehicleLists;
	}

	public void setVehicleLists(List<String> vehicleLists) {
		this.vehicleLists = vehicleLists;
	}

	@Override
	public void afterPhase(PhaseEvent event) {
		System.out.println(event.getPhaseId());

	}

	@Override
	public void beforePhase(PhaseEvent event) {
		System.out.println(event.getPhaseId());
	}

	@Override
	public PhaseId getPhaseId() {
		// TODO Auto-generated method stub
		return null;
	}

	public void onRowUnselect(UnselectEvent event) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("vehicleId");
	}

	public void deleteVehicleInfo() {
		this.vehicleRepository.deleteById(vehicleId);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("vehicleId");
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Vehicle Information Deleted"));
	}

	public void oncontextMenuClick(SelectEvent event) {
		vehicleId = ((VehicleDto) event.getObject()).getRegistrationNumber();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("vehicleId", vehicleId);
	}
}
