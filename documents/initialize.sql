create table client_car(
	register_id		int auto_increment,
    owner_name		varchar(50),
    car_id			varchar(50),
    register_date	date,
    car_type		varchar(50),
    owner_phone		varchar(50),
    owner_email		varchar(100),
    primary key(register_id)
);

create table client_repair(
	repair_id		int auto_increment,
    register_id		int,
    mechanic_id		int,
    repair_task		varchar(200),
    carpart_id		int,
    finish_date		date,
    primary key(repair_id)
);

create table carpart_usage(
	usage_id		int auto_increment,
	repair_id		int,
    carpart_id		int,
    usage_amount	int,
    usage_date		date,
    primary key(usage_id)
);

create table client_bill(
	bill_id			int auto_increment,
    register_id		int,
    payment			int,
    pay_date		date,
    primary key(bill_id)
);

create table mechanic_info(
	mechanic_id		varchar(50),
    mechanic_name	varchar(50),
    mechanic_lv		varchar(50),
    mechanic_phone	varchar(50),
    primary key(mechanic_id)
);

create table carpart_info(
	carpart_id		varchar(50),
    carpart_name	varchar(100),
    manufacturer	varchar(100),
    carpart_price	int,
    reserve_amount	int,
    primary key(carpart_id)
);

create table user_info(
	user_id			varchar(50),
    user_role		varchar(50),
    user_password	varchar(50),
    user_email		varchar(100),
    primary key(user_id)
);

create table role_privilege(
	user_role		varchar(50),
    interface_url	varchar(200),
    access_permit	varchar(10)
);


