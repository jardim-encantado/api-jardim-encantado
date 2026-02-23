package com.apijardimencantado.model.mapper;


import com.apijardimencantado.model.database.Person;
import com.apijardimencantado.model.database.Role;
import com.apijardimencantado.model.dto.request.AddressRequest;
import com.apijardimencantado.model.dto.request.PersonRequest;
import com.apijardimencantado.model.dto.response.PersonResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface PersonMapper {
    @Mapping(target = "id", ignore = true)
    Person toEntity(PersonRequest request);

    @Mapping(source = "role.name", target = "roleName")
    PersonResponse toResponse(Person person);

}