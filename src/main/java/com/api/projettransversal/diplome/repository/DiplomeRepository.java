package com.api.projettransversal.diplome.repository;

import com.api.projettransversal.diplome.entity.Diplome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DiplomeRepository extends JpaRepository<Diplome,Long> {
    @Query("select case when count(dp)>0 then true else false end  from Diplome dp where dp.nomDiplome=:name")
    boolean existsByName(@Param("name") String name);
}
