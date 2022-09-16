package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext ;
import org.testng.ITestListener ;
import org.testng.ITestResult ;

public class ListenerTest implements ITestListener
{
    ExtentReports extend;
    ExtentSparkReporter spark;
    ExtentTest parentTest;

    @Override
    public void onFinish(ITestContext arg0) {
        extend.flush();
    }

    @Override
    public void onStart(ITestContext arg0) {
        extend = new ExtentReports();
        spark = new ExtentSparkReporter("extent-reports/extent-report.html");
        spark.config().setDocumentTitle("Extent Report");
        extend.attachReporter(spark);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailure(ITestResult testCase) {
        System.out.println("The name of the testcase failed is :"+testCase.getName());
        parentTest = extend.createTest(testCase.getName()).log(Status.FAIL, "fail: "+testCase.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult testCase) {
        System.out.println("The name of the testcase skipped is :"+testCase.getName());
        parentTest = extend.createTest(testCase.getName()).log(Status.SKIP, "skipped");
    }

    @Override
    public void onTestStart(ITestResult testCase) {
        System.out.println("The name of the testcase started is :"+testCase.getName());
    }

    @Override
    public void onTestSuccess(ITestResult testCase) {
        System.out.println("The name of the testcase success is :"+testCase.getName());
        parentTest = extend.createTest(testCase.getName()).log(Status.PASS, "passed");

    }
}
