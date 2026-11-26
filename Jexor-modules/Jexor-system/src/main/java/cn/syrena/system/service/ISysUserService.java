package cn.syrena.system.service;

import cn.syrena.system.controller.LoginResult;

public interface ISysUserService {
    LoginResult login(String userAccount, String password);
}
