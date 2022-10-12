public class Delay extends Thread {
    @Override
    public void run() {
        try {
            sleep(3000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
