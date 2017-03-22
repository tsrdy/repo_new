package main.java.org.echidna.eiql.mlo.copyDataApp.service;


import java.sql.Connection;
import java.sql.Statement;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@CrossOrigin
@Controller
public class fileUploadService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private String UPLOAD_DIRECTORY = "target";
	//private static String JDBC_CONNECTION_URL="jdbc:postgresql://localhost:3120/postgres";
	String check = "running";

	@Autowired
	ServletContext servletContext;

	@CrossOrigin
	@RequestMapping(value = "/getData/{tablename}", method=RequestMethod.POST,produces={"text/plain"},headers="Content-Type=application/x-www-form-urlencoded , application/xml, application/json")
	public @ResponseBody String getWeiBullEngineDataResponse(@PathVariable(value="tablename") String tablename,@RequestBody List<Object> t){     
		Connection connection=null;
		Statement st=null;
		try{
			connection=jdbcTemplate.getDataSource().getConnection();

			st=connection.createStatement();

			//delete if table is exist
			try
			{
				st.execute("drop table "+tablename);
			}
			catch(Exception e)
			{

			}
			Pattern pattern = Pattern.compile("[0-9]*");

			String dataType="";
			System.out.println("t::" + t);
			//Create a Table
			Iterator i1=t.iterator();
			if(i1.hasNext())
			{
				LinkedHashMap l=(LinkedHashMap) i1.next();
				Set keys=l.keySet();
				System.out.println("l::" + l);
				String createTableQuery="create table "+tablename+"(";
				Iterator keysIterator=keys.iterator();
				while(keysIterator.hasNext())
				{
					Object  realKey=keysIterator.next();
					Matcher matcher = pattern.matcher(String.valueOf(l.get(realKey)));
					
					if (!matcher.matches()) {
						dataType=" varchar(20),";
					} else {
						dataType=" int(15),";
					}
					createTableQuery=createTableQuery+realKey+dataType;
				}
				createTableQuery=createTableQuery.substring(0, createTableQuery.length() - 1);
				createTableQuery=createTableQuery+")";
				System.out.println("sql"+createTableQuery);
				st.execute(createTableQuery);
			}

			Iterator i=t.iterator();
			while(i.hasNext())
			{
				LinkedHashMap l=(LinkedHashMap) i.next();
				Collection l1= l.values();

				//System.out.println(l);

				String query="insert into "+tablename+" values(";
				Iterator li=l1.iterator();
				while(li.hasNext())
				{


					query=query+"'"+li.next()+"',";
				}
				System.out.println(query);

				query=query.substring(0, query.length() - 1);


				query=query+")";
				System.out.println(query);
				st.executeUpdate(query);   
			}
		} catch (Exception e){
			e.printStackTrace();
			return e.toString();
		}

		// TODO: call persistence layer to update
		return "upload Successfully";
	}
}
