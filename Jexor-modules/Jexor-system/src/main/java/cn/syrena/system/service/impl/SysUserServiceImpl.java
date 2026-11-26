package cn.syrena.system.service.impl;

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
    public LoginResult login(String userAccount, String password) {
        // 在数据库中匹配账号密码
        // select password from tb_sys_user where user_acount = #{userAccount}
        SysUser sysUser = sysUserMapper.selectOne(new LambdaQueryWrapper<SysUser>()
                .select(SysUser::getPassword)
                .eq(SysUser::getUserAccount, userAccount));

        LoginResult loginResult = new LoginResult();

        // 判断用户是否存在
        if (sysUser == null) {
            loginResult.setCode(0);
            loginResult.setMsg("当前用户不存在");
            return loginResult;
        }

        // 判断密码匹配
        if (sysUser.getPassword().equals(password)) {
            loginResult.setCode(1);
            return loginResult;
        }

        // 返回错误信息（密码不匹配，但不能让用户知道用户名存在）
        loginResult.setCode(0);
        loginResult.setMsg("账号或密码错误");
        return loginResult;
    }
}
