CREATE DATABASE bookstore
GO

USE bookstore
GO

CREATE TABLE chitietchuongtrinhgiamgia (
  MaGG nvarchar(5) NOT NULL,
  phanTramGiam float NOT NULL,
  MaSach nvarchar(5) NOT NULL,
  FOREIGN KEY (MaGG) REFERENCES chuongtrinhgiamgia(MaGG),
  FOREIGN KEY (MaSach) REFERENCES sach(MaSach)
);

INSERT INTO chitietchuongtrinhgiamgia (MaGG, phanTramGiam, MaSach) VALUES
('A02', 14, 'KD04'),
('A02', 30, 'KD05'),
('A04', 15, 'KD04');


CREATE TABLE chitiethoadon (
  MaHD nvarchar(5) NOT NULL,
  MaSach nvarchar(5) NOT NULL,
  TenSach nvarchar(50) NOT NULL,
  SoLuong int NOT NULL,
  DonGia float NOT NULL,
  GiamGia int NOT NULL,
  ThanhTien float NOT NULL,
  FOREIGN KEY (MaHD) REFERENCES hoadon(MaHD),
  FOREIGN KEY (MaSach) REFERENCES sach(MaSach)
);

INSERT INTO chitiethoadon (MaHD, MaSach, TenSach, SoLuong, DonGia, GiamGia, ThanhTien) VALUES
('1', 'KD06', N'Đắc Nhân Tâm', 1, 110000, 0, 110000),
('2', 'KD03', N'Cho tôi 1 vé Về tuổi thơ', 1, 75000, 0, 75000),
('3', 'KD10', N'Luật Bảo Vệ Môi Trường', 1, 45000, 0, 45000),
('4', 'KD03', N'Cho tôi 1 vé Về tuổi thơ', 2, 75000, 0, 150000),
('4', 'KD01', N'7 Thói Quen Hiệu Quả', 1, 11000, 0, 11000),
('5', 'KD01', N'7 Thói Quen Hiệu Quả', 49, 11000, 0, 539000),
('5', 'KD02', N'Chúng Ta Đã Sai', 50, 75000, 0, 3750000),
('6', 'KD03', N'Cho tôi 1 vé Về tuổi thơ', 2, 75000, 0, 150000),
('7', 'KD03', N'Cho tôi 1 vé Về tuổi thơ', 3, 75000, 0, 225000);

CREATE TABLE chitietphieunhap (
  MaCTPN nvarchar(5) NOT NULL PRIMARY KEY,
  MaPN nvarchar(5) NOT NULL,
  MaSach nvarchar(5) NOT NULL,
  DonGia int NOT NULL,
  SoLuong int NOT NULL,
  ThanhTien int NOT NULL,
  FOREIGN KEY (MaPN) REFERENCES phieunhap(MaPN),
  FOREIGN KEY (MaSach) REFERENCES sach(MaSach)
);

INSERT INTO chitietphieunhap (MaCTPN, MaPN, MaSach, DonGia, SoLuong, ThanhTien) VALUES
('CT01', 'A01', 'KD01', 110000, 10, 1100000),
('CT02', 'A01', 'KD03', 75000, 10, 750000),
('CT03', 'A02', 'KD04', 100000, 15, 1500000),
('CT04', 'A03', 'KD10', 45000, 10, 450000),
('CT05', 'A03', 'KD09', 55000, 10, 550000),
('CT06', 'A04', 'KD07', 75000, 5, 375000),
('CT07', 'A04', 'KD01', 65000, 50, 3250000),
('CT08', 'A05', 'KD03', 70000, 13, 910000),
('CT09', 'A05', 'KD10', 50000, 15, 750000);

CREATE TABLE chuongtrinhgiamgia(
  MaGG nvarchar(5) NOT NULL PRIMARY KEY,
  TenChuongTrinh nvarchar(50) NOT NULL,
  LoaiChuongTrinh nvarchar(50) NOT NULL,
  NgayBD date NOT NULL,
  NgayKT date NOT NULL,
);

INSERT INTO chuongtrinhgiamgia (MaGG, TenChuongTrinh, LoaiChuongTrinh, NgayBD, NgayKT) VALUES
('A02', N'Khai Trương Cưa Hàng Sách', N'Khuyến Mãi 30% - 40%', '2021-05-01', '2021-05-08'),
('A04', N'Lễ Quốc Tế Lao Động', N'Khuyến Mãi', '2021-05-01', '2021-05-02');

