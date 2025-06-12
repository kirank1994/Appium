package walmart.mobileautomation.CI_CD;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

@Test
public class JenkinsParams {
    private static Properties props = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            props.load(fis);
        } catch (Exception e) {
            System.out.println("Could not load config.properties");
        }
    }

    public static String getTagName() {
        String value = System.getProperty("TAG_NAME");
        if (value != null) return value;
        return props.getProperty("TAG_NAME");
    }

    public static String getAppName() {
        String value = System.getProperty("APP_NAME");
        if (value != null) return value;
        return props.getProperty("APP_NAME");
    }

    public static String getRepoUrl() {
        String value = System.getProperty("REPO_URL");
        if (value != null) return value;
        return props.getProperty("REPO_URL");
    }

    public static String getBranchName() {
        String value = System.getProperty("BRANCH_NAME");
        if (value != null) return value;
        return props.getProperty("BRANCH_NAME");
    }
}