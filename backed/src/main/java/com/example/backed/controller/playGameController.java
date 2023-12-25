package com.example.backed.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backed.bean.NumberBean;
import com.example.backed.bean.guessNumberBean;

@RestController
@RequestMapping("/play")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class playGameController {
	
	@Autowired
	guessNumberBean guessNumber;
	 
	private List<Integer> guess = null;
	private boolean correctGuess = false;
	
	
	@PostMapping("/guess")
	public ResponseEntity guessNumber(@RequestBody NumberBean guessPlayer){
		
		//Integer total = 0;
		
		int A=0;
		int B=0;
			if(guess==null) {
				guess=guessNumber.createNumber();
			}
			
		String num1 = guessPlayer.getNum1();
		String num2 = guessPlayer.getNum2();
		String num3 = guessPlayer.getNum3();
		String num4 = guessPlayer.getNum4();
		
		String[] numPlayer = new String[4];
		numPlayer[0] = num1;
		numPlayer[1] = num2;
		numPlayer[2] = num3;
		numPlayer[3] = num4;
		
		List<String> answer = new ArrayList();
		
		answer.add(num1);
		answer.add(num2);
		answer.add(num3);
		answer.add(num4);
		
		for(int i=0;i<4;i++) {
			if(guess.get(i).equals(Integer.parseInt(answer.get(i)))){
				A++;
			}else {
				if(guess.contains(Integer.parseInt(numPlayer[i]))) {
					B++;
				}
			}
		}
		
		//System.out.println(guessPlayer);
		System.out.println(guess);
		String result=(A+"A"+B+"B");
		
		if(A==4) {
			correctGuess = true; 
			System.out.println(result);
			return ResponseEntity.ok(result+",恭喜答對了");
		}
		
		System.out.println(result);
		return ResponseEntity.ok(result+"我所送出的答案"+answer);
	}
	
	@PostMapping("/resetPlay")
	public ResponseEntity resetGuess() {
		guess=guessNumber.createNumber();
		correctGuess = false;
		return ResponseEntity.ok("reset game");
	}
}
