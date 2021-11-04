package com.api.projettransversal.validation.Repository;


import com.api.projettransversal.demande.entity.Demande;
import com.api.projettransversal.signataire.api.Request.SignataireProjection;
import com.api.projettransversal.placeSignatory.Entity.PlaceSignatory;
import com.api.projettransversal.validation.Entity.Validation;
import com.api.projettransversal.validation.ResponseEnum;
import com.api.projettransversal.validation.api.request.ValidationProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ValidationRepository extends JpaRepository<Validation,Long> {
    @Query("select vl.demande.diplome.nomDiplome as name,vl.response as response," +
            "vl.placeSignatory.namePlace as place,vl.message as message" +
            " from Validation vl where vl.demande=:demande ")
    List<ValidationProjection> getAllValidation(@Param("demande") Demande demande);
    @Query("select case when count(dm)>3 then true else  false end from Validation dm " +
            "where dm.demande=:demande and dm.response=:responseEnum")
    boolean isValid(@Param("demande") Demande demande, ResponseEnum responseEnum);
    @Query("select vl.id as id,vl.demande.etudiant.prenom as prenom, vl.demande.etudiant.nom as nom, " +
            "vl.demande.etudiant.numeroEtudiant as numero,vl.demande.diplome.nomDiplome as diplome," +
            "vl.response as response,vl.message as message   from Validation vl where vl.placeSignatory=:placeSignatory and" +
            "(:numero is null or upper(vl.demande.etudiant.numeroEtudiant) = :numero) and " +
            "(:status is null or vl.response = :status)")
    List<SignataireProjection> AllBySign(
            @Param("placeSignatory") PlaceSignatory placeSignatory,
            @Param("numero") String numero,
            @Param("status") ResponseEnum status
    );
    @Query("select vl.id as id,vl.demande.etudiant.prenom as prenom, vl.demande.etudiant.nom as nom, " +
            "vl.demande.etudiant.numeroEtudiant as numero,vl.demande.diplome.nomDiplome as diplome," +
            "vl.response as response,vl.message as message from Validation vl " +
            "where vl.id=:id and vl.placeSignatory=:placeSignatory")
    Optional<SignataireProjection> getOne(
            @Param("id") Long id,@Param("placeSignatory")  PlaceSignatory placeSignatory
    );
}
