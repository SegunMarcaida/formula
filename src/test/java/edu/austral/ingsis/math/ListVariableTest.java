package edu.austral.ingsis.math;

import edu.austral.ingsis.math.composite.BiFunction;
import edu.austral.ingsis.math.composite.MonoFunction;
import edu.austral.ingsis.math.composite.Number;
import edu.austral.ingsis.math.composite.Variable;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static edu.austral.ingsis.math.composite.BiOperatorEnum.*;
import static edu.austral.ingsis.math.composite.MonoOperatorEnum.ABS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ListVariableTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {
        final List<String> result = Collections.emptyList();

        assertThat(result, empty());
    }

    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {
        final List<String> result = new BiFunction(new Number(12.0), new Variable("div"),DIV).listVariables();

        assertThat(result, containsInAnyOrder("div"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {
        final List<String> result = new BiFunction(new BiFunction(new Number(9.0),new Variable("x"),DIV),new Variable("y"),MULTI).listVariables();

        assertThat(result, containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {
        final List<String> result = new BiFunction(new BiFunction(new Number(27.0),new Variable("a"),DIV),new Variable("b"),POW).listVariables();

        assertThat(result, containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariablesFunction5() {
        final List<String> result = new BiFunction(new Variable("z"),new BiFunction(new Number(1.0), new Number(2.0),DIV),POW).listVariables();

        assertThat(result, containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {
        final List<String> result =  new BiFunction(new MonoFunction(new Variable("value"),ABS),new Number(8.0),SUB).listVariables();

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction7() {
        final List<String> result =  new BiFunction(new MonoFunction(new Variable("value"),ABS),new Number(8.0),SUB).listVariables();

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {
        final List<String> result = new BiFunction(new BiFunction(new Number(5.0),new Variable("i"),SUB),new Number(8.0),MULTI).listVariables();

        assertThat(result, containsInAnyOrder("i"));
    }
}
