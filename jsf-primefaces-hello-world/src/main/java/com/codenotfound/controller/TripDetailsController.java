package com.codenotfound.controller;

import java.util.List;

import javax.enterprise.context.ConversationScoped;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Named;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.codenotfound.dto.TripRegisterDto;
import com.codenotfound.entity.TripRegister;
import com.codenotfound.repo.TripRegisterRepository;

@Named
@Controller
@ConversationScoped
public class TripDetailsController implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String lorryNumber;
	
	@Autowired
	private TripRegisterRepository tripRegisterRepository;
	
	private List<TripRegisterDto> tripRegisterDtos;
	
	
	public void getTripDetails(){
		Iterable<TripRegister> tripRegister=tripRegisterRepository.findAll();
		for(TripRegister atripRegister:tripRegister){
			TripRegisterDto aTripRegisterDto=new TripRegisterDto();
			BeanUtils.copyProperties(atripRegister, aTripRegisterDto);
			tripRegisterDtos.add(aTripRegisterDto);
		}
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

}
