package cn.syrena.system.service;

import cn.syrena.common.core.domain.R;
import cn.syrena.system.controller.LoginResult;

public interface ISysUserService {
    R<Void> login(String userAccount, String password);
}
