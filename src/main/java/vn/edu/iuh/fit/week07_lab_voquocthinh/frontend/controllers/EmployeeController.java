package vn.edu.iuh.fit.week07_lab_voquocthinh.frontend.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.Customer;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.Employee;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.Product;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models.User;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.repositories.EmployeeRepository;
import vn.edu.iuh.fit.week07_lab_voquocthinh.backend.services.EmployeeService;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/admin/my-account")
    public ModelAndView showMyAccount(
            HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) session.getAttribute("adminSession");
        modelAndView.addObject("adminSession", user);
        Employee employee = employeeService.findByUserUsernameAndStatusIsNotTerminated(user.getUsername());
        modelAndView.addObject("employee", employee);

        modelAndView.setViewName("admin/admin-info");
        return modelAndView;
    }

    @PostMapping("/admin/update/{id}")
    public ModelAndView update(@PathVariable("id") Long id,
                               @ModelAttribute("employee") Employee employee){
        ModelAndView modelAndView = new ModelAndView();
        Employee employee1 = employeeRepository.findById(id).get();
        employee1.setFullname(employee.getFullname());
        employee1.setEmail(employee.getEmail());
        employee1.setPhone(employee.getPhone());
        employee1.setAddress(employee.getAddress());
        employeeRepository.save(employee1);
        modelAndView.setViewName("redirect:/admin/my-account");
        return modelAndView;
    }
}
