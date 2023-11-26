package recetteController;

import java.sql.Connection;
import java.util.List;

public class ConnectionTest {
	public static void main(String[] args) {
        
        String critereRecherche = "Mango Curry";

        recetteDAO recetteDAO = new recetteDAO();
        List<recette> resultats = recetteDAO.rechercherRecettes(critereRecherche);

        if (resultats.isEmpty()) {
            System.out.println("Aucune recette trouv�e pour le crit�re : " + critereRecherche);
        } else {
            System.out.println("R�sultats de la recherche pour le crit�re : " + critereRecherche);
            for (recette recette : resultats) {
                afficherRecette(recette);
            }
        }
    }

    private static void afficherRecette(recette recette) {
        System.out.println("ID : " + recette.getId());
        System.out.println("Titre : " + recette.getTitre());
        System.out.println("Ingr�dients : " + recette.getIngredients());
        System.out.println("Instructions : " + recette.getInstructions());
        System.out.println("Image : " + recette.getImagePath());
        System.out.println("-----------------------------------");
    }
}