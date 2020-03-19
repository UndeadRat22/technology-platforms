package lt.vu.usecases;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

@Named
@SessionScoped
public class TestComponent implements Serializable {

    @Inject
    private BeComponent beComponent;

    public String sayHello() {
        return "Labas " + new Date() + " " + beComponent.getClass().getName() + " " + toString();
    }
    @PostConstruct
    public void init() {
        System.out.println(toString() + " constructed.");
    }

    @PreDestroy
    public void gonDieBietch(){
        System.out.println(toString() + " ready to die");
    }
}
