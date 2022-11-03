package edu.austral.ingsis.math.visitor;

import java.util.Map;

public class CalculateVisitor implements OperandVisitor<Double>{
    private final Map<String, Double> variables;
    public CalculateVisitor(Map<String, Double> variables) {
        this.variables = variables;
    }
    public CalculateVisitor() {
        this(Map.of());
    }
    @Override
    public Double visitSum(SumOperand operand) {
        return operand.getOperand1().accept(this) + operand.getOperand2().accept(this);
    }

    @Override
    public Double visitSub(SubOperand operand) {
        return operand.getOperand1().accept(this) - operand.getOperand2().accept(this);

    }

    @Override
    public Double visitMulti(MultiOperand operand) {
        return operand.getOperand1().accept(this) * operand.getOperand2().accept(this);
    }

    @Override
    public Double visitDiv(DivOperand operand) {
        return operand.getOperand1().accept(this) / operand.getOperand2().accept(this);
    }

    @Override
    public Double visitPow(PowOperand operand) {
        return Math.pow(operand.getOperand1().accept(this) ,operand.getOperand2().accept(this));
    }

    @Override
    public Double visitRoot(RootOperand operand) {
        return Math.sqrt(operand.getOperand().accept(this));
    }

    @Override
    public Double visitAbs(AbsOperand operand) {
        return Math.abs(operand.getOperand().accept(this));
    }

    @Override
    public Double visitParenthesis(Parenthesis operand) {
        return operand.getOperand().accept(this);
    }

    @Override
    public Double visitNumber(NumberOperand operand) {
        return operand.getNumber();
    }

    @Override
    public Double visitVariable(VariableOperand operand) {
        return  this.variables.get(operand.getVariable());
    }
}
