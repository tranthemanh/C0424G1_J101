create database test3;
use test3;


create table Address
(
    id      int not null primary key,
    address nvarchar(255)
);

create table Classes
(
    id          int           not null primary key,
    name        nvarchar(255) not null,
    language    nvarchar(255),
    description nvarchar(500)
);

create table Students
(
    id         int           not null primary key,
    fullname   nvarchar(255) not null,
    address_id int,
    foreign key (address_id) references address (id),
    phone      int           not null unique,
    classes_id int,
    foreign key (classes_id) references classes (id)
);

create table Course
(
    id          int primary key,
    name        nvarchar(255) not null,
    description nvarchar(500)
);

create table Point
(
    id         int primary key,
    course_id  int,
    foreign key (course_id) references course (id),
    student_id int,
    foreign key (student_id) references students (id),
    point      int
);

select *
from address;
select *
from classes;
select *
from course;
select *
from point;
select *
from students;

/* Để thêm thuộc tính AUTO_INCREMENT vào cột id*/

alter table address
    change column id id int auto_increment;

alter table classes
    change column id id int auto_increment;
alter table course
    change column id id int auto_increment;
alter table point
    change column id id int auto_increment;
alter table students
    change column id id int auto_increment;

alter table students
    drop foreign key students_ibfk_1;
alter table students
    drop foreign key students_ibfk_2;
alter table point
    drop foreign key point_ibfk_1;
alter table point
    drop foreign key point_ibfk_2;

alter table students
    add constraint students_ibfk_1 foreign key (address_id) references address (id);
alter table students
    add constraint students_ibfk_2 foreign key (classes_id) references classes (id);
alter table point
    add constraint point_ibfk_1 foreign key (course_id) references course (id);
alter table point
    add constraint point_ibfk_2 foreign key (student_id) references students (id);

insert into address(address) value ('HN');
insert into address(address) value ('ĐN');
insert into address(address) value ('SG');
insert into address(address) value ('HY');
insert into address(address) value ('NĐ');

select * from address;
select * from classes;

insert into classes(name, language, description) value ('PHP101', 'PHP', 'Ngon ngu PHP');
insert into classes(name, language, description) value ('JV101', 'Java', 'Ngon ngu Java');
insert into classes(name, language, description) value ('JV102', 'Java', 'Ngon ngu Java');
insert into classes(name, language, description) value ('C101', 'C#', 'Ngon ngu C#');
insert into classes(name, language, description) value ('C102', 'C#', 'Ngon ngu C#');

delete from classes;

alter table classes auto_increment = 1;


#Thêm 10 bản ghi trong bảng Student
select * from students;
select * from address;
select * from classes;

insert into students(fullname, address_id, phone, classes_id) value ('Manh', 1, 0123456789, 2);
insert into students(fullname, address_id, phone, classes_id) value ('Quan', 2, 0888888888, 1);
insert into students(fullname, address_id, phone, classes_id) value ('Nguyen', 3, 0999999999, 3);
insert into students(fullname, address_id, phone, classes_id) value ('Kien', 4, 0777777777, 5);
insert into students(fullname, address_id, phone, classes_id) value ('Trang', 5, 0666666666, 4);
insert into students(fullname, address_id, phone, classes_id) value ('Khoi', 1, 0555555555, 1);
insert into students(fullname, address_id, phone, classes_id) value ('Hien', 4, 0444444444, 2);
insert into students(fullname, address_id, phone, classes_id) value ('Hoang', 3, 0333333333, 3);
insert into students(fullname, address_id, phone, classes_id) value ('Huy', 2, 0222222222, 4);
insert into students(fullname, address_id, phone, classes_id) value ('Thao', 5, 0111111111, 5);

delete from students;

alter table students auto_increment = 1;

#Thêm 20 bản ghi thuộc bảng Coursedec
insert into course(name, description) value ('JV1', 'Khoa hoc Java 1');
insert into course(name, description) value ('JV2', 'Khoa hoc Java 2');
insert into course(name, description) value ('JV3', 'Khoa hoc Java 3');
insert into course(name, description) value ('JV4', 'Khoa hoc Java 4');
insert into course(name, description) value ('JV5', 'Khoa hoc Java 5');
insert into course(name, description) value ('JV6', 'Khoa hoc Java 6');
insert into course(name, description) value ('JV7', 'Khoa hoc Java 7');
insert into course(name, description) value ('JV8', 'Khoa hoc Java 8');
insert into course(name, description) value ('JV9', 'Khoa hoc Java 9');
insert into course(name, description) value ('PHP1', 'Khoa hoc PHP 1');
insert into course(name, description) value ('PHP2', 'Khoa hoc PHP 2');
insert into course(name, description) value ('PHP3', 'Khoa hoc PHP 3');
insert into course(name, description) value ('PHP4', 'Khoa hoc PHP 4');
insert into course(name, description) value ('PHP5', 'Khoa hoc PHP 5');
insert into course(name, description) value ('PHP6', 'Khoa hoc PHP 6');
insert into course(name, description) value ('C#1', 'Khoa hoc C# 1');
insert into course(name, description) value ('C#2', 'Khoa hoc C# 2');
insert into course(name, description) value ('C#3', 'Khoa hoc C# 3');
insert into course(name, description) value ('C#4', 'Khoa hoc C# 4');
insert into course(name, description) value ('C#5', 'Khoa hoc C# 5');

#Thêm 15 bản ghi trong bảng Point
select * from course;
select * from students;

insert into point( course_id, student_id, point) value(1, 1, 10);
insert into point( course_id, student_id, point) value(1, 2, 10);
insert into point( course_id, student_id, point) value(1, 3, 10);
insert into point( course_id, student_id, point) value(1, 4, 10);
insert into point( course_id, student_id, point) value(1, 5, 10);
insert into point( course_id, student_id, point) value(1, 6, 10);
insert into point( course_id, student_id, point) value(1, 7, 10);
insert into point( course_id, student_id, point) value(1, 8, 10);
insert into point( course_id, student_id, point) value(2, 9, 10);
insert into point( course_id, student_id, point) value(2, 1, 10);
insert into point( course_id, student_id, point) value(2, 2, 10);
insert into point( course_id, student_id, point) value(2, 3, 10);
insert into point( course_id, student_id, point) value(3, 4, 10);
insert into point( course_id, student_id, point) value(3, 5, 10);
insert into point( course_id, student_id, point) value(4, 6, 10);
insert into point( course_id, student_id, point) value(11, 6, 10);

delete from point where course_id = 11;

select * from point;

alter table students add column age int after address_id;
update students set age = 18 where fullname = 'Manh';
update students set age = 24 where fullname = 'Quan';
update students set age = 25 where id = 3;
update students set age = 20 where id = 4;
update students set age = 19 where id = 5;
update students set age = 10 where id = 6;
update students set age = 30 where id = 7;
update students set age = 31 where id = 8;
update students set age = 22 where id = 9;
update students set age = 18 where id = 10;

select * from students;

/*
Viết câu query thực hiện:
Tìm kiếm HV có họ Nguyen
Tìm kiếm HV có ten Anh
Tim kiem HV có độ tuổi từ 18-25
Tìm kiếm HV có id là 12 hoặc 13
*/

select * from students where fullname = 'Manh';
select * from students where age >= 18 && age <=25;
select * from students where id = 5 || id = 10;