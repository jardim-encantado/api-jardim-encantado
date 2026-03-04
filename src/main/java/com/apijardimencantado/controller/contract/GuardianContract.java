package com.apijardimencantado.controller.contract;

import com.apijardimencantado.model.dto.request.GuardianRequest;
import com.apijardimencantado.model.dto.response.GuardianResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Guardian Controller", description = "Endpoints to manage legal guardians")
@Validated
public interface GuardianContract {
    @Operation(
            summary = "Create a new person",
            description = "Register a new person in the system"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Guardian created successfully",
                    content = @Content(schema = @Schema(implementation = GuardianResponse.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid data provided", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content)
    })
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    GuardianResponse create(GuardianRequest guardianRequest);

    @Operation(
            summary = "List all guardians",
            description = "Retrieve all registered guardians"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Request completed successfully",
                    content = @Content(schema = @Schema(implementation = GuardianResponse.class))
            ),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content)
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<GuardianResponse> getAll();

    @Operation(
            summary = "Find person by ID",
            description = "Retrieve a specific guardian by its guardian ID"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Person found successfully",
                    content = @Content(schema = @Schema(implementation = GuardianResponse.class))
            ),
            @ApiResponse(responseCode = "404", description = "Person not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content)
    })
    @GetMapping("/{guardianId}")
    @ResponseStatus(HttpStatus.OK)
    GuardianResponse getById(@PathVariable Long guardianId);

    @Operation(
            summary = "Add student to guardian",
            description = "Associate a specific student to its guardian by ID"
    )
    @PostMapping("/{guardianId}/students/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    void addStudent(@PathVariable Long guardianId, @PathVariable Long studentId);


    @Operation(
            summary = "Remove student from guardian",
            description = "Remove a specific student from its guardian by ID"
    )
    @DeleteMapping("/{guardianId}/students/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    void removeStudent(@PathVariable Long guardianId, @PathVariable Long studentId);
}
