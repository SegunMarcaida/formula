package edu.austral.ingsis.math.visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListVariableVisitor implements OperandVisitor<List<String>> {
    private final List<String> variables;

    public ListVariableVisitor() {
        this.variables = new ArrayList<>();
    }

    @Override
    public List<String> visitSum(SumOperand operand) {
        return Stream.concat(operand.getOperand1().accept(this).stream(), operand.getOperand2().accept(this).stream()).collect(Collectors.toList());
    }

    @Override
    public List<String> visitSub(SubOperand operand) {
        return Stream.concat(operand.getOperand1().accept(this).stream(), operand.getOperand2().accept(this).stream()).collect(Collectors.toList());
    }

    @Override
    public List<String> visitAbs(AbsOperand operand) {
        return operand.getOperand().accept(this);
    }

    @Override
    public List<String> visitDiv(DivOperand operand) {
        return Stream.concat(operand.getOperand1().accept(this).stream(), operand.getOperand2().accept(this).stream()).collect(Collectors.toList());
    }

    @Override
    public List<String> visitMulti(MultiOperand operand) {
        return Stream.concat(operand.getOperand1().accept(this).stream(), operand.getOperand2().accept(this).stream()).collect(Collectors.toList());
    }

    @Override
    public List<String> visitParenthesis(Parenthesis operand) {
        return operand.getOperand().accept(this);
    }

    @Override
    public List<String> visitNumber(NumberOperand operand) {
        return List.of();

    }

    @Override
    public List<String> visitPow(PowOperand operand) {
        return Stream.concat(operand.getOperand1().accept(this).stream(), operand.getOperand2().accept(this).stream()).collect(Collectors.toList());
    }

    @Override
    public List<String> visitRoot(RootOperand operand) {
        return  operand.getOperand().accept(this);
    }



    @Override
    public List<String> visitVariable(VariableOperand operand) {
        return List.of(operand.getVariable());
    }
}
