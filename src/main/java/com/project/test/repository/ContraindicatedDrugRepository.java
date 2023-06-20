package com.project.test.repository;

import com.project.test.entity.ContraindicatedDrug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContraindicatedDrugRepository extends JpaRepository<ContraindicatedDrug,Long > {
    @Query("SELECT cd FROM ContraindicatedDrug cd WHERE (cd.productNameA LIKE %:drug1% AND cd.productNameB LIKE %:drug2%) OR (cd.productNameA LIKE %:drug2% AND cd.productNameB LIKE %:drug1%)")
    List<ContraindicatedDrug> findContraindicatedDrugs(@Param("drug1") String drug1, @Param("drug2") String drug2);
}
