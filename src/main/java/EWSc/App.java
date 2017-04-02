package EWSc;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class App {
    static int totalWarsCount = 0;
    static volatile ArrayList<JSONObject> list = new ArrayList<JSONObject>();
    public static void  main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello World!");
        MaxWars.MaxWarsCount();
        ExecutorService executor = Executors.newFixedThreadPool(8);
        for(int i=totalWarsCount-8950; i<=totalWarsCount; i++){
            Thread t = new WarFinder(i);
            executor.execute(t);
        }
        executor.shutdown();
        while(true) {
            Thread.sleep(100);
            if (executor.isTerminated()) {
                System.out.println("Done");
                break;
            }
        }

        //TimeManagement tM = new TimeManagement();
        //System.out.println(tM.getDate());
    }
}