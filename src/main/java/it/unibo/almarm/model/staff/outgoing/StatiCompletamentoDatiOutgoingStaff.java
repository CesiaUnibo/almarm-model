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
package it.unibo.almarm.model.staff.outgoing;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

public enum StatiCompletamentoDatiOutgoingStaff {
    NON_DEFINITO("non definito", "Grey", false, false), // Stato corrispondente a una fase della mobilita' nel quale non e' possibile prevedere lo stato del completamento dei dati (tipicamente prima della conclusione della mobilita')
    COMPLETAMENTO_POSSIBILE("completamento possibile", "White", true, true),
    COMPLETAMENTO_RICHIESTO("completamento richiesto", "Yellow", true, true),
    COMPLETI("completi", "Green", true, false);

    private final String valore;
    private final String color;
    private final boolean visibile;
    private final boolean completamentoDatiAmmesso;

    StatiCompletamentoDatiOutgoingStaff(String valore, String color, boolean visibile, boolean completamentoDatiAmmesso) {
        this.valore = valore;
        this.color = color;
        this.visibile = visibile;
        this.completamentoDatiAmmesso = completamentoDatiAmmesso;
    }

    public String getValore() {
        return valore;
    }

    public String getColor() {
        return color;
    }

    public String getMessageKey(){return getMessageKey(this.getValore());}

    public static StatiCompletamentoDatiOutgoingStaff[] valuesVisibili() {
        StatiCompletamentoDatiOutgoingStaff[] values = values();
        List<StatiCompletamentoDatiOutgoingStaff> valuesVisibili = new ArrayList<>();
        for (StatiCompletamentoDatiOutgoingStaff stato : values)
            if (stato.isVisibile())
                valuesVisibili.add(stato);
        values = new StatiCompletamentoDatiOutgoingStaff[valuesVisibili.size()];
        values = valuesVisibili.toArray(values);
        return values;
    }

    public boolean isVisibile() {
        return visibile;
    }

    public static StatiCompletamentoDatiOutgoingStaff get(String valoreStato) {
        for (StatiCompletamentoDatiOutgoingStaff stato: values())
            if (stato.valore.equals(valoreStato))
                return stato;
        return null;
    }

    static public String getMessageKey(String stato){
        if (StringUtils.isEmpty(stato))
            return "outgoingStaff.statoCompletamentoDati.nondefinito";
        else
            return "outgoingStaff.statoCompletamentoDati."+stato.toLowerCase().replace(" ", "");
    }

    public boolean isCompletamentoDatiAmmesso() {
        return completamentoDatiAmmesso;
    }
}
