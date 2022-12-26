import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(calc(scanner.nextLine()));
    }

    public static String calc(String input) {
        String[] x = input.split(" ");
        String[] arab = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] rim = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        int a = 0;
        int b = 0;
        int c = 0;
        boolean firstArab = false;
        boolean twoArab = false;
        if (x.length != 3) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < arab.length; i++) {
            if (x[0].equals(arab[i])) {
                firstArab = true;
                a = i;
            }
            if (x[2].equals(arab[i])) {
                twoArab = true;
                b = i;
            }

        }
        boolean firstRim = false;
        boolean twoRim = false;
        for (int i = 0; i < rim.length; i++) {
            if (x[0].equals(rim[i])) {
                firstRim = true;
                a = i;
            }
        }
        for (int i = 0; i < rim.length; i++) {
            if (x[2].equals(rim[i])) {
                twoRim = true;
                b = i;
            }

        }
        if ((!firstRim ||!twoRim)&&(!firstArab ||!twoArab) && ((firstRim=twoRim)||(firstArab=twoArab))){
            throw new ArithmeticException();
        }
        switch (x[1]) {
            case "+":
                c = a + b;
                break;
            case "-":
                c = a - b;
                break;
            case "*":
                c = a * b;
                break;
            case "/":
                c = a / b;
                break;
        }
        if (!x[1].equals("+") && !x[1].equals("-") && !x[1].equals("*") && !x[1].equals("/")) {
            throw new ArithmeticException();
        }
        boolean arabOrRim = false;
        if ((firstRim != twoRim) ) {
            throw new ArithmeticException();
        } else {
            if ((firstArab = twoArab)&&firstArab){
                arabOrRim = true;
            }
            if ((firstRim = twoRim)&&firstRim) {
                arabOrRim = false;
            }
        }
        if (arabOrRim) {
            return Integer.toString(c);
        }
        else {
            if (c<1){
                throw new ArithmeticException();
            }
            else {
                if (c<10) {
                    return rim[c];
                } else {
                    int d=c/10;
                    String line="";
                    if(d<4) {
                        for (int i=0; i<d;i++){
                            line+="X";
                        }
                    }
                    if (d==4) {
                        line+="Xl";
                    }
                    if (d>4&&d<9) {
                        line="L";
                        for (int i=5; i<9;i++) {
                            line+="X";
                        }
                    }
                    if (d==9) {
                        line="XC";
                    }
                    if (d==10) {
                        line ="L";
                    }
                    if (c%10!=0) {
line+=rim[c%10];
                    }
return line;
                }
            }

        }

    }

    }
