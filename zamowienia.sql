-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Czas generowania: 07 Mar 2018, 13:38
-- Wersja serwera: 10.1.30-MariaDB
-- Wersja PHP: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `zamowienia`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `kategoria_produktu`
--

CREATE TABLE `kategoria_produktu` (
  `id` int(11) NOT NULL,
  `nazwa` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `kategoria_produktu`
--

INSERT INTO `kategoria_produktu` (`id`, `nazwa`) VALUES
(1, 'Warzywo'),
(2, 'Owoc'),
(3, 'Napoj'),
(4, 'Pieczywo'),
(5, 'Nabial');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `klient`
--

CREATE TABLE `klient` (
  `id` int(11) NOT NULL,
  `imie` varchar(20) DEFAULT NULL,
  `nazwisko` varchar(30) DEFAULT NULL,
  `telefon` int(15) DEFAULT NULL,
  `rabat_Klienta` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `klient`
--

INSERT INTO `klient` (`id`, `imie`, `nazwisko`, `telefon`, `rabat_Klienta`) VALUES
(1, 'Mikolaj', 'Haham', 42141241, 0),
(2, 'Monika', 'Mahaha', 12351641, 10);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `produkt`
--

CREATE TABLE `produkt` (
  `id` int(11) NOT NULL,
  `nazwa` varchar(100) NOT NULL,
  `cena` varchar(50) DEFAULT NULL,
  `stan_Ilosci` int(11) NOT NULL,
  `rabat` varchar(5) DEFAULT NULL,
  `id_Kategori` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `produkt`
--

INSERT INTO `produkt` (`id`, `nazwa`, `cena`, `stan_Ilosci`, `rabat`, `id_Kategori`) VALUES
(1, 'Chleb krojony', '2', 10, '0', 4),
(2, 'Chleb ca?y', '3.5', 5, '0', 4),
(3, 'Bu?ka', '0.5', 25, '0', 4),
(4, 'Marchew', '0.7', 10, '0', 1),
(5, 'Pomidor', '6.8', 10, '0', 1),
(6, 'Ogórek', '7.5', 7, '0', 1),
(7, 'Mandarynka', '6.8', 10, '0', 2),
(8, 'Truskawka', '11.5', 12, '0', 2),
(9, 'Gruszka', '4.5', 10, '0', 2),
(10, 'Cola 1L', '3', 12, '0', 3),
(11, 'Woda 1L', '1.2', 18, '0', 3),
(12, 'Sok Mi?towy 1L', '1.5', 6, '0', 3),
(13, 'Ser bia?y', '3', 10, '0', 5),
(14, 'Mas?o', '5.5', 5, '0', 5),
(15, '?mietana 12%', '2.5', 25, '5', 5);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `produkty_zamowienia`
--

CREATE TABLE `produkty_zamowienia` (
  `id_Zamowienia` int(50) NOT NULL,
  `id_Produktu` int(50) NOT NULL,
  `ilosc` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `produkty_zamowienia`
--

INSERT INTO `produkty_zamowienia` (`id_Zamowienia`, `id_Produktu`, `ilosc`) VALUES
(1, 3, 2),
(1, 1, 2),
(1, 11, 1),
(2, 3, 10),
(2, 6, 3);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `zamowienia`
--

CREATE TABLE `zamowienia` (
  `id` int(11) NOT NULL,
  `id_Klienta` int(11) NOT NULL,
  `rabat_zamowienia` int(11) NOT NULL,
  `koszt_Totalny` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `zamowienia`
--

INSERT INTO `zamowienia` (`id`, `id_Klienta`, `rabat_zamowienia`, `koszt_Totalny`) VALUES
(1, 1, 5, '0'),
(2, 2, 0, '0');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `kategoria_produktu`
--
ALTER TABLE `kategoria_produktu`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `klient`
--
ALTER TABLE `klient`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `produkt`
--
ALTER TABLE `produkt`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `zamowienia`
--
ALTER TABLE `zamowienia`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
