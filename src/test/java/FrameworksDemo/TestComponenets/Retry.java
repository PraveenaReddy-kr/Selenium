package FrameworksDemo.TestComponenets;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

	int count=0;
	int MaxTry=1;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		count++;
		if(count<MaxTry) {
			return true;
		}
		
		return false;
	}

}
