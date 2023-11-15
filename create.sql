drop table if exists flights cascade ;
drop table if exists plane cascade ;
drop table if exists tickets cascade ;
drop table if exists users cascade ;
create table flights (is_active boolean, date_time timestamp(6), id bigint generated by default as identity, primary key (id));
create table plane (is_active boolean, number_of_seats integer, row_seats integer, id bigint generated by default as identity, model varchar(255), primary key (id));
create table tickets (price numeric(38,2), flight_id bigint, id bigint generated by default as identity, user_id bigint, place varchar(255), primary key (id));
create table users (is_active boolean, money numeric(38,2), id bigint generated by default as identity, name varchar(255), surname varchar(255), primary key (id));
alter table if exists tickets add constraint FKtdayegtd891qq5xm0axfbckvy foreign key (flight_id) references flights;
alter table if exists tickets add constraint FK4eqsebpimnjen0q46ja6fl2hl foreign key (user_id) references users;
drop table if exists flights cascade ;
drop table if exists plane cascade ;
drop table if exists tickets cascade ;
drop table if exists users cascade ;
create table flights (is_active boolean, date_time timestamp(6), id bigint generated by default as identity, primary key (id));
create table plane (is_active boolean, number_of_seats integer, row_seats integer, id bigint generated by default as identity, model varchar(255), primary key (id));
create table tickets (price numeric(38,2), flight_id bigint, id bigint generated by default as identity, user_id bigint, place varchar(255), primary key (id));
create table users (is_active boolean, money numeric(38,2), id bigint generated by default as identity, name varchar(255), surname varchar(255), primary key (id));
alter table if exists tickets add constraint FKtdayegtd891qq5xm0axfbckvy foreign key (flight_id) references flights;
alter table if exists tickets add constraint FK4eqsebpimnjen0q46ja6fl2hl foreign key (user_id) references users;
drop table if exists flights cascade ;
drop table if exists plane cascade ;
drop table if exists tickets cascade ;
drop table if exists users cascade ;
create table flights (is_active boolean, date_time timestamp(6), id bigint generated by default as identity, primary key (id));
create table plane (is_active boolean, number_of_seats integer, row_seats integer, id bigint generated by default as identity, model varchar(255), primary key (id));
create table tickets (price numeric(38,2), flight_id bigint, id bigint generated by default as identity, user_id bigint, place varchar(255), primary key (id));
create table users (is_active boolean, money numeric(38,2), id bigint generated by default as identity, name varchar(255), surname varchar(255), primary key (id));
alter table if exists tickets add constraint FKtdayegtd891qq5xm0axfbckvy foreign key (flight_id) references flights;
alter table if exists tickets add constraint FK4eqsebpimnjen0q46ja6fl2hl foreign key (user_id) references users;
