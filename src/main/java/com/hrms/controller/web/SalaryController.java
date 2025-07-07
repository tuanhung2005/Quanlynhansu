package com.hrms.controller.web;

import com.hrms.entity.Employee;
import com.hrms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/salaries")
public class SalaryController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String showSalaryTable(Model model) {
        try {
            List<Employee> employees = employeeService.getAllEmployees();
            model.addAttribute("employees", employees);
            return "salary-table";
        } catch (Exception e) {
            // Log error and return error page or redirect
            model.addAttribute("error", "Không thể tải dữ liệu bảng lương: " + e.getMessage());
            return "error";
        }
    }

    @GetMapping("/")
    public String showSalaryTableWithSlash(Model model) {
        return showSalaryTable(model);
    }
}