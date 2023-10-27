package org.acme.controller;


import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import lombok.RequiredArgsConstructor;
import org.acme.dto.EmployeeCreatingDTO;
import org.acme.dto.EmployeeResponseDTO;
import org.acme.service.EmployeeService;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;


@Path("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    //@Inject
    private final EmployeeService employeeService;

    @GET
    @Path("/{id}")
    @ResponseStatus(OK)
    @Produces(APPLICATION_JSON)
    public EmployeeResponseDTO getEmployee(@PathParam("id") Integer id) {
        return employeeService.getEmployee(id);
    }

    @GET
    @ResponseStatus(OK)
    @Produces(APPLICATION_JSON)
    public List<EmployeeResponseDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @POST
    @ResponseStatus(CREATED)
    @Produces(APPLICATION_JSON)
    public EmployeeResponseDTO createEmployee(@NotNull EmployeeCreatingDTO employeeCreatingDTO) {
        return employeeService.createEmployee(employeeCreatingDTO);
    }
}
