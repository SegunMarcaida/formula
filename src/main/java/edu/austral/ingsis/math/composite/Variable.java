package edu.austral.ingsis.math.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Variable implements Operand{
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public Double getValue(Map<String, Double> variables) throws Exception {
        Double value = variables.get(name);
        if (value!= null){
            return value;
        }else{
            throw new Exception("variable is not in the map");
        }

    }

    @Override
    public List<String> listVariables() {
        List<String> variables =  new ArrayList<>(List.of(name));
        return variables ;
    }

    @Override
    public String print() {
        return name;
    }
}
