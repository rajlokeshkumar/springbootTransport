package com.codenotfound.controller;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.ParseException;
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

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.codenotfound.dto.Advancedto;
import com.codenotfound.dto.AtmCreditDebitDto;
import com.codenotfound.dto.Constants;
import com.codenotfound.dto.ExpenseOnTripBilledDto;
import com.codenotfound.dto.ExpenseonRTOandTOLLDto;
import com.codenotfound.dto.FuelDto;
import com.codenotfound.dto.TripRegisterDto;
import com.codenotfound.entity.Advance;
import com.codenotfound.entity.AtmCreditDebit;
import com.codenotfound.entity.DriverInfo;
import com.codenotfound.entity.Fuel;
import com.codenotfound.entity.TripRegister;
import com.codenotfound.entity.Vehicle;
import com.codenotfound.repo.DriverInfoRepo;
import com.codenotfound.repo.TripRegisterRepository;
import com.codenotfound.repo.VehicleRepository;

@Named
@Controller
@ViewScoped
public class TripRegistrationController implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TripRegisterDto tripRegisterDto;

	private List<FuelDto> fuelDtoForTable;

	private List<ExpenseOnTripBilledDto> billedExpense;

	private List<ExpenseonRTOandTOLLDto> expenseonRTOandTOLL = new ArrayList<>(8);

	private List<Constants> typeOfExpense = new ArrayList<>();

	private List<String> paymentType = new ArrayList<>();

	private List<String> listOfStates = new ArrayList<>();

	private List<Advancedto> totalAdvance;

	private List<AtmCreditDebitDto> atmCreditDebitDto;

	private List<String> vehicleNo;

	private List<String> driverName;
	@Autowired
	private DriverInfoRepo driverInfoRepo;
	@Autowired
	private VehicleRepository vehicleRepository;
	@Autowired
	private TripRegisterRepository tripRegisterRepository;

	public DriverInfoRepo getDriverInfoRepo() {
		return driverInfoRepo;
	}

	public void setDriverInfoRepo(DriverInfoRepo driverInfoRepo) {
		this.driverInfoRepo = driverInfoRepo;
	}

	public List<String> getDriverName() {
		if (driverName == null) {
			driverName = new ArrayList<>();
		}
		return driverName;
	}

	public void setDriverName(List<String> driverName) {
		this.driverName = driverName;
	}

	public VehicleRepository getVehicleRepository() {
		return vehicleRepository;
	}

	public void setVehicleRepository(VehicleRepository vehicleRepository) {
		this.vehicleRepository = vehicleRepository;
	}

	public List<String> getVehicleNo() {
		if (vehicleNo == null) {
			vehicleNo = new ArrayList<>();
		}
		return vehicleNo;
	}

	public void setVehicleNo(List<String> vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public List<Advancedto> getTotalAdvance() {
		if (totalAdvance == null) {
			totalAdvance = new ArrayList<>(9);
		}
		return totalAdvance;
	}

	public void setTotalAdvance(List<Advancedto> totalAdvance) {
		this.totalAdvance = totalAdvance;
	}

	public List<String> getListOfStates() {
		return listOfStates;
	}

	public void setListOfStates(List<String> listOfStates) {
		this.listOfStates = listOfStates;
	}

	public List<String> getPaymentType() {

		return paymentType;
	}

	public void setPaymentType(List<String> paymentType) {
		this.paymentType = paymentType;
	}

	public List<Constants> getTypeOfExpense() {

		return typeOfExpense;
	}

	public void setTypeOfExpense(List<Constants> typeOfExpense) {
		this.typeOfExpense = typeOfExpense;
	}

	public List<ExpenseonRTOandTOLLDto> getExpenseonRTOandTOLL() {
		return expenseonRTOandTOLL;
	}

	public void setExpenseonRTOandTOLL(List<ExpenseonRTOandTOLLDto> expenseonRTOandTOLL) {
		this.expenseonRTOandTOLL = expenseonRTOandTOLL;
	}

	@PostConstruct
	public void init() {
		this.preFillDiesel();
		this.preFillBilledExpese();
		this.preFillRTOandTOLLExpense();
		this.preFillStates();
		this.preFilltotalAdvance();
		this.preFillAtmCreditAndDebit();
		this.getVehicleList();
		this.getDriverList();
		this.preFillAdvanceDto();
		if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("tripRegisterId") != null) {
			String tripRegisterId = FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
					.get("tripRegisterId").toString();
			TripRegister aTripRegister = this.tripRegisterRepository.findById(tripRegisterId).orElse(null);
			if (aTripRegister != null) {
				assemblerFromDomain(aTripRegister);
			}
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("tripRegisterId");
		}
	}

	private void assemblerFromDomain(TripRegister pTripRegister) {
		BeanUtils.copyProperties(pTripRegister, this.getTripRegisterDto());
		for (int i = 0; i <= 6; i++) {
			BeanUtils.copyProperties(pTripRegister.getFuel().get(i), this.fuelDtoForTable.get(i));
		}
		for (int i = 0; i <= 7; i++) {
			BeanUtils.copyProperties(pTripRegister.getAtmCreditDebits().get(i), this.getAtmCreditDebitDto().get(i));
		}
		for (int i = 0; i <= 7; i++) {
			BeanUtils.copyProperties(pTripRegister.getAdvances().get(i), this.getTotalAdvance().get(i));
		}

	}

	private void preFillAdvanceDto() {
		this.getTotalAdvance().get(0).setPurpose("Diesel");
		this.getTotalAdvance().get(1).setPurpose("ATM");
		this.getTotalAdvance().get(2).setPurpose("பணம் பெற்றது");
		this.getTotalAdvance().get(3).setPurpose("Fasttag");
	}

	public void getVehicleList() {
		Iterable<Vehicle> a = this.vehicleRepository.findAll();
		for (Vehicle b : a) {
			this.getVehicleNo().add(b.getRegistrationNumber());
		}
	}

	public void getDriverList() {
		Iterable<DriverInfo> a = this.driverInfoRepo.findAll();
		for (DriverInfo b : a) {
			this.getDriverName().add(b.getDriverName());
		}
	}

	public List<AtmCreditDebitDto> getAtmCreditDebitDto() {
		if (atmCreditDebitDto == null) {
			atmCreditDebitDto = new ArrayList<>();
		}
		return atmCreditDebitDto;
	}

	public void setAtmCreditDebitDto(List<AtmCreditDebitDto> atmCreditDebitDto) {
		this.atmCreditDebitDto = atmCreditDebitDto;
	}

	private void preFillAtmCreditAndDebit() {
		List<AtmCreditDebitDto> atmCreditDebitDtos = new ArrayList<>();
		for (int i = 0; i <= 7; i++) {
			AtmCreditDebitDto bAtmCreditDebitDto = new AtmCreditDebitDto();
			bAtmCreditDebitDto.setRowID("Atm Expense Row" + String.valueOf(i));
			atmCreditDebitDtos.add(bAtmCreditDebitDto);
		}
			this.atmCreditDebitDto = new ArrayList<>();

		atmCreditDebitDto.addAll(atmCreditDebitDtos);
	}

	private void preFilltotalAdvance() {
		List<Advancedto> aAdvancedtos = new ArrayList<>();
		for (int i = 0; i <= 8; i++) {
			Advancedto bAdvancedto = new Advancedto();
			bAdvancedto.setRowID("Diesel Expense Row" + String.valueOf(i));
			aAdvancedtos.add(bAdvancedto);
		}
			this.totalAdvance = new ArrayList<>();

		totalAdvance.addAll(aAdvancedtos);
	}

	private void preFillRTOandTOLLExpense() {
		List<ExpenseonRTOandTOLLDto> aExpenseonRTOandTOLL = new ArrayList<>(8);
		this.setExpenseonRTOandTOLL(new ArrayList<>());
		for (int i = 0; i < 8; i++) {
			ExpenseonRTOandTOLLDto bExpenseonRTOandTOLL = new ExpenseonRTOandTOLLDto();
			bExpenseonRTOandTOLL.setRowID(String.valueOf(i));
			aExpenseonRTOandTOLL.add(bExpenseonRTOandTOLL);
		}
		this.getExpenseonRTOandTOLL().addAll(aExpenseonRTOandTOLL);
		typeOfExpense.add(Constants.RTO);
		typeOfExpense.add(Constants.TOLL);
	}

	public List<ExpenseOnTripBilledDto> getBilledExpense() {
		return billedExpense;
	}

	public void setBilledExpense(List<ExpenseOnTripBilledDto> billedExpense) {
		this.billedExpense = billedExpense;
	}

	public List<FuelDto> getFuelDtoForTable() {
		if (this.fuelDtoForTable == null) {
			this.fuelDtoForTable = new ArrayList<>();

		}
		return fuelDtoForTable;
	}

	private void preFillBilledExpese() {
		List<ExpenseOnTripBilledDto> abilledExpense = new ArrayList<>(5);

		for (int i = 0; i <= 4; i++) {
			ExpenseOnTripBilledDto bExpenseOnTripBilled = new ExpenseOnTripBilledDto();
			bExpenseOnTripBilled.setRowID("Billed Expense Report" + i);
			abilledExpense.add(bExpenseOnTripBilled);
		}
			this.billedExpense = new ArrayList<>();
		this.billedExpense.addAll(abilledExpense);
	}

	private void preFillDiesel() {
		List<FuelDto> aFuelDto = new ArrayList<>();
		for (int i = 0; i <= 6; i++) {
			FuelDto bFuelDto = new FuelDto();
			bFuelDto.setRowID("Diesel Expense Row" + String.valueOf(i));
			aFuelDto.add(bFuelDto);
		}
			this.fuelDtoForTable = new ArrayList<>();
		paymentType.add("CREDIT");
		paymentType.add("CASH");

		fuelDtoForTable.addAll(aFuelDto);
	}

	private void preFillStates() {
		listOfStates.add("Andhra Pradesh");
		listOfStates.add("Arunachal Pradesh");
		listOfStates.add("Assam");
		listOfStates.add("Bihar");
		listOfStates.add("Chhattisgarh");
		listOfStates.add("Goa");
		listOfStates.add("Gujarat ");
		listOfStates.add("Haryana ");
		listOfStates.add("Himachal Pradesh ");
		listOfStates.add("Jammu & Kashmir");
		listOfStates.add("Jharkhand ");
		listOfStates.add("Karnataka ");
		listOfStates.add("Kerala");
		listOfStates.add("Madhya Pradesh ");
		listOfStates.add("Maharashtra ");
		listOfStates.add("Manipur ");
		listOfStates.add("Meghalaya ");
		listOfStates.add("Mizoram ");
		listOfStates.add("Nagaland");
		listOfStates.add("Orissa ");
		listOfStates.add("Punjab ");
		listOfStates.add("Rajasthan ");
		listOfStates.add("Sikkim ");
		listOfStates.add("Tamil Nadu ");
		listOfStates.add("Telangana ");
		listOfStates.add("Tripura ");
		listOfStates.add("Uttar Pradesh ");
		listOfStates.add("Uttarakhand ");
		listOfStates.add("West Bengal ");

	}

	public void setFuelDtoForTable(List<FuelDto> fuelDtoForTable) {
		this.fuelDtoForTable = fuelDtoForTable;
	}

	public TripRegisterDto getTripRegisterDto() {
		if (this.tripRegisterDto == null) {
			this.tripRegisterDto = new TripRegisterDto();
		}
		return tripRegisterDto;
	}

	public void setTripRegisterDto(TripRegisterDto tripRegisterDto) {
		this.tripRegisterDto = tripRegisterDto;
	}

	public void onRowEdit(RowEditEvent event) throws ParseException {
		FacesMessage msg = null;
		if (event.getObject() instanceof FuelDto) {
			processDoneOnFuelTable((FuelDto) event.getObject());
			msg = new FacesMessage("Fuel Edited", ((FuelDto) event.getObject()).getRowID());
		} else if (event.getObject() instanceof ExpenseOnTripBilledDto) {
			this.processDoneOnBilledExpenseTable((ExpenseOnTripBilledDto) event.getObject());
			msg = new FacesMessage("Expense Edited", ((ExpenseOnTripBilledDto) event.getObject()).getRowID());
		} else if (event.getObject() instanceof ExpenseonRTOandTOLLDto) {
			this.processDoneOnExpenseonRTOandToll((ExpenseonRTOandTOLLDto) event.getObject());
			int listmaxSize = Integer.valueOf(((ExpenseonRTOandTOLLDto) event.getObject()).getRowID());
			if (this.getExpenseonRTOandTOLL().size() == listmaxSize + 1) {
				this.setExpenseonRTOandTOLL(FillBilledExpese(this.getExpenseonRTOandTOLL()));
			}
			msg = new FacesMessage("Expense Edited", ((ExpenseonRTOandTOLLDto) event.getObject()).getRowID());
		} else if (event.getObject() instanceof Advancedto) {
			processAdvanceDto();
			msg = new FacesMessage("Advance Edited", ((Advancedto) event.getObject()).getRowID());
		} else if (event.getObject() instanceof AtmCreditDebitDto) {
			processCreditAndDebit((AtmCreditDebitDto) event.getObject());

			msg = new FacesMessage("AtmCreditDebit Edited", ((AtmCreditDebitDto) event.getObject()).getRowID());
		}
		this.getTripRegisterDto().setTotalExpenseForTrip(new BigDecimal(0));
		this.getTripRegisterDto().setTotalIncome(new BigDecimal(0));
		this.getTripRegisterDto().setTotalprofitOnTrip(0);
		calculateWages();
		calculateTotalhireprice();
		calculateTotalExpense();
		calculateTotalProfit();
		calculateDriverToGive();
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	private void processAdvanceDto() {
		if (this.getTripRegisterDto().getVehicleAdvance() == null) {
			this.getTripRegisterDto().setVehicleAdvance(new BigDecimal(0));
		}
		BigDecimal totalAdvace = new BigDecimal(0);
		for (Advancedto aAdvancedto : this.getTotalAdvance()) {
			if (aAdvancedto.getAmount() != null)
				totalAdvace = totalAdvace.add(aAdvancedto.getAmount());
		}
		this.getTripRegisterDto().setVehicleAdvance(totalAdvace);
	}

	private void processCreditAndDebit(AtmCreditDebitDto pAtmCreditDebitDto) {
		BigDecimal atotalAtmDebit = new BigDecimal(0);
		BigDecimal aTotalAtmFasttagAmount = new BigDecimal(0);
		for (AtmCreditDebitDto bAtmCreditDebitDto : this.getAtmCreditDebitDto()) {

			if (bAtmCreditDebitDto.getAmount() != null) {
				if (bAtmCreditDebitDto.getPaymentMode() != null
						&& bAtmCreditDebitDto.getPaymentMode().equals("ATM கொடுதது")) {
					atotalAtmDebit = atotalAtmDebit.add(bAtmCreditDebitDto.getAmount());
				}
				if (bAtmCreditDebitDto.getPaymentMode() != null
						&& bAtmCreditDebitDto.getPaymentMode().equals("Fasttag")) {
					aTotalAtmFasttagAmount = aTotalAtmFasttagAmount.add(bAtmCreditDebitDto.getAmount());
				}
			}
		}
		this.getTotalAdvance().get(3).setAmount(aTotalAtmFasttagAmount);
		if (this.getTripRegisterDto().getBilledtollExpense() != null) {
			aTotalAtmFasttagAmount = aTotalAtmFasttagAmount.add(this.getTripRegisterDto().getBilledtollExpense());
		}

		this.getTripRegisterDto().setTotalTollExpense(aTotalAtmFasttagAmount);
		this.getTotalAdvance().get(1).setAmount(atotalAtmDebit);
		this.processAdvanceDto();
	}

	private List<ExpenseonRTOandTOLLDto> FillBilledExpese(List<ExpenseonRTOandTOLLDto> pExpenseonRTOandTOLL) {
		List<ExpenseonRTOandTOLLDto> cExpenseonRTOandTOLL = new ArrayList<>(5);
		int size = pExpenseonRTOandTOLL.size();
		for (int i = size; i <= size + 4; i++) {
			ExpenseonRTOandTOLLDto bExpenseonRTOandTOLL = new ExpenseonRTOandTOLLDto();
			bExpenseonRTOandTOLL.setRowID(String.valueOf(i));
			cExpenseonRTOandTOLL.add(bExpenseonRTOandTOLL);
		}
		pExpenseonRTOandTOLL.addAll(cExpenseonRTOandTOLL);
		return pExpenseonRTOandTOLL;
	}

	private void processDoneOnExpenseonRTOandToll(ExpenseonRTOandTOLLDto pExpenseonRTOandTOLL) {
		BigDecimal totalTollAmount = new BigDecimal(0);
		BigDecimal totalRTOExpense = new BigDecimal(0);
		for (ExpenseonRTOandTOLLDto aExpenseonRTOandTOLL : this.getExpenseonRTOandTOLL()) {
			if (Constants.RTO.equals(aExpenseonRTOandTOLL.getExpenseType())
					&& aExpenseonRTOandTOLL.getAmountOfExpense() != null) {
				totalRTOExpense = totalRTOExpense.add(aExpenseonRTOandTOLL.getAmountOfExpense());
			} else if (Constants.TOLL.equals(aExpenseonRTOandTOLL.getExpenseType())
					&& aExpenseonRTOandTOLL.getAmountOfExpense() != null) {
				totalTollAmount = totalTollAmount.add(aExpenseonRTOandTOLL.getAmountOfExpense());
			}

		}
		this.getTripRegisterDto().setTotalexpenseonRTOandTOLL(totalRTOExpense);
		this.getTripRegisterDto().setTotalTollExpense(totalTollAmount);
	}

	private void processDoneOnBilledExpenseTable(ExpenseOnTripBilledDto pExpenseOnTripBilled) {
		BigDecimal totalAmountBilled = new BigDecimal(0);
		for (ExpenseOnTripBilledDto aExpenseOnTripBilled : this.getBilledExpense()) {
			if (aExpenseOnTripBilled.getAmountpaid() != null) {
				totalAmountBilled = totalAmountBilled.add(aExpenseOnTripBilled.getAmountpaid());
			}
		}
		this.getTripRegisterDto().setTotalBilledExpense(totalAmountBilled);
	}

	private void processDoneOnFuelTable(FuelDto pFuelDto) throws ParseException {
		if (pFuelDto.getNumberofLitre() != null && pFuelDto.getPricePerlitre() != null) {
			BigDecimal totalamount = pFuelDto.getNumberofLitre().multiply(pFuelDto.getPricePerlitre());
			totalamount = totalamount.setScale(0, BigDecimal.ROUND_HALF_UP);

			pFuelDto.setTotalAmount(totalamount);
		} else if (pFuelDto.getNumberofLitre() != null && pFuelDto.getTotalAmount() != null) {
			BigDecimal pricePerLitre = pFuelDto.getTotalAmount().divide(pFuelDto.getNumberofLitre(), 2,
					RoundingMode.HALF_UP);
			pFuelDto.setPricePerlitre(pricePerLitre);
		}

		if (this.getTripRegisterDto().getTotalDieselAmount() == null) {
			this.getTripRegisterDto().setTotalDieselAmount(new BigDecimal(0));
		}
		BigDecimal totalFuelAmount = new BigDecimal(0);
		BigDecimal totalCreditFuel = new BigDecimal(0);
		for (FuelDto aFuelDto : this.getFuelDtoForTable()) {
			if (aFuelDto.getTotalAmount() != null) {
				totalFuelAmount = totalFuelAmount.add(aFuelDto.getTotalAmount());
				if (aFuelDto.getPaymentMode() != null && aFuelDto.getPaymentMode().equals("SUNDARAM FINANCE")) {
					totalCreditFuel = totalCreditFuel.add(aFuelDto.getTotalAmount());

				}
			}
		}
		this.getTotalAdvance().get(0).setAmount(totalCreditFuel);
		this.processAdvanceDto();
		this.getTripRegisterDto().setTotalDieselAmount(totalFuelAmount);
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = null;
		if (event.getObject() instanceof FuelDto) {
			String rowID = ((FuelDto) event.getObject()).getRowID();
			msg = new FacesMessage("Fuel Edited", rowID);
		} else if (event.getObject() instanceof ExpenseOnTripBilledDto) {
			if (this.getBilledExpense().remove((ExpenseOnTripBilledDto) event.getObject())) {
				this.getBilledExpense().add(new ExpenseOnTripBilledDto());
			}
			msg = new FacesMessage("Expense Edited", ((ExpenseOnTripBilledDto) event.getObject()).getRowID());
		} else if (event.getObject() instanceof ExpenseonRTOandTOLLDto) {
			if (this.getExpenseonRTOandTOLL().remove((ExpenseonRTOandTOLLDto) event.getObject())) {
				this.getExpenseonRTOandTOLL().add(new ExpenseonRTOandTOLLDto());
			}
			msg = new FacesMessage("Expense Edited", ((ExpenseonRTOandTOLLDto) event.getObject()).getRowID());
		} else if (event.getObject() instanceof AtmCreditDebitDto) {

			msg = new FacesMessage("ATM Expense Edited", ((AtmCreditDebitDto) event.getObject()).getRowID());
		} else if (event.getObject() instanceof Advancedto) {

			msg = new FacesMessage("Advance Expense Edited", ((Advancedto) event.getObject()).getRowID());
		}

		this.getTripRegisterDto().setTotalExpenseForTrip(new BigDecimal(0));
		this.getTripRegisterDto().setTotalIncome(new BigDecimal(0));
		this.getTripRegisterDto().setTotalprofitOnTrip(0);
		calculateWages();
		calculateTotalhireprice();
		calculateTotalExpense();
		calculateTotalProfit();
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();

		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed",
					"Old: " + oldValue + ", New:" + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void processButton() {
		TripRegister tripRegister = new TripRegister();
		BeanUtils.copyProperties(this.getTripRegisterDto(), tripRegister);
		List<Fuel> fuel = new ArrayList<>();
		for (FuelDto afuelDto : this.getFuelDtoForTable()) {
			Fuel bFuel = new Fuel();
			BeanUtils.copyProperties(afuelDto, bFuel);
			fuel.add(bFuel);
		}
		tripRegister.setFuel(fuel);
		List<Advance> advances = new ArrayList<>();
		for (Advancedto aAdvanceDto : this.getTotalAdvance()) {
			Advance bAdvance = new Advance();
			BeanUtils.copyProperties(aAdvanceDto, bAdvance);
			advances.add(bAdvance);
		}
		tripRegister.setAdvances(advances);
		List<AtmCreditDebit> atmCreditDebits = new ArrayList<>();
		for (AtmCreditDebitDto aAtmCreditDebitDto : this.getAtmCreditDebitDto()) {
			AtmCreditDebit bAtmCreditDebit = new AtmCreditDebit();
			BeanUtils.copyProperties(aAtmCreditDebitDto, bAtmCreditDebit);
			atmCreditDebits.add(bAtmCreditDebit);
		}
		tripRegister.setAtmCreditDebits(atmCreditDebits);
		this.tripRegisterRepository.save(tripRegister);
		this.setTripRegisterDto(null);
		this.preFillDiesel();
		this.preFillBilledExpese();
		this.preFillRTOandTOLLExpense();
		this.preFillStates();
		this.preFilltotalAdvance();
		this.preFillAtmCreditAndDebit();
		this.getVehicleList();
		this.getDriverList();
		this.preFillAdvanceDto();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Trip has been Registered Successfully"));
	}

	public void calculateBaseOnInputdata() {
		this.getTripRegisterDto().setTotalExpenseForTrip(new BigDecimal(0));
		this.getTripRegisterDto().setTotalIncome(new BigDecimal(0));
		this.getTripRegisterDto().setTotalprofitOnTrip(0);
		calculateWages();
		calculateTotalhireprice();
		calculateTotalTollExepnse();
		calculateTotalExpense();
		calculateTotalProfit();
		calculateDriverToGive();
		calculateMileageofTrip();
	}

	public void calculateMileageofTrip() {

		if (this.getTripRegisterDto().getStartKm() != null && this.getTripRegisterDto().getEndKm() != null) {
			this.getTripRegisterDto().setTotalTripKm(
					(this.getTripRegisterDto().getEndKm().subtract(this.getTripRegisterDto().getStartKm())).intValue());
			int totalNoLit = 0;
			for (FuelDto aFuelDto : this.getFuelDtoForTable()) {
				if (aFuelDto.getNumberofLitre() != null) {
					totalNoLit = totalNoLit + aFuelDto.getNumberofLitre().intValue();
				}
			}
			String statusString = null;
			if("ONGOING1".equals(this.getTripRegisterDto().getStatusOfTrip())){
				statusString="ONGOING2";
			}
			if("ONGOING2".equals(this.getTripRegisterDto().getStatusOfTrip())){
				statusString="ONGOING1";
			}
			if (this.getTripRegisterDto().getVechileNumber() != null && statusString != null) {
				TripRegister aTripRegister = this.tripRegisterRepository
						.findByVechileNumberAndStatusOfTrip(this.getTripRegisterDto().getVechileNumber(), statusString)
						.get(0);
				int totalNoLit1 = totalNoLit;
				for (Fuel aFuel : aTripRegister.getFuel()) {
					if (aFuel.getNumberofLitre() != null) {
						totalNoLit1 = totalNoLit1 + aFuel.getNumberofLitre().intValue();
					}
				}
				if (totalNoLit1 != 0) {
					this.getTripRegisterDto().setMileageofTrip((
							BigDecimal.valueOf((float) this.getTripRegisterDto().getTotalTripKm() / totalNoLit)).setScale(2,BigDecimal.ROUND_HALF_DOWN));
				}
			}
		}
	}
	
	public void calculateDriverToGive() {
		if (this.getTripRegisterDto().getDrivertoGive() == null) {
			this.getTripRegisterDto().setDrivertoGive(new BigDecimal(0));
		}
		if (this.getTripRegisterDto().getAmountPaidonOffload() == null) {
			this.getTripRegisterDto().setAmountPaidonOffload(new BigDecimal(0));
		}
		if (this.getTripRegisterDto().getHireprice() == null) {
			this.getTripRegisterDto().setHireprice(new Integer(0));
		}
		if (this.getTripRegisterDto().getVehicleAdvance() == null) {
			this.getTripRegisterDto().setVehicleAdvance(new BigDecimal(0));
		}
		if (this.getTripRegisterDto().getTotalExpenseForTrip() == null) {
			this.getTripRegisterDto().setTotalExpenseForTrip(new BigDecimal(0));
		}
		if (this.getTripRegisterDto().getAmountpaidonLoad() == null) {
			this.getTripRegisterDto().setAmountpaidonLoad(new BigDecimal(0));
		}
		BigDecimal totalVehiclePricetoAtm = new BigDecimal(0);
		for (AtmCreditDebitDto aAtmCreditDebitDto : this.getAtmCreditDebitDto()) {
			if (aAtmCreditDebitDto.getPaymentMode() != null
					&& (aAtmCreditDebitDto.getPaymentMode().equals("வடகை பெற்றது")
							|| aAtmCreditDebitDto.getPaymentMode().equals("காசோலை"))) {
				totalVehiclePricetoAtm = totalVehiclePricetoAtm.add(aAtmCreditDebitDto.getAmount());
			}

		}
		Integer totlaAmountDrivertoGive = ((this.getTripRegisterDto().getHireprice()
				+ this.getTripRegisterDto().getVehicleAdvance().intValue()
				+ this.getTripRegisterDto().getAmountpaidonLoad().intValue())
				- (this.getTripRegisterDto().getTotalExpenseForTrip()
						.add(this.getTripRegisterDto().getAmountPaidonOffload()).add(totalVehiclePricetoAtm)
						.intValue()));

		this.getTripRegisterDto().setDrivertoGive(new BigDecimal(totlaAmountDrivertoGive));
	}

	public void calculateWages() {
		if (this.getTripRegisterDto().getHireprice() != null && this.getTripRegisterDto().getHireprice() != 0) {
			BigDecimal driverWage = new BigDecimal(0);
			BigDecimal cleanerWage = new BigDecimal(0);
			BigDecimal commissionOnLoad = new BigDecimal(0);
			driverWage = BigDecimal.valueOf(this.getTripRegisterDto().getHireprice()).multiply(new BigDecimal(0.09),
					MathContext.DECIMAL32).setScale(2);
			cleanerWage = BigDecimal.valueOf(this.getTripRegisterDto().getHireprice()).multiply(new BigDecimal(0.025),
					MathContext.DECIMAL32).setScale(2);
			commissionOnLoad = BigDecimal.valueOf(this.getTripRegisterDto().getHireprice())
					.multiply(new BigDecimal(0.05), MathContext.DECIMAL32).setScale(2);

			this.getTripRegisterDto().setCleanerWage(cleanerWage);
			this.getTripRegisterDto().setTotalDriverWageForTrip(driverWage);
			this.getTripRegisterDto().setCommissionAsBilled(commissionOnLoad);
			if (this.getTripRegisterDto().getTotalIncome() == null) {
				this.getTripRegisterDto().setTotalIncome(new BigDecimal(0));
			}
			this.getTripRegisterDto().setTotalIncome(this.getTripRegisterDto().getTotalIncome()
					.add(BigDecimal.valueOf(this.getTripRegisterDto().getHireprice())));
		}
	}

	public void calculateTotalhireprice() {
		if (this.getTripRegisterDto().getTotalIncome() == null) {
			this.getTripRegisterDto().setTotalIncome(new BigDecimal(0));
		}
		this.getTripRegisterDto().setTotalIncome(this.getTripRegisterDto().getTotalIncome());

	}

	public void calculateTotalExpense() {
		BigDecimal totalExpense = new BigDecimal(0);
		if (this.getTripRegisterDto().getTotalBilledExpense() != null) {
			totalExpense = totalExpense.add(this.getTripRegisterDto().getTotalBilledExpense());
		}
		if (this.getTripRegisterDto().getExpenseForLoading() != null) {
			totalExpense = totalExpense.add(this.getTripRegisterDto().getExpenseForLoading());
		}
		if (this.getTripRegisterDto().getExpenseForunloading() != null) {
			totalExpense = totalExpense.add(this.getTripRegisterDto().getExpenseForunloading());
		}
		if (this.getTripRegisterDto().getTotalexpenseonRTOandTOLL() != null) {
			totalExpense = totalExpense.add(this.getTripRegisterDto().getTotalexpenseonRTOandTOLL());
		}
		if (this.getTripRegisterDto().getTotalTollExpense() != null) {
			totalExpense = totalExpense.add(this.getTripRegisterDto().getTotalTollExpense());
		}
		if (this.getTripRegisterDto().getTotalDieselAmount() != null) {
			totalExpense = totalExpense.add(this.getTripRegisterDto().getTotalDieselAmount());
		}
		if (this.getTripRegisterDto().getCommissionAsBilled() != null) {
			totalExpense = totalExpense.add(this.getTripRegisterDto().getCommissionAsBilled());
		}
		if (this.getTripRegisterDto().getTotalDriverWageForTrip() != null) {
			totalExpense = totalExpense.add(this.getTripRegisterDto().getTotalDriverWageForTrip());
		}
		if (this.getTripRegisterDto().getCleanerWage() != null) {
			totalExpense = totalExpense.add(this.getTripRegisterDto().getCleanerWage());
		}
		if (this.getTripRegisterDto().getOtherExpense() != null) {
			totalExpense = totalExpense.add(this.getTripRegisterDto().getOtherExpense());
		}
		this.getTripRegisterDto().setTotalExpenseForTrip(totalExpense);

	}

	public void calculateTotalProfit() {
		int totalProfitOnTrip = 0;
		if (this.getTripRegisterDto().getTotalExpenseForTrip() != null
				&& this.getTripRegisterDto().getTotalIncome() != null) {
			totalProfitOnTrip = this.getTripRegisterDto().getTotalIncome()
					.subtract(this.getTripRegisterDto().getTotalExpenseForTrip()).intValue();
			this.getTripRegisterDto().setTotalprofitOnTrip(totalProfitOnTrip);
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

	public void calculateTotalTollExepnse() {
		if (this.getTripRegisterDto().getTotalTollExpense() == null) {
			this.getTripRegisterDto().setTotalTollExpense(new BigDecimal(0));
		}
		BigDecimal aTotalAtmFasttagAmount = new BigDecimal(0);
		for (AtmCreditDebitDto bAtmCreditDebitDto : this.getAtmCreditDebitDto()) {

			if (bAtmCreditDebitDto.getAmount() != null) {
				if (bAtmCreditDebitDto.getPaymentMode() != null
						&& bAtmCreditDebitDto.getPaymentMode().equals("Fasttag")) {
					aTotalAtmFasttagAmount = aTotalAtmFasttagAmount.add(bAtmCreditDebitDto.getAmount());
				}

			}
		}

		if (this.getTripRegisterDto().getBilledtollExpense() != null) {
			this.getTripRegisterDto()
					.setTotalTollExpense(aTotalAtmFasttagAmount.add(this.getTripRegisterDto().getBilledtollExpense()));
		} else {
			this.getTripRegisterDto().setTotalTollExpense(aTotalAtmFasttagAmount);
		}
	}

}
