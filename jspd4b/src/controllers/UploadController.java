package controllers;

import java.io.File;
import java.io.IOException;
import java.nio.channels.SeekableByteChannel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig
public class UploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DIR_UPLOAD = "uploads";
	public UploadController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			RequestDispatcher rd = request.getRequestDispatcher("/views/upload.jsp");
			rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String username = request.getParameter("username");
			String age = request.getParameter("age");
			//processing upload file
			//infomation file
			Part filePart = request.getPart("avatar");
		/*
		 * System.out.println("File name: " + filePart.getSubmittedFileName());
		 * System.out.println( filePart.getName()); //Input name
		 * System.out.println("Size: " + filePart.getSize());
		 * System.out.println(filePart.getContentType());
		 */
			
			//get file name
			String fileName = filePart.getSubmittedFileName();
			if (!"".equals(fileName)) {
				//upload file
				//1. Have info file 
				//2.Di chuyển file den noi can upload
				String webPathRoot = request.getServletContext().getRealPath("");
				String dirUpload   = webPathRoot + DIR_UPLOAD;
				File fileDirUpload = new File(dirUpload);
				//nếu chưa tồn tại thư mục thì tạo ra
				if (!fileDirUpload.exists()) {
					fileDirUpload.mkdirs();
					//mkdirs: đường dẫn có nhiều / / >< mkdir
				}
				//system.nanoTime(); 
				String filePath = dirUpload + File.separator + fileName;
				//upload file to WebSever
				filePart.write(filePath);
				System.out.println(filePath);
				response.getWriter().print("UPLOAD FILE COMPLETE");
				//System.out.println(request.getServletContext().getRealPath(""));
			}
	}

}




