-- drop database test;
create database test;

use test;

create table master(
    id int(11),
    name varchar(50),
    primary key (id)
);

create table detail(
id int(11),
master_id int(11),
value1 varchar(200),
value2 varchar(200),
primary key (id),
FOREIGN KEY master_ref(id) references master(id)
);

drop table detail;
drop table master;

