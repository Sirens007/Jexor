package cn.syrena.system.controller;

import cn.syrena.common.core.domain.R;
import cn.syrena.system.domain.LoginDTO;
import cn.syrena.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sysuser")
public class SysUserController {
    @Autowired
    private ISysUserService iSysUserService;

    @PostMapping("/login")
    public R<Void> login(@RequestBody LoginDTO loginDTO) {
        return iSysUserService.login(loginDTO.getUserAccount(), loginDTO.getPassword());
    }
}
