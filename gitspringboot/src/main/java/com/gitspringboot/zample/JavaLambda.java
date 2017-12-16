package com.gitspringboot.zample;

import java.util.Arrays;
import java.util.List;

public class JavaLambda {

	public static void main(String[] args) {

		Greetings s = (n) -> 	System.out.println("Hello World " + n);
			
			
		
		greet(s, "Tom");
	}

	private static void greet(Greetings greetingsInstance, String name) {
		greetingsInstance.sayHello(name);
		
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
		int a=list.stream().mapToInt((v->v.intValue())).sum();
		System.out.println("a="+a);
		
	}

}