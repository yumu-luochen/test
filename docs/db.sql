--管理员表
create table tbl_admin(
	user_no char(6) primary key auto_increment,
	user_pwd char(6) not null,
	user_name varchar(30) not null  
);
insert into tbl_admin values('000001','123456',"落尘");
insert into tbl_admin values('000002','123456',"张天明");

--酒店分店表
create table tbl_hotel(
	hotel_id int primary key,
	hotel_name varchar(50) not null,
	hotel_addr varchar(100) not null,
	hotel_phone varchar(20) not null,
	hotel_room_count int not null,
	hotel_pic mediumblob
);

--客房表
create table tbl_room(
	room_id int primary key auto_increment,
	room_no varchar(20) not null,
	room_type char(1) not null,
	room_equip varchar(20) not null,
	room_status char(1) not null,
	room_memo varchar(200),
	hotel_id int not null,
	constraint uk_hotel_room unique (room_id,hotel_id),
	constraint fk_hotel_room foreign key (hotel_id) references tbl_hotel(hotel_id)
);

--顾客表(f:女,m:男)
create table tbl_customer(
	customer_id int primary key auto_increment,
	customer_name varchar(20) not null,
	customer_sex char(1) not null,
	customer_identity varchar(18) not null,
	customer_phone varchar(11) not null,
	customer_email varchar(50) not null
);
--食品分类表
create table tbl_food_category(
	food_category_id int primary key auto_increment,
	food_category_name varchar(20) not null
);

--食品表
create table tbl_food(
	food_id int primary key auto_increment,
	food_name varchar(50) not null,
	food_purchased_price double not null,
	food_sell_price double not null,
	food_number int not null,
	food_category_id int not null,
	
	constraint uk_foodcategory_food unique (food_id,food_category_id),
	constraint fk_foodcategory_food foreign key (food_category_id) references tbl_food_category(food_category_id)
);


--预定表
create table tbl_reservation(
	reservation_id int primary key auto_increment,
	room_id int not null,
	customer_id int not null,
	
    constraint uk_room_reservation unique (reservation_id,room_id),
	constraint fk_room_reservation foreign key (room_id) references tbl_room(room_id),
	
	constraint uk_customer_reservation unique (reservation_id,customer_id),
	constraint fk_customer_reservation foreign key (customer_id) references tbl_customer(customer_id)
);