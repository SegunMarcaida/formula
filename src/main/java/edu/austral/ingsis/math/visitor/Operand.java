package edu.austral.ingsis.math.visitor;

public interface Operand {
    <T> T accept(OperandVisitor<T> visitor);
}
