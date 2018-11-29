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
package it.unibo.almarm.model.outgoing.learningagreement;

import it.unibo.almarm.model.attori.Persona;
import it.unibo.almarm.model.outgoing.StatoRichiestaRiconoscimento;
import it.unibo.almarm.util.Common;

import java.util.Comparator;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class AttivitaUnibo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Character flagRiconosciuta;
	//private Integer votoRiconosciuto;
	private Persona autoreRiconoscimento;
	private Date dataRiconoscimento;
	private String noteRiconoscimento;
	private Integer pincode;
	private Integer carriera; 
	private Integer annoAccademico;
	private String codCorso;
	private String codInd;
	private String codOri;
	private String codMateria;
	private String annoCorsoPrevisto;
	private String annoCorsoReale;
	private Integer idPiano;
	private Integer idComponenteAF;
	private String annoCorso;
	private Character tipo;
	private String descrizione;
	private Character flagInPiano;
	private Character flagObbligatorio;
	private Integer cfu;
	private String ssd;
	private Character flagDaRiconoscere;
	private Character flagAggiuntaInRichiestaRiconoscimento;
	private Character flagRiconoscimentoProposto;
	//private Integer votoProposto;
	private Integer cfuProposti;
	private Integer cfuRiconosciuti;
	private String votoCorsoIntegrato;
	private String votoCorsoIntegratoProposto;
	// identificano il corso integrato cui il modulo appartiene
	private String codCorsoPadre;
	private String codIndPadre;
	private String codOriPadre;
	private String codMateriaPadre;

	private String votoProposto;
	private String votoRiconosciuto;
	private Integer order;
	private BloccoAttivita bloccoAttivita;
	private AttivitaUnibo attivitaPrecedente;
	private Character flagCopiataDaVersioneLaPrecedente;
	private String motivazioneModifica;
	private Character flagCancellata;
	private Character flagSsdSuCreditiASceltaTirocinio;
	private Character flagTirocinioCurriculare;
	private Character flagNonUtileAlConseguimentoDelTitolo;

	// campi non persistiti
	// indica se l'attivita' e' un modulo di un corso integrato
	private Boolean appartieneAIntegrato;
	// nome del corso integrato padre
	private String nomeCorsoIntegratoPadre;
	// indica se nel LA cui l'attivita' appartiene sono presenti tutti i moduli del corso integrato padre
	private Boolean tuttiModuliInLA;
	// contine un eventuale messaggio da mostrare relativo al corso integrato
	private String messaggioSuIntegrato;
	// contiene il nome dell'attivita' formativa senza l'indicazione del corso integrato padre
	private String descMateriaShort;
	// utilizzato per i crediti a scelta dei LAT 
	private boolean attiva;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Character getFlagRiconosciuta() {
		if (flagRiconosciuta == null)
			return 'N';
		return flagRiconosciuta;
	}

	public void setFlagRiconosciuta(Character flagRiconosciuta) {
		this.flagRiconosciuta = flagRiconosciuta;
	}
