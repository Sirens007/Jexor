package cn.syrena.system.service.impl;

import cn.syrena.common.core.domain.R;
import cn.syrena.common.core.domain.enums.ResultCode;
import cn.syrena.system.controller.LoginResult;
import cn.syrena.system.domain.SysUser;
import cn.syrena.system.mapper.SysUserMapper;
import cn.syrena.system.service.ISysUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public R<Void> login(String userAccount, String password) {
        // 在数据库中匹配账号密码
        // select password from tb_sys_user where user_acount = #{userAccount}
        SysUser sysUser = sysUserMapper.selectOne(new LambdaQueryWrapper<SysUser>()
                .select(SysUser::getPassword)
                .eq(SysUser::getUserAccount, userAccount));

        R loginResult = new R();

        // 判断用户是否存在
        if (sysUser == null) {
            loginResult.setCode(ResultCode.FAILED_USER_NOT_EXISTS.getCode());
            loginResult.setMsg(ResultCode.FAILED_USER_NOT_EXISTS.getMsg());
            return loginResult;
        }

        // 判断密码匹配
        if (sysUser.getPassword().equals(password)) {
            loginResult.setCode(ResultCode.SUCCESS.getCode());
            loginResult.setMsg(ResultCode.SUCCESS.getMsg());
            return loginResult;
        }

        // 返回错误信息（密码不匹配，但不能让用户知道用户名存在）
        loginResult.setCode(ResultCode.FAILED_LOGIN.getCode());
        loginResult.setMsg(ResultCode.FAILED_LOGIN.getMsg());
        return loginResult;
    }
}
