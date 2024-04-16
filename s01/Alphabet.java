public class Alphabet extends Thread {
    public void run() {
        try {
            for (char i = 'a'; i <= 'z'; i++) {
                System.out.println(i);
                Thread.sleep(2000);
            }
        } catch (Exception e) {
        }
    }

    public static void main(String args[]) {
        Alphabet p = new Alphabet();
        p.start();
    }
}
