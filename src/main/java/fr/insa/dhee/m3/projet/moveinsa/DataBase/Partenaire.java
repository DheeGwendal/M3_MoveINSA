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
import fr.insa.dhee.m3.projet.moveinsa.model.EntiteDejaSauvegardee;

/**
 *
 * @author gwend
 */
public class Partenaire {
    
    private int id;
    private String NomPartenaire;
    
            
    public Partenaire(int id, String NomPartenaire) {
        this.id = id;
        this.NomPartenaire = NomPartenaire;
    }

        public int saveInDB(Connection con) throws SQLException {
        if (this.getId() != -1) {
            throw new EntiteDejaSauvegardee();
        }
        try (PreparedStatement insert = con.prepareStatement(
                "insert into partenaire (id, NomPartenaire) values (?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS)) {
            insert.setString(1, this.getNomPartenaire());
            insert.executeUpdate();
            try (ResultSet rid = insert.getGeneratedKeys()) {
                rid.next();
                this.id = rid.getInt(1);
                return this.getId();
            }
        }
    }

    public static List<Partenaire> tousLesPartaires(Connection con) throws SQLException {
        try (PreparedStatement pst = con.prepareStatement(
                "select id,NomPartenaire from partenaire")) {
            ResultSet rs = pst.executeQuery();
            List<Partenaire> res = new ArrayList<>();
            while (rs.next()) {
                res.add(new Partenaire(rs.getInt(1), rs.getString(2)));
            }
            return res;
        }
    }

    /**public static int creeConsole(Connection con) throws SQLException {
        String idP = ConsoleFdB.entreeString("NomPartenaire : ");
        Partenaire nouveau = new Partenaire(idP);
        return nouveau.saveInDB(con);
    }

    public static Partenaire selectInConsole(Connection con) throws SQLException {
        return ListUtils.selectOne("choisissez un partenaire :",
                tousLesPartaires(con), (elem) -> elem.getRefPartenaire());
    }*/


    public int getId() {
        return id;
    }

    public String getNomPartenaire() {
        return NomPartenaire;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomPartenaire(String NomPartenaire) {
        this.NomPartenaire = NomPartenaire;
    }
    
    
}
