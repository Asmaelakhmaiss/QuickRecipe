package UserController;

import jakarta.servlet.ServletException;




import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;


/**
 * Servlet implementation class ConnectionServlet
 */
@WebServlet(name = "ConnectionServlet", urlPatterns = {"/ConnectionServlet"})
public class ConnectionServlet extends HttpServlet {
	 
	  
	private static final long serialVersionUID = 1L;
     
  /**
   * @see HttpServlet#HttpServlet()
   */
  public ConnectionServlet() {
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
		String username = request.getParameter("username");
        String password = request.getParameter("password");
      try(Connection connection = SingleConnexion.getConnection();) {
      	
    	  String checkUserSql = "SELECT mot_de_passe_hash FROM utilisateurs WHERE nom_utilisateur = ?";
          try (PreparedStatement checkStmt = connection.prepareStatement(checkUserSql)) {
              checkStmt.setString(1, username);
              try (ResultSet resultSet = checkStmt.executeQuery()) {
                  if (resultSet.next()) {
                      // Le nom d'utilisateur existe, vérifier le mot de passe
                      String storedHash = resultSet.getString("mot_de_passe_hash");
                      if (BCrypt.checkpw(password, storedHash)) {
                          // Le mot de passe est correct, rediriger vers la page .jsp
                    	  
                    	 
                          request.getSession().setAttribute("username", username); // Stocker le nom d'utilisateur dans la session
                          if ("admin".equals(username)) {
                              // Si l'utilisateur est l'administrateur, le rediriger vers admin.jsp
                              response.sendRedirect("admin.jsp");
                              
                          } else {
                              // Si l'utilisateur n'est pas l'administrateur, le rediriger vers userhome.jsp
                              response.sendRedirect("accueil.jsp");
                          }
                      } else {
                          // Le mot de passe est incorrect
                          request.setAttribute("passwordError", "Mot de passe incorrect.");
                          request.getRequestDispatcher("/login.jsp").forward(request, response);
                      }
                  } else {
                      // Le nom d'utilisateur n'existe pas
                      request.setAttribute("usernameError", "Ce nom d'utilisateur n'existe pas.");
                      request.getRequestDispatcher("/login.jsp").forward(request, response);
                  }
              }
          }
      } 
       catch (SQLException e) {
          throw new ServletException("Erreur lors de l'insertion dans la base de données", e);
      }
		
	}

}