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

import java.util.Date;

import it.unibo.almarm.model.accordi.Coorte;
import it.unibo.almarm.model.incoming.StudenteIncoming;
import it.unibo.almarm.model.outgoing.Bando;
import it.unibo.almarm.model.outgoing.StudenteOutgoing;
import it.unibo.frontieraCia.model.Minicarriera;

public class RataVocirataExpView   implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/**********   Rata View  ************/
	private Long id;
	private Long numeroRata;
	private String descrizione;
	private Date dataInizio;
	private Date dataAmmontarePrevisto;
	private Date dataAmmontareIntermedio;
	private Double ammontarePrevisto;
	private Double ammontareIntermedio;
	private Double ammontareEffettivo;
	private String stato;
	private Long idListaPagamenti;
	private Long idStudenteOutgoing;
	private Long idStudenteIncoming;
	private Long idBando;
	private Long idTipologiaPagamento;
	private Long idCoorte;
	private String email;
	private Character flagRestituzione;
	private Long durataRestituzione;
	private Date dataRestituzione;
	
	private Minicarriera minicarriera;
	private ModalitaDiPagamento modalitaPagamento;
	private Coorte coorte;
	private Bando bando;
	private StudenteOutgoing studenteOutgoing;
	private StudenteIncoming studenteIncoming;
	private ListaPagamentiView listaPagamenti;
	private Character flagIncomingOutgoing;
    private String statoRichiestaRiconoscimento;
	private Date dataPresentazioneRichiestaRiconoscimento;
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMinicarriera(Minicarriera minicarriera) {
		this.minicarriera = minicarriera;
	}

	public Minicarriera getMinicarriera() {
		return minicarriera;
	}

	public void setNumeroRata(Long numeroRata) {
		this.numeroRata = numeroRata;
	}

	public Long getNumeroRata() {
		return numeroRata;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setModalitaPagamento(ModalitaDiPagamento modalitaPagamento) {
		this.modalitaPagamento = modalitaPagamento;
	}

	public ModalitaDiPagamento getModalitaPagamento() {
		if (modalitaPagamento==null && studenteOutgoing!=null)
			return studenteOutgoing.getModalitaDiPagamento();
		return modalitaPagamento;
	}

	public void setDataAmmontarePrevisto(Date dataAmmontarePrevisto) {
		this.dataAmmontarePrevisto = dataAmmontarePrevisto;
	}

	public Date getDataAmmontarePrevisto() {
		return dataAmmontarePrevisto;
	}

	public void setAmmontarePrevisto(Double ammontarePrevisto) {
		this.ammontarePrevisto = ammontarePrevisto;
	}

	public Double getAmmontarePrevisto() {
		return ammontarePrevisto;
	}

	public void setDataAmmontareIntermedio(Date dataAmmontareIntermedio) {
		this.dataAmmontareIntermedio = dataAmmontareIntermedio;
	}

	public Date getDataAmmontareIntermedio() {
		return dataAmmontareIntermedio;
	}

	public void setAmmontareIntermedio(Double ammontareIntermedio) {
		this.ammontareIntermedio = ammontareIntermedio;
	}

	public Double getAmmontareIntermedio() {
		return ammontareIntermedio;
	}

	public void setAmmontareEffettivo(Double ammontareEffettivo) {
		this.ammontareEffettivo = ammontareEffettivo;
	}

	public Double getAmmontareEffettivo() {
		return ammontareEffettivo;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getStato() {
		return stato;
	}
	
	public String getColor() {
		return StatoRata.get(stato).getColor();
	}

	public String getColorDesc() {
		return StatoRata.get(stato).getValore();
	}
	
	public StatoRata getStatoRata() {
		return StatoRata.get(getStato());
	}
	
	public String getTipologiaPagamentoLabel() {
		if (getModalitaPagamento() == null || getModalitaPagamento().getTipologiaPagamento() == null)
			return null;
		return getModalitaPagamento().getTipologiaPagamento().getNome();
	}

	public void setIdListaPagamenti(Long idListaPagamenti) {
		this.idListaPagamenti = idListaPagamenti;
	}

	public Long getIdListaPagamenti() {
		return idListaPagamenti;
	}

	public void setIdStudenteOutgoing(Long idStudenteOutgoing) {
		this.idStudenteOutgoing = idStudenteOutgoing;
	}

	public Long getIdStudenteOutgoing() {
		return idStudenteOutgoing;
	}

	public void setIdBando(Long idBando) {
		this.idBando = idBando;
	}

	public Long getIdBando() {
		return idBando;
	}

	public void setIdTipologiaPagamento(Long idTipologiaPagamento) {
		this.idTipologiaPagamento = idTipologiaPagamento;
	}

	public Long getIdTipologiaPagamento() {
		return idTipologiaPagamento;
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

	public void setBando(Bando bando) {
		this.bando = bando;
	}

	public Bando getBando() {
		return bando;
	}

	public void setStudenteOutgoing(StudenteOutgoing studenteOutgoing) {
		this.studenteOutgoing = studenteOutgoing;
	}

	public StudenteOutgoing getStudenteOutgoing() {
		return studenteOutgoing;
	}

	public void setListaPagamenti(ListaPagamentiView listaPagamenti) {
		this.listaPagamenti = listaPagamenti;
	}

	public ListaPagamentiView getListaPagamenti() {
		return listaPagamenti;
	}
	
	public String getNomeListaCia() {
		if (listaPagamenti == null)
			return null;
		return listaPagamenti.getNomeListaCia();
	}
	
	public Date getDataCreazioneListaCia() {
		if (listaPagamenti == null)
			return null;
		return listaPagamenti.getDataCreazione();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFlagRestituzione(Character flagRestituzione) {
		this.flagRestituzione = flagRestituzione;
	}

	public Character getFlagRestituzione() {
		return flagRestituzione;
	}

	public Long getDurataRestituzione() {
		return durataRestituzione;
	}

	public void setDurataRestituzione(Long durataRestituzione) {
		this.durataRestituzione = durataRestituzione;
	}

	public Date getDataRestituzione() {
		return dataRestituzione;
	}

	public void setDataRestituzione(Date dataRestituzione) {
		this.dataRestituzione = dataRestituzione;
	}

	public Long getIdStudenteIncoming() {
		return idStudenteIncoming;
	}

	public void setIdStudenteIncoming(Long idStudenteIncoming) {
		this.idStudenteIncoming = idStudenteIncoming;
	}

	public StudenteIncoming getStudenteIncoming() {
		return studenteIncoming;
	}

	public void setStudenteIncoming(StudenteIncoming studenteIncoming) {
		this.studenteIncoming = studenteIncoming;
	}

	public Character getFlagIncomingOutgoing() {
		return flagIncomingOutgoing;
	}

	public void setFlagIncomingOutgoing(Character flagIncomingOutgoing) {
		this.flagIncomingOutgoing = flagIncomingOutgoing;
	}

    public String getStatoRichiestaRiconoscimento() {
        return statoRichiestaRiconoscimento;
    }

    public void setStatoRichiestaRiconoscimento(String statoRichiestaRiconoscimento) {
        this.statoRichiestaRiconoscimento = statoRichiestaRiconoscimento;
    }

	public Date getDataPresentazioneRichiestaRiconoscimento() {
		return dataPresentazioneRichiestaRiconoscimento;
	}

	public void setDataPresentazioneRichiestaRiconoscimento(Date dataPresentazioneRichiestaRiconoscimento) {
		this.dataPresentazioneRichiestaRiconoscimento = dataPresentazioneRichiestaRiconoscimento;
	}

	/********** campi propri delle voci rata *******/
	
	private String descrVoce1;
	private Double ammVoce1;
	private String durataVoce1;
	private Double ammxUmdVoce1;
	private String descrVoce2;
	private Double ammVoce2;
	private String durataVoce2;
	private Double ammxUmdVoce2;
	private Double valoreIsee;
	
	public String getDescrVoce1() {
		return descrVoce1;
	}
	public void setDescrVoce1(String descrVoce1) {
		this.descrVoce1 = descrVoce1;
	}
	public Double getAmmVoce1() {
		return ammVoce1;
	}
	public void setAmmVoce1(Double ammVoce1) {
		this.ammVoce1 = ammVoce1;
	}
	public String getDurataVoce1() {
		return durataVoce1;
	}
	public void setDurataVoce1(String durataVoce1) {
		this.durataVoce1 = durataVoce1;
	}
	public Double getAmmxUmdVoce1() {
		return ammxUmdVoce1;
	}
	public void setAmmxUmdVoce1(Double ammxUmdVoce1) {
		this.ammxUmdVoce1 = ammxUmdVoce1;
	}
	public String getDescrVoce2() {
		return descrVoce2;
	}
	public void setDescrVoce2(String descrVoce2) {
		this.descrVoce2 = descrVoce2;
	}
	public Double getAmmVoce2() {
		return ammVoce2;
	}
	public void setAmmVoce2(Double ammVoce2) {
		this.ammVoce2 = ammVoce2;
	}
	public String getDurataVoce2() {
		return durataVoce2;
	}
	public void setDurataVoce2(String durataVoce2) {
		this.durataVoce2 = durataVoce2;
	}
	public Double getAmmxUmdVoce2() {
		return ammxUmdVoce2;
	}
	public void setAmmxUmdVoce2(Double ammxUmdVoce2) {
		this.ammxUmdVoce2 = ammxUmdVoce2;
	}
	public Double getValoreIsee() {
		return valoreIsee;
	}
	public void setValoreIsee(Double valoreIsee) {
		this.valoreIsee = valoreIsee;
	}

}
