package edu.austral.ingsis.math.visitor;

public interface OperandVisitor<T> {
    T visitSum(SumOperand operand);
    T visitSub(SubOperand operand);
    T visitMulti(MultiOperand operand);
    T visitDiv(DivOperand operand);
    T visitPow(PowOperand operand);
    T visitRoot(RootOperand operand);
    T visitAbs(AbsOperand operand);
    T visitParenthesis(Parenthesis operand);
    T visitNumber(NumberOperand operand);
    T visitVariable(VariableOperand operand);
}
