package com.api.projettransversal.placeSignatory.repository;

import com.api.projettransversal.placeSignatory.Entity.PlaceSignatory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlaceSignatoryRepository extends JpaRepository<PlaceSignatory,Long> {
    @Query("select CASE WHEN COUNT(pl) > 0 THEN true ELSE false END from PlaceSignatory pl where pl.namePlace=:name")
    boolean existsByName(@Param("name") String name);
    Optional<PlaceSignatory> findByNamePlace(String name);
}
