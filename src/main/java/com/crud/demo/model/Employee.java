package com.crud.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "First_name")
  @NonNull
  private String firstName;

  @Column(name = "Last_name")
  @NonNull
  private String lastName;

  @Column(name = "Gender")
  @NonNull
  private String gender;

  @Column(name = "Department")
  @NonNull
  private String department;

  @Column(name = "Country")
  @NonNull
  private String country;
}
