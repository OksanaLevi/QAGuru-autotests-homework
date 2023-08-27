package guru.qa;

public class Main {
    public static void main(String[] args) {

        // поупражняться с математическими и логическими операторами
        byte example1 = 120;
        short example2 = 130;
        int example3 = 140;
        long example4 = 150;
        char example5 = 'a';
        float example6 = 150.8F;
        double example7 = 160.9;
        boolean example8 = true;

        System.out.println("int + short = " + (example1 + example2));
        System.out.println("byte + long = " + (example3 + example4));
        System.out.println("char + float = " + (example5 + example6));
        System.out.println("double + boolean = " + (example7) + ", " + (!example8));

        // Добиться переполнения при вычислениях  (вывести в консоль)
        byte today = Byte.MAX_VALUE;

        if (today == 128) {
            System.out.println("Лето закончилось");
        } else {
            System.out.println("Шёл " + ++today + " день лета.");
        }

        // попробовать вычисления комбинаций типов данных (int и double)
        System.out.println(" int + double = " + (example3 + example7));
        System.out.println("int * double = " + (example3 * example7));
        System.out.println("int / double = " + (example3 / example7));
        System.out.println("int - double = " + (example3 - example7));
    }
}
