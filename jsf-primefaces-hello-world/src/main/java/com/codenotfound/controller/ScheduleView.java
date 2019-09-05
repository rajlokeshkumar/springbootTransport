package com.codenotfound.controller;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.codenotfound.entity.ScheduleModelDomain;
import com.codenotfound.repo.ScheduleRepo;

@Named
@Controller
@ViewScoped
public class ScheduleView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ScheduleModel eventModel;

	private ScheduleModel lazyEventModel;
	@Autowired
	private ScheduleRepo scheduleRepo;


	public ScheduleRepo getScheduleRepo() {
		return scheduleRepo;
	}

	public void setScheduleRepo(ScheduleRepo scheduleRepo) {
		this.scheduleRepo = scheduleRepo;
	}

	private ScheduleEvent event = new DefaultScheduleEvent();

	@PostConstruct
	public void init() {
		eventModel = new DefaultScheduleModel();
		for (ScheduleModelDomain aScheduleModelDomain : this.scheduleRepo.findAll()) {
			ScheduleEvent aevent = new DefaultScheduleEvent();
			eventModel.addEvent(aevent);
			BeanUtils.copyProperties(aScheduleModelDomain, aevent);
		}
	}

	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}

	public Date getRandomDate(Date base) {
		Calendar date = Calendar.getInstance();
		date.setTime(base);
		date.add(Calendar.DATE, ((int) (Math.random() * 30)) + 1); // set random
		return date.getTime();
	}

	public Date getInitialDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);

		return calendar.getTime();
	}

	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public ScheduleModel getLazyEventModel() {
		return lazyEventModel;
	}

/*	private Calendar today() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);

		return calendar;
	}
*/


	public ScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}

	public void addEvent() {
		if (event.getId() == null)
			eventModel.addEvent(event);
		else
			eventModel.updateEvent(event);
		ScheduleModelDomain aScheduleModelDomain = new ScheduleModelDomain();
		BeanUtils.copyProperties(event, aScheduleModelDomain);
		scheduleRepo.save(aScheduleModelDomain);
		event = new DefaultScheduleEvent();
	}

	public void deleteEvent() {
		if (event.getId() != null) {
			scheduleRepo.deleteById(event.getId());
			eventModel.deleteEvent(event);
			event = new DefaultScheduleEvent();
		}
	}
	public void onEventSelect(SelectEvent selectEvent) {
		event = (ScheduleEvent) selectEvent.getObject();
	}

	public void onDateSelect(SelectEvent selectEvent) {
		event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
	}

	public void onEventMove(ScheduleEntryMoveEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved",
				"Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

		addMessage(message);
	}

	public void onEventResize(ScheduleEntryResizeEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized",
				"Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

		addMessage(message);
	}

	private void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
	}}