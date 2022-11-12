-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Zolochevskyi
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Zolochevskyi
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Zolochevskyi` DEFAULT CHARACTER SET utf8 ;
USE `Zolochevskyi` ;

-- -----------------------------------------------------
-- Table `Zolochevskyi`.`shop`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Zolochevskyi`.`shop` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `country` VARCHAR(20) NOT NULL,
  `city` VARCHAR(20) NOT NULL,
  `adress` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Zolochevskyi`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Zolochevskyi`.`customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Zolochevskyi`.`delivery`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Zolochevskyi`.`delivery` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ordered_time` DATETIME NOT NULL,
  `arrival` TIME NULL,
  `urgency_price` DECIMAL(5,2) NULL,
  `customer_id` INT NOT NULL,
  PRIMARY KEY (`id`, `customer_id`),
  INDEX `fk_delivery_customer1_idx` (`customer_id` ASC) VISIBLE,
  CONSTRAINT `fk_delivery_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `Zolochevskyi`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Zolochevskyi`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Zolochevskyi`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `manufacturer` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `category` VARCHAR(45) NOT NULL,
  `price` DECIMAL(6,2) NOT NULL,
  `arrived` DATE NOT NULL,
  `expired` DATE NULL,
  `is_available` TINYINT NOT NULL,
  `shop_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_product_shop1_idx` (`shop_id` ASC) VISIBLE,
  CONSTRAINT `fk_product_shop1`
    FOREIGN KEY (`shop_id`)
    REFERENCES `Zolochevskyi`.`shop` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Zolochevskyi`.`delivery_products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Zolochevskyi`.`delivery_products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `quantity` INT NOT NULL,
  `weight` DECIMAL(5,3) NOT NULL,
  `price` DECIMAL(5,2) NOT NULL,
  `product_id` INT NOT NULL,
  `delivery_id` INT NOT NULL,
  `delivery_customer_id` INT NOT NULL,
  PRIMARY KEY (`id`, `product_id`, `delivery_id`, `delivery_customer_id`),
  INDEX `fk_delivery_products_product1_idx` (`product_id` ASC) VISIBLE,
  INDEX `fk_delivery_products_delivery1_idx` (`delivery_id` ASC, `delivery_customer_id` ASC) VISIBLE,
  CONSTRAINT `fk_delivery_products_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `Zolochevskyi`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_delivery_products_delivery1`
    FOREIGN KEY (`delivery_id` , `delivery_customer_id`)
    REFERENCES `Zolochevskyi`.`delivery` (`id` , `customer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
