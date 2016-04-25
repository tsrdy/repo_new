package main.java.installed_base_data;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import main.java.lifecycle_data_model.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;



@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@RestController
public class InstalledBaseService {

	private static final Logger LOG = LoggerFactory.getLogger(InstalledBaseService.class);

	Session session=null;
	private int id=0;
	public InstalledBaseService() {
		File f = new File("E:\\SpringBootV\\src\\hibernate.cfg.xml");
		
		Configuration configuration=new Configuration().configure(f);
		
		SessionFactory factory=configuration.buildSessionFactory();
		 session=factory.openSession();    
		 File file=null;
			try {
				file = convertCSVtoJson();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JSONParser parser = new JSONParser();
			System.out.println("parser::"+parser);
			JSONArray jsonArray=null;
			try {
				jsonArray = (JSONArray)parser.parse(new FileReader(file));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("jsonArray::"+jsonArray);
			int count=0;
			for (Object o : jsonArray) {
				System.out.println("Object:::"+o);
				JSONObject installedBaseJson = (JSONObject) o;
				int id=0;
				Date distributor_Date= new Date();
				String distributor=null;
				long tBL_IB_Serial_or_Order=0; 
				String family=null; 
				String model=null;
				String cylinders=null;
				String lean_or_Rich_Burn=null; 
				long power_BHP=0;
				String branch=null; 
				String branch_Address=null; 
				String branch_City=null;
				String branch_State=null; 
				String branch_Country=null; 
				String owner=null;
				String owner_Address=null; 
				String owner_City=null; 
				String owner_State=null;
				String owner_Country=null; 
				String owner_Post_Code=null; 
				String site_Name=null;
				String site_Address=null; 
				String site_City=null; 
				String site_State=null;
				String site_Country=null; 
				String site_Post_Code=null; 
				String site_Longitude=null;
				String site_Latitude=null; 
				String region=null; 
				String engine_Market=null;
				String driven_Equipment=null; 
				String driven_Equipment_Model=null;
				String engine_Application=null; 
				String fuel_Type=null; 
				String lC_Model=null;
				String notes=null; 
				String customer_Tag=null; 
				String status=null; 
				String duty=null;
				String eQUIPMENT_STATUS=null; 
				String rPM=null; 
				String load=null;
				String hours_per_Year=null; 
				String engine_Location_Area=null;
				String contact_name=null; 
				String contact_Email=null; 
				String phone_Number=null;
				String distributor_Maintenance_Agreement=null;
				String engine_Hrs_of_Last_Top_Overhaul=null; 
				String date_Performed=null;
				String engine_Hrs_of_Last_Bottom_Overhaul=null;
				String date_Performed_Last=null; 
				String current_Engine_Hours=null;
				String date_Verified=null; 
				String engine_Modified_Yes_No=null;
				String if_Yes_please_explain_modification=null;
				String other_Distributor_Info=null; 
				String startup_Year=null;
				String special_Notes=null; 
				String installed_at=null;
				String mACHINE_DESCRIPTION=null; 
				String mANUFACTURER=null;
				String oPERATING_PERCENTAJE=null; 
				String cOMMENTS_if_any_OWNER=null;
				String specNo=null; 
				String service_File_No=null; 
				String cP=null;
				String cool_SysecNo=null; 
				String date_of_Op_Hrs=null; 
				String engine_Quantity=null;
				String sector=null; 
				String air_Fuel_Ratio=null; 
				String catalyst=null;
				String compressor=null; 
				String engine_Facility_Name=null;
				String generator_Set=null; 
				String hP=null; 
				String ignition_Type=null;
				String last_Maintenance_Date=null; 
				String overhaul_Date=null;
				String packager=null; 
				String permit_Number=null; 
				String permit_Year=null;
				String turbocharger_Model=null; 
				String driven_Equipment1=null;
				String fuel_Type1=null; 
				String line=null; 
				String jFE_Site_No=null; 
				String area=null;
				String tBL_IB_Region1=null; 
				String startup=null; 
				String ship_Date=null;
				String year=null; 
				String gGO_Region=null; 
				String oraclePartyNumber=null;
				String field0=null; 
				String expr1=null; 
				String expr2=null; 
				String expr3=null;
				String expr4=null; 
				long field1=0;
				
				
				count=count+1;
				id=count;
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

				try {
					if ((String)installedBaseJson.get("Distributor_Date") != null&& !"".equals((String)installedBaseJson.get("Distributor_Date"))) {
						distributor_Date = dateFormat.parse((String) installedBaseJson.get("Distributor_Date"));
					}
				}catch (java.text.ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if((String) installedBaseJson.get("Distributor")!=null&&!"".equals((String) installedBaseJson.get("Distributor"))){
					distributor= (String) installedBaseJson.get("Distributor");
				}
				
				if (installedBaseJson.get("TBL_IB_Serial_or_Order") != null
						&& !"".equals(installedBaseJson.get("TBL_IB_Serial_or_Order"))) {
					tBL_IB_Serial_or_Order = Long.valueOf((String) installedBaseJson.get("TBL_IB_Serial_or_Order"));
				}
				
				if((String) installedBaseJson.get("family")!=null&&!"".equals((String) installedBaseJson.get("family"))){
					family= (String) installedBaseJson.get("family");
				}
				if((String) installedBaseJson.get("Model")!=null&&!"".equals((String) installedBaseJson.get("Model"))){
					model= (String) installedBaseJson.get("Model");
				}
				if((String) installedBaseJson.get("Cylinders")!=null&&!"".equals((String) installedBaseJson.get("Cylinders"))){
					cylinders= (String) installedBaseJson.get("Cylinders");
				}
				if((String) installedBaseJson.get("Lean_or_Rich_Burn")!=null&&!"".equals((String) installedBaseJson.get("Lean_or_Rich_Burn"))){
					lean_or_Rich_Burn= (String) installedBaseJson.get("Lean_or_Rich_Burn");
				}
				if((String) installedBaseJson.get("Power_BHP")!=null&&!"".equals((String) installedBaseJson.get("Power_BHP"))){
					power_BHP= Long.valueOf((String) installedBaseJson.get("Power_BHP"));
				}
				if((String) installedBaseJson.get("Branch")!=null&&!"".equals((String) installedBaseJson.get("Branch"))){
					branch= (String) installedBaseJson.get("Branch");
				}
				if((String) installedBaseJson.get("Branch_Address")!=null&&!"".equals((String) installedBaseJson.get("Branch_Address"))){
					branch_Address= (String) installedBaseJson.get("Branch_Address");
				}
				if((String) installedBaseJson.get("Branch_City")!=null&&!"".equals((String) installedBaseJson.get("Branch_City"))){
					branch_City= (String) installedBaseJson.get("Branch_City");
				}
				if((String) installedBaseJson.get("Branch_State")!=null&&!"".equals((String) installedBaseJson.get("Branch_State"))){
					branch_State= (String) installedBaseJson.get("Branch_State");
				}
				if((String) installedBaseJson.get("Branch_Country")!=null&&!"".equals((String) installedBaseJson.get("Branch_Country"))){
					branch_Country= (String) installedBaseJson.get("Branch_Country");
				}
				if((String) installedBaseJson.get("Owner")!=null&&!"".equals((String) installedBaseJson.get("Owner"))){
					owner= (String) installedBaseJson.get("Owner");
				}
				if((String) installedBaseJson.get("Owner_Address")!=null&&!"".equals((String) installedBaseJson.get("Owner_Address"))){
					owner_Address= (String) installedBaseJson.get("Owner_Address");
				}
				if((String) installedBaseJson.get("Owner_City")!=null&&!"".equals((String) installedBaseJson.get("Owner_City"))){
					owner_City= (String) installedBaseJson.get("Owner_City");
				}
				if((String) installedBaseJson.get("Owner_State")!=null&&!"".equals((String) installedBaseJson.get("Owner_State"))){
					owner_State= (String) installedBaseJson.get("Owner_State");
				}
				if((String) installedBaseJson.get("Owner_Country")!=null&&!"".equals((String) installedBaseJson.get("Owner_Country"))){
					owner_Country= (String) installedBaseJson.get("Owner_Country");
				}
				if((String) installedBaseJson.get("Owner_Post_Code")!=null&&!"".equals((String) installedBaseJson.get("Owner_Post_Code"))){
					owner_Post_Code= (String) installedBaseJson.get("Owner_Post_Code");
				}
				if((String) installedBaseJson.get("Site_Name")!=null&&!"".equals((String) installedBaseJson.get("Site_Name"))){
					site_Name= (String) installedBaseJson.get("Site_Name");
				}
				if((String) installedBaseJson.get("Site_Address")!=null&&!"".equals((String) installedBaseJson.get("Site_Address"))){
					site_Address= (String) installedBaseJson.get("Site_Address");
				}
				if((String) installedBaseJson.get("Site_City")!=null&&!"".equals((String) installedBaseJson.get("Site_City"))){
					site_City= (String) installedBaseJson.get("Site_City");
				}
				if((String) installedBaseJson.get("Site_State")!=null&&!"".equals((String) installedBaseJson.get("Site_State"))){
					site_State= (String) installedBaseJson.get("Site_State");
				}
				if((String) installedBaseJson.get("Site_Country")!=null&&!"".equals((String) installedBaseJson.get("Site_Country"))){
					site_Country= (String) installedBaseJson.get("Site_Country");
				}
				if((String) installedBaseJson.get("Site_Post_Code")!=null&&!"".equals((String) installedBaseJson.get("Site_Post_Code"))){
					site_Post_Code= (String) installedBaseJson.get("Site_Post_Code");
				}
				if((String) installedBaseJson.get("Site_Longitude")!=null&&!"".equals((String) installedBaseJson.get("Site_Longitude"))){
					site_Longitude= (String) installedBaseJson.get("Site_Longitude");
				}
				if((String) installedBaseJson.get("Site_Latitude")!=null&&!"".equals((String) installedBaseJson.get("Site_Latitude"))){
					site_Latitude= (String) installedBaseJson.get("Site_Latitude");
				}
				if((String) installedBaseJson.get("Region")!=null&&!"".equals((String) installedBaseJson.get("Region"))){
					region= (String) installedBaseJson.get("Region");
				}
				
				if((String) installedBaseJson.get("Engine_Market")!=null&&!"".equals((String) installedBaseJson.get("Engine_Market"))){
					engine_Market= (String) installedBaseJson.get("Engine_Market");
				}
				if((String) installedBaseJson.get("Driven_Equipment")!=null&&!"".equals((String) installedBaseJson.get("Driven_Equipment"))){
					driven_Equipment= (String) installedBaseJson.get("Driven_Equipment");
				}
				if((String) installedBaseJson.get("Driven_Equipment_Model")!=null&&!"".equals((String) installedBaseJson.get("Driven_Equipment_Model"))){
					driven_Equipment_Model= (String) installedBaseJson.get("Driven_Equipment_Model");
				}
				if((String) installedBaseJson.get("Engine_Application")!=null&&!"".equals((String) installedBaseJson.get("Engine_Application"))){
					engine_Application= (String) installedBaseJson.get("Engine_Application");
				}
				if((String) installedBaseJson.get("Fuel_Type")!=null&&!"".equals((String) installedBaseJson.get("Fuel_Type"))){
					fuel_Type= (String) installedBaseJson.get("Fuel_Type");
				}
				if((String) installedBaseJson.get("LC_Model")!=null&&!"".equals((String) installedBaseJson.get("LC_Model"))){
					lC_Model= (String) installedBaseJson.get("LC_Model");
				}
				if((String) installedBaseJson.get("Notes")!=null&&!"".equals((String) installedBaseJson.get("Notes"))){
					notes= (String) installedBaseJson.get("Notes");
				}
				if((String) installedBaseJson.get("Customer_Tag")!=null&&!"".equals((String) installedBaseJson.get("Customer_Tag"))){
					customer_Tag= (String) installedBaseJson.get("Customer_Tag");
				}
				if((String) installedBaseJson.get("Status")!=null&&!"".equals((String) installedBaseJson.get("Status"))){
					status = (String) installedBaseJson.get("Status");
				}
				if((String) installedBaseJson.get("Duty")!=null&&!"".equals((String) installedBaseJson.get("Duty"))){
					duty= (String) installedBaseJson.get("Duty");
				}
				if((String) installedBaseJson.get("EQUIPMENT_STATUS")!=null&&!"".equals((String) installedBaseJson.get("EQUIPMENT_STATUS"))){
					eQUIPMENT_STATUS= (String) installedBaseJson.get("EQUIPMENT_STATUS");
				}
				if((String) installedBaseJson.get("Cylinders")!=null&&!"".equals((String) installedBaseJson.get("Cylinders"))){
					cylinders= (String) installedBaseJson.get("Cylinders");
				}
				if((String) installedBaseJson.get("RPM")!=null&&!"".equals((String) installedBaseJson.get("RPM"))){
					rPM = (String) installedBaseJson.get("RPM");
				}
				if((String) installedBaseJson.get("Load")!=null&&!"".equals((String) installedBaseJson.get("Load"))){
					load= (String) installedBaseJson.get("Load");
				}
				if((String) installedBaseJson.get("Hours_per_Year")!=null&&!"".equals((String) installedBaseJson.get("Hours_per_Year"))){
					hours_per_Year= (String) installedBaseJson.get("Hours_per_Year");
				}
				if((String) installedBaseJson.get("Engine_Location_Area")!=null&&!"".equals((String) installedBaseJson.get("Engine_Location_Area"))){
					engine_Location_Area= (String) installedBaseJson.get("Engine_Location_Area");
				}
				if((String) installedBaseJson.get("Contact_name")!=null&&!"".equals((String) installedBaseJson.get("Contact_name"))){
					contact_name = (String) installedBaseJson.get("Contact_name");
				}
				if((String) installedBaseJson.get("Contact_Email")!=null&&!"".equals((String) installedBaseJson.get("Contact_Email"))){
					contact_Email= (String) installedBaseJson.get("Contact_Email");
				}
				if((String) installedBaseJson.get("Phone_Number")!=null&&!"".equals((String) installedBaseJson.get("Phone_Number"))){
					phone_Number= (String) installedBaseJson.get("Phone_Number");
				}
				if((String) installedBaseJson.get("Distributor_Maintenance_Agreement")!=null&&!"".equals((String) installedBaseJson.get("Distributor_Maintenance_Agreement"))){
					distributor_Maintenance_Agreement= (String) installedBaseJson.get("Distributor_Maintenance_Agreement");
				}
				if((String) installedBaseJson.get("engine_Hrs_of_Last_Top_Overhaul")!=null&&!"".equals((String) installedBaseJson.get("engine_Hrs_of_Last_Top_Overhaul"))){
					engine_Hrs_of_Last_Top_Overhaul = (String) installedBaseJson.get("engine_Hrs_of_Last_Top_Overhaul");
				}
				if((String) installedBaseJson.get("Date_Performed")!=null&&!"".equals((String) installedBaseJson.get("Date_Performed"))){
					date_Performed= (String) installedBaseJson.get("Date_Performed");
				}
				if((String) installedBaseJson.get("Engine_Hrs_of_Last_Bottom_Overhaul")!=null&&!"".equals((String) installedBaseJson.get("Engine_Hrs_of_Last_Bottom_Overhaul"))){
					engine_Hrs_of_Last_Bottom_Overhaul= (String) installedBaseJson.get("Engine_Hrs_of_Last_Bottom_Overhaul");
				}
				if((String) installedBaseJson.get("Date_Performed_Last")!=null&&!"".equals((String) installedBaseJson.get("Date_Performed_Last"))){
					date_Performed_Last= (String) installedBaseJson.get("Date_Performed_Last");
				}
				if((String) installedBaseJson.get("Current_Engine_Hours")!=null&&!"".equals((String) installedBaseJson.get("Current_Engine_Hours"))){
					current_Engine_Hours= (String) installedBaseJson.get("Current_Engine_Hours");
				}
				if((String) installedBaseJson.get("Date_Verified")!=null&&!"".equals((String) installedBaseJson.get("Date_Verified"))){
					date_Verified = (String) installedBaseJson.get("Date_Verified");
				}
				if((String) installedBaseJson.get("Engine_Modified_Yes_No")!=null&&!"".equals((String) installedBaseJson.get("Engine_Modified_Yes_No"))){
					engine_Modified_Yes_No= (String) installedBaseJson.get("Engine_Modified_Yes_No");
				}
				if((String) installedBaseJson.get("If_Yes_please_explain_modification")!=null&&!"".equals((String) installedBaseJson.get("If_Yes_please_explain_modification"))){
					if_Yes_please_explain_modification= (String) installedBaseJson.get("If_Yes_please_explain_modification");
				}
				if((String) installedBaseJson.get("Other_Distributor_Info")!=null&&!"".equals((String) installedBaseJson.get("Other_Distributor_Info"))){
					other_Distributor_Info= (String) installedBaseJson.get("Other_Distributor_Info");
				}
				if((String) installedBaseJson.get("Startup_Year")!=null&&!"".equals((String) installedBaseJson.get("Startup_Year"))){
					startup_Year= (String) installedBaseJson.get("Startup_Year");
				}
				if((String) installedBaseJson.get("Special_Notes")!=null&&!"".equals((String) installedBaseJson.get("Special_Notes"))){
					special_Notes= (String) installedBaseJson.get("Special_Notes");
				}
				if((String) installedBaseJson.get("Installed_at")!=null&&!"".equals((String) installedBaseJson.get("Installed_at"))){
					installed_at= (String) installedBaseJson.get("Installed_at");
				}
				if((String) installedBaseJson.get("MACHINE_DESCRIPTION")!=null&&!"".equals((String) installedBaseJson.get("MACHINE_DESCRIPTION"))){
					mACHINE_DESCRIPTION= (String) installedBaseJson.get("MACHINE_DESCRIPTION");
				}
				if((String) installedBaseJson.get("MANUFACTURER")!=null&&!"".equals((String) installedBaseJson.get("MANUFACTURER"))){
					mANUFACTURER= (String) installedBaseJson.get("MANUFACTURER");
				}
				if((String) installedBaseJson.get("OPERATING_PERCENTAJE")!=null&&!"".equals((String) installedBaseJson.get("OPERATING_PERCENTAJE"))){
					oPERATING_PERCENTAJE= (String) installedBaseJson.get("OPERATING_PERCENTAJE");
				}
				if((String) installedBaseJson.get("COMMENTS_if_any_OWNER")!=null&&!"".equals((String) installedBaseJson.get("COMMENTS_if_any_OWNER"))){
					cOMMENTS_if_any_OWNER= (String) installedBaseJson.get("COMMENTS_if_any_OWNER");
				}
				if((String) installedBaseJson.get("SpecNo")!=null&&!"".equals((String) installedBaseJson.get("SpecNo"))){
					specNo= (String) installedBaseJson.get("SpecNo");
				}
				if((String) installedBaseJson.get("Service_File_No")!=null&&!"".equals((String) installedBaseJson.get("Service_File_No"))){
					service_File_No= (String) installedBaseJson.get("Service_File_No");
				}
				if((String) installedBaseJson.get("CP")!=null&&!"".equals((String) installedBaseJson.get("CP"))){
					cP= (String) installedBaseJson.get("CP");
				}
				if((String) installedBaseJson.get("Cool_SysecNo")!=null&&!"".equals((String) installedBaseJson.get("Cool_SysecNo"))){
					cool_SysecNo= (String) installedBaseJson.get("Cool_SysecNo");
				}
				if((String) installedBaseJson.get("Date_of_Op_Hrs")!=null&&!"".equals((String) installedBaseJson.get("Date_of_Op_Hrs"))){
					date_of_Op_Hrs= (String) installedBaseJson.get("Date_of_Op_Hrs");
				}
				if((String) installedBaseJson.get("Engine_Quantity")!=null&&!"".equals((String) installedBaseJson.get("Engine_Quantity"))){
					engine_Quantity= (String) installedBaseJson.get("Engine_Quantity");
				}
				if((String) installedBaseJson.get("Sector")!=null&&!"".equals((String) installedBaseJson.get("Sector"))){
					sector= (String) installedBaseJson.get("Sector");
				}
				if((String) installedBaseJson.get("Air_Fuel_Ratio")!=null&&!"".equals((String) installedBaseJson.get("Air_Fuel_Ratio"))){
					air_Fuel_Ratio= (String) installedBaseJson.get("Air_Fuel_Ratio");
				}
				if((String) installedBaseJson.get("Catalyst")!=null&&!"".equals((String) installedBaseJson.get("Catalyst"))){
					catalyst= (String) installedBaseJson.get("Catalyst");
				}
				if((String) installedBaseJson.get("Compressor")!=null&&!"".equals((String) installedBaseJson.get("Compressor"))){
					compressor= (String) installedBaseJson.get("Compressor");
				}
				if((String) installedBaseJson.get("Engine_Facility_Name")!=null&&!"".equals((String) installedBaseJson.get("Engine_Facility_Name"))){
					engine_Facility_Name= (String) installedBaseJson.get("Engine_Facility_Name");
				}
				if((String) installedBaseJson.get("Generator_Set")!=null&&!"".equals((String) installedBaseJson.get("Generator_Set"))){
					generator_Set= (String) installedBaseJson.get("Generator_Set");
				}
				if((String) installedBaseJson.get("HP")!=null&&!"".equals((String) installedBaseJson.get("HP"))){
					hP= (String) installedBaseJson.get("HP");
				}
				if((String) installedBaseJson.get("Ignition_Type")!=null&&!"".equals((String) installedBaseJson.get("Ignition_Type"))){
					ignition_Type= (String) installedBaseJson.get("Ignition_Type");
				}
				if((String) installedBaseJson.get("Last_Maintenance_Date")!=null&&!"".equals((String) installedBaseJson.get("Last_Maintenance_Date"))){
					last_Maintenance_Date= (String) installedBaseJson.get("Last_Maintenance_Date");
				}
				if((String) installedBaseJson.get("Overhaul_Date")!=null&&!"".equals((String) installedBaseJson.get("Overhaul_Date"))){
					overhaul_Date= (String) installedBaseJson.get("Overhaul_Date");
				}
				if((String) installedBaseJson.get("Packager")!=null&&!"".equals((String) installedBaseJson.get("Packager"))){
					packager= (String) installedBaseJson.get("Packager");
				}
				if((String) installedBaseJson.get("Permit_Number")!=null&&!"".equals((String) installedBaseJson.get("Permit_Number"))){
					permit_Number= (String) installedBaseJson.get("Permit_Number");
				}
				if((String) installedBaseJson.get("Permit_Year")!=null&&!"".equals((String) installedBaseJson.get("Permit_Year"))){
					permit_Year= (String) installedBaseJson.get("Permit_Year");
				}
				if((String) installedBaseJson.get("Turbocharger_Model")!=null&&!"".equals((String) installedBaseJson.get("Turbocharger_Model"))){
					turbocharger_Model= (String) installedBaseJson.get("Turbocharger_Model");
				}
				if((String) installedBaseJson.get("Driven_Equipment1")!=null&&!"".equals((String) installedBaseJson.get("Driven_Equipment1"))){
					driven_Equipment1= (String) installedBaseJson.get("Driven_Equipment1");
				}
				if((String) installedBaseJson.get("Fuel_Type1")!=null&&!"".equals((String) installedBaseJson.get("Fuel_Type1"))){
					fuel_Type1= (String) installedBaseJson.get("Fuel_Type1");
				}
				if((String) installedBaseJson.get("Line")!=null&&!"".equals((String) installedBaseJson.get("Line"))){
					line= (String) installedBaseJson.get("Line");
				}
				if((String) installedBaseJson.get("JFE_Site_No")!=null&&!"".equals((String) installedBaseJson.get("JFE_Site_No"))){
					jFE_Site_No= (String) installedBaseJson.get("JFE_Site_No");
				}
				if((String) installedBaseJson.get("Area")!=null&&!"".equals((String) installedBaseJson.get("Area"))){
					area= (String) installedBaseJson.get("Area");
				}
				if((String) installedBaseJson.get("TBL_IB_Region1")!=null&&!"".equals((String) installedBaseJson.get("TBL_IB_Region1"))){
					tBL_IB_Region1= (String) installedBaseJson.get("TBL_IB_Region1");
				}
				if((String) installedBaseJson.get("Startup")!=null&&!"".equals((String) installedBaseJson.get("Startup"))){
					startup= (String) installedBaseJson.get("Startup");
				}
				if((String) installedBaseJson.get("Ship_Date")!=null&&!"".equals((String) installedBaseJson.get("Ship_Date"))){
					ship_Date= (String) installedBaseJson.get("Ship_Date");
				}
				if((String) installedBaseJson.get("Year")!=null&&!"".equals((String) installedBaseJson.get("Year"))){
					year= (String) installedBaseJson.get("Year");
				}
				if((String) installedBaseJson.get("Go_Region")!=null&&!"".equals((String) installedBaseJson.get("Go_Region"))){
					gGO_Region = (String) installedBaseJson.get("Go_Region");
				}
				if((String) installedBaseJson.get("OraclePartyNumber")!=null&&!"".equals((String) installedBaseJson.get("OraclePartyNumber"))){
					oraclePartyNumber= (String) installedBaseJson.get("OraclePartyNumber");
				}
				if((String) installedBaseJson.get("Field0")!=null&&!"".equals((String) installedBaseJson.get("Field0"))){
					field0 = (String) installedBaseJson.get("Field0");
				}
				if((String) installedBaseJson.get("Expr1")!=null&&!"".equals((String) installedBaseJson.get("Expr1"))){
					expr1= (String) installedBaseJson.get("Expr1");
				}
				if((String) installedBaseJson.get("Expr2")!=null&&!"".equals((String) installedBaseJson.get("Expr2"))){
					expr2= (String) installedBaseJson.get("Expr2");
				}
				if((String) installedBaseJson.get("Expr3")!=null&&!"".equals((String) installedBaseJson.get("Expr3"))){
					expr3= (String) installedBaseJson.get("Expr3");
				}
				if((String) installedBaseJson.get("Expr4")!=null&&!"".equals((String) installedBaseJson.get("Expr4"))){
					expr4 = (String) installedBaseJson.get("Expr4");
				}
				
				if (installedBaseJson.get("Field1") != null
						&& !"".equals(installedBaseJson.get("Field1"))) {
					field1 = Long.valueOf((String) installedBaseJson.get("Field1"));
				}
				LOG.info("inserting into table values");
				InstalledBase installedbase=new InstalledBase(id, distributor_Date, distributor, tBL_IB_Serial_or_Order, family, model, cylinders, lean_or_Rich_Burn, power_BHP, branch, branch_Address, branch_City, branch_State, branch_Country, owner, owner_Address, owner_City, owner_State, owner_Country, owner_Post_Code, site_Name, site_Address, site_City, site_State, site_Country, site_Post_Code, site_Longitude, site_Latitude, region, engine_Market, driven_Equipment, driven_Equipment_Model, engine_Application, fuel_Type, lC_Model, notes, customer_Tag, status, duty, eQUIPMENT_STATUS, rPM, load, hours_per_Year, engine_Location_Area, contact_name, contact_Email, phone_Number, distributor_Maintenance_Agreement, engine_Hrs_of_Last_Top_Overhaul, date_Performed, engine_Hrs_of_Last_Bottom_Overhaul, date_Performed_Last, current_Engine_Hours, date_Verified, engine_Modified_Yes_No, if_Yes_please_explain_modification, other_Distributor_Info, startup_Year, special_Notes, installed_at, mACHINE_DESCRIPTION, mANUFACTURER, oPERATING_PERCENTAJE, cOMMENTS_if_any_OWNER, specNo, service_File_No, cP, cool_SysecNo, date_of_Op_Hrs, engine_Quantity, sector, air_Fuel_Ratio, catalyst, compressor, engine_Facility_Name, generator_Set, hP, ignition_Type, last_Maintenance_Date, overhaul_Date, packager, permit_Number, permit_Year, turbocharger_Model, driven_Equipment1, fuel_Type1, line, jFE_Site_No, area, tBL_IB_Region1, startup, ship_Date, year, gGO_Region, oraclePartyNumber, field0, expr1, expr2, expr3, expr4, field1);

				Transaction tx=session.beginTransaction();
				session.save(installedbase);		
				tx.commit();		

				System.out.println("installedbase with Id " + (id) + " successfully  added");

			}
			
		
	   }
	@RequestMapping("/installedbase")
	public String getService() {
		return "Welcome to Micro Services";
	}


	@RequestMapping(value="/getinstalledbaseList", method = RequestMethod.GET,produces={"application/json", "application/xml"}, headers="Accept=application/json,application/xml")
	public @ResponseBody InstalledBaseList getAllLifecycles() {
		LOG.info("ingetAllBooks()");
		Query query = session.createQuery("FROM InstalledBase");

		List<InstalledBase> list=query.list();
		
		ArrayList<InstalledBase> alist = new ArrayList<InstalledBase>();
		for(InstalledBase array:list){
			InstalledBase b=new InstalledBase();
			b.setId(array.getId());
			b.setAir_Fuel_Ratio(array.getAir_Fuel_Ratio());
			b.setArea(array.getArea());
			b.setBranch(array.getBranch());
			b.setBranch_Address(array.getBranch_Address());
			b.setBranch_City(array.getBranch_City());
			b.setBranch_Country(array.getBranch_Country());
			b.setBranch_State(array.getBranch_State());
			b.setCatalyst(array.getCatalyst());
			b.setcOMMENTS_if_any_OWNER(array.getcOMMENTS_if_any_OWNER());
			b.setCompressor(array.getCompressor());
			b.setContact_Email(array.getContact_Email());
			b.setContact_name(array.getContact_name());
			b.setCool_SysecNo(array.getCool_SysecNo());
			b.setcP(array.getcP());
			b.setCurrent_Engine_Hours(array.getCurrent_Engine_Hours());
			b.setCustomer_Tag(array.getCustomer_Tag());
			b.setDate_of_Op_Hrs(array.getDate_of_Op_Hrs());
			b.setDate_Performed(array.getDate_Performed());
			b.setDate_Performed_Last(array.getDate_Performed_Last());
			b.setDate_Verified(array.getDate_Verified());
			b.setDistributor(array.getDistributor());
			b.setDistributor_Date(array.getDistributor_Date());
			b.setDistributor_Maintenance_Agreement(array.getDistributor_Maintenance_Agreement());
			b.setDriven_Equipment(array.getDriven_Equipment());
			b.setDriven_Equipment1(array.getDriven_Equipment1());
			b.setDriven_Equipment_Model(array.getDriven_Equipment_Model());
			b.setDuty(array.getDuty());
			b.setEngine_Application(array.getEngine_Application());
			b.setEngine_Facility_Name(array.getEngine_Facility_Name());
			b.setEngine_Hrs_of_Last_Bottom_Overhaul(array.getEngine_Hrs_of_Last_Bottom_Overhaul());
			b.setEngine_Hrs_of_Last_Top_Overhaul(array.getEngine_Hrs_of_Last_Top_Overhaul());
			b.setEngine_Location_Area(array.getEngine_Location_Area());
			b.setEngine_Market(array.getEngine_Market());
			b.setEngine_Modified_Yes_No(array.getEngine_Modified_Yes_No());
			b.setEngine_Quantity(array.getEngine_Quantity());
			b.seteQUIPMENT_STATUS(array.geteQUIPMENT_STATUS());
			b.setExpr1(array.getExpr1());
			b.setExpr2(array.getExpr2());
			b.setExpr3(array.getExpr3());
			b.setExpr4(array.getExpr4());
			b.setFamily(array.getFamily());
			b.setField0(array.getField0());
			b.setField1(array.getField1());
			b.setFuel_Type(array.getFuel_Type());
			b.setFuel_Type1(array.getFuel_Type1());
			b.setjFE_Site_No(array.getjFE_Site_No());
			b.setGenerator_Set(array.getGenerator_Set());
			b.setgGO_Region(array.getgGO_Region());
			b.setHours_per_Year(array.getHours_per_Year());
			b.sethP(array.gethP());
			b.setIf_Yes_please_explain_modification(array.getIf_Yes_please_explain_modification());
			b.setIgnition_Type(array.getIgnition_Type());
			b.setInstalled_at(array.getInstalled_at());
			b.setLast_Maintenance_Date(array.getLast_Maintenance_Date());
			b.setlC_Model(array.getlC_Model());
			b.setLean_or_Rich_Burn(array.getLean_or_Rich_Burn());
			b.setLine(array.getLine());
			b.setLoad(array.getLoad());
			b.setmACHINE_DESCRIPTION(array.getmACHINE_DESCRIPTION());
			b.setmANUFACTURER(array.getmANUFACTURER());
			b.setModel(array.getModel());
			b.setNotes(array.getNotes());
			b.setoPERATING_PERCENTAJE(array.getoPERATING_PERCENTAJE());
			b.setOraclePartyNumber(array.getOraclePartyNumber());
			b.setOther_Distributor_Info(array.getOther_Distributor_Info());
			b.setOverhaul_Date(array.getOverhaul_Date());
			b.setOwner(array.getOwner());
			b.setOwner_Address(array.getOwner_Address());
			b.setOwner_City(array.getOwner_City());
			b.setOwner_Country(array.getOwner_Country());
			b.setOwner_Post_Code(array.getOwner_Post_Code());
			b.setOwner_State(array.getOwner_State());
			b.setPackager(array.getPackager());
			b.setPermit_Number(array.getPermit_Number());
			b.setPermit_Year(array.getPermit_Year());
			b.setPower_BHP(array.getPower_BHP());
			b.setRegion(array.getRegion());
			b.setrPM(array.getrPM());
			b.setSector(array.getSector());
			b.setService_File_No(array.getService_File_No());
			b.setShip_Date(array.getShip_Date());
			b.setSite_Address(array.getSite_Address());
			b.setSite_City(array.getSite_City());
			b.setSite_Country(array.getSite_Country());
			b.setSite_Latitude(array.getSite_Latitude());
			b.setSite_Longitude(array.getSite_Longitude());
			b.setSite_Name(array.getSite_Name());
			b.setSite_Post_Code(array.getSite_Post_Code());
			b.setSite_State(array.getSite_State());
			b.settBL_IB_Region1(array.gettBL_IB_Region1());
			b.settBL_IB_Serial_or_Order(array.gettBL_IB_Serial_or_Order());
			b.setTurbocharger_Model(array.getTurbocharger_Model());
			b.setYear(array.getYear());
			
			
			
			alist.add(b);
		}

		InstalledBaseList elist=new InstalledBaseList(alist);
		return elist;
	}

	@RequestMapping(value="/getInstalledBase/{owner}", method = RequestMethod.GET,produces={"application/json", "application/xml"}, headers="Accept=application/xml, application/json")
	public @ResponseBody InstalledBaseList getinstalledBaseOwner(@PathVariable(value="owner") String owner) {
		LOG.info("in  getLifecyclemodel:::::::");
		Query query = session.createQuery("FROM InstalledBase");
		List<InstalledBase> list=query.list();
		InstalledBase b=new InstalledBase();
		List<InstalledBase> newList = new ArrayList<InstalledBase>();
		for(InstalledBase array:list){
			LOG.info("array values:::::::"+array);
			if(array.getOwner().equals(owner))
			{
				b.setId(array.getId());
				b.setAir_Fuel_Ratio(array.getAir_Fuel_Ratio());
				b.setArea(array.getArea());
				b.setBranch(array.getBranch());
				b.setBranch_Address(array.getBranch_Address());
				b.setBranch_City(array.getBranch_City());
				b.setBranch_Country(array.getBranch_Country());
				b.setBranch_State(array.getBranch_State());
				b.setCatalyst(array.getCatalyst());
				b.setcOMMENTS_if_any_OWNER(array.getcOMMENTS_if_any_OWNER());
				b.setCompressor(array.getCompressor());
				b.setContact_Email(array.getContact_Email());
				b.setContact_name(array.getContact_name());
				b.setCool_SysecNo(array.getCool_SysecNo());
				b.setcP(array.getcP());
				b.setCurrent_Engine_Hours(array.getCurrent_Engine_Hours());
				b.setCustomer_Tag(array.getCustomer_Tag());
				b.setDate_of_Op_Hrs(array.getDate_of_Op_Hrs());
				b.setDate_Performed(array.getDate_Performed());
				b.setDate_Performed_Last(array.getDate_Performed_Last());
				b.setDate_Verified(array.getDate_Verified());
				b.setDistributor(array.getDistributor());
				b.setDistributor_Date(array.getDistributor_Date());
				b.setDistributor_Maintenance_Agreement(array.getDistributor_Maintenance_Agreement());
				b.setDriven_Equipment(array.getDriven_Equipment());
				b.setDriven_Equipment1(array.getDriven_Equipment1());
				b.setDriven_Equipment_Model(array.getDriven_Equipment_Model());
				b.setDuty(array.getDuty());
				b.setEngine_Application(array.getEngine_Application());
				b.setEngine_Facility_Name(array.getEngine_Facility_Name());
				b.setEngine_Hrs_of_Last_Bottom_Overhaul(array.getEngine_Hrs_of_Last_Bottom_Overhaul());
				b.setEngine_Hrs_of_Last_Top_Overhaul(array.getEngine_Hrs_of_Last_Top_Overhaul());
				b.setEngine_Location_Area(array.getEngine_Location_Area());
				b.setEngine_Market(array.getEngine_Market());
				b.setEngine_Modified_Yes_No(array.getEngine_Modified_Yes_No());
				b.setEngine_Quantity(array.getEngine_Quantity());
				b.seteQUIPMENT_STATUS(array.geteQUIPMENT_STATUS());
				b.setExpr1(array.getExpr1());
				b.setExpr2(array.getExpr2());
				b.setExpr3(array.getExpr3());
				b.setExpr4(array.getExpr4());
				b.setFamily(array.getFamily());
				b.setField0(array.getField0());
				b.setField1(array.getField1());
				b.setFuel_Type(array.getFuel_Type());
				b.setFuel_Type1(array.getFuel_Type1());
				b.setjFE_Site_No(array.getjFE_Site_No());
				b.setGenerator_Set(array.getGenerator_Set());
				b.setgGO_Region(array.getgGO_Region());
				b.setHours_per_Year(array.getHours_per_Year());
				b.sethP(array.gethP());
				b.setIf_Yes_please_explain_modification(array.getIf_Yes_please_explain_modification());
				b.setIgnition_Type(array.getIgnition_Type());
				b.setInstalled_at(array.getInstalled_at());
				b.setLast_Maintenance_Date(array.getLast_Maintenance_Date());
				b.setlC_Model(array.getlC_Model());
				b.setLean_or_Rich_Burn(array.getLean_or_Rich_Burn());
				b.setLine(array.getLine());
				b.setLoad(array.getLoad());
				b.setmACHINE_DESCRIPTION(array.getmACHINE_DESCRIPTION());
				b.setmANUFACTURER(array.getmANUFACTURER());
				b.setModel(array.getModel());
				b.setNotes(array.getNotes());
				b.setoPERATING_PERCENTAJE(array.getoPERATING_PERCENTAJE());
				b.setOraclePartyNumber(array.getOraclePartyNumber());
				b.setOther_Distributor_Info(array.getOther_Distributor_Info());
				b.setOverhaul_Date(array.getOverhaul_Date());
				b.setOwner(array.getOwner());
				b.setOwner_Address(array.getOwner_Address());
				b.setOwner_City(array.getOwner_City());
				b.setOwner_Country(array.getOwner_Country());
				b.setOwner_Post_Code(array.getOwner_Post_Code());
				b.setOwner_State(array.getOwner_State());
				b.setPackager(array.getPackager());
				b.setPermit_Number(array.getPermit_Number());
				b.setPermit_Year(array.getPermit_Year());
				b.setPower_BHP(array.getPower_BHP());
				b.setRegion(array.getRegion());
				b.setrPM(array.getrPM());
				b.setSector(array.getSector());
				b.setService_File_No(array.getService_File_No());
				b.setShip_Date(array.getShip_Date());
				b.setSite_Address(array.getSite_Address());
				b.setSite_City(array.getSite_City());
				b.setSite_Country(array.getSite_Country());
				b.setSite_Latitude(array.getSite_Latitude());
				b.setSite_Longitude(array.getSite_Longitude());
				b.setSite_Name(array.getSite_Name());
				b.setSite_Post_Code(array.getSite_Post_Code());
				b.setSite_State(array.getSite_State());
				b.settBL_IB_Region1(array.gettBL_IB_Region1());
				b.settBL_IB_Serial_or_Order(array.gettBL_IB_Serial_or_Order());
				b.setTurbocharger_Model(array.getTurbocharger_Model());
				b.setYear(array.getYear());
				newList.add(b);
			}
		}
		InstalledBaseList list1 = new InstalledBaseList();
		list1.setLifecycle(newList);
		LOG.info("lifeycle values::"+newList);
		return list1;
	}

	/*@RequestMapping(value="/addBook", method = RequestMethod.POST,consumes={"application/json", "application/xml"}, produces={"text/plain"})
	public @ResponseBody String addBook(@RequestBody Lifecycle b) {

		
			Lifecycle book=new Lifecycle(b.getId(),b.getName(),b.getAuthor(),b.getPrice());

			Transaction tx=session.beginTransaction();
			session.save(book);		
			tx.commit();		

			System.out.println("Book with Id " + (id) + " successfully  added");
		
		return "Book with Id " + (id+1) + " successfully  added";

	}*/
	public static String readFile(String filename) {
		String result = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			result = sb.toString();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public static File convertCSVtoJson() throws Exception {
		File input = new File("installed_base_data.csv");
		File output = new File("installed_base_data.json");

		List<Map<?, ?>> data = readObjectsFromCsv(input);
		writeAsJson(data, output);
		return output;
	}

	public static List<Map<?, ?>> readObjectsFromCsv(File file) throws IOException {
		CsvSchema bootstrap = CsvSchema.emptySchema().withHeader();
		CsvMapper csvMapper = new CsvMapper();
		MappingIterator<Map<?, ?>> mappingIterator = csvMapper.reader(Map.class).with(bootstrap).readValues(file);

		return mappingIterator.readAll();
	}

	public static void writeAsJson(List<Map<?, ?>> data, File file) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(file, data);
	}



}
