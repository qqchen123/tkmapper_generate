package com.myxx.tktest.controller;

import com.myxx.tktest.mapper.CountryMapper;
import com.myxx.tktest.mapper.UserMapper;
import com.myxx.tktest.pojo.Country;
import com.myxx.tktest.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/index")
@RestController
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CountryMapper countryMapper;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userMapper.selectAll();
    }

    @GetMapping("/countrys")
    public List<Country> getCountrys(){
        return countryMapper.selectAll();
    }
}
