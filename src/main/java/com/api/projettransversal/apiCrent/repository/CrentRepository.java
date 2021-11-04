package com.api.projettransversal.apiCrent.repository;

import com.api.projettransversal.apiCrent.entity.Crent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CrentRepository extends JpaRepository<Crent,Long> {
    @Query("select u from Crent u where  u.cni =:cni")
    Optional<Crent>  findByCni(@Param("cni") long cni);
}
