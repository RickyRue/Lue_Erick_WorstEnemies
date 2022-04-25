-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.7.2-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for worst_enemies
CREATE DATABASE IF NOT EXISTS `worst_enemies` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `worst_enemies`;

-- Dumping structure for table worst_enemies.hibernate_sequence
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table worst_enemies.hibernate_sequence: ~0 rows (approximately)
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES
	(319);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

-- Dumping structure for table worst_enemies.questions
CREATE TABLE IF NOT EXISTS `questions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_svg` varchar(255) DEFAULT NULL,
  `first_text` varchar(255) DEFAULT NULL,
  `second_svg` varchar(255) DEFAULT NULL,
  `second_text` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- Dumping data for table worst_enemies.questions: ~8 rows (approximately)
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` (`id`, `first_svg`, `first_text`, `second_svg`, `second_text`) VALUES
	(3, 'elbow-01', 'Kraft Blue Box', 'shells-01', 'Velveeta Shells'),
	(4, 'coke-01', 'Coke', 'pepsi-01', 'Pepsi'),
	(5, 'gif-01', 'Pronounced \'gif\'', 'jif-01', 'Pronounced \'jif\''),
	(6, 'wheels-01', 'Wheels', 'doors-01', 'Doors'),
	(8, 'water-01', 'Water is Wet', 'towel-01', 'Water is Not Wet'),
	(9, 'ketchup-01', 'Ketchup is a Condiment', 'smoothie-01', 'Ketchup is a Jam'),
	(10, 'cerealbox-01', 'Cereal is a Soup', 'soup-01', 'Cereal is not Soup'),
	(11, 'straw-01', 'A Straw has One Hole', 'straw-02', 'A Straw has Two Holes'),
	(12, 'chicken-01', 'The Chicken', 'egg-01', 'The Egg'),
	(13, 'toiletpaper-01', 'Does Toilet Paper go Under?', 'toiletpaper-02', 'Does Toilet Paper go Over?');
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;

-- Dumping structure for table worst_enemies.role
CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table worst_enemies.role: ~7 rows (approximately)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `name`) VALUES
	(8, 'ROLE_ADMIN'),
	(9, 'ROLE_USER'),
	(18, 'ROLE_USER'),
	(24, 'ROLE_USER'),
	(102, 'ROLE_USER'),
	(113, 'ROLE_USER'),
	(128, 'ROLE_USER'),
	(139, 'ROLE_USER'),
	(216, 'ROLE_USER'),
	(242, 'ROLE_USER'),
	(268, 'ROLE_USER'),
	(284, 'ROLE_USER'),
	(302, 'ROLE_USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Dumping structure for table worst_enemies.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

-- Dumping data for table worst_enemies.users: ~7 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `email`, `password`, `user_name`) VALUES
	(1, 'admin@mail.com', '{bcrypt}$2a$10$a5WsjmLmugVU.eN6ScVTzOcKnlyyVhea/JhOMMrnwvf1ksxV.1tX2', 'admin'),
	(2, 'user@mail.com', '{bcrypt}$2a$10$BdGqE3z5Czw9A2l4YRkWu.4tAPy4327SYXWENn9EFAFnd5.3oWv5C', 'User'),
	(3, 'user2@mail.com', '{bcrypt}$2a$10$/pavKxA0GrV.Y9b7TAZXqOzcd1ZNjMOwXD5gVk15gsEYVi.KYZ5oS', 'user2'),
	(7, 'usertrue@mail.com', '{bcrypt}$2a$10$VN4rwVAs3mo9UiIfKrHgAO/4Q0SeyLZJck9ruwNgnJoFWwvuDm7Dy', 'usertrue'),
	(8, 'userfalse@mail.com', '{bcrypt}$2a$10$TwZZeTViIvT/UhvWJqp0.ut8QpggxqI8zU.cUrQNC1UKB2M7GiKN.', 'userfalse'),
	(9, 'usertruefalse@mail.com', '{bcrypt}$2a$10$aC/CZei/HRyVH0FuNJkvwOt3KiUy94BAPVaoLTV2nb2wJh.R1K.46', 'usertruefalse'),
	(10, 'userfalsetrue@mail.com', '{bcrypt}$2a$10$qKNqeKyf/Klz8.BpxibKseriEBwkBL3Hk7lSZgKBEWKJWBcAjsKKC', 'userfalsetrue'),
	(11, 'samanthalue1105@gmail.com', '{bcrypt}$2a$10$No0V3Ho83s/bKVouIxXTrOSwtAGM8B45xjE9Ff.Y0GuT5thbojpOu', 'slue'),
	(12, 'jgard@yel.com', '{bcrypt}$2a$10$xM3dul6U464X0Rt7D1x1verEVBATRGwT.egs1cKw4ml8FMZrNRuqW', 'jay_gee'),
	(13, 'erick@mail.com', '{bcrypt}$2a$10$NKhOHIStL.wDufGbIwtmjeRt/FE9K9.foGjUg9j46NJvgF5HR78Jy', 'ericklue'),
	(14, 'sean@mail.com', '{bcrypt}$2a$10$JOieqKBxudwoj6e8W.fEnOsWHHTzjcwnSJlY3Ribw8wzq7WAInaEa', 'seanl'),
	(15, 'maddsion@mail.com', '{bcrypt}$2a$10$0YVnxekOs1DVxMpn1QdGhuiJSMgPrlxO2sXZcPdvRHZssmfaLRyLK', 'maddsion');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

-- Dumping structure for table worst_enemies.users_roles
CREATE TABLE IF NOT EXISTS `users_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `FKt4v0rrweyk393bdgt107vdx0x` (`role_id`),
  KEY `FK2o0jvgh89lemvvo17cbqvdxaa` (`user_id`),
  CONSTRAINT `FK2o0jvgh89lemvvo17cbqvdxaa` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKt4v0rrweyk393bdgt107vdx0x` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table worst_enemies.users_roles: ~7 rows (approximately)
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES
	(1, 8),
	(1, 9),
	(2, 18),
	(3, 24),
	(7, 102),
	(8, 113),
	(9, 128),
	(10, 139),
	(11, 216),
	(12, 242),
	(13, 268),
	(14, 284),
	(15, 302);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;

-- Dumping structure for table worst_enemies.users_scores
CREATE TABLE IF NOT EXISTS `users_scores` (
  `pairs` bigint(20) NOT NULL,
  `enemy_score` int(11) DEFAULT NULL,
  `user1_id` bigint(20) NOT NULL,
  `user2_id` bigint(20) NOT NULL,
  PRIMARY KEY (`pairs`),
  KEY `FK96perfjymgaw6cqw04uhlhhrk` (`user2_id`),
  KEY `FKa3lj6d6x48f19r0kwwrnsk56v` (`user1_id`),
  CONSTRAINT `FK96perfjymgaw6cqw04uhlhhrk` FOREIGN KEY (`user2_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKa3lj6d6x48f19r0kwwrnsk56v` FOREIGN KEY (`user1_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table worst_enemies.users_scores: ~53 rows (approximately)
