-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 30, 2021 at 05:51 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `covidcenter`
--

-- --------------------------------------------------------

--
-- Table structure for table `nhankhau`
--

CREATE TABLE `nhankhau` (
  `ID` varchar(12) NOT NULL,
  `IDHoKhau` varchar(10) NOT NULL,
  `IDNhanKhau` varchar(5) NOT NULL,
  `Hoten` varchar(100) NOT NULL,
  `NgaySinh` varchar(50) NOT NULL,
  `GioiTinh` varchar(10) NOT NULL,
  `QuocTich` varchar(50) NOT NULL,
  `DiaChi` varchar(50) NOT NULL,
  `NgheNghiep` varchar(50) NOT NULL,
  `NoiLamViec` varchar(100) NOT NULL,
  `SoDienThoai` varchar(12) NOT NULL,
  `KhaiBao` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nhankhau`
--

INSERT INTO `nhankhau` (`ID`, `IDHoKhau`, `IDNhanKhau`, `Hoten`, `NgaySinh`, `GioiTinh`, `QuocTich`, `DiaChi`, `NgheNghiep`, `NoiLamViec`, `SoDienThoai`, `KhaiBao`) VALUES
('000000000001', '001', '001', 'Tran Van Admin', '2000-09-25', 'Nam', 'Vie', 'So 5 - Ta Quang Buu', 'Sinh Vien', 'DH Bach Khoa Ha Noi', '0976345167', '1'),
('000000000002', '002', '001', 'Nguyen Van Citizen', '2000-12-01', 'Nam', 'Vie', 'So 16 - Le Dai Hanh - Ha Noi', 'Tu Do', 'Cong Ty A', '0973467591', '1'),
('000000000167', '003', '001', 'Trần Lương Minh Long', '1995-03-25', 'Nam', 'Vie', 'So 2 - Ta Quang Buu', 'Công An', 'Công An quận Hai Bà Trưng', '0391647127', '0'),
('000000000613', '048', '002', 'Lý Thị Anh', '1983-04-05', 'Nu', 'Vie', 'Số 10 - Trần Nhân Tông', 'Giáo Viên', 'Trường mầm non Hoa Sen', '0391647648', '0'),
('000000134624', '016', '001', 'Hoàng Lê Long', '2000-12-01', 'Nam', 'Vie', 'So 2 - Lý Thái Tổ', 'Sinh Vien', 'Đại học Thăng Long', '0391154128', '0'),
('000000164614', '048', '001', 'Trần Văn Thêm', '1981-04-05', 'Nam', 'Vie', 'So 10 - Trần Nhân Tông', 'Buôn Bán', 'Tại địa chỉ nhà', '0394761428', '0');

-- --------------------------------------------------------

--
-- Table structure for table `qa`
--

CREATE TABLE `qa` (
  `IDCauHoi` int(11) NOT NULL,
  `CauHoi` varchar(255) NOT NULL,
  `TraLoi` varchar(255) DEFAULT NULL,
  `UserHoi` varchar(12) NOT NULL,
  `UserTL` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `qa`
--

INSERT INTO `qa` (`IDCauHoi`, `CauHoi`, `TraLoi`, `UserHoi`, `UserTL`) VALUES
(1, 'Đây là câu hỏi test', 'Đây là câu trả lời', '000000000002', '000000000001'),
(2, 'Câu hỏi test thứ 2', 'Câu trả lời 2', '000000000002', '000000000001'),
(3, 'Câu hỏi test 3', NULL, '000000000002', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `thongkeyte`
--

CREATE TABLE `thongkeyte` (
  `SoLuongF0` varchar(10) NOT NULL,
  `SoLuongF1` varchar(10) NOT NULL,
  `SoLuongF2` varchar(10) NOT NULL,
  `SoLuongKhoeManh` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `thongkeyte`
--

INSERT INTO `thongkeyte` (`SoLuongF0`, `SoLuongF1`, `SoLuongF2`, `SoLuongKhoeManh`) VALUES
('12', '56', '145', '758');

-- --------------------------------------------------------

--
-- Table structure for table `tokhaiyte`
--

CREATE TABLE `tokhaiyte` (
  `IDToKhai` int(10) NOT NULL,
  `ID` varchar(12) NOT NULL,
  `Sot` varchar(1) NOT NULL,
  `Ho` varchar(1) NOT NULL,
  `KhoTho` varchar(1) NOT NULL,
  `ViemPhoi` varchar(1) NOT NULL,
  `DauHong` varchar(1) NOT NULL,
  `MetMoi` varchar(1) NOT NULL,
  `TrangThaiCachLy` varchar(10) NOT NULL,
  `KetQuaXetNghiem` varchar(10) NOT NULL,
  `Phone` varchar(12) NOT NULL,
  `RegisterDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tokhaiyte`
--

INSERT INTO `tokhaiyte` (`IDToKhai`, `ID`, `Sot`, `Ho`, `KhoTho`, `ViemPhoi`, `DauHong`, `MetMoi`, `TrangThaiCachLy`, `KetQuaXetNghiem`, `Phone`, `RegisterDate`) VALUES
(1, '000000000002', '1', '1', '0', '0', '1', '1', 'Không', 'Âm tính', '0973467591', '2021-12-30');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `ID` varchar(12) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Role` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`ID`, `Username`, `Password`, `Role`) VALUES
('000000000001', 'admin', '1', 1),
('000000000002', 'citizen', '1', 2),
('000000000167', 'longtq123', '1', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `nhankhau`
--
ALTER TABLE `nhankhau`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `qa`
--
ALTER TABLE `qa`
  ADD PRIMARY KEY (`IDCauHoi`),
  ADD KEY `UserHoi` (`UserHoi`);

--
-- Indexes for table `tokhaiyte`
--
ALTER TABLE `tokhaiyte`
  ADD PRIMARY KEY (`IDToKhai`),
  ADD KEY `ID` (`ID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `qa`
--
ALTER TABLE `qa`
  MODIFY `IDCauHoi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tokhaiyte`
--
ALTER TABLE `tokhaiyte`
  MODIFY `IDToKhai` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `qa`
--
ALTER TABLE `qa`
  ADD CONSTRAINT `qa_ibfk_1` FOREIGN KEY (`UserHoi`) REFERENCES `users` (`ID`);

--
-- Constraints for table `tokhaiyte`
--
ALTER TABLE `tokhaiyte`
  ADD CONSTRAINT `tokhaiyte_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `nhankhau` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
