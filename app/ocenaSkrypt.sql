create database oceny DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;
use oceny;

create table uzytkownicy(id smallint primary key auto_increment, login varchar(50) unique not null, pass varchar(50) not null, upraw tinyint(1) default 0, imie varchar(50), nazwisko varchar(50), grupa varchar(50), telefon varchar(11), mail varchar(50), github varchar(50));

insert into uzytkownicy(login, pass, upraw) values ('trener','trener',1);
insert into uzytkownicy(login, pass, imie, nazwisko, telefon, mail, github) values ('kursant','kursant','Jan','Kowalski','123-456-789','kowalski@poczta.pl','kowalskigit');

create table projekty(id smallint primary key auto_increment, temat varchar(100), opis varchar (250), termin date, grupa varchar(50), zrobione tinyint(1) default 0, ocena tinyint);

insert into projekty(temat, opis, termin) values ('Projekt testowy','Opis projektu testowego','2017-12-15');

create table grupy(nazwa varchar(50));

