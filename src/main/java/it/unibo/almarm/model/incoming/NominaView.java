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

import it.unibo.almarm.model.accordi.AccordoOperativo;
import it.unibo.almarm.model.accordi.SottoProgramma;
import it.unibo.almarm.util.Common;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

public class NominaView implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String cognome;
	private String nome;
	private Long idAteneo;
	private String labelAteneo;
	private Long idNazione;
	private SottoProgramma sottoProgramma;
	private String siglaCampus;
	private String codFac;
	private String cognomeReferenteInterno;
	private Long idPeriodo;
	private String codCorso;
	private Date dataInvioMail;
	private Long idStudenteIncoming;
	private String areaDisciplinare;
	private AccordoOperativo accordoOperativo;
	private Character flagRinuncia;
	private Character flagDottorato;
	private TipoMobilita tipoMobilita;
	private Long idReferenteInterno;
	private String stato;
	private Character flagInseritoDaPartner;
	private String applicazione;
	private Integer annoAccademico;
	
	private Set<ReferenteIncomingView> referentiIncoming = new HashSet<ReferenteIncomingView>();
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getIdAteneo() {
		return idAteneo;
	}

	public void setIdAteneo(Long idAteneo) {
		this.idAteneo = idAteneo;
	}

	public String getLabelAteneo() {
		return labelAteneo;
	}

	public void setLabelAteneo(String labelAteneo) {
		this.labelAteneo = labelAteneo;
	}

	public Long getIdNazione() {
		return idNazione;
	}

	public void setIdNazione(Long idNazione) {
		this.idNazione = idNazione;
	}

	public SottoProgramma getSottoProgramma() {
		return sottoProgramma;
	}

	public void setSottoProgramma(SottoProgramma sottoProgramma) {
		this.sottoProgramma = sottoProgramma;
	}

	public String getCodFac() {
		return codFac;
	}

	public void setCodFac(String codFac) {
		this.codFac = codFac;
	}

	public String getCognomeReferenteInterno() {
		return cognomeReferenteInterno;
	}

	public void setCognomeReferenteInterno(String cognomeReferenteInterno) {
		this.cognomeReferenteInterno = cognomeReferenteInterno;
	}

	public Long getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(Long idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public String getCodCorso() {
		return codCorso;
	}

	public void setCodCorso(String codCorso) {
		this.codCorso = codCorso;
	}

	public Long getIdStudenteIncoming() {
		return idStudenteIncoming;
	}

	public void setIdStudenteIncoming(Long idStudenteIncoming) {
		this.idStudenteIncoming = idStudenteIncoming;
	}

	public String getAreaDisciplinare() {
		return areaDisciplinare;
	}

	public void setAreaDisciplinare(String areaDisciplinare) {
		this.areaDisciplinare = areaDisciplinare;
	}

	public AccordoOperativo getAccordoOperativo() {
		return accordoOperativo;
	}

	public void setAccordoOperativo(AccordoOperativo accordoOperativo) {
		this.accordoOperativo = accordoOperativo;
	}

	public Date getDataInvioMail() {
		return dataInvioMail;
	}

	public void setDataInvioMail(Date dataInvioMail) {
		this.dataInvioMail = dataInvioMail;
	}
	
	public String getLabelSottoprogrammaCorso()
	{
		return getSottoProgramma().getNome() + (!StringUtils.isBlank(codCorso)? "<br/>Corso: "+codCorso :"");
	}

	public String getSiglaCampus() {
		if (siglaCampus == null)
			return "";
		return siglaCampus;
	}

	public void setSiglaCampus(String siglaCampus) {
		this.siglaCampus = siglaCampus;
	}
	
	public String getColor() {
		return Nomina.StatoNomina.getBy(getStato()).getColor();
	}
	
	public String getColorDesc() {
		return getStato();
	}
	
	public String getStatoInvioMailColor() {
		return (dataInvioMail!=null)?  "green":"white";	
	}
	
	public String getStatoInvioMailColorDesc() {
		return (dataInvioMail!=null)?  "inviata":"non inviata";	
	}

	public Character getFlagRinuncia() {
		return flagRinuncia;
	}

	public void setFlagRinuncia(Character flagRinuncia) {
		this.flagRinuncia = flagRinuncia;
	}
	
	public boolean isRinunciata() {
		return (new Character('S')).equals(flagRinuncia);
	}
	
	public boolean isNotStudenteIncomingRegistrato() {
		return getIdStudenteIncoming() == null;
	}
	
	public Character getFlagDottorato() {
		if (flagDottorato == null)
			return 'N';
		return flagDottorato;
	}
	
	public void setFlagDottorato(Character flagDottorato) {
		this.flagDottorato = flagDottorato;
	}

	public TipoMobilita getTipoMobilita() {
		return tipoMobilita;
	}

	public void setTipoMobilita(TipoMobilita tipoMobilita) {
		this.tipoMobilita = tipoMobilita;
	}

	public Long getIdReferenteInterno() {
		return idReferenteInterno;
	}

	public void setIdReferenteInterno(Long idReferenteInterno) {
		this.idReferenteInterno = idReferenteInterno;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public Character getFlagInseritoDaPartner() {
		if (flagInseritoDaPartner!=null)
			return flagInseritoDaPartner;
		return 'N';
	}

	public void setFlagInseritoDaPartner(Character flagInseritoDaPartner) {
		this.flagInseritoDaPartner = flagInseritoDaPartner;
	}

	public String getApplicazione() {
		return applicazione;
	}

	public void setApplicazione(String applicazione) {
		this.applicazione = applicazione;
	}

	public Integer getAnnoAccademico() {
		return annoAccademico;
	}

	public void setAnnoAccademico(Integer annoAccademico) {
		this.annoAccademico = annoAccademico;
	}

	public Set<ReferenteIncomingView> getReferentiIncoming() {
		return referentiIncoming;
	}

	public void setReferentiIncoming(Set<ReferenteIncomingView> referentiIncoming) {
		this.referentiIncoming = referentiIncoming;
	}
	
	public  String getAnnoAccLabelCorta() {
		return /*"A.A. " +*/ Common.getAALabelCorta(annoAccademico);
	}
}
