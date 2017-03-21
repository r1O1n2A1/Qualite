-- MySQL Script generated by MySQL Workbench
-- 03/17/17 15:30:39
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bdd_qualite
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bdd_qualite` ;

-- -----------------------------------------------------
-- Schema bdd_qualite
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bdd_qualite` DEFAULT CHARACTER SET utf8 ;
USE `bdd_qualite` ;

-- -----------------------------------------------------
-- Table `bdd_qualite`.`cafeteria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdd_qualite`.`cafeteria` ;

CREATE TABLE IF NOT EXISTS `bdd_qualite`.`cafeteria` (
  `id_cafeteria` INT(11) NOT NULL auto_increment,
  `nom_salle` VARCHAR(45) NOT NULL,
  `nombre_de_place` INT(11) NOT NULL,
  PRIMARY KEY (`id_cafeteria`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO cafeteria  (`id_cafeteria`, `nom_salle`, `nombre_de_place`) VALUES (1, 'cafette', 5);
-- -----------------------------------------------------
-- Table `bdd_qualite`.`promotion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdd_qualite`.`promotion` ;

CREATE TABLE IF NOT EXISTS `bdd_qualite`.`promotion` (
  `id_promotion` INT(11) NOT NULL auto_increment,
  `intitule` VARCHAR(45) NOT NULL,
  `code` VARCHAR(45) NOT NULL,
  `date_debut` DATETIME NOT NULL,
  `date_fin` DATETIME NOT NULL,
  PRIMARY KEY (`id_promotion`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO promotion (`id_promotion`,`intitule`,`code`,`date_debut`, `date_fin`) VALUES 
(1, 'AL','24','2017-01-21','2017-04-21'),
(2, 'AL','25','2017-01-21','2017-04-21'),
(3, 'AL','26','2017-01-22','2017-04-22'),
(4, 'AL','27','2017-01-15','2017-04-15'),
(5, 'AL','28','2017-01-23','2017-04-23'),
(6, 'AL','29','2017-01-16','2017-04-16');

-- -----------------------------------------------------
-- Table `bdd_qualite`.`occupation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdd_qualite`.`occupation` ;

CREATE TABLE IF NOT EXISTS `bdd_qualite`.`occupation` (
  `id_occupation` INT(11) NOT NULL auto_increment,
  `plage_horraire` INT(11) NOT NULL,
  `date_debut` DATETIME NOT NULL,
  `date_fin` DATETIME NOT NULL,
  `id_promotion` INT(11) NOT NULL,
  `id_cafeteria` INT(11) NOT NULL,
  PRIMARY KEY (`id_occupation`),
  INDEX `fk_promotion_idx` (`id_promotion` ASC),
  INDEX `fk_cafet_idx` (`id_cafeteria` ASC),
  CONSTRAINT `fk_cafet`
    FOREIGN KEY (`id_cafeteria`)
    REFERENCES `bdd_qualite`.`cafeteria` (`id_cafeteria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_promotion`
    FOREIGN KEY (`id_promotion`)
    REFERENCES `bdd_qualite`.`promotion` (`id_promotion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO occupation (`id_occupation`, `plage_horraire`, `date_debut`, `date_fin`, `id_promotion`, `id_cafeteria`)
VALUES (1, 1, '2017-03-20', '2017-03-24', 1, 1),
(2, 1, '2017-03-20', '2017-03-24', 2, 1),
(3, 2, '2017-03-20', '2017-03-24', 3, 1),
(4, 2, '2017-03-20', '2017-03-24', 4, 1),
(5, 3, '2017-03-20', '2017-03-24', 5, 1),
(6, 4, '2017-03-20', '2017-03-24', 6, 1);


-- -----------------------------------------------------
-- Table `bdd_qualite`.`stagiaire`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdd_qualite`.`stagiaire` ;

CREATE TABLE IF NOT EXISTS `bdd_qualite`.`stagiaire` (
  `id_stagiaire` INT(11) NOT NULL auto_increment,
  `nom` VARCHAR(45) NOT NULL,
  `mail` VARCHAR(200) NOT NULL,
  `gluten` TINYINT(1) NOT NULL,
  `id_promotion` INT(11) NOT NULL,
  PRIMARY KEY (`id_stagiaire`),
  INDEX `fk_promotion_idx` (`id_promotion` ASC),
  CONSTRAINT `fk_stagiaire_promotion`
    FOREIGN KEY (`id_promotion`)
    REFERENCES `bdd_qualite`.`promotion` (`id_promotion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO stagiaire (`id_stagiaire`,`nom`,`mail`,`gluten`,`id_promotion`) VALUES
(1,'stagiaire 1','stagiaire1@afcepf.fr',0,1),
(2,'stagiaire 2','stagiaire2@afcepf.fr',0,1),
(3,'stagiaire 3','stagiaire3@afcepf.fr',0,1),
(4,'stagiaire 4','stagiaire4@afcepf.fr',0,2),
(5,'stagiaire 5','stagiaire5@afcepf.fr',0,2),
(6,'stagiaire 6','stagiaire6@afcepf.fr',0,3),
(7,'stagiaire 7','stagiaire7@afcepf.fr',0,3),
(8,'stagiaire 8','stagiaire8@afcepf.fr',0,3),
(9,'stagiaire 9','stagiaire9@afcepf.fr',0,4),
(10,'stagiaire 10','stagiaire10@afcepf.fr',0,4),
(11,'stagiaire 11','stagiaire11@afcepf.fr',0,5),
(12,'stagiaire 12','stagiaire12@afcepf.fr',0,5),
(13,'stagiaire 13','stagiaire13@afcepf.fr',0,5),
(14,'stagiaire 14','stagiaire14@afcepf.fr',0,6),
(15,'stagiaire 15','stagiaire15@afcepf.fr',0,6);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
