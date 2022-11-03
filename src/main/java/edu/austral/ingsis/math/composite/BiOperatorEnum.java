package edu.austral.ingsis.math.composite;

import java.util.Map;

public enum BiOperatorEnum implements BiOperator{

    SUM {
        @Override
        public Double calculate(Operand operand1, Operand operand2,Map<String, Double> variables) throws Exception {
            return (operand1.getValue(variables)+ operand2.getValue(variables));
        }

        @Override
        public char getValue() {
            return '+';
        }
    },
    SUB {

        @Override
        public Double calculate(Operand operand1, Operand operand2,Map<String, Double> variables) throws Exception {
            return (operand1.getValue(variables)-operand2.getValue(variables));
        }

        @Override
        public char getValue() {
            return '-' ;
        }
    },
    DIV {
        @Override
        public Double calculate(Operand operand1, Operand operand2,Map<String, Double> variables) throws Exception {
            return (operand1.getValue(variables)/operand2.getValue(variables));
        }

        @Override
        public char getValue() {
            return '/';
        }
    },
    MULTI {

        @Override
        public Double calculate(Operand operand1, Operand operand2, Map<String, Double> variables) throws Exception {
            return (operand1.getValue(variables) * operand2.getValue(variables));
        }

        @Override
        public char getValue() {
            return '*';
        }
    },
    POW {

        @Override
        public Double calculate(Operand operand1, Operand operand2, Map<String, Double> variables) throws Exception {
            return Math.pow(operand1.getValue(variables),operand2.getValue(variables));
        }

        @Override
        public char getValue() {
            return '^';
        }
    };
}
