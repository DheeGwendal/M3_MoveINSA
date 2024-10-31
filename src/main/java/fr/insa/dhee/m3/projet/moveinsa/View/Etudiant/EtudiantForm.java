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


import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.textfield.TextField;
import fr.insa.dhee.m3.projet.moveinsa.DataBase.Etudiant;
import com.vaadin.flow.component.formlayout.FormLayout;
import java.util.List;
import com.vaadin.flow.router.Route;

@Route("combo-box-item-class-name")


/**
 *
 * @author gwend
 */
public class EtudiantForm extends FormLayout {
    
    private Etudiant model;

    private TextField tfNom = new TextField("Nom");
    private TextField tfPrenom = new TextField("Prenom");
    
    public EtudiantForm(Etudiant model, boolean modifiable) {
        this.model = model;
        this.setEnabled(modifiable);
        this.updateView();
        this.add(this.tfNom);
        this.add(this.tfPrenom);
    }
    
    public void updateModel() {
        this.model.setNom(this.tfNom.getValue()); 
        this.model.setPrenom(this.tfPrenom.getValue());
    }
    
    public void updateView() {
        this.tfNom.setValue(this.model.getNom());
        this.tfPrenom.setValue(this.model.getPrenom());
    }

}
