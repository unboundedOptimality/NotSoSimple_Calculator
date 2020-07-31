package com.example.notsosimple_calculator;

/**
 * A nonterminal in the machine Infix2BigDecimal
 *
 * @author Tao Yan
 * @version July 2020
 */
import java.math.BigDecimal;
import java.util.List;

public class I2BDNonterminal implements CFGNonterminal {

    // symbol it represents
    private char symbol;
    // two of its operands as arguments for its innate lambda function
    public List<BigDecimal> operands;

    // I2BDNonterminal Associations
    private Infix2BigDecimal infix2BigDecimal;


    // CONSTRUCTOR
    public I2BDNonterminal(char aSymbol, List<BigDecimal> aOperands, Infix2BigDecimal aInfix2BigDecimal) {
        this.symbol = aSymbol;
        this.operands = aOperands;

        this.infix2BigDecimal = aInfix2BigDecimal;

    }


    // From interface CFGNonterminal
    public boolean setSymbol(char aSymbol) {
        boolean wasSet = false;
        symbol = aSymbol;
        wasSet = true;
        return wasSet;
    }

    public char getSymbol() {
        return symbol;
    }

    // Association
    public Infix2BigDecimal getInfix2BigDecimal() {
        return infix2BigDecimal;
    }

    // Association
    public boolean setInfix2BigDecimal(Infix2BigDecimal aInfix2BigDecimal) {
        boolean wasSet = false;
        if (aInfix2BigDecimal == null) {
            return wasSet;
        }

        Infix2BigDecimal existingInfix2BigDecimal = infix2BigDecimal;
        infix2BigDecimal = aInfix2BigDecimal;
        if (existingInfix2BigDecimal != null && !existingInfix2BigDecimal.equals(aInfix2BigDecimal)) {
            existingInfix2BigDecimal.removeI2BDNonterminal(this);
        }
        infix2BigDecimal.addI2BDNonterminal(this);
        wasSet = true;
        return wasSet;
    }

    @Override
    public Object lambda() throws FormalLanguageProcessingMachineException {
        switch (this.symbol) {
            case '+' :
                if (!(this.operands.size() == 2)) {
                    throw new FormalLanguageProcessingMachineException();
                } else {
                    return this.operands.get(0).add(this.operands.get(1));
                }
            case '-' :
                if (!(this.operands.size() == 2)) {
                    throw new FormalLanguageProcessingMachineException();
                } else {
                    return this.operands.get(0).subtract(this.operands.get(1));
                }
            case '*' :
                if (!(this.operands.size() == 2)) {
                    throw new FormalLanguageProcessingMachineException();
                } else {
                    return this.operands.get(0).multiply(this.operands.get(1));
                }
            case '/' :
                if (!(this.operands.size() == 2)) {
                    throw new FormalLanguageProcessingMachineException();
                } else {
                    return this.operands.get(0).divide(this.operands.get(1));
                }
        }
        throw new FormalLanguageProcessingMachineException();
    }

    public String toString() {
        return super.toString() + "[" + "symbol" + ":" + getSymbol() + "]"
                + System.getProperties().getProperty("line.separator") + "  " + "infix2BigDecimal = "
                + (getInfix2BigDecimal() != null ? Integer.toHexString(System.identityHashCode(getInfix2BigDecimal()))
                : "null");
    }
}