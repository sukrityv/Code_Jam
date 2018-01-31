package com.codejam.practice2017.qualifiers;

import java.util.*;
import java.io.*;

public class OversizedPancakeFlipper {
	
    private static Scanner in;
    private static PrintWriter out;
    String infile = "src/com/codejam/practice2017/qualifiers/" + this.getClass().getSimpleName() + ".in";
    String outfile = "src/com/codejam/practice2017/qualifiers/" + this.getClass().getSimpleName() + ".out";

    public static void main(String[] args) throws FileNotFoundException {
    	new OversizedPancakeFlipper().execute();
    }
    
    public void execute() throws FileNotFoundException{
    	in = new Scanner(new FileReader(infile));
        out = new PrintWriter(outfile);
        
        OversizedPancakeFlipper obj = new OversizedPancakeFlipper();
        
		int t = in.nextInt(); 
		
		for (int i = 1; i <= t; ++i) {
			
			String str = in.next();
			int k = in.nextInt();
			
			out.println("Case #" + i + ": " + obj.solve(str, k));
		}
        
        in.close();
        out.close();
    }

    public String solve(String str, int k){
		int noOfFlips = 0;
		
		int totalPancakes= str.length();
		
		//case when all pancakes are happy
		if(!str.contains("-")){
			noOfFlips = 0;
		} else {
			
			//Preparing the pancakes list of booleans for easier processing
			boolean[] pancakes = new boolean[totalPancakes];
			int count=0; 
			
			for(Character c : str.toCharArray()){
				pancakes[count] = c.equals('+');
				count++;
			}
			
			//Flipping the unhappy Pancakes
			for(int i=0; i<=totalPancakes-k; i++){
				if(!pancakes[i]){
					for( int j=0; j<k; j++){
						pancakes[i+j] = !pancakes[i+j];
					}
					noOfFlips++;
				}
			}
			
			//Checking that all pancakes are Happy
			for(int i=1; i<=k; i++){
				if(!pancakes[totalPancakes-i]){
					return "IMPOSSIBLE";
				}
			}
			
		}
		
		return "" + noOfFlips;
	}
}
