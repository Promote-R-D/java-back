package com.project.test.repository;

import com.project.test.entity.LocationCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationCategoryRepository extends JpaRepository<LocationCategory, Long> {
    @Query("SELECT DISTINCT lc.detailField FROM LocationCategory lc")
    List<String> findDistinctDetailFields();
    @Query("SELECT DISTINCT lc.systemName FROM LocationCategory lc WHERE lc.detailField = :detailField")
    List<String> findDistinctSystemNamesByDetailField(@Param("detailField") String detailField);

    Page<LocationCategory> findBySystemName(String systemName, Pageable pageable);
}
