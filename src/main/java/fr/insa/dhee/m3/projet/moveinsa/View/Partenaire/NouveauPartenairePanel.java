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
package fr.insa.dhee.m3.projet.moveinsa.View.Partenaire;

/**
 *
 * @author gwend
 */
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import fr.insa.dhee.m3.projet.moveinsa.DataBase.Partenaire;
import fr.insa.dhee.m3.projet.moveinsa.View.MainLayout;
import fr.insa.dhee.m3.projet.moveinsa.Session.SessionInfo;
import java.sql.SQLException;

/**
 *
 * @author francois
 */
@PageTitle("MoveINSA")
@Route(value = "partenaires/nouveau", layout = MainLayout.class)
public class NouveauPartenairePanel extends VerticalLayout{
    
    private Partenaire nouveau;
    
    private PartenaireForm fPartenaire;
    private Button bSave;
    
    public NouveauPartenairePanel() {
        this.add(new H3("Creation d'un nouveau partenaire"));
        int test = 15; //juste pour voir si ça tourne pour l'instant ou non
        this.nouveau = new Partenaire(test,"");
        this.fPartenaire = new PartenaireForm(this.nouveau, true);
        this.bSave = new Button("Sauvegarder", (t) -> {
            try {
                this.fPartenaire.updateModel();
                this.nouveau.saveInDB(SessionInfo.getOrCreateConnectionToBdD());
            } catch (SQLException ex) {
                System.out.println("Probleme : " + ex.getLocalizedMessage());
                Notification.show("Probleme : " + ex.getLocalizedMessage());
            }
        });
        this.add(this.fPartenaire,this.bSave);
    }
    
    
}
