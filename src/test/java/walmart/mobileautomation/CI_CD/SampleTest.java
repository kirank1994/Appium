package walmart.mobileautomation.CI_CD;

import org.testng.annotations.Test;

public class SampleTest {

    @Test
    public void runTest() {
        System.out.println("Running App: " + ConfigUtil.getAppName());
        System.out.println("Repo: " + ConfigUtil.getRepoUrl());
        System.out.println("Branch: " + ConfigUtil.getBranchName());
        System.out.println("Tag: " + ConfigUtil.getTagName());

        // Use these values in logic (e.g., choosing APKs, config, logs, etc.)
    }
}
