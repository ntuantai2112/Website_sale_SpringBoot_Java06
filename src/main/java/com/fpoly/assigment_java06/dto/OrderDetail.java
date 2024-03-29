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
public class OrderDetail  implements Serializable{

	Long id;
	Double price;
	Integer quantity;

    Product product;

    Order order;
}
