/*
	ID: thcbin11
	LANG: JAVA
	TASK: milk2
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class milk2 {
	static int [][]worker;
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
		int numberOfFarmer = Integer.parseInt(f.readLine());
		worker = new int[numberOfFarmer][2];
		StringTokenizer st;
		String line;
		for(int i=0;i<numberOfFarmer;i++){
			line = f.readLine();
			st = new StringTokenizer(line);
			worker[i][0]=Integer.parseInt(st.nextToken());
			worker[i][1]=Integer.parseInt(st.nextToken());
		}
		quicksort(0, numberOfFarmer-1);
		for(int i=0;i<numberOfFarmer;i++){
			System.out.println(worker[i][0]+" "+worker[i][1]);
		}
		int index= 0;
		int maxAtLeastServe=0;
		int maxNoServe =0;
		int currentBegin =worker[0][0];
		int currentEnd= worker[0][1];
		while(index<numberOfFarmer){
			if(worker[index][1]<currentEnd){
				
			}else if(worker[index][0]>currentEnd){
				int diff= currentEnd-currentBegin;
				if(diff>maxAtLeastServe)maxAtLeastServe= diff;
				diff= worker[index][0]- currentEnd;
				if(diff>maxNoServe)maxNoServe = diff;
				currentBegin = worker[index][0];
				currentEnd = worker[index][1];
			} else{
				currentEnd = worker[index][1];
			}
			index++;
		}
		int diff = currentEnd-currentBegin;
		if(diff>maxAtLeastServe)maxAtLeastServe = diff;
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"milk2.out")));
		out.println(maxAtLeastServe+" "+maxNoServe);
		out.close();
		System.exit(0); // don't omit this!
//		System.out.println("at least "+maxAtLeastServe);
//		System.out.println("no serve "+maxNoServe);
	}
	private static void quicksort(int low, int high) {
		int i = low, j = high;
		// Get the pivot element from the middle of the list
		int pivot = worker[low + (high-low)/2][0];

		// Divide into two lists
		while (i <= j) {
			// If the current value from the left list is smaller then the pivot
			// element then get the next element from the left list
			while (worker[i][0] < pivot) {
				i++;
			}
			// If the current value from the right list is larger then the pivot
			// element then get the next element from the right list
			while (worker[j][0] > pivot) {
				j--;
			}

			// If we have found a values in the left list which is larger then
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot element then we exchange the
			// values.
			// As we are done we can increase i and j
			if (i <= j) {
				exchange(i, j);
				i++;
				j--;
			}
		}
		// Recursion
		if (low < j)
			quicksort(low, j);
		if (i < high)
			quicksort(i, high);
	}

	private static void exchange(int i, int j) {
		int temp = worker[i][0];
		int temp2 = worker[i][1];
		worker[i][0] = worker[j][0];
		worker[i][1] = worker[j][1];
		worker[j][0] = temp;
		worker[j][1] = temp2;
	}
}
