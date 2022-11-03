package edu.austral.ingsis.math.visitor;

public class AbsOperand implements Visitable,Operand {
     private final Operand operand;

    public AbsOperand(Operand operand) {
        this.operand = operand;
    }

    @Override
    public <T> T accept(OperandVisitor<T> visitor) {
        return visitor.visitAbs(this);
    }

    public Operand getOperand() {
        return operand;
    }

}