/*!40000 ALTER TABLE `users_scores` DISABLE KEYS */;
INSERT INTO `users_scores` (`pairs`, `enemy_score`, `user1_id`, `user2_id`) VALUES
	(203, 4, 7, 3),
	(204, 10, 7, 8),
	(205, 4, 7, 9),
	(206, 5, 7, 10),
	(207, 5, 8, 3),
	(208, 6, 8, 9),
	(209, 5, 8, 10),
	(210, 4, 7, 3),
	(211, 10, 7, 8),
	(212, 4, 7, 9),
	(213, 5, 7, 10),
	(227, 4, 11, 3),
	(228, 4, 11, 9),
	(229, 5, 11, 10),
	(230, 4, 11, 3),
	(231, 4, 11, 9),
	(232, 5, 11, 10),
	(239, 4, 11, 3),
	(240, 4, 11, 9),
	(241, 5, 11, 10),
	(253, 5, 12, 3),
	(254, 10, 12, 8),
	(255, 4, 12, 9),
	(256, 5, 12, 10),
	(257, 4, 12, 11),
	(258, 5, 12, 3),
	(259, 10, 12, 8),
	(260, 4, 12, 9),
	(261, 5, 12, 10),
	(262, 4, 12, 11),
	(263, 5, 12, 3),
	(264, 10, 12, 8),
	(265, 4, 12, 9),
	(266, 5, 12, 10),
	(267, 4, 12, 11),
	(279, 4, 13, 3),
	(280, 4, 13, 9),
	(281, 5, 13, 10),
	(282, 4, 13, 11),
	(283, 9, 13, 12),
	(295, 5, 14, 3),
	(296, 10, 14, 8),
	(297, 4, 14, 9),
	(298, 5, 14, 10),
	(299, 4, 14, 11),
	(300, 1, 14, 12),
	(301, 3, 14, 13),
	(313, 4, 15, 3),
	(314, 4, 15, 9),
	(315, 5, 15, 10),
	(316, 4, 15, 11),
	(317, 1, 15, 12),
	(318, 7, 15, 13);
/*!40000 ALTER TABLE `users_scores` ENABLE KEYS */;

