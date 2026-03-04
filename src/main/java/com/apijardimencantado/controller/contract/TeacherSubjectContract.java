package com.apijardimencantado.controller.contract;

import com.apijardimencantado.model.dto.request.TeacherSubjectRequest;
import com.apijardimencantado.model.dto.response.TeacherSubjectResponse;
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

@Tag(name = "Teacher Subject Controller", description = "Endpoints to manage teacher-subject relationships")
public interface TeacherSubjectContract {

    @Operation(
            summary = "Create a teacher-subject relationship",
            description = "Link a teacher to a study subject"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Relationship created successfully",
                    content = @Content(schema = @Schema(implementation = TeacherSubjectResponse.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid data provided", content = @Content),
            @ApiResponse(responseCode = "404", description = "Teacher or subject not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content)
    })
    @ResponseStatus(HttpStatus.CREATED)
    TeacherSubjectResponse create(TeacherSubjectRequest request);

    @Operation(
            summary = "List all teacher-subject relationships",
            description = "Retrieve all teacher-subject relationships"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Request completed successfully",
                    content = @Content(schema = @Schema(implementation = TeacherSubjectResponse.class))
            ),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    List<TeacherSubjectResponse> getAll();

    @Operation(
            summary = "Find relationship by ID",
            description = "Retrieve a specific teacher-subject relationship by its ID"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Relationship found successfully",
                    content = @Content(schema = @Schema(implementation = TeacherSubjectResponse.class))
            ),
            @ApiResponse(responseCode = "404", description = "Relationship not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    TeacherSubjectResponse getById(Long id);
}