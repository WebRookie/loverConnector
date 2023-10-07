
drop table if exists  relation;
create table `relation`(
    `id` varchar(20) primary key not null comment '关联记录id',
    `relation_send_id` int not null comment '关联发起id',
    `relation_receive_id` int not null comment '关联接受id',
    `status` char(2) default '1' comment '关联状态：1-绑定中、 2-已解除',
    `create_date` timestamp default now() comment '创建时间',
    `update_date` timestamp default now() on update now() comment'更改时间'
)