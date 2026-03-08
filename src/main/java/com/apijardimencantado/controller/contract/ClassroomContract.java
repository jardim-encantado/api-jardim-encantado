package com.apijardimencantado.controller.contract;

import com.apijardimencantado.model.dto.request.ClassroomRequest;
import com.apijardimencantado.model.dto.response.ClassroomResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import java.util.List;

@Tag(name = "Classroom Controller", description = "Endpoints to manage classrooms")
public interface ClassroomContract {
    @Operation(
            summary = "Create a new classroom",
            description = "Register a new classroom in the system"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Classroom created successfully",
                    content = @Content(schema = @Schema(implementation = ClassroomResponse.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid data provided", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content)
    })
    ResponseEntity<ClassroomResponse> create(ClassroomRequest classroomRequest);

    @Operation(
            summary = "List all classrooms",
            description = "Retrieve all registered classrooms"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Request completed successfully",
                    content = @Content(schema = @Schema(implementation = ClassroomResponse.class))
            ),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content)
    })
    ResponseEntity<List<ClassroomResponse>> getAll();

    @Operation(
            summary = "Find classroom by ID",
            description = "Retrieve a specific classroom by its ID"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Classroom found successfully",
                    content = @Content(schema = @Schema(implementation = ClassroomResponse.class))
            ),
            @ApiResponse(responseCode = "404", description = "Classroom not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content)
    })
    ResponseEntity<ClassroomResponse> getById(Long id);

    @Operation(
            summary = "Update classroom",
            description = "Update an existing classroom by its ID"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Classroom updated successfully",
                    content = @Content(schema = @Schema(implementation = ClassroomResponse.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid data provided", content = @Content),
            @ApiResponse(responseCode = "404", description = "Classroom not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content)
    })
    ResponseEntity<ClassroomResponse> update(Long id, ClassroomRequest classroomRequest);
}
