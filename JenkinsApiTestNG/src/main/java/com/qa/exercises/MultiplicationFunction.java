package com.qa.exercises;

import com.hstester.function.AbstractFunction;
import com.hstester.function.InvalidVariableException;
import com.hstester.function.Variable;

import java.util.ArrayList;
import java.util.List;

public class MultiplicationFunction extends AbstractFunction {

    private int multiplierA;
    private int multiplierB;

    /*public MultiplicationFunction () {

    }

    public MultiplicationFunction (int multiplierA, int multiplierB) {
        this.multiplierA = multiplierA;
        this.multiplierB = multiplierB;
    }*/

    @Override
    public String execute() {
        int product = multiplierA * multiplierB;
        return Integer.toString(product);
    }

    @Override
    public void setParameters(List<Variable> list) throws InvalidVariableException {
        this.checkParameterCount(list, 0, 100);
        this.multiplierA = list.get(0).getInt();
        this.multiplierB = list.get(1).getInt();
    }

    @Override
    public List<String> getArgumentDesc() {
        return new ArrayList<>(){
            {
                add(new String("数字A"));
                add(new String("数字B"));
            }
        };
    }

    @Override
    public String getReferenceDesc() {
        return "求得两次输入之和";
    }
}
