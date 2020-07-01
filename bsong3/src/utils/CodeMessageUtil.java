package utils;

import java.io.PrintWriter;

import javax.servlet.jsp.JspWriter;

public class CodeMessageUtil {
	public static final int ADD_SUCCESS = 1;
	public static final int EDIT_SUCCESS = 2;
	public static final int DELETE_SUCCESS = 3;
	public static final int ERROR_HAD_NAME = 4;
	public static final int ERROR_NO_ID = 5;
	public static final int ERROR_NO_PERMISSION_ADD = 6;
	public static final int ERROR_NO_PERMISSION_DELETE = 7;
	public static final int ERROR_NO_PERMISSION_EDIT = 8;
	public static final int ERROR = 0;
	
	public static String displayMessage(JspWriter out, String msg) {
		String result = "";
		if (!"".equals(msg)) {
			result = "<h3 class='error' style='color:red'>"+msg+" </h3>";
		}		
		return result;
		
	}
	
}
