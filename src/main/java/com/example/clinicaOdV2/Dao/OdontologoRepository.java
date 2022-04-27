package com.example.clinicaOdV2.Dao;

import com.example.clinicaOdV2.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo,Long> {

    @Query(value = "SELECT * FROM ODONTOLOGO WHERE ID=?1", nativeQuery = true)
    Optional<Odontologo> buscarOdontologoPorID(Long ID);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ODONTOLOGO SET nombre=?1, apellido=?2, matricula=?3 WHERE ID=?4",nativeQuery = true)
    void actualizarOdontologoPorID(String nombre,String apellido, String matricula,Long ID);
}
