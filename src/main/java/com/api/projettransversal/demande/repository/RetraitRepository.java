package com.api.projettransversal.demande.repository;

import com.api.projettransversal.demande.api.request.RetraitProjection;
import com.api.projettransversal.demande.entity.Retrait;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RetraitRepository extends JpaRepository<Retrait,Long> {
   @Query("select rt.cni as cni,rt.numero as numero from Retrait rt where rt.demande.id=:id")
    Optional<RetraitProjection> findRetrait(@Param("id") Long id);
    @Query("select rt from Retrait rt where rt.demande.id=:id")
    Retrait findDemande(@Param("id") Long id);
}
