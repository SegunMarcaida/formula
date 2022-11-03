package edu.austral.ingsis.math.visitor;

public class RootOperand implements Visitable,Operand {
    private final Operand operand;

    public RootOperand(Operand operand) {
        this.operand = operand;

    }

    @Override
    public <T> T accept(OperandVisitor<T> visitor) {
        return visitor.visitRoot(this);
    }

    public Operand getOperand() {
        return operand;
    }
}
