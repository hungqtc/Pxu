package utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthUtil {
	public static boolean isLogin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("userInfo") == null) {			
			return false;
		}
		return true;		
	}
}
