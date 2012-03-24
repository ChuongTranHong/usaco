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
	TASK: friday
 */
public class friday {
	static int numberOfLeap=0;
	static int currentYear= 1900;
	static int firstDayOfMonth = 2;
	static int[] dayOfMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
	static int[] dayOfMonthLeap = {31,29,31,30,31,30,31,31,30,31,30,31};
	public static void main(String[] args) throws NumberFormatException, IOException{
		int[] numberOfDay = new int[7];
		for(int i=0;i<numberOfDay.length;i++)numberOfDay[i]=0;
		
		BufferedReader f = new BufferedReader(new FileReader("friday.in"));
		int numberOfYear = Integer.parseInt(f.readLine());
		System.out.println(numberOfYear);
		for(int i=0;i<numberOfYear;i++){
			for(int j=0;j<12;j++){
				numberOfDay[(firstDayOfMonth+5)%7]++;
				firstDayOfMonth(j);
			}
			currentYear++;
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"friday.out")));
		for(int i=0;i<numberOfDay.length-1;i++){
			out.write(numberOfDay[i]+" ");
//			System.out.println(numberOfDay[i]+" ");
		}
//		System.out.println("leap "+numberOfLeap);
		out.println((String.valueOf(numberOfDay[numberOfDay.length-1])));
		out.close();
		System.exit(0); // don't omit this!
	}
	public static void firstDayOfMonth(int month){
		if(month!=1){
			firstDayOfMonth = (firstDayOfMonth + (dayOfMonth[month]%7))%7;
		}else{
			if(isLeap()){
				numberOfLeap++;
//				System.out.println("current year "+currentYear);
				firstDayOfMonth = (firstDayOfMonth +1 )%7;
			}
		}
	}
	
	public static boolean isLeap(){
		if(currentYear%400 == 0)return true;
		if(currentYear %100 ==0)return false;
		if ( currentYear %4 ==0 )return true;
		else return false;
	}
}
