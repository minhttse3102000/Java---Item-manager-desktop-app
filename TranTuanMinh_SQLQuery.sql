create database ItemManagement
go
use ItemManagement
go
create table tblUsers (
	userID varchar(10) primary key,
	fullname nvarchar(50),
	password varchar(50),
	status bit
)
create table tblSuppliers (
	supCode varchar(10) primary key,
	supName nvarchar(50),
	address nvarchar(50),
	collaborating bit
)
create table tblItems (
	itemCode varchar(10) primary key,
	itemName nvarchar(50),
	unit varchar(50),
	price float,
	supplying bit,
	supCode varchar(10) foreign key references tblSuppliers(supCode)
)

insert tblUsers
values('123456',N'Tran Tuan Minh','minh',1)

insert tblUsers
values('654321',N'Van Hoang','hoang',1)


insert tblSuppliers
values('S1',N'Pepsi',N'Bình Dương',1)
insert tblSuppliers
values('S2',N'Việt Tiến',N'Hà Nội',1)
insert tblSuppliers
values('S3',N'Coca',N'Hải Phòng',0)


insert tblItems
values('I1',N'Áo','Cai','200000',1,'S1')
insert tblItems
values('I2',N'Quần bò','Cai','150000',1,'S3')
insert tblItems
values('I5',N'Nước ngọt','Chai','12000',0,'S2')
insert tblItems
values('I7',N'Bàn gỗ','Cai','50000',1,'S3')





