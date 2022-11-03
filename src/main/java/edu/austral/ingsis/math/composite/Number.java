package edu.austral.ingsis.math.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Number implements Operand {
    private final Double value;

    public Number(Double value) {
        this.value = value;
    }

    @Override
    public Double getValue(Map<String, Double> variables) {
        return value;
    }

    @Override
    public List<String> listVariables() {
        return new ArrayList<>();
    }

    @Override
    public String print() {
        return value.toString();
    }
}
