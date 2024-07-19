create database mini_test2;
use mini_test2;

create table categorytour
(
    id           int not null primary key,
    categoryCode varchar(255),
    categoryName varchar(255)
);
alter table categorytour
    change column id id int auto_increment;

create table city
(
    id       int not null auto_increment primary key,
    cityName varchar(255)
);

create table clients
(
    id          int not null primary key,
    nameClients varchar(255),
    idNumber    varchar(255),
    dateBirth   date,
    city_id     int,
    foreign key (city_id) references city (id)
);
alter table clients
    change column id id int auto_increment;

create table destination
(
    id              int not null auto_increment primary key,
    destinationName varchar(255),
    cost            int,
    city_id         int,
    foreign key (city_id) references city (id)
);

create table tour
(
    id             int not null auto_increment primary key,
    tourCode       varchar(255),
    category_id    int,
    foreign key (category_id) references categorytour (id),
    destination_id int,
    foreign key (destination_id) references destination (id),
    dateStart      date,
    dateEnd        date
);

create table ordertour
(
    id         int not null auto_increment primary key,
    tour_id    int,
    foreign key (tour_id) references tour (id),
    clients_id int,
    foreign key (clients_id) references clients (id),
    statuss    varchar(255)
);

select *
from clients;
select *
from destination;
select *
from city;
select *
from tour;
select *
from categorytour;
select *
from ordertour;
insert into categorytour(categoryCode, categoryName) value ('VIP1', 'Goi Vip 1');
insert into categorytour(categoryCode, categoryName) value ('VIP2', 'Goi Vip 2');

insert into city(cityName) value ('HN');
insert into city(cityName) value ('DN');
insert into city(cityName) value ('Hue');
insert into city(cityName) value ('HY');
insert into city(cityName) value ('BN');

insert into clients(nameClients, idNumber, dateBirth, city_id) value ('Manh', 111111111, '2001-01-19', 1);
insert into clients(nameClients, idNumber, dateBirth, city_id) value ('Quan', 222222222, '2001-01-19', 2);
insert into clients(nameClients, idNumber, dateBirth, city_id) value ('Trang', 333333333, '2001-01-20', 3);
insert into clients(nameClients, idNumber, dateBirth, city_id) value ('Nguyen', 4444444444, '2001-02-19', 4);
insert into clients(nameClients, idNumber, dateBirth, city_id) value ('Nam', 55555, '2001-03-19', 5);
insert into clients(nameClients, idNumber, dateBirth, city_id) value ('Son', 66666, '2001-04-19', 1);
insert into clients(nameClients, idNumber, dateBirth, city_id) value ('Hung', 77777, '2001-05-19', 1);
insert into clients(nameClients, idNumber, dateBirth, city_id) value ('Quang', 88888, '2001-06-19', 2);
insert into clients(nameClients, idNumber, dateBirth, city_id) value ('Tung', 99999, '2001-07-19', 3);
insert into clients(nameClients, idNumber, dateBirth, city_id) value ('Kien', 111112, '2001-08-19', 3);

insert into destination(destinationName, cost, city_id) value
    ('Lang bac', 100, 1),
    ('Bien Da Nang', 200, 2),
    ('Co do Hue', 300, 3),
    ('Ecopark', 400, 4),
    ('KCN', 300, 5);

select *
from destination;
select *
from categorytour;

insert into tour(tourCode, category_id, destination_id, dateStart, dateEnd) value
    ('HN01', 1, 1, '2024-07-10', '2024-07-14'),
    ('HN02', 2, 1, '2024-07-9', '2024-07-14'),
    ('DN01', 2, 1, '2024-06-15', '2024-06-20');

select *
from clients;

insert into ordertour(tour_id, clients_id, statuss) VALUE
    (1, 1, 'statuss 1'),
    (2, 1, 'statuss 2'),
    (3, 1, 'statuss 3'),
    (1, 2, 'statuss 4'),
    (1, 3, 'statuss 5'),
    (1, 4, 'statuss 6'),
    (1, 5, 'statuss 7'),
    (1, 6, 'statuss 8'),
    (1, 7, 'statuss 9'),
    (1, 7, 'statuss 10');

select *
from destination;
#Thống kê số lượng tour của các thành phố
select city.cityName, count(destination.destinationName) as number
from destination
         right join city on destination.city_id = city.id group by city.cityName ;

#Tính số tour có ngày bắt đầu trong tháng 3 năm 2020 ( dùng count)
select * from tour;
select count(dateStart) as numberMonth7 from tour where MONTH(dateStart) = 07 ;

#Tính số tour có ngày kết thúc trong tháng 4 năm 2020
select count(tour.dateEnd) from tour where MONTH(dateEnd)= 06;
