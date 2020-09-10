package ui;

import guardhat_ui.general_setup.jira.JiraTicket;
import guardhat_ui.general_setup.ui_helper.DriverHelper;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.io.*;

public class BaseTest implements IHookable {
    private static final Logger LOGGER = Logger.getLogger("projects_tests.ui.BaseTest");
    private final WebDriver driver = DriverHelper.get().getDriver();


    @AfterMethod
    public void tearDown() {
        DriverHelper.get().quitDriver(DriverHelper.get().getDriver());
    }

    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        callBack.runTestMethod(testResult);
        if (testResult.getThrowable() != null) {
            try {
                takeScreenshot(testResult.getMethod().getMethodName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Attachment(value = "Failure in method {0}", type = "image/png")
    private byte[] takeScreenshot(String methodName) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("./target/screenshots/" + methodName + ".png"));
        LOGGER.error("****** Taking a screenshot on failure");
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @AfterMethod
    public void createJiraTicketFailCase(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            JiraTicket.createIssueJira(result, JiraTicket.JIRA_URL, JiraTicket.KEY,
                    "[FAILED] " + result.getMethod().getMethodName(),
                    JiraTicket.getCURRENT_DATE_TIME() + "   " + String.valueOf(result.getThrowable()),
                    driver.getCurrentUrl(), JiraTicket.ISSUE_TYPE_BUG);
        }
    }

}
