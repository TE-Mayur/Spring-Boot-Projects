package com.te.java8features;

import java.util.ArrayList;
import java.util.List;

public class LamdaFunction {
	
	public static void main(String[] args) {
	
		String str ="Mayur";
		
		Writing wri = ()->{
			System.out.println("Writing" + str);
		};
		wri.write();
	}
}
