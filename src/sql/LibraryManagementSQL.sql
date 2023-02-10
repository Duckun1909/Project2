create database LibraryManagement;
use LibraryManagement;

CREATE TABLE `Admin` (
  `id` int PRIMARY KEY auto_increment,
  `adm_name` varchar(50),
  `adm_pass` varchar(50),
  `adm_fullname` nvarchar(100)
);

CREATE TABLE `Author` (
  `id` int PRIMARY KEY auto_increment,
  `au_name` nvarchar(100),
  `au_description` nvarchar(299)
);

CREATE TABLE `Pushlisher` (
  `id` int PRIMARY KEY auto_increment,
  `pus_name` nvarchar(100),
  `pus_email` nvarchar(50),
  `pus_web` nvarchar(299),
  `pus_address` nvarchar(150)
);

CREATE TABLE `Category` (
  `id` int PRIMARY KEY auto_increment,
  `cat_name` nvarchar(100),
  `cat_description` nvarchar(100)
);

CREATE TABLE `Reader` (
  `id` int PRIMARY KEY auto_increment,
  `reader_name` nvarchar(100),
  `reader_phone` char(10),
  `reader_address` nvarchar(150),
  `reader_cid` char(15)
);

CREATE TABLE `Book` (
  `id` int PRIMARY KEY auto_increment,
  `book_name` nvarchar(100),
  `book_price` float,
  `book_description` nvarchar(299),
  `book_img` nvarchar(299),
  `book_quantity` int,
  `cat_id` int,
  `author_id` int,
  `pushlisher_id` int
);

CREATE TABLE `Borrow` (
  `id` int PRIMARY KEY auto_increment,
  `reader_id` int,
  `borrow_date` datetime,
  `return_date` datetime,
  `returnStatus` nvarchar(150)
);

CREATE TABLE `BorrowDetail` (
  `id` int primary key auto_increment,
  `book_id` int,
  `borrow_id` int,
  `payment` float
);

ALTER TABLE `Book` ADD FOREIGN KEY (`cat_id`) REFERENCES `Category`(id);

ALTER TABLE `Book` ADD FOREIGN KEY (`author_id`) REFERENCES `Author` (`id`);

ALTER TABLE `Book` ADD FOREIGN KEY (`pushlisher_id`) REFERENCES `Pushlisher` (`id`);

ALTER TABLE `Borrow` ADD FOREIGN KEY (`reader_id`) REFERENCES `Reader` (`id`);

ALTER TABLE `BorrowDetail` ADD FOREIGN KEY (`borrow_id`) REFERENCES `Borrow`(`id`);

ALTER TABLE `BorrowDetail` ADD FOREIGN KEY (`book_id`) REFERENCES `Book` (`id`);
