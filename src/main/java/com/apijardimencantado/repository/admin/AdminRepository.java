package com.apijardimencantado.repository;

import com.apijardimencantado.model.database.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
