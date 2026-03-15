package com.apijardimencantado.controller.contract.classroom;

import com.apijardimencantado.model.dto.request.ClassroomGroupStudentRequest;
import com.apijardimencantado.model.dto.response.ClassroomGroupStudentResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Tag(name = "Classroom Group Student Controller", description = "Endpoints to manage student-group relations")
public interface ClassroomGroupStudentContract {

    @Operation(
            summary = "Create a new classroom group student relation",
            description = "Register a student inside a classroom group"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Relation created successfully",
                    content = @Content(schema = @Schema(implementation = ClassroomGroupStudentResponse.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid data provided", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @ResponseStatus(HttpStatus.CREATED)
    ClassroomGroupStudentResponse create(ClassroomGroupStudentRequest request);

    @Operation(
            summary = "List all classroom group student relations",
            description = "Retrieve all registered student-group relations"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Request completed successfully",
                    content = @Content(schema = @Schema(implementation = ClassroomGroupStudentResponse.class))
            ),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    List<ClassroomGroupStudentResponse> getAll();

    @Operation(
            summary = "Find relation by ID",
            description = "Retrieve a specific student-group relation by ID"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Relation found successfully",
                    content = @Content(schema = @Schema(implementation = ClassroomGroupStudentResponse.class))
            ),
            @ApiResponse(responseCode = "404", description = "Relation not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @ResponseStatus(HttpStatus.OK)
    ClassroomGroupStudentResponse getById(Integer id);
}