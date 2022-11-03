package edu.austral.ingsis.math.visitor;

public class PrintVisitor implements OperandVisitor<String> {

    @Override
    public String visitSum(SumOperand operand) {
        return operand.getOperand1().accept(this) + " + " + operand.getOperand2().accept(this);
    }

    @Override
    public String visitSub(SubOperand operand) {
        return operand.getOperand1().accept(this) + " - " + operand.getOperand2().accept(this);
    }

    @Override
    public String visitAbs(AbsOperand operand) {
        return "|" + operand.getOperand().accept(this) + "|";
    }

    @Override
    public String visitMulti(MultiOperand operand) {
        return operand.getOperand1().accept(this) + " * " + operand.getOperand2().accept(this);
    }

    @Override
    public String visitDiv(DivOperand operand) {
        return operand.getOperand1().accept(this) + " / " + operand.getOperand2().accept(this);
    }

    @Override
    public String visitPow(PowOperand operand) {
        return operand.getOperand1().accept(this) + " ^ " + operand.getOperand2().accept(this);
    }

    @Override
    public String visitRoot(RootOperand operand) {
         return " √ " + operand.getOperand().accept(this);
    }

    @Override
    public String visitParenthesis(Parenthesis operand) {
        return "(" + operand.getOperand().accept(this) + ")";
    }

    @Override
    public String visitNumber(NumberOperand operand) {
        if (operand.getNumber() == Math.floor(operand.getNumber())) {
            return String.format("%d", operand.getNumber().intValue());
        } else {
            return String.format("%s", operand.getNumber());
        }
    }

    @Override
    public String visitVariable(VariableOperand operand) {
        return operand.getVariable();
    }

}
