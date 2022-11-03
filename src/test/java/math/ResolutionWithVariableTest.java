package math;

import edu.austral.ingsis.math.visitor.*;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionWithVariableTest {

    /**
     * Case 1 + x where x = 3
     */
    @Test
    public void shouldResolveFunction1() {
        final OperandVisitor<Double> visitor = new CalculateVisitor(Map.of("x",3d));
        final Double result = visitor.visitSum(new SumOperand(new NumberOperand(1.0), new VariableOperand("x")));


        assertThat(result, equalTo(4d));
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    public void shouldResolveFunction2() {
        final OperandVisitor<Double> visitor = new CalculateVisitor(Map.of("div",4d));
        final Double result = visitor.visitDiv(new DivOperand(new NumberOperand(12.0), new VariableOperand("div")));

        assertThat(result, equalTo(3d));
    }

    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    public void shouldResolveFunction3() {
        final OperandVisitor<Double> visitor = new CalculateVisitor(Map.of("x",3d,"y",4d));
        final Double result = visitor.visitMulti(new MultiOperand(new Parenthesis(new DivOperand(new NumberOperand(9.0), new VariableOperand("x"))), new VariableOperand("y")));

        assertThat(result, equalTo(12d));
    }

    /**
     * Case (27 / a) ^ b where a = 9 and b = 3
     */
    @Test
    public void shouldResolveFunction4() {
        final OperandVisitor<Double> visitor = new CalculateVisitor(Map.of("a",9d,"b",3d));
        final Double result = visitor.visitPow(new PowOperand(new Parenthesis(new DivOperand(new NumberOperand(27.0), new VariableOperand("a"))), new VariableOperand("b")));

        assertThat(result, equalTo(27d));
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    public void shouldResolveFunction5() {
        final OperandVisitor<Double> visitor = new CalculateVisitor(Map.of("z",36d));
        final Double result = visitor.visitPow(new PowOperand(new VariableOperand("z"), new DivOperand(new NumberOperand(1.0), new NumberOperand(2.0))));

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction6() {
        final OperandVisitor<Double> visitor = new CalculateVisitor(Map.of("value",8d));
        final Double result = visitor.visitSub(new SubOperand(new AbsOperand(new VariableOperand("value")), new NumberOperand(8.0)));

        assertThat(result, equalTo(0d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction7() {
        final OperandVisitor<Double> visitor = new CalculateVisitor(Map.of("value",8d));
        final Double result = visitor.visitSub(new SubOperand(new AbsOperand(new VariableOperand("value")), new NumberOperand(8.0)));

        assertThat(result, equalTo(0d));
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    public void shouldResolveFunction8() {
        final OperandVisitor<Double> visitor = new CalculateVisitor(Map.of("i",2d));
        final Double result = visitor.visitMulti(new MultiOperand(new Parenthesis(new SubOperand(new NumberOperand(5.0), new VariableOperand("i"))), new NumberOperand(8.0)));

        assertThat(result, equalTo(24d));
    }
}