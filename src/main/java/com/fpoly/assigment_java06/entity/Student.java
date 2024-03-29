package com.fpoly.assigment_java06.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Students")
public class Student {

    @Id
    @Column(name = "email")
    private String email;
    private String fullname;
    private Double marks;
    private Boolean gender;
    private String country;


}
