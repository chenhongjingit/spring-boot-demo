package com.example.demo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Ingredient {

	 private final String id;
	 private final String nama ;
	 private final Type type ;
	 
	 public static enum Type {
		 WRAP,PROTEIN,VEGGIES,CHEESE,SAUCE
	 }
	 
	 
}
