package com.apijardimencantado.controller.contract;

import com.apijardimencantado.model.dto.request.LoginRequest;
import com.apijardimencantado.model.dto.request.PersonRequest;
import com.apijardimencantado.model.dto.response.PersonResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Tag(name = "Person Controller", description = "Endpoints to manage persons")
public interface PersonContract {

    @Operation(
            summary = "Create a new person",
            description = "Register a new person in the system"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Person created successfully",
                    content = @Content(schema = @Schema(implementation = PersonResponse.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid data provided", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content)
    })
    @ResponseStatus(HttpStatus.CREATED)
    PersonResponse create(PersonRequest personRequest);

    @Operation(
            summary = "List all persons",
            description = "Retrieve all registered persons"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Request completed successfully",
                    content = @Content(schema = @Schema(implementation = PersonResponse.class))
            ),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    List<PersonResponse> getAll();

    @Operation(
            summary = "Find person by ID",
            description = "Retrieve a specific person by its ID"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Person found successfully",
                    content = @Content(schema = @Schema(implementation = PersonResponse.class))
            ),
            @ApiResponse(responseCode = "404", description = "Person not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    PersonResponse getById(Long id);

    @Operation(
            summary = "Update person",
            description = "Update an existing person by its ID"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Person updated successfully",
                    content = @Content(schema = @Schema(implementation = PersonResponse.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid data provided", content = @Content),
            @ApiResponse(responseCode = "404", description = "Person not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    PersonResponse update(Long id, PersonRequest personRequest);

    ResponseEntity<PersonResponse> login(LoginRequest loginRequest);
}
