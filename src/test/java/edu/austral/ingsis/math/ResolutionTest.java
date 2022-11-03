package edu.austral.ingsis.math;

import edu.austral.ingsis.math.composite.BiFunction;
import edu.austral.ingsis.math.composite.BiOperatorEnum;
import edu.austral.ingsis.math.composite.MonoFunction;
import edu.austral.ingsis.math.composite.Number;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static edu.austral.ingsis.math.composite.BiOperatorEnum.*;
import static edu.austral.ingsis.math.composite.MonoOperatorEnum.ABS;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() throws Exception {
        BiOperatorEnum sum = SUM;
       Map<String, Double> variables = new HashMap<>();
        final Double result = new BiFunction(new Number(1.0),new Number(6.0), SUM).getValue(variables);

        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() throws Exception {
        BiOperatorEnum div = DIV;
        Map<String, Double> variables = new HashMap<>();

        final Double result =  new BiFunction(new Number(12.0),new Number(2.0), DIV).getValue(variables);
        ;

        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() throws Exception {
        Map<String, Double> variables = new HashMap<>();
        final Double result =  new BiFunction( new BiFunction(new Number(9.0),new Number(2.0), DIV),new Number(3.0),MULTI).getValue(variables);

        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() throws Exception {
        Map<String, Double> variables = new HashMap<>();
        final Double result = new BiFunction(new BiFunction(new Number(27.0), new Number(6.0),DIV), new Number(2.0),POW).getValue(variables);

        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() throws Exception {
        Map<String, Double> variables = new HashMap<>();

        final Double result =  new BiFunction(new Number(36.0) ,new BiFunction(new Number(1.0),new Number(2.0), DIV),POW).getValue(variables);

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() throws Exception {
        Map<String, Double> variables = new HashMap<>();

        final Double result =  new MonoFunction(new Number(136.0),ABS).getValue(variables);
        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() throws Exception {
        Map<String, Double> variables = new HashMap<>();

        final Double result =  new MonoFunction(new Number(-136.0),ABS).getValue(variables);

        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() throws Exception {
        Map<String, Double> variables = new HashMap<>();
        final Double result =  new BiFunction(new BiFunction(new Number(5.0), new Number(5.0),SUB),new Number(8.0),MULTI).getValue(variables);
        assertThat(result, equalTo(0d));
    }
}
