package _AutomaticallywireinparentGuicemoduleintoyourTestNGtest;

import com.google.inject.Binder;
import com.google.inject.Module;
 
public class WebDriverModule implements Module {
    @Override
    public void configure(Binder binder) {
        binder.bind(WebDriverProducer.class).to(DefaultWebDriverProducerImpl.class);
    }
}