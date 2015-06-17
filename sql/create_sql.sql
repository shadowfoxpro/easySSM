CREATE DATABASE easyssm;
USE easyssm;
DROP TABLE IF EXISTS `ssm_user`;

CREATE TABLE `ssm_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(40) NOT NULL,
  `user_password` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user_t` */

insert  into `ssm_user`(`user_id`,`user_name`,`user_password`) values (1,'test001','test001');