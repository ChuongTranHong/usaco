/*
	ID: thcbin11
	LANG: JAVA
	TASK: clocks
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class clocks {

	static CommandList[] commandAffectedArray;
	public static void main(String args[]) throws IOException{
		int t1,t2,t3,t4,t5,t6,t7,t8,t9;
		int [][]clock = new int [3][3];
		BufferedReader f = new BufferedReader(new FileReader("clocks.in"));
		int [] array= new int[9];
		for(int i=0;i<3;i++){
			String line = f.readLine();
			StringTokenizer st = new StringTokenizer(line);
			clock[i][0] = Integer.parseInt(st.nextToken());
			clock[i][1] = Integer.parseInt(st.nextToken());
			clock[i][2] = Integer.parseInt(st.nextToken());
		}
		f.close();

		commandAffectedArray= new CommandList[9];

		for(int i=0;i<commandAffectedArray.length;i++){
			commandAffectedArray[i]= new CommandList();
		}
		
		Collection< Coordinate> coordinateList =  new HashSet<Coordinate>(Arrays.asList(new Coordinate[]{new Coordinate(0,0),new Coordinate(0,1),new Coordinate(1,0),new Coordinate(1,1)} ));
		commandAffectedArray[0].commandList.addAll(coordinateList);
		coordinateList =  new HashSet<Coordinate>(Arrays.asList(new Coordinate[]{new Coordinate(0,0),new Coordinate(0,1),new Coordinate(0,2)} ));
		commandAffectedArray[1].commandList.addAll(coordinateList);
		coordinateList =  new HashSet<Coordinate>(Arrays.asList(new Coordinate[]{new Coordinate(0,1),new Coordinate(0,2),new Coordinate(1,1),new Coordinate(1,2)} ));
		commandAffectedArray[2].commandList.addAll(coordinateList);
		coordinateList =  new HashSet<Coordinate>(Arrays.asList(new Coordinate[]{new Coordinate(0,0),new Coordinate(1,0),new Coordinate(2,0)} ));
		commandAffectedArray[3].commandList.addAll(coordinateList);
		coordinateList =  new HashSet<Coordinate>(Arrays.asList(new Coordinate[]{new Coordinate(0,1),new Coordinate(1,0),new Coordinate(1,1),new Coordinate(1,2),new Coordinate(2,1)} ));
		commandAffectedArray[4].commandList.addAll(coordinateList);
		coordinateList =  new HashSet<Coordinate>(Arrays.asList(new Coordinate[]{new Coordinate(0,2),new Coordinate(1,2),new Coordinate(2,2)} ));
		commandAffectedArray[5].commandList.addAll(coordinateList);
		coordinateList =  new HashSet<Coordinate>(Arrays.asList(new Coordinate[]{new Coordinate(1,0),new Coordinate(1,1),new Coordinate(2,0),new Coordinate(2,1)} ));
		commandAffectedArray[6].commandList.addAll(coordinateList);
		coordinateList =  new HashSet<Coordinate>(Arrays.asList(new Coordinate[]{new Coordinate(2,0),new Coordinate(2,1),new Coordinate(2,2)} ));
		commandAffectedArray[7].commandList.addAll(coordinateList);
		coordinateList =  new HashSet<Coordinate>(Arrays.asList(new Coordinate[]{new Coordinate(1,1),new Coordinate(1,2),new Coordinate(2,1),new Coordinate(2,2)} ));
		commandAffectedArray[8].commandList.addAll(coordinateList);
		for(array[0]=1;array[0]<=4;array[0]++){
			update(commandAffectedArray[0].commandList,clock);
			for(array[1]=1;array[1]<=4;array[1]++){
				update(commandAffectedArray[1].commandList,clock);
				for(array[2]=1;array[2]<=4;array[2]++){
					update(commandAffectedArray[2].commandList,clock);
					for(array[3]=1;array[3]<=4;array[3]++){
						update(commandAffectedArray[3].commandList,clock);
						for(array[4]=1;array[4]<=4;array[4]++){
							update(commandAffectedArray[4].commandList,clock);
							for(array[5]=1;array[5]<=4;array[5]++){
								update(commandAffectedArray[5].commandList,clock);
								for(array[6]=1;array[6]<=4;array[6]++){
									update(commandAffectedArray[6].commandList,clock);
									for(array[7]=1;array[7]<=4;array[7]++){
										update(commandAffectedArray[7].commandList,clock);
										for(array[8]=1;array[8]<=4;array[8]++){
											update(commandAffectedArray[8].commandList,clock);
											if(isFinished(clock)){
//												System.out.println("exit");
												solution(array);
												System.exit(0);
											}
										}
										
									}
									
								}
								
							}
							
						}
						
					}
					
				}
				
			}
			
		}
	

	}
	public static void solution(int[] array) throws IOException{

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"clocks.out")));
		StringBuilder st= new StringBuilder();
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array[i]%4;j++){
				st.append((i+1)+" ");
			}
		}
		st.deleteCharAt(st.length()-1);
		out.println(st.toString());
		out.close();

	}

	
	static public void update(ArrayList<Coordinate> updateArray,int[][]clock){
		Coordinate coordinate;

		for(int i=0;i<updateArray.size();i++){
			coordinate = updateArray.get(i);
			clock[coordinate.x][coordinate.y]+=3;
			if(clock[coordinate.x][coordinate.y]>12)clock[coordinate.x][coordinate.y]-=12;
		}
		
	}
	static public boolean isFinished(int [][] clock){
		for(int i=0;i<clock.length;i++){
			for(int j=0;j<clock.length;j++){
				if(clock[i][j]!=12)return false;
			}
		}
		return true;
	}
	static class Coordinate{
		int x,y;
		public Coordinate(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	static class CommandList{
		ArrayList<Coordinate>commandList =new ArrayList<Coordinate>();
		
	}
	
}
