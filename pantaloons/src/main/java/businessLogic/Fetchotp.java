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

import org.springframework.stereotype.Component;


public class Fetchotp implements Nlp {
    @InputParams({@InputParam(name = "otpText", type = "java.lang.String"), @InputParam(name = "startString", type = "java.lang.String")})
    @ReturnType(name = "otpValue", type = "java.lang.String")

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
          String otpText = (String) attributes.get("otpText");
          String startString = (String) attributes.get("startString");
         
          String otpValue="";
          
          // Your program element business logic goes here ...
          int indexOfIs = otpText.indexOf(startString);
          
        try {
          if (indexOfIs != -1) {
        	// Adding 3 to skip "is"
              String otpSubstring = otpText.substring(indexOfIs + 3).trim(); 
              
              // Find the first space to get the OTP
              int indexOfSpace = otpSubstring.indexOf(" ");
              
              if (indexOfSpace != -1) {
                  String otp = otpSubstring.substring(0, indexOfSpace);
                  otpValue=otp;
                 nlpResponseModel.setStatus(CommonConstants.pass);
 	        	 nlpResponseModel.setMessage(otp);
                
              } 
              else {
            	  nlpResponseModel.setStatus(CommonConstants.fail);
 	        	 nlpResponseModel.setMessage("Failed to Fetch Otp");
              }
          }
          else {
        	  nlpResponseModel.setStatus(CommonConstants.fail);
	          nlpResponseModel.setMessage("Failed to Fetch Otp");
          }
        }
        
          catch (Exception e) {
        	 nlpResponseModel.setStatus(CommonConstants.fail);
	         nlpResponseModel.setMessage("Failed to Fetch Otp");
		}
     
          
          nlpResponseModel.getAttributes().put("otpValue",otpValue);
          return nlpResponseModel;
      }
  } 
