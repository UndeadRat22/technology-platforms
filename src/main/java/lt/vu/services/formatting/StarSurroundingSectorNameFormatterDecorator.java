package lt.vu.services.formatting;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public class StarSurroundingSectorNameFormatterDecorator implements ISectorNameFormatter {

    @Inject @Delegate @Any
    private ISectorNameFormatter baseFormatter;

    @Override
    public String format(String name) {
        String baseName = baseFormatter.format(name);
        return "*"+baseName+"*";
    }
}
