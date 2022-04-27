package com.example.clinicaOdV2.Dao;


import com.example.clinicaOdV2.model.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio,Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE DOMICILIO SET calle=?1, numero=?2, localidad=?3, provincia=?4 WHERE ID=?5",nativeQuery = true)
    void modificarDomicilioPorID(String calle,String numero, String localidad, String provincia, Long ID);

}
