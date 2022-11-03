package edu.austral.ingsis.math.composite;

import java.util.Map;

import static java.lang.Math.abs;

public enum MonoOperatorEnum implements MonoOperator{

  ABS{
      @Override
      public Double calculate(Operand operand, Map<String, Double> variables) throws Exception {
          return abs(operand.getValue(variables));
      }

      @Override
      public String getValue() {
          return "|";
      }
  },
    PARENTHESIS{
        @Override
        public Double calculate(Operand operand, Map<String, Double> variables) throws Exception {
            return operand.getValue(variables);
        }

        @Override
        public String getValue() {
            return "(";
        }
    }



}
