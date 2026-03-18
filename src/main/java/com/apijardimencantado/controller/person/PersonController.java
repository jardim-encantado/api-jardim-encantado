package com.apijardimencantado.controller.person;

import com.apijardimencantado.controller.contract.person.PersonContract;
import com.apijardimencantado.model.dto.request.LoginRequest;
import com.apijardimencantado.model.dto.request.PersonRequest;
import com.apijardimencantado.model.dto.response.PersonResponse;
import com.apijardimencantado.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PersonController implements PersonContract {

    private final PersonService personService;

    @Override
    @PostMapping
    public PersonResponse create(@RequestBody PersonRequest personRequest) {
        return personService.create(personRequest);
    }

    @Override
    @PostMapping("/login")
    public PersonResponse login(
            @RequestBody LoginRequest loginRequest
    ) {
        return personService.login(loginRequest);
    }

    @Override
    @GetMapping("/person")
    public List<PersonResponse> getAll() {
        return personService.getAll();
    }

    @Override
    @GetMapping("/person/{id}")
    public PersonResponse getById(@PathVariable Long id) {
        return personService.getById(id);
    }

    @Override
    @PutMapping("/person/{id}")
    public PersonResponse update(
            @PathVariable Long id,
            @RequestBody PersonRequest personRequest
    ) {
        return personService.update(id, personRequest);
    }
}
