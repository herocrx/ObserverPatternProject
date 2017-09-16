import Observables.WeatherStation;
import Observers.PhoneDisplay;
import Observers.WallDisplay;

import java.lang.String;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Observator pattern!");
        Scanner keyboard = new Scanner(System.in);

        WeatherStation weatherStation = new WeatherStation();
        Thread calcaulateTemerature = new Thread(weatherStation);
        calcaulateTemerature.start();
        PhoneDisplay phoneDisplay = new PhoneDisplay(weatherStation);
        WallDisplay  wallDisplay  = new WallDisplay(weatherStation);

        weatherStation.add(phoneDisplay);
        weatherStation.add(wallDisplay);



        int i = 10;
        for(int j = 0 ;j<i;j++) {
            System.out.format("Iteration: %s\n",j+1);
            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                System.out.println("Main thread cannot sleep");
            }
            weatherStation.getTemperature();
            weatherStation.notifyObservers();

            phoneDisplay.display();
            wallDisplay.display();
        }

        weatherStation.remove(phoneDisplay);
        weatherStation.remove(wallDisplay);
        calcaulateTemerature.interrupt();
    }
}
