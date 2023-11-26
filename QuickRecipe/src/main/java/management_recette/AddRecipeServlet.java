package management_recette;

import jakarta.servlet.ServletException;



import jakarta.servlet.annotation.MultipartConfig;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.http.Part;
import jakarta.servlet.http.HttpSession;
import java.io.File;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

/**
 * Servlet implementation class AddRecipeServlet
 */
@WebServlet(name = "AddRecipeServlet", urlPatterns = {"/AddRecipeServlet"})
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
	    maxFileSize = 1024 * 1024 * 10,      // 10MB
	    maxRequestSize = 1024 * 1024 * 50    // 50MB
	)
public class AddRecipeServlet extends HttpServlet {
	

	 private static final String IMAGE_DIR = "C:/Users/HP/eclipse-workspace/QuickRecipe/src/main/webapp/Images_temp/";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRecipeServlet() {
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
		/* HttpSession session = request.getSession(false); // ne crée pas de session si elle n'existe pas
	        if (session == null || session.getAttribute("user") == null) {
	            // Si la session est nulle ou ne contient pas d'attribut "user", rediriger vers la page de connexion
	            response.sendRedirect("login.jsp"); // ou afficher un message d'erreur
	            return; // Sortie précoce de la méthode
	        }*/
		// TODO Auto-generated method stub
		String recipeTitle = request.getParameter("recipe_title");
        String ingredients = request.getParameter("ingredients");
        String instructions = request.getParameter("instructions");
        Part filePart = request.getPart("image"); // Récupère le fichier image
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        String uniqueFilePrefix = UUID.randomUUID().toString(); // Génère un préfixe unique
        try {
            
        	String storagePath = IMAGE_DIR + fileName;

            filePart.write(storagePath);

            // Ajoutez ici le code pour gérer la réussite de l'opération
            // Par exemple, enregistrement des données de recette dans la base de données
        } catch (IOException e) {
            // Gestion des erreurs d'entrée/sortie
            e.printStackTrace(); // Imprime la trace de l'exception dans les logs de l'application
            // Vous pouvez également enregistrer l'erreur dans un fichier de log ou afficher un message d'erreur à l'utilisateur
        } 
        
     
        try(Connection connection = SingleConnexion.getConnection();) {
        	 String sql = "INSERT INTO recettes_temp (titre,ingredients, instructions, image_path) VALUES (?, ?, ?, ?)";
             PreparedStatement stmt = connection.prepareStatement(sql);
             stmt.setString(1, recipeTitle);
             stmt.setString(2, ingredients);
             stmt.setString(3, instructions);
             stmt.setString(4,fileName );

             stmt.executeUpdate();
             stmt.close();
             connection.close();

             // Rediriger vers la page de connexion ou d'accueil
             response.sendRedirect("accueil.jsp");
         } catch (SQLException e) {
             throw new ServletException("Erreur lors de l'insertion dans la base de données", e);
         
        
        	
        }
	}

}
