package com.liyuan.controller.admin;

import com.liyuan.service.AdministratorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AuthenticationController {

    @Autowired
    private AdministratorServiceImpl administratorService;

}
