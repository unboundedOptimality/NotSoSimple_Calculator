package com.example.notsosimple_calculator;

/**
 *
 * @author Tao Yan
 * @verison July 2020
 */
public interface ContextFreeMachine {

    public boolean isFormalLanguageDefiner();

    public boolean isInputAlphabetSubsetOfOutputAlphabet();

    public boolean isOutputAlphabetSubsetOfInputAlphabet();

    public Object runTape(String tape) throws FormalLanguageProcessingMachineException;

    public String subMachine_translate(String tape) throws FormalLanguageProcessingMachineException;
}
