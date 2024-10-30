/*
Copyright 2000- Francois de Bertrand de Beuvron

This file is part of CoursBeuvron.

CoursBeuvron is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

CoursBeuvron is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with CoursBeuvron.  If not, see <http://www.gnu.org/licenses/>.
 */
package fr.insa.dhee.m3.projet.moveinsa.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gwend
 */
public class Etudiant {
    
    private int ine;
    private String nom;
    private String prenom;
   
    /**
     * création d'un nouvel Etudiant en mémoire, non existant dans la Base de
     * donnée.
     *
     * @param nom
     * @param prenom
     */
    
    public Etudiant(String nom, String prenom) {
        this(-1,nom, prenom);
    }

    /**
     * création d'un Etudiant retrouvé dans la base de donnée.
     *
     * @param ine
     * @param nom
     * @param prenom
     */
    public Etudiant(int ine, String nom, String prenom) {
        this.ine = ine;
        this.nom = nom;
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Etudiant{" + "ine =" + this.getIne() + " ; nom =" + this.getNom() + "; prenom =" + this.getPrenom() +  "}";
    }

    /**
     * Sauvegarde une nouvelle entité et retourne la clé affecté automatiquement
     * par le SGBD.
     * <p>
     * la clé est également sauvegardée dans l'attribut id
     * </p>
     *
     * @param con
     * @return la clé de la nouvelle entité dans la table de la BdD
     * @throws EntiteDejaSauvegardee si l'id de l'entité est différent de -1
     * @throws SQLException si autre problème avec la BdD
     */
/**    public int saveInDB(Connection con) throws SQLException {
        if (this.getIne() != -1) {
            throw new EntiteDejaSauvegardee();
        }
        try (PreparedStatement insert = con.prepareStatement(
                "insert into etudiant (nom, prenom) values (?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS)) {
            insert.setString(1, this.getNom());
            insert.setString(2, this.getPrenom());
            insert.executeUpdate();
            try (ResultSet rid = insert.getGeneratedKeys()) {
                rid.next();
                this.ine = rid.getInt(1);
                return this.getIne();
            }
        }
    }
*/
    public static List<Etudiant> tousLesEtudiants(Connection con) throws SQLException {
        try (PreparedStatement pst = con.prepareStatement(
                "select ine,nom, prenom")) {
            ResultSet rs = pst.executeQuery();
            List<Etudiant> res = new ArrayList<>();
            while (rs.next()) {
                res.add(new Etudiant(rs.getInt(1), rs.getString(1), rs.getString(2)));
            }
            return res;
        }
    }
/**
    public static int creeConsole(Connection con) throws SQLException {
        String nom = ConsoleFdB.entreeString("Nom : ");
        String prenom = ConsoleFdB.entreeString("Prenom : ");
        String classe = ConsoleFdB.entreeString("Classe : ");
    //    int annee = ConsoleFdB.entreeInt("Annee : ");
        int score = ConsoleFdB.entreeInt("Score : ");
        Etudiant nouveau = new Etudiant(nom, prenom, classe, score);
        return nouveau.saveInDB(con);
        
    }

    public static Etudiant selectInConsole(Connection con) throws SQLException {
        return ListUtils.selectOne("choisissez un etudiant :",
                tousLesEtudiants(con), (elem) -> elem.getNom());
    }
    */
    /**
     * @return the id
     */
    public int getIne() {
        return ine;
    }
    
    public String getNom(){
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

  
    public void setIne (int ine) {
        this.ine = ine;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
  
}
