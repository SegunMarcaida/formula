package math;

import edu.austral.ingsis.math.visitor.*;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
public class ListVariablesTest {
    final private static OperandVisitor<List<String>> visitor = new ListVariableVisitor();

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {
        final List<String> result = visitor.visitSum(new SumOperand(new NumberOperand(1.0), new NumberOperand(6.0)));
        assertThat(result, empty());

        assertThat(result, empty());
    }

    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {
        final List<String> result = visitor.visitDiv(new DivOperand(new NumberOperand(12.0), new VariableOperand("div")));

        assertThat(result, containsInAnyOrder("div"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {
        final List<String> result = visitor.visitMulti(new MultiOperand(new DivOperand(new NumberOperand(9.0), new VariableOperand("x")), new VariableOperand("y")));

        assertThat(result, containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {
        final List<String> result = visitor.visitPow(new PowOperand(new DivOperand(new NumberOperand(27.0), new VariableOperand("a")), new VariableOperand("b")));

        assertThat(result, containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariableOperandsFunction5() {
        final List<String> result = visitor.visitPow(new PowOperand(new VariableOperand("z"), new DivOperand(new NumberOperand(1.0), new NumberOperand(2.0))));

        assertThat(result, containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {
        final List<String> result = visitor.visitSub(new SubOperand(new AbsOperand(new VariableOperand("value")), new NumberOperand(8.0)));
        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction7() {
        final List<String> result = visitor.visitSub(new SubOperand(new NumberOperand(8.0), new AbsOperand(new VariableOperand("value"))));

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {
        final List<String> result = visitor.visitMulti(new MultiOperand(new SubOperand(new NumberOperand(5.0), new VariableOperand("i")), new NumberOperand(8.0)));

        assertThat(result, containsInAnyOrder("i"));
    }
}