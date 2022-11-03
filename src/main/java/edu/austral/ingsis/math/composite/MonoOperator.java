package edu.austral.ingsis.math.composite;

import java.util.Map;

public interface MonoOperator {
    public Double calculate(Operand operand, Map<String, Double> variables) throws Exception;
    public String getValue();

}
