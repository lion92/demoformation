/*
 * Copyright (c) 2001-2017 Group JCDecaux.
 * 17 rue Soyer, 92523 Neuilly Cedex, France.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of Group JCDecaux ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you
 * entered into with Group JCDecaux.
 */
package fr.jcdecaux.demo.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_table")
public class UserEntity {
  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(name = "first_name", nullable = false)
  private String firstName; // camelCase
  @Column(name = "last_name", nullable = false)
  private String lastName;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}