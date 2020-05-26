package lt.vu.usecases;

import lt.vu.interceptors.LoggedInvocation;
import lt.vu.services.IRandomNameGenerator;
import lt.vu.services.ParameterCollector;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class GenerateRandomName implements Serializable {
    @Inject
    private IRandomNameGenerator randomNameGenerator;
    @Inject
    private ParameterCollector parameterCollector;


    private CompletableFuture<String> nameGenerationTask = null;

    @LoggedInvocation
    public String generateNewName(){
        String id = parameterCollector.get("doctorId");

        nameGenerationTask = CompletableFuture.supplyAsync(() -> randomNameGenerator.generateRandomName());

        return "doctors?faces-redirect=true&doctorId=" + id;
    }

    @LoggedInvocation
    public boolean isGeneratorRunning(){
        return nameGenerationTask != null && !nameGenerationTask.isDone();
    }

    public String getNameGenerationStatus() throws ExecutionException, InterruptedException {
        if (nameGenerationTask == null) {
            return null;
        } else if (isGeneratorRunning()) {
            return "Generation in progress";
        }
        return "Suggested doctor name: " + nameGenerationTask.get();
    }
}
