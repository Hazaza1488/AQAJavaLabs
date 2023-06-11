package Task_13;

import org.apache.log4j.Logger;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class SuiteListener implements IInvokedMethodListener {
    protected final Logger LOGGER = Logger.getLogger(this.getClass());

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        LOGGER.info("Before invocation of method: " + method.getTestMethod().getMethodName());
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        LOGGER.info("After invocation of method: " + method.getTestMethod().getMethodName());
    }
}
