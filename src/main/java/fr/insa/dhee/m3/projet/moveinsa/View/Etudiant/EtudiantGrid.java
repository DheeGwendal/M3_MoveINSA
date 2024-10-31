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
package fr.insa.dhee.m3.projet.moveinsa.View.Etudiant;

/**
 *
 * @author gwend
 */
import com.vaadin.flow.component.grid.Grid;
import fr.insa.dhee.m3.projet.moveinsa.DataBase.Etudiant;
import java.util.List;

public class EtudiantGrid extends Grid<Etudiant> {
    
    public EtudiantGrid(List<Etudiant> etudiant) {
        this.setColumnReorderingAllowed(true);
        this.addColumn(Etudiant::getIne).setHeader("Ine").setSortable(true).setResizable(true);
        this.setItems(etudiant);
    }

    
}
