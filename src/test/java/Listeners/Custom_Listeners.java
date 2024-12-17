package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;


public class Custom_Listeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result)
    {
        //when test method starts
        System.out.println("on Test Start -> Test Name: " + result.getName());
    }

    @Override
    public   void onTestSuccess(ITestResult result)
    {
        //when test method success
        System.out.println("On Test success -> Test Name: " + result.getName());
    }
}
