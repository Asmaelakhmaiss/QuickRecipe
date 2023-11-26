<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List" %>
<%@ page import="recetteController.recette" %>
<%@ page import="recetteController.recetteDAO" %>
  <%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>

<% 
    recetteDAO recetteDAO = new recetteDAO();
    List<recette> List_recipe = recetteDAO.getAllRecipes();
    System.out.println(List_recipe.isEmpty());
%>
 
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>QuickRecipe</title>
    <link rel="stylesheet" href="accueil1.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <link rel="stylesheet" href="userhome1.css">
</head>
<body>
<% String username = (String) session.getAttribute("username"); %>
    <header id="primary-header">
        <div class="header-content">
         <div class="logo-container">
         <img src="Images/logo.png" alt="Logo" class="logo">
         <h1 >QuickRecipe</h1>
          </div>
        <% if (session ==null || username == null) { %>
          
          
        <div class="auth-buttons">
           <a href="login.jsp" class="button">log in </a>
           <a href="signup.jsp" class="button">sign up</a>
    </div>
    <% }  %>
    </div>
   

         </header>
        
         <section class="nav">
           <div class="navigation">
            <a href="accueil.jsp" class="btn1">HOME</a>
            <a href="#info-bar" class="btn1">ABOUT</a>
            <a href=#info-bar class="btn-accueil">CONTACT</a>
            
            <%if ( session!=null && username!=null){ %>
            
             <a href="add_recipe.jsp" class="btn-accueil">ADD A RECIPE</a>
             <!-- Icône d'utilisateur et menu déroulant -->
     <div class="dropdown">
        <button class="dropbtn">
            <i class="fa fa-user"></i> <!-- Icône d'utilisateur -->
            <i class="fa fa-chevron-down"></i> <!-- Icône de flèche vers le bas -->
        </button>
        <div class="dropdown-content">
            
            <a href="#" class="username"> <%= username %></a>
            <a href="#"><i class="fa fa-user"></i>My Profile</a>
            <a href="#"><i class="fa fa-cog"></i>Settings</a>
            <form action="LogoutServlet" method="post">
            <button type="submit" class="button"><i class="fa fa-sign-out-alt"></i> Log out</button>
            </form>
        </div>
    </div>
    <%} else {%>
           <a href="login.jsp" class="btn-accueil">ADD A RECIPE</a>
           <%} %>
    
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
         <% for (recette recipe : List_recipe){ %>
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