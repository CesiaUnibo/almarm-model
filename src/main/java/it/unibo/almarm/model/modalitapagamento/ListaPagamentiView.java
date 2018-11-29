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
package it.unibo.almarm.model.modalitapagamento;

import it.unibo.almarm.model.accordi.Coorte;
import it.unibo.almarm.util.Common;

import java.util.Date;

public class ListaPagamentiView implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nomeListaCia;
	private String descrizione;
	private Date dataCreazione;
	private Date dataEmissione;
	private String stato;
	private Long numeroRate;
	private Long idCoorte;
	private Double ammontareTotale;
	private Character flagInvioEmailAvviso;
	private Character flagRestituzione;
	private String idListaParametricaUGOV;
	private String erroreCreazioneListaParametricaUGOV;
	
	private Coorte coorte;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNomeListaCia(String nomeListaCia) {
		this.nomeListaCia = nomeListaCia;
	}

	public String getNomeListaCia() {
		return nomeListaCia;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDataEmissione(Date dataEmissione) {
		this.dataEmissione = dataEmissione;
	}

	public Date getDataEmissione() {
		return dataEmissione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListaPagamentiView other = (ListaPagamentiView) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getStato() {
		return stato;
	}
	
	public String getColor() {
		return StatoListaPagamenti.get(stato).getColor();
	}

	public String getColorDesc() {
		return StatoListaPagamenti.get(stato).getValore();
	}
	
	public StatoListaPagamenti getStatoListaPagamenti() {
		return StatoListaPagamenti.get(getStato());
	}

	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public Date getDataCreazione() {
		return dataCreazione;
	}

	public void setNumeroRate(Long numeroRate) {
		this.numeroRate = numeroRate;
	}

	public Long getNumeroRate() {
		return numeroRate;
	}

	public void setIdCoorte(Long idCoorte) {
		this.idCoorte = idCoorte;
	}

	public Long getIdCoorte() {
		return idCoorte;
	}

	public void setCoorte(Coorte coorte) {
		this.coorte = coorte;
	}

	public Coorte getCoorte() {
		return coorte;
	}

	public void setAmmontareTotale(Double ammontareTotale) {
		this.ammontareTotale = ammontareTotale;
	}

	public Double getAmmontareTotale() {
		return ammontareTotale;
	}

	public Character getFlagInvioEmailAvviso() {
		return flagInvioEmailAvviso;
	}

	public void setFlagInvioEmailAvviso(Character flagInvioEmailAvviso) {
		this.flagInvioEmailAvviso = flagInvioEmailAvviso;
	}
	
	public boolean isInvioEmailAvvisoAbilitato() {
		return Common.CH_S.equals(getFlagInvioEmailAvviso());
	}

	public void setFlagRestituzione(Character flagRestituzione) {
		this.flagRestituzione = flagRestituzione;
	}

	public Character getFlagRestituzione() {
		return flagRestituzione;
	}

	public String getIdListaParametricaUGOV() {
		return idListaParametricaUGOV;
	}

	public void setIdListaParametricaUGOV(String idListaParametricaUGOV) {
		this.idListaParametricaUGOV = idListaParametricaUGOV;
	}

	public String getErroreCreazioneListaParametricaUGOV() {
		return erroreCreazioneListaParametricaUGOV;
	}

	public void setErroreCreazioneListaParametricaUGOV(String erroreCreazioneListaParametricaUGOV) {
		this.erroreCreazioneListaParametricaUGOV = erroreCreazioneListaParametricaUGOV;
	}
}
