package com.example.demo.tourist.service;

import com.example.demo.city.entity.City;
import com.example.demo.city.exception.NotFoundCityException;
import com.example.demo.city.repository.CityRepository;
import com.example.demo.common.model.PageRequest;
import com.example.demo.tourist.dto.TouristDto;
import com.example.demo.tourist.dto.TouristReviewDto;
import com.example.demo.tourist.entity.Tourist;
import com.example.demo.tourist.repository.TouristRepository;
import com.example.demo.tourist.repository.TouristRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TouristAdminService {

    private final TouristRepository touristRepository;
    private final CityRepository cityRepository;

    public List<TouristDto.TouristResponse> getTourists() {
        List<Tourist> tourists = touristRepository.findAll();
        return TouristDto.TouristResponse.of(tourists);
    }

    public Page<TouristDto.TouristResponse> getTouristsByType(String type, String keyword, PageRequest pageRequest){

        Page<Tourist> tourists = touristRepository.findByType(type, keyword, pageRequest.of());

        return TouristDto.TouristResponse.of(tourists);
    }

    public void createTourist(TouristDto.TouristCreate touristDto) {
        City city = cityRepository.findByAddress_City(touristDto.getCity()).orElseThrow(NotFoundCityException::new);

        touristRepository.save(Tourist.builder()
                .cityStr(touristDto.getCity())
                .load(touristDto.getLoadAdr())
                .zipcode(touristDto.getZipcodeAdr())
                .cityObj(city)
                .name(touristDto.getName())
                .build());

    }

    public void deleteTourist(Long id) {
        Tourist tourist = touristRepository.findById(id).orElseThrow(NullPointerException::new);
        tourist.deleteTourist();
    }

    public List<TouristReviewDto.ReviewRes> getTouristReviews() {

        List<Tourist> tourists = touristRepository.findAllForTourist();

        List<TouristReviewDto.ReviewRes> list = new ArrayList<>();
        for (Tourist tourist : tourists) {
            list.addAll(tourist.getTouristReviews().stream() .map(TouristReviewDto.ReviewRes::new)
                    .collect(Collectors.toList()));
        }

        return list;
    }
}
