package com.project.test.service;


import com.project.test.controller.LocationDto;
import com.project.test.controller.ResponseDto;
import com.project.test.controller.SearchDto;
import com.project.test.entity.MedicalInstitution;
import com.project.test.repository.MedicalInstitutionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GisService {
    private final MedicalInstitutionRepository medicalInstitutionRepository;


    @Transactional
    public ResponseDto<?> mIInfo(){
       List<MedicalInstitution> infos= medicalInstitutionRepository.findAll();
       return ResponseDto.success(infos);
    }
    @Transactional
    public ResponseDto<?> mIInfoCh(){
//        List<MedicalInstitution> infos= medicalInstitutionRepository.findByGu("흥덕구");
        List<MedicalInstitution> infos= medicalInstitutionRepository.findByGuLimit();
        return ResponseDto.success(infos);
    }
//    @Transactional
//    public ResponseDto<?> LeaderSelect(Long id) {
//        Employee employee = isPresentEmployee(id);
//        if(employee.getLeader().contains("false")){
//            employee.updateLeader(id);
//        }else{
//            employee.cancelLeader(id);
//        }
//        employee.save(employee)
//        return ResponseDto.success("바뀜");
//    }
    public ResponseDto<?> locationTo(LocationDto locationDto,Long km){
//        List<MedicalInstitution> withinRadius = medicalInstitutionRepository.findWithinRadius(locationDto.getLat(), locationDto.getLng(), 5.0);
        List<MedicalInstitution> withinRadius = medicalInstitutionRepository.findNearbyLocations(locationDto.getLat(), locationDto.getLng(), km);
        return ResponseDto.success(withinRadius);
    }

    }
