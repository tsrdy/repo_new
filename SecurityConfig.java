package com.echidna.eiq.mlo.config;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.echidna.eiq.mlo.dto.User;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("in configure global");
		List<User> listOfUsers=new ArrayList<User>();
		String sql = "select * from userinfo";
		System.out.println("sql::"+sql);
		listOfUsers = jdbcTemplate.query(sql, new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new User(rs.getString("user_id"), rs.getString("user_Name"), rs.getString("password"));
			}
		});
		System.out.println("list of users::"+listOfUsers);
		if(!listOfUsers.isEmpty()&&listOfUsers!=null){
			for(User user:listOfUsers){
				auth.inMemoryAuthentication().withUser(user.getUserId()).password(user.getPassword()).roles("User");
			}
		}
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.anyRequest().authenticated()
			.and().formLogin().loginPage("/loginPage").loginProcessingUrl("/validateuser").permitAll()
			.and().logout().permitAll();
	}
}