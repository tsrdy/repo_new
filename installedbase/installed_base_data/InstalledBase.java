package main.java.installed_base_data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "InstalledBase")
@Entity
@Table(name = "InstalledBase")
public class InstalledBase {
	@Id
	@Column(name="id")
	protected int id;
	@XmlElement(required = true)
	@Column(name = "Distributor_Date")
	protected Date distributor_Date;

	@XmlElement(required = true)
	@Column(name = "Distributor")
	protected String distributor;

	@XmlElement(required = true)
	@Column(name = "TBL_IB_Serial_or_Order")
	protected long tBL_IB_Serial_or_Order;

	@XmlElement(required = true)
	@Column(name = "Family")
	protected String family;

	@XmlElement(required = true)
	@Column(name = "Model")
	protected String model;

	@XmlElement(required = true)
	@Column(name = "Cylinders")
	protected String cylinders;

	@XmlElement(required = true)
	@Column(name = "Lean_or_Rich_Burn")
	protected String lean_or_Rich_Burn;

	@XmlElement(required = true)
	@Column(name = "Power_BHP")
	protected long power_BHP;

	@XmlElement(required = true)
	@Column(name = "Branch")
	protected String branch;
	
	@XmlElement(required = true)
	@Column(name = "Branch_Address")
	protected String branch_Address;
	
	@XmlElement(required = true)
	@Column(name = "Branch_City")
	protected String branch_City;
	
	@XmlElement(required = true)
	@Column(name = "Branch_State")
	protected String branch_State;
	
	@XmlElement(required = true)
	@Column(name = "Branch_Country")
	protected String branch_Country;
	
	@XmlElement(required = true)
	@Column(name = "Owner")
	protected String owner;
	
	@XmlElement(required = true)
	@Column(name = "Owner_Address")
	protected String owner_Address;
	
	@XmlElement(required = true)
	@Column(name = "Owner_City")
	protected String owner_City;
	
	@XmlElement(required = true)
	@Column(name = "Owner_State")
	protected String owner_State;
	
	@XmlElement(required = true)
	@Column(name = "Owner_Country")
	protected String owner_Country;
	
	@XmlElement(required = true)
	@Column(name = "Owner_Post_Code")
	protected String owner_Post_Code;
	
	@XmlElement(required = true)
	@Column(name = "Site_Name")
	protected String site_Name;
	
	@XmlElement(required = true)
	@Column(name = "Site_Address")
	protected String site_Address;
	
	@XmlElement(required = true)
	@Column(name = "Site_City")
	protected String site_City;
	
	@XmlElement(required = true)
	@Column(name = "Site_State")
	protected String site_State;
	
	@XmlElement(required = true)
	@Column(name = "Site_Country")
	protected String site_Country;
	
	@XmlElement(required = true)
	@Column(name = "Site_Post_Code")
	protected String site_Post_Code;
	
	@XmlElement(required = true)
	@Column(name = "Site_Longitude")
	protected String site_Longitude;
	
	@XmlElement(required = true)
	@Column(name = "Site_Latitude")
	protected String site_Latitude;
	
	@XmlElement(required = true)
	@Column(name = "Region")
	protected String region;
	
	@XmlElement(required = true)
	@Column(name = "Engine_Market")
	protected String engine_Market;
	
	@XmlElement(required = true)
	@Column(name = "Driven_Equipment")
	protected String driven_Equipment;
	
	@XmlElement(required = true)
	@Column(name = "Driven_Equipment_Model")
	protected String driven_Equipment_Model;
	
	@XmlElement(required = true)
	@Column(name = "Engine_Application")
	protected String engine_Application;
	
	@XmlElement(required = true)
	@Column(name = "Fuel_Type")
	protected String fuel_Type;
	
	@XmlElement(required = true)
	@Column(name = "LC_Model")
	protected String lC_Model;
	
	@XmlElement(required = true)
	@Column(name = "Notes")
	protected String notes;
	
	@XmlElement(required = true)
	@Column(name = "Customer_Tag")
	protected String customer_Tag;
	
	@XmlElement(required = true)
	@Column(name = "Status")
	protected String status;
	
	@XmlElement(required = true)
	@Column(name = "Duty")
	protected String duty;
	
	@XmlElement(required = true)
	@Column(name = "EQUIPMENT_STATUS")
	protected String eQUIPMENT_STATUS;
	
