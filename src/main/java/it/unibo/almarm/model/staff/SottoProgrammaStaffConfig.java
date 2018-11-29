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
package it.unibo.almarm.model.staff;

import it.unibo.almarm.model.accordi.SottoProgramma;
import it.unibo.almarm.util.Common;

import java.io.Serializable;
import java.util.Arrays;

public class SottoProgrammaStaffConfig implements Serializable {

    private static final long serialVersionUID = 6781145605511450994L;

    private Long id;
    private Character flagBloccoInserimentoIncoming;
    private Character flagAvvisoReferenteInternoInserimentoIncoming;
    private Character flagTeachingProgrammeInserimentoIncoming;
    private SottoProgramma sottoProgramma;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Character getFlagBloccoInserimentoIncoming() {
        return flagBloccoInserimentoIncoming;
    }

    public boolean isBloccoInserimentoIncoming() {
        return Common.CH_S.equals(getFlagBloccoInserimentoIncoming());
    }

    public void setFlagBloccoInserimentoIncoming(Character flagBloccoInserimentoIncoming) {
        this.flagBloccoInserimentoIncoming = flagBloccoInserimentoIncoming;
    }

    public Character getFlagAvvisoReferenteInternoInserimentoIncoming() {
        return flagAvvisoReferenteInternoInserimentoIncoming;
    }

    public boolean isAvvisoReferenteInternoInserimentoIncoming() {
        return Common.CH_S.equals(getFlagAvvisoReferenteInternoInserimentoIncoming());
    }

    public void setFlagAvvisoReferenteInternoInserimentoIncoming(Character flagAvvisoReferenteInternoInserimentoIncoming) {
        this.flagAvvisoReferenteInternoInserimentoIncoming = flagAvvisoReferenteInternoInserimentoIncoming;
    }

    public Character getFlagTeachingProgrammeInserimentoIncoming() {
        return flagTeachingProgrammeInserimentoIncoming;
    }

    public void setFlagTeachingProgrammeInserimentoIncoming(Character flagTeachingProgrammeInserimentoIncoming) {
        this.flagTeachingProgrammeInserimentoIncoming = flagTeachingProgrammeInserimentoIncoming;
    }

    public boolean isTeachingProgrammeInserimentoIncomingPrevisto() {
        boolean previsto = false;
        if (getFlagTeachingProgrammeInserimentoIncoming()!=null) {
            if (Arrays.asList(Common.CH_S, Common.CH_O).contains(getFlagTeachingProgrammeInserimentoIncoming()))
                previsto = true;
        }
        return previsto;
    }

    public boolean isTeachingProgrammeInserimentoIncomingObbligatorio() {
        boolean obbligatorio = false;
        if (getFlagTeachingProgrammeInserimentoIncoming()!=null) {
            if (Common.CH_O.equals(getFlagTeachingProgrammeInserimentoIncoming()))
                obbligatorio = true;
        }
        return obbligatorio;
    }

    public SottoProgramma getSottoProgramma() {
        return sottoProgramma;
    }

    public void setSottoProgramma(SottoProgramma sottoProgramma) {
        this.sottoProgramma = sottoProgramma;
    }
}
