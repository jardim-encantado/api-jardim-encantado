package com.apijardimencantado.controller.contract;

import com.apijardimencantado.model.dto.request.StudentRequest;
import com.apijardimencantado.model.dto.response.StudentResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Tag(name = "Student Controller", description = "Endpoints to manage persons")
@Validated
public interface StudentContract {

    @Operation(
            summary = "Create a new student",
            description = "Register a new student linked to an existing person by their CPF"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Student created successfully",
                    content = @Content(schema = @Schema(implementation = StudentResponse.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid data provided", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Student not found", content = @Content),
    })
    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    StudentResponse createStudent(StudentRequest request);

    @Operation(
            summary = "Solidifies an enrollment",
            description = "Finalize the enrollment process for a specific student"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Student's enrollment finished with success",
                    content = @Content(schema = @Schema(implementation = StudentResponse.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid data provided", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content),
            @ApiResponse(responseCode = "409", description = "Could not finish student's enrollment due to state constraints.", content = @Content),

    })
    @PatchMapping("/students/{studentId}/enrollment/finish")
    @ResponseStatus(HttpStatus.OK)
    StudentResponse finishEnrollment(@PathVariable Long studentId);


    @Operation(
            summary = "Rejects an enrollment",
            description = "Rejects the enrollment process for a specific student"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Student's enrollment rejected with success",
                    content = @Content(schema = @Schema(implementation = StudentResponse.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid data provided", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access Denied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Student not found", content = @Content),
            @ApiResponse(responseCode = "409", description = "Could not reject student's enrollment due to state constraints.", content = @Content),
    })

    @PatchMapping("/students/{studentId}/enrollment/approve")
    @ResponseStatus(HttpStatus.OK)
    StudentResponse rejectEnrollment(@PathVariable Long studentId);
}
