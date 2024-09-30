package br.gov.sp.fatec.springtopicos20242.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.gov.sp.fatec.springtopicos20242.entity.Trabalho;

public interface TrabalhoRepository extends JpaRepository<Trabalho, Long> {

    @Query("SELECT t FROM Trabalho t WHERE t.titulo LIKE %:palavra% AND t.nota > :nota")
    List<Trabalho> findByTituloContainingAndNotaGreaterThan(@Param("palavra") String palavra, @Param("nota") int nota);
}
