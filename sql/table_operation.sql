create table t_owners (
    id            number primary key,
    name          varchar2(30),
    address       number,
    house_number  varchar2(30),
    water_meter   varchar2(30),
    add_date      date,
    owner_type_id number
);

insert into t_owners (id, name) values (1, 'mary');

update t_owners set id = 2 where id = 1;

select * from t_owners;

delete from t_owners where id = 2;
