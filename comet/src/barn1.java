/*
 ID: thcbin11
 LANG: JAVA
 TASK: barn1
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class barn1 {
	static Stall[] arrayStall;

	public static void main(String args[]) throws IOException {

		BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
		String line = f.readLine();
		StringTokenizer st = new StringTokenizer(line);
		int numberOfBoard = Integer.parseInt(st.nextToken());
		int totalStall = Integer.parseInt(st.nextToken());
		int numberOccupied = Integer.parseInt(st.nextToken());
		arrayStall = new Stall[totalStall];
		for (int i = 0; i < totalStall; i++) {
			arrayStall[i] = new Stall(false, true);
		}

		int index;
		for (int i = 0; i < numberOccupied; i++) {
			line = f.readLine();
			index = Integer.parseInt(line);
			arrayStall[index - 1].occupied = true;
		}
		f.close();
		
		removeTwoEnd(arrayStall);
		
		for (int i = 1; i < numberOfBoard; i++) {
			removeBigGap(arrayStall);
			
		}
		
		
		int numberCover = 0;
		for (int i = 0; i < totalStall; i++) {
			if (arrayStall[i].cover)
				numberCover++;
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"barn1.out")));
		out.println(numberCover);
		out.close();
		System.exit(0);
		
	}
	public static void removeTwoEnd(Stall[] array){
		int index=0;
		while(index<array.length && !array[index].occupied) {
			array[index].cover = false;
			index++;
		}
		index=array.length-1;
		while(index >= 0 &&!array[index].occupied){
			array[index].cover = false;
			index--;
		}
		
	}

	public static void removeBigGap(Stall[] array) {
		
		int index = 0;
		int gaplength = 0;
		for (int i = 0; i < arrayStall.length; i++) {
			if (arrayStall[i].occupied || !arrayStall[i].cover) {

				continue;
			}
			int startIndex = i;
			i++;
			while (i < arrayStall.length && !arrayStall[i].occupied)
				i++;
			if ((i - startIndex) > gaplength) {
				index = startIndex;
				gaplength = i - startIndex;
			}
		}
		for (int i = index; i < index+gaplength; i++) {
			arrayStall[i].cover = false;
		}
		
	}

	static class Stall {
		boolean occupied;
		boolean cover;

		public Stall(boolean occ, boolean cover) {
			this.occupied = occ;
			this.cover = cover;
		}
	}
}
