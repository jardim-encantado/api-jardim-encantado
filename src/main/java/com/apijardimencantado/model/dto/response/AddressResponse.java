package com.apijardimencantado.model.dto.response;

public record AddressResponse(
        Long addressId,
        String street,
        String streetNumber,
        String cep,
        String complement,
        String city,
        String state

) {}