	@XmlElement(required = true)
	@Column(name = "RPM")
	protected String rPM;
	
	@XmlElement(required = true)
	@Column(name = "LOAD")
	protected String load;
	@XmlElement(required = true)
	@Column(name = "Hours_per_Year")
	protected String hours_per_Year;
	
	@XmlElement(required = true)
	@Column(name = "Engine_Location_Area")
	protected String engine_Location_Area;
	
	@XmlElement(required = true)
	@Column(name = "Contact_name")
	protected String contact_name;
	
	@XmlElement(required = true)
	@Column(name = "Contact_Email")
	protected String contact_Email;
	
	@XmlElement(required = true)
	@Column(name = "Phone_Number")
	protected String phone_Number;
	
	@XmlElement(required = true)
	@Column(name = "Distributor_Maintenance_Agreement")
	protected String distributor_Maintenance_Agreement;
	
	@XmlElement(required = true)
	@Column(name = "Engine_Hrs_of_Last_Top_Overhaul")
	protected String engine_Hrs_of_Last_Top_Overhaul;
	
	@XmlElement(required = true)
	@Column(name = "Date_Performed")
	protected String date_Performed;
	
	@XmlElement(required = true)
	@Column(name = "Engine_Hrs_of_Last_Bottom_Overhaul")
	protected String engine_Hrs_of_Last_Bottom_Overhaul;
	
	@XmlElement(required = true)
	@Column(name = "Date_Performed_Last")
	protected String date_Performed_Last;
	
	@XmlElement(required = true)
	@Column(name = "Current_Engine_Hours")
	protected String current_Engine_Hours;
	
	@XmlElement(required = true)
	@Column(name = "Date_Verified")
	protected String date_Verified;
	
	@XmlElement(required = true)
	@Column(name = "Engine_Modified_Yes_No")
	protected String engine_Modified_Yes_No;
	
	@XmlElement(required = true)
	@Column(name = "If_Yes_please_explain_modification")
	protected String if_Yes_please_explain_modification;
	
	@XmlElement(required = true)
	@Column(name = "Other_Distributor_Info")
	protected String other_Distributor_Info;
	
	@XmlElement(required = true)
	@Column(name = "Startup_Year")
	protected String startup_Year;
	
	@XmlElement(required = true)
	@Column(name = "Special_Notes")
	protected String special_Notes;
	
	@XmlElement(required = true)
	@Column(name = "INSTALLED_AT")
	protected String installed_at;
	
	@XmlElement(required = true)
	@Column(name = "MACHINE_DESCRIPTION")
	protected String mACHINE_DESCRIPTION;
	
	@XmlElement(required = true)
	@Column(name = "MANUFACTURER")
	protected String mANUFACTURER;
	
	@XmlElement(required = true)
	@Column(name = "OPERATING_PERCENTAJE")
	protected String oPERATING_PERCENTAJE;
	
	@XmlElement(required = true)
	@Column(name = "COMMENTS_if_any_OWNER")
	protected String cOMMENTS_if_any_OWNER;
	
	@XmlElement(required = true)
	@Column(name = "SpecNo")
	protected String specNo;
	
	@XmlElement(required = true)
	@Column(name = "Service_File_No")
	protected String service_File_No;
	
	@XmlElement(required = true)
	@Column(name = "CP")
	protected String cP;
	
	@XmlElement(required = true)
	@Column(name = "Cool_Sys")
	protected String cool_SysecNo;
	
	@XmlElement(required = true)
	@Column(name = "Date_of_Op_Hrs")
	protected String date_of_Op_Hrs;
	
	@XmlElement(required = true)
	@Column(name = "Engine_Quantity")
	protected String engine_Quantity;
	
	@XmlElement(required = true)
	@Column(name = "Sector")
	protected String sector;
	
	@XmlElement(required = true)
	@Column(name = "Air_Fuel_Ratio")
	protected String air_Fuel_Ratio;
	
	@XmlElement(required = true)
	@Column(name = "Catalyst")
	protected String catalyst;
	
	@XmlElement(required = true)
	@Column(name = "Compressor")
	protected String compressor;
	
	@XmlElement(required = true)
	@Column(name = "Engine_Facility_Name")
	protected String engine_Facility_Name;
	
	@XmlElement(required = true)
	@Column(name = "Generator_Set")
	protected String generator_Set;
	
