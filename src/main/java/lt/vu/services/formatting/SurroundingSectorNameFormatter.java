package lt.vu.services.formatting;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;

@Specializes
@ApplicationScoped
public class SurroundingSectorNameFormatter extends BasicSectorNameFormatter {
    @Override
    public String format(String name) {
        String output = super.format(name);
        return "[ " + output + "]";
    }
}
