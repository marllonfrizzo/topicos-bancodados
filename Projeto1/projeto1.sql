-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 15/04/2018 às 20:34
-- Versão do servidor: 10.1.31-MariaDB
-- Versão do PHP: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `projeto1`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `cadCliente`
--

CREATE TABLE `cadCliente` (
  `qtdeCompras` int(11) NOT NULL,
  `valorComprado` double DEFAULT NULL,
  `id` int(11) NOT NULL,
  `venda_idVenda` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `cadCliente`
--

INSERT INTO `cadCliente` (`qtdeCompras`, `valorComprado`, `id`, `venda_idVenda`) VALUES
(15, 13.2, 1, 1),
(100, 1000.1, 2, 2),
(2, 2.5, 3, 3);

-- --------------------------------------------------------

--
-- Estrutura para tabela `cadVenda`
--

CREATE TABLE `cadVenda` (
  `idVenda` int(11) NOT NULL,
  `quantidadeItems` int(11) DEFAULT NULL,
  `valorTotal` double DEFAULT NULL,
  `vendedor_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `cadVenda`
--

INSERT INTO `cadVenda` (`idVenda`, `quantidadeItems`, `valorTotal`, `vendedor_id`) VALUES
(1, 10, 250.5, 4),
(2, 100, 78.78, 5),
(3, 30, 30.1, 6);

-- --------------------------------------------------------

--
-- Estrutura para tabela `cadVendedor`
--

CREATE TABLE `cadVendedor` (
  `idVendedor` int(11) DEFAULT NULL,
  `quantidadeVendas` int(11) DEFAULT NULL,
  `valorVendas` double DEFAULT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `cadVendedor`
--

INSERT INTO `cadVendedor` (`idVendedor`, `quantidadeVendas`, `valorVendas`, `id`) VALUES
(1, 100, 150, 4),
(2, 200, 250, 5),
(3, 300, 350, 6);

-- --------------------------------------------------------

--
-- Estrutura para tabela `Pessoa`
--

CREATE TABLE `Pessoa` (
  `id` int(11) NOT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `Pessoa`
--

INSERT INTO `Pessoa` (`id`, `cpf`, `nome`) VALUES
(1, '123.123.123-12', 'Marllon'),
(2, '789.789.789-78', 'Bruna'),
(3, '321.321.321-32', 'José'),
(4, '123.123.123-12', 'Vendedor 1'),
(5, '321.321.321-32', 'Vendedor 2'),
(6, '999.321.321-32', 'Vendedor 3');

-- --------------------------------------------------------

--
-- Estrutura para tabela `Telefone`
--

CREATE TABLE `Telefone` (
  `id` int(11) NOT NULL,
  `DDD` int(11) NOT NULL,
  `numero` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `Telefone`
--

INSERT INTO `Telefone` (`id`, `DDD`, `numero`) VALUES
(1, 44, '99920-2425'),
(2, 44, '88888-2323'),
(3, 44, '99999-9999');

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `cadCliente`
--
ALTER TABLE `cadCliente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_gfvbnubol1s92ypg5aqad66uc` (`venda_idVenda`);

--
-- Índices de tabela `cadVenda`
--
ALTER TABLE `cadVenda`
  ADD PRIMARY KEY (`idVenda`),
  ADD KEY `FK_hb509dhgp32xnmxjw0das9kki` (`vendedor_id`);

--
-- Índices de tabela `cadVendedor`
--
ALTER TABLE `cadVendedor`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `Pessoa`
--
ALTER TABLE `Pessoa`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `Telefone`
--
ALTER TABLE `Telefone`
  ADD PRIMARY KEY (`id`,`DDD`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `cadVenda`
--
ALTER TABLE `cadVenda`
  MODIFY `idVenda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `Pessoa`
--
ALTER TABLE `Pessoa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restrições para dumps de tabelas
--

--
-- Restrições para tabelas `cadCliente`
--
ALTER TABLE `cadCliente`
  ADD CONSTRAINT `FK_gfvbnubol1s92ypg5aqad66uc` FOREIGN KEY (`venda_idVenda`) REFERENCES `cadVenda` (`idVenda`),
  ADD CONSTRAINT `FK_svkyup7yjiwy2xc480864y7i5` FOREIGN KEY (`id`) REFERENCES `Pessoa` (`id`);

--
-- Restrições para tabelas `cadVenda`
--
ALTER TABLE `cadVenda`
  ADD CONSTRAINT `FK_hb509dhgp32xnmxjw0das9kki` FOREIGN KEY (`vendedor_id`) REFERENCES `cadVendedor` (`id`);

--
-- Restrições para tabelas `cadVendedor`
--
ALTER TABLE `cadVendedor`
  ADD CONSTRAINT `FK_3gkvhal9b7ffb4tlqk3d3lnh4` FOREIGN KEY (`id`) REFERENCES `Pessoa` (`id`);

--
-- Restrições para tabelas `Telefone`
--
ALTER TABLE `Telefone`
  ADD CONSTRAINT `FK_eppupgvhlehxi9fp70uit3jfn` FOREIGN KEY (`id`) REFERENCES `cadCliente` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
