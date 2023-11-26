package management_recette;

import java.util.List;




import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class AfficherTableServlet
 */

@WebServlet(name = "afficherTable", urlPatterns = {"/afficherTable"})
public class AfficherTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherTableServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MaTableDAO dao = new MaTableDAO(); // Utilisation de votre classe DAO
        List<Recette> liste = dao.getToutesLesLignes(); // Obtention de la liste des recettes
        request.setAttribute("liste", liste); // Passage de la liste à la JSP
        request.getRequestDispatcher("admin_Recipe_Validation.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
