import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
// import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


// 743
public class Hannan89 {
    public static int numeralStartCount = 0;
    public static void main(String[] args) {
        Queue<String> inputQueue = readNumeralFile();
        Queue<String> outputQueue = new LinkedList<>();

        NumeralConverter converter = new NumeralConverter();
        int[] numberList = converter.convertListToSumNum(inputQueue);
        int endCharCount = converter.convertNumToNumerals(numberList, outputQueue);
        System.out.println(numeralStartCount - endCharCount);
        // System.out.println(Arrays.toString(numberList));


    }


    public static Queue<String> readNumeralFile() {
        Queue<String> readerQueue = new LinkedList<>();
        String filePath = "./0089_roman.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                numeralStartCount += line.length();
                readerQueue.offer(line); // Add each line to the queue
            }
            // System.out.println("File successfully read and lines added to the queue.");

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            e.printStackTrace();
        }

        return readerQueue;
    }
}


class NumeralConverter {
    public NumeralAdapter numAdapter = new NumeralAdapter();
    public static int numeralEndCount = 0;

    public int[] convertListToSumNum(Queue<String> queue) {
        int[] convertedArr = new int[queue.size()];

        for (int i = 0; i < convertedArr.length; i++) {
            convertSequenceToSumNum(convertedArr, i, queue.poll());
        }
        return convertedArr;
    }

    public void convertSequenceToSumNum(int[] convertedArr, int index, String sequence) {
        int leftNum = 0;
        int rightNum = 0;

        if (sequence == null || sequence.isEmpty()) {
            return;
        }
            for (int i = 1; i < sequence.length(); i++) {
                rightNum = numAdapter.getNumber(sequence.charAt(i));
                leftNum =  numAdapter.getNumber(sequence.charAt(i - 1));
                leftNum = numAdapter.SetDescendingRule(leftNum, rightNum);
                convertedArr[index] += leftNum;
            }

        int lastCharValue = numAdapter.getNumber(sequence.charAt(sequence.length() - 1));
        convertedArr[index] += lastCharValue;
    }

    public int convertNumToNumerals(int[] nums, Queue<String> outputQueue) {
        Numero num = new Numero(0);

        for (int i = 0; i < nums.length; i++) {
            num.setNum(nums[i]);
            outputQueue.add(divideNumToNumerals(num));
        }
        // System.out.println(charCount);
        return numAdapter.charCount;
    }

    public String divideNumToNumerals(Numero num) {
        String str = "";
        while (num.getNum() > 0) {
            // System.out.println(num.getNum());
            if (num.getNum() - 1000 >= 0) {
                str = setNumeralSubtractNum(num, str,1000);
            } else if (num.getNum() - 500 >= 0) {
                str = setNumeralSubtractNum(num, str,500);
            } else if (num.getNum() - 100 >= 0) {
                str = setNumeralSubtractNum(num, str,100);
            } else if (num.getNum() - 50 >= 0) {
                str = setNumeralSubtractNum(num, str,50);
            } else if (num.getNum() - 10 >= 0) {
                str = setNumeralSubtractNum(num, str,10);
            } else if (num.getNum() - 5 >= 0) {
                str = setNumeralSubtractNum(num, str,5);
            } else {
                str = setNumeralSubtractNum(num, str,1);
            }
        }
        System.out.println(str);
        return str;
    } 

    public String setNumeralSubtractNum(Numero num, String str, int amount) {
        int ruleResult = numAdapter.checkDescendingRule(num);
        if (ruleResult != 0) {
            str += numAdapter.getNumeral(ruleResult);
            numAdapter.charCount += 2;
        } else {
            num.changeNum(-amount);
            str += numAdapter.getNumeral(amount);
            numAdapter.charCount++;
        }
        // System.out.println(str);
        
        return str;
    }
}

class NumeralAdapter {
    public int charCount = 0;

    public int getNumber(Character numeral) {
        switch (numeral) {
            case 'M': return 1000;
            case 'D': return 500;
            case 'C': return 100;
            case 'L': return 50;
            case 'X': return 10;
            case 'V': return 5;
            default: return 1;
        }
    }

    public String getNumeral(int number) {
        switch (number) {
            case 1000: return "M";
            case 900:  return "CM";
            case 500:  return "D";
            case 400:  return "CD";
            case 100:  return "C";
            case 90:   return "XC";
            case 50:   return "L";
            case 40:   return "XL";
            case 10:   return "X";
            case 9:    return "IX";
            case 5:    return "V";
            case 4:    return "IV";
            default:   return "I";
        }
    }

    /*
     * Cases of numeral descending rule
     * 900, 400, 90, 40, 9, 4
     */

    public int checkDescendingRule(Numero num) {
        if (num.getNum() < 1000 && num.getNum() >= 900) {
            num.changeNum(-900);
            return 900;
        } if (num.getNum() < 500 && num.getNum() >= 400) {
            num.changeNum(-400);
            return 400;
        } if (num.getNum() < 100 && num.getNum() >= 90) {
            num.changeNum(-90);
            return 90;
        } if (num.getNum() < 50 && num.getNum() >= 40) {
            num.changeNum(-40);
            return 40;
        } if (num.getNum() < 10 && num.getNum() >= 9) {
            num.changeNum(-9);
            return 9;
        } if (num.getNum() < 5 && num.getNum() >= 4) {
            num.changeNum(-4);
            return 4;
        } else {
            return 0;
        }
    }

    public int SetDescendingRule(int l, int r) {
        if (l < r) {
            return l *= -1;
        } else {
            return l;
        }
    }
}


// Im tired of not being able to pass by reference.
class Numero {
    private int val;

    public Numero(int val) {
        this.val = val;
    }

    public int getNum() {
        return this.val;
    }

    public void setNum(int newVal) {
        this.val = newVal;
    }

    public void changeNum(int newVal) {
        this.val += newVal;
    }
}