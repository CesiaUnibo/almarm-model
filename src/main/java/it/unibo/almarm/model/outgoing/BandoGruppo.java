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
package it.unibo.almarm.model.outgoing;

import it.unibo.almarm.model.accordi.Coorte;
import it.unibo.almarm.util.Common;

import java.util.Date;

public class BandoGruppo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String descrizione;
	private Date dataInizioAccettazione1;
	private Date dataFineAccettazione1;
	private Coorte coorte;
	private String nomeDocumentoContratto;
	private String nomeDocumentoContrattoSchedaFiscale;
	private Integer ordinamento;
	private Character flagAggiungePosti;
	private String nomeDocInfoOutgoing;					  
	private String codTestoDocInfoOutgoing;
	private Character gestioneDataLimiteFineMobilita;
	private Date dataLimiteFineMobilita;
	
	// se valorizzato prevale rispetto la configurazione sul bando
	private Character flagGestioneAiPoli;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getDataInizioAccettazione1() {
		return dataInizioAccettazione1;
	}

	public void setDataInizioAccettazione1(Date dataInizioAccettazione1) {
		this.dataInizioAccettazione1 = dataInizioAccettazione1;
	}

	public Date getDataFineAccettazione1() {
		return dataFineAccettazione1;
	}

	public void setDataFineAccettazione1(Date dataFineAccettazione1) {
		this.dataFineAccettazione1 = dataFineAccettazione1;
	}

	public Coorte getCoorte() {
		return coorte;
	}

	public void setCoorte(Coorte coorte) {
		this.coorte = coorte;
	}

	public String getNomeDocumentoContratto() {
		return nomeDocumentoContratto;
	}

	public void setNomeDocumentoContratto(String nomeDocumentoContratto) {
		this.nomeDocumentoContratto = nomeDocumentoContratto;
	}

	public String getNomeDocumentoContrattoSchedaFiscale() {
		return nomeDocumentoContrattoSchedaFiscale;
	}

	public void setNomeDocumentoContrattoSchedaFiscale(
			String nomeDocumentoContrattoSchedaFiscale) {
		this.nomeDocumentoContrattoSchedaFiscale = nomeDocumentoContrattoSchedaFiscale;
	}

	public Integer getOrdinamento() {
		return ordinamento;
	}

	public void setOrdinamento(Integer ordinamento) {
		this.ordinamento = ordinamento;
	}

	public Character getFlagAggiungePosti() {
		return flagAggiungePosti;
	}

	public void setFlagAggiungePosti(Character flagAggiungePosti) {
		this.flagAggiungePosti = flagAggiungePosti;
	}

	public boolean isAggiungePosti() {
		return !Common.CH_N.equals(flagAggiungePosti);
	}

	public String getNomeDocInfoOutgoing() {
		return nomeDocInfoOutgoing;
	}

	public void setNomeDocInfoOutgoing(String nomeDocInfoOutgoing) {
		this.nomeDocInfoOutgoing = nomeDocInfoOutgoing;
	}

	public String getCodTestoDocInfoOutgoing() {
		return codTestoDocInfoOutgoing;
	}

	public void setCodTestoDocInfoOutgoing(String codTestoDocInfoOutgoing) {
		this.codTestoDocInfoOutgoing = codTestoDocInfoOutgoing;
	}

	public Character getGestioneDataLimiteFineMobilita() {
		return gestioneDataLimiteFineMobilita;
	}

	public void setGestioneDataLimiteFineMobilita(Character gestioneDataLimiteFineMobilita) {
		this.gestioneDataLimiteFineMobilita = gestioneDataLimiteFineMobilita;
	}

	public Date getDataLimiteFineMobilita() {
		return dataLimiteFineMobilita;
	}

	public void setDataLimiteFineMobilita(Date dataLimiteFineMobilita) {
		this.dataLimiteFineMobilita = dataLimiteFineMobilita;
	}

	public boolean isDataLimiteFineMobilitaAttiva() {
		return Common.CH_S.equals(gestioneDataLimiteFineMobilita);
	}

	public Character getFlagGestioneAiPoli() {
		return flagGestioneAiPoli;
	}

	public void setFlagGestioneAiPoli(Character flagGestioneAiPoli) {
		this.flagGestioneAiPoli = flagGestioneAiPoli;
	}
	
	public boolean isGestioneAiPoli() {
		return Common.CH_S.equals(getFlagGestioneAiPoli());
	}
}
