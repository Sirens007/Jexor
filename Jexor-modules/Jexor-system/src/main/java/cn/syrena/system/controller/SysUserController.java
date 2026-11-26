package cn.syrena.system.controller;

import cn.syrena.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sysuser")
public class SysUserController {
    @Autowired
    private ISysUserService iSysUserService;

    @PostMapping()
    public LoginResult login(String userAccount, String password) {
        return iSysUserService.login(userAccount, password);
    }
}
