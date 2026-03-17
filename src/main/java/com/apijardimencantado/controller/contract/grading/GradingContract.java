package com.apijardimencantado.controller.contract.grading;

import com.apijardimencantado.model.dto.request.GradingRequest;
import com.apijardimencantado.model.dto.response.GradingResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Tag(name = "Grading Controller", description = "Endpoints to manage student grades")
public interface GradingContract {

    @Operation(
            summary = "Create a new grade",
            description = "Register a new grade for a student"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Grade created successfully",
                    content = @Content(schema = @Schema(implementation = GradingResponse.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid data provided", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @ResponseStatus(HttpStatus.CREATED)
    GradingResponse create(GradingRequest request);

    @Operation(
            summary = "List all grades",
            description = "Retrieve all grades"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Request completed successfully",
                    content = @Content(schema = @Schema(implementation = GradingResponse.class))
            ),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    List<GradingResponse> getAll();

    @Operation(
            summary = "Find grade by ID",
            description = "Retrieve a specific grade by its ID"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Grade found successfully",
                    content = @Content(schema = @Schema(implementation = GradingResponse.class))
            ),
            @ApiResponse(responseCode = "404", description = "Grade not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    GradingResponse getById(Long id);

    @Operation(
            summary = "Find grade by Student ID",
            description = "Retrieve a specific grade by student ID"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Grade found successfully",
                    content = @Content(schema = @Schema(implementation = GradingResponse.class))
            ),
            @ApiResponse(responseCode = "404", description = "Grade not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    List<GradingResponse> getByPersonId(Long id);

    @Operation(
            summary = "Update grade",
            description = "Update an existing grade"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Grade updated successfully",
                    content = @Content(schema = @Schema(implementation = GradingResponse.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid data provided", content = @Content),
            @ApiResponse(responseCode = "404", description = "Grade not found", content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    GradingResponse update(Long id, GradingRequest request);
}