package com.example.employeemanager.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import com.example.employeemanager.model.Department;
import com.example.employeemanager.service.DepartmentService;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/departments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DepartmentResource {


    private final DepartmentService departmentService;

    @Inject
    public DepartmentResource(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GET
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GET
    @Path("/{id}")
    public Department getDepartmentById(@PathParam("id") int id) {
        return departmentService.getDepartmentById(id);
    }

    @POST
    public Response createDepartment(Department department) {
        departmentService.saveDepartment(department);
        return Response.ok(department).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateDepartment(@PathParam("id") int id, Department department) {
        department.setId(id);
        departmentService.updateDepartment(department);
        System.out.println("Department updated");
        return Response.ok(department).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDepartmentById(@PathParam("id") int id) {
        departmentService.deleteDepartmentById(id);
        System.out.println("Department deleted");
        return Response.ok().build();
    }
}