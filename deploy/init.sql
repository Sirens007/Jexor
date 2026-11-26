# 账号密码
# 表名小写 多个单词用下划线隔开 全部以tb开头

create table tb_sys_user (
    # 此处不设自增()
    user_id bigint unsigned not null comment '用户id(主键)',
    user_account varchar(20) not null comment '账号',
    password varchar(20) comment '密码',

    create_by bigint unsigned not null comment '创建人',
    create_time datetime not null comment '创建时间',
    update_by bigint unsigned comment '更新人',
    update_time datetime comment '更新时间',

    primary key (`user_id`),
    unique key `idx_user_account` (`user_account`)
);