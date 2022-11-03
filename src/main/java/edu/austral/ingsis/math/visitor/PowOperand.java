package edu.austral.ingsis.math.visitor;

public class PowOperand implements Visitable,Operand {
    private final Operand operand1;
    private final Operand operand2;

    public PowOperand(Operand operand1,Operand operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    @Override
    public <T> T accept(OperandVisitor<T> visitor) {
        return visitor.visitPow(this);
    }

    public Operand getOperand1() {
        return operand1;
    }
    public Operand getOperand2() {
        return operand2;
    }
}
