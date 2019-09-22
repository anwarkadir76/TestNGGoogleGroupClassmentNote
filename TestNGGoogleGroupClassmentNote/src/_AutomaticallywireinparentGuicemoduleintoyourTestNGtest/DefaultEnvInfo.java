package _AutomaticallywireinparentGuicemoduleintoyourTestNGtest;

import org.testng.annotations.Test;

public class DefaultEnvInfo implements EnvInfo {
    @Override
    public String getBrowserFlavor() {
        //Keeping it simple for the sake of example. 
        //You can make it fancy by having this read from JVM arguments.
        return "firefox";
    }
}