	@XmlElement(required = true)
	@Column(name = "HP")
	protected String hP;
	
	@XmlElement(required = true)
	@Column(name = "Ignition_Type")
	protected String ignition_Type;
	
	@XmlElement(required = true)
	@Column(name = "Last_Maintenance_Date")
	protected String last_Maintenance_Date;
	
	@XmlElement(required = true)
	@Column(name = "Overhaul_Date")
	protected String overhaul_Date;
	
	@XmlElement(required = true)
	@Column(name = "Packager")
	protected String packager;
	
	@XmlElement(required = true)
	@Column(name = "Permit_Number")
	protected String permit_Number;
	
	@XmlElement(required = true)
	@Column(name = "Permit_Year")
	protected String permit_Year;
	
	@XmlElement(required = true)
	@Column(name = "Turbocharger_Model")
	protected String turbocharger_Model;
	
	@XmlElement(required = true)
	@Column(name = "Driven_Equipment1")
	protected String driven_Equipment1;
	
	@XmlElement(required = true)
	@Column(name = "Fuel_Type1")
	protected String fuel_Type1;
	
	@XmlElement(required = true)
	@Column(name = "Line")
	protected String line ;
	
	@XmlElement(required = true)
	@Column(name = "JFE_Site_No")
	protected String jFE_Site_No;
	
	@XmlElement(required = true)
	@Column(name = "Area")
	protected String area;
	
	@XmlElement(required = true)
	@Column(name = "TBL_IB_Region1")
	protected String tBL_IB_Region1;
	
	@XmlElement(required = true)
	@Column(name = "Startup")
	protected String startup;
	
	@XmlElement(required = true)
	@Column(name = "Ship_Date")
	protected String ship_Date;
	
	@XmlElement(required = true)
	@Column(name = "Year")
	protected String year;
	
	@XmlElement(required = true)
	@Column(name = "GGO_Region")
	protected String gGO_Region;
	
	@XmlElement(required = true)
	@Column(name = "OraclePartyNumber")
	protected String oraclePartyNumber;
	
	@XmlElement(required = true)
	@Column(name = "Field0")
	protected String field0;
	
	@XmlElement(required = true)
	@Column(name = "Expr1")
	protected String expr1;
	
	@XmlElement(required = true)
	@Column(name = "Expr2")
	protected String expr2;
	
	@XmlElement(required = true)
	@Column(name = "Expr3")
	protected String expr3;
	
	@XmlElement(required = true)
	@Column(name = "Expr4")
	protected String expr4;
	
