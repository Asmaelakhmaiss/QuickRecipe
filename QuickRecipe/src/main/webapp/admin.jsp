<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<%
    String username = (String) session.getAttribute("username");
    if (!"admin".equals(username)) {
        // Code spécifique à l'administrateur
        response.sendRedirect("login.jsp");
    }
%>

<%@ page import="java.util.List" %>
<%@ page import="recetteController.recette" %>
<%@ page import="recetteController.recetteDAO" %>
<% 
    recetteDAO recetteDAO = new recetteDAO();
    List<recette> List_recipe = recetteDAO.getAllRecipes();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin home</title>
     <link rel="stylesheet" href="accueil1.css">
    <link rel="stylesheet" href="userhome1.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
</head>
<body>
    <header>
        <div class="header-content">
         <div class="logo-container">
         <img src="Images/logo.png" alt="Logo" class="logo">
         <h1 >QuickRecipe</h1>
          </div>
        
    </div>
     
     

         </header>
         <section class="nav">
         <div class="navigation">
            <a href="admin.jsp" class="btn1">HOME</a>
            <a href="admin_Recipe_Management.jsp" class="btn1">Recipe Management</a>
            <a href="admin_Recipe_Validation.jsp" class="btn-accueil">Recipe Validation</a>
            
             <!-- Icône d'utilisateur et menu déroulant -->
     <div class="dropdown">
        <button class="dropbtn">
            <i class="fa fa-user"></i> <!-- Icône d'utilisateur -->
            <i class="fa fa-chevron-down"></i> <!-- Icône de flèche vers le bas -->
        </button>
        <div class="dropdown-content">
            <a href="#" class="username"> admin</a>
            <a href="#"><i class="fa fa-user"></i>My Profile</a>
            <a href="#"><i class="fa fa-cog"></i>Settings</a>
            <form action="LogoutServlet" method="post">
            <button type="submit" class="button"><i class="fa fa-sign-out-alt"></i> Log out</button>
            </form>
        </div>
    </div>
        </div>
         </section>
         <section class="searching">
    <div class="search-container">
    <img src="Images/image1.png" alt="Background" class="background-image">
    <form class="search-box" action="rechercheServlet" method="get">
        <input type="text" placeholder="Search" name="critereRecherche">
        <button type="submit"><i class="fas fa-search"></i></button>
    </form>
</div>
    </section>
        <section class="menu">
    <div class="recipe-gallery">
         <%for (recette recipe : List_recipe){ %>
          <div class="recipe-card">
           <img src="Images/<%= recipe.getImagePath() %>" alt=<%= recipe.getId() %>>
           <div class="recipe-title"><%= recipe.getTitre() %></div>
           <a href="details.jsp?id=<%= recipe.getId() %>" class="consult-button">View Recipe</a>
       </div>
      <% } %>  
    </div>
</section>
     


   
 <script>
function toggleDropdown() {
    var dropdownContent = document.getElementById("userDropdown");
    if (dropdownContent.style.display === "block") {
        dropdownContent.style.display = "none";
    } else {
        dropdownContent.style.display = "block";
    }
}
// Fermer le menu déroulant si l'utilisateur clique en dehors de celui-ci
window.onclick = function(event) {
    if (!event.target.matches('.dropbtn')) {
        var dropdowns = document.getElementsByClassName("dropdown-content");
        for (var i = 0; i < dropdowns.length; i++) {
            var openDropdown = dropdowns[i];
            if (openDropdown.style.display === "block") {
                openDropdown.style.display = "none";
            }
        }
    }
}
</script> 

</body>
</html>
        
