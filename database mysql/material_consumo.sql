-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 23-Fev-2021 às 13:57
-- Versão do servidor: 5.6.21
-- PHP Version: 5.5.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `material_consumo`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `materiais`
--

CREATE TABLE IF NOT EXISTS `materiais` (
`id` int(11) NOT NULL,
  `codigo` text NOT NULL,
  `tipo` text NOT NULL,
  `subtipo` text NOT NULL,
  `descricao` text NOT NULL,
  `qtd` text NOT NULL,
  `data` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `materiais`
--

INSERT INTO `materiais` (`id`, `codigo`, `tipo`, `subtipo`, `descricao`, `qtd`, `data`) VALUES
(0, '051000012517', '', '', '', '', ''),
(3, '123456', 'jdhdjdj', 'hdhdh', 'hdhdh', 'hfhfh', 'hdhdh'),
(4, '01234565', 'udbebdidj', 'ixudjh3', 'hdhdhu', 'hdhdu', 'hdhdh'),
(5, '7898482632238', 'escritorii', 'bloco de anotaÃ§Ãµes', 'cola facil', '2', '15fev21'),
(6, '0123456789012', 'stkstkstk', 'katkaw5i', 'arjaratk', 'sfjarja', 'Fnarj'),
(7, '123456789012', 'stujatja', 'w4uwtjatj', 'sfjarjtaj', 'stjatkqj', 'znFjrja');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `materiais`
--
ALTER TABLE `materiais`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `materiais`
--
ALTER TABLE `materiais`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
