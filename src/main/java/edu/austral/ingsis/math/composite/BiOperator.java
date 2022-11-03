package edu.austral.ingsis.math.composite;

import java.util.Map;

public interface BiOperator {
    public Double calculate(Operand operand1, Operand operand2, Map<String, Double> variables) throws Exception;
    public char getValue();
}
