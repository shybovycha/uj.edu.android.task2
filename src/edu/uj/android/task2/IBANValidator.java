package edu.uj.android.task2;

import java.math.BigInteger;

/**
 * Created by shybovycha on 07.10.14.
 */
public class IBANValidator {
    protected String line;

    public IBANValidator() {
        this.line = "";
    }

    public IBANValidator(String line) {
        this.setLine(line);
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line.replaceAll("\\s", "").toUpperCase();
    }

    public boolean validate() {
        if (line.length() != 28) {
            return false;
        }

        line = line.substring(4, line.length()) + line.substring(0, 4);

        for (int i = line.length() - 5; i < line.length(); i++) {
            int symbol = (int) line.charAt(i);

            if ((symbol >= (int) 'A') && (symbol <= (int) 'Z')) {
                line = line.substring(0, i) + String.format("%d", (symbol - (int) 'A' + 10)) + line.substring(i + 1, line.length());
            }
        }

        return (new BigInteger(line).mod(new BigInteger("97")).equals(BigInteger.ONE));
    }
}