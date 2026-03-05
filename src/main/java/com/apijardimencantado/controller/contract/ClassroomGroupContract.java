package com.apijardimencantado.controller.contract;

import com.apijardimencantado.model.dto.request.ClassroomGroupRequest;
import com.apijardimencantado.model.dto.response.ClassroomGroupResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import java.util.List;

@Tag(name = "Classroom Group Controller", description = "Endpoints to manage classroom groups")
public interface ClassroomGroupContract {

    @Operation(
            summary = "Create a new classroom group",
            description = "Register a new classroom group in the system"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Classroom group created successfully",
                    content = @Content(schema = @Schema(implementation = ClassroomGroupResponse.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid data provided", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content)
    })
    ResponseEntity<ClassroomGroupResponse> create(ClassroomGroupRequest classroomGroupRequest);

    @Operation(
            summary = "List all classroom groups",
            description = "Retrieve all registered classroom groups"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Request completed successfully",
                    content = @Content(schema = @Schema(implementation = ClassroomGroupResponse.class))
            ),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content)
    })
    ResponseEntity<List<ClassroomGroupResponse>> getAll();

    @Operation(
            summary = "Find classroom group by ID",
            description = "Retrieve a specific classroom group by its ID"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Classroom group found successfully",
                    content = @Content(schema = @Schema(implementation = ClassroomGroupResponse.class))
            ),
            @ApiResponse(responseCode = "404", description = "Classroom group not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content)
    })
    ResponseEntity<ClassroomGroupResponse> getById(Long id);

    @Operation(
            summary = "Update classroom group",
            description = "Update an existing classroom group by its ID"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Classroom group updated successfully",
                    content = @Content(schema = @Schema(implementation = ClassroomGroupResponse.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid data provided", content = @Content),
            @ApiResponse(responseCode = "404", description = "Classroom group not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content)
    })
    ResponseEntity<ClassroomGroupResponse> update(Long id, ClassroomGroupRequest classroomGroupRequest);
}
