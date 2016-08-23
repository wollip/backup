package projections;

public class Matrix {
	
	public static void main(String[] args){
		double[][] matrix2 = {{0,3,1}};
		
		//double[][] matrix = {{2},{2},{2}};
		
		double[] angles = angles(matrix2);
		for( int i = 0; i < 3; i++){
			System.out.println(Math.toDegrees(angles[i]));
		}
		
		
		//print(cross);
		
	}
	
	public static boolean add(double[][] matrix, double[][] matrix2){
		if(matrix.length != matrix2.length || matrix[0].length != matrix2[0].length){
			return false;
		}
		for(int r = 0; r< matrix.length; r++){
			for(int c = 0; c<matrix[0].length; c++){
				matrix[r][c]+= matrix2[r][c];
			}
		}
		return true;
	}
	
	public static boolean subtract(double[][] matrix, double[][] matrix2){
		if(matrix.length != matrix2.length || matrix[0].length != matrix2[0].length){
			return false;
		}
		for(int r = 0; r< matrix.length; r++){
			for(int c = 0; c<matrix[0].length; c++){
				matrix[r][c]-= matrix2[r][c];
			}
		}
		return true;
	}

	public static double[][] multiply(double[][] matrix, double[][] matrix2){
		if(matrix[0].length != matrix2.length){
			System.out.println("error");
			double[][] error = new double[1][1];
			error[0][0]= 0;
			return error;
		}
		//System.out.println("no error"+ matrix[0].length  + " " + matrix2.length);
		double[][] ret = new double[matrix.length][matrix2[0].length];
		//System.out.println("ret det" + matrix.length + " " + matrix2[0].length);
		double sum;
		
		for(int c = 0; c < ret[0].length; c++){
			for(int r = 0; r< ret.length; r++){
				sum = 0;
				for(int i = 0; i < matrix2.length; i++){
					sum += matrix[r][i] * matrix2[i][c];
				}
				
				ret[r][c] = sum;
			}
		}
		
		return ret;
	}

	public static double dot(double[][] matrix, double[][] matrix2){
		if(matrix.length != matrix2.length || matrix[0].length != matrix2[0].length){
			System.out.println("there was an error in dot");
			return -1;
		}
		
		double det = 0;
		for(int r = 0; r<matrix.length; r++){
			for(int c = 0; c<matrix[0].length; c++){
				det += matrix[r][c] * matrix2[r][c];
			}
		}
		return det;
	}

	public static double length(double[][] matrix){
		if(matrix.length != 1){
			return -1;
		}
		double length = 0;
		for(int i = 0; i<matrix[0].length; i++){
			length += matrix[0][i] * matrix[0][i];
		}
		return Math.sqrt(length);
	}
	
	// values returned in radians.
	public static double[] angles(double[][] matrix){
		if (matrix.length != 1){
			System.out.println("error in angle");
			double[] error = {0};
			return error;
		}
		double[] angles = new double[matrix[0].length];
		double length = length(matrix);
		for(int i = 0; i< matrix[0].length; i++){
			angles[i] = Math.acos(matrix[0][i] / length);
		}
		return angles;
	}
	
	public static void print(double[][] matrix){
		for(int r = 0; r< matrix.length; r++){
			for(int c = 0; c< matrix[0].length; c++){
				System.out.print(matrix[r][c] + "\t");
			}
			System.out.println();
		}
	}








}
