package upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

public class UploadServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<String> types = Arrays.asList(".jpg",".gif",".avi",".txt"); //supported type
		
		DiskFileItemFactory dfi = new DiskFileItemFactory(); // apache's component
		
		dfi.setSizeThreshold(1024*1024); //1M, and default is 10k, and excessed will be saved in the cache file
		String path = getServletContext().getRealPath("/temp") ;  
		dfi.setRepository(new File(path));  //temporary cached file
		
		ServletFileUpload sf = new ServletFileUpload(dfi);
		sf.setHeaderEncoding("utf-8");
//		sf.setFileSizeMax(1024*1024*5); //set single file's max size
		
		
		if (!ServletFileUpload.isMultipartContent(request)) {  //other type return;
			return;
		}
		
		try {
			List<FileItem> lf = sf.parseRequest(new ServletRequestContext(
					request));

			for (FileItem item : lf) {
				if (item.isFormField()) { // ordinary input
					String name = item.getFieldName();
					String value = item.getString("utf-8");
					System.out.println(name + " " + value);
				} else { // stream
					String name = item.getName();
					if (name == null || "".equals(name)) {
						continue;
					}
					String ext = name.substring(name.lastIndexOf("."));
System.out.println(ext);
					if (!types.contains(ext)) {
						request.setAttribute("message", "sorryia..  i don't support type "+ext);
						request.getRequestDispatcher("/message.jsp").forward(request, response);
						return;
					}
					InputStream is = item.getInputStream();
					
					String Spath = getServletContext().getRealPath("/WEB-INF/upload/"); //can't be accessed by outside 
					System.out.println(Spath);
					FileOutputStream fos = new FileOutputStream(new File(Spath
							+ name));

					byte[] b = new byte[1024];
					int len = 0;
					while ((len = is.read(b)) > 0) {
						fos.write(b);
					}
					fos.close();
					is.close();
					
					item.delete();  //the temporary file would be deleted.
				}
			}
		} /*catch(FileSizeLimitExceededException e) {
			request.setAttribute("message", "the file's size is over 5m..");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}*/ catch (FileUploadException e) {
			throw new RuntimeException(e);
		}
	}
}
