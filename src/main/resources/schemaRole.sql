create table authorities
(
    id   int generated always as identity primary key ,
    name varchar2(50) not null
);

create table roles
(
    id int generated always as identity primary key ,
    name varchar2(50) not null
);

create table roles_authority(
                                role_id int,
                                auth_id int,
                                foreign key (role_id) references roles(id),
                                foreign key (auth_id) references authorities(id),
                                primary key (role_id,auth_id)
);

alter table ACCOUNT
    add role_id int;

alter table ACCOUNT
    add constraint fk_supplier
        foreign key (role_id)
            references roles(id);
insert into authorities (NAME)
values ('read-own');
insert into authorities (NAME)
values ('write-own');
insert into authorities (NAME)
values ('edit-own');

insert into roles (name)
values ('user');
insert into roles (name)
values ('premium user');

commit;

select * from authorities