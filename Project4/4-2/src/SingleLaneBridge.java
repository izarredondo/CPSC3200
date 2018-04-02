/*
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
 
public class SingleLaneBridge {
 
    public static void main(String[] args) 
    {
        final Bridge bridge = new Bridge();
         
        Thread thNorthbound = new Thread( new Runnable() {
             
            @Override
            public void run() {
             
                while(true)
                {
                    Farmer farmer = new Farmer(bridge);
                    Thread th = new Thread(farmer);
                    farmer.setName("North Farmer : "+th.getId());
                    th.start();
                    try
                    {
                        TimeUnit.SECONDS.sleep((long)(Math.random()*10));
                    }
                    catch(InterruptedException iex)
                    {
                        iex.printStackTrace();
                    }
                }
                 
            }
        });
         
        Thread thSouthbound = new Thread( new Runnable() {
             
            @Override
            public void run() {
                 
                while(true)
                {
                    Farmer farmer = new Farmer(bridge);
                    Thread th = new Thread(farmer);
                    farmer.setName("South Farmer : "+th.getId());
                    th.start();
                    try
                    {
                        TimeUnit.SECONDS.sleep((long)(Math.random()*10));
                    }
                    catch(InterruptedException iex)
                    {
                        iex.printStackTrace();
                    }
                }
            }
        });
         
        thNorthbound.start();
        thSouthbound.start();
    }
 
}
 
class Bridge
{
    private final Semaphore semaphore;
     
    public Bridge()
    {
        semaphore = new Semaphore(1);
    }
    public void crossBridge(Farmer farmer)
    {
        try
        {
            System.out.printf("Farmer %s is trying to cross the bridge.\n",farmer.getName());
            semaphore.acquire();
            System.out.printf("Farmer %s is crossing the bridge.\n",farmer.getName());
            long duration = (long)(Math.random() * 10);
            TimeUnit.SECONDS.sleep(duration);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        finally
        {
            System.out.printf("Farmer %s has crossed the bridge.\n",farmer.getName());
            semaphore.release();
        }
    }
}
 
class Farmer implements Runnable
{
    private String name;
    private Bridge bridge;
     
    public Farmer(Bridge bridge)
    {
        this.bridge = bridge;
    }
     
    public void run()
    {
        bridge.crossBridge(this);
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
}
*/
