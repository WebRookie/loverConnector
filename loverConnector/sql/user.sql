
DROP  TABLE if exists users;
create table `user` (
    `user_id` int auto_increment primary key comment '用户id',
    `nickname` varchar(20) default null comment '用户昵称',
    `phone` varchar(30) default null comment '用户手机',
    `is_related` char(2) default '0' comment '是否有关联 0-无关联、1-有关联、2-关联已解除',
    `access_token` varchar (512) default null comment '小程序token',
    `create_date` timestamp not null  default  now()  comment '创建时间',
    `update_date`  timestamp not null  default now()  update now() comment '更改时间'
 )