package com.example.notsosimple_calculator;

/**
 * A special type of nonterminal separated for better language processing
 *
 * @author Tao Yan
 * @version July 2020
 */
import java.math.BigDecimal;
import java.util.List;

public class I2BDLukasiewiczNonterminal extends I2BDNonterminal {

    public I2BDLukasiewiczNonterminal(char aSymbol, List<BigDecimal> aOperands, Infix2BigDecimal aInfix2BigDecimal) {
        super(aSymbol, aOperands, aInfix2BigDecimal);
    }

    @Override
    public Object lambda() {
        return null;
    }

}
