import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {
	/** A small tolerance for floating point round-off (precision) error. */
	static final double TOL = 1.0E-6;
	
	@Test
	public void testAverageTinyArray() {
		double[] x = { 123.01 };
		assertEquals( x[0], Statistics.average(x), TOL);
		double[] y = { 123.01, 123.02 };
		assertEquals( 123.015, Statistics.average(y), TOL);
	}
	
	@Test
	public void testAverageMixedValues() {
		double[] x = new double[99];
		java.util.Arrays.fill(x, 12.5);
		assertEquals( 12.5, Statistics.average(x), TOL);
		// many values spaced around a known mean
		double avg = 1.125;
		int n = x.length;
		java.util.Arrays.fill(x, avg);
		for(int k=0; k<=n/2; k++) {
			x[k] -= 0.5*k;
			x[n-k-1] += 0.5*k;
		}
		assertEquals( avg, Statistics.average(x), TOL);
	}
	
	@Test
	public void testAverageArrayEmpty() {
		double[] x = new double[0];
		assertEquals(0, Statistics.average(x), TOL);
	}
	
	@Test
	public void testAverageLargeArray() {
		double[] x = new double[1000];
		java.util.Arrays.fill(x, 123.8);
		assertEquals(123.8, Statistics.average(x), TOL);
	}
	
	@Test
	public void testAverageDifferentValue() {
		double[] x = new double[5];
		x[0] = 10.5;
		x[1] = 2001.3;
		x[2] = 300.24;
		x[3] = 9845.9;
		x[4] = 1243.77;
		assertEquals(2680.342, Statistics.average(x), TOL);
	}	
	
	@Test
	public void testVarianceTinyArray() {
		double[] x = {123.01, 234.56};
		assertEquals(3110.850625, Statistics.variance(x), TOL);
		
		double[] y = {777.9};
		assertEquals(0, Statistics.variance(y), TOL);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testVarianceArrayEmpty() {
		Statistics.variance(new double[0]);
	}
	
	@Test
	public void testTinyCovariance() {
		double[] x = {123.4, 456.7};
		double[] y = {650.2, 244.2};
		
		assertEquals(-67659.9, Statistics.covariance(x, y), TOL);
		
		double[] a = {985.1, 1002.7};
		double[] b = {203.45, 20.9};
		
		assertEquals(-1606.44, Statistics.covariance(a, b), TOL);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConvarianceException() {
		double[] x = new double[2];
		double[] y = new double[5];
		Statistics.covariance(x, y);
		
		java.util.Arrays.fill(x, 15.3);
		Statistics.covariance(x, new double[0]);
		
		java.util.Arrays.fill(y, 24.1);
		Statistics.covariance(new double[0], y);
	}

}
