-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 26, 2019 at 12:25 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `aikan`
--

-- --------------------------------------------------------

--
-- Table structure for table `hasil_analisis`
--

CREATE TABLE `hasil_analisis` (
  `id` int(11) NOT NULL,
  `hasil_analis` varchar(50) NOT NULL,
  `tgl_analis` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  `id_user` int(11) NOT NULL,
  `id_kolam` int(11) NOT NULL,
  `id_ikan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hasil_analisis`
--

INSERT INTO `hasil_analisis` (`id`, `hasil_analis`, `tgl_analis`, `id_user`, `id_kolam`, `id_ikan`) VALUES
(1, 'nullPh ikan lebih besar dari pH kolam', '0000-00-00 00:00:00.000000', 1, 1, 1),
(2, 'nullPh ikan lebih besar dari pH kolam', '0000-00-00 00:00:00.000000', 1, 1, 1),
(3, 'nullPh ikan lebih besar dari pH kolam', '2019-10-26 20:22:04.359320', 1, 1, 1),
(4, 'nullPh ikan lebih besar dari pH kolam', '2019-10-28 10:17:37.263738', 1, 1, 2),
(5, 'nullPh ikan lebih besar dari pH kolam', '2019-11-11 07:51:51.871013', 1, 1, 1),
(6, 'nullPh ikan lebih besar dari pH kolam', '2019-11-11 08:02:25.919512', 1, 1, 1),
(7, 'Kolam ikan dalam kondisi baik', '2019-11-26 10:38:56.317036', 1, 1, 1),
(8, 'Kolam ikan dalam kondisi baik', '2019-11-26 10:43:20.329923', 1, 1, 1),
(9, 'Ph ikan lebih besar dari pH kolam', '2019-11-26 10:46:42.390353', 1, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `ikan`
--

CREATE TABLE `ikan` (
  `id_ikan` int(11) NOT NULL,
  `id_tahap_ikan` int(11) NOT NULL,
  `nama_ikan` varchar(50) NOT NULL,
  `ph_ikan` int(50) NOT NULL,
  `suhu_ikan` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ikan`
--

INSERT INTO `ikan` (`id_ikan`, `id_tahap_ikan`, `nama_ikan`, `ph_ikan`, `suhu_ikan`) VALUES
(1, 2, 'Lele', 6, 25),
(2, 2, 'Patin', 6, 25);

-- --------------------------------------------------------

--
-- Table structure for table `kolam`
--

CREATE TABLE `kolam` (
  `id_kolam` int(11) NOT NULL,
  `id_tahap_kolam` int(11) NOT NULL,
  `nama_kolam` varchar(50) NOT NULL,
  `volume_kolam` int(50) NOT NULL,
  `suhu_kolam` int(50) NOT NULL,
  `ph_kolam` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kolam`
--

INSERT INTO `kolam` (`id_kolam`, `id_tahap_kolam`, `nama_kolam`, `volume_kolam`, `suhu_kolam`, `ph_kolam`) VALUES
(1, 1, 'Kolam 1', 210, 25, 6),
(2, 1, 'Kolam 2', 210, 25, 9);

-- --------------------------------------------------------

--
-- Table structure for table `level_user`
--

CREATE TABLE `level_user` (
  `id_level` int(11) NOT NULL,
  `nama_level` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `level_user`
--

INSERT INTO `level_user` (`id_level`, `nama_level`) VALUES
(1, 'admin'),
(2, 'user');

-- --------------------------------------------------------

--
-- Table structure for table `pembersihan`
--

CREATE TABLE `pembersihan` (
  `id` int(11) NOT NULL,
  `id_kolam` int(11) NOT NULL,
  `deskripsi` varchar(191) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tahap`
--

CREATE TABLE `tahap` (
  `id_tahap` int(11) NOT NULL,
  `nama_tahap` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tahap`
--

INSERT INTO `tahap` (`id_tahap`, `nama_tahap`) VALUES
(1, 'Pemijahan'),
(2, 'Pemeliharaan Benih'),
(4, 'Pembesaran'),
(5, 'Tes');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `nama_lengkap` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `id_level` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `nama_lengkap`, `username`, `password`, `id_level`) VALUES
(1, 'Fendy Marzuki', 'admin', 'admin', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hasil_analisis`
--
ALTER TABLE `hasil_analisis`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_ikan` (`id_ikan`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_kolam` (`id_kolam`);

--
-- Indexes for table `ikan`
--
ALTER TABLE `ikan`
  ADD PRIMARY KEY (`id_ikan`),
  ADD KEY `id_tahap` (`id_tahap_ikan`);

--
-- Indexes for table `kolam`
--
ALTER TABLE `kolam`
  ADD PRIMARY KEY (`id_kolam`),
  ADD KEY `id_tahap` (`id_tahap_kolam`);

--
-- Indexes for table `level_user`
--
ALTER TABLE `level_user`
  ADD PRIMARY KEY (`id_level`);

--
-- Indexes for table `pembersihan`
--
ALTER TABLE `pembersihan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_kolam` (`id_kolam`);

--
-- Indexes for table `tahap`
--
ALTER TABLE `tahap`
  ADD PRIMARY KEY (`id_tahap`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD KEY `id_level` (`id_level`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hasil_analisis`
--
ALTER TABLE `hasil_analisis`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `ikan`
--
ALTER TABLE `ikan`
  MODIFY `id_ikan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `kolam`
--
ALTER TABLE `kolam`
  MODIFY `id_kolam` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `level_user`
--
ALTER TABLE `level_user`
  MODIFY `id_level` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `pembersihan`
--
ALTER TABLE `pembersihan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tahap`
--
ALTER TABLE `tahap`
  MODIFY `id_tahap` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `hasil_analisis`
--
ALTER TABLE `hasil_analisis`
  ADD CONSTRAINT `hasil_analisis_ibfk_1` FOREIGN KEY (`id_ikan`) REFERENCES `ikan` (`id_ikan`),
  ADD CONSTRAINT `hasil_analisis_ibfk_2` FOREIGN KEY (`id_kolam`) REFERENCES `kolam` (`id_kolam`),
  ADD CONSTRAINT `hasil_analisis_ibfk_3` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `ikan`
--
ALTER TABLE `ikan`
  ADD CONSTRAINT `ikan_ibfk_1` FOREIGN KEY (`id_tahap_ikan`) REFERENCES `tahap` (`id_tahap`);

--
-- Constraints for table `kolam`
--
ALTER TABLE `kolam`
  ADD CONSTRAINT `kolam_ibfk_1` FOREIGN KEY (`id_tahap_kolam`) REFERENCES `tahap` (`id_tahap`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`id_level`) REFERENCES `level_user` (`id_level`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
