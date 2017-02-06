package com.itliusir.micro.controller;

import com.itliusir.micro.model.ResponseInfo;
import com.itliusir.micro.model.Users;
import com.itliusir.micro.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ysstech on 2017/1/24.
 */
@RestController
@RequestMapping("/users")
public class helloController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value="/", method= RequestMethod.GET)
    public ResponseInfo getAll(){
        List<Users> list = usersService.selectAll();
        return new ResponseInfo(1,list,"查询成功");
    }
}
