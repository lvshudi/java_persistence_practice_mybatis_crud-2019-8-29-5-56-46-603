package tws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tws.dto.EmployeeDTO;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	public EmployeeDTO getEmployeeWithDesc(String id) {
		Employee employee = employeeMapper.selectOne(id);
		
		String dtoId = employee.getId();
		String dtoName = employee.getName();
		String dtoAge = employee.getAge();
		String desc = "name:" + dtoName + ", age:" + dtoAge;
		
		EmployeeDTO employeeDTO = new EmployeeDTO(dtoId, dtoName, dtoAge, desc);		
		
		return employeeDTO;
	}
	
	public List<Employee> getEmployeesByPages(int page, int count) {
		count = count * (page - 1);
		List<Employee> employees = employeeMapper.selectEmployeesByPages(page, count);
		return employees;
	}
	
	
}
