package com.example.notsosimple_calculator;

/**
 * The concrete machine behind the calculator
 *
 * @author Tao Yan
 * @version July 2020
 */

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.*;

public class Infix2BigDecimal implements ContextFreeMachine {

    // ASSOCIATIONS
    private List<I2BDTerminal> i2BDTerminals;
    private List<I2BDNonterminal> i2BDNonterminals;

    // CONSTRUCTORS

    public Infix2BigDecimal() {
        i2BDTerminals = new ArrayList<I2BDTerminal>();
        i2BDNonterminals = new ArrayList<I2BDNonterminal>();

        i2BDTerminals.add(new I2BDTerminal('.', this));
        i2BDTerminals.add(new I2BDTerminal('0', this));
        i2BDTerminals.add(new I2BDTerminal('1', this));
        i2BDTerminals.add(new I2BDTerminal('2', this));
        i2BDTerminals.add(new I2BDTerminal('3', this));
        i2BDTerminals.add(new I2BDTerminal('4', this));
        i2BDTerminals.add(new I2BDTerminal('5', this));
        i2BDTerminals.add(new I2BDTerminal('6', this));
        i2BDTerminals.add(new I2BDTerminal('7', this));
        i2BDTerminals.add(new I2BDTerminal('8', this));
        i2BDTerminals.add(new I2BDTerminal('9', this));

        i2BDNonterminals.add(new I2BDNonterminal('+', new ArrayList<BigDecimal>(), this));
        i2BDNonterminals.add(new I2BDNonterminal('-', new ArrayList<BigDecimal>(), this));
        i2BDNonterminals.add(new I2BDNonterminal('*', new ArrayList<BigDecimal>(), this));
        i2BDNonterminals.add(new I2BDNonterminal('/', new ArrayList<BigDecimal>(), this));

        i2BDNonterminals.add(new I2BDLukasiewiczNonterminal('(', new ArrayList<BigDecimal>(), this));
        i2BDNonterminals.add(new I2BDLukasiewiczNonterminal(')', new ArrayList<BigDecimal>(), this));
        i2BDNonterminals.add(new I2BDLukasiewiczNonterminal(',', new ArrayList<BigDecimal>(), this));
    }

    // INHERITED
    public I2BDTerminal getI2BDTerminal(int index) {
        I2BDTerminal aI2BDTerminal = i2BDTerminals.get(index);
        return aI2BDTerminal;
    }

    public List<I2BDTerminal> getI2BDTerminals() {
        List<I2BDTerminal> newI2BDTerminals = Collections.unmodifiableList(i2BDTerminals);
        return newI2BDTerminals;
    }

    public int numberOfI2BDTerminals() {
        int number = i2BDTerminals.size();
        return number;
    }

    public int indexOfI2BDTerminal(I2BDTerminal aI2BDTerminal) {
        int index = i2BDTerminals.indexOf(aI2BDTerminal);
        return index;
    }

    public I2BDNonterminal getI2BDNonterminal(int index) {
        I2BDNonterminal aI2BDNonterminal = i2BDNonterminals.get(index);
        return aI2BDNonterminal;
    }

    public List<I2BDNonterminal> getI2BDNonterminals() {
        List<I2BDNonterminal> newI2BDNonterminals = Collections.unmodifiableList(i2BDNonterminals);
        return newI2BDNonterminals;
    }

    public int numberOfI2BDNonterminals() {
        int number = i2BDNonterminals.size();
        return number;
    }

    public boolean hasI2BDNonterminals() {
        boolean has = i2BDNonterminals.size() > 0;
        return has;
    }

    public int indexOfI2BDNonterminal(I2BDNonterminal aI2BDNonterminal) {
        int index = i2BDNonterminals.indexOf(aI2BDNonterminal);
        return index;
    }

    /* Code from template association_MinimumNumberOfMethod */
    public static int minimumNumberOfI2BDTerminals() {
        return 0;
    }

