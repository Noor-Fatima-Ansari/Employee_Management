public class Loading extends Thread{
    public void run() {
        for (int i=0;i<15;i++){
            System.out.print(" *");
            try {
                sleep(300);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.println();
    }


}
