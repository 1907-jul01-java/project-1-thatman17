drop table if exists employees;
drop table if exists transactions;

create table employees(id serial primary key, username text not null, password text not null, address text not null, permission boolean not null);
insert into employees(username, password, address, permission)
values ('Bruce', 'Banner', '1223 Kafe St.', false);
insert into employees(username, password, address, permission)
values ('Tony', 'Stank', 'Malibu Point, 10880', false);
insert into employees(username, password, address, permission)
values ('Charles', 'Xavier', '1407 Graymalkin Lane', false);
insert into employees(username, password, address, permission)
values ('Nick', 'Fury', '1313 Theodore Rooselvelt Isl.', true);
insert into employees(username, password, address, permission)
values ('Stephen', 'Strange', '177A Bleecker St.', true);

create table transactions(id serial primary key, username text not null, cost decimal not null, picture text not null, validate integer not null);
insert into transactions(username, cost, picture, validate)
values ('Bruce', 300.25, 'kitten.jpg', 0);
insert into transactions(username, cost, picture, validate)
values ('Bruce', 10.11, 'kitten2.jpg', 2);
insert into transactions(username, cost, picture, validate)
values ('Bruce', 85.67, 'kitten3.jpg', 1);

insert into transactions(username, cost, picture, validate)
values ('Tony', 30.5, 'puppy.jpg', 0);
insert into transactions(username, cost, picture, validate)
values ('Tony', 5.15, 'puppy2.jpg', 0);
insert into transactions(username, cost, picture, validate)
values ('Tony', 21, 'puppy3.jpg', 0);

insert into transactions(username, cost, picture, validate)
values ('Charles', 250.55, 'koala.jpg', 0);
insert into transactions(username, cost, picture, validate)
values ('Charles',12546.23, 'koala2.jpg', 1);
insert into transactions(username, cost, picture, validate)
values ('Charles', 300003.55, 'koala3.jpg', 0);
