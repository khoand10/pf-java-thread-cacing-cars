import com.sun.javaws.Main;

import java.util.Random;


public class Car implements Runnable {
    private String name;
    public Car(String name){
        this.name = name;
    }
    @Override
    public void run() {
        int start = 0;
        long time = System.currentTimeMillis();
        while(start < App.DISTANCE){
            try{
                int speed = new Random().nextInt(10);
                start += speed;
                String log = "|";
                int percentTravel = (start * 100) / App.DISTANCE;
                for (int i = 0; i < App.DISTANCE; i += App.STEP) {
                    if (percentTravel >= i + App.STEP) {
                        log += "=";
                    } else if (percentTravel >= i && percentTravel < i + App.STEP) {
                        log += "o";
                    } else {
                        log += "-";
                    }
                }
                log += "|";
                System.out.println("Car" + this.name + ": " + log + " " + Math.min(App.DISTANCE, start) + "KM");
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println("Car" + this.name + " broken...");
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Car" + this.name + " Finish in " + (endTime - time) / 1000 + "s");
    }
}
