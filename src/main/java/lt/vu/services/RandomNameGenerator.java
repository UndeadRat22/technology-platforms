package lt.vu.services;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Random;

@ApplicationScoped
public class RandomNameGenerator implements Serializable {
    public String generateRandomName() {
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e ){

        }
        return "Random";
    }
}
