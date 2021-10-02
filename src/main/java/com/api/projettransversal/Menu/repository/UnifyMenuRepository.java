package com.api.projettransversal.Menu.repository;

import com.api.projettransversal.Menu.Projection.UnifyMenuProjection;
import com.api.projettransversal.Menu.entity.UnifyMenu;
import com.api.projettransversal.Role.ERole;
import com.api.projettransversal.Role.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnifyMenuRepository extends JpaRepository<UnifyMenu,Long> {
    @Query("select u.name as name,u.nameRoute as nameRoute from UnifyMenu u where u.role.name=:role")
    List<UnifyMenuProjection> findByRole(@Param("role") ERole role);
}
