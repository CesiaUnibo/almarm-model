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

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import it.unibo.almarm.model.attori.Ateneo;
import it.unibo.almarm.model.attori.Persona;
import it.unibo.almarm.model.attori.Struttura;
import it.unibo.almarm.model.flussiscambio.ScambioAccordo;
import it.unibo.almarm.util.Common;

import org.apache.commons.lang.StringUtils;

public class AccordoOperativoView implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
    
	private Ateneo  ateneoPartner;
	private Persona referenteInterno;
	private Persona referenteEsterno;
	private Programma programma;
	private Struttura struttura;
	private AccordoOperativo accordoOperativo;
	
	private Long idAteneoPartner;
	private Long idStruttura;
	private Long idProgramma;
	private Long idNazionePartner;
	private String nomeAteneo;
	private String codiceErasmus;
	private String nomeReferenteInterno;
	private String cognomeReferenteInterno;
	private String nomeReferenteEsterno;
	private String cognomeReferenteEsterno;
	private String descrizioneProgramma; 
	
	private Date dataInserimento;
	private Date dataInizio;
	private Date dataFine;
	private Date dataStipula;
	private String stato;
	private String descrizioneAccordo;
	
	private Character inRinnovo;
	private Character validita;
	private Character tacitoRinnovo;
	// Agosto 2013
	private Character flagTipoApprovazione;
	private Long idAccordoPredecessore;
	
	// flagInApprovazioneModificaDaPartner: se "S" nella fase di conivolgimento dei Partner per la
	// stipula di nuovi accordi con il 
	// processo di "Stipula Contratto Partner" come la prima stipula erasmus plus),
	// indica che e' in corso una fase di negoziazione interna di una modifica recepita del partner;
	// la modifica deve essere avvallata per arrivare alla stipula del contratto e 
	// con questa flag accesa, il flusso del contratto partner deve bloccare l'upload del contratto firmato
	private Character flagInApprovazioneModificaDaPartner;
	private String statoContrattoPartner;
	private Integer numeroScambiStaff;
	private Character flagMobilitaErasmusExtraUE;
	
	private Set<ScambioAccordo> scambiAccordo = new HashSet<ScambioAccordo>();
	private Set<AccordoOperativoAteneoView> ateneiPerFiltri = new HashSet<AccordoOperativoAteneoView>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
	
	public Ateneo getAteneoPartner() {
		return ateneoPartner;
	}

	public void setAteneoPartner(Ateneo ateneoPartner) {
		this.ateneoPartner = ateneoPartner;
	}

	public String getNomeAteneo() {
		return nomeAteneo;
	}

	public void setNomeAteneo(String nomeAteneo) {
		this.nomeAteneo = nomeAteneo;
	}

	public Persona getReferenteInterno() {
		return referenteInterno;
	}

	public void setReferenteInterno(Persona referenteInterno) {
		this.referenteInterno = referenteInterno;
	}

	public String getCognomeReferenteInterno() {
		return cognomeReferenteInterno;
	}

	public void setCognomeReferenteInterno(String cognomeReferenteInterno) {
		this.cognomeReferenteInterno = cognomeReferenteInterno;
	}

	public String getNomeReferenteInterno() {
		return nomeReferenteInterno;
	}

	public void setNomeReferenteInterno(String nomeReferenteInterno) {
		this.nomeReferenteInterno = nomeReferenteInterno;
	}

	public Persona getReferenteEsterno() {
		return referenteEsterno;
	}

	public void setReferenteEsterno(Persona referenteEsterno) {
		this.referenteEsterno = referenteEsterno;
	}

	public String getCognomeReferenteEsterno() {
		return cognomeReferenteEsterno;
	}

	public void setCognomeReferenteEsterno(String cognomeReferenteEsterno) {
		this.cognomeReferenteEsterno = cognomeReferenteEsterno;
	}

	public String getNomeReferenteEsterno() {
		return nomeReferenteEsterno;
	}

	public void setNomeReferenteEsterno(String nomeReferenteEsterno) {
		this.nomeReferenteEsterno = nomeReferenteEsterno;
	}

	public Programma getProgramma() {
		return programma;
	}

	public void setProgramma(Programma programma) {
		this.programma = programma;
	}

	public String getDescrizioneProgramma() {
		return descrizioneProgramma;
	}

	public void setDescrizioneProgramma(String descrizioneProgramma) {
		this.descrizioneProgramma = descrizioneProgramma;
	}

	public String getLabel()
	{
		return StringUtils.defaultIfEmpty(cognomeReferenteInterno, "") + " -- " + StringUtils.defaultIfEmpty(cognomeReferenteEsterno, "");
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

	public Date getDataStipula() {
		return dataStipula;
	}

	public void setDataStipula(Date dataStipula) {
		this.dataStipula = dataStipula;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public Long getIdNazionePartner() {
		return idNazionePartner;
	}

	public void setIdNazionePartner(Long idNazionePartner) {
		this.idNazionePartner = idNazionePartner;
	}
	
	public Long getIdProgramma() {
		return idProgramma;
	}

	public void setIdProgramma(Long idProgramma) {
		this.idProgramma = idProgramma;
	}

	public Long getIdAteneoPartner() {
		return idAteneoPartner;
	}

	public void setIdAteneoPartner(Long idAteneoPartner) {
		this.idAteneoPartner = idAteneoPartner;
	}
	
	public Long getIdStruttura() {
		return idStruttura;
	}

	public void setIdStruttura(Long idStruttura) {
		this.idStruttura = idStruttura;
	}

	public String getCodiceErasmus() {
		return codiceErasmus;
	}

	public void setCodiceErasmus(String codiceErasmus) {
		this.codiceErasmus = codiceErasmus;
	}

	public String getDescrizioneAccordo() {
		return descrizioneAccordo;
	}

	public void setDescrizioneAccordo(String descrizioneAccordo) {
		this.descrizioneAccordo = descrizioneAccordo;
	}

	public Struttura getStruttura() {
		return struttura;
	}

	public void setStruttura(Struttura struttura) {
		this.struttura = struttura;
	}

	public String getAteneoRefintLabel()	{
		return ((getAteneoPartner().getCodiceErasmus() !=null ? ateneoPartner.getCodiceErasmus()+" - ":"")
				+ ateneoPartner.getRagioneSociale() + " - "
			    + (getReferenteInterno() != null ? referenteInterno.getNomeCognome() : "")
			    );
	}

	public String getAteneoAccordoDesc()
	{
		return ateneoPartner.getRagioneSociale() + "<br/>" + descrizioneAccordo;
	}
	
	public String getInizioFineDesc() {
		return Common.getDataFormattata(dataInizio) + "<br/>" + Common.getDataFormattata(dataFine);
	}
	
	public String getLabelResponsabili() {
		String resp = "";
		if (getReferenteInterno() != null)
			resp += getReferenteInterno().getNomeCognome() + "<br/>";
		if (getReferenteEsterno() != null)
			resp += getReferenteEsterno().getNomeCognome();
		return resp;
	}
	public String getLabelConValidita()
	{
		return StringUtils.defaultIfEmpty(cognomeReferenteInterno, "") + " -- " + StringUtils.defaultIfEmpty(cognomeReferenteEsterno, "")
		 	+ " -- ["+Common.getDataFormattata(dataInizio) + " - " + Common.getDataFormattata(dataFine)+"]";
	}
	
	public String getColor() {
		return StatoAccordo.get(stato).getColor();
	}

	public String getColorDesc() {
		return StatoAccordo.get(stato).getValore();
	}

	public Character getInRinnovo() {
		return inRinnovo;
	}

	public void setInRinnovo(Character inRinnovo) {
		this.inRinnovo = inRinnovo;
	}

	public Character getValidita() {
		return validita;
	}

	public void setValidita(Character validita) {
		this.validita = validita;
	}
	
	public String getValiditaColor() {
		return StatoValiditaAccordo.get(validita).getColor();
	}
	
	public String getValiditaColorDesc() {
		return StatoValiditaAccordo.get(validita).getDescrizione();
	}

	public Character getTacitoRinnovo() {
		return tacitoRinnovo;
	}

	public void setTacitoRinnovo(Character tacitoRinnovo) {
		this.tacitoRinnovo = tacitoRinnovo;
	}

	public Set<ScambioAccordo> getScambiAccordo() {
		return scambiAccordo;
	}

	public void setScambiAccordo(Set<ScambioAccordo> scambiAccordo) {
		this.scambiAccordo = scambiAccordo;
	}

	public Date getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public AccordoOperativo getAccordoOperativo() {
		return accordoOperativo;
	}

	public void setAccordoOperativo(AccordoOperativo accordoOperativo) {
		this.accordoOperativo = accordoOperativo;
	}

	public Set<AccordoOperativoAteneoView> getAteneiPerFiltri() {
		return ateneiPerFiltri;
	}

	public void setAteneiPerFiltri(Set<AccordoOperativoAteneoView> ateneiPerFiltri) {
		this.ateneiPerFiltri = ateneiPerFiltri;
	}

	public Long getIdAccordoPredecessore() {
		return idAccordoPredecessore;
	}

	public void setIdAccordoPredecessore(Long idAccordoPredecessore) {
		this.idAccordoPredecessore = idAccordoPredecessore;
	}
/*
	public Character getFlagRichiestaModifica() {
		return flagRichiestaModifica;
	}

	public void setFlagRichiestaModifica(Character flagRichiestaModifica) {
		this.flagRichiestaModifica = flagRichiestaModifica;
	}
*/

	public Character getFlagTipoApprovazione() {
		return flagTipoApprovazione;
	}

	public void setFlagTipoApprovazione(Character flagTipoApprovazione) {
		this.flagTipoApprovazione = flagTipoApprovazione;
	}

	public Character getFlagInApprovazioneModificaDaPartner() {
		return flagInApprovazioneModificaDaPartner;
	}

	public void setFlagInApprovazioneModificaDaPartner(
			Character flagInApprovazioneModificaDaPartner) {
		this.flagInApprovazioneModificaDaPartner = flagInApprovazioneModificaDaPartner;
	}

	public boolean isInApprovazioneModificaDaPartner(){
		return Common.CH_S.equals(flagInApprovazioneModificaDaPartner);
	}

	public String getStatoContrattoPartner() {
		return statoContrattoPartner;
	}

	public void setStatoContrattoPartner(String statoContrattoPartner) {
		this.statoContrattoPartner = statoContrattoPartner;
	}

	public Integer getNumeroScambiStaff() {
		return numeroScambiStaff;
	}

	public void setNumeroScambiStaff(Integer numeroScambiStaff) {
		this.numeroScambiStaff = numeroScambiStaff;
	}

	public Character getFlagMobilitaErasmusExtraUE() {
		return flagMobilitaErasmusExtraUE;
	}

	public void setFlagMobilitaErasmusExtraUE(Character flagMobilitaErasmusExtraUE) {
		this.flagMobilitaErasmusExtraUE = flagMobilitaErasmusExtraUE;
	}
	
	public boolean isScaduto() {
		return Common.CH_S.equals(validita);
	}
}
