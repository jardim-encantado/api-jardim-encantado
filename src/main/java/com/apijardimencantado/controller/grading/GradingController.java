package com.apijardimencantado.controller.grading;

import com.apijardimencantado.controller.contract.grading.GradingContract;
import com.apijardimencantado.model.dto.request.GradingRequest;
import com.apijardimencantado.model.dto.response.GradingResponse;
import com.apijardimencantado.service.GradingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/grading")
@RequiredArgsConstructor
public class GradingController implements GradingContract {

    private final GradingService gradingService;

    @Override
    @PostMapping
    public GradingResponse create(@RequestBody GradingRequest request) {
        return gradingService.create(request);
    }

    @Override
    @GetMapping
    public List<GradingResponse> getAll() {
        return gradingService.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public GradingResponse getById(@PathVariable Long id) {
        return gradingService.getById(id);
    }

    @Override
    @PutMapping("/{id}")
    public GradingResponse update(
            @PathVariable Long id,
            @RequestBody GradingRequest request
    ) {
        return gradingService.update(id, request);
    }
}