package tws.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import tws.entity.Employee;
import tws.repository.EmployeeMapper;

@RunWith(SpringRunner.class)
@MybatisTest
public class EmployeeMpaperTest {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@After
	public void clearData() {
		JdbcTestUtils.deleteFromTables(jdbcTemplate, "employee");
	}
	
	@Test
	public void shouldFetchList() {
		//given
		jdbcTemplate.execute("insert into employee values('001','name','18')");
		//when
		List<Employee> employees = employeeMapper.selectAll("name");
		//then
		assertEquals(1, employees.size());
	}
	
	@Test
	public void shouleSaveEmployee() {
		//given
		jdbcTemplate.execute("insert into employee values('001','name','18')");
		//when
		List<Employee> employees = employeeMapper.selectAll("name");
		//then
		assertEquals(1, employees.size());
	}
}