	@XmlElement(required = true)
	@Column(name = "Field1")
	protected long field1;
	
	
	public InstalledBase(int id, Date distributor_Date, String distributor,
			long tBL_IB_Serial_or_Order, String family, String model,
			String cylinders, String lean_or_Rich_Burn, long power_BHP,
			String branch, String branch_Address, String branch_City,
			String branch_State, String branch_Country, String owner,
			String owner_Address, String owner_City, String owner_State,
			String owner_Country, String owner_Post_Code, String site_Name,
			String site_Address, String site_City, String site_State,
			String site_Country, String site_Post_Code, String site_Longitude,
			String site_Latitude, String region, String engine_Market,
			String driven_Equipment, String driven_Equipment_Model,
			String engine_Application, String fuel_Type, String lC_Model,
			String notes, String customer_Tag, String status, String duty,
			String eQUIPMENT_STATUS, String rPM, String load,
			String hours_per_Year, String engine_Location_Area,
			String contact_name, String contact_Email, String phone_Number,
			String distributor_Maintenance_Agreement,
			String engine_Hrs_of_Last_Top_Overhaul, String date_Performed,
			String engine_Hrs_of_Last_Bottom_Overhaul,
			String date_Performed_Last, String current_Engine_Hours,
			String date_Verified, String engine_Modified_Yes_No,
			String if_Yes_please_explain_modification,
			String other_Distributor_Info, String startup_Year,
			String special_Notes, String installed_at,
			String mACHINE_DESCRIPTION, String mANUFACTURER,
			String oPERATING_PERCENTAJE, String cOMMENTS_if_any_OWNER,
			String specNo, String service_File_No, String cP,
			String cool_SysecNo, String date_of_Op_Hrs, String engine_Quantity,
			String sector, String air_Fuel_Ratio, String catalyst,
			String compressor, String engine_Facility_Name,
			String generator_Set, String hP, String ignition_Type,
			String last_Maintenance_Date, String overhaul_Date,
			String packager, String permit_Number, String permit_Year,
			String turbocharger_Model, String driven_Equipment1,
			String fuel_Type1, String line, String jFE_Site_No, String area,
			String tBL_IB_Region1, String startup, String ship_Date,
			String year, String gGO_Region, String oraclePartyNumber,
			String field0, String expr1, String expr2, String expr3,
			String expr4, long field1) {
		super();
		this.id = id;
		this.distributor_Date = distributor_Date;
		this.distributor = distributor;
		this.tBL_IB_Serial_or_Order = tBL_IB_Serial_or_Order;
		this.family = family;
		this.model = model;
		this.cylinders = cylinders;
		this.lean_or_Rich_Burn = lean_or_Rich_Burn;
		this.power_BHP = power_BHP;
		this.branch = branch;
		this.branch_Address = branch_Address;
		this.branch_City = branch_City;
		this.branch_State = branch_State;
		this.branch_Country = branch_Country;
		this.owner = owner;
		this.owner_Address = owner_Address;
		this.owner_City = owner_City;
		this.owner_State = owner_State;
		this.owner_Country = owner_Country;
		this.owner_Post_Code = owner_Post_Code;
		this.site_Name = site_Name;
		this.site_Address = site_Address;
		this.site_City = site_City;
		this.site_State = site_State;
		this.site_Country = site_Country;
		this.site_Post_Code = site_Post_Code;
		this.site_Longitude = site_Longitude;
		this.site_Latitude = site_Latitude;
		this.region = region;
		this.engine_Market = engine_Market;
		this.driven_Equipment = driven_Equipment;
		this.driven_Equipment_Model = driven_Equipment_Model;
		this.engine_Application = engine_Application;
		this.fuel_Type = fuel_Type;
		this.lC_Model = lC_Model;
		this.notes = notes;
		this.customer_Tag = customer_Tag;
		this.status = status;
		this.duty = duty;
		this.eQUIPMENT_STATUS = eQUIPMENT_STATUS;
		this.rPM = rPM;
		this.load = load;
		this.hours_per_Year = hours_per_Year;
		this.engine_Location_Area = engine_Location_Area;
		this.contact_name = contact_name;
		this.contact_Email = contact_Email;
		this.phone_Number = phone_Number;
		this.distributor_Maintenance_Agreement = distributor_Maintenance_Agreement;
		this.engine_Hrs_of_Last_Top_Overhaul = engine_Hrs_of_Last_Top_Overhaul;
		this.date_Performed = date_Performed;
		this.engine_Hrs_of_Last_Bottom_Overhaul = engine_Hrs_of_Last_Bottom_Overhaul;
		this.date_Performed_Last = date_Performed_Last;
		this.current_Engine_Hours = current_Engine_Hours;
		this.date_Verified = date_Verified;
		this.engine_Modified_Yes_No = engine_Modified_Yes_No;
		this.if_Yes_please_explain_modification = if_Yes_please_explain_modification;
		this.other_Distributor_Info = other_Distributor_Info;
		this.startup_Year = startup_Year;
		this.special_Notes = special_Notes;
		this.installed_at = installed_at;
		this.mACHINE_DESCRIPTION = mACHINE_DESCRIPTION;
		this.mANUFACTURER = mANUFACTURER;
		this.oPERATING_PERCENTAJE = oPERATING_PERCENTAJE;
		this.cOMMENTS_if_any_OWNER = cOMMENTS_if_any_OWNER;
		this.specNo = specNo;
		this.service_File_No = service_File_No;
		this.cP = cP;
		this.cool_SysecNo = cool_SysecNo;
		this.date_of_Op_Hrs = date_of_Op_Hrs;
		this.engine_Quantity = engine_Quantity;
		this.sector = sector;
		this.air_Fuel_Ratio = air_Fuel_Ratio;
		this.catalyst = catalyst;
		this.compressor = compressor;
		this.engine_Facility_Name = engine_Facility_Name;
		this.generator_Set = generator_Set;
		this.hP = hP;
		this.ignition_Type = ignition_Type;
		this.last_Maintenance_Date = last_Maintenance_Date;
		this.overhaul_Date = overhaul_Date;
		this.packager = packager;
		this.permit_Number = permit_Number;
		this.permit_Year = permit_Year;
		this.turbocharger_Model = turbocharger_Model;
		this.driven_Equipment1 = driven_Equipment1;
		this.fuel_Type1 = fuel_Type1;
		this.line = line;
		this.jFE_Site_No = jFE_Site_No;
		this.area = area;
		this.tBL_IB_Region1 = tBL_IB_Region1;
		this.startup = startup;
		this.ship_Date = ship_Date;
		this.year = year;
		this.gGO_Region = gGO_Region;
		this.oraclePartyNumber = oraclePartyNumber;
		this.field0 = field0;
		this.expr1 = expr1;
		this.expr2 = expr2;
		this.expr3 = expr3;
		this.expr4 = expr4;
		this.field1 = field1;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getDistributor_Date() {
		return distributor_Date;
	}


	public void setDistributor_Date(Date distributor_Date) {
		this.distributor_Date = distributor_Date;
	}


	public String getDistributor() {
		return distributor;
	}


	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}