    /* Code from template association_AddManyToOne */
    public I2BDTerminal addI2BDTerminal(char aSymbol) {
        return new I2BDTerminal(aSymbol, this);
    }

    public boolean addI2BDTerminal(I2BDTerminal aI2BDTerminal) {
        boolean wasAdded = false;
        if (i2BDTerminals.contains(aI2BDTerminal)) {
            return false;
        }
        Infix2BigDecimal existingInfix2BigDecimal = aI2BDTerminal.getInfix2BigDecimal();
        boolean isNewInfix2BigDecimal = existingInfix2BigDecimal != null && !this.equals(existingInfix2BigDecimal);
        if (isNewInfix2BigDecimal) {
            aI2BDTerminal.setInfix2BigDecimal(this);
        } else {
            i2BDTerminals.add(aI2BDTerminal);
        }
        wasAdded = true;
        return wasAdded;
    }

    public boolean removeI2BDTerminal(I2BDTerminal aI2BDTerminal) {
        boolean wasRemoved = false;
        if (!this.equals(aI2BDTerminal.getInfix2BigDecimal())) {
            i2BDTerminals.remove(aI2BDTerminal);
            wasRemoved = true;
        }
        return wasRemoved;
    }

    public boolean addI2BDTerminalAt(I2BDTerminal aI2BDTerminal, int index) {
        boolean wasAdded = false;
        if (addI2BDTerminal(aI2BDTerminal)) {
            if (index < 0) {
                index = 0;
            }
            if (index > numberOfI2BDTerminals()) {
                index = numberOfI2BDTerminals() - 1;
            }
            i2BDTerminals.remove(aI2BDTerminal);
            i2BDTerminals.add(index, aI2BDTerminal);
            wasAdded = true;
        }
        return wasAdded;
    }

    public boolean addOrMoveI2BDTerminalAt(I2BDTerminal aI2BDTerminal, int index) {
        boolean wasAdded = false;
        if (i2BDTerminals.contains(aI2BDTerminal)) {
            if (index < 0) {
                index = 0;
            }
            if (index > numberOfI2BDTerminals()) {
                index = numberOfI2BDTerminals() - 1;
            }
            i2BDTerminals.remove(aI2BDTerminal);
            i2BDTerminals.add(index, aI2BDTerminal);
            wasAdded = true;
        } else {
            wasAdded = addI2BDTerminalAt(aI2BDTerminal, index);
        }
        return wasAdded;
    }

    public static int minimumNumberOfI2BDNonterminals() {
        return 0;
    }

    public I2BDNonterminal addI2BDNonterminal(char aSymbol, List<BigDecimal> aOperands) {
        return new I2BDNonterminal(aSymbol, aOperands, this);
    }

    public boolean addI2BDNonterminal(I2BDNonterminal aI2BDNonterminal) {
        boolean wasAdded = false;
        if (i2BDNonterminals.contains(aI2BDNonterminal)) {
            return false;
        }
        Infix2BigDecimal existingInfix2BigDecimal = aI2BDNonterminal.getInfix2BigDecimal();
        boolean isNewInfix2BigDecimal = existingInfix2BigDecimal != null && !this.equals(existingInfix2BigDecimal);
        if (isNewInfix2BigDecimal) {
            aI2BDNonterminal.setInfix2BigDecimal(this);
        } else {
            i2BDNonterminals.add(aI2BDNonterminal);
        }
        wasAdded = true;
        return wasAdded;
    }

    public boolean removeI2BDNonterminal(I2BDNonterminal aI2BDNonterminal) {
        boolean wasRemoved = false;
        if (!this.equals(aI2BDNonterminal.getInfix2BigDecimal())) {
            i2BDNonterminals.remove(aI2BDNonterminal);
            wasRemoved = true;
        }
        return wasRemoved;
    }