/* 
	public Integer getVotoRiconosciuto() {
		return votoRiconosciuto;
	}

	public void setVotoRiconosciuto(Integer votoRiconosciuto) {
		this.votoRiconosciuto = votoRiconosciuto;
	}
 */
	public Persona getAutoreRiconoscimento() {
		return autoreRiconoscimento;
	}

	public void setAutoreRiconoscimento(Persona autoreRiconoscimento) {
		this.autoreRiconoscimento = autoreRiconoscimento;
	}

	public Date getDataRiconoscimento() {
		return dataRiconoscimento;
	}

	public void setDataRiconoscimento(Date dataRiconoscimento) {
		this.dataRiconoscimento = dataRiconoscimento;
	}

	public String getNoteRiconoscimento() {
		return noteRiconoscimento;
	}

	public void setNoteRiconoscimento(String noteRiconoscimento) {
		this.noteRiconoscimento = noteRiconoscimento;
	}
	
	public String getLabel() {
		if (isEsameStudente() || isEsameCorso() || isMateria())
			return getCodMateria() + " - " + getDescrizione() + (getCfu() != null ? " - " + getCfu() + " CFU" : "");
		if (isSceltaLibera())
			return (getCfu() != null ? " " + getCfu() + " CFU " : "") + (StringUtils.isNotBlank(getSsd()) ? "di " + getSsd() : "- SSD non specificato"); 
		return "???TODO???";
	}
	
	public String getLabelConInfoModifica() {
		String label = getLabel();
		if (!isCopiataDaVersioneLaPrecedente())
			label += " - Attività non presente nel precedente LA approvato";
		if (isCancellata())
			label = "<span style=\"text-decoration: line-through;\">" + label + "</span>";
		return label;
	}
	
	public String getLabelConInfoRiconoscimento() {
		boolean barrato = false;
		String l = "";
		if (isAggiuntaInRichiestaRiconoscimento())
			l += " - Attività non presente in LA";
		if (isRiconoscimentoNegatoInApprovazione())
		{
			l += " - Riconoscimento negato dal consiglio di corso di studi";
			barrato = true;
		}
		else if (isRiconoscimentoNegatoInValidazione() && isRiconoscimentoDefinitivoDaValutare())
		{
			l += " - Riconoscimento negato dal docente referente";
			barrato = true;
		}
		else if (isDaNonRiconoscere())
		{
			l += " - Lo studente non richiede il riconoscimento";
			barrato = true;
		}
		else
		{
			if (votoRiconosciuto != null)
				l += " - Voto riconosciuto: " + votoRiconosciuto;
			else if (votoProposto != null)
				l += " - Voto proposto: " + votoProposto;
			if (cfuRiconosciuti != null)
				l += " - CFU riconosciuti: " + cfuRiconosciuti;
			else if (cfuProposti != null)
				l += " - CFU proposti: " + cfuProposti;
		}
		String tipo = "";
		if (getBloccoAttivita() != null && getBloccoAttivita().getLearningAgreement() != null && getBloccoAttivita().getLearningAgreement().isForTraineeship()) {
			if (isTirocinioCurriculare())
				tipo = "Tirocinio curriculare - ";
			else if (!isTirocinioCurriculare() && !isNonUtileAlConseguimentoDelTitolo())
				tipo = "Attività a libera scelta - ";
			else if (isNonUtileAlConseguimentoDelTitolo())
				tipo = "Crediti non utili al conseguimento del titolo - ";
		}
		String label = tipo + getLabel();
		String r = barrato ? "<span style=\"text-decoration: line-through;\">" + label + "</span>" : label;
		return r + l;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public Integer getCarriera() {
		return carriera;
	}

	public void setCarriera(Integer carriera) {
		this.carriera = carriera;
	}

	public Integer getAnnoAccademico() {
		return annoAccademico;
	}

	public void setAnnoAccademico(Integer annoAccademico) {
		this.annoAccademico = annoAccademico;
	}

	public String getCodCorso() {
		return codCorso;
	}

	public void setCodCorso(String codCorso) {
		this.codCorso = codCorso;
	}

	public String getCodInd() {
		return codInd;
	}

	public void setCodInd(String codInd) {
		this.codInd = codInd;
	}

	public String getCodOri() {
		return codOri;
	}

	public void setCodOri(String codOri) {
		this.codOri = codOri;
	}

	public String getCodMateria() {
		return codMateria;
	}

	public void setCodMateria(String codMateria) {
		this.codMateria = codMateria;
	}

	public String getAnnoCorsoPrevisto() {
		return annoCorsoPrevisto;
	}

	public void setAnnoCorsoPrevisto(String annoCorsoPrevisto) {
		this.annoCorsoPrevisto = annoCorsoPrevisto;
	}

	public String getAnnoCorsoReale() {
		return annoCorsoReale;
	}

	public void setAnnoCorsoReale(String annoCorsoReale) {
		this.annoCorsoReale = annoCorsoReale;
	}

	public Integer getIdPiano() {
		return idPiano;
	}

	public void setIdPiano(Integer idPiano) {
		this.idPiano = idPiano;
	}

	public Integer getIdComponenteAF() {
		return idComponenteAF;
	}

	public void setIdComponenteAF(Integer idComponenteAF) {
		this.idComponenteAF = idComponenteAF;
	}

	public String getAnnoCorso() {
		return annoCorso;
	}

	public void setAnnoCorso(String annoCorso) {
		this.annoCorso = annoCorso;
	}

	public String getSsd() {
		return ssd;
	}

	public void setSsd(String ssd) {
		this.ssd = ssd;
	}

	public Character getTipo() {
		return tipo;
	}

	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Character getFlagInPiano() {
		return flagInPiano;
	}

	public void setFlagInPiano(Character flagInPiano) {
		this.flagInPiano = flagInPiano;
	}
	
	public boolean isInPiano() {
		return Common.CH_S.equals(getFlagInPiano());
	}

	public Character getFlagObbligatorio() {
		return flagObbligatorio;
	}

	public void setFlagObbligatorio(Character flagObbligatorio) {
		this.flagObbligatorio = flagObbligatorio;
	}

	public Integer getCfu() {
		return cfu;
	}

	public void setCfu(Integer cfu) {
		this.cfu = cfu;
	}
	
	public boolean isEsameStudente() {
		return Common.CH_S.equals(getTipo());
	}
	
	public boolean isEsameCorso() {
		return Common.CH_F.equals(getTipo());
	}
	
	public boolean isMateria() {
		return Common.CH_C.equals(getTipo());
	}
	
	public boolean isSceltaLibera() {
		return Common.CH_L.equals(getTipo());
	}
	
	public String getIdEsameStudente() {
		if (!isEsameStudente())
			throw new RuntimeException("Tentativo di lettura id esame studente da attività unibo di tipo " + getTipo());
		String ret = "";
		ret = "id" + Common.idSeparator 
		+ pincode + Common.idSeparator 
		+ carriera + Common.idSeparator 
		+ annoAccademico + Common.idSeparator
		+ codCorso + Common.idSeparator
		+ codInd + Common.idSeparator
		+ codOri + Common.idSeparator
		+ codMateria + Common.idSeparator
		+ annoCorsoPrevisto + Common.idSeparator
		+ annoCorsoReale + Common.idSeparator
		+ StringUtils.defaultIfEmpty(codCorsoPadre, Common.idCorsoIntegratoPadreNullo) + Common.idSeparator
		+ StringUtils.defaultIfEmpty(codIndPadre, Common.idCorsoIntegratoPadreNullo) + Common.idSeparator
		+ StringUtils.defaultIfEmpty(codOriPadre, Common.idCorsoIntegratoPadreNullo) + Common.idSeparator
                + StringUtils.defaultIfEmpty(codMateriaPadre, Common.idCorsoIntegratoPadreNullo) + Common.idSeparator
                + (getCfu() != null ? getCfu().intValue() : "0");
		return ret;
	}
	
	public String getIdEsameCorso() {
		if (!isEsameCorso())
			throw new RuntimeException("Tentativo di lettura id esame corso da attività unibo di tipo " + getTipo());
		String ret = "";
		ret = "id" + Common.idSeparator
		+ annoAccademico + Common.idSeparator
		+ idPiano + Common.idSeparator
		+ idComponenteAF + Common.idSeparator
		+ annoCorso;
		return ret;
	}
	
	public AttivitaUnibo copy() {
		AttivitaUnibo au = new AttivitaUnibo();
		au.setAnnoAccademico(annoAccademico);
		au.setAnnoCorso(annoCorso);
		au.setAnnoCorsoPrevisto(annoCorsoPrevisto);
		au.setAnnoCorsoReale(annoCorsoReale);
		au.setAutoreRiconoscimento(autoreRiconoscimento);
		au.setCarriera(carriera);
		au.setCfu(cfu);
		au.setCodCorso(codCorso);
		au.setCodInd(codInd);
		au.setCodMateria(codMateria);
		au.setCodOri(codOri);
		au.setDataRiconoscimento(dataRiconoscimento);
		au.setDescrizione(descrizione);
		au.setFlagInPiano(flagInPiano);
		au.setFlagObbligatorio(flagObbligatorio);
		au.setFlagRiconosciuta(flagRiconosciuta);
		au.setIdComponenteAF(idComponenteAF);
		au.setIdPiano(idPiano);
		au.setNoteRiconoscimento(noteRiconoscimento);
		au.setPincode(pincode);
		au.setSsd(ssd);
		au.setTipo(tipo);
		au.setVotoRiconosciuto(votoRiconosciuto);
		au.setFlagDaRiconoscere(flagDaRiconoscere);
		au.setFlagAggiuntaInRichiestaRiconoscimento(flagAggiuntaInRichiestaRiconoscimento);
		au.setOrder(order);
		au.setCodCorsoPadre(codCorsoPadre);
		au.setCodIndPadre(codIndPadre);
		au.setCodOriPadre(codOriPadre);
		au.setCodMateriaPadre(codMateriaPadre);
		au.setFlagSsdSuCreditiASceltaTirocinio(flagSsdSuCreditiASceltaTirocinio);
		au.setFlagTirocinioCurriculare(flagTirocinioCurriculare);
		au.setFlagNonUtileAlConseguimentoDelTitolo(flagNonUtileAlConseguimentoDelTitolo);
		au.setAttivitaPrecedente(this);
		if (this.getBloccoAttivita().getLearningAgreement().isApprovato())
			au.setFlagCopiataDaVersioneLaPrecedente('S');
		else
		{
			au.setFlagCopiataDaVersioneLaPrecedente(this.getFlagCopiataDaVersioneLaPrecedente());
			au.setFlagCancellata(this.getFlagCancellata());
			au.setMotivazioneModifica(this.getMotivazioneModifica());
		}
		return au;
	}

	public Character getFlagDaRiconoscere() {
		if (flagDaRiconoscere == null)
			return Common.CH_D;
		return flagDaRiconoscere;
	}

	public void setFlagDaRiconoscere(Character flagDaRiconoscere) {
		this.flagDaRiconoscere = flagDaRiconoscere;
	}
	
	public boolean isDaNonRiconoscere() {
		return Common.CH_N.equals(getFlagDaRiconoscere());
	}
	
	public boolean isDaRiconoscere() {
		return Common.CH_S.equals(getFlagDaRiconoscere());
	}
	
	public Character getFlagAggiuntaInRichiestaRiconoscimento() {
		if (flagAggiuntaInRichiestaRiconoscimento == null)
			return 'N';
		return flagAggiuntaInRichiestaRiconoscimento;
	}

	public void setFlagAggiuntaInRichiestaRiconoscimento(
			Character flagAggiuntaInRichiestaRiconoscimento) {
		this.flagAggiuntaInRichiestaRiconoscimento = flagAggiuntaInRichiestaRiconoscimento;
	}
	
	public boolean isAggiuntaInRichiestaRiconoscimento() {
		return Common.CH_S.equals(getFlagAggiuntaInRichiestaRiconoscimento());
	}
	
	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public static class AttivitaUniboComparator implements Comparator<AttivitaUnibo>
	{
		public int compare(AttivitaUnibo o1, AttivitaUnibo o2) {
			if (o1 == null && o2 == null)
				return 0;
			if (o1 == null && o2 != null)
				return 1;
			if (o1 != null && o2 == null)
				return -1;
			if (o1.isAggiuntaInRichiestaRiconoscimento() && !o2.isAggiuntaInRichiestaRiconoscimento())
				return 1;
			if (o2.isAggiuntaInRichiestaRiconoscimento() && !o1.isAggiuntaInRichiestaRiconoscimento())
				return -1;
			if (o1.getOrder() != null)
				return o1.getOrder().compareTo(o2.getOrder());
			if (o2.getOrder() != null)
				return o2.getOrder().compareTo(o1.getOrder());
			if (StringUtils.isBlank(o1.getDescrizione()) && StringUtils.isBlank(o2.getDescrizione()))
				return 0;
			if (StringUtils.isNotBlank(o1.getDescrizione()))
				return o1.getDescrizione().compareTo(o2.getDescrizione());
			return -1;
		}
	}

	public String getDaRiconoscereLabel() {
		switch (getFlagDaRiconoscere()) {
		case 'D':
			return " ";
		case 'S':
			return "si";
		case 'N':
			return "no";
		}
		return "";
	}

	public Character getFlagRiconoscimentoProposto() {
		if (flagRiconoscimentoProposto == null)
			return Common.CH_D;
		return flagRiconoscimentoProposto;
	}
	
	public void setFlagRiconoscimentoProposto(Character flagRiconoscimentoProposto) {
		this.flagRiconoscimentoProposto = flagRiconoscimentoProposto;
	}
	
	public boolean isRiconoscimentoNegatoInValidazione() {
		return Common.CH_N.equals(getFlagRiconoscimentoProposto());
	}
	
	public boolean isRiconoscimentoNegatoInApprovazione() {
		return Common.CH_R.equals(getFlagRiconosciuta());
	}
	
	public boolean isRiconoscimentoNegato() {
		if (getFlagRiconosciuta() == null || Common.CH_N.equals(getFlagRiconosciuta()))
			return Common.CH_N.equals(getFlagRiconoscimentoProposto());
		return Common.CH_R.equals(getFlagRiconosciuta());
	}

/*	
	public Integer getVotoProposto() {
		return votoProposto;
	}

	public void setVotoProposto(Integer votoProposto) {
		this.votoProposto = votoProposto;
	}
*/
	public Integer getCfuProposti() {
		if (cfuProposti == null && isDaRiconoscere())
			return getCfu();
		return cfuProposti;
	}

	public void setCfuProposti(Integer cfuProposti) {
		this.cfuProposti = cfuProposti;
	}
	
	public String getRiconoscimentoPropostoLabel() {
		switch (getFlagRiconoscimentoProposto()) {
		case 'D':
			return " ";
		case 'S':
			return "si";
		case 'N':
			return "no";
		}
		return "";
	}

	public Integer getCfuRiconosciuti() {
		return cfuRiconosciuti;
	}

	public void setCfuRiconosciuti(Integer cfuRiconosciuti) {
		this.cfuRiconosciuti = cfuRiconosciuti;
	}
	
	public String getRiconosciutaLabel() {
		switch (getFlagRiconosciuta()) {
		case 'N':
			return "";
		case 'S':
			return "si";
		case 'R':
			return "no";
		}
		return "";
	}
	
	public String getRiconoscimentoLabel() {
		return StringUtils.defaultIfEmpty(getRiconosciutaLabel(), getRiconoscimentoPropostoLabel());
	}
	
	public String getVotoLabel() {
		return votoRiconosciuto != null ? votoRiconosciuto.toString() : votoProposto != null ? votoProposto.toString() : " ";
	}
	
	public String getCfuRiconosciutiLabel() {
		return cfuRiconosciuti != null ? cfuRiconosciuti.toString() : cfuProposti != null ? cfuProposti.toString() : " ";
	}
	
	public boolean isRiconosiuta() {
		return Common.CH_S.equals(getFlagRiconosciuta());
	}
	
	public boolean isRiconoscimentoPropostoDaValutare() {
		return Common.CH_D.equals(getFlagRiconoscimentoProposto());
	}
	
	public boolean isRiconoscimentoDefinitivoDaValutare() {
		return Common.CH_N.equals(getFlagRiconosciuta());
	}

	/**
	 * Metodo da utilizzare solo dopo aver precompilato il campo appartieneAIntegrato
	 * @return appartieneAIntegrato
	 */
	public Boolean getAppartieneAIntegrato() {
		if (appartieneAIntegrato == null)
			throw new RuntimeException("ATTENZIONE!! L'utilizzo delle info sui corsi integrati e' permesso solo dopo aver compilato correttamente le attivita'. Vedi learningAgreementManager.getAttivitaUniboConInfoIntegrati");
		return appartieneAIntegrato;
	}

	public void setAppartieneAIntegrato(Boolean appartieneAIntegrato) {
		this.appartieneAIntegrato = appartieneAIntegrato;
	}

	public Boolean getTuttiModuliInLA() {
		return tuttiModuliInLA;
	}

	public void setTuttiModuliInLA(Boolean tuttiModuliInLA) {
		this.tuttiModuliInLA = tuttiModuliInLA;
	}

	public String getIdCorsoIntegratoPadre() {
		return getCodCorsoPadre() + "_" + getCodIndPadre() + "_" + getCodOriPadre() + "_" + getCodMateriaPadre();
	}
	
	public String getNomeCorsoIntegratoPadre() {
		return nomeCorsoIntegratoPadre;
	}

	public void setNomeCorsoIntegratoPadre(String nomeCorsoIntegratoPadre) {
		this.nomeCorsoIntegratoPadre = nomeCorsoIntegratoPadre;
	}

	public String getMessaggioSuIntegrato() {
		return messaggioSuIntegrato;
	}

	public void setMessaggioSuIntegrato(String messaggioSuIntegrato) {
		this.messaggioSuIntegrato = messaggioSuIntegrato;
	}

	public String getVotoCorsoIntegrato() {
		return votoCorsoIntegrato;
	}

	public void setVotoCorsoIntegrato(String votoCorsoIntegrato) {
		this.votoCorsoIntegrato = votoCorsoIntegrato;
	}
	
	public String getVotoCorsoIntegratoProposto() {
		return votoCorsoIntegratoProposto;
	}

	public void setVotoCorsoIntegratoProposto(String votoCorsoIntegratoProposto) {
		this.votoCorsoIntegratoProposto = votoCorsoIntegratoProposto;
	}
	
	public String getVotoIntegratoPadreLabel() {
		if (getVotoCorsoIntegrato() != null)
			return getVotoCorsoIntegrato();
		if (getVotoCorsoIntegratoProposto() != null)
			return getVotoCorsoIntegratoProposto();
		return null;
	}

	public boolean isIntegratoDaValutare(String statoRichiestaRiconoscimento) {
		boolean forTraineeship = getBloccoAttivita().getLearningAgreement().isForTraineeship();
		
		if (!getAppartieneAIntegrato())
			return false;
		if (isDaNonRiconoscere())
			return false;
		if (isRiconoscimentoNegato())
			return false;
		if (!forTraineeship) 
		{
			if (StatoRichiestaRiconoscimento.PRESENTATA.getValore().equals(statoRichiestaRiconoscimento) && getVotoProposto() == null)
				return false;
			if (StatoRichiestaRiconoscimento.VALIDATA.getValore().equals(statoRichiestaRiconoscimento) && getVotoRiconosciuto() == null)
				return false;
		}
		else if ((StatoRichiestaRiconoscimento.PRESENTATA.getValore().equals(statoRichiestaRiconoscimento) || StatoRichiestaRiconoscimento.VALIDATA.getValore().equals(statoRichiestaRiconoscimento)) && getVotoRiconosciuto() == null)
			return false;
		if (getCfu() == null)
			return false;
		if (!forTraineeship)
		{
			if (StatoRichiestaRiconoscimento.PRESENTATA.getValore().equals(statoRichiestaRiconoscimento) && !getCfu().equals(getCfuProposti()))
				return false;
			if (StatoRichiestaRiconoscimento.VALIDATA.getValore().equals(statoRichiestaRiconoscimento) && !getCfu().equals(getCfuRiconosciuti()))
				return false;
		}
		else if ((StatoRichiestaRiconoscimento.PRESENTATA.getValore().equals(statoRichiestaRiconoscimento) || StatoRichiestaRiconoscimento.VALIDATA.getValore().equals(statoRichiestaRiconoscimento)) && !getCfu().equals(getCfuRiconosciuti()))
			return false;
		return true;
	}

	public String getCodCorsoPadre() {
		return codCorsoPadre;
	}

	public void setCodCorsoPadre(String codCorsoPadre) {
		this.codCorsoPadre = codCorsoPadre;
	}

	public String getCodIndPadre() {
		return codIndPadre;
	}

	public void setCodIndPadre(String codIndPadre) {
		this.codIndPadre = codIndPadre;
	}

	public String getCodOriPadre() {
		return codOriPadre;
	}

	public void setCodOriPadre(String codOriPadre) {
		this.codOriPadre = codOriPadre;
	}

	public String getCodMateriaPadre() {
		return codMateriaPadre;
	}

	public void setCodMateriaPadre(String codMateriaPadre) {
		this.codMateriaPadre = codMateriaPadre;
	}
	
	public Integer getCfuDaRiconoscere(){
		return getCfuRiconosciuti() != null ? getCfu() : getCfuProposti();
	}

	public String getDescMateriaShort() {
		return descMateriaShort;
	}

	public void setDescMateriaShort(String descMateriaShort) {
		this.descMateriaShort = descMateriaShort;
	}
	
	public String getLabelShort() {
		if (isEsameStudente() || isEsameCorso() || isMateria())
            return getCodMateria() + " - " + (getDescMateriaShort() != null ? getDescMateriaShort().trim() : getDescMateriaShort()) + (getCfu() != null ? " - " + getCfu() + " CFU" : "");
		if (isSceltaLibera())
			return (getCfu() != null ? " " + getCfu() + " CFU " : "") + "di " + getSsd(); 
		return "???TODO???";
	}

	public String getVotoProposto() {
		return votoProposto;
	}

	public void setVotoProposto(String votoProposto) {
		this.votoProposto = votoProposto;
	}

	public String getVotoRiconosciuto() {
		return votoRiconosciuto;
	}

	public void setVotoRiconosciuto(String votoRiconosciuto) {
		this.votoRiconosciuto = votoRiconosciuto;
	}

	// Ritorna una copia identica dell'attivita' a meno degli ID. Utilizzato per storicizzazione
	public AttivitaUnibo clona() {
		AttivitaUnibo clone = new AttivitaUnibo();
		
		clone.setFlagRiconosciuta(this.getFlagRiconosciuta());
		clone.setAutoreRiconoscimento(this.getAutoreRiconoscimento());
		clone.setDataRiconoscimento(this.getDataRiconoscimento());
		clone.setNoteRiconoscimento(this.getNoteRiconoscimento());
		clone.setPincode(this.getPincode());
		clone.setCarriera(this.getCarriera());
		clone.setAnnoAccademico(this.getAnnoAccademico());
		clone.setCodCorso(this.getCodCorso());
		clone.setCodInd(this.getCodInd());
		clone.setCodOri(this.getCodOri());
		clone.setCodMateria(this.getCodMateria());
		clone.setAnnoCorsoPrevisto(this.getAnnoCorsoPrevisto());
		clone.setAnnoCorsoReale(this.getAnnoCorsoReale());
		clone.setIdPiano(this.getIdPiano());
		clone.setIdComponenteAF(this.getIdComponenteAF());
		clone.setAnnoCorso(this.getAnnoCorso());
		clone.setTipo(this.getTipo());
		clone.setDescrizione(this.getDescrizione());
		clone.setFlagInPiano(this.getFlagInPiano());
		clone.setFlagObbligatorio(this.getFlagObbligatorio());
		clone.setCfu(this.getCfu());
		clone.setSsd(this.getSsd());
		clone.setFlagDaRiconoscere(this.getFlagDaRiconoscere());
		clone.setFlagAggiuntaInRichiestaRiconoscimento(this.getFlagAggiuntaInRichiestaRiconoscimento());
		clone.setFlagRiconoscimentoProposto(this.getFlagRiconoscimentoProposto());
		clone.setCfuProposti(this.getCfuProposti());
		clone.setCfuRiconosciuti(this.getCfuRiconosciuti());
		clone.setVotoCorsoIntegrato(this.getVotoCorsoIntegrato());
		clone.setVotoCorsoIntegratoProposto(this.getVotoCorsoIntegratoProposto());
		clone.setCodCorsoPadre(this.getCodCorsoPadre());
		clone.setCodIndPadre(this.getCodIndPadre());
		clone.setCodOriPadre(this.getCodOriPadre());
		clone.setCodMateriaPadre(this.getCodMateriaPadre());
		clone.setVotoProposto(this.getVotoProposto());
		clone.setVotoRiconosciuto(this.getVotoRiconosciuto());
		clone.setOrder(this.getOrder());
		clone.setFlagCopiataDaVersioneLaPrecedente(this.getFlagCopiataDaVersioneLaPrecedente());
		clone.setAttivitaPrecedente(this.getAttivitaPrecedente());
		clone.setMotivazioneModifica(this.getMotivazioneModifica());
		clone.setFlagCancellata(this.getFlagCancellata());
		clone.setFlagSsdSuCreditiASceltaTirocinio(this.getFlagSsdSuCreditiASceltaTirocinio());
		clone.setFlagTirocinioCurriculare(this.getFlagTirocinioCurriculare());
		clone.setFlagNonUtileAlConseguimentoDelTitolo(this.getFlagNonUtileAlConseguimentoDelTitolo());
		
		return clone;
	}
	
	public String getDescrizioneLabel() {
		if (isSceltaLibera())
			return getSsd();
		return getDescrizione();
	}

	public BloccoAttivita getBloccoAttivita() {
		return bloccoAttivita;
	}

	public void setBloccoAttivita(BloccoAttivita bloccoAttivita) {
		this.bloccoAttivita = bloccoAttivita;
	}
	
	public AttivitaUnibo getAttivitaPrecedente() {
		return attivitaPrecedente;
	}

	public void setAttivitaPrecedente(AttivitaUnibo attivitaPrecedente) {
		this.attivitaPrecedente = attivitaPrecedente;
	}

	public Character getFlagCopiataDaVersioneLaPrecedente() {
		return flagCopiataDaVersioneLaPrecedente;
	}

	public void setFlagCopiataDaVersioneLaPrecedente(
			Character flagCopiataDaVersioneLaPrecedente) {
		this.flagCopiataDaVersioneLaPrecedente = flagCopiataDaVersioneLaPrecedente;
	}
	
	public boolean isCopiataDaVersioneLaPrecedente() {
		return Common.CH_S.equals(getFlagCopiataDaVersioneLaPrecedente());
	}

	public String getMotivazioneModifica() {
		return motivazioneModifica;
	}

	public void setMotivazioneModifica(String motivazioneModifica) {
		this.motivazioneModifica = motivazioneModifica;
	}

	public Character getFlagCancellata() {
		if (flagCancellata == null)
			return 'N';
		return flagCancellata;
	}

	public void setFlagCancellata(Character flagCancellata) {
		this.flagCancellata = flagCancellata;
	}
	
	public boolean isCancellata() {
		return Common.CH_S.equals(getFlagCancellata());
	}
	
	public String getAddedLabel() {
		if (!isCopiataDaVersioneLaPrecedente())
			return "X";
		return "";
	}
	
	public String getDeletedLabel() {
		if (isCancellata())
			return "X";
		return "";
	}

	public Character getFlagSsdSuCreditiASceltaTirocinio() {
		return flagSsdSuCreditiASceltaTirocinio;
	}

	public void setFlagSsdSuCreditiASceltaTirocinio(Character flagSsdSuCreditiASceltaTirocinio) {
		this.flagSsdSuCreditiASceltaTirocinio = flagSsdSuCreditiASceltaTirocinio;
	}
	
	public boolean isSsdSuCreditiASceltaTirocinio() {
		return Common.CH_S.equals(getFlagSsdSuCreditiASceltaTirocinio());
	}

	public boolean isAttiva() {
		return attiva;
	}

	public void setAttiva(boolean attiva) {
		this.attiva = attiva;
	}

	public Character getFlagTirocinioCurriculare() {
		return flagTirocinioCurriculare;
	}

	public void setFlagTirocinioCurriculare(Character flagTirocinioCurriculare) {
		this.flagTirocinioCurriculare = flagTirocinioCurriculare;
	}
	
	public boolean isTirocinioCurriculare() {
		return Common.CH_S.equals(getFlagTirocinioCurriculare());
	}

	public Character getFlagNonUtileAlConseguimentoDelTitolo() {
		return flagNonUtileAlConseguimentoDelTitolo;
	}

	public void setFlagNonUtileAlConseguimentoDelTitolo(Character flagNonUtileAlConseguimentoDelTitolo) {
		this.flagNonUtileAlConseguimentoDelTitolo = flagNonUtileAlConseguimentoDelTitolo;
	}
	
	public boolean isNonUtileAlConseguimentoDelTitolo() {
		return Common.CH_S.equals(getFlagNonUtileAlConseguimentoDelTitolo());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bloccoAttivita == null) ? 0 : bloccoAttivita.hashCode());
		result = prime * result + ((cfu == null) ? 0 : cfu.hashCode());
		result = prime * result + ((codMateria == null) ? 0 : codMateria.hashCode());
		result = prime * result + ((codMateriaPadre == null) ? 0 : codMateriaPadre.hashCode());
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
		result = prime * result + ((flagAggiuntaInRichiestaRiconoscimento == null) ? 0
				: flagAggiuntaInRichiestaRiconoscimento.hashCode());
		result = prime * result + ((flagCancellata == null) ? 0 : flagCancellata.hashCode());
		result = prime * result + ((flagNonUtileAlConseguimentoDelTitolo == null) ? 0
				: flagNonUtileAlConseguimentoDelTitolo.hashCode());
		result = prime * result + ((ssd == null) ? 0 : ssd.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		AttivitaUnibo other = (AttivitaUnibo) obj;
		if (bloccoAttivita == null) {
			if (other.bloccoAttivita != null)
				return false;
		} else if (!bloccoAttivita.equals(other.bloccoAttivita))
			return false;
		if (cfu == null) {
			if (other.cfu != null)
				return false;
		} else if (!cfu.equals(other.cfu))
			return false;
		if (codMateria == null) {
			if (other.codMateria != null)
				return false;
		} else if (!codMateria.equals(other.codMateria))
			return false;
		if (codMateriaPadre == null) {
			if (other.codMateriaPadre != null)
				return false;
		} else if (!codMateriaPadre.equals(other.codMateriaPadre))
			return false;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (flagAggiuntaInRichiestaRiconoscimento == null) {
			if (other.flagAggiuntaInRichiestaRiconoscimento != null)
				return false;
		} else if (!flagAggiuntaInRichiestaRiconoscimento.equals(other.flagAggiuntaInRichiestaRiconoscimento))
			return false;
		if (flagCancellata == null) {
			if (other.flagCancellata != null)
				return false;
		} else if (!flagCancellata.equals(other.flagCancellata))
			return false;
		if (flagNonUtileAlConseguimentoDelTitolo == null) {
			if (other.flagNonUtileAlConseguimentoDelTitolo != null)
				return false;
		} else if (!flagNonUtileAlConseguimentoDelTitolo.equals(other.flagNonUtileAlConseguimentoDelTitolo))
			return false;
		if (id != null && other.getId() != null)
			return id.equals(other.getId());
		if (ssd == null) {
			if (other.ssd != null)
				return false;
		} else if (!ssd.equals(other.ssd))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	/**
	 * Indica se l'attivita' formativa appartiene a un integrato basandosi sulla presenza del codice materia del padre
	 * @return true se il codice materia del padre non e' nullo
	 */
	public boolean isAFAppartieneAIntegrato() {
		return getCodMateriaPadre() != null;
	}
}
