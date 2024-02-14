package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Mockery;
import org.jmock.Expectations;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataUtilitiesTest {
	Mockery mockingContext;
	Values2D values;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		// setup
		mockingContext = new Mockery();
		values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				oneOf(values).getColumnCount();
				will(returnValue(4));
				oneOf(values).getRowCount();
				will(returnValue(4));
				oneOf(values).getValue(1, 0);
				will(returnValue(5));
				oneOf(values).getValue(1, 1);
				will(returnValue(5));
				oneOf(values).getValue(1, 2);
				will(returnValue(5));
				oneOf(values).getValue(2, 0);
				will(returnValue(2));
				oneOf(values).getValue(2, 1);
				will(returnValue(-4));
				oneOf(values).getValue(2, 2);
				will(returnValue(2));
			}
		});
	}

	@Test
	public void calculateRowTotalForThreeValues() {
		// exercise
		double result = DataUtilities.calculateRowTotal(values, 1);
		System.out.println("result:" + result);
		// verify
		assertEquals(15, result, .000000001d);
	}
	
	@Test
	public void calculateRowTotalValues() {
		// exercise
		double result = DataUtilities.calculateRowTotal(values, 2);
		System.out.println("result:" + result);
		// verify
		assertEquals(0, result, .000000001d);
	}
	

	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}