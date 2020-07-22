package com.example.demo.tourist.dto;

import com.example.demo.city.entity.City;
import com.example.demo.common.model.Address;
import com.example.demo.common.model.ListResult;
import com.example.demo.tourist.entity.Tourist;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TouristDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class TouristResponse {
        private Long id;
        private String name;
        private Address address;

        @Builder
        public TouristResponse(Tourist tourist) {
            this.id = tourist.getId();
            this.name = tourist.getName();
            this.address = tourist.getAddress();
        }

        public static List<TouristResponse> of(List<Tourist> tourists){
            return tourists.stream().map(TouristResponse::new).collect(Collectors.toList());
        }

        public static Page<TouristResponse> of(Page<Tourist> tourists) {
            return new PageImpl<>(tourists.stream().map(TouristResponse::new).collect(Collectors.toList()));
        }
    }

    @Getter
    public static class ListResponse extends ListResult<TouristResponse>{
        public ListResponse(List<TouristResponse> list) {
            super(list);
        }
    }


    @Getter
    public static class TouristCreate {
        private String name;
        private String cityAdr;
        private String loadAdr;
        private String zipcodeAdr;
        private String city;

        @Builder
        public TouristCreate(String name, String cityAdr, String loadAdr, String zipcodeAdr, String city) {
            this.name = name;
            this.cityAdr = cityAdr;
            this.loadAdr = loadAdr;
            this.zipcodeAdr = zipcodeAdr;
            this.city = city;
        }
    }

}
