/*
ID: thcbin11
LANG: JAVA
TASK: ride
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

class ride {

	public static void main(String args[]) {
		try {

			FileInputStream fstream = new FileInputStream("ride.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			ArrayList<String> line = new ArrayList<String>();
 			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console
				line.add(strLine.trim());
				System.out.println(strLine);
			}
			in.close();
			int userMode = calculateValueString(line.get(1))%47;
			int cometMode = calculateValueString(line.get(0))%47;
			FileWriter wstream = new FileWriter("ride.out");
			BufferedWriter out = new BufferedWriter(wstream);

			  if(userMode != cometMode)out.write("STAY\n");
			  else out.write("GO\n");

			  out.close();

		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
	public static int calculateValueString(String st){
		int returnValue=1;
		for(int i=0;i<st.length();i++){
			char character = st.charAt(i);
			returnValue*= (character- 'A'+1);
		}
		return returnValue;
	}
}
