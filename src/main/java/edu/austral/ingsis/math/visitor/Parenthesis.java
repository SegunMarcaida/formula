package edu.austral.ingsis.math.visitor;

public class Parenthesis implements Visitable,Operand {

    private final Operand operand;

    public Parenthesis(Operand operand) {
        this.operand = operand;
    }

    @Override
    public <T> T accept(OperandVisitor<T> visitor) {
        return visitor.visitParenthesis(this);
    }

    public Operand getOperand() {
        return operand;
    }
}
