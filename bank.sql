-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 14, 2023 lúc 04:52 AM
-- Phiên bản máy phục vụ: 10.4.11-MariaDB
-- Phiên bản PHP: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `bank`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giaodich`
--

CREATE TABLE `giaodich` (
  `id` int(11) NOT NULL,
  `sotk` varchar(6) DEFAULT NULL,
  `loaitt` int(11) DEFAULT NULL,
  `sotien` int(11) DEFAULT NULL,
  `ngaytao` date DEFAULT NULL,
  `noithuchien` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `giaodich`
--

INSERT INTO `giaodich` (`id`, `sotk`, `loaitt`, `sotien`, `ngaytao`, `noithuchien`) VALUES
(1, 'KHD123', 0, 200000, NULL, 'RechargeAccount'),
(3, 'KHD123', 0, 200000, '2023-06-14', 'RechargeAccount');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `id` int(11) NOT NULL,
  `makh` varchar(20) DEFAULT NULL,
  `tenkh` varchar(100) DEFAULT NULL,
  `cmt` varchar(12) DEFAULT NULL,
  `sodt` varchar(10) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `ngaysinh` date DEFAULT NULL,
  `gioitinh` int(11) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `loaikh` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`id`, `makh`, `tenkh`, `cmt`, `sodt`, `email`, `ngaysinh`, `gioitinh`, `address`, `loaikh`) VALUES
(2, 'KH1', 'Dang Van Dat8', '036097005225', '0862442397', 'dangvandat09@gmail.com', '1997-10-20', 0, 'sadasa', 0),
(5, 'KH2', 'Dang Van Dat', '036097005125', '0862442297', 'dangvandat092@gmail.com', NULL, 0, 'Dong My Thanh Tri Ha Noi', 1),
(10, 'KH4', 'Dang Van Dat', '036097005128', '0622422397', 'dangvandat094@gmail.com', '1997-10-20', 0, 'Dong My Thanh Tri Ha Noi', 1),
(13, 'KH6', 'Dang Van Dat', '036097105728', '0612422317', 'dangvandat128@gmail.com', '1997-10-20', 0, 'Dong My Thanh Tri Ha Noi', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `id` int(11) NOT NULL,
  `khid` int(11) DEFAULT NULL,
  `sotk` varchar(6) DEFAULT NULL,
  `loaitk` int(11) DEFAULT NULL,
  `trangthai` int(11) DEFAULT NULL,
  `ngaytao` date DEFAULT NULL,
  `sotien` int(11) DEFAULT NULL,
  `hanmuc` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`id`, `khid`, `sotk`, `loaitk`, `trangthai`, `ngaytao`, `sotien`, `hanmuc`) VALUES
(1, NULL, 'hasdas', 0, 1, '1997-10-20', 204630000, 1),
(3, NULL, 'asdasd', 0, 1, '1997-10-20', 204630000, 1),
(4, 2, 'lhsdwq', 0, 1, '1997-10-20', 204630000, 1),
(5, 2, 'KSADHQ', 0, 1, '0000-00-00', 204630000, 1),
(6, 2, 'KHD123', 0, 0, '2023-09-21', 204430000, 0);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `giaodich`
--
ALTER TABLE `giaodich`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `makh` (`makh`),
  ADD UNIQUE KEY `cmt` (`cmt`),
  ADD UNIQUE KEY `sodt` (`sodt`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `sotk` (`sotk`),
  ADD KEY `khid` (`khid`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `giaodich`
--
ALTER TABLE `giaodich`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `khid` FOREIGN KEY (`khid`) REFERENCES `khachhang` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
