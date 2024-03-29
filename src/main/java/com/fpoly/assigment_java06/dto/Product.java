package com.fpoly.assigment_java06.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product  implements Serializable{

	Integer id;
	String name;
	String image;
	Double price;

	Date createDate = new Date();
	Boolean available;

    Category category;

	List<OrderDetail> orderDetails;
}
