import java.util.List;
import java.util.Scanner;

public class Calcularor {

    public static void main(String[] args) throws Exception {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        String[] ar = input.split(" ");
        String operation = ar[1];
        String number1 = ar[0];
        String number2 = ar[2];
        boolean isarabik = false;

        int a;
        int b;
        try {
            a = Integer.parseInt(number1);
            b = Integer.parseInt(number2);
            isarabik = true;
        } catch (Exception ex) {
            a = ConvertToArabic(number1);
            b = ConvertToArabic(number2);
            isarabik = false;
        }
        int result;
        switch (operation) {
            case ("+"):
                result = a + b;
                break;
            case ("-"):
                result = a - b;
                break;
            case ("*"):
                result = a * b;
                break;
            case ("/"):
                result = a / b;
                break;
            default:
                throw new Exception("Че творишь?)");
        }
        if (isarabik) {
            System.out.println(result);
        } else {
            String s = arabicToRoman(result);
            System.out.println(s);
        }
    }

    public static int ConvertToArabic(String value) throws Exception {
        switch (value) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default:
                throw new Exception();
        }

    }

    public static String arabicToRoman(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }

        List<RomanNum> romanNumerals = RomanNum.getReverseSortedValues();


        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNum currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }


}

