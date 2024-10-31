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
package fr.insa.dhee.m3.projet.moveinsa.View.OffreMobilite;

/**
 *
 * @author gwend
 */
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import fr.insa.dhee.m3.projet.moveinsa.View.MainLayout;
import fr.insa.dhee.m3.projet.moveinsa.Session.SessionInfo;
import fr.insa.dhee.m3.projet.moveinsa.DataBase.OffreMobilite;
import java.sql.SQLException;

@PageTitle("MoveINSA")
@Route(value = "offres/liste", layout = MainLayout.class)

public class OffresPanel extends VerticalLayout {
    public OffresPanel () {
        try {
            this.add(new H3("Liste de toutes les offres"));
            this.add(new OffresGrid(OffreMobilite.toutesLesOffres(
                    SessionInfo.getOrCreateConnectionToBdD()
            )));
        } catch (SQLException ex) {
            System.out.println("Probleme : " + ex.getLocalizedMessage());
            Notification.show("Probleme : " + ex.getLocalizedMessage());
        }
    }
    
}
