package recetteController;



public class recette {
	private int likes;
    private int dislikes;
    private long id ; 
    private String titre;
    private String ingredients;
    private String instructions;
    private String imagePath;

    // Getters et setters
    

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public int getNbrLike() {
        return likes;
    }

    public void setNbrLike(int likes) {
        this.likes = likes;
    }

    // Getter et setter pour nbrDislike
    public int getNbrDislike() {
        return dislikes;
    }

    public void setNbrDislike(int dislikes) {
        this.dislikes = dislikes;
    }
    
}