<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Log in </title>
    <link rel="stylesheet" href="login.css">
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
    
         <div class="wrapper">
         <div class="form-box-login">
            <h2>Welcom Back!</h2>
            <form action="ConnectionServlet" method="POST" >
            <div class="form-group">
                <label for="username">Username :</label>
                <input type="text" id="username" name="username" required>
                <%-- Afficher le message d'erreur pour le nom d'utilisateur --%>
              <% if (request.getAttribute("usernameError") != null) { %>
         <p class="error-message"><%= request.getAttribute("usernameError") %></p>
              <% } %>
            </div>
            <div class="form-group">
                <label for="password">Password :</label>
                <input type="password" id="password" name="password" required>
                <%-- Afficher le message d'erreur pour le mot de passe --%>
       <% if (request.getAttribute("passwordError") != null) { %>
    <p class="error-message"><%= request.getAttribute("passwordError") %></p>
      <% } %>
            </div>
            <div class="form-group">
                <button type="submit" class="button">Log in</button>
            </div>
            <div class="links">
                <a href="reset-password.jsp">Forgot Password?</a>
                <a href="signup.jsp">Sign up</a>
            </div>
        </form>
      </div>
      </div>
        
       </header>
      
      
      
  
</body>
</html>