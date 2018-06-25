CREATE TABLE `sample_user` (
  `id` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
INSERT INTO sample_user (id,age,last_name,name) VALUES
('5b19af15586320a62ab8e854',30,'Sullivan','Fernandez')
,('5b19af1580395b8a662caf3d',12,'Blanchard','Lourdes')
,('5b19af158855506a711476e3',10,'Norris','Gross')
,('5b19b0359b1367bbf61fb1d5',25,'Dorsey','Hendrix')
,('5b19afe205cc9d7c0857dacf',40,'Harris','Mejia');