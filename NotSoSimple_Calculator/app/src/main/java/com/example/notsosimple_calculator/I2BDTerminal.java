package com.example.notsosimple_calculator;

/**
 * A terminal in the machine Infix2BigDecimal
 *
 * @author Tao Yan
 * @version July 2020
 */
public class I2BDTerminal implements CFGTerminal {

    // Symbol it represents
    private char symbol;
    // By association
    private Infix2BigDecimal infix2BigDecimal;


    // CONSTRUCTORS

    public I2BDTerminal(char aSymbol, Infix2BigDecimal aInfix2BigDecimal) {
        symbol = aSymbol;
        this.infix2BigDecimal = aInfix2BigDecimal;
    }

    // SETTERS AND GETTERS

    public boolean setSymbol(char aSymbol) {
        boolean wasSet = false;
        symbol = aSymbol;
        wasSet = true;
        return wasSet;
    }

    public char getSymbol() {
        return symbol;
    }

    // By association
    public Infix2BigDecimal getInfix2BigDecimal() {
        return infix2BigDecimal;
    }

    // By association
    public boolean setInfix2BigDecimal(Infix2BigDecimal aInfix2BigDecimal) {
        boolean wasSet = false;
        if (aInfix2BigDecimal == null) {
            return wasSet;
        }

        Infix2BigDecimal existingInfix2BigDecimal = infix2BigDecimal;
        infix2BigDecimal = aInfix2BigDecimal;
        if (existingInfix2BigDecimal != null && !existingInfix2BigDecimal.equals(aInfix2BigDecimal)) {
            existingInfix2BigDecimal.removeI2BDTerminal(this);
        }
        infix2BigDecimal.addI2BDTerminal(this);
        wasSet = true;
        return wasSet;
    }

}
