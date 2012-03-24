package com.demo.dao.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ShwTest entity. @author MyEclipse Persistence Tools 
 * CREATE TABLE `test`.`shw_test` (
 *  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
 *  `name` VARCHAR(20) NOT NULL,
 *  PRIMARY KEY (`id`) 
 * ) AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
 */
@Entity
@Table(name = "shw_test", catalog = "test")
public class ShwTest implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;

	// Constructors

	/** default constructor */
	public ShwTest() {
	}

	/** full constructor */
	public ShwTest(String name) {
		this.name = name;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}