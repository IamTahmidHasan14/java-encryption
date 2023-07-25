package encryption;
public class Encryption {
    private int[] num;

    private void swapDigits() {
        int t;
        t = num[0];
        num[0] = num[2];
        num[2] = t;
        t = num[1];
        num[1] = num[3];
        num[3] = t;
    }
    private int toInt() {
        int s = 0;
        for(int i = 0; i < num.length; ++i)
            s += num[i] * Math.pow(10, 4 - (i + 1));
        return s;
    }
    public int encryption(int data) {
        num = new int[4];
        for(int i = 3; i >= 0; --i) {
            num[i] = data % 10;
            data /= 10;
        }
        for(int i = 0; i < num.length; ++i)
            num[i] = (num[i] + 7) % 10;
        swapDigits();
        return toInt();
    }
    public static void main(String[] args) {
        Encryption encrypt = new Encryption();
        int a = Integer.parseInt(args[0]);
        System.out.println(encrypt.encryption(a));
    }
}
