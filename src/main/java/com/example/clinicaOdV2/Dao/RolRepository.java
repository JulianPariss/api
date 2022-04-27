package com.example.clinicaOdV2.Dao;

import com.example.clinicaOdV2.model.Rol;
import com.example.clinicaOdV2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    @Query("from Rol u where u.name =:name")
    Optional<Rol> getRolByName(@Param("name") String name);
}
