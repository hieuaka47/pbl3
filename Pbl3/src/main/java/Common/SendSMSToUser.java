package Common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.twilio.Twilio;
import com.twilio.http.HttpClient;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import Common.SendSMS;
import DAO.UserDAOImpl;
import Model.Email;
import Model.User;
/**
 * Servlet implementation class SendSMS
 */
@WebServlet("/sendSMS")
public class SendSMSToUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAOImpl userDAO = new UserDAOImpl();
    
    public static final String ACCOUNT_SID = "AC35c17f7117bce4469d5193af1f7c6c30";
    public static final String AUTH_TOKEN = "42d11dc740f1b1346696c35e070ad0bf";
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String phoneNumber	= request.getParameter("phone");
			User user = userDAO.findUserByPhone(phoneNumber);
			
			if (user == null) {
				request.setAttribute("message", "incorrect");
			} else {
				String ACCOUNT_SID = "AC35c17f7117bce4469d5193af1f7c6c30";
				String AUTH_TOKEN = "22f8ff5c83786f2cbd69796e95b89a7d";
				String arr[] = phoneNumber.split("0", 2);
				Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		        Message message = Message.creator(
		                new com.twilio.type.PhoneNumber("+84" + arr[1]),
		                new com.twilio.type.PhoneNumber("+19803006356"),
		                "Ăn có cái pass không cũng quên dm :v \nPass của Ngài đây: "+ user.getPassword())
		            .create();
				System.out.println(message.getSid());
				request.setAttribute("message", "correct");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
