<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Recipe Submission Form</title>
    <link rel="stylesheet" href="add_recipe.css">
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
         <div class="form-box-add_recipe">
            <h2>Add Your Recipe !</h2>
            <form action="AddRecipeServlet" method="POST" enctype="multipart/form-data">
            <div class="form-group">
                <label for="Name of Your Recipe">Name of Your Recipe :</label>
                <input type="text" id="recipe_title" name="recipe_title" required>

            </div>
            <div class="form-group">
                <label for="Ingredients">Ingredients :</label>
                <input type="text" id="ingredients" name="ingredients" required>
                
            </div>
            <div class="form-group">
                <label for="Instructions">Instructions :</label>
                <input type="text" id="instructions" name="instructions" required>
                
            </div>
            <div class="form-group">
          <label for="image">Image :</label>
           <label for="image" class="file-input-label">
        <i class="fas fa-upload"></i> 
    </label>
    <input type="file" id="image" name="image" accept="image/*" required>
   
    </div>
            <div class="form-group">
                <button type="submit" class="button">Submit</button>
            </div>
            
        </form>
      </div>
      </div>
        
       </header>
     
      
      
  
</body>
</html>