package Observers;

import Observables.WeatherStation;

public class WallDisplay implements IObserver {
    public WallDisplay(WeatherStation weatherStation){
        this.weatherStation = weatherStation;
    }

    public void update(){
        temperature = weatherStation.getTemperature();
    }

    public void display()
    {
        System.out.format("Wall display has a new temperature. It is equal: %s \n",temperature);
    }

    double temperature;
    WeatherStation weatherStation;
}


