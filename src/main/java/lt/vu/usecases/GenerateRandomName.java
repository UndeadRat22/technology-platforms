package lt.vu.usecases;

import lt.vu.interceptors.LoggedInvocation;
import lt.vu.services.ParameterCollector;
import lt.vu.services.RandomNameGenerator;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class GenerateRandomName implements Serializable {
    @Inject
    private RandomNameGenerator randomNameGenerator;

    @Inject
    private ParameterCollector parameterCollector;

    private CompletableFuture<String> nameGenerationTask = null;

    @LoggedInvocation
    public String generateNewName(){
        Integer doctorId = parameterCollector.getInt("doctorId");

        nameGenerationTask = CompletableFuture.supplyAsync(() -> randomNameGenerator.generateRandomName());

        return "doctors?faces-redirect=true&doctorId=" + doctorId.toString();
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
        return "Suggested doctor name number: " + nameGenerationTask.get();
    }
}
