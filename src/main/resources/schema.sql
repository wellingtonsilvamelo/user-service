-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 30/09/2019 às 11:00
-- Versão do servidor: 8.0.17
-- Versão do PHP: 7.2.19-0ubuntu0.18.04.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `tomwel`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- --------------------------------------------------------

--
-- Estrutura para tabela `tbg_authority`
--

CREATE TABLE `tbg_authority` (
  `authority_id` bigint(20) NOT NULL,
  `authority_description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- --------------------------------------------------------

--
-- Estrutura para tabela `tbg_user`
--

CREATE TABLE `tbg_user` (
  `user_id` bigint(20) NOT NULL,
  `user_email` varchar(70) NOT NULL,
  `user_full_name` varchar(100) NOT NULL,
  `user_hash_password` varchar(255) DEFAULT NULL,
  `username` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- --------------------------------------------------------

--
-- Estrutura para tabela `tbg_user_authority`
--

CREATE TABLE `tbg_user_authority` (
  `user_authority_id` bigint(20) NOT NULL,
  `authority_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `tbg_authority`
--
ALTER TABLE `tbg_authority`
  ADD PRIMARY KEY (`authority_id`);

--
-- Índices de tabela `tbg_user`
--
ALTER TABLE `tbg_user`
  ADD PRIMARY KEY (`user_id`);

--
-- Índices de tabela `tbg_user_authority`
--
ALTER TABLE `tbg_user_authority`
  ADD PRIMARY KEY (`user_authority_id`),
  ADD KEY `FK77ob2m0ibn084kovmuwne0ms0` (`authority_id`),
  ADD KEY `FK2qyjhgtpdce7r8b8xankrchcm` (`user_id`);

--
-- Restrições para dumps de tabelas
--

--
-- Restrições para tabelas `tbg_user_authority`
--
ALTER TABLE `tbg_user_authority`
  ADD CONSTRAINT `FK2qyjhgtpdce7r8b8xankrchcm` FOREIGN KEY (`user_id`) REFERENCES `tbg_user` (`user_id`),
  ADD CONSTRAINT `FK77ob2m0ibn084kovmuwne0ms0` FOREIGN KEY (`authority_id`) REFERENCES `tbg_authority` (`authority_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

