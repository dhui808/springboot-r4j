package com.example.us;

import lombok.Data;
import lombok.NonNull;

@Data
public class OrderDTO {
	@NonNull
    private int id;
	@NonNull
    private String name;
	@NonNull
    private String category;
	@NonNull
    private String color;
	@NonNull
    private double price;
}
