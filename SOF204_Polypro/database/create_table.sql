CREATE DATABASE POLYPRO
GO

USE POLYPRO
GO

CREATE TABLE NHANVIEN
(
    MaNV NVARCHAR(20) PRIMARY KEY NOT NULL,
    MatKhau NVARCHAR(50) NOT NULL,
    HoTen NVARCHAR(50) NOT NULL,
    VaiTro BIT DEFAULT 0
)
GO

CREATE TABLE NGUOIHOC
(
	MaNH NCHAR(7) PRIMARY KEY NOT NULL,
    HoTen NVARCHAR(50) NOT NULL,
    GioiTinh BIT DEFAULT 1,
    NgaySinh DATE NOT NULL,
    DienThoai NVARCHAR(24) NOT NULL,
    Email NVARCHAR(50) NOT NULL,
    GhiChu NVARCHAR(255) NULL,
    MaNV NVARCHAR(20) NOT NULL FOREIGN KEY REFERENCES NHANVIEN(MaNV),
    NgayDK DATE DEFAULT getdate()
)
GO

CREATE TABLE CHUYENDE
(
	MaCD NCHAR(5) PRIMARY KEY NOT NULL,
	TenCD NVARCHAR(50) NOT NULL,
	HocPhi FLOAT NOT NULL,
	ThoiLuong INT NOT NULL,
	Hinh NVARCHAR(100) NOT NULL,
	MoTa NVARCHAR(255) NOT NULL
)
GO

CREATE TABLE KHOAHOC
(
	MaKH INT PRIMARY KEY IDENTITY(1,1),
	MaCD NCHAR(5) FOREIGN KEY REFERENCES CHUYENDE (MaCD) NOT NULL,
	HocPhi FLOAT NOT NULL,
	ThoiLuong INT NOT NULL,
	NgayKG DATE NOT NULL,
	GhiChu NVARCHAR(255) NULL,
	MaNV NVARCHAR(20) FOREIGN KEY REFERENCES NHANVIEN (MaNV) NOT NULL,
	NgayTao DATE DEFAULT getdate()
)
GO

CREATE TABLE HOCVIEN
(
	MaHV INT PRIMARY KEY IDENTITY(1,1),
	MaKH INT FOREIGN KEY REFERENCES KHOAHOC (MaKH) NOT NULL,
	MaNH NCHAR(7) FOREIGN KEY REFERENCES NGUOIHOC (MaNH) NOT NULL,
	Diem FLOAT DEFAULT -1
)
GO