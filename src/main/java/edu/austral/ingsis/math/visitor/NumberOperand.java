package edu.austral.ingsis.math.visitor;

public class NumberOperand implements Visitable,Operand {

    private  final  Double value;

    public NumberOperand(Double value) {
        this.value = value;
    }

    @Override
    public <T> T accept(OperandVisitor<T> visitor) {
        return visitor.visitNumber(this);
    }

    public Double getNumber() {
        return value;
    }
}