package Play_22_6_12;

public class P6 {
    public void setNum(int a, int b, float c) {

    }

    void setNum(int a, int b) {

    }

    int setNum(int a) {
        return 0;
    }


    void test() {
        this.setNum(1);
        this.setNum();
    }

    protected void setNum() {

    }

    public static void main(String[] args) {
        new P6().setNum();
    }
}