    public boolean addI2BDNonterminalAt(I2BDNonterminal aI2BDNonterminal, int index) {
        boolean wasAdded = false;
        if (addI2BDNonterminal(aI2BDNonterminal)) {
            if (index < 0) {
                index = 0;
            }
            if (index > numberOfI2BDNonterminals()) {
                index = numberOfI2BDNonterminals() - 1;
            }
            i2BDNonterminals.remove(aI2BDNonterminal);
            i2BDNonterminals.add(index, aI2BDNonterminal);
            wasAdded = true;
        }
        return wasAdded;
    }

    public boolean addOrMoveI2BDNonterminalAt(I2BDNonterminal aI2BDNonterminal, int index) {
        boolean wasAdded = false;
        if (i2BDNonterminals.contains(aI2BDNonterminal)) {
            if (index < 0) {
                index = 0;
            }
            if (index > numberOfI2BDNonterminals()) {
                index = numberOfI2BDNonterminals() - 1;
            }
            i2BDNonterminals.remove(aI2BDNonterminal);
            i2BDNonterminals.add(index, aI2BDNonterminal);
            wasAdded = true;
        } else {
            wasAdded = addI2BDNonterminalAt(aI2BDNonterminal, index);
        }
        return wasAdded;
    }

    @Override
    public boolean isFormalLanguageDefiner() {
        return false;
    }

    @Override
    public boolean isInputAlphabetSubsetOfOutputAlphabet() {
        return false;
    }

    @Override
    public boolean isOutputAlphabetSubsetOfInputAlphabet() {
        return true;
    }

