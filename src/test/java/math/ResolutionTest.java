package math;

import edu.austral.ingsis.math.visitor.*;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionTest {
    private final static OperandVisitor<Double> visitor = new CalculateVisitor();
    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {
        final Double result = visitor.visitSum(new SumOperand(new NumberOperand(1.0), new NumberOperand(6.0)));
        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        final Double result = visitor.visitDiv(new DivOperand(new NumberOperand(12.0), new NumberOperand(2.0)));

        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        final Double result = visitor.visitMulti(new MultiOperand(new Parenthesis(new DivOperand(new NumberOperand(9.0), new NumberOperand(2.0))), new NumberOperand(3.0)));

        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        final Double result = visitor.visitPow(new PowOperand(new Parenthesis(new DivOperand(new NumberOperand(27.0), new NumberOperand(6.0))), new NumberOperand(2.0)));

        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        final Double result = visitor.visitPow(new PowOperand(new NumberOperand(36.0), new Parenthesis( new DivOperand(new NumberOperand(1.0), new NumberOperand(2.0)))));

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        final Double result = visitor.visitAbs(new AbsOperand(new NumberOperand(136.0)));

        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        final Double result = visitor.visitAbs(new AbsOperand(new NumberOperand(-136.0)));

        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        final Double result = visitor.visitMulti(new MultiOperand(new Parenthesis(new SubOperand(new NumberOperand(5.0), new NumberOperand(5.0))), new NumberOperand(8.0)));

        assertThat(result, equalTo(0d));
    }
}
