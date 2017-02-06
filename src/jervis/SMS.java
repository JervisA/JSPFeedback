package jervis;

/**
 * Created by Dominic on 5/2/2017.
 */
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SMS {
    // Find your Account Sid and Token at twilio.com/user/account
    public static final String ACCOUNT_SID = "ACde9a9c2ba74d7eb613963867b27d5e46";
    public static final String AUTH_TOKEN = "3dbedb992280a3f0301fcca96ca43f89";

    public static void main(String[] args) {
//        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//
//        Message message = Message.creator(new PhoneNumber("+6593265717"),
//                new PhoneNumber("(630) 313-2580"),
//                "sms").create();
//
//        System.out.println(message.getSid());
        SMS.method("+6597430007","testing");
    }
    public static void method(String num, String msg){
     String ACCOUNT_SID = "ACde9a9c2ba74d7eb613963867b27d5e46";
     String AUTH_TOKEN = "3dbedb992280a3f0301fcca96ca43f89";
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(num),
                new PhoneNumber("(805) 250-4112"),
                msg).create();

        System.out.println(message.getSid());
    }

}