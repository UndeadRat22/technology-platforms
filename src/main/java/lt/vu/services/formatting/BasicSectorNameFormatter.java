package lt.vu.services.formatting;

import javax.enterprise.context.ApplicationScoped;
import java.util.Arrays;

@ApplicationScoped
public class BasicSectorNameFormatter implements ISectorNameFormatter {

    @Override
    public String format(String name) {
        String[] parts = name.toLowerCase().split(" ");
        String output = "";
        for (String part: parts) {
            output += Character.toString(part.charAt(0)).toUpperCase() + part.substring(1) + " ";
        }
        return output;
    }
}
