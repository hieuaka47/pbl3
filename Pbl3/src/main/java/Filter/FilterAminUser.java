package Filter;

import java.io.IOException;
import java.net.URL;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import Model.User;

@WebFilter(urlPatterns = {"/cart", "/add-to-cart", "/history_order_user"})
public class FilterAminUser implements Filter{
	
	@Override
	public void destroy() {

	}

	@SuppressWarnings("unused")
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain arg2)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		HttpSession session = req.getSession(false);
		
		String url = req.getServletPath();
		String urlGet = req.getRequestURL().toString();
		String serverPath = req.getRequestURL().substring(0,req.getRequestURL().indexOf(url));
		URL urlPath = new URL(serverPath);
		
		User u = (User) session.getAttribute("acc");
		if (u != null && u.getRole().equals("1")) {
			resp.sendRedirect(urlPath+"/page404");
			return;
		} else  {
			arg2.doFilter(request, response);
			return;
		}
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
