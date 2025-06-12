package walmart.mobileautomation.CI_CD;

import walmart.mobileautomation.utils.ConfigReader;

public class ConfigUtil {
    public static String getTagName() {
        return System.getProperty("TAG_NAME", ConfigReader.getProperty("TAG_NAME"));
    }

    public static String getAppName() {
        return System.getProperty("APP_NAME", ConfigReader.getProperty("APP_NAME"));
    }

    public static String getRepoUrl() {
        return System.getProperty("REPO_URL", ConfigReader.getProperty("REPO_URL"));
    }

    public static String getBranchName() {
        return System.getProperty("BRANCH_NAME", ConfigReader.getProperty("BRANCH_NAME"));
    }
}
