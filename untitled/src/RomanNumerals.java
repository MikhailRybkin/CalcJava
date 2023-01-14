import java.util.ArrayList;
import java.util.EnumSet;

enum RomanNumerals {
    I("I", "1"),
    II("II", "2"),
    III("III", "3"),
    IV("IV", "4"),
    V("V", "5"),
    VI("VI", "6"),
    VII("VII", "7"),
    VIII("VIII", "8"),
    IX("IX", "9"),
    X("X", "10"),
    XX("XX", "20"),
    XXX("XXX", "30"),
    XL("XL", "40"),
    L("L", "50"),
    LX("LX", "60"),
    LXX("LXX", "70"),
    LXXX("LXXX", "80"),
    XC("XC", "90"),
    C("C", "100");

    final String valueRome;
    final String valueArabian;

    RomanNumerals(String valueRome, String valueArabian) {
        this.valueRome = valueRome;
        this.valueArabian = valueArabian;
    }

    String getValueRome() {
        return valueRome;
    }

    String getValueArabian() {
        return valueArabian;
    }

    static EnumSet<RomanNumerals> allRomanNumeral(){
        return EnumSet.range(I,C);
    }

    static ArrayList<String> getAllRomanValues() {
        ArrayList<String> allRomanValues = new ArrayList<>();
        for (RomanNumerals numerals : allRomanNumeral()) {
            allRomanValues.add(numerals.valueRome);
        }
        return allRomanValues;
    }
    static EnumSet<RomanNumerals> tensRomanNumerals(){
        return EnumSet.range(X,XC);
    }
}