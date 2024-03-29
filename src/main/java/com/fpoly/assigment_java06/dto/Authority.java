package com.fpoly.assigment_java06.dto;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Authority  implements Serializable{

	private Integer id;
	private Account account;
	private Role role;
}