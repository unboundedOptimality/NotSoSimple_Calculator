package com.example.notsosimple_calculator;

/**
 * A nonterminal in a context-free grammar
 *
 * @author admin
 * @version July 2020
 */
public interface CFGNonterminal {

    public char getSymbol();

    public Object lambda() throws FormalLanguageProcessingMachineException;

}
