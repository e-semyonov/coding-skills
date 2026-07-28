package coding;

public class Main {
    int [] array = new int[] {1,2,3};
    int [] array1 = {1,2,3};



    public static void changeA(int [] a) {
        a[0] = -1;
    }

    public static void main(String[] args) {
        int [] a = {1,2,3};
        changeA(a);
        System.out.println(a[0]);

        isValid("([{}])");
    }

    public static boolean isValid(String s) {
        while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
        }
        return s.isEmpty();
    }

}
