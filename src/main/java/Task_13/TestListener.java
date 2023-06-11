package Task_13;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    protected final Logger LOGGER = Logger.getLogger(this.getClass());

    @Override
    public void onTestStart(ITestResult result) {
        LOGGER.info("Test started: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        LOGGER.fatal("Test failed: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LOGGER.info("Test skipped: " + result.getName());
    }

    // Implement the remaining methods as per your requirements
}
