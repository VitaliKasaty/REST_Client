package com.kasatyvitali.spring.rest.spring_course_rest_client;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kasatyvitali.spring.rest.Communication;
import com.kasatyvitali.spring.rest.entity.Employee;
import com.kasatyvitali.spring.rest.spring_course_rest_client.configuration.MyConfig;

public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = 
        		new AnnotationConfigApplicationContext(MyConfig.class);
        
        Communication communication =context.getBean("communication", Communication.class);
        List<Employee> allEmployees = communication.getAllEmployees();
        System.out.println(allEmployees);
        
        Employee empById = communication.getEmployee(10);
        System.out.println(empById);
        
        Employee emp = new Employee("Sveta", "Sokolova", "HR", 900);        
        communication.saveEmployee(emp);
        
        Employee emp1 = new Employee("Sveta", "Sokolova", "IT", 1900);
        emp.setId(12);
        communication.saveEmployee(emp1);
        
        communication.deleteEmployee(12);
        
    }
}
