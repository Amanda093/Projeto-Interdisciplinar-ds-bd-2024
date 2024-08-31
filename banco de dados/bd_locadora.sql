-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 29-Ago-2024 às 19:44
-- Versão do servidor: 10.4.22-MariaDB
-- versão do PHP: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `bd_locadora`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `CodCliente` int(11) NOT NULL,
  `Nome` varchar(35) NOT NULL,
  `Telefone` varchar(9) NOT NULL,
  `Endereco` varchar(80) NOT NULL,
  `RG` int(11) NOT NULL,
  `CPF` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor`
--

CREATE TABLE `fornecedor` (
  `CodFornecedor` int(11) NOT NULL,
  `Nome` varchar(35) NOT NULL,
  `CNPJ` int(11) NOT NULL,
  `Telefone` varchar(9) NOT NULL,
  `Endereco` varchar(80) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `CodFuncionario` int(11) NOT NULL,
  `Nome` varchar(35) NOT NULL,
  `Salario` double NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Telefone` varchar(9) NOT NULL,
  `RG` int(11) NOT NULL,
  `CPF` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `CodProduto` int(11) NOT NULL,
  `Nome` varchar(35) NOT NULL,
  `Preco` double NOT NULL,
  `CodTipoProd` int(11) NOT NULL,
  `CodFornecedor` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `reserva`
--

CREATE TABLE `reserva` (
  `CodReserva` int(11) NOT NULL,
  `DataInicial` date NOT NULL,
  `DataFinal` date NOT NULL,
  `CodTipoReserva` int(11) NOT NULL,
  `CodCliente` int(11) NOT NULL,
  `CodFuncionario` int(11) NOT NULL,
  `CodProduto` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipo_produto`
--

CREATE TABLE `tipo_produto` (
  `CodTipoProd` int(11) NOT NULL,
  `Descricao` varchar(25) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipo_reserva`
--

CREATE TABLE `tipo_reserva` (
  `CodTipoReserva` int(11) NOT NULL,
  `Descricao` varchar(25) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`CodCliente`);

--
-- Índices para tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`CodFornecedor`);

--
-- Índices para tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`CodFuncionario`);

--
-- Índices para tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`CodProduto`);

--
-- Índices para tabela `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`CodReserva`);

--
-- Índices para tabela `tipo_produto`
--
ALTER TABLE `tipo_produto`
  ADD PRIMARY KEY (`CodTipoProd`);

--
-- Índices para tabela `tipo_reserva`
--
ALTER TABLE `tipo_reserva`
  ADD PRIMARY KEY (`CodTipoReserva`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `CodCliente` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  MODIFY `CodFornecedor` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `CodFuncionario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `CodProduto` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `reserva`
--
ALTER TABLE `reserva`
  MODIFY `CodReserva` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tipo_produto`
--
ALTER TABLE `tipo_produto`
  MODIFY `CodTipoProd` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tipo_reserva`
--
ALTER TABLE `tipo_reserva`
  MODIFY `CodTipoReserva` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
