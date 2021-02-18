-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 18-Fev-2021 às 04:46
-- Versão do servidor: 10.4.17-MariaDB
-- versão do PHP: 7.4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `twjbd`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `categoria`
--

CREATE TABLE `categoria` (
  `categoriaID` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `categoria`
--

INSERT INTO `categoria` (`categoriaID`, `nome`) VALUES
(1, 'Tudo'),
(2, 'Informatica'),
(3, 'Livros'),
(4, 'Moda'),
(5, 'Infantil');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `clienteID` int(11) NOT NULL,
  `nome` varchar(500) NOT NULL,
  `email` varchar(200) NOT NULL,
  `senha` varchar(200) NOT NULL,
  `enderecoID` int(11) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `carrinho` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`clienteID`, `nome`, `email`, `senha`, `enderecoID`, `telefone`, `carrinho`) VALUES
(3, 'joao Batista', 'joao@bb.com', 'admin123', 7, '85987627229', NULL),
(4, 'joao Batista', 'joao@bb.com', 'admin123', 8, '85987627229', NULL),
(9, 'joao Batista', 'joao@bb.com', 'admin123', 13, '999999999', NULL),
(10, 'joao Batista', 'joao@bb.com', 'admin123', 14, '999999999', NULL),
(11, 'joao Batista', 'joao@bb.com', 'admin123', 15, '999999999', NULL),
(12, 'joao Batista', 'joao@bb.com', 'admin123', 16, '999999999', NULL),
(13, 'joao Batista', 'joao@bb.com', 'admin123', 17, '999999999', NULL),
(14, 'joao Batista', 'joao@bb.com', 'admin123', 18, '999999999', NULL),
(15, 'joao Batista', 'joao@bb.com', 'admin123', 19, '999999999', NULL),
(16, 'joao Batista', 'joao@bb.com', 'admin123', 20, '999999999', NULL),
(17, 'joao Batista', 'joao@bb.com', 'admin123', 21, '999999999', NULL),
(19, 'joao Batista', 'joao@bb.com', 'admin123', 23, '999999999', NULL),
(20, 'joao Batista', 'joao@bb.com', 'admin123', 24, '999999999', NULL),
(21, 'joao Batista', 'joao@bb.com', 'admin123', 25, '999999999', NULL),
(22, 'joao Batista', 'joao@bb.com', 'admin123', 26, '999999999', NULL),
(23, 'joao Batista', 'joao@bb.com', 'admin123', 27, '999999999', NULL),
(24, 'joao Batista', 'joao@bb.com', 'admin123', 28, '999999999', NULL),
(26, 'joao Batista', 'joao@bb.com', 'admin123', 30, '999999999', NULL),
(27, 'juca', 'ju', 'uu', 32, 'uu', NULL),
(28, 'juca tatu', 'juca@bb.com', '124578', 34, '85987545215', NULL),
(29, 'jessica', 'jessy', '121212', 35, '125478875', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE `endereco` (
  `enderecoID` int(11) NOT NULL,
  `rua` text NOT NULL,
  `bairro` varchar(200) NOT NULL,
  `cidade` varchar(200) NOT NULL,
  `estado` varchar(50) NOT NULL,
  `cep` int(11) NOT NULL,
  `pais` varchar(200) NOT NULL,
  `numero` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`enderecoID`, `rua`, `bairro`, `cidade`, `estado`, `cep`, `pais`, `numero`) VALUES
(4, 'rua pupunha', 'Serrinha', 'Fortaleza', 'Ceará', 60714305, 'Brasil', '125b'),
(5, 'rua pupunha', 'Serrinha', 'Fortaleza', 'Ceará', 60714305, 'Brasil', '125b'),
(6, 'rua pupunha', 'Serrinha', 'Fortaleza', 'Ceará', 60714305, 'Brasil', '125b'),
(7, 'rua pupunha', 'Serrinha', 'Fortaleza', 'Ceará', 60714305, 'Brasil', '125b'),
(8, 'rua pupunha', 'Serrinha', 'Fortaleza', 'Ceará', 60714305, 'Brasil', '125b'),
(9, 'rua pupunha', 'Serrinha', 'Fortaleza', 'Ceará', 60714305, 'Brasil', '125b'),
(10, 'rua pupunha', 'Serrinha', 'Fortaleza', 'Ceará', 60714305, 'Brasil', '125b'),
(11, 'rua pupunha', 'Serrinha', 'Fortaleza', 'Ceará', 60714305, 'Brasil', '125b'),
(12, 'rua pupunha', 'Itaperi', 'Fortaleza', 'Ceará', 60714305, 'Brasil', '125b'),
(13, 'rua pupunha', 'Itaperi', 'Fortaleza', 'Ceará', 60714305, 'Brasil', '125b'),
(14, 'rua pupunha', 'Itaperi', 'Fortaleza', 'Ceará', 60714305, 'Brasil', '125b'),
(15, 'rua pupunha', 'Itaperi', 'Fortaleza', 'Ceará', 60714305, 'Brasil', '125b'),
(16, 'rua pupunha', 'Itaperi', 'Fortaleza', 'Ceará', 60714305, 'Brasil', '125b'),
(17, 'rua pupunha', 'Itaperi', 'Fortaleza', 'Ceará', 60714305, 'Brasil', '125b'),
(18, 'rua pupunha', 'Itaperi', 'Fortaleza', 'Ceará', 60714305, 'Brasil', '125b'),
(19, 'rua pupunha', 'Itaperi', 'Fortaleza', 'Ceará', 60714305, 'Brasil', '125b'),
(20, 'rua pupunha', 'Itaperi', 'Fortaleza', 'Ceará', 60714305, 'Brasil', '125b'),
(21, 'rua pupunha', 'Itaperi', 'Fortaleza', 'Ceará', 60714305, 'Brasil', '125b'),
(23, 'rua pupunha', 'Itaperi', 'Fortaleza', 'Ceará', 60714305, 'Brasil', '125b'),
(24, 'rua pupunha', 'Itaperi', 'Fortaleza', 'Ceará', 60714305, 'Brasil', '125b'),
(25, 'rua pupunha', 'Itaperi', 'Fortaleza', 'Ceará', 60714305, 'Brasil', '125b'),
(26, 'rua pupunha', 'Itaperi', 'Fortaleza', 'Ceará', 60714305, 'Brasil', '125b'),
(27, 'rua pupunha', 'Itaperi', 'Fortaleza', 'Ceará', 60714305, 'Brasil', '125b'),
(28, 'rua pupunha', 'Itaperi', 'Fortaleza', 'Ceará', 60714305, 'Brasil', '125b'),
(29, 'rua caramuru', 'Castel?o', 'Fortaleza', 'Ceará', 0, 'Brasil', 'tdgete'),
(30, 'rua pupunha', 'Itaperi', 'Fortaleza', 'Ceará', 60714305, 'Brasil', '125b'),
(31, 'rua pupunha', 'itaperi', 'fortaleza', 'cear??', 60714305, 'brasil', '303'),
(32, 'ldnjkl', 'jh', 'jk', 'hjk', 0, 'jk', 'jk'),
(33, 'deqw', 'wqe', 'ewqe', 'ewqe', 9989, 'wq', 'ew'),
(34, 'rua caramuru', 'itaperi', 'fortaaleza', 'cear??', 60714305, 'brasil', '303'),
(35, 'ruca', 'jkhjkh', 'kjhjk', 'jkhjk', 65, 'kjhjk', 'jkhjk');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `produtoID` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `preco` float NOT NULL,
  `categoriaID` int(11) NOT NULL,
  `descricao` text NOT NULL,
  `urlImage` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`produtoID`, `nome`, `preco`, `categoriaID`, `descricao`, `urlImage`) VALUES
(3, 'Monitor Samsung', 788.99, 1, 'Ultrarrápido e cheio de recursos conheça o novo samsung gaming monitor que chegou para melhorar a sua performance para as próximas conquistas. Com o tempo de resposta de 1ms ultrarrápido é excelente para games de ação que exigem reflexos rápidos e precisos. Prepare-se para momentos eletrizantes.', '/image/samsung.jpg');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`categoriaID`);

--
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`clienteID`),
  ADD KEY `enderecoIDFK` (`enderecoID`);

--
-- Índices para tabela `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`enderecoID`);

--
-- Índices para tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`produtoID`),
  ADD KEY `categoriaIDFK` (`categoriaID`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `categoria`
--
ALTER TABLE `categoria`
  MODIFY `categoriaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `clienteID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT de tabela `endereco`
--
ALTER TABLE `endereco`
  MODIFY `enderecoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `produtoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `enderecoIDFK` FOREIGN KEY (`enderecoID`) REFERENCES `endereco` (`enderecoID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `produto`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `categoriaIDFK` FOREIGN KEY (`categoriaID`) REFERENCES `categoria` (`categoriaID`) ON DELETE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
