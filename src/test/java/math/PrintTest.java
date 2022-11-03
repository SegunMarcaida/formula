package math;

import edu.austral.ingsis.math.visitor.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {
    final private static OperandVisitor<String> visitor = new PrintVisitor();

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        final String expected = "1 + 6";
        final String result = visitor.visitSum(new SumOperand(new NumberOperand(1.0), new NumberOperand(6.0)));
        assertThat(result, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        final String result = visitor.visitDiv(new DivOperand(new NumberOperand(12.0), new NumberOperand(2.0)));
        final String expected = "12 / 2";

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        final String expected = "(9 / 2) * 3";
        final String result = visitor.visitMulti(new MultiOperand(new Parenthesis(new DivOperand(new NumberOperand(9.0), new NumberOperand(2.0))), new NumberOperand(3.0)));

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        final String expected = "(27 / 6) ^ 2";
        final String result = visitor.visitPow(new PowOperand(new Parenthesis(new DivOperand(new NumberOperand(27.0), new NumberOperand(6.0))), new NumberOperand(2.0)));

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        final String expected = "|value| - 8";
        final String result = visitor.visitSub(new SubOperand(new AbsOperand(new VariableOperand("value")), new NumberOperand(8.0)));

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction7() {
        final String expected = "|value| - 8";
        final String result = visitor.visitSub(new SubOperand(new AbsOperand(new VariableOperand("value")), new NumberOperand(8.0)));

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        final String expected = "(5 - i) * 8";
        final String result = visitor.visitMulti(new MultiOperand(new Parenthesis(new SubOperand(new NumberOperand(5.0), new VariableOperand("i"))), new NumberOperand(8.0)));

        assertThat(result, equalTo(expected));
    }
}