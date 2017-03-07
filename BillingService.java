package genpact.pmr.start.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import genpact.pmr.start.dao.BillingDao;
import genpact.pmr.start.dto.BillingJSONDataDto;
import genpact.pmr.start.dto.BillingTableDataDto;
import genpact.pmr.start.dto.BillingTimelineDTO;
import genpact.pmr.start.dto.BillingTotalJsonDTO;
import genpact.pmr.start.dto.ColourIndex;
import genpact.pmr.start.dto.FormatDataDto;
import genpact.pmr.start.dto.ProjectIdFilter;
import genpact.pmr.start.dto.ProjectManagerFilter;
import genpact.pmr.start.dto.RegionFilter;
import genpact.pmr.start.dto.RequestTradingFilter;
import genpact.pmr.start.dto.TableDataOnGroupFilter;

@CrossOrigin
@RestController
public class BillingService {

	/*@Autowired
	private JdbcTemplate jdbcTemplate;*/
	@Autowired
	private BillingDao billingDao;// just to check
	

	@RequestMapping(value = "/billing", method = RequestMethod.GET)
	public String msg() {
		// List<BillingChartDto> billingChartDtos =
		// billingDao.getBillingPending("");
		return "Billing Running Succesfully";
	}

	// To retrieve info
	@RequestMapping(value = "/getbilling", method = RequestMethod.GET)
	public BillingJSONDataDto getInfo() {
		String str = "";
		String granularity = "yearly";
		int lowerLimit = 1;
		int upperLimit = 100;
		BillingJSONDataDto billingJSONDataDto = new BillingJSONDataDto();
		List<FormatDataDto> formatDataDtos = billingDao.getRegions();
		
		//String sql = "select distinct(region) from billingdata";// ===============================
		List<BillingTableDataDto> billingTableDataDtos = billingDao.getTotalBillingTableData(str,null,null,null,lowerLimit,upperLimit);

		billingJSONDataDto.setBillingTableDataDtos(billingTableDataDtos);
		
		/*formatDataDtos = jdbcTemplate.query(sql, new RowMapper<FormatDataDto>() {
			int counter;
			public FormatDataDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new FormatDataDto(++counter, rs.getString("region"));
			}
		});*/
		
		billingJSONDataDto.setFormatDataDtos(formatDataDtos);
		Map<String, Long> billingValuesMap = billingDao.getBillingPendingValuesMap(str);
		List<Long> billing_values = getBillingValues(billingValuesMap);
		
		billingJSONDataDto.setBillingValues(billing_values);
		List<BillingTimelineDTO> list = billingDao.getBillingByTimeLine(str, granularity);
		billingJSONDataDto.setBillingTimelineDTOs(list);
		billingJSONDataDto.setBillingtotal(billingDao.getBillTotal(str));
		billingJSONDataDto.setCounter(billingDao.getTableCounter(str));
		billingJSONDataDto.setColourIndex(setcolorindex(granularity, list));
		return billingJSONDataDto;
	}
	
	
	private List<Long> getBillingValues(Map<String, Long> billingValuesMap) {
		
		String[] daysGroup = { "1-30", "31-60", "61-90", "91-120", "120+" };
		// List<String> billing_dates = new ArrayList<>();
		List<Long> billing_values = new ArrayList<>();// ===============
		for (String key : daysGroup) {
			billing_values.add(billingValuesMap.get(key));
		}
		return billing_values;
	}
	// // retrieve info with Region


