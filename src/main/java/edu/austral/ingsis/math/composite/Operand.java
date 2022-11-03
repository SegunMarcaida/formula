package edu.austral.ingsis.math.composite;

import java.util.List;
import java.util.Map;

public interface Operand {
     public Double getValue(Map<String, Double> variables) throws Exception;
     public List<String> listVariables();

     public String print();
}
