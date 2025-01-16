package buildSrc.build;

public class Build {

    private String buildVersion;

    public Build() {
        this("build #000");
    }

        this.buildVersion = buildVersion;

    }

    public Build(String buildVersion) {
        this.buildVersion = buildVersion;
    }

    public String getBuildVersion() {
        return buildVersion;
    }

    public void setBuildVersion(String buildVersion) {
        this.buildVersion = buildVersion;
    }

}
