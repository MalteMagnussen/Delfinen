DROP SCHEMA IF EXISTS `Delfinen`;
CREATE SCHEMA `Delfinen`;
USE `Delfinen`;

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
 `member_id` varchar(255),
 `member_name` varchar(255),
 `member_age` varchar(255),
 `member_address` varchar(255),
 `member_mail` varchar(255),
 `member_number` int(255) NOT NULL,
 PRIMARY KEY (`member_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

DROP TABLE IF EXISTS `kontigent`;

CREATE TABLE `kontigent` (
 `member_id` varchar(255),
 `kon_year` varchar(255),
 `payment` int(255),
 PRIMARY KEY (`member_id`)
 )
 
 DROP TABLE IF EXISTS `teams`;
 
 CREATE TABLE `teams` (
 `member_id` varchar(255),
 `team_name` varchar(255),
 PRIMARY KEY (`member_id`)
 )
 
 DROP TABlE IF EXISTS `konkurrence_results`;
 
 CREATE TABLE `konkurrence_results` (
 `member_id` varchar(255),
 `distance` int(255),
 `res_time` double,
 `res_date` varchar(255),
 PRIMARY KEY (`member_id`)
) 

DROP TABLE IF EXISTS `trainnings_res`;

CREATE TABLE `trainnings_res` (
 `member_id` varchar(255),
 `distance` int(255) NOT NULL,
 `res_time` varchar(255),
 `res_date` varchar(255),
 PRIMARY KEY (`member_id`)
 )
 
 DROP TABLE IF EXISTS `competition`;
 
 CREATE TABLE `competition` (
 `comp_name` varchar(255),
 `comp_date` varchar(255),
 PRIMARY KEY (`comp_name`)
 )
