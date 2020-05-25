package lt.vu.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.io.Serializable;
import java.util.Random;

@ApplicationScoped
@Alternative
public class RandomNumberNameGenerator2 implements IRandomNameGenerator, Serializable {

    @Override
    public String generateRandomName() {
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e ){

        }
        return "Random name" + new Random().nextInt(100);
    }
}
