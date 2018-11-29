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
package it.unibo.almarm.model.email;

import it.unibo.almarm.model.accordi.Coorte;
import it.unibo.almarm.model.incoming.TipoMobilita;
import it.unibo.almarm.model.outgoing.Bando;
import it.unibo.almarm.model.profilazione.Contesto;


public class EmailTipoTemplate implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private TipoEmail tipoEmail;
	private TemplateEmail templateEmail;
	private Contesto contesto;
	private String descrizione;
	private Character attivo;
	private TipoMobilita tipoMobilita;
	private Bando bando;
	private Coorte coorte;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoEmail getTipoEmail() {
		return tipoEmail;
	}

	public void setTipoEmail(TipoEmail tipoEmail) {
		this.tipoEmail = tipoEmail;
	}

	public TemplateEmail getTemplateEmail() {
		return templateEmail;
	}

	public void setTemplateEmail(TemplateEmail templateEmail) {
		this.templateEmail = templateEmail;
	}

	public Contesto getContesto() {
		return contesto;
	}

	public void setContesto(Contesto contesto) {
		this.contesto = contesto;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Character getAttivo() {
		return attivo;
	}

	public void setAttivo(Character attivo) {
		this.attivo = attivo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((contesto == null) ? 0 : contesto.hashCode());
		result = prime * result
				+ ((tipoEmail == null) ? 0 : tipoEmail.hashCode());
		result = prime * result
				+ ((bando == null) ? 0 : bando.hashCode());
		result = prime * result
				+ ((coorte == null) ? 0 : coorte.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof EmailTipoTemplate))
			return false;
		EmailTipoTemplate other = (EmailTipoTemplate) obj;
		if (contesto == null) {
			if (other.contesto != null)
				return false;
		} else if (!contesto.equals(other.contesto))
			return false;
		if (tipoEmail == null) {
			if (other.tipoEmail != null)
				return false;
		} else if (!tipoEmail.equals(other.tipoEmail))
			return false;
		if (bando == null) {
			if (other.getBando()!=null)
				return false;
		} else if (!bando.equals(other.getBando()))
			return false;
		if (coorte == null) {
			if (other.getCoorte()!=null)
				return false;
		} else if (!coorte.equals(other.getCoorte()))
			return false;
		return true;
	}

	public boolean isInvioAttivo() {
		return (new Character('S')).equals(attivo);
	}

	public TipoMobilita getTipoMobilita() {
		return tipoMobilita;
	}

	public void setTipoMobilita(TipoMobilita tipoMobilita) {
		this.tipoMobilita = tipoMobilita;
	}

	public void setBando(Bando bando) {
		this.bando = bando;
	}

	public Bando getBando() {
		return bando;
	}

	public Coorte getCoorte() {
		return coorte;
	}

	public void setCoorte(Coorte coorte) {
		this.coorte = coorte;
	}

}
