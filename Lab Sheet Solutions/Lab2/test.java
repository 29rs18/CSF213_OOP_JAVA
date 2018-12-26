import java.util.Scanner;

/**
 *
 */
public class JavaApplication3 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        boolean status = true;

        int n = Integer.parseInt(in.nextLine());
        if (n < 1) {
            status = false;
        }

        String s[] = new String[n];

        for (int i = 0; i < n; i++) {
            s[i] = in.nextLine();
        }

        int q = Integer.parseInt(in.nextLine());
        String output[] = new String[q];

        for (int i = 0; i < q; i++) {
            String[] input = in.nextLine().split(" ");

            String word = input[1];

            if (Integer.parseInt(input[0]) > 1000) {
                status = false;
            }

            for (int k = 1; k <= word.length(); k++) {

                String substring = word.substring(0, k);
//                System.out.println("\n\n");
//                System.out.println(substring + "-");

                int selectedSize = 0;
                String selectedWord = "";

                for (int j = 0; j < Integer.parseInt(input[0]); j++) {
                    if (s[j].startsWith(substring)) {
//                        System.out.println(s[j]);
                        if (selectedSize == 0 || selectedSize > s[j].length()) {
//                            System.out.println("t");
                            selectedSize = s[j].length();
                            selectedWord = s[j];
                        }
                    }
                }

                if (!selectedWord.equals("")) {
                    output[i] = selectedWord;
                }

            }

//            System.out.println(output[i]);
        }

        if (status) {
            for (String string : output) {
                if (string == null) {
                    System.out.println("");
                } else {
                    System.out.println(string);
                }
            }
        }
    }
}