CREATE TABLE hoadon (
  MaHD nvarchar(5) NOT NULL PRIMARY KEY,
  MaKH nvarchar(5) NOT NULL,
  MaNV nvarchar(5) NOT NULL,
  MaGG nvarchar(5) NULL,
  NgayLapHD date NOT NULL,
  TongTien float NOT NULL,
  GiamGia float NOT NULL,
  ThanhTien float NOT NULL,
  FOREIGN KEY (MaKH) REFERENCES khachhang(MaKH),
  FOREIGN KEY (MaNV) REFERENCES nhanvien(MaNV),
  FOREIGN KEY (MaGG) REFERENCES chuongtrinhgiamgia(MaGG)
);

INSERT INTO hoadon (MaHD, MaKH, MaNV, MaGG, NgayLapHD, TongTien, GiamGia, ThanhTien) VALUES
('1', 'K02', 'PK', NULL, '2021-01-18', 110000, 0, 110000),
('2', 'K05', 'PK', NULL, '2021-05-18', 75000, 0, 75000),
('3', 'K07', 'MT', NULL, '2021-02-19', 45000, 0, 45000),
('4', 'K01', 'PK', NULL, '2021-05-19', 161000, 0, 161000),
('5', 'K01', 'PK', NULL, '2021-05-19', 4289000, 0, 4289000),
('6', 'K04', 'MT', 'A02', '2021-08-16', 150000, 0, 150000),
('7', 'K01', 'TT', NULL, '2021-08-26', 225000, 0, 225000);

CREATE TABLE khachhang (
  MaKH nvarchar(5) NOT NULL PRIMARY KEY,
  Ho nvarchar(30) NOT NULL,
  Ten nvarchar(30) NOT NULL,
  SDT nvarchar(10) NOT NULL,
  Email nvarchar(30) NOT NULL,
  Phai tinyint NOT NULL,
  TCT int NOT NULL,
  NgaySinh date NULL,
);

INSERT INTO khachhang (MaKH, Ho, Ten, SDT, Email, Phai, TCT, NgaySinh) VALUES
('K01', N'Nguyễn Trần Văn', N'Vũ', '0902638361', 'vanvu21@gmail.com', 1, 1000, '2001-04-16'),
('K02', N'Phạm Thiên', N'Phúc', '0363691591', 'phuc@gmail.com', 0, 1000, '2001-03-18'),
('K03', N'thanh ', N'huy', '0121455123', 'truc@gmail.com', 1, 1000, '1996-06-23'),
('K04', N'Trần Thanh', N'Tùng', '9999999999', 'tung@gmail.com', 1, 2000, '1980-04-17'),
('K05', N'Nguyễn Trần Văn', N'Bưởi', '0363691591', 'daubuoi111@gmail.com', 1, 1000, '2000-08-19'),
('K06', N'Trần Thanh', N'Tèo', '0363691591', 'teo21@gmail.com', 0, 50000, '2000-06-19'),
('K07', N'Trần Thanh', N'Táo', '0363691591', 'apple21@gmail.com', 1, 50000, '2000-05-19'),
('K08', N'Phan Trung', N'Kiên', '0123456789', 'kien@email.com', 1, 200000, '2001-12-03');

CREATE TABLE nhacungcap (
  MaNCC nvarchar(5) NOT NULL PRIMARY KEY,
  TenNCC nvarchar(255) NOT NULL,
  DiaChi nvarchar(255) NOT NULL,
);

INSERT INTO nhacungcap (MaNCC, TenNCC, DiaChi) VALUES
('KĐ', N'Kim Đồng', N'TP.HCM'),
('NN', N'Nhã Nam', N'TP.HCM'),
('NVC', N'Nguyễn Văn Cừ', N'TP.HCM'),
('PĐ', N'Phương Đông', N'Hà Nội'),
('PN', N'Phương Nam', N'TP.HCM');

CREATE TABLE nhanvien(
  MaNV nvarchar(5) NOT NULL PRIMARY KEY, 
  Ho nvarchar(30) NOT NULL,
  Ten nvarchar(30) NOT NULL,
  SDT char(10) NOT NULL,
  Email nvarchar(35) NOT NULL,
  Phai tinyint NOT NULL,
  NgaySinh date NOT NULL DEFAULT GETDATE(),
  ChucVu nvarchar(25) NOT NULL,
  Luong float NOT NULL,
);