    @Override
    public String subMachine_translate(String tape) throws FormalLanguageProcessingMachineException {

        if (tape == null) {
            return null;
        }

        StringReader reader1 = new StringReader(tape);

        int first;
        try {
            first = reader1.read();
        } catch (Exception e) {
            throw new FormalLanguageProcessingMachineException();
        }

        if (first == -1) {
            return "";
        }

        if (first == (int) '-') {
            return subMachine_translate("0" + tape);
        }

        //==============
//		boolean firstIsATerminal = false;
//		for (I2BDTerminal ele : i2BDTerminals) {
//			if (((int) (ele.getSymbol())) == first) {
//				firstIsATerminal = true;
//				break;
//			}
//		}
//		boolean firstIsANonterminal = false;
//		boolean firstIsALukasiewiczNonterminal = false;
//		for (I2BDNonterminal ele : i2BDNonterminals) {
//			if (((int) (ele.getSymbol())) == first) {
//				firstIsANonterminal = true;
//				if(ele instanceof I2BDLukasiewiczNonterminal) {
//					firstIsALukasiewiczNonterminal = true;
//				}
//				break;
//			}
//		}

        reader1.close();
        //==============
		/*
		Pattern startingBracket = Pattern.compile("(");
		Pattern endingBracket = Pattern.compile(")");

		Matcher m_startingBracket = startingBracket.matcher(tape);
		Matcher m_endingBracket = endingBracket.matcher(tape);
		*/

        StringReader reader2 = new StringReader(tape);
        int bracketState = 0;

        int bracketStaringIndex = -1;
        int bracketEndingIndex = -1;
        boolean startingBracketEncountered = false;
        List<int[]> topLevelBrackets = new ArrayList<int[]>();
        for (int i = 0; i < tape.length(); i++) {
            try {
                int read_in = reader2.read();
                if (read_in == (int) '(') {
                    bracketState = bracketState - 1;
                    if (!startingBracketEncountered) {
                        bracketStaringIndex = i;
                    }
                    startingBracketEncountered = true;
                } else
                if (read_in == (int) ')') {
                    bracketState = bracketState + 1;
                }
                if ((!startingBracketEncountered) && (bracketState < 0)) {
                    throw new FormalLanguageProcessingMachineException();
                }
                if (startingBracketEncountered && (bracketState == 0)) {
                    bracketEndingIndex = i;
                    //dontbreak;
                    topLevelBrackets.add(new int[] {bracketStaringIndex, bracketEndingIndex});
                }
            } catch (Exception e) {
                throw new FormalLanguageProcessingMachineException();
            }
        }
        if (bracketState != 0) {
            throw new FormalLanguageProcessingMachineException();
        }

        for (int i = 0; i < tape.length(); i++) {

            boolean channel_continue1 = false;
            for (int[] ele_topLevelBrackets : topLevelBrackets) {
                if ((ele_topLevelBrackets[0] <= i) &&
                        (ele_topLevelBrackets[1] >= i)) {
                    channel_continue1 = true;
                    break;
                }
            }
            if (channel_continue1) {
                continue;
            }

            if ((tape.charAt(i) == '*') || (tape.charAt(i) == '/')) {

                for (int j = i; j < tape.length(); j++) {

                    boolean channel_continue = false;
                    for (int[] ele_topLevelBrackets : topLevelBrackets) {
                        if ((ele_topLevelBrackets[0] <= j) &&
                                (ele_topLevelBrackets[1] >= j)) {
                            channel_continue = true;
                            break;
                        }
                    }
                    if (channel_continue) {
                        continue;
                    }

                    if ((tape.charAt(j) == '+') || (tape.charAt(j) == '-') ||
                            (tape.charAt(j) == '*') || (tape.charAt(j) == '/')) {

                        if ((tape.charAt(j) == '+') || (tape.charAt(j) == '-')) {
                            String newTape1 = tape.substring(0, j) +  ")" + tape.substring(j, tape.length());
                            int startingBracketIndex_tape = -1;
                            for (int k = i - 1; k >= 0; k--) {
                                if ((tape.charAt(k) == '+') || (tape.charAt(k) == '-') ||
                                        (tape.charAt(k) == '*') || (tape.charAt(k) == '/')) {
                                    startingBracketIndex_tape = k + 1;
                                    break;
                                }
                            }
                            if (!(startingBracketIndex_tape > 0)) {
                                newTape1 = "(" + newTape1;
                            } else {
                                newTape1 = newTape1.substring(0, startingBracketIndex_tape) +
                                        "(" + newTape1.substring(startingBracketIndex_tape, newTape1.length());
                            }
                            return subMachine_translate(newTape1);

                        } else {	// '*' || '/'

                            continue;

                        }

                    }
                }

            }
        }

        for (int i = 0; i < tape.length(); i++) {

            boolean channel_continue1 = false;
            for (int[] ele_topLevelBrackets : topLevelBrackets) {
                if ((ele_topLevelBrackets[0] <= i) &&
                        (ele_topLevelBrackets[1] >= i)) {
                    channel_continue1 = true;
                    break;
                }
            }
            if (channel_continue1) {
                continue;
            }

            for (int j = i; j < tape.length(); j++) {

                boolean channel_continue = false;
                for (int[] ele_topLevelBrackets : topLevelBrackets) {
                    if ((ele_topLevelBrackets[0] <= j) &&
                            (ele_topLevelBrackets[1] >= j)) {
                        channel_continue = true;
                        break;
                    }
                }
                if (channel_continue) {
                    continue;
                }

                if (tape.charAt(j) == '+' || tape.charAt(j) == '-') {

                    String newTape1 = "(" + tape.substring(0, j) + ")" + tape.substring(j, tape.length());
                    return subMachine_translate(newTape1);

                }
            }
        }

        return tape;
    }


