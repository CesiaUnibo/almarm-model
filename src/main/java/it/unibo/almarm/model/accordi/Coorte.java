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
package it.unibo.almarm.model.accordi;

import it.unibo.almarm.util.Common;
import it.unibo.frontieraCia.model.ConfigurazioneMinicarriera;

public class Coorte implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private SottoProgramma sottoProgramma;
	private String descrizione;
	private Character flagInviaListaPagamentiCia;
	private Long numeroMassimoPagamentiInLista;
	private String prefissoNomeListaPagamentiCia;
	private String descrizioneListaPagamentiCia;
	private ConfigurazioneMinicarriera configurazioneMinicarriera;
	private Integer numeroRate;
	private String numeroImpegno;
	private Character flagOutgoing;
	private Character flagCreaListaParametrica;
	private Character sistemaPagamento;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
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
		Coorte other = (Coorte) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void setSottoProgramma(SottoProgramma sottoProgramma) {
		this.sottoProgramma = sottoProgramma;
	}

	public SottoProgramma getSottoProgramma() {
		return sottoProgramma;
	}

	public void setFlagInviaListaPagamentiCia(Character flagInviaListaPagamentiCia) {
		this.flagInviaListaPagamentiCia = flagInviaListaPagamentiCia;
	}

	public Character getFlagInviaListaPagamentiCia() {
		return flagInviaListaPagamentiCia;
	}

	public void setNumeroMassimoPagamentiInLista(
			Long numeroMassimoPagamentiInLista) {
		this.numeroMassimoPagamentiInLista = numeroMassimoPagamentiInLista;
	}

	public Long getNumeroMassimoPagamentiInLista() {
		return numeroMassimoPagamentiInLista;
	}

	public void setPrefissoNomeListaPagamentiCia(
			String prefissoNomeListaPagamentiCia) {
		this.prefissoNomeListaPagamentiCia = prefissoNomeListaPagamentiCia;
	}

	public String getPrefissoNomeListaPagamentiCia() {
		return prefissoNomeListaPagamentiCia;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizioneListaPagamentiCia(
			String descrizioneListaPagamentiCia) {
		this.descrizioneListaPagamentiCia = descrizioneListaPagamentiCia;
	}

	public String getDescrizioneListaPagamentiCia() {
		return descrizioneListaPagamentiCia;
	}

	public void setConfigurazioneMinicarriera(ConfigurazioneMinicarriera configurazioneMinicarriera) {
		this.configurazioneMinicarriera = configurazioneMinicarriera;
	}

	public ConfigurazioneMinicarriera getConfigurazioneMinicarriera() {
		return configurazioneMinicarriera;
	}

	public void setNumeroRate(Integer numeroRate) {
		this.numeroRate = numeroRate;
	}

	public Integer getNumeroRate() {
		return numeroRate;
	}

	public void setNumeroImpegno(String numeroImpegno) {
		this.numeroImpegno = numeroImpegno;
	}

	public String getNumeroImpegno() {
		return numeroImpegno;
	}
	
	public boolean isOutgoing() {
		return (flagOutgoing == null || Common.CH_S.equals(flagOutgoing));
	}
	
	public Character getFlagOutgoing() {
		return flagOutgoing;
	}

	public void setFlagOutgoing(Character flagOutgoing) {
		this.flagOutgoing = flagOutgoing;
	}
	
	public boolean isCreaListaParametrica() {
		return Common.CH_S.equals(flagCreaListaParametrica);
	}

	public Character getFlagCreaListaParametrica() {
		return flagCreaListaParametrica;
	}

	public void setFlagCreaListaParametrica(Character flagCreaListaParametrica) {
		this.flagCreaListaParametrica = flagCreaListaParametrica;
	}
	
	public String getLabelConIndicazioneIncoming() {
		return getDescrizione() + (isOutgoing() ? "" : " - Incoming");
	}
	
	public Character getSistemaPagamento() {
		return sistemaPagamento;
	}
	
	public void setSistemaPagamento(Character sistemaPagamento) {
		this.sistemaPagamento = sistemaPagamento;
	}
	
	public boolean isPagamentoCia() {
		Character sp = getSistemaPagamento();
		if (sp == null && getSottoProgramma() != null)
			sp = getSottoProgramma().getSistemaPagamento();
		return Common.CH_I.equals(sp);
	}
	
	public boolean isPagamentoCsa() {
		Character sp = getSistemaPagamento();
		if (sp == null && getSottoProgramma() != null)
			sp = getSottoProgramma().getSistemaPagamento();
		return Common.CH_S.equals(sp);
	}
	
	public boolean isPagamentoUgov() {
		Character sp = getSistemaPagamento();
		if (sp == null && getSottoProgramma() != null)
			sp = getSottoProgramma().getSistemaPagamento();
		return Common.CH_U.equals(sp);
	}
}
