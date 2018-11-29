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
package it.unibo.almarm.model.trasparenza;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import it.unibo.almarm.util.Common;

public class TrasparenzaGruppo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String nome;
    private String descrizione;
    private Character flagAnnoSolare;
	private Long anno;
    private String titoloAtribuzione;
    private String responsabileProcedimento;
    private String individuazioneBeneficiario;
    private Character flagUsaUrlAllegati;
    private String urlAllegati;
    private String note;
    private Date dataUltimaModifica;
    private Long autoreUltimaModifica;
    private Set<TrasparenzaGruppoAllegati> allegati = new HashSet<TrasparenzaGruppoAllegati>();
	
    private Long[] idCoorti = new Long[0];
    
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Character getFlagAnnoSolare() {
		return flagAnnoSolare;
	}

	public void setFlagAnnoSolare(Character flagAnnoSolare) {
		this.flagAnnoSolare = flagAnnoSolare;
	}

	public Long getAnno() {
		return anno;
	}

	public void setAnno(Long anno) {
		this.anno = anno;
	}

	public String getTitoloAtribuzione() {
		return titoloAtribuzione;
	}

	public void setTitoloAtribuzione(String titoloAtribuzione) {
		this.titoloAtribuzione = titoloAtribuzione;
	}

	public String getResponsabileProcedimento() {
		return responsabileProcedimento;
	}

	public void setResponsabileProcedimento(String responsabileProcedimento) {
		this.responsabileProcedimento = responsabileProcedimento;
	}

	public String getIndividuazioneBeneficiario() {
		return individuazioneBeneficiario;
	}

	public void setIndividuazioneBeneficiario(String individuazioneBeneficiario) {
		this.individuazioneBeneficiario = individuazioneBeneficiario;
	}

	public Character getFlagUsaUrlAllegati() {
		return flagUsaUrlAllegati;
	}

	public void setFlagUsaUrlAllegati(Character flagUsaUrlAllegati) {
		this.flagUsaUrlAllegati = flagUsaUrlAllegati;
	}
	
	public boolean isUsaUrlAllegati() {
		return Common.CH_S.equals(getFlagUsaUrlAllegati());
	}

	public String getUrlAllegati() {
		return urlAllegati;
	}

	public void setUrlAllegati(String urlAllegati) {
		this.urlAllegati = urlAllegati;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getDataUltimaModifica() {
		return dataUltimaModifica;
	}

	public void setDataUltimaModifica(Date dataUltimaModifica) {
		this.dataUltimaModifica = dataUltimaModifica;
	}

	public Long getAutoreUltimaModifica() {
		return autoreUltimaModifica;
	}

	public void setAutoreUltimaModifica(Long autoreUltimaModifica) {
		this.autoreUltimaModifica = autoreUltimaModifica;
	}

	public Long[] getIdCoorti() {
		return idCoorti;
	}

	public void setIdCoorti(Long[] idCoorti) {
		this.idCoorti = idCoorti;
	}

	public Set<TrasparenzaGruppoAllegati> getAllegati() {
		return allegati;
	}

	public void setAllegati(Set<TrasparenzaGruppoAllegati> allegati) {
		this.allegati = allegati;
	}
	
	public String getIdsCoortiLabel() {
		String ret = "";
		for (Long tgc: getIdCoorti())
			ret += tgc.toString() + " ";
		return ret;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anno == null) ? 0 : anno.hashCode());
		result = prime * result + ((flagAnnoSolare == null) ? 0 : flagAnnoSolare.hashCode());
		result = prime * result + ((flagUsaUrlAllegati == null) ? 0 : flagUsaUrlAllegati.hashCode());
		result = prime * result + Arrays.hashCode(idCoorti);
		result = prime * result + ((individuazioneBeneficiario == null) ? 0 : individuazioneBeneficiario.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((responsabileProcedimento == null) ? 0 : responsabileProcedimento.hashCode());
		result = prime * result + ((titoloAtribuzione == null) ? 0 : titoloAtribuzione.hashCode());
		result = prime * result + ((urlAllegati == null) ? 0 : urlAllegati.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TrasparenzaGruppo))
			return false;
		TrasparenzaGruppo other = (TrasparenzaGruppo) obj;
		if (anno == null) {
			if (other.anno != null)
				return false;
		} else if (!anno.equals(other.anno))
			return false;
		if (flagAnnoSolare == null) {
			if (other.flagAnnoSolare != null)
				return false;
		} else if (!flagAnnoSolare.equals(other.flagAnnoSolare))
			return false;
		if (flagUsaUrlAllegati == null) {
			if (other.flagUsaUrlAllegati != null)
				return false;
		} else if (!flagUsaUrlAllegati.equals(other.flagUsaUrlAllegati))
			return false;
		if (!Arrays.equals(idCoorti, other.idCoorti))
			return false;
		if (individuazioneBeneficiario == null) {
			if (other.individuazioneBeneficiario != null)
				return false;
		} else if (!individuazioneBeneficiario.equals(other.individuazioneBeneficiario))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (responsabileProcedimento == null) {
			if (other.responsabileProcedimento != null)
				return false;
		} else if (!responsabileProcedimento.equals(other.responsabileProcedimento))
			return false;
		if (titoloAtribuzione == null) {
			if (other.titoloAtribuzione != null)
				return false;
		} else if (!titoloAtribuzione.equals(other.titoloAtribuzione))
			return false;
		if (urlAllegati == null) {
			if (other.urlAllegati != null)
				return false;
		} else if (!urlAllegati.equals(other.urlAllegati))
			return false;
		return true;
	}
}
