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
import com.codenotfound.dto.TripRegisterDto;
import com.codenotfound.entity.DriverInfo;
import com.codenotfound.entity.TripRegister;
import com.codenotfound.entity.Vehicle;
import com.codenotfound.repo.DriverInfoRepo;
import com.codenotfound.repo.VehicleRepository;

@Named
@Controller
@ViewScoped
public class DriverInfoController  implements PhaseListener {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DriverInfodto driverInfodto;
	@Autowired
	private DriverInfoRepo driverInfoRepo;
	
	private List<DriverInfodto> driverInfodtos;
	
	private String driverInfoId;
	
	private DriverInfodto selectedDriverInfo;
	@Autowired
	private VehicleRepository vehicleRepository;
	private List<String> vehicleNo;
	
	

	public VehicleRepository getVehicleRepository() {
		return vehicleRepository;
	}

	public void setVehicleRepository(VehicleRepository vehicleRepository) {
		this.vehicleRepository = vehicleRepository;
	}

	public List<String> getVehicleNo() {
		if(vehicleNo==null){
			vehicleNo=new ArrayList<>();
		}
		return vehicleNo;
	}

	public void setVehicleNo(List<String> vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public DriverInfodto getSelectedDriverInfo() {
		return selectedDriverInfo;
	}

	public void setSelectedDriverInfo(DriverInfodto selectedDriverInfo) {
		this.selectedDriverInfo = selectedDriverInfo;
	}

	public String getDriverInfoId() {
		return driverInfoId;
	}

	public void setDriverInfoId(String driverInfoId) {
		this.driverInfoId = driverInfoId;
	}

	public List<DriverInfodto> getDriverInfodtos() {
		if(this.driverInfodtos==null){
			this.driverInfodtos=new ArrayList<DriverInfodto>();
		}
		return driverInfodtos;
	}

	public void setDriverInfodtos(List<DriverInfodto> driverInfodtos) {
		this.driverInfodtos = driverInfodtos;
	}

	public DriverInfoRepo getDriverInfoRepo() {
		return driverInfoRepo;
	}

	public void setDriverInfoRepo(DriverInfoRepo driverInfoRepo) {
		this.driverInfoRepo = driverInfoRepo;
	}

	public DriverInfodto getDriverInfodto() {
		if(driverInfodto==null){
			driverInfodto=new DriverInfodto();
		}
		return driverInfodto;
	}

	public void setDriverInfodto(DriverInfodto driverInfodto) {
		this.driverInfodto = driverInfodto;
	}

	public DriverInfoController(){
		
	}
	public void getVehicleList() {
		Iterable<Vehicle> a = this.vehicleRepository.findAll();
		for (Vehicle b : a) {
			this.getVehicleNo().add(b.getRegistrationNumber());
		}
	}
	@PostConstruct
	public void init() {
		this.getDriverList();
		this.getVehicleList();
		if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("driverInfoId") != null) {
			String driverinfoId = FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
					.get("driverInfoId").toString();
			DriverInfo aDriverInfo = this.driverInfoRepo.findById(driverinfoId).get();
			BeanUtils.copyProperties(aDriverInfo, this.getDriverInfodto());
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("driverInfoId");
		}
	}
	
	public void getDriverList(){
		Iterable<DriverInfo> a=this.driverInfoRepo.findAll();
		for(DriverInfo b:a){
			DriverInfodto aDriverInfodtoc=new DriverInfodto();
			BeanUtils.copyProperties(b, aDriverInfodtoc);
			this.getDriverInfodtos().add(aDriverInfodtoc);
		}
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
	
	public void performtheAction(){
		DriverInfo driverInfo=new DriverInfo();
		BeanUtils.copyProperties(this.getDriverInfodto(), driverInfo);
		this.getDriverInfoRepo().save(driverInfo);
		this.driverInfodto=new DriverInfodto();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Driver Information updated"));
	}
	public void onRowUnselect(UnselectEvent event) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("driverInfoId");
	}
	public void deleteDriverInfo( ){
		this.driverInfoRepo.deleteById(driverInfoId);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("driverInfoId");
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Driver Information Deleted"));
	}
	
	public void oncontextMenuClick(SelectEvent event) {
		driverInfoId = ((DriverInfodto) event.getObject()).getLicenseno();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("driverInfoId", driverInfoId);
	}
	
}
