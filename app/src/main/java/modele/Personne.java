package modele;


import com.example.testapplication.R;

public class Personne {

    private String str_nom;
    private int i_Sexe;
    private int i_Age;
    private String strMessage;
    private int i_image;

    //Constructeurs
    public Personne(String str_nom, int i_Sexe, int i_Age) {
        super();
        this.str_nom = str_nom;
        this.i_Sexe = i_Sexe;
        this.i_Age = i_Age;
    }

    public int getI_image() {
        return i_image;
    }

    public void setI_image(int i_image) {
        this.i_image = i_image;
    }

    public Personne() {
        super();
    }

    //Getters et Setters
    public String getStr_nom() {
        return str_nom;
    }

    public void setStr_nom(String str_nom) {
        this.str_nom = str_nom;
    }

    public int getI_Sexe() {
        return i_Sexe;
    }

    public void setI_Sexe(int i_Sexe) {
        this.i_Sexe = i_Sexe;
    }

    public int getI_Age() {
        return i_Age;
    }

    public void setI_Age(int i_Age) {
        this.i_Age = i_Age;
    }

    public String getStrMessage() {
        if (i_Sexe == 1) {
            strMessage = "Bonjour Monsieur " + this.str_nom + "\nVous avez " + this.i_Age + " ans.";
            i_image = R.drawable.homme;
        } else {
            strMessage = "Bonjour Madame " + this.str_nom + "\nVous avez " + this.i_Age + " ans.";
            i_image = R.drawable.femme;
        }
        return strMessage;
    }

}

