package edu.austral.ingsis.math;

import edu.austral.ingsis.math.composite.BiFunction;
import edu.austral.ingsis.math.composite.MonoFunction;
import edu.austral.ingsis.math.composite.Number;
import edu.austral.ingsis.math.composite.Variable;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static edu.austral.ingsis.math.composite.BiOperatorEnum.*;
import static edu.austral.ingsis.math.composite.MonoOperatorEnum.ABS;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionWithVariableTest {

    /**
     * Case 1 + x where x = 3
     */
    @Test
    public void shouldResolveFunction1() throws Exception {
        Map<String, Double> variables = new HashMap<>();
        variables.put("x",3.0);
        final Double result = new BiFunction(new Number(1.0),new Variable("x"),SUM).getValue(variables);

        assertThat(result, equalTo(4d));
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    public void shouldResolveFunction2() throws Exception {
        Map<String, Double> variables = new HashMap<>();
        variables.put("div",4.0);
        final Double result = new BiFunction(new Number(12.0),new Variable("div"),DIV).getValue(variables);

        assertThat(result, equalTo(3d));
    }

    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    public void shouldResolveFunction3() throws Exception {
        Map<String, Double> variables = new HashMap<>();
            variables.put("x",3.0);
            variables.put("y",4.0);
        final Double result = new BiFunction(new BiFunction(new Number(9.0),new Variable("x"),DIV),new Variable("y"),MULTI).getValue(variables);

        assertThat(result, equalTo(12d));
    }

    /**
     * Case (27 / a) ^ b where a = 9 and b = 3
     */
    @Test
    public void shouldResolveFunction4() throws Exception {
        Map<String, Double> variables = new HashMap<>();
        variables.put("a",9.0);
        variables.put("b",3.0);
        final Double result = new BiFunction(new BiFunction(new Number(27.0),new Variable("a"),DIV),new Variable("b"),POW).getValue(variables);

        assertThat(result, equalTo(27d));
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    public void shouldResolveFunction5() throws Exception {
        Map<String, Double> variables = new HashMap<>();
        variables.put("z",36.0);
        final Double result = new BiFunction(new Variable("z"),new BiFunction(new Number(1.0), new Number(2.0),DIV),POW).getValue(variables);

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction6() throws Exception {
        Map<String, Double> variables = new HashMap<>();
        variables.put("value",8.0);
        final Double result =  new BiFunction(new MonoFunction(new Variable("value"),ABS),new Number(8.0),SUB).getValue(variables);

        assertThat(result, equalTo(0d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction7() throws Exception {
        Map<String, Double> variables = new HashMap<>();
        variables.put("value",8.0);
        final Double result =  new BiFunction(new MonoFunction(new Variable("value"),ABS),new Number(8.0),SUB).getValue(variables);


        assertThat(result, equalTo(0d));
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    public void shouldResolveFunction8() throws Exception {
        Map<String, Double> variables = new HashMap<>();
        variables.put("i",2.0);
        final Double result = new BiFunction(new BiFunction(new Number(5.0),new Variable("i"),SUB),new Number(8.0),MULTI).getValue(variables);

        assertThat(result, equalTo(24d));
    }
}
