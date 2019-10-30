import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class VectorTest {

	@Test
	public void testAddData() {
		double[] data = {1.0, 2.0, 3.0};
		Vector vector = new Vector(3);
		vector.addData(data);
		assertEquals(Arrays.toString(vector.getData()), Arrays.toString(data));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidLength() {
		double[] data = {1.0, 2.0, 3.0};
		Vector vector = new Vector(4);
		vector.addData(data);		
	}
	
	@Test
	public void testInnerProduct() {
		Vector vector1 = new Vector(3, new double[]{1.0, 1.0, 2.0});
		Vector vector2 = new Vector(3, new double[]{1.0, 3.0, 1.0});
		double innerProductActual = vector1.innerProduct(vector2);
		assertEquals(1.0 * 1.0 + 1.0 * 3.0 + 2.0 * 1.0, innerProductActual, 0.000001);
	}
	
	@Test
	public void testAddVectors() {
		Vector vector1 = new Vector(3, new double[]{1.0, 1.0, 2.0});
		Vector vector2 = new Vector(3, new double[]{1.0, 3.0, 1.0});
		Vector resultActual = vector1.addVectors(vector2, 2.0);
		double[] resultExpected = {3.0, 7.0, 4.0};
		assertArrayEquals(resultExpected, resultActual.getData(), 0.000001);		
	}
	
	@Test
	public void multiplyByScalar() {
		double[] data1 = {1.0, 0.0, 2.0};
		Vector vector1 = new Vector(3, data1);
		double alpha = 2.0;
		Vector resultActual = vector1.multiplyByScalar(alpha);
		double[] resultExpected = {2.0, 0.0, 4.0};
		assertArrayEquals(resultExpected, resultActual.getData(), 0.000001);	
	}

}