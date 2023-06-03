-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-06-2023 a las 15:37:31
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdferreteria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `almacen`
--

CREATE TABLE `almacen` (
  `id_almacen` int(11) NOT NULL,
  `id_articulo` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `precio_unitario` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_general_ci;

--
-- Volcado de datos para la tabla `almacen`
--

INSERT INTO `almacen` (`id_almacen`, `id_articulo`, `stock`, `precio_unitario`) VALUES
(1, 1, 12, 1.12),
(2, 2, 54, 23.112),
(3, 3, 20, 2.3),
(4, 4, -10, 20.4),
(5, 2, 45, 20),
(6, 6, -559, 20),
(7, 8, -14, 30.01),
(8, 5, 45, 23),
(10, 7, -449, 85),
(11, 10, 8, 9),
(12, 11, -3, 89),
(14, 6, -598, 12),
(15, 3, 4, 4),
(16, 5, 6, 12),
(17, 7, -450, 8),
(18, 9, 1, 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulo`
--

CREATE TABLE `articulo` (
  `id_articulo` int(11) NOT NULL,
  `Nombre` varchar(200) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `id_categoria` int(11) NOT NULL,
  `id_marca` int(11) NOT NULL,
  `cod_eliminado` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_general_ci;

--
-- Volcado de datos para la tabla `articulo`
--

INSERT INTO `articulo` (`id_articulo`, `Nombre`, `descripcion`, `id_categoria`, `id_marca`, `cod_eliminado`) VALUES
(1, 'prueba1', 'prueba1', 1, 1, 0),
(2, 'prueba2', 'prueba2', 1, 2, 1),
(3, 'Art?culo 3', 'Descripci?n del art?culo 3', 1, 1, 1),
(4, 'Art?culo 4', 'Descripci?n del art?culo 4', 1, 1, 0),
(5, 'Art?culo 5', 'Descripci?n del art?culo 5', 1, 1, 0),
(6, 'Art?culo 6', 'Descripci?n del art?culo 6', 1, 1, 0),
(7, 'Art?culo 7', 'Descripci?n del art?culo 7', 1, 1, 0),
(8, 'Art?culo 8', 'Descripci?n del art?culo 8', 1, 1, 0),
(9, 'Art?culo 9', 'Descripci?n del art?culo 9', 1, 1, 0),
(10, 'Art?culo 10', 'Descripci?n del art?culo 10', 1, 1, 0),
(11, 'Art?culo 11', 'Descripci?n del art?culo 11', 1, 1, 0),
(12, 'Art?culo 12', 'Descripci?n del art?culo 12', 1, 1, 0),
(13, 'Art?culo 13', 'Descripci?n del art?culo 13', 1, 1, 0),
(14, 'articulonuevo', 'descripcion de articulo nuevo', 2, 2, 1),
(15, 'Articulo9888', 'Articulo ingresado por compra', 3, 7, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id_categoria` int(11) NOT NULL,
  `Nombre` varchar(200) NOT NULL,
  `cod_eliminado` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_general_ci;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id_categoria`, `Nombre`, `cod_eliminado`) VALUES
(1, 'prueba 43', 0),
(2, 'prueba 3', 0),
(3, 'prueba1', 0),
(4, 'prueba 20', 0),
(6, 'prueba 45', 0),
(7, 'martillo', 1),
(8, 'prueba no', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE `compra` (
  `id_compra` int(11) NOT NULL,
  `id_proveedor` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `Fecha_compra` date NOT NULL,
  `Total` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_general_ci;

--
-- Volcado de datos para la tabla `compra`
--

INSERT INTO `compra` (`id_compra`, `id_proveedor`, `id_usuario`, `Fecha_compra`, `Total`) VALUES
(1, 5, 4, '2023-05-02', 100.1),
(2, 4, 4, '2023-05-01', 123.123),
(5, 5, 2, '2023-05-30', 155.24),
(6, 4, 2, '2023-05-30', 144.46),
(7, 4, 2, '2023-05-30', 123.12),
(8, 4, 2, '2023-05-30', 123.12),
(9, 4, 2, '2023-05-30', 123.12),
(10, 7, 5, '2023-06-02', 4082.34),
(11, 4, 5, '2023-06-02', 1340);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `det_compra_articulos`
--

CREATE TABLE `det_compra_articulos` (
  `id_det_compra` int(11) NOT NULL,
  `id_compra` int(11) NOT NULL,
  `id_articulo` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio_subtotal` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_general_ci;

--
-- Volcado de datos para la tabla `det_compra_articulos`
--

INSERT INTO `det_compra_articulos` (`id_det_compra`, `id_compra`, `id_articulo`, `cantidad`, `precio_subtotal`) VALUES
(1, 1, 1, 12, 123.123),
(2, 1, 2, 50, 123.123),
(3, 2, 2, 80, 152.123),
(4, 2, 2, 100, 632.154),
(5, 8, 1, 12, 123.12),
(6, 9, 1, 12, 123.12),
(7, 11, 5, 23, 456),
(8, 11, 4, 12, 454),
(9, 11, 7, 36, 132),
(10, 11, 6, 456, 175),
(11, 11, 8, 45, 123);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `det_venta_articulos`
--

CREATE TABLE `det_venta_articulos` (
  `id_det_venta` int(11) NOT NULL,
  `id_venta` int(11) NOT NULL,
  `id_articulo` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio_subtotal` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_general_ci;

--
-- Volcado de datos para la tabla `det_venta_articulos`
--

INSERT INTO `det_venta_articulos` (`id_det_venta`, `id_venta`, `id_articulo`, `cantidad`, `precio_subtotal`) VALUES
(10, 12, 1, 1, 1.12),
(11, 12, 1, 2, 2.24),
(12, 13, 1, 1, 1.12),
(13, 13, 2, 2, 46.22),
(14, 15, 4, 5, 102),
(15, 15, 6, 4, 80),
(16, 15, 8, 6, 180.06),
(17, 15, 11, 8, 712),
(18, 15, 9, 5, 45),
(19, 16, 4, 50, 1020),
(20, 16, 8, 20, 600.2),
(21, 17, 6, 544, 10880),
(22, 17, 7, 456, 38760),
(23, 18, 6, 56, 1120);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marca`
--

CREATE TABLE `marca` (
  `id_marca` int(11) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `cod_eliminado` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_general_ci;

--
-- Volcado de datos para la tabla `marca`
--

INSERT INTO `marca` (`id_marca`, `nombre`, `cod_eliminado`) VALUES
(1, 'Primor', 0),
(2, 'prueba', 1),
(3, 'prueba 2', 1),
(4, 'prueba1', 1),
(6, 'Nastisol', 1),
(7, 'Herrera', 0),
(8, 'Margarita', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `id_proveedor` int(11) NOT NULL,
  `Nombre_pro` varchar(250) NOT NULL,
  `RUC` varchar(11) NOT NULL,
  `Telefono` int(11) NOT NULL,
  `Direccion` varchar(200) NOT NULL,
  `cod_eliminado` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_general_ci;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`id_proveedor`, `Nombre_pro`, `RUC`, `Telefono`, `Direccion`, `cod_eliminado`) VALUES
(3, 'prueba1', '1233', 321, 'prueba1', 1),
(4, 'prueba2', '321', 1234242, 'direc2', 0),
(5, 'pedro', '324', 324213, 'casa de pedro a', 0),
(6, 'juan', '5432', 123, 'casa de juan no', 0),
(7, 'pv1', '54865', 123456789, 'AvLima 45', 0),
(8, 'pv2', '12345678968', 125836942, 'Av Lima 456', 1),
(9, 'proveedor123', '25836914756', 568923369, 'Av Lima231', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `Usuario` varchar(100) NOT NULL,
  `contraseña` varchar(100) NOT NULL,
  `rol` enum('EmpleadoVentas','EmpleadoCompras','EmpleadoAlmacen','Supervisor') NOT NULL DEFAULT 'Supervisor',
  `cod_eliminado` int(11) NOT NULL DEFAULT 0,
  `cantidad_venta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombre`, `Usuario`, `contraseña`, `rol`, `cod_eliminado`, `cantidad_venta`) VALUES
(2, 'juan', 'admin', 'admin', 'Supervisor', 0, 0),
(3, 'jorge', 'koki28', 'koki', 'Supervisor', 0, 0),
(4, 'mote', 'mote', 'mote', 'EmpleadoVentas', 0, 0),
(5, 'Roberto', 'robert123', '123', 'EmpleadoCompras', 0, 0),
(6, 'yo', 'yo', '123', 'EmpleadoVentas', 0, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `id_venta` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `DNI_cliente` int(11) NOT NULL,
  `Nombre_cliente` varchar(100) NOT NULL,
  `metodo_pago` enum('Tarjeta','Efectivo','Otros') NOT NULL,
  `fecha_venta` date NOT NULL,
  `Total` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_general_ci;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`id_venta`, `id_usuario`, `DNI_cliente`, `Nombre_cliente`, `metodo_pago`, `fecha_venta`, `Total`) VALUES
(8, 3, 123, 'asdasd', 'Efectivo', '2023-05-09', 123.413),
(9, 4, 1231, 'asdasdas', 'Tarjeta', '2023-05-10', 12312.1),
(10, 2, 2132, 'qweasd', 'Tarjeta', '2023-05-30', 3.36),
(11, 2, 21312, 'wqesda', 'Efectivo', '2023-05-30', 23.11),
(12, 2, 1231, 'asdasd', 'Tarjeta', '2023-05-30', 3.36),
(13, 2, 32131, 'asdasd', 'Efectivo', '2023-05-30', 1.12),
(14, 6, 45678925, 'cliente41', 'Efectivo', '2023-06-02', 1013.07),
(15, 6, 12345678, 'asd', 'Tarjeta', '2023-06-02', 1119.06),
(16, 6, 789, 'asd', 'Tarjeta', '2023-06-02', 1620.2),
(17, 6, 4562, 'asdfsdf', 'Tarjeta', '2023-06-02', 49640),
(18, 6, 54678, 'dfg', 'Tarjeta', '2023-06-02', 1120);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `almacen`
--
ALTER TABLE `almacen`
  ADD PRIMARY KEY (`id_almacen`),
  ADD KEY `id_articulo` (`id_articulo`);

--
-- Indices de la tabla `articulo`
--
ALTER TABLE `articulo`
  ADD PRIMARY KEY (`id_articulo`),
  ADD UNIQUE KEY `Nombre` (`Nombre`),
  ADD KEY `id_categoria` (`id_categoria`),
  ADD KEY `id_marca` (`id_marca`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id_categoria`),
  ADD UNIQUE KEY `Nombre` (`Nombre`);

--
-- Indices de la tabla `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`id_compra`),
  ADD KEY `id_proveedor` (`id_proveedor`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `det_compra_articulos`
--
ALTER TABLE `det_compra_articulos`
  ADD PRIMARY KEY (`id_det_compra`),
  ADD KEY `id_compra` (`id_compra`),
  ADD KEY `id_articulo` (`id_articulo`);

--
-- Indices de la tabla `det_venta_articulos`
--
ALTER TABLE `det_venta_articulos`
  ADD PRIMARY KEY (`id_det_venta`),
  ADD KEY `id_venta` (`id_venta`),
  ADD KEY `id_articulo` (`id_articulo`);

--
-- Indices de la tabla `marca`
--
ALTER TABLE `marca`
  ADD PRIMARY KEY (`id_marca`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`id_proveedor`),
  ADD UNIQUE KEY `Nombre_pro` (`Nombre_pro`),
  ADD UNIQUE KEY `RUC` (`RUC`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `Usuario` (`Usuario`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`id_venta`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `almacen`
--
ALTER TABLE `almacen`
  MODIFY `id_almacen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `articulo`
--
ALTER TABLE `articulo`
  MODIFY `id_articulo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `compra`
--
ALTER TABLE `compra`
  MODIFY `id_compra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `det_compra_articulos`
--
ALTER TABLE `det_compra_articulos`
  MODIFY `id_det_compra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `det_venta_articulos`
--
ALTER TABLE `det_venta_articulos`
  MODIFY `id_det_venta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `marca`
--
ALTER TABLE `marca`
  MODIFY `id_marca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `id_proveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `id_venta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `almacen`
--
ALTER TABLE `almacen`
  ADD CONSTRAINT `almacen_ibfk_1` FOREIGN KEY (`id_articulo`) REFERENCES `articulo` (`id_articulo`);

--
-- Filtros para la tabla `articulo`
--
ALTER TABLE `articulo`
  ADD CONSTRAINT `articulo_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`),
  ADD CONSTRAINT `articulo_ibfk_2` FOREIGN KEY (`id_marca`) REFERENCES `marca` (`id_marca`);

--
-- Filtros para la tabla `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id_proveedor`),
  ADD CONSTRAINT `compra_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `det_compra_articulos`
--
ALTER TABLE `det_compra_articulos`
  ADD CONSTRAINT `det_compra_articulos_ibfk_1` FOREIGN KEY (`id_compra`) REFERENCES `compra` (`id_compra`),
  ADD CONSTRAINT `det_compra_articulos_ibfk_2` FOREIGN KEY (`id_articulo`) REFERENCES `articulo` (`id_articulo`);

--
-- Filtros para la tabla `det_venta_articulos`
--
ALTER TABLE `det_venta_articulos`
  ADD CONSTRAINT `det_venta_articulos_ibfk_1` FOREIGN KEY (`id_venta`) REFERENCES `venta` (`id_venta`),
  ADD CONSTRAINT `det_venta_articulos_ibfk_2` FOREIGN KEY (`id_articulo`) REFERENCES `articulo` (`id_articulo`);

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
