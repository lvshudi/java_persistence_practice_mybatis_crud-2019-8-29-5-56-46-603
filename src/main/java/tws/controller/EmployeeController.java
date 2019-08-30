package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tws.dto.EmployeeDTO;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeMapper employeeMapper;

	@GetMapping("")
	public ResponseEntity<List<Employee>> getAll(@RequestParam(value = "keyword", required = false) String keyWork) {
		
		return ResponseEntity.ok(employeeMapper.selectAll(keyWork));
	}

	@PostMapping("")
	public ResponseEntity<Employee> insert(@RequestBody Employee employee) {
		String id = UUID.randomUUID().toString();
		employee.setId(id);
		employeeMapper.insertEmployee(employee);
		return ResponseEntity.created(URI.create("employees" + id)).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getOne(@PathVariable String id) {
		Employee employee = employeeMapper.selectOne(id);
		return ResponseEntity.ok(employee);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateOne(@PathVariable String id, @RequestBody Employee employee) {
		employeeMapper.update(id, employee);
		return ResponseEntity.ok(employee);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable String id) {
		employeeMapper.delete(id);
		return ResponseEntity.ok("delete success");
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeWithDesc(@PathVariable String id) {
		Employee employee = employeeMapper.selectOne(id);
		String desc = "name:" + employee.getName() + "age" + employee.getAge();

		String dtoId = employee.getId();
		String dtoName = employee.getName();
		String dtoAge = employee.getAge();

		EmployeeDTO employeeDTO = new EmployeeDTO(dtoId, dtoName, dtoAge, desc);

		return ResponseEntity.ok(employeeDTO);
	}

	@GetMapping("/page/{page}/count/{count}")
	public ResponseEntity<List<Employee>> getEmployeeByPage(@PathVariable("page") int page,
			@PathVariable("count") int count) {
		List<Employee> employees = employeeMapper.selectEmployeesByPages(page, count);
		return ResponseEntity.ok(employees);
	}

}