	private ColourIndex setcolorindex(String granularity, List<BillingTimelineDTO> list_billingdto) {
		Date date = new Date();
		ColourIndex colourIndex = new ColourIndex();
		if (granularity.equals("yearly")) {
			DateFormat dfDateFormat = new SimpleDateFormat("yyyy");
			int str_year = Integer.parseInt(dfDateFormat.format(date));
			for (int i = 0; i < list_billingdto.size(); i++) {
				BillingTimelineDTO billingTimelineDTO = list_billingdto.get(i);
				if (str_year <= Integer.parseInt(billingTimelineDTO.getBillingDate())) {
					colourIndex.setCount(i);
					//billingTimelineDTO.setIndex(i);
					break;
				} else if (str_year > Integer.parseInt(billingTimelineDTO.getBillingDate())){
					colourIndex.setCount(i);
				}
			}
		} else if (granularity.equals("monthly")) {
			DateFormat dfDateFormat = new SimpleDateFormat("yyyy-MMM");

			for (int i = 0; i < list_billingdto.size(); i++) {
				BillingTimelineDTO billingTimelineDTO = list_billingdto.get(i);
				Date fromMonthDate = new Date();
				try {
					fromMonthDate = dfDateFormat.parse(billingTimelineDTO.getBillingDate());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (fromMonthDate.getTime() >= date.getTime()) {
					colourIndex.setCount(i);
					//billingTimelineDTO.setBillingDate(billingTimelineDTO.getBillingDate().substring(0, 8));
					break;
				} else if(fromMonthDate.getTime() < date.getTime()){
					colourIndex.setCount(i);
					//billingTimelineDTO.setBillingDate(billingTimelineDTO.getBillingDate().substring(0, 8));
				}
			}
		}
		else if (granularity.equals("quarterly"))
		{

			DateFormat dfDateFormat = new SimpleDateFormat("yyyy-MMM");

			for (int i = 0; i < list_billingdto.size(); i++) {
				BillingTimelineDTO billingTimelineDTO = list_billingdto.get(i);
				Date fromMonthDate = new Date();
				
				try {
					fromMonthDate = dfDateFormat.parse(billingTimelineDTO.getBillingDate().split("-")[0]+"-"+getMonthName(billingTimelineDTO.getBillingDate().split("-")[1]));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (fromMonthDate.getTime() >= date.getTime()) {
					colourIndex.setCount(i);
					break;
					
				} else if(fromMonthDate.getTime() < date.getTime()){
					colourIndex.setCount(i);
				}
			}
		
		}
		return colourIndex;
	}
	
	private String getMonthName(String quarter)
	{
		if (quarter.equals("Q1")) {
			return "January";
		}
		else if (quarter.equals("Q2")) {
			return "April";
		}
		else if (quarter.equals("Q1")) {
			return "July";
		}
		else {
			return "October";
		}
	}

	@RequestMapping(value = "/getbilling/region", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public BillingJSONDataDto getProjectManager(@RequestBody RequestTradingFilter[] requestTradingFilterArr) {
		RequestTradingFilter requestTradingFilter = requestTradingFilterArr[0];
		BillingJSONDataDto billingJSONDataDto = new BillingJSONDataDto();
		List<RegionFilter> regionFilters = requestTradingFilter.getRegionFilters();
		String granularity = requestTradingFilter.getGranularity().get(0).getLabel();
		String region = "";
		int i = 0;
		/*int lowerLimit = 1;
		int upperLimit = 100;*/
		/*int lowerLimit = requestTradingFilter.getLowerLimit();
		int upperLimit = requestTradingFilter.getUpperLimit();*/
		
		for (RegionFilter regionFilter : regionFilters) {
			if ((i + 1) == regionFilters.size()) {
				region += regionFilter.getLabel() + ",";
				break;
			} else if (i < regionFilters.size()) {
				region += regionFilter.getLabel() + ",";
			}
			i++;
		}
		List<FormatDataDto> formatDataDtos = billingDao.getProjetManagers(region);
		/*String segment = "select distinct(project_manager) from billingdata where region in ( ";
		segment += createSql(region);
		segment += ")";
		List<FormatDataDto> formatDataDtos = jdbcTemplate.query(segment, new RowMapper<FormatDataDto>() {
			int counter;

			public FormatDataDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new FormatDataDto(++counter, rs.getString("project_manager"));
			}
		});*/
		String str = "where region in (" + createSql(region) + ")";// ==================
		billingJSONDataDto.setFormatDataDtos(formatDataDtos);
		
		//List<BillingTableDataDto> billingTableDataDtos = billingDao.getTotalBillingTableData(str,region,null,null,lowerLimit,upperLimit);
		/*List<BillingTableDataDto> billingTableDataDtos = billingDao.getTotalBillingTableData(str);*/
		//billingJSONDataDto.setBillingTableDataDtos(billingTableDataDtos);

		Map<String, Long> billingValuesMap = billingDao.getBillingPendingValuesMap(str);
		List<Long> billing_values = getBillingValues(billingValuesMap);

		

		billingJSONDataDto.setBillingValues(billing_values);

		//billingJSONDataDto.setBillingTimelineDTOs(billingDao.getBillingByTimeLine(str, granularity));
		
		List<BillingTimelineDTO> list = billingDao.getBillingByTimeLine(str, granularity);
		billingJSONDataDto.setBillingTimelineDTOs(list);
		billingJSONDataDto.setBillingtotal(billingDao.getBillTotal(str));
		billingJSONDataDto.setCounter(billingDao.getTableCounter(str));
		billingJSONDataDto.setColourIndex(setcolorindex(granularity, list));
		return billingJSONDataDto;
	}

	// retrieving information with region and Project manager
	@RequestMapping(value = "/getbilling/region/projectmanager", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public BillingJSONDataDto getProjectId(@RequestBody RequestTradingFilter[] requestTradingFilterArr) {
		BillingJSONDataDto billingJSONDataDto = new BillingJSONDataDto();
		RequestTradingFilter requestTradingFilter = requestTradingFilterArr[0];
		List<RegionFilter> regionFilters = requestTradingFilter.getRegionFilters();// ================
		List<ProjectManagerFilter> projectManagerFilters = requestTradingFilter.getProjectManagerFilters();
		String granularity = requestTradingFilter.getGranularity().get(0).getLabel();
		String region = "";
		String project_manager = "";
		int i = 0;
		/*int lowerLimit = requestTradingFilter.getLowerLimit();
		int upperLimit = requestTradingFilter.getUpperLimit();*/
		
		for (RegionFilter regionFilter : regionFilters) {
			if ((i + 1) == regionFilters.size()) {
				region += regionFilter.getLabel() + ",";
				break;
			} else if (i < regionFilters.size()) {
				region += regionFilter.getLabel() + ",";
			}
			i++;
		}
		i = 0;
		for (ProjectManagerFilter projectManagerFilter : projectManagerFilters) {
			if ((i + 1) == projectManagerFilters.size()) {
				project_manager += projectManagerFilter.getLabel() + ",";
				break;
			} else if (i < projectManagerFilters.size()) {
				project_manager += projectManagerFilter.getLabel() + ",";
			}
			i++;
		}
		
		List<FormatDataDto> formatDataDtos = billingDao.getProjectIds(region,project_manager);
		
		/*String segment = "select distinct(project_id) from billingdata where region in (";
		segment += createSql(region);
		segment += ") and project_manager in (";
		segment += createSql(project_manager);
		segment += ")";// ==================================
		List<FormatDataDto> formatDataDtos = jdbcTemplate.query(segment, new RowMapper<FormatDataDto>() {
			int counter;

			public FormatDataDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new FormatDataDto(++counter, rs.getString("project_id"));
			}
		});*/
		billingJSONDataDto.setFormatDataDtos(formatDataDtos);
		String str = " where region in (" + createSql(region) + ") and project_manager in ("
				+ createSql(project_manager) + ")";
		//List<BillingTableDataDto> billingTableDataDtos = billingDao.getTotalBillingTableData(str,region,project_manager,null,lowerLimit,upperLimit);
		//billingJSONDataDto.setBillingTableDataDtos(billingTableDataDtos);
		Map<String, Long> billingValuesMap = billingDao.getBillingPendingValuesMap(str);// =====================================

		String[] daysGroup = { "1-30", "31-60", "61-90", "91-120", "120+" };
		// List<String> billing_dates = new ArrayList<>();
		List<Long> billing_values = new ArrayList<>();// ===============
		for (String key : daysGroup) {
			billing_values.add(billingValuesMap.get(key));
		}
		billingJSONDataDto.setBillingValues(billing_values);
		//billingJSONDataDto.setBillingTimelineDTOs(billingDao.getBillingByTimeLine(str, granularity));
		List<BillingTimelineDTO> list = billingDao.getBillingByTimeLine(str, granularity);
		billingJSONDataDto.setBillingTimelineDTOs(list);
		billingJSONDataDto.setBillingtotal(billingDao.getBillTotal(str));
		billingJSONDataDto.setCounter(billingDao.getTableCounter(str));
		billingJSONDataDto.setColourIndex(setcolorindex(granularity, list));
		return billingJSONDataDto;
	}

	@RequestMapping(value = "/getbillingtabledata", method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
	public List<BillingTableDataDto> getBillingTableData(@RequestBody RequestTradingFilter[] requestTradingFilterArr) {
		List<BillingTableDataDto> billingTableDataDtos = null;
		RequestTradingFilter requestTradingFilter = requestTradingFilterArr[0];
		List<RegionFilter> regionFilters = requestTradingFilter.getRegionFilters();
		List<ProjectManagerFilter> projectManagerFilters = requestTradingFilter.getProjectManagerFilters();
		List<ProjectIdFilter> projectIdFilters = requestTradingFilter.getProjectIdFilters();
		//String granularity = requestTradingFilter.getGranularity().get(0).getLabel();
		int lowerLimit = requestTradingFilter.getLowerLimit();
		int upperLimit = requestTradingFilter.getUpperLimit();
		String region = "";
		String project_manager = "";
		String project_id = "";
		int i = 0;
		for (RegionFilter regionFilter : regionFilters) {
			if ((i + 1) == regionFilters.size()) {
				region += regionFilter.getLabel() + ",";
				break;
			} else if (i < regionFilters.size()) {
				region += regionFilter.getLabel() + ",";
			}
			i++;
		}
		i = 0;
		for (ProjectManagerFilter projectManagerFilter : projectManagerFilters) {
			if ((i + 1) == projectManagerFilters.size()) {
				project_manager += projectManagerFilter.getLabel() + ",";
				break;
			} else if (i < projectManagerFilters.size()) {
				project_manager += projectManagerFilter.getLabel() + ",";
			}
			i++;
		}
		i = 0;
		for (ProjectIdFilter projectIdFilter : projectIdFilters) {

			if ((i + 1) == projectIdFilters.size()) {
				project_id += projectIdFilter.getLabel() + ",";
				break;
			} else if (i < projectIdFilters.size()) {
				project_id += projectIdFilter.getLabel() + ",";
			}
			i++;
		}
		//System.out.println("projectIdFilters::"+project_id);
		String str= "";
		
		if(!region.equals("") && !project_manager.equals("") && !project_id.equals("") )
			str = "where region in (" + createSql(region) + ") and project_manager in (" + createSql(project_manager)
			+ ") and project_id in (" + createSql(project_id) + ")";
		
		else if(!region.equals("") && !project_manager.equals(""))
			 str = "where region in (" + createSql(region) + ") and project_manager in (" + createSql(project_manager)+ ")";
		else  if(!region.equals(""))
			str = "where region in (" + createSql(region) + ") ";
		
		//System.out.println("str:::"+str);
		 billingTableDataDtos = billingDao.getTotalBillingTableData(str,region,project_manager,project_id,lowerLimit,upperLimit);
		return billingTableDataDtos;
	}
	
	//
	@RequestMapping(value = "/getbilling/region/projectmanager/projectid/granularity", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public BillingJSONDataDto getDetailsBasedOnGranularity(@RequestBody RequestTradingFilter[] requestTradingFilterArr) {
		BillingJSONDataDto billingJSONDataDto = new BillingJSONDataDto();
		RequestTradingFilter requestTradingFilter = requestTradingFilterArr[0];
		List<RegionFilter> regionFilters = requestTradingFilter.getRegionFilters();
		List<ProjectManagerFilter> projectManagerFilters = requestTradingFilter.getProjectManagerFilters();
		List<ProjectIdFilter> projectIdFilters = requestTradingFilter.getProjectIdFilters();
		String granularity = requestTradingFilter.getGranularity().get(0).getLabel();

		String str = "";
		// no input only with granularity
		if (regionFilters.isEmpty() && projectManagerFilters.isEmpty() && projectIdFilters.isEmpty() && !"".equals(granularity)) {
			List<BillingTimelineDTO> list = billingDao.getBillingByTimeLine(str, granularity);
			billingJSONDataDto.setBillingTimelineDTOs(list);
			billingJSONDataDto.setColourIndex(setcolorindex(granularity, list));
			
		} else if (!regionFilters.isEmpty() && projectManagerFilters.isEmpty() && projectIdFilters.isEmpty() && !"".equals(granularity))
		{
			String region = "";
			int i = 0;
			for (RegionFilter regionFilter : regionFilters) {
				if ((i + 1) == regionFilters.size()) {
					region += regionFilter.getLabel() + ",";
					break;
				} else if (i < regionFilters.size()) {
					region += regionFilter.getLabel() + ",";
				}
				i++;
			}
			str = "where region in (" + createSql(region) + ")";
			//billingJSONDataDto.setBillingTimelineDTOs(billingDao.getBillingByTimeLine(str, granularity));
			
			List<BillingTimelineDTO> list = billingDao.getBillingByTimeLine(str, granularity);
			billingJSONDataDto.setBillingTimelineDTOs(list);
			billingJSONDataDto.setColourIndex(setcolorindex(granularity, list));
			
		} else if (!regionFilters.isEmpty() && !projectManagerFilters.isEmpty() && projectIdFilters.isEmpty()
				&& !"".equals(granularity))// regions, projectmanagers input
											// with granularity
		{
			String region = "";
			String project_manager = "";
			int i = 0;

			for (RegionFilter regionFilter : regionFilters) {
				if ((i + 1) == regionFilters.size()) {
					region += regionFilter.getLabel() + ",";
					break;
				} else if (i < regionFilters.size()) {
					region += regionFilter.getLabel() + ",";
				}
				i++;
			}
			i = 0;
			for (ProjectManagerFilter projectManagerFilter : projectManagerFilters) {
				if ((i + 1) == projectManagerFilters.size()) {
					project_manager += projectManagerFilter.getLabel() + ",";
					break;
				} else if (i < projectManagerFilters.size()) {
					project_manager += projectManagerFilter.getLabel() + ",";
				}
				i++;
			}

			str = " where region in (" + createSql(region) + ") and project_manager in (" + createSql(project_manager)
					+ ")";
			
			List<BillingTimelineDTO> list = billingDao.getBillingByTimeLine(str, granularity);
			billingJSONDataDto.setBillingTimelineDTOs(list);
			billingJSONDataDto.setColourIndex(setcolorindex(granularity, list));
		}
		// regions, projectmanagers,projectId input with granularity dat means
		// all input is comming here no null
		if (!regionFilters.isEmpty() && !projectManagerFilters.isEmpty() && !projectIdFilters.isEmpty()
				&& !"".equals(granularity)) {

			String region = "";
			String project_manager = "";
			String project_id = "";

			int i = 0;
			for (RegionFilter regionFilter : regionFilters) {
				if ((i + 1) == regionFilters.size()) {
					region += regionFilter.getLabel() + ",";
					break;
				} else if (i < regionFilters.size()) {
					region += regionFilter.getLabel() + ",";
				}
				i++;
			}
			i = 0;
			for (ProjectManagerFilter projectManagerFilter : projectManagerFilters) {
				if ((i + 1) == projectManagerFilters.size()) {
					project_manager += projectManagerFilter.getLabel() + ",";
					break;
				} else if (i < projectManagerFilters.size()) {
					project_manager += projectManagerFilter.getLabel() + ",";
				}
				i++;
			}

			for (ProjectIdFilter projectIdFilter : projectIdFilters) {

				if ((i + 1) == projectIdFilters.size()) {
					project_id += projectIdFilter.getLabel() + ",";
					break;
				} else if (i < projectIdFilters.size()) {
					project_id += projectIdFilter.getLabel() + ",";
				}
				i++;
			}

			str = "where region in (" + createSql(region) + ") and project_manager in (" + createSql(project_manager)
					+ ") and project_id in (" + createSql(project_id) + ")";

			//billingJSONDataDto.setBillingTimelineDTOs(billingDao.getBillingByTimeLine(str, granularity));
			
			List<BillingTimelineDTO> list = billingDao.getBillingByTimeLine(str, granularity);
			billingJSONDataDto.setBillingTimelineDTOs(list);
			billingJSONDataDto.setColourIndex(setcolorindex(granularity, list));
		}
		return billingJSONDataDto;
	}

	// retrieving information with region and Project manager
	@RequestMapping(value = "/getbilling/region/projectmanager/projectid", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public BillingJSONDataDto getDetailsBasedOnProjectId(@RequestBody RequestTradingFilter[] requestTradingFilterArr) {
		BillingJSONDataDto billingJSONDataDto = new BillingJSONDataDto();
		RequestTradingFilter requestTradingFilter = requestTradingFilterArr[0];
		List<RegionFilter> regionFilters = requestTradingFilter.getRegionFilters();
		List<ProjectManagerFilter> projectManagerFilters = requestTradingFilter.getProjectManagerFilters();
		List<ProjectIdFilter> projectIdFilters = requestTradingFilter.getProjectIdFilters();
		String granularity = requestTradingFilter.getGranularity().get(0).getLabel();
		String region = "";
		String project_manager = "";
		String project_id = "";
		int i = 0;
		for (RegionFilter regionFilter : regionFilters) {
			if ((i + 1) == regionFilters.size()) {
				region += regionFilter.getLabel() + ",";
				break;
			} else if (i < regionFilters.size()) {
				region += regionFilter.getLabel() + ",";
			}
			i++;
		}
		i = 0;
		for (ProjectManagerFilter projectManagerFilter : projectManagerFilters) {
			if ((i + 1) == projectManagerFilters.size()) {
				project_manager += projectManagerFilter.getLabel() + ",";
				break;
			} else if (i < projectManagerFilters.size()) {
				project_manager += projectManagerFilter.getLabel() + ",";
			}
			i++;
		}

		for (ProjectIdFilter projectIdFilter : projectIdFilters) {

			if ((i + 1) == projectIdFilters.size()) {
				project_id += projectIdFilter.getLabel() + ",";
				break;
			} else if (i < projectIdFilters.size()) {
				project_id += projectIdFilter.getLabel() + ",";
			}
			i++;
		}

		
		
		/*String segment = "select distinct(project_id) from billingdata where region in (";
		segment += createSql(region);
		segment += ") and project_manager in (";
		segment += createSql(project_manager);
		segment += ") and project_id in (";

		segment += createSql(project_id);
		segment += ")";
		
		System.out.println("segment ****" +segment );
*/
		/*List<FormatDataDto> formatDataDtos = jdbcTemplate.query(segment, new RowMapper<FormatDataDto>() {
			int counter;

			public FormatDataDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new FormatDataDto(++counter, rs.getString("project_id"));
			}
		});*/
		//billingJSONDataDto.setFormatDataDtos(formatDataDtos);
		String str="";
		
		if(!region.equals("") && !project_manager.equals("") && !project_id.equals("") )
			str = "where region in (" + createSql(region) + ") and project_manager in (" + createSql(project_manager)
			+ ") and project_id in (" + createSql(project_id) + ")";
		
		else if(!region.equals("") && !project_manager.equals(""))
			 str = "where region in (" + createSql(region) + ") and project_manager in (" + createSql(project_manager)+ ")";
		else  if(!region.equals(""))
			str = "where region in (" + createSql(region) + ") ";

		/*List<BillingTableDataDto> billingTableDataDtos = billingDao.getTotalBillingTableData(str,region,project_manager,project_id,lowerLimit,upperLimit);
		billingJSONDataDto.setBillingTableDataDtos(billingTableDataDtos);*/

		Map<String, Long> billingValuesMap = billingDao.getBillingPendingValuesMap(str);
		List<Long> billing_values = getBillingValues(billingValuesMap);

		
		billingJSONDataDto.setBillingValues(billing_values);
		//billingJSONDataDto.setBillingTimelineDTOs(billingDao.getBillingByTimeLine(str, granularity));
		List<BillingTimelineDTO> list = billingDao.getBillingByTimeLine(str, granularity);
		billingJSONDataDto.setBillingTimelineDTOs(list);
		billingJSONDataDto.setBillingtotal(billingDao.getBillTotal(str));
		billingJSONDataDto.setCounter(billingDao.getTableCounter(str));
		billingJSONDataDto.setColourIndex(setcolorindex(granularity, list));
		return billingJSONDataDto;
	}

	private String createSql(String str) {

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

	
	
	@RequestMapping(value = "/getbilling/region/projectmanager/projectid/group", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public BillingTotalJsonDTO getTableDataBasedOnSelction(@RequestBody TableDataOnGroupFilter[] tableDataOnGroupFilterArr) {

		//BillingJSONDataDto billingJSONDataDto = new BillingJSONDataDto();
		TableDataOnGroupFilter requestTradingFilter = tableDataOnGroupFilterArr[0];
		List<RegionFilter> regionFilters = requestTradingFilter.getRegionFilters();
		List<ProjectManagerFilter> projectManagerFilters = requestTradingFilter.getProjectManagerFilters();
		List<ProjectIdFilter> projectIdFilters = requestTradingFilter.getProjectIdFilters();
		String group = requestTradingFilter.getGroup().get(0).getLabel();
		
		//String str = "";
		String region = "";
		String project_manager = "";
		String project_id = "";

			int i = 0;
			for (RegionFilter regionFilter : regionFilters) {
				if ((i + 1) == regionFilters.size()) {
					region += regionFilter.getLabel() + ",";
					break;
				} else if (i < regionFilters.size()) {
					region += regionFilter.getLabel() + ",";
				}
				i++;
			}
			i = 0;
			for (ProjectManagerFilter projectManagerFilter : projectManagerFilters) {
				if ((i + 1) == projectManagerFilters.size()) {
					project_manager += projectManagerFilter.getLabel() + ",";
					break;
				} else if (i < projectManagerFilters.size()) {
					project_manager += projectManagerFilter.getLabel() + ",";
				}
				i++;
			}

			for (ProjectIdFilter projectIdFilter : projectIdFilters) {

				if ((i + 1) == projectIdFilters.size()) {
					project_id += projectIdFilter.getLabel() + ",";
					break;
				} else if (i < projectIdFilters.size()) {
					project_id += projectIdFilter.getLabel() + ",";
				}
				i++;
			}
			
			BillingTotalJsonDTO billingTotalJsonDTO = billingDao.getTableDataBasedOnRange(region, project_manager, project_id,group);
			
			
		return billingTotalJsonDTO;
	}
	
	
}
