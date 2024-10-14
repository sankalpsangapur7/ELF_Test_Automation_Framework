package businessLogic;

	import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
	import com.tyss.optimize.nlp.util.NlpException;
	import com.tyss.optimize.nlp.util.NlpRequestModel;
	import com.tyss.optimize.nlp.util.NlpResponseModel;
	import com.tyss.optimize.nlp.util.annotation.InputParam;
	import com.tyss.optimize.nlp.util.annotation.InputParams;
	import com.tyss.optimize.nlp.util.annotation.ReturnType;
	import java.util.Map;
	import java.util.ArrayList;
	import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Component;

	@Component("LIC12620_PJT1001_PE_NLP157c5d62-57de-4928-89b1-6294b60cc7d8")
public class scrollUntilElement implements Nlp {
	    @InputParams({@InputParam(name = "xpath", type = "java.lang.String")})
	    

	      @Override
	      public List<String> getTestParameters() throws NlpException {
	        List<String> params = new ArrayList<>();
	        return params;
	      }

	      @Override
	      public StringBuilder getTestCode() throws NlpException {
	        StringBuilder sb = new StringBuilder();
	        return sb;
	      }
	      @Override
	      public NlpResponseModel execute(NlpRequestModel nlpRequestModel) throws NlpException {
	        
	          NlpResponseModel nlpResponseModel = new NlpResponseModel();
	          Map<String, Object> attributes = nlpRequestModel.getAttributes();
	          WebDriver driver=(WebDriver) nlpRequestModel.getDriver().getSpecificIDriver();
	          String xpath = (String) attributes.get("xpath");

	          // Your program element business logic goes here ...
	          try { 
	        	 
	        	   WebElement  element=driver.findElement(By.xpath(xpath));
	      		   JavascriptExecutor js=(JavascriptExecutor) driver;
	      		   js.executeScript("arguments[0].scrollIntoView();",element);
	        	  nlpResponseModel.setStatus(CommonConstants.pass);
	        	  nlpResponseModel.setMessage("scrolled to element");
	        
	          }
	          catch (Exception e) {
	        	  nlpResponseModel.setStatus(CommonConstants.fail);
	        	  nlpResponseModel.setMessage("element is not found");
	          }
	          
	          return nlpResponseModel;
	      }
	  } 