	public long gettBL_IB_Serial_or_Order() {
		return tBL_IB_Serial_or_Order;
	}


	public void settBL_IB_Serial_or_Order(long tBL_IB_Serial_or_Order) {
		this.tBL_IB_Serial_or_Order = tBL_IB_Serial_or_Order;
	}


	public String getFamily() {
		return family;
	}


	public void setFamily(String family) {
		this.family = family;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getCylinders() {
		return cylinders;
	}


	public void setCylinders(String cylinders) {
		this.cylinders = cylinders;
	}


	public String getLean_or_Rich_Burn() {
		return lean_or_Rich_Burn;
	}


	public void setLean_or_Rich_Burn(String lean_or_Rich_Burn) {
		this.lean_or_Rich_Burn = lean_or_Rich_Burn;
	}


	public long getPower_BHP() {
		return power_BHP;
	}


	public void setPower_BHP(long power_BHP) {
		this.power_BHP = power_BHP;
	}


	public String getBranch() {
		return branch;
	}


	public void setBranch(String branch) {
		this.branch = branch;
	}


	public String getBranch_Address() {
		return branch_Address;
	}


	public void setBranch_Address(String branch_Address) {
		this.branch_Address = branch_Address;
	}


	public String getBranch_City() {
		return branch_City;
	}


	public void setBranch_City(String branch_City) {
		this.branch_City = branch_City;
	}


	public String getBranch_State() {
		return branch_State;
	}


	public void setBranch_State(String branch_State) {
		this.branch_State = branch_State;
	}


	public String getBranch_Country() {
		return branch_Country;
	}


	public void setBranch_Country(String branch_Country) {
		this.branch_Country = branch_Country;
	}


	public String getOwner() {
		return owner;
	}


	public void setOwner(String owner) {
		this.owner = owner;
	}


	public String getOwner_Address() {
		return owner_Address;
	}


	public void setOwner_Address(String owner_Address) {
		this.owner_Address = owner_Address;
	}


	public String getOwner_City() {
		return owner_City;
	}


	public void setOwner_City(String owner_City) {
		this.owner_City = owner_City;
	}


	public String getOwner_State() {
		return owner_State;
	}


	public void setOwner_State(String owner_State) {
		this.owner_State = owner_State;
	}


	public String getOwner_Country() {
		return owner_Country;
	}


	public void setOwner_Country(String owner_Country) {
		this.owner_Country = owner_Country;
	}


	public String getOwner_Post_Code() {
		return owner_Post_Code;
	}


	public void setOwner_Post_Code(String owner_Post_Code) {
		this.owner_Post_Code = owner_Post_Code;
	}


	public String getSite_Name() {
		return site_Name;
	}


	public void setSite_Name(String site_Name) {
		this.site_Name = site_Name;
	}


	public String getSite_Address() {
		return site_Address;
	}


	public void setSite_Address(String site_Address) {
		this.site_Address = site_Address;
	}


	public String getSite_City() {
		return site_City;
	}


	public void setSite_City(String site_City) {
		this.site_City = site_City;
	}


	public String getSite_State() {
		return site_State;
	}


	public void setSite_State(String site_State) {
		this.site_State = site_State;
	}


	public String getSite_Country() {
		return site_Country;
	}


	public void setSite_Country(String site_Country) {
		this.site_Country = site_Country;
	}


	public String getSite_Post_Code() {
		return site_Post_Code;
	}


	public void setSite_Post_Code(String site_Post_Code) {
		this.site_Post_Code = site_Post_Code;
	}


	public String getSite_Longitude() {
		return site_Longitude;
	}


	public void setSite_Longitude(String site_Longitude) {
		this.site_Longitude = site_Longitude;
	}


	public String getSite_Latitude() {
		return site_Latitude;
	}


	public void setSite_Latitude(String site_Latitude) {
		this.site_Latitude = site_Latitude;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getEngine_Market() {
		return engine_Market;
	}


	public void setEngine_Market(String engine_Market) {
		this.engine_Market = engine_Market;
	}


	public String getDriven_Equipment() {
		return driven_Equipment;
	}


	public void setDriven_Equipment(String driven_Equipment) {
		this.driven_Equipment = driven_Equipment;
	}


	public String getDriven_Equipment_Model() {
		return driven_Equipment_Model;
	}


	public void setDriven_Equipment_Model(String driven_Equipment_Model) {
		this.driven_Equipment_Model = driven_Equipment_Model;
	}


	public String getEngine_Application() {
		return engine_Application;
	}


	public void setEngine_Application(String engine_Application) {
		this.engine_Application = engine_Application;
	}


	public String getFuel_Type() {
		return fuel_Type;
	}


	public void setFuel_Type(String fuel_Type) {
		this.fuel_Type = fuel_Type;
	}


	public String getlC_Model() {
		return lC_Model;
	}


	public void setlC_Model(String lC_Model) {
		this.lC_Model = lC_Model;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	public String getCustomer_Tag() {
		return customer_Tag;
	}


	public void setCustomer_Tag(String customer_Tag) {
		this.customer_Tag = customer_Tag;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getDuty() {
		return duty;
	}


	public void setDuty(String duty) {
		this.duty = duty;
	}


	public String geteQUIPMENT_STATUS() {
		return eQUIPMENT_STATUS;
	}


	public void seteQUIPMENT_STATUS(String eQUIPMENT_STATUS) {
		this.eQUIPMENT_STATUS = eQUIPMENT_STATUS;
	}


	public String getrPM() {
		return rPM;
	}


	public void setrPM(String rPM) {
		this.rPM = rPM;
	}


	public String getLoad() {
		return load;
	}


	public void setLoad(String load) {
		this.load = load;
	}


	public String getHours_per_Year() {
		return hours_per_Year;
	}


	public void setHours_per_Year(String hours_per_Year) {
		this.hours_per_Year = hours_per_Year;
	}


	public String getEngine_Location_Area() {
		return engine_Location_Area;
	}


	public void setEngine_Location_Area(String engine_Location_Area) {
		this.engine_Location_Area = engine_Location_Area;
	}


	public String getContact_name() {
		return contact_name;
	}


	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}


	public String getContact_Email() {
		return contact_Email;
	}


	public void setContact_Email(String contact_Email) {
		this.contact_Email = contact_Email;
	}


	public String getPhone_Number() {
		return phone_Number;
	}


	public void setPhone_Number(String phone_Number) {
		this.phone_Number = phone_Number;
	}


	public String getDistributor_Maintenance_Agreement() {
		return distributor_Maintenance_Agreement;
	}


	public void setDistributor_Maintenance_Agreement(
			String distributor_Maintenance_Agreement) {
		this.distributor_Maintenance_Agreement = distributor_Maintenance_Agreement;
	}


	public String getEngine_Hrs_of_Last_Top_Overhaul() {
		return engine_Hrs_of_Last_Top_Overhaul;
	}


	public void setEngine_Hrs_of_Last_Top_Overhaul(
			String engine_Hrs_of_Last_Top_Overhaul) {
		this.engine_Hrs_of_Last_Top_Overhaul = engine_Hrs_of_Last_Top_Overhaul;
	}


	public String getDate_Performed() {
		return date_Performed;
	}


	public void setDate_Performed(String date_Performed) {
		this.date_Performed = date_Performed;
	}


	public String getEngine_Hrs_of_Last_Bottom_Overhaul() {
		return engine_Hrs_of_Last_Bottom_Overhaul;
	}


	public void setEngine_Hrs_of_Last_Bottom_Overhaul(
			String engine_Hrs_of_Last_Bottom_Overhaul) {
		this.engine_Hrs_of_Last_Bottom_Overhaul = engine_Hrs_of_Last_Bottom_Overhaul;
	}


	public String getDate_Performed_Last() {
		return date_Performed_Last;
	}


	public void setDate_Performed_Last(String date_Performed_Last) {
		this.date_Performed_Last = date_Performed_Last;
	}


	public String getCurrent_Engine_Hours() {
		return current_Engine_Hours;
	}


	public void setCurrent_Engine_Hours(String current_Engine_Hours) {
		this.current_Engine_Hours = current_Engine_Hours;
	}


	public String getDate_Verified() {
		return date_Verified;
	}


	public void setDate_Verified(String date_Verified) {
		this.date_Verified = date_Verified;
	}


	public String getEngine_Modified_Yes_No() {
		return engine_Modified_Yes_No;
	}


	public void setEngine_Modified_Yes_No(String engine_Modified_Yes_No) {
		this.engine_Modified_Yes_No = engine_Modified_Yes_No;
	}


	public String getIf_Yes_please_explain_modification() {
		return if_Yes_please_explain_modification;
	}


	public void setIf_Yes_please_explain_modification(
			String if_Yes_please_explain_modification) {
		this.if_Yes_please_explain_modification = if_Yes_please_explain_modification;
	}


	public String getOther_Distributor_Info() {
		return other_Distributor_Info;
	}


	public void setOther_Distributor_Info(String other_Distributor_Info) {
		this.other_Distributor_Info = other_Distributor_Info;
	}


	public String getStartup_Year() {
		return startup_Year;
	}


	public void setStartup_Year(String startup_Year) {
		this.startup_Year = startup_Year;
	}


	public String getSpecial_Notes() {
		return special_Notes;
	}


	public void setSpecial_Notes(String special_Notes) {
		this.special_Notes = special_Notes;
	}


	public String getInstalled_at() {
		return installed_at;
	}


	public void setInstalled_at(String installed_at) {
		this.installed_at = installed_at;
	}


	public String getmACHINE_DESCRIPTION() {
		return mACHINE_DESCRIPTION;
	}


	public void setmACHINE_DESCRIPTION(String mACHINE_DESCRIPTION) {
		this.mACHINE_DESCRIPTION = mACHINE_DESCRIPTION;
	}


	public String getmANUFACTURER() {
		return mANUFACTURER;
	}


	public void setmANUFACTURER(String mANUFACTURER) {
		this.mANUFACTURER = mANUFACTURER;
	}


	public String getoPERATING_PERCENTAJE() {
		return oPERATING_PERCENTAJE;
	}


	public void setoPERATING_PERCENTAJE(String oPERATING_PERCENTAJE) {
		this.oPERATING_PERCENTAJE = oPERATING_PERCENTAJE;
	}


	public String getcOMMENTS_if_any_OWNER() {
		return cOMMENTS_if_any_OWNER;
	}


	public void setcOMMENTS_if_any_OWNER(String cOMMENTS_if_any_OWNER) {
		this.cOMMENTS_if_any_OWNER = cOMMENTS_if_any_OWNER;
	}


	public String getSpecNo() {
		return specNo;
	}


	public void setSpecNo(String specNo) {
		this.specNo = specNo;
	}


	public String getService_File_No() {
		return service_File_No;
	}


	public void setService_File_No(String service_File_No) {
		this.service_File_No = service_File_No;
	}


	public String getcP() {
		return cP;
	}


	public void setcP(String cP) {
		this.cP = cP;
	}


	public String getCool_SysecNo() {
		return cool_SysecNo;
	}


	public void setCool_SysecNo(String cool_SysecNo) {
		this.cool_SysecNo = cool_SysecNo;
	}


	public String getDate_of_Op_Hrs() {
		return date_of_Op_Hrs;
	}


	public void setDate_of_Op_Hrs(String date_of_Op_Hrs) {
		this.date_of_Op_Hrs = date_of_Op_Hrs;
	}


	public String getEngine_Quantity() {
		return engine_Quantity;
	}


	public void setEngine_Quantity(String engine_Quantity) {
		this.engine_Quantity = engine_Quantity;
	}


	public String getSector() {
		return sector;
	}


	public void setSector(String sector) {
		this.sector = sector;
	}


	public String getAir_Fuel_Ratio() {
		return air_Fuel_Ratio;
	}


	public void setAir_Fuel_Ratio(String air_Fuel_Ratio) {
		this.air_Fuel_Ratio = air_Fuel_Ratio;
	}


	public String getCatalyst() {
		return catalyst;
	}


	public void setCatalyst(String catalyst) {
		this.catalyst = catalyst;
	}


	public String getCompressor() {
		return compressor;
	}


	public void setCompressor(String compressor) {
		this.compressor = compressor;
	}


	public String getEngine_Facility_Name() {
		return engine_Facility_Name;
	}


	public void setEngine_Facility_Name(String engine_Facility_Name) {
		this.engine_Facility_Name = engine_Facility_Name;
	}


	public String getGenerator_Set() {
		return generator_Set;
	}


	public void setGenerator_Set(String generator_Set) {
		this.generator_Set = generator_Set;
	}


	public String gethP() {
		return hP;
	}


	public void sethP(String hP) {
		this.hP = hP;
	}


	public String getIgnition_Type() {
		return ignition_Type;
	}


	public void setIgnition_Type(String ignition_Type) {
		this.ignition_Type = ignition_Type;
	}


	public String getLast_Maintenance_Date() {
		return last_Maintenance_Date;
	}


	public void setLast_Maintenance_Date(String last_Maintenance_Date) {
		this.last_Maintenance_Date = last_Maintenance_Date;
	}


	public String getOverhaul_Date() {
		return overhaul_Date;
	}


	public void setOverhaul_Date(String overhaul_Date) {
		this.overhaul_Date = overhaul_Date;
	}


	public String getPackager() {
		return packager;
	}


	public void setPackager(String packager) {
		this.packager = packager;
	}


	public String getPermit_Number() {
		return permit_Number;
	}


	public void setPermit_Number(String permit_Number) {
		this.permit_Number = permit_Number;
	}


	public String getPermit_Year() {
		return permit_Year;
	}


	public void setPermit_Year(String permit_Year) {
		this.permit_Year = permit_Year;
	}


	public String getTurbocharger_Model() {
		return turbocharger_Model;
	}


	public void setTurbocharger_Model(String turbocharger_Model) {
		this.turbocharger_Model = turbocharger_Model;
	}


	public String getDriven_Equipment1() {
		return driven_Equipment1;
	}


	public void setDriven_Equipment1(String driven_Equipment1) {
		this.driven_Equipment1 = driven_Equipment1;
	}


	public String getFuel_Type1() {
		return fuel_Type1;
	}


	public void setFuel_Type1(String fuel_Type1) {
		this.fuel_Type1 = fuel_Type1;
	}


	public String getLine() {
		return line;
	}


	public void setLine(String line) {
		this.line = line;
	}


	public String getjFE_Site_No() {
		return jFE_Site_No;
	}


	public void setjFE_Site_No(String jFE_Site_No) {
		this.jFE_Site_No = jFE_Site_No;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String gettBL_IB_Region1() {
		return tBL_IB_Region1;
	}


	public void settBL_IB_Region1(String tBL_IB_Region1) {
		this.tBL_IB_Region1 = tBL_IB_Region1;
	}


	public String getStartup() {
		return startup;
	}


	public void setStartup(String startup) {
		this.startup = startup;
	}


	public String getShip_Date() {
		return ship_Date;
	}


	public void setShip_Date(String ship_Date) {
		this.ship_Date = ship_Date;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getgGO_Region() {
		return gGO_Region;
	}


	public void setgGO_Region(String gGO_Region) {
		this.gGO_Region = gGO_Region;
	}


	public String getOraclePartyNumber() {
		return oraclePartyNumber;
	}


	public void setOraclePartyNumber(String oraclePartyNumber) {
		this.oraclePartyNumber = oraclePartyNumber;
	}


	public String getField0() {
		return field0;
	}


	public void setField0(String field0) {
		this.field0 = field0;
	}


	public String getExpr1() {
		return expr1;
	}


	public void setExpr1(String expr1) {
		this.expr1 = expr1;
	}


	public String getExpr2() {
		return expr2;
	}


	public void setExpr2(String expr2) {
		this.expr2 = expr2;
	}


	public String getExpr3() {
		return expr3;
	}


	public void setExpr3(String expr3) {
		this.expr3 = expr3;
	}


	public String getExpr4() {
		return expr4;
	}


	public void setExpr4(String expr4) {
		this.expr4 = expr4;
	}


	public long getField1() {
		return field1;
	}


	public void setField1(long field1) {
		this.field1 = field1;
	}


	public InstalledBase() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}