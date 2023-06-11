package Task_13;

import org.apache.log4j.Logger;
import org.testng.IExecutionListener;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class ExecutionListener implements IInvokedMethodListener, IExecutionListener {
    protected final Logger LOGGER = Logger.getLogger(this.getClass());

    @Override
    public void onExecutionFinish() {
        LOGGER.info("Execution finished");
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        // Do nothing
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        LOGGER.info("After invocation of method: " + method.getTestMethod().getMethodName());
    }
}
