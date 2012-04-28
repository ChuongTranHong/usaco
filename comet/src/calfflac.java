/*
	ID: thcbin11
	LANG: JAVA
	TASK: calfflac
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class calfflac {

	public static void main(String args[]) throws IOException {
		int maxLenght= 0,maxMiddle=0;
		boolean even=false;
		BufferedReader f = new BufferedReader(new FileReader("calfflac.in"));
		String contain = new String();
		String line;
		while ((line = f.readLine()) != null) {
			contain +="\n"+ line;
		}
		String containclone =new String(contain);
		contain = contain.toLowerCase();
		for (int i = 1; i < contain.length() - 1; i++) {
			if (!Character.isLetter(contain.charAt(i)))
				continue;


			int result1 =  isPalim(true, contain, i);
			int result2 = isPalim(false, contain, i);
			if(result1>maxLenght){
				maxLenght = result1;
				maxMiddle =i;
				even =true;
			}
			if(result2>maxLenght){
				maxLenght= result2;
				maxMiddle = i;
				even = false;
			}
//			int leftMargin = 1, rightMargin = 1;
//			while (true) {//?
//				while (i - leftMargin >= 0
//						&& !Character.isLetter(contain.charAt(i - leftMargin)))
//					leftMargin++;
//				// check the out of range
//				while (i + rightMargin < contain.length()
//						&& !Character.isLetter(contain.charAt(i + rightMargin)))
//					rightMargin++;
//				
//				
//				if(contain.charAt(i-leftMargin)!=contain.charAt(i+rightMargin)){
//					
//					break;
//				}
//				leftMargin++;
//				rightMargin++;
//				halfLength++;
//			}
			
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"calfflac.out")));
		int length = (even)? maxLenght*2:maxLenght*2+1;
		out.println(length);
		out.println(shiftLeft(containclone, maxLenght, maxMiddle)+shiftRight(containclone, maxLenght, maxMiddle, even));
		out.close();
		System.exit(0);
//		System.out.println("at "+maxMiddle + " length "+maxLenght);
//		System.out.print(shiftLeft(containclone, maxLenght, maxMiddle));
//		System.out.println(shiftRight(containclone, maxLenght, maxMiddle, even));
	}
	public static String shiftLeft(String string, int length,int position){
		StringBuilder sb = new StringBuilder();
		int index=0;
		int i=1;
		while(index<length){
			if(Character.isLetter(string.charAt(position - i)))index++;
			sb.append(string.charAt(position-i));
			i++;
		}
		sb.reverse();
		return sb.toString();
	}
	public static String shiftRight(String string, int length,int position, boolean even){
		StringBuilder sb = new StringBuilder();
		int index=0,i;
		if(!even){
			sb.append(string.charAt(position));
			i=1;
		}else i=0;
		

		
		while(index<length){
			if(Character.isLetter(string.charAt(position + i)))index++;
			sb.append(string.charAt(position+i));
			i++;
		}
		return sb.toString();
	}
	public static int isPalim(boolean even,String string,int position){
		int halfLength=0;
		int leftMargin = 1,rightMargin;
		if(even)rightMargin=0;
		else rightMargin=1;
		while(position-leftMargin>=0 && position+rightMargin<string.length()){
			while (position - leftMargin >= 0
					&& !Character.isLetter(string.charAt(position - leftMargin)))
				leftMargin++;
			while (position + rightMargin < string.length()
					&& !Character.isLetter(string.charAt(position + rightMargin)))
				rightMargin++;
			if(position-leftMargin<0||position+rightMargin>=string.length())break;
			if(string.charAt(position-leftMargin)!=string.charAt(position+rightMargin)){
				break;
			}
			halfLength++;
			leftMargin++;
			rightMargin++;
		}
		return halfLength;
	}
}
