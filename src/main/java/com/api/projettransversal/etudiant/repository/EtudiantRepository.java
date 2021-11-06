package com.api.projettransversal.etudiant.repository;
import com.api.projettransversal.etudiant.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    @Query("select case when count(pl)>0 then true else false end from Etudiant pl where  pl.email=:email")
    boolean existsByEmail(@Param("email") String email);
    Optional<Etudiant> findByEmail(String email);
    @Query("select case when count(pl)>0 then true else false end from Etudiant pl where  pl.numeroEtudiant =:numeroEtudiant")
    boolean existsByNumero(@Param("numeroEtudiant") String numeroEtudiant);
    @Query("select case when count(pl)>0 then true else false end from Etudiant pl where  pl.cni=:cni")
    boolean existsByCni(@Param("cni") String cni);
    @Query("select case when count(pl)>0 then true else false end from Etudiant pl where  pl.numeroTelephone=:numeroTelephone")
    boolean existsBynumeroTelephone(@Param("numeroTelephone") String numeroTelephone);
}