INSERT INTO nhanvien (MaNV, Ho, Ten, SDT, Email, Phai, NgaySinh, ChucVu, Luong) VALUES
('MT', N'Dưng Kui', N'Trung', '089233779', 'teoa@gmail.com', 1, '1991-10-11', N'Tổng Giám Đốc', 10000000),
('PK', N'Phạm Trần', N'Kuku', '0111425446', '', 0, '2021-04-25', '', 10000000),
('TT', N'Trần Thanh', N'Tèo', '0984525453', '', 0, '2021-04-25', '', 10000000),
('VV', N'Nguyễn Trần Cu', N'Vũ', '0456368547', '', 0, '2021-04-25', '', 10000000);

CREATE TABLE nhaxuatban (
  MaNXB nvarchar(50) NOT NULL PRIMARY KEY,
  TenNXB nvarchar(30) NOT NULL,
  DiaChiNXB nvarchar(70) NOT NULL,
  SDT nvarchar(10) NOT NULL,
);

INSERT INTO nhaxuatban (MaNXB, TenNXB, DiaChiNXB, SDT) VALUES
(N'GD', N'Nhà xuất Bản Giáo Dục', N'Hà Nội', '0235456987'),
(N'NXB_Đại_Học_Quốc_Gia', N'Nhà Xuất Đại Học Quốc Gia', N'Hà Nội', '0899131345'),
(N'NXB_Hội_Nhà_Văn', N'Nhà Xuất Bản Hội Nhà Văn', N'TP.HCM', '0235872347'),
(N'NXB_Lao_Động', N'Nhà xuất Bản lao Động', N'TP.HCM', '0535878987'),
(N'NXB_Tổng_Hợp_HCM', N'Nhà Xuất Bản Tổng Hợp Hồ Chí M', N'TP.HCM', '0755878987'),
(N'NXB_Trẻ', N'Nhà Xuất Bản Trẻ', N'TP.HCM', '0235878987');

CREATE TABLE phieunhap (
  MaPN nvarchar(5) NOT NULL PRIMARY KEY,
  MaNV nvarchar(5) NOT NULL,
  MaNCC nvarchar(5) NOT NULL,
  TrangThai tinyint NOT NULL,
  TongTien float NOT NULL,
  NgayNhap date NOT NULL,
  FOREIGN KEY (MaNV) REFERENCES nhanvien(MaNV),
  FOREIGN KEY (MaNCC) REFERENCES nhacungcap(MaNCC)
);

INSERT INTO phieunhap (MaPN, MaNV, MaNCC, TrangThai, TongTien, NgayNhap) VALUES
('A01', 'MT', 'KĐ', 1, 1850000, '2021-05-18'),
('A02', 'PK', 'NVC', 0, 1500000, '2021-05-18'),
('A03', 'TT', 'PN', 1, 1000000, '2021-05-19'),
('A04', 'VV', 'PĐ', 0, 3625000, '2021-05-19'),
('A05', 'MT', 'PĐ', 1, 1660000, '2021-08-26');

CREATE TABLE sach (
  MaSach nvarchar(5) NOT NULL PRIMARY KEY,
  MaNXB nvarchar(50) NOT NULL,
  MaTG nvarchar(50) NOT NULL,
  MaTL nvarchar(50) NOT NULL,
  TenSach nvarchar(50) NOT NULL,
  NamXuatBan int NOT NULL,
  SoLuong int NOT NULL,
  DonGia float NOT NULL,
  imgName nvarchar(20) NOT NULL,
  FOREIGN KEY (MaNXB) REFERENCES nhaxuatban(MaNXB),
  FOREIGN KEY (MaTG) REFERENCES tacgia(MaTG),
  FOREIGN KEY (MaTL) REFERENCES theloai(MaTL)
);

