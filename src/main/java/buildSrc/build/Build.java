package buildSrc.build;

public class Build {

    private String buildVersion;

    public Build() {
        this("build #000");
    }

        this.buildVersion = buildVersion;

    }
// change in DEF branch new change
// bugfix done on main branch
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
