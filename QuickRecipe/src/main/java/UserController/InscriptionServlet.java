package UserController;


import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import org.mindrot.jbcrypt.BCrypt;

/**
 * Servlet implementation class AnotherServlet
 */
@WebServlet(name = "InscriptionServlet", urlPatterns = {"/InscriptionServlet"})
public class InscriptionServlet extends HttpServlet {
	  

	  
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
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
		// TODO Auto-generated method stub
		String prenomNom = request.getParameter("fullname");
        String email = request.getParameter("email");
        String username = request.getParameter("new-username");
        String password = request.getParameter("new-password");
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        try(Connection connection = SingleConnexion.getConnection();) {
        	
        	String checkEmailSql = "SELECT COUNT(*) AS count FROM utilisateurs WHERE email = ?";
        	boolean emailExists = false;
        	try (PreparedStatement checkEmailStmt = connection.prepareStatement(checkEmailSql)) {
        	    checkEmailStmt.setString(1, email);
        	    try (ResultSet resultSet = checkEmailStmt.executeQuery()) {
        	        if (resultSet.next() && resultSet.getInt("count") > 0) {
        	            emailExists = true;
        	            request.setAttribute("emailError", " Cette adresse e-mail est déjà utilisée");
        	        }
        	    }
        	}

        	// Vérifier si le nom d'utilisateur existe déjà
        	String checkUsernameSql = "SELECT COUNT(*) AS count FROM utilisateurs WHERE nom_utilisateur = ?";
        	boolean usernameExists = false;
        	try (PreparedStatement checkUsernameStmt = connection.prepareStatement(checkUsernameSql)) {
        	    checkUsernameStmt.setString(1, username);
        	    try (ResultSet resultSet = checkUsernameStmt.executeQuery()) {
        	        if (resultSet.next() && resultSet.getInt("count") > 0) {
        	            usernameExists = true;
        	            request.setAttribute("usernameError", "Ce nom d'utilisateur existe déjà.");
        	        }
        	    }
        	}

        	// Si l'un des deux existe, rediriger l'utilisateur vers le formulaire d'inscription avec les messages d'erreur
        	if (emailExists || usernameExists) {
        	    request.getRequestDispatcher("/signup.jsp").forward(request, response);
        	    return;
        	}

        	
            String sql = "INSERT INTO utilisateurs (prenom_nom, email, nom_utilisateur, mot_de_passe_hash) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, prenomNom);
            stmt.setString(2, email);
            stmt.setString(3, username);
            stmt.setString(4, hashedPassword);

            stmt.executeUpdate();

            // Fermer les connexions
            stmt.close();
            connection.close();

            // Rediriger vers la page de connexion ou d'accueil
            response.sendRedirect("login.jsp");
        } catch (SQLException e) {
            throw new ServletException("Erreur lors de l'insertion dans la base de données", e);
        }
		
	}

}
