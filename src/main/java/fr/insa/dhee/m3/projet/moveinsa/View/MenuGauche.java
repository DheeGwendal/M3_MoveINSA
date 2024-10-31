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
package fr.insa.dhee.m3.projet.moveinsa.View;

import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import fr.insa.dhee.m3.projet.moveinsa.View.Etudiant.EtudiantPanel;
import fr.insa.dhee.m3.projet.moveinsa.View.Etudiant.NouvelEtudiantPanel;
import fr.insa.dhee.m3.projet.moveinsa.View.OffreMobilite.OffresPanel;
import fr.insa.dhee.m3.projet.moveinsa.View.Partenaire.NouveauPartenairePanel;
import fr.insa.dhee.m3.projet.moveinsa.View.Partenaire.PartenairesPanel;

/**
 *
 * @author gwend
 */
public class MenuGauche extends SideNav {

    public MenuGauche() {
        SideNavItem partenaires = new SideNavItem("partenaires");
//        partenaires.addItem(new SideNavItem("liste", PartenairesPanel.class));
        partenaires.addItem(new SideNavItem("nouveau", NouveauPartenairePanel.class));
        SideNavItem offres = new SideNavItem("offres");
        offres.addItem(new SideNavItem("liste", OffresPanel.class));
//        offres.addItem(new SideNavItem("nouvelle", TodoPanel.class));
        SideNavItem etudiants = new SideNavItem("etudiants");
        etudiants.addItem(new SideNavItem("liste", EtudiantPanel.class));
//        etudiants.addItem(new SideNavItem("nouveau", NouvelEtudiantPanel.class));
        SideNavItem debug = new SideNavItem("debug");
//        debug.addItem(new SideNavItem("test driver", TestDriverPanel.class));
 //       debug.addItem(new SideNavItem("raz BdD", RAZBdDPanel.class));
       this.addItem(partenaires,offres, etudiants,debug);
    }
    
}
