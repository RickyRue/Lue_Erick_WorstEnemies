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



-- Dumping structure for table worst_enemies_testdb.hibernate_sequence
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table worst_enemies_testdb.hibernate_sequence: ~0 rows (approximately)
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES
	(1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

-- Dumping structure for table worst_enemies_testdb.questions
CREATE TABLE IF NOT EXISTS `questions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_svg` varchar(255) DEFAULT NULL,
  `first_text` varchar(255) DEFAULT NULL,
  `second_svg` varchar(255) DEFAULT NULL,
  `second_text` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- Dumping data for table worst_enemies_testdb.questions: ~2 rows (approximately)
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` (`id`, `first_svg`, `first_text`, `second_svg`, `second_text`) VALUES
	(1, 'Left.svg', 'Left', 'Right.svg', 'Right'),
	(2, 'Left.svg', 'Left', 'Right.svg', 'Right'),
	(3, 'elbow-01', 'Kraft Blue Box', 'shells-01', 'Velveeta Shells'),
	(4, 'coke-01', 'Coke', 'pepsi-01', 'Pepsi'),
	(5, 'gif-01', 'Pronounced \'gif\'', 'jif-01', 'Pronounced \'jif\''),
	(6, 'wheels-01', 'Wheels', 'doors-01', 'Doors'),
	(7, 'water-01', 'Water is Wet', 'towel-01', 'Water is Not Wet'),
	(8, 'ketchup-01', 'Ketchup is a Condiment', 'smoothie-01', 'Ketchup is a Jam'),
	(9, 'cerealbox-01', 'Cereal is a Soup', 'soup-01', 'Cereal is not Soup'),
	(10, 'straw-01', 'A Straw has One Hole', 'straw-02', 'A Straw has Two Holes'),
	(11, 'chicken-01', 'The Chicken', 'egg-01', 'The Egg'),
	(12, 'toiletpaper-01', 'Does Toilet Paper go Under?', 'toiletpaper-02', 'Does Toilet Paper go Over?');
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;

-- Dumping structure for table worst_enemies_testdb.role
CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table worst_enemies_testdb.role: ~0 rows (approximately)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Dumping structure for table worst_enemies_testdb.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

-- Dumping data for table worst_enemies_testdb.users: ~2 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `email`, `password`, `user_name`) VALUES
	(10, 'test@mail.com', 'Abcd1234!', 'Test'),
	(11, 'testUser1@mail.com"', 'Abcd12345!', 'testUser1'),
	(12, 'testUser2@mail.com"', 'Abcd12345!', 'testUser2'),
	(13, 'testUser3@mail.com"', 'Abcd12345!', 'testUser3');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

-- Dumping structure for table worst_enemies_testdb.users_roles
CREATE TABLE IF NOT EXISTS `users_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `FKt4v0rrweyk393bdgt107vdx0x` (`role_id`),
  KEY `FK2o0jvgh89lemvvo17cbqvdxaa` (`user_id`),
  CONSTRAINT `FK2o0jvgh89lemvvo17cbqvdxaa` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKt4v0rrweyk393bdgt107vdx0x` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table worst_enemies_testdb.users_roles: ~0 rows (approximately)
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;

-- Dumping structure for table worst_enemies_testdb.users_scores
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

-- Dumping data for table worst_enemies_testdb.users_scores: ~0 rows (approximately)
/*!40000 ALTER TABLE `users_scores` DISABLE KEYS */;
INSERT INTO `users_scores` (`pairs`, `enemy_score`, `user1_id`, `user2_id`) VALUES
	(1, 10, 11, 12),
	(2, 10, 12, 11);
/*!40000 ALTER TABLE `users_scores` ENABLE KEYS */;

-- Dumping structure for table worst_enemies_testdb.user_responses
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

-- Dumping data for table worst_enemies_testdb.user_responses: ~0 rows (approximately)
/*!40000 ALTER TABLE `user_responses` DISABLE KEYS */;
INSERT INTO `user_responses` (`id`, `choice`, `question_id`, `user_id`) VALUES
	(1, b'1', 3, 11),
	(2, b'1', 4, 11),
	(3, b'1', 5, 11),
	(4, b'1', 6, 11),
	(5, b'1', 7, 11),
	(6, b'1', 8, 11),
	(7, b'1', 9, 11),
	(8, b'1', 10, 11),
	(9, b'1', 11, 11),
	(10, b'1', 12, 11),
	(11, b'0', 3, 12),
	(12, b'0', 4, 12),
	(13, b'0', 5, 12),
	(14, b'0', 6, 12),
	(15, b'0', 7, 12),
	(16, b'0', 8, 12),
	(17, b'0', 9, 12),
	(18, b'0', 10, 12),
	(19, b'0', 11, 12),
	(20, b'0', 12, 12);
/*!40000 ALTER TABLE `user_responses` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
