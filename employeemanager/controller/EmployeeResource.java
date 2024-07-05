package com.example.employeemanager.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import com.example.employeemanager.model.Employee;
import com.example.employeemanager.service.EmployeeService;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {


    private final EmployeeService employeeService;

    @Inject
    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GET
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GET
    @Path("/{id}")
    public Employee getEmployee(@PathParam("id") int id) {
        return employeeService.getEmployeeById(id);
    }

    @GET
    @Path("/department/{departmentId}")
    public List<Employee> getEmployeesByDepartmentId(@PathParam("departmentId") int departmentId) {
        return employeeService.getEmployeesByDepartmentId(departmentId);
    }

    @GET
    @Path("/job/{jobId}")
    public List<Employee> getEmployeesByJobId(@PathParam("jobId") int jobId) {
        return employeeService.getEmployeesByJobId(jobId);
    }

    @POST
    public Response createEmployee(Employee employee) {
        employeeService.saveEmployee(employee);
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    public Response updateEmployee(@PathParam("id") int id, Employee employee) {
        employee.setId(id);
        employeeService.updateEmployee(employee);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteEmployee(@PathParam("id") int id) {
        employeeService.deleteEmployee(id);
        return Response.ok().build();
    }
}
