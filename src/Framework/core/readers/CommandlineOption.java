package Framework.core.readers;

import com.beust.jcommander.Parameter;

public class CommandlineOption {


    @Parameter(
            names = {"--config","-c"},
            description = "Configuration to run",
            required = true
    )
    private String configFile;

    public String getConfigName() {
        return configFile;
    }

    public void setConfigFile(String configFile) {
        this.configFile = configFile;
    }
}
