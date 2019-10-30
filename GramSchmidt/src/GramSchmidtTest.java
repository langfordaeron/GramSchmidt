import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GramSchmidtTest {

	@Test
	public void testKhanExampleSmall() {
		List<Vector> vectors = new ArrayList<Vector>();		
		vectors.add(new Vector(4, new double[]{0, 0, 1, 1}));
		vectors.add(new Vector(4, new double[]{0, 1, 1, 0}));
		vectors.add(new Vector(4, new double[]{1, 1, 0, 0}));

		List<Vector> resultActual = GramSchmidt.gramSchmidt(vectors);
		List<Vector> resultExpected = new ArrayList<Vector>();
		resultExpected.add(new Vector(4, new double[]{0, 0, 1 / Math.sqrt(2), 1 / Math.sqrt(2)}));
		resultExpected.add(new Vector(4, new double[]{0, Math.sqrt(2.0 / 3.0), 0.5 * Math.sqrt(2.0 / 3.0), -0.5 * Math.sqrt(2.0 / 3.0)}));
		resultExpected.add(new Vector(4, new double[]{3 * (1 / (2 * Math.sqrt(3))), 
				1 / (2 * Math.sqrt(3)), -1 / (2 * Math.sqrt(3)), 1 / (2 * Math.sqrt(3))}));

		for (int i = 0; i < 3; i++) {
			assertArrayEquals(resultExpected.get(i).getData(), resultActual.get(i).getData(), 0.0000000000001);				
		}
	}
	
	@Test
	public void testKhanExampleLarger() {
		List<Vector> vectors = new ArrayList<Vector>();		
		vectors.add(new Vector(4, new double[]{1, 2, 3, 4}));
		vectors.add(new Vector(4, new double[]{1, 1, 2, 3}));
		vectors.add(new Vector(4, new double[]{-3, 0, 2, 1}));
		vectors.add(new Vector(4, new double[]{2, 4, 1, -2}));

		
		List<Vector> resultActual = GramSchmidt.gramSchmidt(vectors);
		List<Vector> resultExpected = new ArrayList<Vector>();
		resultExpected.add(new Vector(4, new double[]{1 / Math.sqrt(30), 2  / Math.sqrt(30),
				3 / Math.sqrt(30), 4 / 1 / Math.sqrt(30)}));
		resultExpected.add(new Vector(4, new double[]{Math.sqrt(10.0 / 3.0) * (3.0 / 10.0),
				Math.sqrt(10.0 / 3.0) * (- 2.0 / 5.0), Math.sqrt(10.0 / 3.0) * (-1.0 / 10.0), Math.sqrt(10.0 / 3.0) * (1.0 / 5.0)}));
		resultExpected.add(new Vector(4, new double[]{Math.sqrt(3.0 / 29.0) * (-7.0 / 3.0), 
				Math.sqrt(3.0 / 29.0) * (-5.0 / 3.0), Math.sqrt(3.0 / 29.0), Math.sqrt(3.0 / 29.0) * (2.0 / 3.0)}));
		resultExpected.add(new Vector(4, new double[]{Math.sqrt(29.0 / 3.0) * (15.0 / (29.0 * 5)), 
				Math.sqrt(29.0 / 3.0) * (-10.0 / (29.0 * 5.0)), Math.sqrt(29.0 / 3.0) * (35.0 / (29.0 * 5.0)),
				Math.sqrt(29.0 / 3.0) * (-25.0 / (29.0 * 5.0))}));

		for (int i = 0; i < 4; i++) {
			assertArrayEquals(resultExpected.get(i).getData(), resultActual.get(i).getData(), 0.0000000000001);				
		}
	}
	
	@Test
	public void testKhanExampleSmallModified() {
		List<Vector> vectors = new ArrayList<Vector>();		
		vectors.add(new Vector(4, new double[]{0, 0, 1, 1}));
		vectors.add(new Vector(4, new double[]{0, 1, 1, 0}));
		vectors.add(new Vector(4, new double[]{1, 1, 0, 0}));

		List<Vector> resultActual = GramSchmidt.gramSchmidtModified(vectors);
		List<Vector> resultExpected = new ArrayList<Vector>();
		resultExpected.add(new Vector(4, new double[]{0, 0, 1 / Math.sqrt(2), 1 / Math.sqrt(2)}));
		resultExpected.add(new Vector(4, new double[]{0, Math.sqrt(2.0 / 3.0), 0.5 * Math.sqrt(2.0 / 3.0), -0.5 * Math.sqrt(2.0 / 3.0)}));
		resultExpected.add(new Vector(4, new double[]{3 * (1 / (2 * Math.sqrt(3))), 
				1 / (2 * Math.sqrt(3)), -1 / (2 * Math.sqrt(3)), 1 / (2 * Math.sqrt(3))}));

		for (int i = 0; i < 3; i++) {
			assertArrayEquals(resultExpected.get(i).getData(), resultActual.get(i).getData(), 0.0000000000001);				
		}
	}
	
	@Test
	public void testKhanExampleLargerModified() {
		List<Vector> vectors = new ArrayList<Vector>();		
		vectors.add(new Vector(4, new double[]{1, 2, 3, 4}));
		vectors.add(new Vector(4, new double[]{1, 1, 2, 3}));
		vectors.add(new Vector(4, new double[]{-3, 0, 2, 1}));
		vectors.add(new Vector(4, new double[]{2, 4, 1, -2}));

		List<Vector> resultActual = GramSchmidt.gramSchmidtModified(vectors);
		List<Vector> resultExpected = new ArrayList<Vector>();
		resultExpected.add(new Vector(4, new double[]{1 / Math.sqrt(30), 2  / Math.sqrt(30),
				3 / Math.sqrt(30), 4 / 1 / Math.sqrt(30)}));
		resultExpected.add(new Vector(4, new double[]{Math.sqrt(10.0 / 3.0) * (3.0 / 10.0),
				Math.sqrt(10.0 / 3.0) * (- 2.0 / 5.0), Math.sqrt(10.0 / 3.0) * (-1.0 / 10.0), Math.sqrt(10.0 / 3.0) * (1.0 / 5.0)}));
		resultExpected.add(new Vector(4, new double[]{Math.sqrt(3.0 / 29.0) * (-7.0 / 3.0), 
				Math.sqrt(3.0 / 29.0) * (-5.0 / 3.0), Math.sqrt(3.0 / 29.0), Math.sqrt(3.0 / 29.0) * (2.0 / 3.0)}));
		resultExpected.add(new Vector(4, new double[]{Math.sqrt(29.0 / 3.0) * (15.0 / (29.0 * 5)), 
				Math.sqrt(29.0 / 3.0) * (-10.0 / (29.0 * 5.0)), Math.sqrt(29.0 / 3.0) * (35.0 / (29.0 * 5.0)),
				Math.sqrt(29.0 / 3.0) * (-25.0 / (29.0 * 5.0))}));

		for (int i = 0; i < 4; i++) {
			assertArrayEquals(resultExpected.get(i).getData(), resultActual.get(i).getData(), 0.0000000000001);				
		}
	}

}
