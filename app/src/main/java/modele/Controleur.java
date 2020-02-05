package modele;

//Pattern Singleton

//Avec le mot clé final, on ne pourra pas hériter de la classe
//

import exceptions.TextValidationException;

public final class Controleur {

    private String erreurMessage = "";

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

    public Personne getMaPersonne() {
        return maPersonne;
    }

    public String getErreurMessage() {
        return erreurMessage;
    }

    public void setErreurMessage(String erreurMessage) {
        this.erreurMessage = erreurMessage;
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
    public void creerPersonne(int isexe, String nom, int iage) {
        try {
            validerNom(nom);
        } catch (Exception e) {
            this.setErreurMessage(e.getMessage());
        }
        try {
            validerAge(iage);
        } catch (Exception e) {
            String message = this.getErreurMessage();
            String saut;
            if(message==""){
                saut = "";
            }else{
                saut = "\n";
            }
            this.setErreurMessage(message + saut + e.getMessage());
        }
        maPersonne = new Personne(nom, isexe, iage);
    }

    private void validerNom(String nom) throws TextValidationException {
        if (nom.equals("")) {
            throw new TextValidationException("Veuillez saisir un nom");
        }
    }

    private void validerAge (int age) throws TextValidationException {
        if(age==0 ){
            throw new TextValidationException("Veuillez saisir un âge valide");
        }
    }


}
