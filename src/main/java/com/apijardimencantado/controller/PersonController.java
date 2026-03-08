package com.apijardimencantado.controller;

import com.apijardimencantado.controller.contract.PersonContract;
import com.apijardimencantado.model.dto.request.LoginRequest;
import com.apijardimencantado.model.dto.request.PersonRequest;
import com.apijardimencantado.model.dto.response.PersonResponse;
import com.apijardimencantado.service.PersonService;
import lombok.RequiredArgsConstructor;
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
    public PersonResponse create(@RequestBody PersonRequest personRequest) {
        return personService.create(personRequest);
    }

    @Override
    @GetMapping
    public List<PersonResponse> getAll() {
        return personService.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public PersonResponse getById(@PathVariable Long id) {
        return personService.getById(id);
    }

    @Override
    @PutMapping("/{id}")
    public PersonResponse update(
            @PathVariable Long id,
            @RequestBody PersonRequest personRequest
    ) {
        return personService.update(id, personRequest);
    }

    @Override
    @PostMapping("/login")
    public ResponseEntity<PersonResponse> login(
            @RequestBody LoginRequest loginRequest
    ) {
        return ResponseEntity.ok(personService.login(loginRequest));
    }
}
