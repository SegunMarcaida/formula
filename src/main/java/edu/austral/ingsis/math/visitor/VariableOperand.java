package edu.austral.ingsis.math.visitor;

public class VariableOperand implements Visitable,Operand {
    private  final  String value;

    public VariableOperand(String value) {
        this.value = value;
    }

    @Override
    public <T> T accept(OperandVisitor<T> visitor) {
        return visitor.visitVariable(this);
    }

    public String getVariable() {
        return value;
    }
}
