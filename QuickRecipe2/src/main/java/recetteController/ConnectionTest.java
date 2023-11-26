package recetteController;

import java.sql.Connection;
import java.util.List;

public class ConnectionTest {
	public static void main(String[] args) {
        
        String critereRecherche = "Mango Curry";

        recetteDAO recetteDAO = new recetteDAO();
        List<recette> resultats = recetteDAO.rechercherRecettes(critereRecherche);

        if (resultats.isEmpty()) {
            System.out.println("Aucune recette trouvée pour le critère : " + critereRecherche);
        } else {
            System.out.println("Résultats de la recherche pour le critère : " + critereRecherche);
            for (recette recette : resultats) {
                afficherRecette(recette);
            }
        }
    }

    private static void afficherRecette(recette recette) {
        System.out.println("ID : " + recette.getId());
        System.out.println("Titre : " + recette.getTitre());
        System.out.println("Ingrédients : " + recette.getIngredients());
        System.out.println("Instructions : " + recette.getInstructions());
        System.out.println("Image : " + recette.getImagePath());
        System.out.println("-----------------------------------");
    }
}