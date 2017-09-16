package Observables;

import Observers.IObserver;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class WeatherStation  implements IObservable, Runnable {

    public WeatherStation()
    {
        listObservers = new ArrayList<IObserver>();
    }

    public void add(IObserver objectObserver)
    {
        for(IObserver object : listObservers)
            if(object == objectObserver)
                return;
        listObservers.add(objectObserver);
    }
    public void remove(IObserver objectObserver)
    {
        if(listObservers.contains(objectObserver));
        {
            listObservers.remove(objectObserver);
        }
    }

    public void notifyObservers()
    {
        for(IObserver observer : listObservers)
        {
            observer.update();
        }
    }

    public double getTemperature(){
        return temperature;
    }

    private void calculateTemperature()
    {
        Random r = new Random();
        temperature = r.nextDouble() * 50;
        boolean signPlus = r.nextBoolean();
        if(!signPlus)
            temperature=temperature*-1.0;
    }

    public void run()
    {
        for(;;) {
            calculateTemperature();
            try {
                Random r = new Random();
                int timeOfChange = r.nextInt(5000);
                Thread.sleep(timeOfChange);
            }
            catch(InterruptedException e)
            {
                System.out.println("\nThread has been interrupted");
                break;
            }
        }
    }

    double temperature;
    private ArrayList<IObserver> listObservers;

}
