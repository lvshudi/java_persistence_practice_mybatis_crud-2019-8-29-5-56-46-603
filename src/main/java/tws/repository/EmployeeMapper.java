package tws.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import tws.entity.Employee;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    public List<Employee> selectAll();
    
    public void insertEmployee(@Param("employee") Employee employee);
    
    public Employee selectOne(@Param("id") String id);
    
    public void update(@Param("id") String id, @Param("employee") Employee employee);
    
    public void delete(@Param("id") String id);
}
