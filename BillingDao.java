package genpact.pmr.start.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import genpact.pmr.start.dto.BillingChartDto;
import genpact.pmr.start.dto.BillingTableDataDto;
import genpact.pmr.start.dto.BillingTimeGraphDTO;
import genpact.pmr.start.dto.BillingTimelineDTO;
import genpact.pmr.start.dto.BillingTotalJsonDTO;
import genpact.pmr.start.dto.BillingValueTotalDTO;
import genpact.pmr.start.dto.FormatDataDto;

@Repository
public class BillingDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
    long billSum = 0; 
	public List<BillingTableDataDto> getTotalBillingTableData(String str,String region,String project_manager,String project_id,int lowerLimit,int upperLimit) {
		List<BillingTableDataDto> billingTableDataDtos;
			/*String sql = "select * from billingdata "+str;*/
		    String sql = null;
		     if(str == "")
		    	  sql = "select * from (select row_number() over() as rownumber, * from billingdata) x where x.rownumber between " + lowerLimit + " and "+ upperLimit;
		     else
		    	 sql = "select *,(select count(*) from billingdata " +str+ ") as counter from (select row_number() over() as rownumber, * from billingdata "+ str +" ) x  where x.rownumber between " + lowerLimit + " and "+ upperLimit;
			
		     //System.out.println("sql:::::"+sql);
		     billingTableDataDtos = jdbcTemplate.query(sql, new BillingTableRowMapper());
		
		     
		     
		return billingTableDataDtos;
	}
	
	
	public long getTableCounter(String str) {
		String sql = "";
			if(str == null){
				sql = "select count(project_id)  as counter from billingdata";
			}
			else{
				sql = "select count(project_id)  as counter from billingdata "+str;
			}
		return jdbcTemplate.query(sql, new ResultSetExtractor<Long>() {
			@Override
			public Long extractData(ResultSet rs) throws SQLException, DataAccessException {
				long counter = 0;
				if (rs.next())
					counter = rs.getLong("counter");
				return counter;
			}
		});
		//return totalbill;
	}
	
	public List<FormatDataDto> getRegions(){
		List<FormatDataDto> formatDataDtos = null;
		String sql = "select distinct(region) from billingdata";
		formatDataDtos = jdbcTemplate.query(sql, new RowMapper<FormatDataDto>() {
			int counter;
			public FormatDataDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new FormatDataDto(++counter, rs.getString("region"));
			}
		});
		return formatDataDtos;
	}
	
	public List<FormatDataDto> getProjetManagers(String region){
		String segment = "select distinct(project_manager) from billingdata where region in ( ";
		segment += createSql(region);
		segment += ")";
		List<FormatDataDto> formatDataDtos = jdbcTemplate.query(segment, new RowMapper<FormatDataDto>() {
			int counter;
			public FormatDataDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new FormatDataDto(++counter, rs.getString("project_manager"));
			}
		});
		return formatDataDtos;
	}
	
	public List<FormatDataDto> getProjectIds(String region,String project_manager){
		String segment = "select distinct(project_id) from billingdata where region in (";
		segment += createSql(region);
		segment += ") and project_manager in (";
		segment += createSql(project_manager);
		segment += ")";
		List<FormatDataDto> formatDataDtos = jdbcTemplate.query(segment, new RowMapper<FormatDataDto>() {
			int counter;

			public FormatDataDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new FormatDataDto(++counter, rs.getString("project_id"));
			}
		});

		return formatDataDtos;
	}
	
	public BillingTotalJsonDTO getTableDataBasedOnRange(String region,String project_manager,String project_id,String group){
				BillingTotalJsonDTO billingTotalJsonDTO = new BillingTotalJsonDTO();
				String sql = "" ;
				if(!region.equals("") && !project_manager.equals("") && !project_id.equals("")){
				if(group.equals("1 and 30")){
					////System.out.println("1 and 30--region5 project_manager5 project_id1");
					 sql = "select project_id,sold_to_party_name,sold_to_party_country,sales_order_number,billing_number,customer_po_no,billing_status,billing_date,due_date,billing_value,"
							 + "date_part('days', now() - to_date(due_date, 'dd-mon-yy')) as days from billingdata where date_part('days', now() - to_date(due_date, 'dd-mon-yy')) between "+ group +" and due_date <> '' "
							 + " and billing_status = 'A' and region in (" + createSql(region) + ") and project_manager in (" + createSql(project_manager) + ") and project_id in (" + createSql(project_id) + ")";
				}else if(group.equals("31 and 60")){
					////System.out.println("1 and 30--region5 project_manager5 project_id2");
					sql = "select project_id,sold_to_party_name,sold_to_party_country,sales_order_number,billing_number,customer_po_no,billing_status,billing_date,due_date,billing_value,"
							 + "date_part('days', now() - to_date(due_date, 'dd-mon-yy')) as days from billingdata where date_part('days', now() - to_date(due_date, 'dd-mon-yy')) between "+ group +" and due_date <> '' "
							 + " and billing_status = 'A' and region in (" + createSql(region) + ") and project_manager in (" + createSql(project_manager) + ") and project_id in (" + createSql(project_id) + ")";
				}else if(group.equals("61 and 90")){
					////System.out.println("1 and 30--region5 project_manager5 project_id3");
					sql = "select project_id,sold_to_party_name,sold_to_party_country,sales_order_number,billing_number,customer_po_no,billing_status,billing_date,due_date,billing_value,"
							 + "date_part('days', now() - to_date(due_date, 'dd-mon-yy')) as days from billingdata where date_part('days', now() - to_date(due_date, 'dd-mon-yy')) between "+ group +" and due_date <> '' "
							 		+ " and billing_status = 'A' and region in (" + createSql(region) + ") and project_manager in (" + createSql(project_manager) + ") and project_id in (" + createSql(project_id) + ")";
				}else if(group.equals("91 and 120")){
					//System.out.println("1 and 30--region5 project_manager5 project_id4");
					sql = "select project_id,sold_to_party_name,sold_to_party_country,sales_order_number,billing_number,customer_po_no,billing_status,billing_date,due_date,billing_value,"
							 + "date_part('days', now() - to_date(due_date, 'dd-mon-yy')) as days from billingdata where date_part('days', now() - to_date(due_date, 'dd-mon-yy')) between "+ group +" and due_date <> '' "
							 		+ " and billing_status = 'A' and region in (" + createSql(region) + ") and project_manager in (" + createSql(project_manager) + ") and project_id in (" + createSql(project_id) + ")";
				}else{
					////System.out.println("1 and 30--region5 project_manager5 project_id5");
					sql = "select project_id,sold_to_party_name,sold_to_party_country,sales_order_number,billing_number,customer_po_no,billing_status,billing_date,due_date,billing_value,"
							 + "date_part('days', now() - to_date(due_date, 'dd-mon-yy')) as days from billingdata where date_part('days', now() - to_date(due_date, 'dd-mon-yy')) >= 120 and due_date <> '' "
							 + " and billing_status = 'A' and region in (" + createSql(region) + ") and project_manager in (" + createSql(project_manager) + ") and project_id in (" + createSql(project_id) + ")";
				}
			}else if(!region.equals("") && !project_manager.equals("")){
					if(group.equals("1 and 30")){
						////System.out.println("1 and 30--region5 project_manager1");
						 sql = "select project_id,sold_to_party_name,sold_to_party_country,sales_order_number,billing_number,customer_po_no,billing_status,billing_date,due_date,billing_value,"
								 + "date_part('days', now() - to_date(due_date, 'dd-mon-yy')) as days from billingdata where date_part('days', now() - to_date(due_date, 'dd-mon-yy')) between "+ group +" and due_date <> '' "
								 + " and billing_status = 'A' and region in (" + createSql(region) + ") and project_manager in (" + createSql(project_manager) + ")";
					}else if(group.equals("31 and 60")){
						////System.out.println("1 and 30--region5 project_manager2");
						sql = "select project_id,sold_to_party_name,sold_to_party_country,sales_order_number,billing_number,customer_po_no,billing_status,billing_date,due_date,billing_value,"
								 + "date_part('days', now() - to_date(due_date, 'dd-mon-yy')) as days from billingdata where date_part('days', now() - to_date(due_date, 'dd-mon-yy')) between "+ group +" and due_date <> '' "
								 + " and billing_status = 'A' and region in (" + createSql(region) + ") and project_manager in (" + createSql(project_manager) + ")";
					}else if(group.equals("61 and 90")){
						////System.out.println("1 and 30--region5 project_manager3");
						sql = "select project_id,sold_to_party_name,sold_to_party_country,sales_order_number,billing_number,customer_po_no,billing_status,billing_date,due_date,billing_value,"
								 + "date_part('days', now() - to_date(due_date, 'dd-mon-yy')) as days from billingdata where date_part('days', now() - to_date(due_date, 'dd-mon-yy')) between "+ group +" and due_date <> '' "
								 		+ " and billing_status = 'A' and region in (" + createSql(region) + ") and project_manager in (" + createSql(project_manager) + ")";
					}else if(group.equals("91 and 120")){
						////System.out.println("1 and 30--region5 project_manager4");
						sql = "select project_id,sold_to_party_name,sold_to_party_country,sales_order_number,billing_number,customer_po_no,billing_status,billing_date,due_date,billing_value,"
								 + "date_part('days', now() - to_date(due_date, 'dd-mon-yy')) as days from billingdata where date_part('days', now() - to_date(due_date, 'dd-mon-yy')) between "+ group +" and due_date <> '' "
								 		+ " and billing_status = 'A' and region in (" + createSql(region) + ") and project_manager in (" + createSql(project_manager) + ")";
					}else{
						////System.out.println("1 and 30--region5 project_manager5");
						sql = "select project_id,sold_to_party_name,sold_to_party_country,sales_order_number,billing_number,customer_po_no,billing_status,billing_date,due_date,billing_value,"
								 + "date_part('days', now() - to_date(due_date, 'dd-mon-yy')) as days from billingdata where date_part('days', now() - to_date(due_date, 'dd-mon-yy')) >= 120 and due_date <> '' "
								 + " and billing_status = 'A' and region in (" + createSql(region) + ") and project_manager in (" + createSql(project_manager) + ")";
			}
			}else if(!region.equals("")){
				if(group.equals("1 and 30")){
				////System.out.println("1 and 30--region1");
				 sql = "select project_id,sold_to_party_name,sold_to_party_country,sales_order_number,billing_number,customer_po_no,billing_status,billing_date,due_date,billing_value,"
						 + "date_part('days', now() - to_date(due_date, 'dd-mon-yy')) as days from billingdata where date_part('days', now() - to_date(due_date, 'dd-mon-yy')) between "+ group +" and due_date <> '' "
						 + " and billing_status = 'A' and region in (" + createSql(region) + ")";
			}else if(group.equals("31 and 60")){
				////System.out.println("1 and 30--region2");
				sql = "select project_id,sold_to_party_name,sold_to_party_country,sales_order_number,billing_number,customer_po_no,billing_status,billing_date,due_date,billing_value,"
						 + "date_part('days', now() - to_date(due_date, 'dd-mon-yy')) as days from billingdata where date_part('days', now() - to_date(due_date, 'dd-mon-yy')) between "+ group +" and due_date <> '' "
						 + " and billing_status = 'A' and region in (" + createSql(region) + ")";
			}else if(group.equals("61 and 90")){
				//System.out.println("1 and 30--region3");
				sql = "select project_id,sold_to_party_name,sold_to_party_country,sales_order_number,billing_number,customer_po_no,billing_status,billing_date,due_date,billing_value,"
						 + "date_part('days', now() - to_date(due_date, 'dd-mon-yy')) as days from billingdata where date_part('days', now() - to_date(due_date, 'dd-mon-yy')) between "+ group +" and due_date <> '' "
						 		+ " and billing_status = 'A' and region in (" + createSql(region) + ")";
			}else if(group.equals("91 and 120")){
				//System.out.println("1 and 30--region4");
				sql = "select project_id,sold_to_party_name,sold_to_party_country,sales_order_number,billing_number,customer_po_no,billing_status,billing_date,due_date,billing_value,"
						 + "date_part('days', now() - to_date(due_date, 'dd-mon-yy')) as days from billingdata where date_part('days', now() - to_date(due_date, 'dd-mon-yy')) between "+ group +" and due_date <> '' "
						 		+ " and billing_status = 'A' and region in (" + createSql(region) + ")";
			}else{
				//System.out.println("1 and 30--region5");
				sql = "select project_id,sold_to_party_name,sold_to_party_country,sales_order_number,billing_number,customer_po_no,billing_status,billing_date,due_date,billing_value,"
						 + "date_part('days', now() - to_date(due_date, 'dd-mon-yy')) as days from billingdata where date_part('days', now() - to_date(due_date, 'dd-mon-yy')) >= 120 and due_date <> '' "
						 + " and billing_status = 'A' and region in (" + createSql(region) + ")";
			}
			
			}else{
				if(group.equals("1 and 30")){
					 sql = "select project_id,sold_to_party_name,sold_to_party_country,sales_order_number,billing_number,customer_po_no,billing_status,billing_date,due_date,billing_value,"
							 + "date_part('days', now() - to_date(due_date, 'dd-mon-yy')) as days from billingdata where date_part('days', now() - to_date(due_date, 'dd-mon-yy')) between " + group +"  and billing_status = 'A' and due_date <> '' ";
				}else if(group.equals("31 and 60")){
					sql = "select project_id,sold_to_party_name,sold_to_party_country,sales_order_number,billing_number,customer_po_no,billing_status,billing_date,due_date,billing_value,"
							 + "date_part('days', now() - to_date(due_date, 'dd-mon-yy')) as days from billingdata where date_part('days', now() - to_date(due_date, 'dd-mon-yy')) between " + group +"  and billing_status = 'A' and due_date <> '' ";
				}else if(group.equals("61 and 90")){
					sql = "select project_id,sold_to_party_name,sold_to_party_country,sales_order_number,billing_number,customer_po_no,billing_status,billing_date,due_date,billing_value,"
							 + "date_part('days', now() - to_date(due_date, 'dd-mon-yy')) as days from billingdata where date_part('days', now() - to_date(due_date, 'dd-mon-yy')) between " + group +"  and billing_status = 'A' and due_date <> '' ";
				}else if(group.equals("91 and 120")){
					sql = "select project_id,sold_to_party_name,sold_to_party_country,sales_order_number,billing_number,customer_po_no,billing_status,billing_date,due_date,billing_value,"
							 + "date_part('days', now() - to_date(due_date, 'dd-mon-yy')) as days from billingdata where date_part('days', now() - to_date(due_date, 'dd-mon-yy')) between " + group +"  and billing_status = 'A' and due_date <> '' ";
				}else{
					sql = "select project_id,sold_to_party_name,sold_to_party_country,sales_order_number,billing_number,customer_po_no,billing_status,billing_date,due_date,billing_value,"
							 + "date_part('days', now() - to_date(due_date, 'dd-mon-yy')) as days from billingdata where date_part('days', now() - to_date(due_date, 'dd-mon-yy')) >= 120  and billing_status = 'A' and due_date <> '' ";
				}
			}
					System.out.println(sql);
					List<BillingTableDataDto> billingTableDataDto = jdbcTemplate.query(sql, new RowMapper<BillingTableDataDto>() {
						public BillingTableDataDto mapRow(ResultSet resultSet, int rowCount) throws SQLException {
							BillingTableDataDto  billingTableData = new BillingTableDataDto();
							    billingTableData.setProject_id(resultSet.getString("project_id"));
							    billingTableData.setSold_to_party_name(resultSet.getString("sold_to_party_name"));
							    billingTableData.setSold_to_party_country(resultSet.getString("sold_to_party_country"));
							    billingTableData.setSales_order_number(resultSet.getString("sales_order_number"));
							    billingTableData.setBilling_number(resultSet.getLong("billing_number"));
							    billingTableData.setCustomer_po_no(resultSet.getString("customer_po_no"));
							    billingTableData.setBilling_status(resultSet.getString("billing_status"));
							    billingTableData.setBilling_date(resultSet.getString("billing_date"));
							    billingTableData.setDue_date(resultSet.getString("due_date"));
							    billingTableData.setBilling_value(resultSet.getLong("billing_value"));
								return billingTableData;
						}
					});

				BillingValueTotalDTO billingValueTotalDTO = new BillingValueTotalDTO();
				billingTotalJsonDTO.setBillingTableDataDto(billingTableDataDto);
				long billingTotal = 0;
				for(BillingTableDataDto list:billingTableDataDto){
					billingTotal+= list.getBilling_value();
					billingValueTotalDTO.setBillingtotal(billingTotal);
				}
				billingTotalJsonDTO.setBillingValueTotalDTO(billingValueTotalDTO);
		
		return billingTotalJsonDTO;
	}
	
	public Map<String,Long> getBillingPendingValuesMap(String str) {
		
		String sql = null;
		if(str.equals("")){
			sql = "select billing_value, billing_date,due_date from billingdata "+ str +" where billing_status = 'A' and due_date <> '' ";
		}else
		{
			sql = "select billing_value, billing_date,due_date from billingdata "+ str +" and billing_status = 'A' and due_date <> '' ";
		}
		
		
		List<BillingChartDto> billingChartDtos = jdbcTemplate.query(sql, new BillingPendingRowMapper());
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
		Date today = null;
		try {
			 today = dateFormat.parse(dateFormat.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date dueDate = null;
		List<String> days = new ArrayList<>();
		String []daysGroup={"1-30","31-60","61-90","91-120","120+"};
		Map<String,Long> billingValuesMap = new HashMap<>();
		Set<String> daysGroupSet = new HashSet<>();
		String key=null;
		int noOfDays =0;
		for (BillingChartDto bcd : billingChartDtos) {
			dueDate = new Date(bcd.getDueDate());
			 noOfDays = Days.daysBetween(new DateTime(dueDate),new DateTime(today)).getDays();
			 if(noOfDays > 0){
				 if(noOfDays >= 1 && noOfDays <= 30){
					 key=daysGroup[0];
				 }else if(noOfDays >= 31 && noOfDays <= 60){
					 key=daysGroup[1];
				 }else if(noOfDays >= 61 && noOfDays <= 90){
					 key=daysGroup[2];
				 }else  if(noOfDays >= 91 && noOfDays <= 120){
					 key=daysGroup[3];
				 }else  if(noOfDays > 120){
					 key=daysGroup[4];
				 }
			 if(daysGroupSet.add(key)){
				 billingValuesMap.put(key, bcd.getBilling_value());
				 
			 }else{
				 billingValuesMap.put(key,billingValuesMap.get(key) + bcd.getBilling_value());
			 }
		}
		}
		return billingValuesMap;
	}

	private static class BillingTableRowMapper implements RowMapper<BillingTableDataDto> {
		int count = 10000;
		 /*int fetchSize = 1000;*/
		public BillingTableDataDto mapRow(ResultSet resultSet, int rowCount) throws SQLException {
			return new BillingTableDataDto(++count, resultSet.getString("project_id"),
					resultSet.getString("sold_to_party_name"), resultSet.getString("sold_to_party_country"),
					resultSet.getString("sales_order_number"), resultSet.getLong("billing_number"),
					resultSet.getString("customer_po_no"), resultSet.getString("billing_status"),
					resultSet.getString("billing_date"), resultSet.getString("due_date"),
					resultSet.getLong("billing_value"));
		}
	}

	public List<BillingTimelineDTO> getBillingByTimeLine(String str,String group){
		List<BillingTimelineDTO> billingTimelineList = null;
		String sql = "";
		if(group.equals("yearly")){
			billSum = 0;
			 sql = "SELECT EXTRACT(YEAR FROM to_date(billing_date,'DD-Mon-YY')) AS billyear,sum(Billing_Value) as billsum from billingdata " + str + " group by billyear order by billyear ";
			 billingTimelineList = jdbcTemplate.query(sql, new RowMapper<BillingTimelineDTO>() {
					public BillingTimelineDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						billSum += rs.getLong("billsum");
						return new BillingTimelineDTO(billSum,rs.getString("billyear"));
					}
				});
		}
		else if(group.equals("monthly"))
		{
				 sql = "SELECT to_char(to_date(billing_date,'DD-Mon-YY'),'Month') AS billmonth,"
				 		+ "concat(EXTRACT(YEAR FROM to_date(billing_date,'DD-Mon-YY')),'-',to_char(to_date(billing_date,'DD-Mon-YY'),'Month')) AS yearmonth,"
				 		+ "EXTRACT(YEAR FROM to_date(billing_date,'DD-Mon-YY')) AS billyear,"
				 		+ "sum(Billing_Value) as billsum "
				 		+ "from billingdata " + str + " group by billmonth,billyear order by billyear";
				  billingTimelineList = jdbcTemplate.query(sql, new RowMapper<BillingTimelineDTO>() {
						public BillingTimelineDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
							return new BillingTimelineDTO(rs.getLong("billsum"),rs.getString("billyear"),rs.getString("billmonth").trim(),(rs.getString("billyear")+"-"+rs.getString("billmonth").trim()));
						}
					});
				  
				  Collections.sort(billingTimelineList,new DateComparator());
				
				  billSum=0;
				  for (int i = 0; i < billingTimelineList.size(); i++) {
					  BillingTimelineDTO billingTimelineDTO2 = billingTimelineList.get(i);
					  billingTimelineDTO2.setBillingDate(billingTimelineDTO2.getBillingDate()+"-"+billingTimelineDTO2.getBillmonth());
					  billSum += billingTimelineDTO2.getBillingValue();
					  billingTimelineDTO2.setBillingValue(billSum);
				}
			
		}
		else if(group.equals("quarterly"))
		{
			 billSum = 0;
			 sql = "SELECT  EXTRACT(MONTH FROM to_date(billing_date,'DD-Mon-YY'))  AS billmonth,"
			 		+ "EXTRACT(YEAR FROM to_date(billing_date,'DD-Mon-YY')) AS billyear,"
			 		+ "sum(Billing_Value) as billsum from billingdata " + str + " group by billmonth,billyear order by billyear";
			 
			  billingTimelineList = jdbcTemplate.query(sql, new RowMapper<BillingTimelineDTO>() {
					public BillingTimelineDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						return new BillingTimelineDTO(rs.getLong("billsum"),rs.getString("billyear"),rs.getString("billmonth"));
					}
				});
			  BillingTimeGraphDTO billingtimegraphdto = getBillingByTimeLineByquarterly(billingTimelineList);
			  billingTimelineList = new ArrayList<BillingTimelineDTO>();
			  
			  List<String> listofkeys = billingtimegraphdto.getxCordinatesList();
			  List<Long> listofvalues = billingtimegraphdto.getyCordinatesList();
			  for (int i = 0; i < listofkeys.size(); i++) {
				  BillingTimelineDTO billingTimelineDTO =new BillingTimelineDTO();
				  billingTimelineDTO.setBillingDate(listofkeys.get(i));
				  billingTimelineDTO.setBillingValue(listofvalues.get(i));
				  billingTimelineList.add(billingTimelineDTO);
			}
			  Collections.sort(billingTimelineList,new BillingDateComparator());
			  
			  billSum=0;
			  for (int i = 0; i < billingTimelineList.size(); i++) {
				  BillingTimelineDTO billingTimelineDTO2 = billingTimelineList.get(i);
				  billSum += billingTimelineDTO2.getBillingValue();
				  billingTimelineDTO2.setBillingValue(billSum);
			}
			  
		}
		return billingTimelineList;
	}

	private static class BillingPendingRowMapper implements RowMapper<BillingChartDto> {
		public BillingChartDto mapRow(ResultSet resultSet, int rowCount) throws SQLException {
			return new BillingChartDto(resultSet.getLong("billing_value"),resultSet.getString("billing_date"),resultSet.getString("due_date"));
		}
	}
	
	
	private BillingTimeGraphDTO getBillingByTimeLineByquarterly(List<BillingTimelineDTO> list){
		BillingTimeGraphDTO billingTimeGraphDTO = new BillingTimeGraphDTO();
		
		List<String> list_keys = new ArrayList<String>();
		List<Long> list_result = new ArrayList<Long>();
		
		for (int i = 0; i < list.size(); i++) {
			BillingTimelineDTO billingTimelineDTO = list.get(i);
			String quartername = getQuarterName(billingTimelineDTO.getBillingDate(),Integer.parseInt(billingTimelineDTO.getBillmonth()));
			if (list_keys.contains(quartername)) {
				int index = list_keys.indexOf(quartername);
				long result = list_result.get(index);
				list_result.set(index,result+billingTimelineDTO.getBillingValue());
			}
			else
			{
				list_keys.add(quartername);
				list_result.add(billingTimelineDTO.getBillingValue());				
			}

		}
		
		billingTimeGraphDTO.setxCordinatesList(list_keys);
		billingTimeGraphDTO.setyCordinatesList(list_result);
		
		return billingTimeGraphDTO;
	}
	


	public long getBillTotal(String str) {
		
		String sql = "select sum(billing_value) as totalbill from billingdata "+str;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Long>() {
			@Override
			public Long extractData(ResultSet rs) throws SQLException, DataAccessException {
				long totalbill = 0;
				if (rs.next())
					  totalbill = rs.getLong("totalbill");
				return totalbill;
			}
		});
		//return totalbill;
	}

	
	private String getQuarterName(String year,int month)
	{
		String quartername = year;
		if(month<=3)
		{
			quartername += "-Q1";
		}
		else if(month>3 && month<=6)
		{
			quartername += "-Q2";
		}
		else if(month>6 && month<=9)
		{
			quartername += "-Q3";
		}
		else
		{
			quartername += "-Q4";
		}
		return quartername;
	}
	
	
	class DateComparator implements Comparator{  
		public int compare(Object obj1,Object obj2){  
			BillingTimelineDTO billingTimelineDTO1 = (BillingTimelineDTO)obj1;  
			BillingTimelineDTO billingTimelineDTO2 = (BillingTimelineDTO)obj2;
			DateFormat df = new SimpleDateFormat("yyyy-MMM-dd");
			Date firstdate = new Date();
			try {
				firstdate = df.parse(billingTimelineDTO1.getBillingDate()+"-"+billingTimelineDTO1.getBillmonth().trim()+"-01");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			Date seconddate=new Date();
			try {
				seconddate = df.parse(billingTimelineDTO2.getBillingDate()+"-"+billingTimelineDTO2.getBillmonth().trim()+"-01");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		if(firstdate.getTime() == seconddate.getTime())  
			return 0;  
		else if(firstdate.getTime() > seconddate.getTime())  
			return 1;  
		else  
			return -1;  
		}  
		}  
	class BillingDateComparator implements Comparator{  
		public int compare(Object obj1,Object obj2){  
			BillingTimelineDTO billingTimelineDTO1 = (BillingTimelineDTO)obj1;  
			BillingTimelineDTO billingTimelineDTO2 = (BillingTimelineDTO)obj2;
			return billingTimelineDTO1.getBillingDate().compareTo(billingTimelineDTO2.getBillingDate());
		}
	}  
	
	private String getMonthName(String month){
		DateFormat df = new SimpleDateFormat("MM");
		Date date = new Date("01"+month+"1990");
		return df.format(date);
	}

	private String createSql(String str) {

		// if(str)
		String[] strArray = str.split(",");
		String seg = "";
		for (int i = 0; i <= strArray.length; i++) {
			seg += "'" + strArray[i] + "'";
			if ((i + 1) == strArray.length) {
				break;
			} else if (i < strArray.length) {
				seg += ",";
			}
		}
		return seg;
	}


}
