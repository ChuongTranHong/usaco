/*
 ID: thcbin11
 LANG: JAVA
 TASK: transform
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class transform {
	static int[][] matrixIn;
	static int[][] matrixOut;

	public static void main(String args[]) throws NumberFormatException,
			IOException {
		BufferedReader f = new BufferedReader(new FileReader("transform.in"));
		int numberOfLine = Integer.parseInt(f.readLine());
		String line;
		matrixIn = new int[numberOfLine][numberOfLine];
		matrixOut = new int[numberOfLine][numberOfLine];
		for (int i = 0; i < numberOfLine; i++) {
			line = f.readLine();
			for (int j = 0; j < numberOfLine; j++) {
				if (line.charAt(j) == '@')
					matrixIn[i][j] = 1;
				else
					matrixIn[i][j] = 0;
			}
		}
		for (int i = 0; i < numberOfLine; i++) {
			line = f.readLine();
			for (int j = 0; j < numberOfLine; j++) {
				if (line.charAt(j) == '@')
					matrixOut[i][j] = 1;
				else
					matrixOut[i][j] = 0;
			}
		}
		f.close();
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"transform.out")));
		int[][] test;
		test = rotateMatrix90(matrixIn);
		if (compareMatrix(test)) {
			out.println("1");

		} else {
			test = rotateMatrix90(test);
			if (compareMatrix(test))
				out.println("2");
			else {
				test = rotateMatrix90(test);
				if (compareMatrix(test))
					out.println("3");
				else {
					test = reflection(matrixIn);
					if (compareMatrix(test))
						out.println("4");
					else {
						test = rotateMatrix90(test);
						if (compareMatrix(test))
							out.println("5");
						else {
							test = rotateMatrix90(test);
							if (compareMatrix(test))
								out.println("5");
							else {
								test = rotateMatrix90(test);
								if (compareMatrix(test))
									out.println("5");
								else if (compareMatrix(matrixIn))
									out.println("6");
								else
									out.println("7");
							}
						}
					}
				}
			}
		}
		out.close();
	}

	public static int[][] rotateMatrix90(int[][] matrix) {
		int[][] returnMatrix = new int[matrix.length][matrix.length];
		int n = returnMatrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				returnMatrix[i][j] = matrix[n - j - 1][i];
			}
		}
		return returnMatrix;
	}

	public static int[][] rotateMatrix180(int[][] matrix) {
		int[][] returnMatrix = new int[matrix.length][matrix.length];
		int n = returnMatrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				returnMatrix[i][j] = matrix[n - i - 1][n - j - 1];
			}
		}
		return returnMatrix;
	}

	public static int[][] rotateMatrix270(int[][] matrix) {
		int[][] returnMatrix = new int[matrix.length][matrix.length];
		int n = returnMatrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				returnMatrix[i][j] = matrix[j][n - i - 1];
			}
		}
		return returnMatrix;
	}

	public static int[][] reflection(int[][] matrix) {
		int[][] returnMatrix = new int[matrix.length][matrix.length];
		int n = returnMatrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				returnMatrix[i][j] = matrix[i][n - j - 1];
			}
		}
		return returnMatrix;
	}

	public static boolean compareMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] != matrixOut[i][j])
					return false;
			}
		}
		return true;
	}
}
