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

import com.codenotfound.dto.BookingDto;
import com.codenotfound.entity.BookingInfo;
import com.codenotfound.repo.BookingInfoRepo;

@Named
@Controller
@ViewScoped
public class BookingInformatonController implements PhaseListener { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BookingInfo bookingInfo;
	@Autowired
	private BookingInfoRepo bookingInfoRepo;
	
	private List<BookingDto> bookingInfoDtos=new ArrayList<>();

	private BookingDto selectedBookingInfo;
	
	private boolean disableSubmitButton;
	
	private boolean disableUpdateButton;
	
	private boolean disableDeleteButton;
	
	
	
	public boolean isDisableSubmitButton() {
		return disableSubmitButton;
	}

	public void setDisableSubmitButton(boolean disableSubmitButton) {
		this.disableSubmitButton = disableSubmitButton;
	}

	public boolean isDisableUpdateButton() {
		return disableUpdateButton;
	}

	public void setDisableUpdateButton(boolean disableUpdateButton) {
		this.disableUpdateButton = disableUpdateButton;
	}

	public boolean isDisableDeleteButton() {
		return disableDeleteButton;
	}

	public void setDisableDeleteButton(boolean disableDeleteButton) {
		this.disableDeleteButton = disableDeleteButton;
	}

	public BookingDto getSelectedBookingInfo() {
		if(selectedBookingInfo==null) {
			selectedBookingInfo=new BookingDto();
		}
		return selectedBookingInfo;
	}

	public void setSelectedBookingInfo(BookingDto selectedBookingInfo) {
		this.selectedBookingInfo = selectedBookingInfo;
	}

	public BookingInfo getBookingInfo() {
		return bookingInfo;
	}

	public void setBookingInfo(BookingInfo bookingInfo) {
		this.bookingInfo = bookingInfo;
	}

	public BookingInfoRepo getBookingInfoRepo() {
		return bookingInfoRepo;
	}

	public void setBookingInfoRepo(BookingInfoRepo bookingInfoRepo) {
		this.bookingInfoRepo = bookingInfoRepo;
	}


	public List<BookingDto> getBookingInfoDtos() {
		return bookingInfoDtos;
	}

	public void setBookingInfoDtos(List<BookingDto> bookingInfoDtos) {
		this.bookingInfoDtos = bookingInfoDtos;
	}

	@PostConstruct
	public void init() {
		this.getAllRecord();
	}
	
	public void getAllRecord() {
		this.getBookingInfoDtos().clear();
		Iterable<BookingInfo> aBookingInfo=this.getBookingInfoRepo().findAll();
		for(BookingInfo a:aBookingInfo) {
			BookingDto aBookingInfoDto=new BookingDto();
			BeanUtils.copyProperties(a, aBookingInfoDto);
			this.getBookingInfoDtos().add(aBookingInfoDto);
		}
	}
	
	public void addRecord() {
		BookingInfo bookingInfo=new BookingInfo();
		BeanUtils.copyProperties(this.getSelectedBookingInfo(), bookingInfo);
		this.getBookingInfoRepo().save(bookingInfo);
		this.getAllRecord();
		this.selectedBookingInfo=new BookingDto();
	}

	
	public void onRowUnselect(UnselectEvent event) {
		this.selectedBookingInfo=new BookingDto();
		this.disableDeleteButton=false;
	}
	public void onRowselect(SelectEvent event) {
		this.disableDeleteButton=true;
	}
	public void deleteRecord( ){
		this.bookingInfoRepo.deleteById(this.selectedBookingInfo.getLorryNo());
		getAllRecord();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Booking Information Deleted"));
	}

	
	public void oncontextMenuClick(SelectEvent event) {
	}
	
	
	
	@Override
	public void afterPhase(PhaseEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PhaseId getPhaseId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
