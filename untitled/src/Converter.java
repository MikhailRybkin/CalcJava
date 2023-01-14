class Converter {

    static String fromArabicToRoman (String arabianNumber){
        int romeNumber = Integer.parseInt((arabianNumber));
        if (romeNumber == 100) {
            return RomanNumerals.C.getValueRome();
        }
        StringBuilder result = new StringBuilder();
        int ten = romeNumber / 10 * 10;
        int units = romeNumber % 10;
        for (RomanNumerals romanNumerals : RomanNumerals.tensRomanNumerals()) {
            if (ten == 0){
                break;
            }
            if (romanNumerals.getValueArabian().equals(String.valueOf(ten))) {
                result.append(romanNumerals.valueRome);
                break;
            }
        }

        for (RomanNumerals romanNumerals : RomanNumerals.allRomanNumeral()) {
            if (units == 0 && ten != 0){
                break;
            }
            if (romanNumerals.getValueArabian().equals(String.valueOf(units))) {
                result.append(romanNumerals.valueRome);
                break;
            }
        }
        return result.toString();
    }

    static String[] fromRomanToArabic(String[] romeNumber) {
        String[] arabicNumerals = new String[romeNumber.length];
        for (int i = 0; i < romeNumber.length; i++) {
            for (RomanNumerals romanNumerals :
                    RomanNumerals.allRomanNumeral()) {
                if (romanNumerals.getValueRome().equals(romeNumber[i])) {
                    arabicNumerals[i] = romanNumerals.getValueArabian();
                }
            }
        }
        return arabicNumerals;
    }
}