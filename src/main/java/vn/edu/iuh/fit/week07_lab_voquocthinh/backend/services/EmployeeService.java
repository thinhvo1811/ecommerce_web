package vn.edu.iuh.fit.week07_lab_voquocthinh.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.Employee;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.repositories.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee findByUserUsernameAndStatusIsNotTerminated(String username){
        return employeeRepository.findByUserUsernameAndStatusIsNot(username, EmployeeStatus.TERMINATED);
    }

    public List<Employee> findByStatusIsNotTerminated(){
        return employeeRepository.findByStatusIsNot(EmployeeStatus.TERMINATED);
    }
}
