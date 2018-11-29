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
package it.unibo.almarm.model.incoming;


public enum StampeStudenteIncoming {
	DICHIARAZIONE_DI_ARRIVO("DichiarazioneDiArrivo.pdf") {
	},
	DICHIARAZIONE_DI_PERIODO("DichiarazioneDiPeriodo.pdf") {
	},
	DICHIARAZIONE_DI_PERMANENZA("DichiarazioneDiPermanenza.pdf") {
	},
	LETTERA_DI_INVITO("LetteraDiInvitoSemplificata.pdf") {
	},
	LIBRETTO("LibrettoStudente.pdf") {
	},
	SCHEDA("SchedaStudente.pdf") {
	},
	CREDENZIALI("CredenzialiStudente.pdf") {
	},
	DICHIARAZIONE_DI_ARRIVO_IMMIGRAZIONE("DichiarazioneDiArrivoImmigrazione.pdf") {
	},
	DICHIARAZIONE_DI_ARRIVO_IMMIGRAZIONE_EMA2("DichiarazioneDiArrivoImmigrazioneEMA2.pdf") {
	},
	CONFERMA_DI_ARRIVO("ConfermaDiArrivo.pdf") {
	},
	CONFERMA_DI_PERIODO("ConfermaDiPeriodo.pdf") {
	},
	CONFERMA_DI_PERMANENZA("ConfermaDiPermanenza.pdf") {
	},
	AUTOCERTIFICAZIONE_DI_ARRIVO_IMMIGRAZIONE("AutocertificazioneDiArrivoImmigrazione.pdf") {
	},
	/* 2017-10-13: Non piu utilizzato 
	RINNOVO_PERMESSO_DI_SOGGIORNO("rinnovoPermessoSoggiorno.pdf") {  
	},*/
	DICHIARAZIONE_DI_ARRIVO_STAFF("DichiarazioneDiArrivoStaff.pdf") {
	},
	DICHIARAZIONE_DI_ARRIVO_STAFF_IMMIGRAZIONE("DichiarazioneDiArrivoStaffImmigrazione.pdf") {
	},
	AUTOCERTIFICAZIONE_DI_ARRIVO_STAFF("AutocertificazioneDiArrivoStaff.pdf") {
	},
	CONFERMA_DI_PERIODO_STAFF("ConfermaDiPeriodoStaff.pdf") {
	},
	NESSUNA("none") {
	};
	
	private String nomeTemplate;
	private String messageKey;
	
	StampeStudenteIncoming(String nomeTemplate) {
		messageKey = this.name().toLowerCase().replace("_", "");
		this.nomeTemplate=nomeTemplate;
	}

	public String getValore() {
		return this.name();
	}
	public String getNomeTemplate() {
		return nomeTemplate;
	}

	public String getMessageKey(){
		return "studenteIncoming.stampa."+messageKey;
	}
	
	static public StampeStudenteIncoming get(String stampa) {return valueOf(stampa.toUpperCase().replace(" ", "_"));}
}
