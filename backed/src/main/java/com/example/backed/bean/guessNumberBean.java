package com.example.backed.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class guessNumberBean {
	
	public List<Integer> createNumber(){
	Random random = new Random();
	
	List<Integer> numberList = new ArrayList<Integer>();
	
			while(numberList.size()<4) {
		
			int num = random.nextInt(10);
				
			if(!numberList.contains(num)) {
				numberList.add(num);
				}
			}
			
			return numberList;
	}
}
