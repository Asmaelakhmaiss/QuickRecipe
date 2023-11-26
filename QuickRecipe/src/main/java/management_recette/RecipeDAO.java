package management_recette;


import java.sql.SQLException;
import java.sql.*;

public class RecipeDAO {
	
	 public boolean saveTempRecipe(Recette recipe) {
			
	        String sql = "INSERT INTO recettes_temp (titre, ingredients, instructions, image_path) VALUES (?, ?, ?, ?)";

	        try (PreparedStatement statement = SingleConnexion.getConnection().prepareStatement(sql)) {
	            statement.setString(1, recipe.getTitre());
	            statement.setString(2, recipe.getIngredients());
	            statement.setString(3, recipe.getInstructions());
	            statement.setString(4, recipe.getImagePath());

	            int rowsInserted = statement.executeUpdate();
	            return rowsInserted > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	 public String getImagePathById(long id) {
	        String query = "SELECT image_path FROM recettes_temp WHERE id = ?";
	        try (Connection connection = SingleConnexion.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            
	            preparedStatement.setLong(1, id);
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                    return resultSet.getString("image_path");
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	 public String getTitleById(long id) {
	        String query = "SELECT titre FROM recettes_temp WHERE id = ?";
	        try (Connection connection = SingleConnexion.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            
	            preparedStatement.setLong(1, id);
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                    return resultSet.getString("titre");
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	 public String getInstructionsById(long id) {
	        String query = "SELECT instructions FROM recettes_temp WHERE id = ?";
	        try (Connection connection = SingleConnexion.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            
	            preparedStatement.setLong(1, id);
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                    return resultSet.getString("instructions");
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	 public String getIngredientsById(long id) {
	        String query = "SELECT ingredients FROM recettes_temp WHERE id = ?";
	        try (Connection connection = SingleConnexion.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            
	            preparedStatement.setLong(1, id);
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                    return resultSet.getString("ingredients");
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	 public boolean deleteRecetteById(long id) {
	        String query = "DELETE FROM recettes_temp WHERE id = ?";
	        try (Connection connection = SingleConnexion.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            
	            preparedStatement.setLong(1, id);
	            int affectedRows = preparedStatement.executeUpdate();
	            return affectedRows > 0;
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }

}
	 public boolean confirmRecette( String titre ,String ingredients, String instructions, String image_path) {
			
	        String sql = "INSERT INTO quickrecipe (titre, ingredients, instructions, image_name) VALUES (?, ?, ?, ?)";

	        try (PreparedStatement statement = SingleConnexion.getConnection().prepareStatement(sql)) {
	            statement.setString(1,titre);
	            statement.setString(2,ingredients);
	            statement.setString(3,instructions);
	            statement.setString(4, image_path);

	            int rowsInserted = statement.executeUpdate();
	            return rowsInserted > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
}
