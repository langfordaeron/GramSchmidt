import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class GramSchmidtTestVisual {
	
	public static int NUM_VECTORS = 50;
	public static int VECTOR_SIZE = 50; 
	
	public static void main(String[] args) {
		
		//printGramSchmidtMatrix();
		printGramSchmidtMatrixModified();
		
	}
	
	// prints a matrix of size VECTOR_SIZE x NUM_VECTORS with each 
	// element being the inner product of each vector from the result of 
	// Gram Schmidt times 10^{10} 
	public static void printGramSchmidtMatrix() {
		System.out.println("Regular Gram Schmidt");
		List<Vector> vectors = populateRandomVectors();
		List<Vector> result = GramSchmidt.gramSchmidt(vectors);
		double[][] matrix = populateMatrixTest(result);
		printMatrix(matrix);
	}

	// prints a matrix of size VECTOR_SIZE x NUM_VECTORS with each 
	// element being the inner product of each vector from the result of 
	// Modified Gram Schmidt times 10^{10} 
	public static void printGramSchmidtMatrixModified() {
		System.out.println("Modified Gram Schmidt");
		List<Vector> vectors = populateRandomVectors();
		List<Vector> result = GramSchmidt.gramSchmidtModified(vectors);
		double[][] matrix = populateMatrixTest(result);
		printMatrix(matrix);
	}
	
	public static List<Vector> populateRandomVectors() {
		List<Vector> vectors = new ArrayList<Vector>();	
		for (int i = 0; i < NUM_VECTORS; i++) {
			vectors.add(new Vector(VECTOR_SIZE)); 
			vectors.get(i).addRandomData();
		}
		return vectors;
	}
	
	public static double[][] populateMatrixTest(List<Vector> result) {
		double[][] matrix = new double[NUM_VECTORS][VECTOR_SIZE];
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.size(); j++) {
				matrix[i][j] = result.get(i).innerProduct(result.get(j));
			}
		}
		return matrix;
	}
	
	public static void printMatrix(double[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
		        DecimalFormat df = new DecimalFormat("####0.0000");
		        System.out.print(Double.parseDouble(df.format(Math.abs(matrix[i][j] * Math.pow(10, 11)))) + "\t");
			    //System.out.printf("%4f\t", (matrix[i][j]) * Math.pow(10, 10));
			}
			System.out.println();
		}
	}
}
