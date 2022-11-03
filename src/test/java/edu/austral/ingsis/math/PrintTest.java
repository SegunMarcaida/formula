package edu.austral.ingsis.math;

import edu.austral.ingsis.math.composite.BiFunction;
import edu.austral.ingsis.math.composite.MonoFunction;
import edu.austral.ingsis.math.composite.Number;
import edu.austral.ingsis.math.composite.Variable;
import org.junit.Test;

import static edu.austral.ingsis.math.composite.BiOperatorEnum.*;
import static edu.austral.ingsis.math.composite.MonoOperatorEnum.ABS;
import static edu.austral.ingsis.math.composite.MonoOperatorEnum.PARENTHESIS;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        final String expected = new BiFunction(new Number(1.0),new Number(1.0),SUM).print();

        assertThat(expected, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        final String expected =  new BiFunction(new Number(12.0),new Number(2.0),DIV).print();

        assertThat(expected, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        final String expected = "(9.0/2.0)*3.0";
        final String result = new BiFunction(new MonoFunction(new BiFunction(new Number(9.0),new Number(2.0),DIV),PARENTHESIS),new Number(3.0),MULTI).print() ;

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        final String expected = "(27.0/6.0)^2.0";
        final String result =  new BiFunction(new MonoFunction(new BiFunction(new Number(27.0),new Number(6.0),DIV),PARENTHESIS),new Number(2.0),POW).print() ;


        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        final String expected = "|value|-8.0";
        final String result = new BiFunction(new MonoFunction(new Variable("value"),ABS),new Number(8.0),SUB).print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value|-8
     */
    @Test
    public void shouldPrintFunction7() {
        final String expected = "|value|-8.0";
        final String result = new BiFunction(new MonoFunction(new Variable("value"),ABS),new Number(8.0),SUB).print();
        assertThat(result, equalTo(expected));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        final String expected = "(5.0-i)*8.0";
        final String result = new BiFunction(new MonoFunction(new BiFunction(new Number(5.0),new Variable("i"),SUB),PARENTHESIS),new Number(8.0),MULTI).print() ;


        assertThat(result, equalTo(expected));
    }
}
