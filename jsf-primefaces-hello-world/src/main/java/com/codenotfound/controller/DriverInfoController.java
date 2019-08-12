package com.codenotfound.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.codenotfound.dto.DriverInfodto;
import com.codenotfound.entity.DriverInfo;
import com.codenotfound.repo.DriverInfoRepo;

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
	
	@PostConstruct
	public void init(){
		this.getDriverList();
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
	}

}
