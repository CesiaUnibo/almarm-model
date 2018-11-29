/*
 * AlmaRM Model - Java represenation of the model AlmaRM is built on.
 * Copyright (C) 2018  ALMA MATER STUDIORUM - Università di Bologna
 *
 * This file is part of AlmaRM Model.
 *
 * AlmaRM Model is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * AlmaRM Model is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with AlmaRM Model.  If not, see <https://www.gnu.org/licenses/>.
 */
package it.unibo.almarm.model.profilazione;

import it.unibo.almarm.model.accordi.SottoProgramma;

import java.io.Serializable;
import java.util.Objects;

public class ContestoSottoprogramma implements Serializable {
    private Long id;
    private Contesto contesto;
    private Long idSottoProgramma;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Contesto getContesto() {
        return contesto;
    }

    public void setContesto(Contesto contesto) {
        this.contesto = contesto;
    }

    public Long getIdSottoProgramma() {
        return idSottoProgramma;
    }

    public void setIdSottoProgramma(Long idSottoProgramma) {
        this.idSottoProgramma = idSottoProgramma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContestoSottoprogramma that = (ContestoSottoprogramma) o;
        return Objects.equals(getContesto(), that.getContesto()) &&
                Objects.equals(getIdSottoProgramma(), that.getIdSottoProgramma());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getContesto(), getIdSottoProgramma());
    }
}
