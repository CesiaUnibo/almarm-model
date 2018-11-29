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

import java.io.Serializable;

import it.unibo.almarm.util.Common;

public class IncomingStaffChecklistView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id; 
	private Long idAnagraficaDipartimento;
	private String testo;
	private String descrizione;
	private Character flagObbligatorio;
	private String flagRichiedeDettaglio;
	private Character flagAmbitoDiApplicazione;
	private String testoAvvisoSi;
	private String testoAvvisoNo;
	private Character flagAttivo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdAnagraficaDipartimento() {
		return idAnagraficaDipartimento;
	}

	public void setIdAnagraficaDipartimento(Long idAnagraficaDipartimento) {
		this.idAnagraficaDipartimento = idAnagraficaDipartimento;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Character getFlagObbligatorio() {
		return flagObbligatorio;
	}

	public void setFlagObbligatorio(Character flagObbligatorio) {
		this.flagObbligatorio = flagObbligatorio;
	}
	
	public boolean isObbligatorio() {
		return Common.CH_S.equals(getFlagObbligatorio());
	}

	public String getFlagRichiedeDettaglio() {
		return flagRichiedeDettaglio;
	}

	public void setFlagRichiedeDettaglio(String flagRichiedeDettaglio) {
		this.flagRichiedeDettaglio = flagRichiedeDettaglio;
	}
	
	public boolean isDettaglioNonRichiesto() {
		return "N".equals(getFlagRichiedeDettaglio());
	}
	
	public boolean isDettaglioObbligatorio() {
		return "O".equals(getFlagRichiedeDettaglio());
	}
	
	public boolean isDettaglioOpzionale() {
		return "Z".equals(getFlagRichiedeDettaglio());
	}
	
	public boolean isDettaglioObbligatorioConSi() {
		return "SO".equals(getFlagRichiedeDettaglio());
	}
	
	public boolean isDettaglioOpzionaleConSi() {
		return "SZ".equals(getFlagRichiedeDettaglio());
	}
	
	public boolean isDettaglioObbligatorioConNo() {
		return "NO".equals(getFlagRichiedeDettaglio());
	}
	
	public boolean isDettaglioOpzionaleConNo() {
		return "NZ".equals(getFlagRichiedeDettaglio());
	}

	public Character getFlagAmbitoDiApplicazione() {
		return flagAmbitoDiApplicazione;
	}

	public void setFlagAmbitoDiApplicazione(Character flagAmbitoDiApplicazione) {
		this.flagAmbitoDiApplicazione = flagAmbitoDiApplicazione;
	}
	
	public String getTestoAvvisoSi() {
		return testoAvvisoSi;
	}

	public void setTestoAvvisoSi(String testoAvvisoSi) {
		this.testoAvvisoSi = testoAvvisoSi;
	}

	public String getTestoAvvisoNo() {
		return testoAvvisoNo;
	}

	public void setTestoAvvisoNo(String testoAvvisoNo) {
		this.testoAvvisoNo = testoAvvisoNo;
	}

	public Character getFlagAttivo() {
		return flagAttivo;
	}

	public void setFlagAttivo(Character flagAttivo) {
		this.flagAttivo = flagAttivo;
	}
	
	public boolean isAttivo() {
		return Common.CH_S.equals(getFlagAttivo());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idAnagraficaDipartimento == null) ? 0 : idAnagraficaDipartimento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof IncomingStaffChecklistView))
			return false;
		IncomingStaffChecklistView other = (IncomingStaffChecklistView) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idAnagraficaDipartimento == null) {
			if (other.idAnagraficaDipartimento != null)
				return false;
		} else if (!idAnagraficaDipartimento.equals(other.idAnagraficaDipartimento))
			return false;
		return true;
	}
	
	
}
