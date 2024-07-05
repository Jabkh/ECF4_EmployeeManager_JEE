package com.example.employeemanager.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import com.example.employeemanager.model.Job;
import com.example.employeemanager.service.JobService;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/jobs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JobResource {


    private JobService jobService;

    @Inject
    public JobResource(JobService jobService) {
        this.jobService = jobService;
    }

    @GET
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GET
    @Path("/{id}")
    public Job getJobById(@PathParam("id") int id) {
        return jobService.getJobById(id);
    }

    @POST
    public Response createJob(Job job) {
        jobService.saveJob(job);
        return Response.ok(job).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateJob(@PathParam("id") int id, Job job) {
        job.setId(id);
        jobService.updateJob(job);
        return Response.ok(job).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteJobById(@PathParam("id") int id) {
        jobService.deleteJobById(id);
        return Response.ok().build();
    }
}