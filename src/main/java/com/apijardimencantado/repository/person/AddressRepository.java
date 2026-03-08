package com.apijardimencantado.repository.person;

import com.apijardimencantado.model.database.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findAddressByPerson_Id(Long id);
}
