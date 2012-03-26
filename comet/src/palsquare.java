/*
 ID: thcbin11
 LANG: JAVA
 TASK: palsquare
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


public class palsquare {
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
		int base =Integer.parseInt(f.readLine());
		f.close();
		Character[] result ;
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"palsquare.out")));
//		for(int i=0;i<result.length;i++){
//			System.out.print(result[i]);
//		}
//		if(palindromic(result))System.out.println("correct");
//		else System.out.println("not correct");
		for(int i=1;i<=300;i++){
			result= changeBase((int)Math.pow(i,2),base);
			if(palindromic(result)){
				out.println(valueOf(changeBase(i,base))+" "+valueOf(result));
			}
		}
		out.close();
	}
	public static String valueOf(Character[] array){
		StringBuilder st= new StringBuilder();
		for(int i=0;i<array.length;i++)st.append(array[i]);
		return st.toString();
	}
	public static Character[] changeBase(int number , int base){
		ArrayList<Character>result = new ArrayList<Character>();
		Character[] a ;
		int temp = number;
		int remain=0;
		while(temp!=0){
			remain = temp%base;
			if(remain<10)
				result.add((char)('0'+remain));
			else result.add((char)('A'+remain-10));
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
}
