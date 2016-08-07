CREATE DATABASE IF NOT EXISTS `test`;
USE test;
CREATE TABLE IF NOT EXISTS `test`.`users` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `age` INT(3) NULL,
  `isAdmin` BIT(1) NULL,
  `createdDate` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;
TRUNCATE TABLE users;
insert into users (isAdmin, age, createdDate, name) values (1, 21, '2013-08-05', 'user_1');
insert into users (isAdmin, age, createdDate, name) values (0, 22, '2013-08-06', 'user_2');
insert into users (isAdmin, age, createdDate, name) values (1, 23, '2013-08-07', 'user_3');
insert into users (isAdmin, age, createdDate, name) values (0, 24, '2013-08-08', 'user_4');
insert into users (isAdmin, age, createdDate, name) values (1, 25, '2013-08-09', 'user_5');
insert into users (isAdmin, age, createdDate, name) values (0, 26, '2013-08-10', 'user_6');
insert into users (isAdmin, age, createdDate, name) values (1, 27, '2013-08-11', 'user_7');
insert into users (isAdmin, age, createdDate, name) values (0, 28, '2013-08-12', 'user_8');
insert into users (isAdmin, age, createdDate, name) values (1, 29, '2013-08-13', 'user_9');
insert into users (isAdmin, age, createdDate, name) values (0, 30, '2013-08-14', 'user_10');
insert into users (isAdmin, age, createdDate, name) values (1, 31, '2013-08-15', 'user_11');
insert into users (isAdmin, age, createdDate, name) values (0, 32, '2013-08-16', 'user_12');
insert into users (isAdmin, age, createdDate, name) values (1, 33, '2013-08-17', 'user_13');
insert into users (isAdmin, age, createdDate, name) values (0, 34, '2013-08-18', 'user_14');
insert into users (isAdmin, age, createdDate, name) values (1, 35, '2013-08-19', 'user_15');
insert into users (isAdmin, age, createdDate, name) values (0, 36, '2013-08-20', 'user_16');
insert into users (isAdmin, age, createdDate, name) values (1, 37, '2013-08-21', 'user_17');
insert into users (isAdmin, age, createdDate, name) values (0, 38, '2013-08-22', 'user_18');
insert into users (isAdmin, age, createdDate, name) values (1, 39, '2013-08-23', 'user_19');
insert into users (isAdmin, age, createdDate, name) values (0, 40, '2013-08-24', 'user_20');
insert into users (isAdmin, age, createdDate, name) values (1, 41, '2013-08-25', 'user_21');
insert into users (isAdmin, age, createdDate, name) values (0, 42, '2013-08-26', 'user_22');
insert into users (isAdmin, age, createdDate, name) values (1, 43, '2013-08-27', 'user_23');
insert into users (isAdmin, age, createdDate, name) values (0, 44, '2013-08-28', 'user_24');
insert into users (isAdmin, age, createdDate, name) values (1, 45, '2013-08-29', 'user_25');
insert into users (isAdmin, age, createdDate, name) values (0, 46, '2013-08-30', 'user_26');
insert into users (isAdmin, age, createdDate, name) values (1, 47, '2013-08-31', 'user_27');
insert into users (isAdmin, age, createdDate, name) values (0, 48, '2013-08-32', 'user_28');
insert into users (isAdmin, age, createdDate, name) values (1, 49, '2013-08-33', 'user_29');
insert into users (isAdmin, age, createdDate, name) values (0, 50, '2013-08-34', 'user_30');

        