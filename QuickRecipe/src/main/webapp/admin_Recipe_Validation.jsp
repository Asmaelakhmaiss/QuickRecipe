<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      
 
<%@ page import="management_recette.Recette" %>
<%@ page import="java.util.List" %>
<%@ page import="management_recette.MaTableDAO" %>
<%@ page import="management_recette.RecipeDAO" %>
<%
    String username = (String) session.getAttribute("username");
    if (!"admin".equals(username)) {
        // Code spécifique à l'administrateur
        response.sendRedirect("login.jsp");
    }
%>


<%  
      MaTableDAO dao = new MaTableDAO();
      List<Recette> listeRecettes = dao.getToutesLesLignes();
  %>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0); // Proxies.
%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    
    <meta charset="UTF-8">
    <title>Admin Recipe Validation</title>
    <link rel="stylesheet" href="userhome1.css">
    <link rel="stylesheet" href="accueil1.css">
    <link rel="stylesheet" href="admin_Recipe_Validation.css">
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
   <%
        String deletionSuccess = request.getParameter("deletionSuccess");
        String deletedId = request.getParameter("deletedId");
        long deletedIdLong = -1;
        if (deletedId != null) {
            try {
                deletedIdLong = Long.parseLong(deletedId);
            } catch (NumberFormatException e) {
                // Gérer l'exception si nécessaire
            }
        }
    %>
     <%
        String ConfirmationSuccess = request.getParameter("confirmationSuccess");
        String ConfirmedId = request.getParameter("ConfirmedId");
        long ConfirmetedIdLong = -1;
        if (ConfirmedId != null) {
            try {
                deletedIdLong = Long.parseLong(deletedId);
            } catch (NumberFormatException e) {
                // Gérer l'exception si nécessaire
            }
        }
    %>
    <section class ="matable">
     <table id="table">
    <thead>
        <tr>
            <th>id</th>
            <th>Title</th>
            <th>Ingredients</th>
            <th>Instructions</th>
            <th>Image_name</th>
            <th>Deletion</th>
            <th>Confirmation</th>
        </tr>
    </thead>
    <tbody>
     <%
                if (listeRecettes != null && !listeRecettes.isEmpty()) {
                    for (Recette recette : listeRecettes) {
            %>
            <tr>
                <td><%= recette.getId() %></td>
                <td><%= recette.getTitre() %></td>
                <td><%= recette.getIngredients() %></td>
                <td><%= recette.getInstructions() %></td>
                <td><a href="#" onclick="showImage('<%= recette.getImagePath() %>')"><%= recette.getImagePath() %></a>
                </td>
               <td>
                    
                        <form action="DeleteServlet" method="post">
                            <input type="hidden" name="id" value="<%= recette.getId() %>" />
                            <button type="submit" class="btn01" >Delete</button>
                        </form>
                    
                </td>
            <td>
                
                <form action="ConfirmServlet" method="post">
                    <input type="hidden" name="id" value="<%= recette.getId() %>"  >
                    <button type="submit" class="btn01" >Confirm</button>
                </form>
            </td>
                
            </tr>
            <%
                    }
                }
                else {
                    %>
                    <tr>
                        <td colspan="5">Aucune recette trouvée.</td>
                    </tr>
                    <%
                        }
                    %>
                
        
    </tbody>
</table>
<button id="seeMore">See More</button>
<button id="seeLess" style="display: none;">See Less</button>
</section>
<div id="imageModal">
    <div id="imageModalContent">
        <span class="close" onclick="document.getElementById('imageModal').style.display='none'">&times;</span>
        <img id="dynamicImage" src="" style="width:100%" />
    </div>
</div>

<script>
    function showImage(imageName) {
        var imageUrl = "imageDisplay?name=" + imageName;
        $("#dynamicImage").attr("src", imageUrl);
        $("#imageModal").show();
    }
</script>


   
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
<script>
    document.addEventListener('DOMContentLoaded', function() {
        var rows = document.querySelectorAll('#table tr');
        var visibleRows = 20; // Le nombre initial de lignes à afficher
        var increment = 20; // Combien de lignes supplémentaires à afficher à chaque fois

        // Cachez initialement les lignes qui ne doivent pas être affichées
        for (var i = visibleRows; i < rows.length; i++) {
            rows[i].style.display = 'none';
        }

        // Gestionnaire d'événements pour "See More"
        document.getElementById('seeMore').addEventListener('click', function() {
            var nextLimit = Math.min(rows.length, visibleRows + increment);
            for (var i = visibleRows; i < nextLimit; i++) {
                rows[i].style.display = '';
            }
            visibleRows = nextLimit;

            // Masquez le bouton "See More" si toutes les lignes sont visibles
            if (visibleRows >= rows.length) {
                this.style.display = 'none';
            }
            document.getElementById('seeLess').style.display = ''; // Afficher le bouton "See Less"
        });

        // Gestionnaire d'événements pour "See Less"
        document.getElementById('seeLess').addEventListener('click', function() {
            var nextLimit = Math.max(20, visibleRows - increment);
            for (var i = nextLimit; i < visibleRows; i++) {
                rows[i].style.display = 'none';
            }
            visibleRows = nextLimit;

            // Afficher le bouton "See More"
            document.getElementById('seeMore').style.display = '';
            // Masquez le bouton "See Less" si le nombre visible de lignes est de nouveau 10
            if (visibleRows <= 400) {
                this.style.display = 'none';
            }
        });
    });
</script>






</body>
</html>