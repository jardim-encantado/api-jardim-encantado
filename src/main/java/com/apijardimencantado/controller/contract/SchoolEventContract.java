package com.apijardimencantado.controller.contract;

import com.apijardimencantado.model.dto.request.SchoolEventRequest;
import com.apijardimencantado.model.dto.response.SchoolEventResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "School Event Controller", description = "Endpoints to manage school events")
public interface SchoolEventContract {

    @Operation(
            summary = "Create a new school event",
            description = "Register a new school event in the system"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "School event created successfully",
                    content = @Content(schema = @Schema(implementation = SchoolEventResponse.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid data provided", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content)
    })
    ResponseEntity<SchoolEventResponse> create(SchoolEventRequest schoolEventRequest);

    @Operation(
            summary = "List all school events",
            description = "Retrieve all registered school events"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Request completed successfully",
                    content = @Content(schema = @Schema(implementation = SchoolEventResponse.class))
            ),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content)
    })
    ResponseEntity<List<SchoolEventResponse>> getAll();

    @Operation(
            summary = "Find school event by ID",
            description = "Retrieve a specific school event by its ID"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "School event found successfully",
                    content = @Content(schema = @Schema(implementation = SchoolEventResponse.class))
            ),
            @ApiResponse(responseCode = "404", description = "School event not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content)
    })
    ResponseEntity<SchoolEventResponse> getById(Long id);

    @Operation(
            summary = "Update school event",
            description = "Update an existing school event by its ID"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "School event updated successfully",
                    content = @Content(schema = @Schema(implementation = SchoolEventResponse.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid data provided", content = @Content),
            @ApiResponse(responseCode = "404", description = "School event not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content)
    })
    ResponseEntity<SchoolEventResponse> update(
            Long id,
            SchoolEventRequest schoolEventRequest
    );
}