-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 2017-11-03 06:58:21
-- 服务器版本： 5.7.19
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `product`
--

-- --------------------------------------------------------

--
-- 表的结构 `car`
--

CREATE TABLE `car` (
  `id` int(10) NOT NULL,
  `volum` float NOT NULL,
  `name` varchar(20) NOT NULL,
  `tele` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `car`
--

INSERT INTO `car` (`id`, `volum`, `name`, `tele`) VALUES
(1, 200, 'zhangsan', 131),
(2, 100000, 'lisi', 151);

-- --------------------------------------------------------

--
-- 表的结构 `list`
--

CREATE TABLE `list` (
  `id` int(11) NOT NULL,
  `address` varchar(50) CHARACTER SET utf8 NOT NULL,
  `product` int(11) NOT NULL,
  `sendname` varchar(20) CHARACTER SET utf8 NOT NULL,
  `sendtel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `list`
--

INSERT INTO `list` (`id`, `address`, `product`, `sendname`, `sendtel`) VALUES
(1, '昌平区天通苑北街天通苑西二区', 1, 'z', 1),
(3, '昌平区天通苑西三区', 2, 'z', 1),
(4, '昌平区回龙观科星路90号院', 3, 'z', 1),
(5, '昌平区北七家镇立新路东三旗九号家园', 4, '1', 1),
(6, '昌平区东小口东三旗村', 5, '1', 1),
(7, '昌平区北七家镇蔡丹村天通嘉苑', 6, '1', 1),
(8, '昌平区北七家镇望都新地', 7, '1', 1),
(9, '昌平区沙河小沙河村祥和公寓', 8, '1', 1),
(15, '昌平区东沙各庄加油站', 9, '1', 1),
(16, '昌平区北七家镇立汤路364号', 10, '1', 1),
(17, '昌平区北七家镇鲁疃嘉园', 11, '1', 1),
(18, '昌平区北七家镇北亚花园', 12, '1', 1),
(19, '昌平区万家灯火东', 13, '1', 1),
(20, '昌平区回龙观西半壁店村', 14, '1', 1),
(21, '昌平区回龙观西三旗金榜园小区', 15, '1', 1);

-- --------------------------------------------------------

--
-- 表的结构 `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `type` varchar(20) CHARACTER SET utf8 NOT NULL,
  `money` int(11) NOT NULL,
  `color` varchar(10) CHARACTER SET utf8 NOT NULL,
  `efficiency` varchar(10) CHARACTER SET utf8 NOT NULL,
  `weight` float DEFAULT NULL,
  `weight2` float DEFAULT NULL,
  `maoweight` float DEFAULT NULL,
  `maoweight2` float DEFAULT NULL,
  `sizechang` float NOT NULL,
  `sizekuan` float NOT NULL,
  `sizegao` float NOT NULL,
  `size2chang` float DEFAULT NULL,
  `size2kuan` int(11) DEFAULT NULL,
  `size2gao` int(11) DEFAULT NULL,
  `volume` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `product`
--

INSERT INTO `product` (`id`, `name`, `type`, `money`, `color`, `efficiency`, `weight`, `weight2`, `maoweight`, `maoweight2`, `sizechang`, `sizekuan`, `sizegao`, `size2chang`, `size2kuan`, `size2gao`, `volume`) VALUES
(1, 'BCD-350WDPG', '冰箱', 3699, '凯岩灰色', '1级', 75, 0, 0, 0, 65.7, 59.5, 190.3, 0, 0, 0, 0.7439),
(2, 'KFR-26GW/03JMY23AU1(Q)套机', '挂式空调', 2899, '白', '3级', 10.5, 28, 0, 0, 86.5, 20, 29, 830, 285, 545, 0.0502),
(3, 'KFR-50LW/12CAA22AU1套机', '立式空调', 8599, '海尔白', '2级', 37, 35, 0, 0, 38.7, 41.7, 181, 905, 365, 615, 0.2921),
(4, 'EG7012B29W', '滚筒洗衣机', 2999, '白', '1级', 64, 0, 70, 0, 85, 59.5, 51, 0, 0, 0, 0.2579),
(5, 'EC6002-Q6', '电热水器', 1199, '白', '2级', 20, 0, 24, 0, 76.6, 41.1, 44.9, 0, 0, 0, 0.1414),
(6, 'EC6002-MC3', '电热水器', 1399, '白', '1级', 23, 0, 27, 0, 81.2, 44.2, 48.7, 0, 0, 0, 0.1748),
(7, 'BCD-642WDVMU1', '冰箱', 5099, '香槟金', '2级', 115, 0, 0, 0, 73.8, 90.8, 179, 0, 0, 0, 1.1995),
(8, 'EG8012BX19S', '滚筒洗衣机', 3699, '银灰', '1级', 70, 0, 77, 0, 85, 59.5, 60, 0, 0, 0, 0.3035),
(9, 'EC6002-MC3', '电热水器', 1399, '白', '1级', 23, 0, 27, 0, 81.2, 44.2, 48.7, 0, 0, 0, 0.1748),
(10, 'BCD-629WDEYU1', '冰箱', 7399, '金棕', '1级', 130, 0, 145, 0, 73.8, 90.8, 179, 0, 0, 0, 1.1995),
(11, 'EG10014HBX39GU1', '滚筒洗衣机', 3999, '香槟金', '1级', 72, 0, 79, 0, 85, 59.5, 60, 0, 0, 0, 0.3035),
(12, 'BCD-451WDEMU1', '冰箱', 2999, '藕纱白', '2级', 92, 0, 102, 0, 66.5, 83.3, 179, 0, 0, 0, 0.9916),
(13, 'KFR-26GW/21TMAAL23AU1套机', '挂式空调', 2799, '白', '3级', 9.7, 27.5, 11.7, 30.5, 86, 19, 30, 830, 285, 545, 0.049),
(14, 'KFR-35GW/21TMAAL23AU1套机', '挂式空调', 3099, '白', '3级', 10, 29.5, 12, 32.5, 86, 19, 30, 830, 345, 550, 0.049),
(15, 'KFR-50LW/03JAA23A套机', '立式空调', 6199, '白', '3级', 38, 42, 0, 0, 49.1, 171.5, 31, 890, 615, 365, 0.261);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `car`
--
ALTER TABLE `car`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `list`
--
ALTER TABLE `list`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `car`
--
ALTER TABLE `car`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- 使用表AUTO_INCREMENT `list`
--
ALTER TABLE `list`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- 使用表AUTO_INCREMENT `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
