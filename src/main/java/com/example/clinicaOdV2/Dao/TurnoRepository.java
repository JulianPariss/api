package com.example.clinicaOdV2.Dao;


import com.example.clinicaOdV2.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface TurnoRepository extends JpaRepository<Turno, Long> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE TURNO SET odontologo_id=?1, paciente_id=?2 WHERE ID=?3",nativeQuery = true)
    void asignarTurno(Long odontologo, Long paciente, Long ID);
}
