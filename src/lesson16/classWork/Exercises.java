package lesson16.classWork;

import java.util.Arrays;

public class Exercises {
    public static void main(String[] args) {

//        String test = "There is Test something new or jot sdf sdf sdf word Test op or";
//
//        System.out.println(deleteDuplicates(test));
//        System.out.println(Arrays.toString(countDuplicates(test, new String[]{"or", "some", "Test"})));
//
//        String str = "Today is good day... Hello dpsd";
//        System.out.println(replace(str, "is", "that"));
//        System.out.println(replace(str, "o", " "));
//        System.out.println(replace(str, "To", "PPPP"));
//        System.out.println(replace(str, "lo", "X"));

        System.out.println(replace("test str here was here two times or not no test", "here", "PPP"));


    }

     public static String replace(String input, String target, String replacement) {

        if (firstIndexesFinal(input, target, replacement).length == 0)
            return input;

        for (int index : firstIndexesFinal(input, target, replacement)) {
            if (checkReplace(input, target, index)) {
                input = replace(input, target, replacement, index);
            }

        }
        return input;
    }

    private static int [] firstIndexesFinal (String input, String target, String replacement) {
        int[] indexes = findStartIndexes(input.toCharArray(), target.charAt(0));
        int sum = target.length() - replacement.length();

        for (int i = 1; i < indexes.length; i++) {
            indexes[i] -= sum;
            sum++;

        }
        return indexes;
    }


//    public static String deleteDuplicates(String input) {
//
//        String[] words = input.split(" ");
//
//        for (int i = 0; i < words.length; i++) {
//            for (int j = i + 1; j < words.length; j++) {
//                if (words[i].equals(words[j]))
//                    words[j] = "";
//
//            }
//        }
//
//        String res = "";
//
//        for (String word : words) {
//            res += word;
//
//            if (!word.isEmpty())
//                res += " ";
//        }
//        return res;
//    }


//    public static int[] countDuplicates(String input, String[] words) {
//        String[] strings = input.split(" ");
//
//        int[] res = new int[words.length];
//
//        for (String string : strings) {
//            for (int i = 0; i < words.length; i++) {
//                if (string.equals(words[i]))
//                    res[i]++;
//
//            }
//        }
//
//
//        return res;
//    }

    private static boolean checkReplace(String input, String target, int index) {
        char[] inputChars = input.toCharArray();
        char[] replaceChars = target.toCharArray();

        for (int i = 0; i < replaceChars.length && index < inputChars.length; i++, index++) {
            if (inputChars[index] != replaceChars[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] findStartIndexes(char[] inputChars, char beginningChar) {
        int count = 0;

        for (char ch : inputChars) {
            if (ch == beginningChar) {
                count++;
            }
        }

        int[] indexes = new int[count];
        int in = 0;

        int index = 0;
        for (char ch : inputChars) {
            if (ch == beginningChar) {
                indexes[in] = index;
                in++;
            }
            index++;
        }
        return indexes;
    }



    private static String replace(String input, String target, String replacement, int index) {
        char[] res1 = new char[index];

        for (int i = 0; i < index; i++) {
            res1[i] = input.toCharArray()[i];
        }

        char[] res3 = new char[input.length() - res1.length - target.length()];
        for (int i = 0, j = res1.length + target.length(); i < res3.length && j < input.length(); i++, j++) {
            res3[i] = input.toCharArray()[j];

        }
        return new String(res1) + replacement + new String(res3);
    }
}
