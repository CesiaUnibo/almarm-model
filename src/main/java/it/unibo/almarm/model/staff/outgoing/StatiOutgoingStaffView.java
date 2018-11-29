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

public enum StatiOutgoingStaffView {
    MOBILITA_NON_EFFETTUATA("non effettuata", "White"),
    MOBILITA_EFFETTUATA("effettuata", "Green"),
    MOBILITA_ANNULLATA("annullata", "Red");

    private final String valore;
    private final String color;

    StatiOutgoingStaffView(String valore, String color) {
        this.valore = valore;
        this.color = color;
    }

    public String getValore() {
        return valore;
    }
    public String getColor() {
        return color;
    }
    public String getMessageKey(){return getMessageKey(this.getValore());}

    public static StatiOutgoingStaffView get(String valoreStato) {
        for (StatiOutgoingStaffView stato: values())
            if (stato.valore.equals(valoreStato))
                return stato;
        return null;
    }

    static public String getMessageKey(String stato){
        if (StringUtils.isEmpty(stato))
            return "outgoingStaff.stato.noneffettuata";
        else
            return "outgoingStaff.stato."+stato.toLowerCase().replace(" ", "");
    }
}
