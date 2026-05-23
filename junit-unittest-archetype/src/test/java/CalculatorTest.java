
	import org.junit.Test;
	import static org.junit.Assert.*;
public class CalculatorTest {
	




	    Calculator calc = new Calculator();

	    @Test
	    public void testAddition() {
	        assertEquals(10, calc.addition(6, 4));
	        assertEquals(12, calc.addition(6, 6));
	    }

	    @Test
	    public void testSubtraction() {
	        assertEquals(2, calc.subtraction(6, 4));
	        assertEquals(2, calc.subtraction(8, 6));
	    }

	    @Test
	    public void testMultiplication() {
	        assertEquals(24, calc.multiplication(6, 4));
	        assertEquals(32, calc.multiplication(8, 4));

	    }

	    @Test
	    public void testDivision() {
	        assertEquals(1.5, calc.division(3, 2), 0.001);
	        assertEquals(0, calc.division(2, 2), 2);

	    }

	    @Test(expected = ArithmeticException.class)
	    public void testDivisionByZero() {
	        calc.division(5, 0);
	        calc.division(10, 0);

	        
	    }
	}


