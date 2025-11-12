package buildSrc.build;

public class Build {

    private String buildVersion;
// change
    public Build() {
        this("build #000");
    }

        this.buildVersion = buildVersion;
// change on NewBranch1
    }
// change in build on main branch
    public Build(String buildVersion) {
        this.buildVersion = buildVersion;
    }
// change to be updated
    public String getBuildVersion() {
        return buildVersion;
    }

    public void setBuildVersion(String buildVersion) {
        this.buildVersion = buildVersion;
    }

}
