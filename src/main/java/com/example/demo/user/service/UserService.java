package com.example.demo.user.service;

import com.example.demo.city.entity.City;
import com.example.demo.city.entity.UserLikeCity;
import com.example.demo.city.repository.CityRepository;
import com.example.demo.city.repository.UserLikeCityRepository;
import com.example.demo.company.entity.Company;
import com.example.demo.company.entity.CompanyReview;
import com.example.demo.company.repository.CompanyRepository;
import com.example.demo.tourist.entity.Tourist;
import com.example.demo.tourist.repository.TouristRepository;
import com.example.demo.user.dto.UserDto;
import com.example.demo.user.entity.Role;
import com.example.demo.user.entity.User;
import com.example.demo.user.exception.NotFoundUserException;
import com.example.demo.user.repository.RoleRepository;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CityRepository cityRepository;
    private final UserLikeCityRepository userLikeCityRepository;
    private final TouristRepository touristRepository;
    private final CompanyRepository companyRepository;

    public void signIn(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        if (user == null) {
            throw new NotFoundUserException();
        }
    }

    public void createMemberUser(UserDto.CreateMemberUser userDto) {

        Role role = roleRepository.findByUserRole("MEMBER");
        User user = UserDto.CreateMemberUser.toEntity(userDto, role);

        List<City> cities = userDto.getUserLikeCities().stream()
                .map(city -> cityRepository.findByAddress_City(city).orElseThrow(NullPointerException::new))
                .collect(Collectors.toList());

        List<UserLikeCity> userLikeCities = cities.stream()
                .map(city -> UserLikeCity.builder().city(city).user(user).build())
                .collect(Collectors.toList());

        userRepository.save(user);
        userLikeCityRepository.saveAll(userLikeCities);

    }

    public void createCompanyUSer(UserDto.CreateCompany userDto){

        Role role = roleRepository.findByUserRole("COMPANY");
        User user = UserDto.CreateCompany.toEntity(userDto, role);

        Tourist tourist = touristRepository.findById(userDto.getCompany().getTourist()).orElseThrow(NullPointerException::new);
        Company company = UserDto.CreateCompany.toEntity(userDto, user,tourist);

        userRepository.save(user);
        companyRepository.save(company);
    }

    public List<UserDto.UserRes> getAllUsers() {
        return userRepository.findAll().stream().map(UserDto.UserRes::new).collect(Collectors.toList());
    }
}
