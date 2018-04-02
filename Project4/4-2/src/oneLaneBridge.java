/*
 * CPSC 2800 -- 46267
 * 10/27/16
 * Project 4-1 
 * by Izabella Arredondo -- CBZ848
 * 
 * This program simulates a one lane bridge with east and westbound traffic. 
 */

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
 
public class oneLaneBridge {
 
    public static void main(String[] args) 
    {
        final Bridge bridge = new Bridge();								// create the bridge
         
        Thread thEast = new Thread(new Runnable() {						// create thread for eastbound traffic
            @Override
            public void run() 
            {
            	while(true)
                {
                    Vehicle vehicle = new Vehicle(bridge);				// create new vehicle 
                    Thread th = new Thread(vehicle);					// create vehicle thread
                    vehicle.setName("Eastbound Vehicle "+th.getId());	// name vehicle with thread #
                    th.start();											// begin thread
                    try
                    {
                        TimeUnit.SECONDS.sleep((long)(Math.random()*10));	// pause execution
                    }
                    catch(InterruptedException iex)
                    {
                        iex.printStackTrace();	
                    }
                }
            }
        });
         
        Thread thWest = new Thread(new Runnable() {						// create thread for westbound traffic
            @Override
            public void run() 
            {
                while(true)
                {
                    Vehicle vehicle = new Vehicle(bridge);				// create new vehicle
                    Thread th = new Thread(vehicle);					// create vehicle thread
                    vehicle.setName("Westbound Vehicle "+th.getId());	// name vehicle with thread #
                    th.start();											// begin thread
                    try
                    {
                        TimeUnit.SECONDS.sleep((long)(Math.random()*10));	// pause execution
                    }
                    catch(InterruptedException iex)
                    {
                        iex.printStackTrace();
                    }
                }
            }
        });
         
        thEast.start();		// begin eastbound thread
        thWest.start();		// begin westbound thread 
    }
 
}
 
class Bridge
{
    private final Semaphore semaphore;
     
    public Bridge()
    {
        semaphore = new Semaphore(1);			// create semaphore
    }
    public void crossBridge(Vehicle vehicle)	
    {
        try
        {
        	//initial state is attempting to cross
            System.out.printf("%s is attempting to cross the bridge.\n",vehicle.getName());
            // acquire semaphore to cross bridge
            semaphore.acquire();
            System.out.printf("%s is crossing the bridge.\n",vehicle.getName());
            // time to cross
            long duration = (long)(Math.random() * 10);
            // sleep while crossing
            TimeUnit.SECONDS.sleep(duration);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        finally
        {
        	// final state of completed crossing, semaphore released
            System.out.printf("%s has crossed the bridge.\n",vehicle.getName());
            semaphore.release();
        }
    }
}
 
class Vehicle implements Runnable		// Giving the thread what to run
{
    private String name;
    private Bridge bridge;
     
    public Vehicle(Bridge bridge)	
    {
        this.bridge = bridge;			// assign to bridge
    }
     
    public void run()				 
    {
        bridge.crossBridge(this);		// cross bridge 
    }
 
    public String getName() {
        return name;					
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
}

