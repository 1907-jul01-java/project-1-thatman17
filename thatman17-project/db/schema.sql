drop table if exists employees;
drop table if exists transactions;

create table employees(id serial primary key, username text not null, password text not null, address text not null, permission boolean not null);
insert into employees(username, password, address, permission)
values ('Bruce', 'Banner', '1223 Kafe St.', false);
insert into employees(username, password, address, permission)
values ('Tony', 'Stank', 'Malibu Point, 10880', false);
insert into employees(username, password, address, permission)
values ('Scott', 'Lang', '1407 Graymalkin Lane', false);
insert into employees(username, password, address, permission)
values ('Nick', 'Fury', '1313 Theodore Rooselvelt Isl.', true);
insert into employees(username, password, address, permission)
values ('Stephen', 'Strange', '177A Bleecker St.', true);

create table transactions(id serial primary key, username text not null, cost decimal not null, picture text not null, validate integer not null, manager text);
insert into transactions(username, cost, picture, validate)
values ('Bruce', 300.25, 'Running from Local Authority', 0);
insert into transactions(username, cost, picture, validate)
values ('Bruce', 10.11, 'Banana Smoothie', 2);
insert into transactions(username, cost, picture, validate)
values ('Bruce', 85.67, 'Jet Refund', 1);

insert into transactions(username, cost, picture, validate)
values ('Tony', 30.5, 'Mechanized Suit', 0);
insert into transactions(username, cost, picture, validate)
values ('Tony', 5.15, 'Spider-Guy Costume', 0);
insert into transactions(username, cost, picture, validate)
values ('Tony', 21, 'Funeral', 0);

insert into transactions(username, cost, picture, validate)
values ('Scott', 250.55, 'Drum Set', 0);
insert into transactions(username, cost, picture, validate)
values ('Scott',12546.23, 'Tiny Trophy', 1);
insert into transactions(username, cost, picture, validate)
values ('Scott', 300003.55, 'Train Set', 0);
