package modele;

//Pattern Singleton

//Avec le mot clé final, on ne pourra pas hériter de la classe
//

public final class Controleur {
    public Personne getMaPersonne() {
        return maPersonne;
    }

    public void setMaPersonne(Personne maPersonne) {
        this.maPersonne = maPersonne;
    }

    //
    private Personne maPersonne;
    private static Controleur monInstance = null;

    //Constructeur en private qui empêche de faire un new en dehors de la classe
    private Controleur() {
        super();
    }

    //Getter de monInstance
    public static Controleur getMonInstance() {
        //Si il n'y a pas d'instance existante on en créé une
        if (monInstance == null) {
            Controleur.monInstance = new Controleur();
        }
        return monInstance;
    }

    //Méthode qui créé une personne
    public void creerPersonne (int isexe, String nom, int iage){
        //test de validité des champs




        maPersonne = new Personne(nom,isexe,iage);



    }
}
