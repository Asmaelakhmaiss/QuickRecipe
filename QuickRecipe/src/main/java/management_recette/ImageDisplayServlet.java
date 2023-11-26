package management_recette;
import java.io.File;
import java.io.FileInputStream;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Servlet implementation class ImageDisplayServlet
 */
@WebServlet("/imageDisplay")
public class ImageDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageDisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  String imageName = request.getParameter("name");
	        String imagePath = "C:/Users/HP/eclipse-workspace/QuickRecipe/src/main/webapp/Images_temp/"+ imageName; // Assurez-vous que le chemin est correct

	        File imageFile = new File(imagePath);
	        response.setContentType(getServletContext().getMimeType(imageFile.getName()));
	        response.setContentLengthLong(imageFile.length());
	        try (FileInputStream in = new FileInputStream(imageFile); OutputStream out = response.getOutputStream()) {
	            byte[] buffer = new byte[1024];
	            int numBytesRead;
	            while ((numBytesRead = in.read(buffer)) > 0) {
	                out.write(buffer, 0, numBytesRead);
	            }
	        }
	        
	        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
