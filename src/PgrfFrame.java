public class PgrfFrame {
    public static void main(String... args) {
        int k = 0, a = 0, b = 1;
        System.out.print("0 1 ");
        for (int i = 0; i < 15 ; i++) {
            //pres sysout vypsat fibonacciho posloupnost
            k = a +b;
            System.out.print(k + " ");
            a= b;
            b = k;
        }
    }

}
