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


import it.unibo.almarm.model.accordi.AccordoVicepresidenza;
import it.unibo.almarm.model.attori.Facolta;
import it.unibo.almarm.model.attori.Persona;
import it.unibo.almarm.model.attori.Scuola;
import it.unibo.almarm.util.Common;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Disponibilita implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Bando bando;
	private Integer postiDisponibili;
	private Integer periodiDisponibili;
	private Date dataInizio;
	private Date dataFine;
	private Set<OffertaInDisponibilita> offerteInDisponibilita = new HashSet<OffertaInDisponibilita>();
	private Set<RequisitoOfferta> requisitiOfferta = new HashSet<RequisitoOfferta>();
	private String descrizione;
	private Facolta facolta;
	private String stato;
	private Date dataApertura;
	private Persona autoreApertura;
	private Date dataCompletata;
	private Persona autoreCompletata;
	private Date dataChiusura;
	private Persona autoreChiusura;
	private Long idDocTitulus;
	private Character modalitaValutazione;
	private String noteValutazione;
	private Integer postiDisponibiliIniziali;
	private Character flagRevocata;
	private String noteRevoca;
	private Date dataRevoca;
	private Persona autoreRevoca;
	private Scuola scuola;
	private Long idAreaGeografica;
	private String nomeDocumentoAggregato;
	private String nomeDocumentoToDownload;
	private Long numeroDocumentiAggregatiDaStampare;
	private Set<DisponibilitaGruppo> disponibilitaGruppi = new HashSet<DisponibilitaGruppo>();
	private Set<DisponibilitaVicepresidenza> disponibilitaVicepresidenze = new HashSet<DisponibilitaVicepresidenza>();
	private Set<CompletamentoDisponibilita> completamenti = new HashSet<CompletamentoDisponibilita>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Bando getBando() {
		return bando;
	}

	public void setBando(Bando bando) {
		this.bando = bando;
	}

	public Integer getPostiDisponibili() {
		return postiDisponibili;
	}

	public void setPostiDisponibili(Integer postiDisponibili) {
		this.postiDisponibili = postiDisponibili;
	}

	public Integer getPeriodiDisponibili() {
		return periodiDisponibili;
	}

	public void setPeriodiDisponibili(Integer periodiDisponibili) {
		this.periodiDisponibili = periodiDisponibili;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public Set<OffertaInDisponibilita> getOfferteInDisponibilita() {
		return offerteInDisponibilita;
	}

	public void setOfferteInDisponibilita(
			Set<OffertaInDisponibilita> offerteInDisponibilita) {
		this.offerteInDisponibilita = offerteInDisponibilita;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bando == null) ? 0 : bando.hashCode());
		result = prime
				* result
				+ ((offerteInDisponibilita == null) ? 0
						: offerteInDisponibilita.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Disponibilita))
			return false;
		Disponibilita other = (Disponibilita) obj;
		if (bando == null) {
			if (other.bando != null)
				return false;
		} else if (!bando.equals(other.bando))
			return false;
		if (offerteInDisponibilita == null) {
			if (other.offerteInDisponibilita != null)
				return false;
		} else if (!offerteInDisponibilita.equals(other.offerteInDisponibilita))
			return false;
		return true;
	}

	public Set<RequisitoOfferta> getRequisitiOfferta() {
		return requisitiOfferta;
	}

	public void setRequisitiOfferta(Set<RequisitoOfferta> requisitiOfferta) {
		this.requisitiOfferta = requisitiOfferta;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public Facolta getFacolta() {
		return facolta;
	}

	public void setFacolta(Facolta facolta) {
		this.facolta = facolta;
	}

	public Date getDataApertura() {
		return dataApertura;
	}

	public void setDataApertura(Date dataApertura) {
		this.dataApertura = dataApertura;
	}

	public Persona getAutoreApertura() {
		return autoreApertura;
	}

	public void setAutoreApertura(Persona autoreApertura) {
		this.autoreApertura = autoreApertura;
	}

	public Date getDataCompletata() {
		return dataCompletata;
	}

	public void setDataCompletata(Date dataCompletata) {
		this.dataCompletata = dataCompletata;
	}

	public Persona getAutoreCompletata() {
		return autoreCompletata;
	}

	public void setAutoreCompletata(Persona autoreCompletata) {
		this.autoreCompletata = autoreCompletata;
	}

	public Date getDataChiusura() {
		return dataChiusura;
	}

	public void setDataChiusura(Date dataChiusura) {
		this.dataChiusura = dataChiusura;
	}

	public Persona getAutoreChiusura() {
		return autoreChiusura;
	}

	public void setAutoreChiusura(Persona autoreChiusura) {
		this.autoreChiusura = autoreChiusura;
	}
	
	public Long getIdDocTitulus() {
		return idDocTitulus;
	}

	public void setIdDocTitulus(Long idDocTitulus) {
		this.idDocTitulus = idDocTitulus;
	}

	public String getColor() {
		return StatoDisponibilita.get(stato).getColor();
	}

	public Character getModalitaValutazione() {
		return modalitaValutazione;
	}

	public void setModalitaValutazione(Character modalitaValutazione) {
		this.modalitaValutazione = modalitaValutazione;
	}

	public String getNoteValutazione() {
		return noteValutazione;
	}

	public void setNoteValutazione(String noteValutazione) {
		this.noteValutazione = noteValutazione;
	}
	
	public boolean isCompletata() {
		return StatoDisponibilita.COMPLETATA.getValore().equals(stato);
	}
	
	public boolean isChiusa() {
		return StatoDisponibilita.CHIUSA.getValore().equals(stato);
	}

	public Integer getPostiDisponibiliIniziali() {
		return postiDisponibiliIniziali;
	}

	public void setPostiDisponibiliIniziali(Integer postiDisponibiliIniziali) {
		this.postiDisponibiliIniziali = postiDisponibiliIniziali;
	}

	public Set<DisponibilitaGruppo> getDisponibilitaGruppi() {
		return disponibilitaGruppi;
	}

	public void setDisponibilitaGruppi(Set<DisponibilitaGruppo> disponibilitaGruppi) {
		this.disponibilitaGruppi = disponibilitaGruppi;
	}

	public Character getFlagRevocata() {
		if (flagRevocata == null)
			return 'N';
		return flagRevocata;
	}

	public void setFlagRevocata(Character flagRevocata) {
		this.flagRevocata = flagRevocata;
	}
	
	public boolean isRevocata() {
		return Common.CH_S.equals(getFlagRevocata());
	}

	public String getNoteRevoca() {
		return noteRevoca;
	}

	public void setNoteRevoca(String noteRevoca) {
		this.noteRevoca = noteRevoca;
	}

	public Date getDataRevoca() {
		return dataRevoca;
	}

	public void setDataRevoca(Date dataRevoca) {
		this.dataRevoca = dataRevoca;
	}

	public Persona getAutoreRevoca() {
		return autoreRevoca;
	}

	public void setAutoreRevoca(Persona autoreRevoca) {
		this.autoreRevoca = autoreRevoca;
	}
	
	public String getVicepresidenzeDescHtml() {
		String ret = "";
		if (getBando().getSottoProgramma().isErasmusPlacement())
			return ret;
		for (OffertaInDisponibilita oid: getOfferteInDisponibilita())
			for (AccordoVicepresidenza av: oid.getOfferta().getFlussoScambioEsecuzione().getAccordoOperativo().getAccordoVicepresidenze())
				ret += av.getVicepresidenza().getDescrizione() + "<br/>";
		if (ret.length() > 0)
			ret = ret.substring(0, ret.length() - 5);
		return ret;
	}

	public Scuola getScuola() {
		return scuola;
	}

	public void setScuola(Scuola scuola) {
		this.scuola = scuola;
	}

	public Set<DisponibilitaVicepresidenza> getDisponibilitaVicepresidenze() {
		return disponibilitaVicepresidenze;
	}

	public void setDisponibilitaVicepresidenze(
			Set<DisponibilitaVicepresidenza> disponibilitaVicepresidenze) {
		this.disponibilitaVicepresidenze = disponibilitaVicepresidenze;
	}

	public Long getIdAreaGeografica() {
		return idAreaGeografica;
	}

	public void setIdAreaGeografica(Long idAreaGeografica) {
		this.idAreaGeografica = idAreaGeografica;
	}

	public String getNomeDocumentoAggregato() {
		return nomeDocumentoAggregato;
	}

	public void setNomeDocumentoAggregato(String nomeDocumentoAggregato) {
		this.nomeDocumentoAggregato = nomeDocumentoAggregato;
	}

	public String getNomeDocumentoToDownload() {
		return nomeDocumentoToDownload;
	}

	public void setNomeDocumentoToDownload(String nomeDocumentoToDownload) {
		this.nomeDocumentoToDownload = nomeDocumentoToDownload;
	}

	public Long getNumeroDocumentiAggregatiDaStampare() {
		return numeroDocumentiAggregatiDaStampare;
	}

	public void setNumeroDocumentiAggregatiDaStampare(
			Long numeroDocumentiAggregatiDaStampare) {
		this.numeroDocumentiAggregatiDaStampare = numeroDocumentiAggregatiDaStampare;
	}

	public boolean isZeroPostiAggiuntiDaiGruppi() {
		if (getDisponibilitaGruppi() != null && (!getDisponibilitaGruppi().isEmpty()))
			for (DisponibilitaGruppo dg : getDisponibilitaGruppi())
				if (dg.getBandoGruppo().isAggiungePosti() && dg.getPosti() != null && dg.getPosti().intValue()>0)
					return false;
		return true;
	}
	
	public BandoGruppo getGruppoAssegnatoCandidatura(){
		if (getDisponibilitaGruppi() != null && (!getDisponibilitaGruppi().isEmpty()))
			for (DisponibilitaGruppo dg: getDisponibilitaGruppi()){
				if (dg.isGruppoAssegnatoCandidatura())
					return dg.getBandoGruppo();
			}
		return null;
	}
	
	public Set<CompletamentoDisponibilita> getCompletamenti() {
		return completamenti;
	}
	
	public void setCompletamenti(Set<CompletamentoDisponibilita> completamenti) {
		this.completamenti = completamenti;
	}
	
	/**
	 * Metodo di convenienza. Si occupa di gestire i riferimenti tra questa disponibilita' 
	 * e il completamento passato come argomento.
	 * @param completamento
	 */
	public void addCompletamento(CompletamentoDisponibilita completamento) {
		completamento.setDisponibilita(this);
		completamenti.add(completamento);
	}
	
	/**
	 * ritorna l'ultimo completamento di questa disponibilita, ovvero 
	 * il completamento con numero di completamento piu' alto.
	 * @return <code>null</code> se non ci sono completamenti.
	 */
	public CompletamentoDisponibilita getUltimoComplemtamento() {
		CompletamentoDisponibilita ultimo = null;
		Iterator<CompletamentoDisponibilita> iterator = getCompletamenti().iterator();
		while (iterator.hasNext()) {
			CompletamentoDisponibilita comp = iterator.next();
			if (ultimo==null)
				ultimo = comp;
			else 
				if (comp.compareTo(ultimo) > 0)
					ultimo = comp;
		}
		return ultimo;
	}
	
}
