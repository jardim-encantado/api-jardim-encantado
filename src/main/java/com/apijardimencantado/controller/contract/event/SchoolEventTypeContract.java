package com.apijardimencantado.controller.contract.event;

import com.apijardimencantado.model.dto.response.SchoolEventTypeResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SchoolEventTypeContract {
    @Operation(
            summary = "List all events type",
            description = "Retrieve all registered events type"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Request completed successfully",
                    content = @Content(schema = @Schema(implementation = SchoolEventTypeResponse.class))
            ),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content)
    })
    ResponseEntity<List<SchoolEventTypeResponse>> getAll();

    @Operation(
            summary = "Find event type by ID",
            description = "Retrieve a specific event type by its ID"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Event type found successfully",
                    content = @Content(schema = @Schema(implementation = SchoolEventTypeResponse.class))
            ),
            @ApiResponse(responseCode = "404", description = "Event type not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content)
    })
    ResponseEntity<SchoolEventTypeResponse> getById(Long id);
}
