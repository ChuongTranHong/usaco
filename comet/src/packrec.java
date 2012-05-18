/*
 ID: thcbin11
 LANG: JAVA
 TASK: packrec
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;









public class packrec {
	static int minArea=Integer.MAX_VALUE;
	static ArrayList<Rectangle> result = new ArrayList<Rectangle>();
	public static ArrayList<Rectangle> array = new ArrayList<Rectangle>();
	public static ArrayList<ArrayList<Rectangle>> combination = new ArrayList<ArrayList<Rectangle>>();
	public static void main(String args[]) throws IOException{
		Stack<ArrayList<Rectangle>> stack = new Stack<ArrayList<Rectangle>>();
		BufferedReader f = new BufferedReader(new FileReader("packrec.in"));
		String line = f.readLine();
		StringTokenizer st = new StringTokenizer(line);
		int x, y;
		
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		Rectangle rect1 = new Rectangle(x,y);
		
		array.add( rect1);
		line = f.readLine();
		st = new StringTokenizer(line);
		
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		Rectangle rect2 = new Rectangle(x,y);
		
		array.add( rect2);
		line = f.readLine();
		st = new StringTokenizer(line);
		
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		Rectangle rect3 = new Rectangle(x,y);
		
		array.add(rect3);
		line = f.readLine();
		st = new StringTokenizer(line);
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		Rectangle rect4 = new Rectangle(x,y);
		array.add(rect4);
		f.close();
		for(int i=0;i<array.size();i++){
			for(int j=0;j<array.size();j++){
				if(i==j)continue;
				for(int t=0;t<array.size();t++){
					if(t==j||t == i)continue;
					for(int l=0;l<array.size();l++){
						if(l==i||l==j||l==t)continue;
						ArrayList<Rectangle> temp= new ArrayList<Rectangle>();
						temp.add(array.get(i));
						temp.add(array.get(j));
						temp.add(array.get(t));
						temp.add(array.get(l));
						combination.add(temp);
						
					}
				}
			}
		}
		
		
		for(int i=0;i<combination.size();i++){
			ArrayList<Rectangle> tempList = combination.get(i);
			

			ArrayList<Rectangle> list1 = new ArrayList<Rectangle>();
			ArrayList<Rectangle> list2 = new ArrayList<Rectangle>();
			
			list1.add(tempList.get(0));
			list2.add(tempList.get(0).rotate());
			stack.push(list1);
			stack.push(list2);
			Rectangle tempRect;
			while(!stack.empty()){
				ArrayList<Rectangle> tempArray = stack.pop();
				if(tempArray.size()==tempList.size()){
					tempRect = firstLayout(tempArray);
					addToResult(tempRect);
					tempRect = secondLayout(tempArray);
					addToResult(tempRect);
					tempRect = thirdLayout(tempArray);
					addToResult(tempRect);
					tempRect = fourthFifthLayout(tempArray);
					addToResult(tempRect);
					tempRect = sixLayout(tempArray);
					addToResult(tempRect);
//					if(tempRect.area()<minArea){
//						result.clear();
//						result.add(tempRect);
//						System.out.println("change area "+tempRect.area());
//						displayArray(tempArray);
//						minArea = tempRect.area();
//					}else if(tempRect.area() == minArea){
//						System.out.println("the same area "+tempRect.area());
//						displayArray(tempArray);
//						result.add(tempRect);
//					}
				}else{
					ArrayList<Rectangle> cloneArray = (ArrayList<Rectangle>) tempArray.clone();
					tempArray.add(tempList.get(tempArray.size()));
					stack.push(tempArray);
					cloneArray.add(tempList.get(cloneArray.size()).rotate());
					stack.push(cloneArray);
				}
			}
		}
//		System.out.println("min area "+result.get(0).area());
		int previous=0;
		for(int i=0;i<result.size();i++){
			result.get(i).arrange();
		}
		Collections.sort(result);
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"packrec.out")));
		out.println(result.get(0).area());
		
		for(int i=0;i<result.size();i++){
			if(previous!=result.get(i).x)out.println(result.get(i).x+ " "+result.get(i).y);
			previous = result.get(i).x;
		}
		out.close();
	}
	public static void addToResult(Rectangle tempRect){
		if(tempRect.area()<minArea){
			result.clear();
			result.add(tempRect);
//			System.out.println("change area "+tempRect.area());
			
			minArea = tempRect.area();
		}else if(tempRect.area() == minArea){
//			System.out.println("the same area "+tempRect.area());
			
			result.add(tempRect);
		}
	}
//	public static void displayArray(ArrayList<Rectangle>array){
//		for(int i=0 ;i<array.size();i++){
//			System.out.println("array "+array.get(i).x+" "+array.get(i).y);
//		}
//	}
	
	static Rectangle firstLayout(ArrayList<Rectangle> array){
		Rectangle temp;
		int maxLength= 0,sumX=0;
		for(int i =0;i<array.size();i++){
			temp = array.get(i);
			sumX+=temp.x;
			if(maxLength<temp.y){
				maxLength = temp.y;
				
			}
		}
		return new Rectangle(maxLength,sumX);
	}
	static Rectangle secondLayout(ArrayList<Rectangle>array){
		Rectangle temp,lastRec;
		int maxLength= 0,sumX=0;
		for(int i =0;i<array.size()-1;i++){
			temp = array.get(i);
			sumX+=temp.x;
			if(maxLength<temp.y){
				maxLength = temp.y;
				
			}
		}
		
		lastRec =array.get(array.size()-1);
		if(sumX<lastRec.y)sumX=lastRec.y;
		return new Rectangle(sumX, lastRec.x+maxLength);
	}
	static Rectangle thirdLayout(ArrayList<Rectangle>array){
		int maxLength = (array.get(0).y>array.get(1).y)?array.get(0).y:array.get(1).y;
		int sumx = array.get(0).x+array.get(1).x;
		if(sumx<array.get(2).y)sumx=array.get(2).y;
		maxLength+=array.get(2).x;
		sumx+=array.get(3).x;
		if(maxLength<array.get(3).y)maxLength = array.get(3).y;
		return new Rectangle(sumx,maxLength);
		
	}
	static Rectangle fourthFifthLayout(ArrayList<Rectangle>array){
		int maxLength = (array.get(0).x>array.get(1).x)?array.get(0).x:array.get(1).x;
		int sum = array.get(0).y+array.get(1).y;
		sum = (sum<array.get(2).y)?array.get(2).y:sum;
		sum = (sum<array.get(3).y)?array.get(3).y:sum;
		maxLength+= array.get(2).x+array.get(3).x;
		return new Rectangle(maxLength,sum);
	}
	static Rectangle sixLayout(ArrayList<Rectangle>array){
		
		int length1 = array.get(0).y+array.get(2).y;
		int length2 = array.get(1).y+array.get(3).y;
//		int maxLength3 = array.get(0).y+array.get(3).y;
//		int maxLength4 = array.get(1).y+array.get(2).y;
		
		
		int width1 =array.get(0).x+array.get(1).x;
		int width2 =array.get(2).x+array.get(3).x;
		int width3 = (width1>width2)?width1:width2;
		
		if(array.get(0).x>array.get(2).x){
			if(array.get(3).y>array.get(2).y)return new Rectangle(Integer.MAX_VALUE, 1);
			if(array.get(0).x>width2){
				return new Rectangle(width3,(array.get(1).y>length1)?array.get(1).y:length1);
			}else {
				if(length2>length1)return new Rectangle(Integer.MAX_VALUE, 1);
				else return new Rectangle(length1,width3);
			}

		}else{
			if(array.get(1).y>array.get(0).y)return new Rectangle(Integer.MAX_VALUE, 1);
			if(array.get(2).x>width2){
				return new Rectangle(width3,(array.get(3).y>length1)?array.get(1).y:length1);
			}else {
				if(length2>length1)return new Rectangle(Integer.MAX_VALUE, 1);
				else return new Rectangle(length1,width3);
			}

		}
//		int sum3 = array.get(0).x+array.get(3).x;
//		int sum4 = array.get(1).x+ array.get(2).x;
		
//		sum1 = (sum1>sum3)?sum1:sum3;
//		sum1 = (sum1>sum4)?sum1:sum4;
//		maxLength1 =(maxLength1>maxLength2)?maxLength1:maxLength2;
//		maxLength1 =(maxLength1>maxLength3)?maxLength1:maxLength3;
//		maxLength1 =(maxLength1>maxLength4)?maxLength1:maxLength4;
//		System.out.println("sum1 "+sum1+"  "+maxLength1);
//		return new Rectangle(sum1,maxLength1);
		
	}
	
	
	
	static class Rectangle implements Comparable<Rectangle>{
		int x,y;
		public Rectangle(int x,int y){
			
			this.x = x;
			this.y = y;
		
		}
		public Rectangle(int x, int y,boolean notFix){
			this.x = x;
			this.y = y;
		}
		public int area(){
			return x*y;
		}
		public Rectangle rotate(){
			
			return new Rectangle(y,x,true);
		}
		public void arrange(){
			if(x>y){
				int temp = x;
				x= y;
				y=temp;
			}
		}
		@Override
		public int compareTo(Rectangle arg0) {
			// TODO Auto-generated method stub
			if(this.x <arg0.x)return -1;
			else if(this.x > arg0.x)return 1;
			return 0;
		}
	}
}
