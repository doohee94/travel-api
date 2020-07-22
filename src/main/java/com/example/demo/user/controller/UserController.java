package com.example.demo.user.controller;

import com.example.demo.user.dto.UserDto;
import com.example.demo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/sign-in")
    @ResponseStatus(HttpStatus.OK)
    public void signIn(String email, String password){
        userService.signIn(email, password);
    }

    @PostMapping(value = "/sign-up/member")
    @ResponseStatus(HttpStatus.OK)
    public void CreateMemberUser(@RequestBody UserDto.CreateMemberUser dto){
        userService.createMemberUser(dto);
    }

    @PostMapping(value = "/sign-up/company")
    @ResponseStatus(HttpStatus.CREATED)
    public void CreateCompanyUser(@RequestBody UserDto.CreateCompany dto){
        userService.createCompanyUSer(dto);
    }

    @GetMapping(value = "/admin/users")
    @ResponseStatus(HttpStatus.OK)
    public UserDto.ListResponse getUsers(){
     return new UserDto.ListResponse(  userService.getAllUsers()) ;
    }

}
