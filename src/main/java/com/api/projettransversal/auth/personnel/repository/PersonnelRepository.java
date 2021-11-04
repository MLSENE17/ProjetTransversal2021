package com.api.projettransversal.auth.personnel.repository;

import com.api.projettransversal.auth.personnel.api.request.ProjectionPersonnel;
import com.api.projettransversal.auth.personnel.entity.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel,Long> {
    @Query("select case when count(pl)>0 then true else false end from Personnel pl where  pl.email=:email")
    boolean existsByEmail(@Param("email") String email);
    Optional<Personnel> findByEmail(String email);
    @Query("select case when count(pl)>0 then true else false end from Personnel  pl where pl.placeSignatory.id=:id")
    boolean existByPlace(@Param("id") Long id);
    @Query("select p.id as id,p.prenom as prenom,p.nom as nom,p.email as email," +
            "p.placeSignatory.namePlace as place from Personnel p")
    List<ProjectionPersonnel> getAll();
}
