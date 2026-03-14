package com.apijardimencantado.controller.event;

import com.apijardimencantado.controller.contract.event.SchoolEventTypeContract;
import com.apijardimencantado.model.dto.response.SchoolEventTypeResponse;
import com.apijardimencantado.service.SchoolEventTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/schoolEventType")
public class SchoolEventTypeController implements SchoolEventTypeContract {
    private final SchoolEventTypeService schoolEventTypeService;
    @Override
    @GetMapping
    public ResponseEntity<List<SchoolEventTypeResponse>> getAll() {
        return ResponseEntity.ok(schoolEventTypeService.getAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<SchoolEventTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(schoolEventTypeService.getById(id));
    }

}
