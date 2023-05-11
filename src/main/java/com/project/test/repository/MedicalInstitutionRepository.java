package com.project.test.repository;

import com.project.test.entity.MedicalInstitution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalInstitutionRepository extends JpaRepository<MedicalInstitution,Long > {
    List<MedicalInstitution> findByGu(String gu);
    @Query(value="SELECT * FROM medical_institution WHERE gu='서원구' limit 100",nativeQuery = true)
    List<MedicalInstitution> findByGuLimit();
    @Query(value="SELECT * FROM medical_institution m WHERE" +
            " m.hospital_name LIKE %?% " +
            "AND m.ddo LIKE %?% " +
            "AND m.si LIKE %?% " +
            "AND m.dong LIKE %?% " +
            "AND m.medical_institution LIKE %?% " +
            "AND m.medical_department LIKE %?%"
            ,nativeQuery = true)
    List<MedicalInstitution> search(String hp,
                                    String ddo,
                                    String si,
                                    String dong,
                                    String mi,
                                    String md);
    @Query("SELECT l FROM MedicalInstitution l WHERE " +
            "(6371 * acos(cos(radians(:latitude)) * " +
            "cos(radians(l.lat)) * " +
            "cos(radians(l.lng) - " +
            "radians(:longitude)) + " +
            "sin(radians(:latitude)) * " +
            "sin(radians(l.lat)))) <= :radius")
    List<MedicalInstitution> findNearbyLocations(
            @Param("latitude") double latitude,
            @Param("longitude") double longitude,
            @Param("radius") double radius);
    @Query("SELECT h FROM MedicalInstitution h WHERE lower(h.hospitalName) LIKE lower(concat('%', :name, '%'))")
    List<MedicalInstitution> findByNameFuzzyMatch(@Param("name") String name);
    @Query("SELECT h FROM MedicalInstitution h WHERE lower(h.medicalDepartment) LIKE lower(concat('%', :name, '%'))")
    List<MedicalInstitution> findByMdFuzzyMatch(@Param("name") String name);
//    @Query(value = "SELECT * FROM medical_institution WHERE medical_department REGEXP '^:name$'",nativeQuery = true)
//    List<MedicalInstitution> findByMdFuzzyMatch(@Param("name") String name);
}
