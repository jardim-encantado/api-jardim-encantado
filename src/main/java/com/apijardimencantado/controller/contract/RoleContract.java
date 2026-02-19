package com.apijardimencantado.controller.contract;

import com.apijardimencantado.model.dto.request.RoleRequest;
import com.apijardimencantado.model.dto.response.RoleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Role Controller", description = "Endpoints to manage roles")
public interface RoleContract {

    @Operation(summary = "Create a new role", description = "Register a new role in the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Role created successfully",
                    content = @Content(schema = @Schema(implementation = RoleResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid data provided", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content)
    })
    ResponseEntity<RoleResponse> create(RoleRequest roleRequest);

    @Operation(summary = "List all roles", description = "Retrieve all registered roles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Request completed successfully",
                    content = @Content(schema = @Schema(implementation = RoleResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content)
    })
    ResponseEntity<List<RoleResponse>> getAll();

    @Operation(summary = "Find role by ID", description = "Retrieve a specific role by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Role found successfully",
                    content = @Content(schema = @Schema(implementation = RoleResponse.class))),
            @ApiResponse(responseCode = "404", description = "Role not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content)
    })
    ResponseEntity<RoleResponse> getById(Long id);

    @Operation(summary = "Update role", description = "Update an existing role by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Role updated successfully",
                    content = @Content(schema = @Schema(implementation = RoleResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid data provided", content = @Content),
            @ApiResponse(responseCode = "404", description = "Role not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content)
    })
    ResponseEntity<RoleResponse> update(Long id, RoleRequest roleRequest);
}
