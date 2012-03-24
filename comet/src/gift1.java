/*
	ID: thcbin11
	LANG: JAVA
	TASK: gift1
 */
import java.io.*;
import java.util.*;

class gift1 {

	public static void main(String[] args) throws IOException {
		HashMap<String,User> hashMap =new HashMap<String,User>();
		String[] name; 
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"gift1.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		int numberOfPeople = Integer.parseInt(f.readLine().trim());
		name = new String[numberOfPeople];
		for(int i=0;i<numberOfPeople;i++){
			String namePerson = f.readLine().trim();
			name[i]=namePerson;
			hashMap.put(namePerson, new User());
		}
		String strLine;
		while ((strLine = f.readLine()) != null) {
			// Print the content on the console
			String namePerson =strLine.trim();
			StringTokenizer st = new StringTokenizer(f.readLine());
			int initAmount = Integer.parseInt(st.nextToken()); // first integer
			int numberOfReceiver = Integer.parseInt(st.nextToken());
			User user = hashMap.get(namePerson);
			
			int receiveAmount = (numberOfReceiver==0)?0:initAmount/numberOfReceiver;
			
			user.give = receiveAmount*numberOfReceiver;
			user.initAmount = initAmount- user.give;
			for(int i = 0;i<numberOfReceiver;i++){
				String receiverName = f.readLine().trim();
				
				User receiver = hashMap.get(receiverName);
				if(receiver == null)System.out.println("is null "+receiverName);
				receiver.receive+=receiveAmount;
			}
			
		}
		for(int i=0;i<name.length;i++){
			User user = hashMap.get(name[i]);
			int result = user.receive-user.give;
			out.println(name[i]+" "+result);
		}
//		out.println(i1 + i2); // output result
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}

class User {
	public int initAmount=0;
	public int give=0;
	public int receive=0;
}