-- Dumping structure for table worst_enemies.user_responses
CREATE TABLE IF NOT EXISTS `user_responses` (
  `id` bigint(20) NOT NULL,
  `choice` bit(1) DEFAULT NULL,
  `question_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjkpkrl7envn449i8n2i5jg6ra` (`question_id`),
  KEY `FKawbcqv7094c2wineyamms6nxp` (`user_id`),
  CONSTRAINT `FKawbcqv7094c2wineyamms6nxp` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKjkpkrl7envn449i8n2i5jg6ra` FOREIGN KEY (`question_id`) REFERENCES `questions` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table worst_enemies.user_responses: ~107 rows (approximately)
/*!40000 ALTER TABLE `user_responses` DISABLE KEYS */;
INSERT INTO `user_responses` (`id`, `choice`, `question_id`, `user_id`) VALUES
	(15, b'0', 4, 1),
	(16, b'0', 5, 1),
	(17, b'0', 13, 1),
	(19, b'1', 5, 2),
	(20, b'1', 6, 2),
	(21, b'0', 4, 2),
	(22, b'0', 6, 2),
	(23, b'0', 12, 2),
	(25, b'1', 3, 3),
	(26, b'1', 4, 3),
	(27, b'0', 6, 3),
	(28, b'1', 9, 3),
	(29, b'0', 12, 3),
	(30, b'1', 10, 3),
	(31, b'1', 11, 3),
	(32, b'0', 13, 3),
	(33, b'0', 8, 3),
	(103, b'1', 3, 7),
	(104, b'1', 4, 7),
	(105, b'1', 5, 7),
	(106, b'1', 6, 7),
	(107, b'1', 9, 7),
	(108, b'1', 12, 7),
	(109, b'1', 10, 7),
	(110, b'1', 11, 7),
	(111, b'1', 13, 7),
	(112, b'1', 8, 7),
	(114, b'0', 3, 8),
	(115, b'0', 4, 8),
	(116, b'0', 5, 8),
	(117, b'0', 6, 8),
	(118, b'0', 9, 8),
	(119, b'0', 12, 8),
	(120, b'0', 10, 8),
	(121, b'0', 11, 8),
	(122, b'0', 13, 8),
	(123, b'0', 8, 8),
	(129, b'1', 3, 9),
	(130, b'0', 4, 9),
	(131, b'1', 5, 9),
	(132, b'0', 6, 9),
	(133, b'1', 9, 9),
	(134, b'0', 12, 9),
	(135, b'1', 10, 9),
	(136, b'0', 11, 9),
	(137, b'1', 13, 9),
	(138, b'1', 8, 9),
	(140, b'0', 3, 10),
	(141, b'1', 4, 10),
	(142, b'0', 5, 10),
	(143, b'1', 6, 10),
	(144, b'0', 9, 10),
	(145, b'1', 12, 10),
	(146, b'0', 10, 10),
	(147, b'1', 11, 10),
	(148, b'0', 13, 10),
	(149, b'1', 8, 10),
	(217, b'1', 3, 11),
	(218, b'1', 4, 11),
	(219, b'1', 5, 11),
	(220, b'1', 6, 11),
	(221, b'1', 9, 11),
	(222, b'0', 12, 11),
	(223, b'0', 10, 11),
	(224, b'1', 11, 11),
	(225, b'0', 13, 11),
	(226, b'0', 8, 11),
	(243, b'0', 3, 12),
	(244, b'1', 4, 12),
	(245, b'1', 5, 12),
	(246, b'1', 6, 12),
	(247, b'1', 9, 12),
	(248, b'1', 12, 12),
	(249, b'1', 10, 12),
	(250, b'1', 11, 12),
	(251, b'1', 13, 12),
	(252, b'1', 8, 12),
	(269, b'1', 3, 13),
	(270, b'1', 4, 13),
	(271, b'1', 5, 13),
	(272, b'1', 6, 13),
	(273, b'1', 9, 13),
	(274, b'0', 12, 13),
	(275, b'1', 10, 13),
	(276, b'1', 11, 13),
	(277, b'0', 13, 13),
	(278, b'0', 8, 13),
	(285, b'0', 3, 14),
	(286, b'1', 4, 14),
	(287, b'1', 5, 14),
	(288, b'1', 6, 14),
	(289, b'1', 9, 14),
	(290, b'1', 12, 14),
	(291, b'0', 10, 14),
	(292, b'1', 11, 14),
	(293, b'1', 13, 14),
	(294, b'1', 8, 14),
	(303, b'1', 3, 15),
	(304, b'1', 4, 15),
	(305, b'1', 5, 15),
	(306, b'1', 6, 15),
	(307, b'1', 9, 15),
	(308, b'1', 12, 15),
	(309, b'0', 10, 15),
	(310, b'1', 11, 15),
	(311, b'0', 13, 15),
	(312, b'0', 8, 15);
/*!40000 ALTER TABLE `user_responses` ENABLE KEYS */;


/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
