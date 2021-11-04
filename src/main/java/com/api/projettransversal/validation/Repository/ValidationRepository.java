package com.api.projettransversal.validation.Repository;


import com.api.projettransversal.demande.entity.Demande;
import com.api.projettransversal.validation.Entity.Validation;
import com.api.projettransversal.validation.api.request.ValidationProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ValidationRepository extends JpaRepository<Validation,Long> {
    @Query("select vl.message as message,vl.updateAt as update from Validation vl where vl.demande=:demande ")
    List<ValidationProjection> getAllValidation(@Param("demande") Demande demande);
}
