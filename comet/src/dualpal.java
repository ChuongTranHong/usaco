/*
 ID: thcbin11
 LANG: JAVA
 TASK: dualpal
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class dualpal {
	public static void main(String args[]) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
		String line = f.readLine();
		f.close();
		StringTokenizer st = new StringTokenizer(line);
		int limit = Integer.parseInt(st.nextToken());
		int floor = Integer.parseInt(st.nextToken());
		int count = 0;
		int currentNumber =(floor+1);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"dualpal.out")));
		while(count<limit){
			if(checkingDual(currentNumber)){
				count++;
				out.println(currentNumber);
			}
			currentNumber++;
		}
		out.close();
		System.exit(0); // don't omit this!
	}
	public static Character[] changeBase(int number , int base){
		ArrayList<Character>result = new ArrayList<Character>();
		Character[] a ;
		int temp = number;
		int remain=0;
		while(temp!=0){
			remain = temp%base;
			result.add((char)('0'+remain));
			temp = temp/base; 
		}
		Collections.reverse(result);
		a = new Character[result.size()];

		return (result.toArray(a));
	}
	public static boolean palindromic(Character[] array){
		int lenght = array.length;
		int half = lenght/2;
		for(int i=0;i<half;i++){
			if(array[i]!=array[lenght-i-1])return false;
		}
		return true;
	}
	public static boolean checkingDual(int number){
		int count =0;
		Character[] result;
		for(int i=2;i<=10;i++){
			result =changeBase(number, i);
			if(palindromic(result))count++;
			if(count>=2)return true;
		}
		return false;
	}
}
