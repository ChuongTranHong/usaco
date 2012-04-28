/*
 ID: thcbin11
 LANG: JAVA
 TASK: milk
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class milk {
	public static void main(String args[]) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("milk.in"));
		String line = f.readLine();
		StringTokenizer st = new StringTokenizer(line);
		int totalMilk = Integer.parseInt(st.nextToken());
		int numberOfFarm = Integer.parseInt(st.nextToken());
		Farm[] array = new Farm[numberOfFarm];
		for(int i= 0;i<numberOfFarm;i++){
			line = f.readLine();
			st = new StringTokenizer(line);
			int price = Integer.parseInt(st.nextToken());
			int milk = Integer.parseInt(st.nextToken());
			array[i]= new Farm(price, milk);
			
		}
		f.close();
		Arrays.sort(array);
//		for(int i=0;i<numberOfFarm;i++){
//			System.out.println(" "+array[i].price+" "+array[i].milk);
//		}
		int currentMilk=0;
		int index= 0;
		int price=0;
		Farm farm;
		int margin=totalMilk;
		while(currentMilk<totalMilk){
			margin = totalMilk- currentMilk; 
			farm = array[index];
			if(farm.milk<margin){
				price += farm.milk* farm.price;
				currentMilk +=farm.milk;
				
			}else {
				price +=farm.price*margin;
				currentMilk +=margin;
				
			}
			index++;
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"milk.out")));
		out.println(price);
		out.close();
		System.exit(0);
		
	}
	static class Farm implements Comparable<Farm>{
		int price ;
		int milk;
		public Farm(int price, int milk){
			this.price = price;
			this.milk = milk;
		}
		@Override
		public int compareTo(Farm o) {
			// TODO Auto-generated method stub
			if(this.price < o.price)return -1;
			else if(this.price > o.price) return 1;
			return 0;
		}
		 
	}
}
