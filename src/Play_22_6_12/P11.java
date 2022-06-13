package Play_22_6_12;


public class P11 {

    static int get() {

        try {

            return 1;

        } catch (Throwable e) {

            return 2;

        } finally {

            return 3;

        }

    }

    public static void main(String[] args) {

        System.out.println(get());

    }

}

