import java.util.Arrays;
import java.util.Random;

public class Vector {

	private double[] data; 
	private int numElements; 
	
	public Vector(int size) {
		this.data = new double[size];
		this.numElements = size;
	}
	
	public Vector(int size, double[] data) {
		this.data = new double[size];
		this.numElements = size;
		this.addData(data);
	}
	
	// populates data with random floating point values
	// in the range 0.0 to 1.0
	public void addRandomData() {
		Random rand = new Random();
		for (int i = 0; i < data.length; i++) {
			data[i] = rand.nextDouble();
		}
	}
	
	// copies the data values
	// throws exception if lengths are not the same
	public void addData(double[] data) {
		if (data.length != this.numElements) {
			throw new IllegalArgumentException("data size mismatch, should be " + 
						this.numElements + ", is " + data.length);
		}
		for (int i = 0; i < this.numElements; i++) {
			this.data[i] = data[i];
		}
	}
	
	// returns the result of the inner product of this
	// vector with other
	// throws exception if lengths are not the same
	public double innerProduct(Vector other) {
		if (other.numElements != this.numElements) {
			throw new IllegalArgumentException("data size mismatch, should be " + 
						this.numElements + ", is " + other.numElements);
		}
		double result = 0.0;
		for (int i = 0; i < this.numElements; i++) {
			result += this.data[i] * other.data[i];
		}
		return result;
	}
	
	// returns the length 
	public double getLength() {
		return this.innerProduct(this); 
	}
	
	// normalizes this Vector, in other words, modifies
	// the elements so that the length of the Vector is 1
	public void normalize() {
		double sum = 0.0;
		for (int i = 0; i < this.numElements; i++) {
			sum += Math.pow(data[i], 2); 
		}
		if (Double.compare(sum, 0.0) == 0) {  
			throw new ArithmeticException("data elements are zero, can't normalize");
		}
		for (int i = 0; i < this.numElements; i++) {
			data[i] /= Math.sqrt(sum); 
		}		
	}
	
	// returns a new Vector of the value this + alpha * other
	public Vector addVectors(Vector other, double alpha) {
		if (other.data.length != this.numElements) {
			throw new IllegalArgumentException("data size mismatch, should be " + 
						this.numElements + ", is " + other.data.length);
		}
		Vector result = new Vector(data.length);
		for (int i = 0; i < data.length; i++) {
			result.data[i] = this.data[i] + other.data[i] * alpha; 
		}
		return result;
	}
	
	public Vector multiplyByScalar(double alpha) {
		Vector result = new Vector(this.numElements);
		for (int i = 0; i < this.numElements; i++) {
			result.data[i] = this.data[i] * alpha;
		}
		return result;
	}
	
	public double[] getData() {
		return this.data.clone();
	}
	
	public Vector makeCopy() {
		return new Vector(this.numElements, this.getData());
	}
	
	public String toString() {
		return Arrays.toString(this.data);
	}
	
}
