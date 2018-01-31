package com.codejam.practice2017.qualifiers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TidyNumbers {
	
    private static Scanner in;
    private static PrintWriter out;
    String infile = "src/com/codejam/practice2017/qualifiers/" + this.getClass().getSimpleName() + ".in";
    String outfile = "src/com/codejam/practice2017/qualifiers/" + this.getClass().getSimpleName() + ".out";

    public static void main(String[] args) throws FileNotFoundException {
    	new TidyNumbers().execute();
    }
    
    public void execute() throws FileNotFoundException{
    	//in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    	
    	in = new Scanner(new FileReader(infile));
        out = new PrintWriter(outfile);
        
        TidyNumbers obj = new TidyNumbers();
        
		int t = in.nextInt(); 
		
		for (int i = 1; i <= t; ++i) {
			
			long n = in.nextLong();
			
			out.println("Case #" + i + ": " + obj.solve(n));
			//System.out.println("Case #" + i + ": " + obj.solve(n));
		}
        
        in.close();
        out.close();
    }

	public String solve(long n) {

		boolean isTidy = false;
		
		List<Integer> digits = new ArrayList<Integer>();
		
		long num = n;
		while (num > 0) {
			digits.add((int) num % 10);
			num /= 10;
		}
		Collections.reverse(digits);
		
		while(!isTidy){
			isTidy = true;
			long prevDigit = 0;
			for(int i=0; i<digits.size(); i++){
				if (digits.get(i) < prevDigit) {
					isTidy = false;
					
					//Update the digits
					digits.set(i-1, digits.get(i-1)-1);
					for(int j=i; j<digits.size(); j++){
						digits.set(j, 9);
					}
					break;
				}
				prevDigit = digits.get(i);
			}
			if(digits.get(0)==0){
				digits.remove(0);
			}
		}
		
		StringBuilder str = new StringBuilder();
		for(Integer i : digits){
			str.append(i);
		}

		return str.toString();
	}
}
