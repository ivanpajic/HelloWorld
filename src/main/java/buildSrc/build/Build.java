package buildSrc.build;

public class Build {

    private String buildVersion;
// change
    public Build() {
        this("build #000");
    }
// change
        this.buildVersion = buildVersion;

    }
// change in build on main branch
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
