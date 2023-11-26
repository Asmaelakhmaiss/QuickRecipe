package management_recette;

import jakarta.servlet.ServletException;
import java.io.File;
import java.nio.file.Paths;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet(name = "DeleteServlet", urlPatterns = {"/DeleteServlet"})
public class DeleteServlet extends HttpServlet {
	private static final String IMAGE_DIR = "C:/Users/HP/eclipse-workspace/QuickRecipe/src/main/webapp/Images_temp/";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String idParam = request.getParameter("id");
	        boolean success = false;
	        if (idParam != null && !idParam.trim().isEmpty()) {
	            long id = Long.parseLong(idParam);
	            RecipeDAO dao = new RecipeDAO();
	            String image_path= dao.getImagePathById(id);
	            System.out.println(image_path);
	            File file = new File(IMAGE_DIR+image_path);
	            if (file.exists() && !file.isDirectory()) {
	                boolean isDeleted = file.delete();
	                if (isDeleted) {
	                    // Le fichier a été supprimé avec succès
	                } else {
	                    // La suppression a échoué
	                }
	            } else {
	                // Le fichier n'existe pas ou est un répertoire
	            }
	            
	            if (dao.deleteRecetteById(id)) { // Supprime l'enregistrement de la base de données
	                success = true;
	            }
}
	        
	        
	        // Redirection avec un paramètre indiquant le succès de la suppression
	        response.sendRedirect("admin_Recipe_Validation.jsp?deletionSuccess=" + success + "&deletedId=" + idParam);
	    }


	 
}



