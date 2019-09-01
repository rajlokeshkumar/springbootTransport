package com.codenotfound.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import org.springframework.util.StringUtils;

import com.codenotfound.dto.TripRegisterDto;
import com.codenotfound.entity.TripRegister;
import com.codenotfound.repo.TripRegisterRepository;

@Named
@Controller
@ViewScoped
public class TripDetailsController implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String lorryNumber;

	@Autowired
	private TripRegisterRepository tripRegisterRepository;

	private List<TripRegisterDto> tripRegisterDtos;

	private TripRegisterDto tripRegisterDto;

	private boolean disableSubmitButton = true;

	private String startPlace;

	private String endPlace;

	private Set<String> startPlaces = new HashSet<>();

	private Set<String> endPlaces = new HashSet<>();

	public Set<String> getStartPlaces() {
		return startPlaces;
	}

	public void setStartPlaces(Set<String> startPlaces) {
		this.startPlaces = startPlaces;
	}

	public Set<String> getEndPlaces() {
		return endPlaces;
	}

	public void setEndPlaces(Set<String> endPlaces) {
		this.endPlaces = endPlaces;
	}

	public String getStartPlace() {
		return startPlace;
	}

	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}

	public String getEndPlace() {
		return endPlace;
	}

	public void setEndPlace(String endPlace) {
		this.endPlace = endPlace;
	}

	public boolean isDisableSubmitButton() {
		return disableSubmitButton;
	}

	@PostConstruct
	public void init() {
		for (TripRegister tripRegister : this.tripRegisterRepository.findAll()) {
			startPlaces.add(tripRegister.getStartPlace());
			endPlaces.add(tripRegister.getEndPlace());
		}
	}

	public void setDisableSubmitButton(boolean disableSubmitButton) {
		this.disableSubmitButton = disableSubmitButton;
	}

	private String tripRegisterId;

	public String getTripRegisterId() {
		return tripRegisterId;
	}

	public void setTripRegisterId(String tripRegisterId) {
		this.tripRegisterId = tripRegisterId;
	}

	public TripRegisterDto getTripRegisterDto() {
		return tripRegisterDto;
	}

	public void setTripRegisterDto(TripRegisterDto tripRegisterDto) {
		this.tripRegisterDto = tripRegisterDto;
	}

	public TripRegisterRepository getTripRegisterRepository() {

		return tripRegisterRepository;
	}

	public void setTripRegisterRepository(TripRegisterRepository tripRegisterRepository) {
		this.tripRegisterRepository = tripRegisterRepository;
	}

	public List<TripRegisterDto> getTripRegisterDtos() {
		if (tripRegisterDtos == null) {
			tripRegisterDtos = new ArrayList<>();
		}
		return tripRegisterDtos;
	}

	public void setTripRegisterDtos(List<TripRegisterDto> tripRegisterDtos) {
		this.tripRegisterDtos = tripRegisterDtos;
	}

	public String getLorryNumber() {
		return lorryNumber;
	}

	public void setLorryNumber(String lorryNumber) {
		this.lorryNumber = lorryNumber;
	}

	@Override
	public void afterPhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public PhaseId getPhaseId() {
		// TODO Auto-generated method stub
		return null;
	}

	public void processRequest() {
		List<TripRegister> aTripRegisters = null;
		if(StringUtils.isEmpty(this.getStartPlace())){
			this.startPlace=null;
		}
		if(StringUtils.isEmpty(this.getEndPlace())){
			this.endPlace=null;
		}
		if(StringUtils.isEmpty(this.getLorryNumber())){
			this.lorryNumber=null;
		}
		if (this.getStartPlace() != null && this.getEndPlace() != null && this.getLorryNumber() != null) {
			aTripRegisters = this.tripRegisterRepository.findByVechileNumberAndStartPlaceAndEndPlace(
					this.getLorryNumber(), this.getStartPlace(), this.getEndPlace());
		} else if (this.getStartPlace() != null && this.getEndPlace() != null && this.getLorryNumber() == null) {
			aTripRegisters = this.tripRegisterRepository.findByStartPlaceAndEndPlace(this.getStartPlace(),
					this.getEndPlace());
		} else if (this.getStartPlace() != null && this.getEndPlace() == null && this.getLorryNumber() != null) {
			aTripRegisters = this.tripRegisterRepository.findByVechileNumberAndStartPlace(this.getLorryNumber(),
					this.getStartPlace());
		} else if (this.getStartPlace() != null && this.getEndPlace() == null && this.getLorryNumber() == null) {
			aTripRegisters = this.tripRegisterRepository.findByStartPlace(this.getStartPlace());
		} else if (this.getStartPlace() == null && this.getEndPlace() != null && this.getLorryNumber() != null) {
			aTripRegisters = this.tripRegisterRepository.findByVechileNumberAndEndPlace(this.getLorryNumber(),
					this.getEndPlace());
		} else if (this.getStartPlace() == null && this.getEndPlace() != null && this.getLorryNumber() == null) {
			aTripRegisters = this.tripRegisterRepository.findByEndPlace(this.getEndPlace());
		} else if (this.getStartPlace() == null && this.getEndPlace() == null && this.getLorryNumber() != null) {
			aTripRegisters = tripRegisterRepository.findByVechileNumber(this.getLorryNumber());
		} else if (this.getStartPlace() == null && this.getEndPlace() != null && this.getLorryNumber() != null) {
			aTripRegisters = tripRegisterRepository.findByVechileNumberAndEndPlace(this.getLorryNumber(),
					this.getEndPlace());
		} else if (this.getStartPlace() == null && this.getEndPlace() == null && this.getLorryNumber() == null) {
			aTripRegisters = (List<TripRegister>) tripRegisterRepository.findAll();
		}

		this.tripRegisterDtos = null;
		for (TripRegister atripRegister : aTripRegisters) {
			TripRegisterDto aTripRegisterDto = new TripRegisterDto();
			BeanUtils.copyProperties(atripRegister, aTripRegisterDto);
			this.getTripRegisterDtos().add(aTripRegisterDto);
		}

	}

	public void oncontextMenuClick(SelectEvent event) {
		disableSubmitButton = false;
		tripRegisterId = ((TripRegisterDto) event.getObject()).getId();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("tripRegisterId", tripRegisterId);
	}

	public void onRowUnselect(UnselectEvent event) {
		disableSubmitButton = true;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("tripRegisterId");
	}

	public void deleteTripDetails() {
		if (tripRegisterId != null)
			this.tripRegisterRepository.deleteById(tripRegisterId);
		this.processRequest();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Trip has been Deleted Successfully"));
	}
}
