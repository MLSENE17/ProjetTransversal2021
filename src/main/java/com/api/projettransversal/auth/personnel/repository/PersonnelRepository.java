package com.api.projettransversal.auth.personnel.repository;

import com.api.projettransversal.auth.personnel.entity.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel,Long> {
    @Query("select case when count(pl)>0 then true else false end from Personnel pl where  pl.email=:email")
    boolean existsByEmail(@Param("email") String email);
}
