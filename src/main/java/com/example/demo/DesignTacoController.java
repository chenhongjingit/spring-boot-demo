package com.example.demo;

import java.util.List;
import java.util.Arrays;
import java.util.stream.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
 

import com.example.demo.Ingredient;
import com.example.demo.Ingredient.Type;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {
	@GetMapping
	public String showDesignForm(Model model) {
		
		List<Ingredient> ingredients = Arrays.asList(
				new Ingredient("FLTO","fLOUE",Type.WRAP),
				new Ingredient("coto","sss",Type.WRAP),
				new Ingredient("grbf","fLddsddOUE",Type.PROTEIN),
				new Ingredient("cansdsd","ddsd",Type.PROTEIN),
				new Ingredient("sssd","ffff",Type.VEGGIES),
				new Ingredient("ffff","fLOffffUE",Type.VEGGIES),
				new Ingredient("zzzz","fLdsdsdOUE",Type.VEGGIES),
				new Ingredient("ccc","fLOqwqwUE",Type.CHEESE),
				new Ingredient("sddd","fLsdsdOUE",Type.CHEESE)
				
				); 
		
		Type[] types = Ingredient.Type.values();
		for (Type type : types) {
			 model.addAttribute(type.toString().toLowerCase(),filterByType(ingredients,type));
			
		}
		model.addAttribute("design",new Taco());
		
		return "design";
		
	}

	private Object filterByType(List<Ingredient> ingredients, Type type) {
		// TODO Auto-generated method stub
		return ingredients
				.stream()
				.filter(x->x.getType().equals(type))
				.collect(Collectors.toList());
	}
	

}
