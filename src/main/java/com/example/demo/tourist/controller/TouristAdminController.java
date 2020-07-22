package com.example.demo.tourist.controller;

import com.example.demo.common.model.PageRequest;
import com.example.demo.tourist.dto.TouristDto;
import com.example.demo.tourist.dto.TouristReviewDto;
import com.example.demo.tourist.service.TouristAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/travel/admin")
@RequiredArgsConstructor
public class TouristAdminController {

    private final TouristAdminService touristAdminService;

    @GetMapping(value = "/tourists")
    public TouristDto.ListResponse getTourists(){
        return new TouristDto.ListResponse(touristAdminService.getTourists());
    }

    @GetMapping(value = "/tourists/{type}")
    public Page<TouristDto.TouristResponse> getTouristsByType(@PathVariable  String type, String keyword, PageRequest pageRequest){
        return touristAdminService.getTouristsByType(type, keyword,pageRequest);
    }

    @PostMapping(value = "/tourist")
    public void createTourist(@RequestBody TouristDto.TouristCreate touristDto){
        touristAdminService.createTourist(touristDto);
    }

    @DeleteMapping(value = "/tourist")
    public void deleteTourist(Long id){
        touristAdminService.deleteTourist(id);
    }

    @GetMapping(value = "/tourist/review")
    @ResponseStatus(HttpStatus.OK)
    public TouristReviewDto.ListResponse getReviews(){
        return new TouristReviewDto.ListResponse(touristAdminService.getTouristReviews());
    }

    //코멘트는 리뷰컨트롤러쪽 사용하기 된다면..ㅎ _ㅎ...


}
