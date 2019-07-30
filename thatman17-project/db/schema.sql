drop table if exists employees;
drop table if exists transactions;

create table employees(id serial primary key, username text not null, password text not null, address text not null);
insert into employees(username, password, address)
values ('Bruce', 'Banner', '1223 Kafe St.');
insert into employees(username, password, address)
values ('Tony', 'Stank', 'Malibu Point, 10880');
insert into employees(username, password, address)
values ('Charles', 'Xavier', '1407 Graymalkin Lane');

create table transactions(id serial primary key, username integer references employees(id) not null, cost decimal not null, picture text not null, validate integer not null);
insert into transactions(username, cost, picture, validate)
values (1, 300.25, 'kitten.jpg', 0);
insert into transactions(username, cost, picture, validate)
values (1, 10.11, 'kitten2.jpg', 2);
insert into transactions(username, cost, picture, validate)
values (1, 85.67, 'kitten3.jpg', 1);

insert into transactions(username, cost, picture, validate)
values (2, 30.5, 'puppy.jpg', 0);
insert into transactions(username, cost, picture, validate)
values (2, 5.15, 'puppy2.jpg', 0);
insert into transactions(username, cost, picture, validate)
values (2, 21, 'puppy3.jpg', 0);

insert into transactions(username, cost, picture, validate)
values (3, 250.55, 'koala.jpg', 0);
insert into transactions(username, cost, picture, validate)
values (3,12546.23, 'koala2.jpg', 1);
insert into transactions(username, cost, picture, validate)
values (3, 300003.55, 'koala3.jpg', 0);
