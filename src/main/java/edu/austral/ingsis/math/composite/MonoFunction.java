package edu.austral.ingsis.math.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MonoFunction implements Operand {
    private final Operand operand;
    private final MonoOperator operator;

    public MonoFunction(Operand operand, MonoOperator operator) {
        this.operand = operand;
        this.operator = operator;
    }

    @Override
    public Double getValue(Map<String, Double> variables) throws Exception {
        return operator.calculate(operand,variables);
    }

    @Override
    public List<String> listVariables() {
        List<String> variables = new ArrayList<>();
        variables.addAll(operand.listVariables());
        return variables;

    }

    @Override
    public String print() {
        if (!Objects.equals(operator.getValue(), "("))
            return operator.getValue() + operand.print() + operator.getValue();
        else
            return "(" + operand.print()  + ")";
    }
}
