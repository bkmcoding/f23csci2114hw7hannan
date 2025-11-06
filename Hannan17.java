
// 22124
public class Hannan17 {
    public static void main(String[] args) {
        WordConverter wordconverter = new WordConverter();
        for (int i = 0; i <= 1000; i++) {
            wordconverter.convert(i);
        }
        System.out.println("Character Count: " + wordconverter.charCount);
    }

}

class WordConverter {
    public int thousands = 0;
    public int hundreds = 0;
    public int tens = 0;
    public int ones = 0;

    public int charCount;

    public String convert(int n) {
        setDigits(n);
        String sentence = "";
        sentence += getThousandWords(thousands);
        sentence += getHundredsWords(hundreds);
        if (tens == 1) {
            sentence += getTeensWords(ones);
        } else {
            sentence += getTensWords(tens);
            sentence += getOnesWords(ones);
        }
        charCount += sentence.length();
        System.out.println(sentence);
        return sentence;
    }


    public void setDigits(int n) {
        this.thousands = setDigit(n, 1000);
        this.hundreds= setDigit(n, 100);
        this.tens = setDigit(n, 10);
        this.ones = setDigit(n, 1);
        System.out.println(thousands);
        System.out.println(hundreds);
        System.out.println(tens);
        System.out.println(ones);
    }

    public int setDigit(int n, int digit) {
        return (n / digit) % 10;
    }


    public String getOnesWords(int n) {
        switch (n) {
            case 9: return "Nine";
            case 8: return "Eight";
            case 7: return "Seven";
            case 6: return "Six";
            case 5: return "Five";
            case 4: return "Four";
            case 3: return "Three";
            case 2: return "Two";
            case 1: return "One";
            default: return "";
        }
    }

       // Stupid english language and its wierd names for the tens place
       public String getTeensWords(int n) {
        switch (n) {
            case 9: return "Nineteen";
            case 8: return "Eighteen";
            case 7: return "Seventeen";
            case 6: return "Sixteen";
            case 5: return "Fifteen";
            case 4: return "Fourteen";
            case 3: return "Thirteen";
            case 2: return "Twelve";
            case 1: return "Eleven";
            default: return "Ten";
        }
    }

    public String getTensWords(int n) {
        switch (n) {
            case 9: return "Ninety";
            case 8: return "Eighty";
            case 7: return "Seventy";
            case 6: return "Sixty";
            case 5: return "Fifty";
            case 4: return "Forty";
            case 3: return "Thirty";
            case 2: return "Twenty";
            default: return "";
        }
    }

    public String getHundredsWords(int n) {
        if (n > 0) {
            String word = getOnesWords(n);
            return word + "Hundred" + setAnd(n);
        }
        return "";
        
    }

    public String getThousandWords(int n) {
        if (n > 0) {
            String word = getOnesWords(n);
            return word + "Thousand";
        } return "";
    }

    public String setAnd(int n) {
        if (!(this.ones == 0 && this.tens == 0)) {
            return "And";
        } return "";
    }

}