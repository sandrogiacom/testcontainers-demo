CREATE TABLE `sample_user` (
  `id` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
INSERT INTO sample_user values ('11111', 39, 'Giacomozzi', 'Sandro');