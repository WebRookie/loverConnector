drop table if exists record;
create table `record`(
    `id` int(10) auto_increment  not null primary key comment '记录Id',
    `user_id` int(11) not null comment '用户Id',
    `record_type` char(10) not null comment '记录类型 1-收入、2-支出',
    `record_content` varchar(500) default null comment '记录内容备注',
    `price` decimal(10, 2) not null comment '记录金额',
    `delete_flag` char(10) default '1' not null comment '删除状态： 1-正常、2-已删除',
    `create_date` DATETIME not null default now() comment '创建时间',
    `update_date` DATETIME not null default now() on update now() comment '更新时间'
) comment '用户记账记录表';