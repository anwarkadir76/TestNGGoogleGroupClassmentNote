package _AutomaticallywireinparentGuicemoduleintoyourTestNGtest;

import org.testng.annotations.Test;
import com.google.inject.AbstractModule;

public class DefaultParentModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(EnvInfo.class).to(DefaultEnvInfo.class);
    }
}