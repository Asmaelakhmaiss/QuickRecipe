<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Sign up</title>
    <link rel="stylesheet" href="signup.css">
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
        <div class="form-box-signup">
            <h2>Create your account</h2>
            <form action="InscriptionServlet" method="POST">
                <div class="form-group">
                    <label for="fullname">Fullname :</label>
                    <input type="text" id="fullname" name="fullname" required>
                </div>
                <div class="form-group">
                    <label for="email">Email :</label>
                    <input type="email" id="email" name="email" required>
                    <% if (request.getAttribute("emailError") != null) { %>
            <p class="error-message" ><%= request.getAttribute("emailError") %></p>
        <% } %>
                </div>
                <div class="form-group">
                    <label for="new-username">Username :</label>
                    <input type="text" id="new-username" name="new-username" required>
                    <% if (request.getAttribute("usernameError") != null) { %>
            <p class="error-message"><%= request.getAttribute("usernameError") %></p>
        <% } %>
                </div>
                <div class="form-group">
                    <label for="new-password">Password :</label>
                    <input type="password" id="new-password" name="new-password" required>
                </div>
              
                <div class="form-group">
                    <button type="submit" class="button">Sign up</button>
                </div>
            </form>
        </div>
        <div class="login-bar">
            <span>Already have an account?</span><a href="/QuickRecipe/login.jsp">Log in</a>
        </div>
        
    </div>
        
       </header>
     
      
      
  
</body>
</html>