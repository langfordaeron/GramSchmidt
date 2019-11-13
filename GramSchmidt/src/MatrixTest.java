import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class MatrixTest {

	@Test
	public void testListInit() {
		Vector vector1 = new Vector(3, new double[]{1.0, 1.0, 2.0});
		Vector vector2 = new Vector(3, new double[]{1.0, 3.0, 1.0});
		List<Vector> vectors = new ArrayList<>();
		vectors.add(vector1);
		vectors.add(vector2);
		Matrix matrix1 = new Matrix(2, 3, vectors);
		double[][] matrixData = matrix1.getData();
		double[][] data = {{1.0, 1.0, 2.0}, {1.0, 3.0, 1.0}};
		
		for (int i = 0; i < 2; i++) {
			assertArrayEquals(matrixData[i],  data[i], 1E-10);					
		}
	}
	
	@Test
	public void test2DArrayInit() {
		double[][] data = {{1.0, 1.0, 2.0}, {1.0, 3.0, 1.0}};
		Matrix matrix2 = new Matrix(2, 3, data);
		double[][] matrixData = matrix2.getData();		
		
		for (int i = 0; i < 2; i++) {
			assertArrayEquals(matrixData[i],  data[i], 1E-10);					
		}
	}

	@Test
	public void testTranspose() {
		double[][] data = {{1.0, 1.0, 2.0}, {1.0, 3.0, 1.0}};
		Matrix matrix2 = new Matrix(2, 3, data);
		Matrix transpose = matrix2.getTranspose();
		double[][] matrixTransposeData = transpose.getData();		
		double[][] transposeData = {{1.0, 1.0}, {1.0, 3.0}, {2.0, 1.0}};

		//System.out.println(Arrays.deepToString(matrixTransposeData));
		for (int i = 0; i < 3; i++) {
			assertArrayEquals(matrixTransposeData[i],  transposeData[i], 1E-10);					
		}
	}
	
	@Test
	public void testNorm() {
		double[][] data = {{-1, 2, 5}, {-1, 2, 7}, {23, 4, 12}};
		Matrix matrix = new Matrix(3, 3, data);	
		double norm = matrix.getNorm();
		assertEquals(norm, 27.80287754891568, 1E-10);
	}
	
}
