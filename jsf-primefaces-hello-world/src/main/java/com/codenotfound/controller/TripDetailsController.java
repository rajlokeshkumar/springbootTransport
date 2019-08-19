package com.codenotfound.controller;

import java.util.ArrayList;
import java.util.List;

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

		List<TripRegister> aTripRegisters = tripRegisterRepository.findByVechileNumber(this.getLorryNumber());
		this.tripRegisterDtos = null;
		for (TripRegister atripRegister : aTripRegisters) {
			TripRegisterDto aTripRegisterDto = new TripRegisterDto();
			BeanUtils.copyProperties(atripRegister, aTripRegisterDto);
			this.getTripRegisterDtos().add(aTripRegisterDto);
		}

	}

	public void oncontextMenuClick(SelectEvent event) {
		tripRegisterId = ((TripRegisterDto) event.getObject()).getId();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("tripRegisterId", tripRegisterId);
	}

	public void onRowUnselect(UnselectEvent event) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("tripRegisterId");
	}

	public void deleteTripDetails() {
		if (tripRegisterId != null)
			this.tripRegisterRepository.deleteById(tripRegisterId);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Trip has been Deleted Successfully"));
	}
}
