-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 14, 2020 at 05:44 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tucshop`
--

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `image`, `name`) VALUES
(1, 'http://localhost:8080/api/category/image/Chips/1586648317505chips icon.png', 'Chips'),
(2, 'http://localhost:8080/api/category/image/Drinks/1586648329752drinks.jpg', 'Drinks'),
(3, 'http://localhost:8080/api/category/image/Biscuits/1586648349943biscuitsIcon.jpg', 'Biscuits'),
(4, 'http://localhost:8080/api/category/image/Cakes/1586875744871icons8-cake-48.png', 'Cakes'),
(5, 'http://localhost:8080/api/category/image/Candies/1586875828791icons8-halloween-candy-64.png', 'Candies');

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `costprice`, `date1`, `description`, `image`, `name`, `price`, `qty`, `variants`, `category_id`) VALUES
(1, 8, '2020-04-11', NULL, 'http://localhost:8080/api/products/image/Chips/Lays/1586648383820Lays.png', 'Lays', 10, 60, 'SMALL', 1),
(2, 25, '2020-04-11', NULL, 'http://localhost:8080/api/products/image/Chips/Lays/1586648494237Lays.png', 'Lays', 30, 60, 'LARGE', 1),
(3, 6, '2020-04-11', NULL, 'http://localhost:8080/api/products/image/Chips/Kurleez/1586648538758Kurleez.png', 'Kurleez', 10, 100, 'SMALL', 1),
(4, 37, '2020-04-11', NULL, 'http://localhost:8080/api/products/image/Chips/Kurleez/1586648581116Kurleez.png', 'Kurleez', 40, 60, 'LARGE', 1),
(5, 35, '2020-04-11', NULL, 'http://localhost:8080/api/products/image/Drinks/Coke/1586648607764Coke.png', 'Coke', 40, 120, '500ML', 2),
(6, 80, '2020-04-11', NULL, 'http://localhost:8080/api/products/image/Drinks/Coke/1586648636137Coke.png', 'Coke', 90, 150, '1.5LTR', 2),
(7, 35, '2020-04-11', NULL, 'http://localhost:8080/api/products/image/Drinks/Sprite/1586648667945Sprite.png', 'Sprite', 45, 150, '500ML', 2),
(8, 90, '2020-04-11', NULL, 'http://localhost:8080/api/products/image/Drinks/Sprite/1586648718458Sprite.png', 'Sprite', 100, 78, '1.5LTR', 2),
(9, 5, '2020-04-11', NULL, 'http://localhost:8080/api/products/image/Biscuits/Candy/1586648754425Candy.png', 'Candy', 8, 500, 'TICKY PACK', 3),
(10, 15, '2020-04-11', NULL, 'http://localhost:8080/api/products/image/Biscuits/Candy/1586648834492Candy.png', 'Candy', 20, 350, 'HALF ROLL', 3),
(11, 8, '2020-04-11', NULL, 'http://localhost:8080/api/products/image/Biscuits/Prince/1586648859244Prince.png', 'Prince', 10, 400, 'TICKY PACK', 3),
(12, 20, '2020-04-11', NULL, 'http://localhost:8080/api/products/image/Biscuits/Prince/1586648894412Prince.png', 'Prince', 25, 180, 'HALF ROLL', 3),
(13, 1, '2020-04-14', NULL, 'http://localhost:8080/api/products/image/Candies/Eclairs/1586876111382Eclairs.png', 'Eclairs', 2, 500, 'SINGLE', 5),
(14, 80, '2020-04-14', NULL, 'http://localhost:8080/api/products/image/Candies/Eclairs/1586876518633Eclairs.png', 'Eclairs', 100, 50, 'FAMILY PACK', 5),
(15, 1, '2020-04-14', NULL, 'http://localhost:8080/api/products/image/Candies/Fanta/1586876595758Fanta.png', 'Fanta', 2, 600, 'SINGLE', 5),
(16, 40, '2020-04-14', NULL, 'http://localhost:8080/api/products/image/Candies/Fanta/1586876649018Fanta.png', 'Fanta', 60, 80, 'FAMILY PACK', 5),
(17, 450, '2020-04-14', NULL, 'http://localhost:8080/api/products/image/Cakes/Chocolate Cake/1586877070311Chocolate Cake.png', 'Chocolate Cake', 600, 5, '1 POUND', 4),
(18, 450, '2020-04-14', NULL, 'http://localhost:8080/api/products/image/Cakes/Coffee Cake/1586877243350Coffee Cake.png', 'Coffee Cake', 600, 15, '1 POUND', 4);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
