package com.fpoly.assigment_java06.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account  implements Serializable{

	private String username;
	private String password;
	private String fullname;
	private String email;
	private String photo;

}
