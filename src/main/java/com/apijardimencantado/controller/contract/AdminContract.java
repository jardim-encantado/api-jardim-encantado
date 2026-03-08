package com.apijardimencantado.controller.contract;

import com.apijardimencantado.model.dto.request.AdminRequest;
import com.apijardimencantado.model.dto.response.AdminResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Tag(name = "Admin Controller", description = "Endpoints to manage admins")
public interface AdminContract {

    @Operation(
            summary = "Create a new admin",
            description = "Register a new admin in the system"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Admin created successfully",
                    content = @Content(schema = @Schema(implementation = AdminResponse.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid data provided", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content)
    })
    @ResponseStatus(HttpStatus.CREATED)
    AdminResponse create(AdminRequest adminRequest);

    @Operation(
            summary = "List all admins",
            description = "Retrieve all registered admins"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Request completed successfully",
                    content = @Content(schema = @Schema(implementation = AdminResponse.class))
            ),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    List<AdminResponse> getAll();

    @Operation(
            summary = "Find admin by ID",
            description = "Retrieve a specific admin by its ID"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Admin found successfully",
                    content = @Content(schema = @Schema(implementation = AdminResponse.class))
            ),
            @ApiResponse(responseCode = "404", description = "Admin not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    AdminResponse getById(Long id);

    @Operation(
            summary = "Update admin",
            description = "Update an existing admin by its ID"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Admin updated successfully",
                    content = @Content(schema = @Schema(implementation = AdminResponse.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid data provided", content = @Content),
            @ApiResponse(responseCode = "404", description = "Admin not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    AdminResponse update(Long id, AdminRequest adminRequest);
}