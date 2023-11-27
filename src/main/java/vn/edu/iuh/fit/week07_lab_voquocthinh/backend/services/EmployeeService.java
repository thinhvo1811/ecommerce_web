package vn.edu.iuh.fit.week07_lab_voquocthinh.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.Employee;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.repositories.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee findByUserUsername(String username){
        return employeeRepository.findByUserUsername(username);
    }
}
