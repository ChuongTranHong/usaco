import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
	ID: thcbin11
	LANG: JAVA
	TASK: beads
 */
public class beads {
	public static	int []necklace;
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader f = new BufferedReader(new FileReader("beads.in"));
		int length = Integer.parseInt(f.readLine());
		necklace = new int[length];
		String neck = f.readLine();
		f.close();
		char character;
		for(int i=0;i<neck.length();i++){
			character = neck.charAt(i);
			if(character == 'w')necklace[i]=0;
			else if(character == 'b')necklace[i]=1;
			else if(character == 'r')necklace[i]=2;
		}
		
//		for(int i =0;i<necklace.length;i++){
//			System.out.print(necklace[i]);
//		}
		int maxNumber = 0;
		
		for(int i=0;i<necklace.length;i++){
			int result = numberOfBead(i);
			if(maxNumber<result)maxNumber = result;
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"beads.out")));
		out.println(maxNumber);
//		System.out.println(maxNumber);
		out.close();
		System.exit(0); // don't omit this!
	}
	public static int numberOfBead( int position){
		int maxNumber=0;
		int index =0;
		int length = necklace.length;
		int currentColor= 0;
		while(index<length-1){
			if(sameColor(currentColor,necklace[(position+index)%length])){
				if(currentColor==0)currentColor=necklace[(position+index)%length];
				maxNumber ++;
				index++;
			}else break;
		}
		currentColor = 0;
		int reduceLenght = length-index;
		index=1;
		while(index<=reduceLenght){
			if(sameColor(currentColor, necklace[(position-index+length)%length])){
				if(currentColor==0)currentColor=necklace[(position-index+length)%length];
				maxNumber ++;
				index++;
			}else break;
		}
		return maxNumber;
	}
	public static boolean sameColor(int number1, int number2){
		if(number1 == number2 )return true;
		if(number1==0 || number2 == 0)return true;
		return false;
	}
}
