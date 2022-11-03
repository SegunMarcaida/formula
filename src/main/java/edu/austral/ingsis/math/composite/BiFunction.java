package edu.austral.ingsis.math.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BiFunction implements Operand{
    private  final Operand firstOperand;
    private final   Operand secondOperand;
   private final BiOperator operator;

    public BiFunction(Operand firstOperand, Operand secondOperand, BiOperator operator) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operator = operator;
    }

    @Override
    public Double getValue(Map<String, Double> variables) throws Exception {
        return operator.calculate( firstOperand, secondOperand ,variables);
    }

    @Override
    public List<String> listVariables() {
        List<String> variables = new ArrayList<>();
        variables.addAll(firstOperand.listVariables());
        variables.addAll(secondOperand.listVariables());

        return variables;
    }

    @Override
    public String print() {
        return firstOperand.print() + operator.getValue() + secondOperand.print() ;
    }
}
