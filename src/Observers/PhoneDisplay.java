package Observers;
import Observables.WeatherStation;

import java.text.DecimalFormat;

public class PhoneDisplay implements IObserver {
    public PhoneDisplay(WeatherStation weatherStation){
        this.weatherStation = weatherStation;
    }

    public void update(){
        temperature = weatherStation.getTemperature();
    }

    public void display()
    {
        DecimalFormat df = new DecimalFormat("#,##");
        temperature =  Double.parseDouble(df.format(temperature));
        System.out.format("Phone display has a new temperature. It is equal: %s \n",temperature);
    }

    double temperature;
     WeatherStation weatherStation;
}
