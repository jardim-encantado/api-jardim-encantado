package com.apijardimencantado.controller.event;

import com.apijardimencantado.controller.contract.event.SchoolEventContract;
import com.apijardimencantado.model.dto.request.SchoolEventRequest;
import com.apijardimencantado.model.dto.response.SchoolEventResponse;
import com.apijardimencantado.service.SchoolEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/schoolEvent")
public class SchoolEventController implements SchoolEventContract {

    private final SchoolEventService schoolEventService;

    @Override
    @PostMapping
    public ResponseEntity<SchoolEventResponse> create(@RequestBody SchoolEventRequest schoolEventRequest) {
        SchoolEventResponse response = schoolEventService.create(schoolEventRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<SchoolEventResponse>> getAll() {
        return ResponseEntity.ok(schoolEventService.getAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<SchoolEventResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(schoolEventService.getById(id));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<SchoolEventResponse> update(
            @PathVariable Long id,
            @RequestBody SchoolEventRequest schoolEventRequest
    ) {
        return ResponseEntity.ok(schoolEventService.update(id, schoolEventRequest));
    }

}
