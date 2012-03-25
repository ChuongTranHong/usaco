/*
 ID: thcbin11
 LANG: JAVA
 TASK: namenum
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class namenum {
	public static HashMap<Integer,char[]> dic;
	public static void main(String args[]) throws NumberFormatException, IOException{
		dic = new HashMap<Integer,char[]>();
		dic.put(2,new char[]{'A','B','C'});
		dic.put(3, new char[]{'D','E','F'});
		dic.put(4, new char[]{'G','H','I'});
		dic.put(5, new char[]{'J','K','L'});
		dic.put(6, new char[]{'M','N','O'});
		dic.put(7, new char[]{'P','R','S'});
		dic.put(8, new char[]{'T','U','V'});
		dic.put(9, new char[]{'W','X','Y'});
		BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
		long number = Long.parseLong(f.readLine());
		f.close();
		long tempNumber = number;
		int length = Long.toString(number).length();
		int[] numberArray = new int[length]; 
		for(int i=length-1;i>=0;i--){
			numberArray[i] = (int) (tempNumber %10);
			tempNumber = tempNumber/10;
		}
		f = new  BufferedReader(new FileReader("dict.txt"));
		String line;
		boolean reachZone =false;
		boolean correct = true;
		boolean found =false;
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"namenum.out")));
//		if(contain(dic.get(2), 'A'))System.out.println("contain");
//		else System.out.println("not contain");
		while((line=f.readLine())!=null){
			correct =true;
			char character = line.charAt(0);
			if(contain(dic.get(numberArray[0]),character)){
				
				reachZone =true;
				if(line.length()!=length)continue;
				
				for(int i=1;i<length;i++){
					character = line.charAt(i);
					if(!contain(dic.get(numberArray[i]),character)){
						correct = false;
						break;
					}
				}
				if(correct){
					found = true;
					out.println(line);
				}
			}else if(reachZone)break;
		}
		if(!found)out.println("NONE");
		out.close();
		f.close();
		System.exit(0); // don't omit this!
	}
	public static boolean contain(char[] array,char character){
		for(int i=0;i<array.length;i++){
			if(array[i]==character)return true;
		}
		return false;
	}
}
