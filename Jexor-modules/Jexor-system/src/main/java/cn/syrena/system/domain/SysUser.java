package cn.syrena.system.domain;

import cn.syrena.common.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@TableName("tb_sys_user")
@Data
public class SysUser extends BaseEntity {
    @TableId(type = IdType.ASSIGN_ID)
    private Long userId;    // 此处主键不使用自增
    private String userAccount;
    private String password;

}
