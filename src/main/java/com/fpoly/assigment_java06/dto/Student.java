package com.fpoly.assigment_java06.dto;


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
public class Student {


    private String email;
    private String fullname;
    private Double marks;
    private Boolean gender;
    private String country;


}
