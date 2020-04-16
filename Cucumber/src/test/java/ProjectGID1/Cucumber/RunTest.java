package ProjectGID1.Cucumber;



	import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
	import cucumber.api.junit.Cucumber;


	@RunWith(Cucumber.class) 
	@CucumberOptions(features ="Features",glue= "gluecode"
	,plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json" }, 
        monochrome = true	        
           )
	public class RunTest {
		
//		@AfterClass
//	    public static void writeExtentReport() {
//	        Reporter.loadXMLConfig(new File("config/config.xml"));
//	    
		//}

	}
	//,glue={"loginTest"})
	// plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}