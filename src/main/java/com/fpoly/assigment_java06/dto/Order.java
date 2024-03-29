package com.fpoly.assigment_java06.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order  implements Serializable{

	private Long id;
	private String address;

	Date createDate = new Date();

    Account account;
	

	List<OrderDetail> orderDetails;
}