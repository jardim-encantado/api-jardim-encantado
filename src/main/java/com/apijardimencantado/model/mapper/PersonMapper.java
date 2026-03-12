package com.apijardimencantado.model.mapper;

import com.apijardimencantado.model.database.Person;
import com.apijardimencantado.model.database.Role;
import com.apijardimencantado.model.dto.request.PersonRequest;
import com.apijardimencantado.model.dto.response.AddressResponse;
import com.apijardimencantado.model.dto.response.PersonResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface PersonMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", source = "role")
    Person toEntity(PersonRequest request, Role role);

    @Mapping(source = "person.role.name", target = "roleName")
    @Mapping(source = "person.role.id", target = "roleId")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "person.cpf", target = "cpf")
    @Mapping(source = "person.phoneNumber",target = "phoneNumber")
    PersonResponse toResponse(Person person, AddressResponse address);
}