public class Test2 {
    static int addAsStrings(int n1, int n2) {


        return Integer.parseInt(n1 + "" + n2, Integer.parseInt(n2 + "" + n1));
    }

    public static void main(String[] args) {
        addAsStrings(1, 2);
        addAsStrings(2, 1);
        addAsStrings(0, 0);

    }
}
