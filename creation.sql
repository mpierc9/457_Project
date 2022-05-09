--o for office, p for patient, c for client, s for service, v for vendor

use mpierc9db;

CREATE TABLE Office
(o_id varchar(4) not null,
phone varchar(14) not null,
street varchar(20) not null,
city varchar(20) not null,
PRIMARY KEY(o_id));


CREATE TABLE Patient
(p_id varchar(8) not null,
name varchar(20) not null,
breed varchar(20) not null,
dob varchar(20),
notes varchar(40),
PRIMARY KEY(p_id));


CREATE TABLE Client
(c_id varchar(8) not null,
fname varchar(20) not null,
lname varchar(20) not null,
phone varchar(20) not null,
email varchar(20) not null,
street varchar(20) not null,
city varchar(20) not null,
PRIMARY KEY(c_id));


CREATE TABLE Vendor
(v_id varchar(8) not null,
name varchar(20) not null,
type varchar(20) not null,
phone varchar(20) not null,
email varchar(20) not null,
street varchar(20) not null,
city varchar(20) not null,
PRIMARY KEY(v_id));


CREATE TABLE Employee
(ssn varchar(9) not null,
fname varchar(20) not null,
lname varchar(20) not null,
gender varchar(20) not null,
phone varchar(20) not null,
street varchar(20) not null,
city varchar(20) not null,
start varchar(20) not null,
dob varchar(20) not null,
pay double(8,2) not null,
PRIMARY KEY(ssn));


CREATE TABLE Department
(d_num varchar(8) not null,
name varchar(20) not null,
num_of_e varchar(20) not null,
mgr_ssn varchar(9) not null,
mgr_start varchar(20) not null,
UNIQUE(name),
FOREIGN KEY(mgr_ssn) references Employee(ssn),
PRIMARY KEY(d_num));

CREATE TABLE Service
(s_id varchar(4) not null,
name varchar(20) not null,
animal_type varchar(10),
weight_max int(3),
cost double(5,2) not null,
PRIMARY KEY(s_id));

CREATE TABLE WorksFor
(ssn varchar(9) not null,
dno varchar(20) not null,
hours double(10,2) not null,
FOREIGN KEY(ssn) references Employee(ssn),
FOREIGN KEY(dno) references Department(d_num),
PRIMARY KEY(ssn, dno));

CREATE TABLE Administers
(essn varchar(9) not null,
p_id varchar(20) not null,
s_id varchar(20) not null,
FOREIGN KEY(essn) references Employee(ssn),
FOREIGN KEY(p_id) references Patient(p_id),
FOREIGN KEY(s_id) references Service(s_id),
PRIMARY KEY(essn, p_id, s_id));

CREATE TABLE Contracts
(v_id varchar(8) not null,
o_id varchar(20) not null,
cost int(8) not null,
end_date varchar(20) not null,
FOREIGN KEY(v_id) references Vendor(v_id),
FOREIGN KEY(o_id) references Office(o_id),
PRIMARY KEY(v_id, o_id));

CREATE TABLE CheckIn
(ci_id varchar(8) not null,
p_id varchar(20) not null,
o_id varchar(20) not null,
date varchar(10) not null,
time_in varchar(10) not null,
date_out varchar(10),
kennel varchar(4),
FOREIGN KEY(o_id) references Office(o_id),
FOREIGN KEY(p_id) references Patient(p_id),
PRIMARY KEY(ci_id));

CREATE TABLE Bills
(b_id varchar(8) not null,
c_id varchar(8) not null,
o_id varchar(8) not null,
ci_id varchar(8) not null,
date varchar(14) not null,
cost double(8,2) not null,
paid_yn char(1) not null,
FOREIGN KEY(c_id) references Client(c_id),
FOREIGN KEY(o_id) references Office(o_id),
FOREIGN KEY(ci_id) references CheckIn(ci_id),
PRIMARY KEY(b_id));

CREATE TABLE Owns
(c_id varchar(8) not null,
p_id varchar(20) not null,
FOREIGN KEY(c_id) references Client(c_id),
FOREIGN KEY(p_id) references Patient(p_id),
PRIMARY KEY(c_id, p_id));
