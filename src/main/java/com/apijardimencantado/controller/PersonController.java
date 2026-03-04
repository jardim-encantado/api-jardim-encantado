package com.apijardimencantado.controller;

import com.apijardimencantado.controller.contract.PersonContract;
import com.apijardimencantado.model.dto.request.PersonRequest;
import com.apijardimencantado.model.dto.response.PersonResponse;
import com.apijardimencantado.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
@RequiredArgsConstructor
public class PersonController implements PersonContract {

    private final PersonService personService;

    @Override
    @PostMapping
    public ResponseEntity<PersonResponse> create(@RequestBody PersonRequest personRequest) {
        PersonResponse response = personService.create(personRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<PersonResponse>> getAll() {
        return ResponseEntity.ok(personService.getAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<PersonResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(personService.getById(id));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<PersonResponse> update(
            @PathVariable Long id,
            @RequestBody PersonRequest personRequest
    ) {
        return ResponseEntity.ok(personService.update(id, personRequest));
    }
}