INSERT INTO sach (MaSach, MaNXB, MaTG, MaTL, TenSach, NamXuatBan, SoLuong, DonGia, imgName) VALUES
('KD01', N'NXB_Đại_Học_Quốc_Gia', N'J.K.R', N'Văn_Học_Nghệ_Thuật', N'7 Thói Quen Hiệu Quả', 2016, 50, 11000, 'KD01.jpg'),
('KD02', N'NXB_Trẻ', N'H.Trương', N'Tôn_Giáo&Tâm_Lý', N'Chúng Ta Đã Sai', 2018, 50, 75000, 'KD02.jpg'),
('KD03', N'NXB_Trẻ', N'P.Việt', N'Văn_Học_Nghệ_Thuật', N'Cho tôi 1 vé Về tuổi thơ', 2016, 56, 75000, 'KD03.jpg'),
('KD04', N'NXB_Trẻ', N'P.Việt', N'Văn_Học_Nghệ_Thuật', N'Đời Ngắn Đừng Ngủ Dài', 2008, 50, 100000, 'KD04.jpg'),
('KD05', N'NXB_Trẻ', N'NhieuTG', N'Tôn_Giáo&Tâm_Lý', N'Hạt Giống Tâm Hồn', 2006, 50, 65000, 'KD05.jpg'),
('KD06', N'NXB_Trẻ', N'J.K.R', N'Chính_Trị', N'Đắc Nhân Tâm', 2010, 100, 110000, 'KD06.jpg'),
('KD07', N'NXB_Đại_Học_Quốc_Gia', N'Nguyễn Du', N'Truyện', N'Truyện Kiều', 2008, 55, 75000, 'KD07.jpg'),
('KD08', N'NXB_Tổng_Hợp_HCM', N'D.N.Nam', N'Văn_Học_Nghệ_Thuật', N'Thành Phố Ngày Ta Yêu', 2018, 50, 85000, 'KD08.jpg'),
('KD09', N'NXB_Hội_Nhà_Văn', N'H.Trương', N'Văn_Học_Nghệ_Thuật', N'Thương Nhau Để Đó', 2017, 55, 55000, 'KD09.jpg'),
('KD10', N'NXB_Đại_Học_Quốc_Gia', N'NhieuTG', N'Pháp _Luật', N'Luật Bảo Vệ Môi Trường', 2018, 54, 45000, 'KD10.jpg');

CREATE TABLE tacgia (
  MaTG nvarchar(50) NOT NULL PRIMARY KEY,
  TenTG nvarchar(50) NOT NULL,
  DiaChi nvarchar(70) NOT NULL,
  SDT char(10) NOT NULL,
);

INSERT INTO tacgia (MaTG, TenTG, DiaChi, SDT) VALUES
(N'C.Thiên', N'Cảnh Thiên', N'HCM', '0235878987'),
(N'D.N.Nam', N'Đỗ Nhật Nam', N'An Giang', '0907365481'),
(N'H.Trang', N'Trang Hạ', N'TP.HCM', '0803365421'),
(N'H.Trương', N'Hamlet Trương', N'TP.HCM', '0803365421'),
(N'J.K.R', N'J.K.Rowling', N'Anh Quốc', '02-036-798'),
(N'N.N.Ánh', N'Nguyễn Nhật Ánh', N'HCM', '067939771'),
(N'N.T.Tố', N'Ngô Tất Tố', N'TP.HCM', '0809995472'),
(N'Nguyễn Du', N'Nguyễn Du', N'VietNam', '0803999999'),
(N'NhieuTG', N'Nhiều TG', N'QT', '0222228686'),
(N'P.Việt', N'Nguyễn Phong Việt', N'Phú Yên', '0803365421'),
(N'V.T.Phụng', N'Vũ Trọng Phụng', N'Nam Viet Nam', '0589365429');

CREATE TABLE theloai (
  MaTL nvarchar(50) NOT NULL PRIMARY KEY,
  TenTL nvarchar(50) NOT NULL,
);

INSERT INTO theloai (MaTL, TenTL) VALUES
(N'Chính_Trị', N'Chính Trị'),
(N'Pháp _Luật', N'Pháp Luật'),
(N'Thiếu_Nhi', N'Sách Thiếu Nhi'),
(N'Tiểu_Thuyết', N'Tiểu Thuyết'),
(N'Tôn_Giáo&Tâm_Lý', N'Tâm Lý-Tôn Giáo'),
(N'Trinh_Thám', N'Thám Hiểm & Trinh Thám'),
(N'Truyện', N'Truyện'),
(N'Văn_Học_Nghệ_Thuật', N'Văn Học Nghệ Thuật');

CREATE TABLE taikhoan (
  MaTK nvarchar(5) NOT NULL PRIMARY KEY,
  TenTaiKhoan nvarchar(255) NOT NULL,
  MatKhau nvarchar(50) NOT NULL,
  Quyen nvarchar(30) NOT NULL,
  TrangThai int NOT NULL,
);

INSERT INTO taikhoan (MaTK, TenTaiKhoan, MatKhau, Quyen, TrangThai) VALUES
('MT', 'admin', 'admin', 'admin', 1);