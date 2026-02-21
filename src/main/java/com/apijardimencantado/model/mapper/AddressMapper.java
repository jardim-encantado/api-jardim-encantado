package com.apijardimencantado.model.mapper;

import com.apijardimencantado.model.database.Address;
import com.apijardimencantado.model.dto.request.AddressRequest;
import com.apijardimencantado.model.dto.response.AddressResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address toEntity(AddressRequest request);

    AddressResponse toResponse(Address address);
}