    @Override
    public Object runTape(String tape) throws FormalLanguageProcessingMachineException {

        tape = subMachine_translate(tape);

        for (int i = 0; i < tape.length(); i++) {
            if (((tape.charAt(i) == '0') ||
                    (tape.charAt(i) == '1') ||
                    (tape.charAt(i) == '2') ||
                    (tape.charAt(i) == '3') ||
                    (tape.charAt(i) == '4') ||
                    (tape.charAt(i) == '5') ||
                    (tape.charAt(i) == '6') ||
                    (tape.charAt(i) == '7') ||
                    (tape.charAt(i) == '8') ||
                    (tape.charAt(i) == '9') ||
                    (tape.charAt(i) == '.')) &&
                    ((tape.charAt(i + 1) == '+') ||
                            (tape.charAt(i + 1) == '-') ||
                            (tape.charAt(i + 1) == '*') ||
                            (tape.charAt(i + 1) == '/')) &&
                    ((tape.charAt(i + 2) == '0') ||
                            (tape.charAt(i + 2) == '1') ||
                            (tape.charAt(i + 2) == '2') ||
                            (tape.charAt(i + 2) == '3') ||
                            (tape.charAt(i + 2) == '4') ||
                            (tape.charAt(i + 2) == '5') ||
                            (tape.charAt(i + 2) == '6') ||
                            (tape.charAt(i + 2) == '7') ||
                            (tape.charAt(i + 2) == '8') ||
                            (tape.charAt(i + 2) == '9') ||
                            (tape.charAt(i + 2) == '.'))) {

                boolean consecutiveJs = true;
                int log_j = -1;
                for (int j = 0; j <= i; j++) {
                    if (!((tape.charAt(i - j) == '0') ||
                            (tape.charAt(i - j) == '1') ||
                            (tape.charAt(i - j) == '2') ||
                            (tape.charAt(i - j) == '3') ||
                            (tape.charAt(i - j) == '4') ||
                            (tape.charAt(i - j) == '5') ||
                            (tape.charAt(i - j) == '6') ||
                            (tape.charAt(i - j) == '7') ||
                            (tape.charAt(i - j) == '8') ||
                            (tape.charAt(i - j) == '9') ||
                            (tape.charAt(i - j) == '.'))) {
                        consecutiveJs = false;
                    }
                    log_j = j;
                    if (!consecutiveJs) {
                        break;
                    }
                }

                boolean consecutiveKs = true;
                int log_k = -1;
                for (int k = 0; i + 2 + k < tape.length(); k++) {
                    if (!((tape.charAt(i + 2 + k) == '0') ||
                            (tape.charAt(i + 2 + k) == '1') ||
                            (tape.charAt(i + 2 + k) == '2') ||
                            (tape.charAt(i + 2 + k) == '3') ||
                            (tape.charAt(i + 2 + k) == '4') ||
                            (tape.charAt(i + 2 + k) == '5') ||
                            (tape.charAt(i + 2 + k) == '6') ||
                            (tape.charAt(i + 2 + k) == '7') ||
                            (tape.charAt(i + 2 + k) == '8') ||
                            (tape.charAt(i + 2 + k) == '9') ||
                            (tape.charAt(i + 2 + k) == '0') ||
                            (tape.charAt(i + 2 + k) == '.'))) {
                        consecutiveKs = false;
                    }
                    log_k = k;
                    if (!consecutiveKs) {
                        break;
                    }
                }


                BigDecimal operand1;
                BigDecimal operand2;
                try {
                    operand1 = new BigDecimal(Double.parseDouble(tape.substring(i - log_j + 1, i + 1)));
                    operand2 = new BigDecimal(Double.parseDouble(tape.substring(i + 2, i + 2 + log_k)));
                } catch (Exception e) {
                    throw new FormalLanguageProcessingMachineException();
                }

                String stringToSubstitute = "";
                switch (tape.charAt(i + 1)) {
                    case '+':
                        stringToSubstitute = operand1.add(operand2).toString();
                        break;
                    case '-':
                        stringToSubstitute = operand1.subtract(operand2).toString();
                        break;
                    case '*':
                        stringToSubstitute = operand1.multiply(operand2).toString();
                        break;
                    case '/':
                        stringToSubstitute = operand1.divide(operand2).toString();
                        break;
                }

                String stringAfterSubstitution = stringToSubstitute + tape.substring(i + 1, tape.length());

                return runTape(stringAfterSubstitution);
            }

        } return (Object) tape;

    }

}
