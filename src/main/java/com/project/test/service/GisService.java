package com.project.test.service;


import com.project.test.controller.LocationDto;
import com.project.test.controller.ResponseDto;
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
//    public ResponseDto<?> locationTo(LocationDto locationDto,Long km){
////        List<MedicalInstitution> withinRadius = medicalInstitutionRepository.findWithinRadius(locationDto.getLat(), locationDto.getLng(), 5.0);
//        List<MedicalInstitution> withinRadius = medicalInstitutionRepository.findNearbyLocations(locationDto.getLat(), locationDto.getLng(), km);
//        return ResponseDto.success(withinRadius);
//    }
public ResponseDto<?> locationTo(LocationDto locationDto, Long km) {
    double latitude = locationDto.getLat();
    double longitude = locationDto.getLng();

    List<MedicalInstitution> withinRadius = medicalInstitutionRepository.findNearbyLocationsOrderedByDistance(latitude, longitude, km);

    for (MedicalInstitution medicalInstitution : withinRadius) {
        double distanceInMeters = calculateDistance(latitude, longitude, medicalInstitution.getLat(), medicalInstitution.getLng());
        String formattedDistance = formatDistance(distanceInMeters);
        medicalInstitution.setDistance(formattedDistance);
    }

    return ResponseDto.success(withinRadius);
}

    private double calculateDistance(double lat1, double lng1, double lat2, double lng2) {
        double earthRadius = 6371; // 지구의 반지름 (단위: km)

        // 두 지점의 위도 차이와 경도 차이를 라디안 단위로 변환
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);

        // 위도 차이와 경도 차이에 대한 삼각 함수를 적용하여 거리 계산 (단위: km)
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLng / 2) * Math.sin(dLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distanceInKm = earthRadius * c;

        // km를 m로 변환하여 반환 (1 km = 1000 m)
        return distanceInKm * 1000;
    }

    private String formatDistance(double distanceInMeters) {
        if (distanceInMeters >= 1000) {
            double distanceInKm = distanceInMeters / 1000.0;
            return String.format("%.1f km", distanceInKm);
        } else {
            return String.format("%.0f m", distanceInMeters);
        }
    }

    }
