package Common;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SendSMS {
    public static final String ACCOUNT_SID = "AC35c17f7117bce4469d5193af1f7c6c30";
    public static final String AUTH_TOKEN = "42d11dc740f1b1346696c35e070ad0bf";
    
    public void send() {
//        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//        Message message = Message.creator(
//                new com.twilio.type.PhoneNumber("+84915789629"),
//                new com.twilio.type.PhoneNumber("+19803006356"),
//                "Ăn có cái pass không cũng quên dm :v")
//            .create();
//        System.out.println(message.getSid());
    	
    }
    
    public static void main(String[] args) {
        SendSMS a = new SendSMS();
        a.send();
    }
}
