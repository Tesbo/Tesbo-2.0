package io.unity.framework.readers;

import com.beust.jcommander.Parameter;

public class CommandlineOption {


    @Parameter(
            names = {"--config","-c"},
            description = "Configuration to run",
            required = true
    )
    private String configName;

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }
}
