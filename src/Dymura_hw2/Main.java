package Dymura_hw2;

public class Main {
    public static void wordsCount(String str){
        if(str.equals("") || str.equals(" ")){
            System.out.println("Empty string.");
            return;
        }
        String[] s = str.split(" ");
        int count = 0;
        for(int i = 0; i < s.length; i++){
            String s1 = s[i];
            if(s1.equals("") || s1.equals(".") || s1.equals(",")){
                continue;
            }
            count++;
        }
        System.out.println("This string has "+count+" words.");
    }

    public static void isPalindrome(String str){
        if(str.equals("") || str.equals(" ")){
            System.out.println("Empty string.");
            return;
        }
        StringBuilder rev_str = new StringBuilder(str);
        rev_str.reverse();
        if(str.equals(rev_str.toString())){
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }
    }

    public static void main(String[] args) {
        wordsCount("take me away from home  .");
        wordsCount("i    love        java");
        wordsCount(" ");
        isPalindrome("baby");
        isPalindrome("madam");
        isPalindrome("");
    }
}
