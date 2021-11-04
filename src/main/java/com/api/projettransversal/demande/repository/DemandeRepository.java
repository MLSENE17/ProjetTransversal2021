package com.api.projettransversal.demande.repository;

import com.api.projettransversal.demande.api.request.DemandeProjection;
import com.api.projettransversal.demande.entity.Demande;
import com.api.projettransversal.diplome.entity.Diplome;
import com.api.projettransversal.etudiant.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandeRepository extends JpaRepository<Demande, Long> {
    @Query("select case when count(dm)>0 then true else  false end from Demande dm where dm.valide=false and " +
            "dm.diplome=:diplome and dm.etudiant=:etudiant")
    boolean existDemande(@Param("diplome") Diplome diplome, @Param("etudiant")Etudiant etudiant);
    @Query("select dm.diplome.nomDiplome as diplome,dm.createAt as create,dm.valide as valide from Demande dm order by dm.createAt desc")
    List<DemandeProjection> findAllEtudiant(Etudiant etudiant);
    @Query("select dm.id as id,dm.diplome.nomDiplome as diplome,dm.createAt as create,dm.valide as valide from Demande dm where dm.valide=false and dm.etudiant=:etudiant order by dm.createAt desc")
    List<DemandeProjection> findAllEtudiantCours(@Param("etudiant") Etudiant etudiant);
}
