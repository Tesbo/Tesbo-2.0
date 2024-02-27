package Framework.core.readers;

import com.beust.jcommander.Parameter;

public class CommandlineOption {


    @Parameter(
            names = {"--config","-c"},
            description = "Configuration to run",
            required = true
    )
    private String FileName;

    public String getConfigName() {
        return FileName;
    }

    public void setConfigFile(String FileName) {
        this.FileName = FileName;
    }
}
