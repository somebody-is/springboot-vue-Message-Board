CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message_key` varchar(45) NOT NULL,
  `message_content` text NOT NULL,
  `message_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `message_master` int(11) DEFAULT '0',
  `is_locked` int(11) DEFAULT '0',
  `message_password` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `master_name` varchar(45) DEFAULT NULL,
  `is_public` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;


CREATE TABLE `ordinary_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `sex` int(11) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `age` int(11) DEFAULT '3',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

