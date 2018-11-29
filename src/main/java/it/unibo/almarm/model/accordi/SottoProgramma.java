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

import it.unibo.almarm.model.attori.StrutturaAmministrativa;
import it.unibo.almarm.model.luoghi.Nazione;
import it.unibo.almarm.model.outgoing.Bando;
import it.unibo.almarm.model.staff.SottoProgrammaStaffConfig;
import it.unibo.almarm.util.Common;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class SottoProgramma implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	public static final Long ID_EMA2 = 1304L;
	
	public static final Long ID_ERASMUS_STUDIO = 111L;
	public static final Long ID_ERASMUS_PLACEMENT = 112L;
	public static final Long ID_ERASMUS_ATTIVITA_DIDATTICA_STA = 113L;

	public static final Long ID_ERASMUS_PLUS_STUDIO = 511L;
	public static final Long ID_ERASMUS_PLUS_ATTIVITA_DIDATTICA_STA = 513L;
	public static final Long ID_ERASMUS_PLUS_PLACEMENT = 514L;
	public static final Long ID_ERASMUS_PLUS_EXTRAUE_STUDIO = 515L;
	public static final Long ID_ERASMUS_PLUS_EXTRAUE_STA = 516L;
	
	public static final Long ID_SWISS_EUROPEAN_MOBILITY_PROGRAMME = 232L;
	public static final Long ID_SWISS_EUROPEAN_MOBILITY_PROGRAMME_STA = 233L;
	
	public static final Long ID_VISITING_STUDENTS = 241L;
	public static final Long ID_VISITING_STAFF = 242L;
	public static final Long ID_VISITING_STAFF_TA = 243L;
	public static final Long ID_TESI_ESTERO = 244L;
	
	public static final Long ID_SEMESTRI_A_BUENOS_AIRES = 214L;

	public static final Long ID_FIELD_WORK = 215L;

	public static final Long ID_OVERSEAS = 211L;

	public static final Long ID_ALTRI_ACCORDI_DI_ATENEO = 212L;

	public static final Long ID_ACCORDI_DI_SETTORE = 221L;

	public static final Character FLAG_DOCUMENTO_RICHIESTO_PER_APPROVAZIONE_LA_RICHIESTO = Common.CH_S;

	private Long id;
	private String nome;
	private Long annoInizioValidita;
	private Long annoFineValidita;
	private String sigla;
	private String descrizione;
	private Programma programma;
	private String testoArrivo;
	private String testoArrivoIng;
	private String testoArrivo2;
	private String testoArrivo2Ing;
	private String testoPeriodo;
	private String testoPeriodoIng;
	private Bando bandoCorrente;
	private Character flagModificaFacoltaNomina;
	private String labelEcts;
	private Character flagReferenteScambioPerLA;
	private Character flagValidazioneLAObbligatoria;
	private Character flagCodiceCeeUfficiale;
	private Character flagUniversitaAzienda;
	private Character flagAbbrProlOutgModificabili;
	private Character flagEmilUfficiDiriAccettLa;
	private Character flagVicepresidenzeInDisponibilita;
	private Character flagProvenienzaDaAccordo;
	private Character flagConBorsa;
	private Character flagRichiedeSemestreSuAttEstereLa;
	private Character flagCourseCatalogInLa;
	private Character flagCompetenzeLinguisticheInLa;
	private Character sistemaPagamento;
	private Character flagDurataOutgoingInGiorni;
	private Character flagTracciamentoModificheInLa;
	private Character flagRilevaLivLinguistico;  // gestione OLS
	private Character flagGestionePeridoResiduo; // periodo residuo nuove candidature erasmus plus
	private Character flagCreaCandidaturaLingue;
	private Character flagUploadContrattoFirmato;
	private Character tipoGestioneContratto;
	private String flagDichiarazioneStudenteOutgoing;
	private Character fnzDocOriginaliConsegnati; // A=attiva, D=disattiva
	private Integer durataMassimaScambio;
	private Integer durataMinimaScambio;
	private Character flagPassaporto;
	private Character flagDocPassaporto;
	private Character flagDocLAIncoming;
	private Character flagModificaPrimaCittadinanzaInRegistrazioneIncoming;
	
	private Long idProgramma;
	private Integer ordinamento;
	
	private SortedSet<SottoProgrammaNazione> sottoProgrammaNazioni = new TreeSet<SottoProgrammaNazione>();

	private StrutturaAmministrativa strutturaAmministrativa;
	private Character flagDocumentoRichiestoPerApprovazioneLA;
	private SottoProgrammaStaffConfig sottoProgrammaStaffConfig;

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
	public Long getAnnoInizioValidita() {
		return annoInizioValidita;
	}
	public void setAnnoInizioValidita(Long annoInizioValidita) {
		this.annoInizioValidita = annoInizioValidita;
	}
	public Long getAnnoFineValidita() {
		return annoFineValidita;
	}
	public void setAnnoFineValidita(Long annoFineValidita) {
		this.annoFineValidita = annoFineValidita;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	// TODO : togliere
	public Long getIdProgramma() {
		return idProgramma;
	}
	public void setIdProgramma(Long idProgramma) {
		this.idProgramma = idProgramma;
	}
	public Programma getProgramma() {
		return programma;
	}
	public void setProgramma(Programma programma) {
		this.programma = programma;
	}
	public String getTestoArrivo() {
		return testoArrivo;
	}
	public void setTestoArrivo(String testoArrivo) {
		this.testoArrivo = testoArrivo;
	}
	public String getTestoArrivoIng() {
		return testoArrivoIng;
	}
	public void setTestoArrivoIng(String testoArrivoIng) {
		this.testoArrivoIng = testoArrivoIng;
	}	
	public String getTestoArrivo2() {
		return testoArrivo2;
	}
	public void setTestoArrivo2(String testoArrivo2) {
		this.testoArrivo2 = testoArrivo2;
	}
	public String getTestoArrivo2Ing() {
		return testoArrivo2Ing;
	}
	public void setTestoArrivo2Ing(String testoArrivo2Ing) {
		this.testoArrivo2Ing = testoArrivo2Ing;
	}
	public String getTestoPeriodo() {
		return testoPeriodo;
	}
	public void setTestoPeriodo(String testoPeriodo) {
		this.testoPeriodo = testoPeriodo;
	}
	public String getTestoPeriodoIng() {
		return testoPeriodoIng;
	}
	public void setTestoPeriodoIng(String testoPeriodoIng) {
		this.testoPeriodoIng = testoPeriodoIng;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime
				* result
				+ ((annoInizioValidita == null) ? 0 : annoInizioValidita.hashCode());
		result = prime
				* result
				+ ((annoFineValidita == null) ? 0 : annoFineValidita.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof SottoProgramma))
			return false;
		SottoProgramma other = (SottoProgramma) obj;
		if (nome == null) {
			if (other.getNome() != null)
				return false;
		} else if (!nome.equals(other.getNome()))
			return false;
		if (annoInizioValidita == null) {
			if (other.getAnnoInizioValidita() != null)
				return false;
		} else if (!annoInizioValidita.equals(other.getAnnoInizioValidita()))
			return false;
		if (annoFineValidita == null) {
			if (other.getAnnoFineValidita() != null)
				return false;
		} else if (!annoFineValidita.equals(other.getAnnoFineValidita()))
			return false;
		return true;
	}
	
	public Bando getBandoCorrente() {
		return bandoCorrente;
	}
	public void setBandoCorrente(Bando bandoCorrente) {
		this.bandoCorrente = bandoCorrente;
	}
	
	@Override
	public String toString() {
		return id != null ? id.toString() : "";
	}
	
	public Integer getOrdinamento() {
		return ordinamento;
	}
	
	public void setOrdinamento(Integer ordinamento) {
		this.ordinamento = ordinamento;
	}
	
	public Character getFlagModificaFacoltaNomina() {
		return flagModificaFacoltaNomina;
	}
	
	public void setFlagModificaFacoltaNomina(Character flagModificaFacoltaNomina) {
		this.flagModificaFacoltaNomina = flagModificaFacoltaNomina;
	}
	
	public boolean isModificaFacoltaNomina() {
		 return Common.CH_S.equals(flagModificaFacoltaNomina);
	}

	public Character getFlagDocumentoRichiestoPerApprovazioneLA() {
		return flagDocumentoRichiestoPerApprovazioneLA;
	}

	public void setFlagDocumentoRichiestoPerApprovazioneLA(Character flagDocumentoRichiestoPerApprovazioneLA) {
		this.flagDocumentoRichiestoPerApprovazioneLA = flagDocumentoRichiestoPerApprovazioneLA;
	}

	public boolean isDocumentoRichiestoPerApprovazioneLA() {
		boolean richiesto = false;
		if (getFlagDocumentoRichiestoPerApprovazioneLA()!=null) {
			if (FLAG_DOCUMENTO_RICHIESTO_PER_APPROVAZIONE_LA_RICHIESTO.equals(getFlagDocumentoRichiestoPerApprovazioneLA()))
				richiesto = true;
		}
		return richiesto;
	}

	public Character getFlagModificaPrimaCittadinanzaInRegistrazioneIncoming() {
		Character flag = Common.CH_S;
		if (isOverseas() || isAltriAccordiDiAteneo() || isAccordiDiSettore()) {
			flag = Common.CH_N;
		}
		return flag;
	}

	public void setFlagModificaPrimaCittadinanzaInRegistrazioneIncoming(Character flagModificaNazionalitaInRegistrazioneIncoming) {
		this.flagModificaPrimaCittadinanzaInRegistrazioneIncoming = flagModificaNazionalitaInRegistrazioneIncoming;
	}

	public boolean isModificaPrimaCittadinanzaInRegistrazioneIncomingAbilitata() {
		boolean abilitata = true;
		if (Common.CH_N.equals(getFlagModificaPrimaCittadinanzaInRegistrazioneIncoming())) {
			abilitata = false;
		}
		return abilitata;
	}

	public static class  SottoprogrammaComparator  extends SottoprogrammaComparatorNome
	{
		@Override
		public int compare(SottoProgramma o1,	SottoProgramma o2) {
			if ((o1 == null && o2 == null) || (o1.getOrdinamento() == null && o2.getOrdinamento() == null))
				return super.compare(o1,o2);
			if (o1 == null || o1.getOrdinamento() == null)
				return 1;
			if (o2 == null || o2.getOrdinamento() == null)
				return -1;
			
			int comparison=o1.getOrdinamento().compareTo(o2.getOrdinamento());
			return (comparison==0) ? super.compare(o1, o2) : comparison;
		}
	}

	public static class  SottoprogrammaComparatorNome implements Comparator<SottoProgramma> {
		public int compare(SottoProgramma o1,	SottoProgramma o2) {
			if ((o1 == null && o2 == null) || (o1.getNome() == null && o2.getNome() == null))
				return 0;
			if (o1 == null || o1.getNome() == null)
				return 1;
			if (o2 == null || o2.getNome() == null)
				return -1;
			return o1.getNome().compareTo(o2.getNome());
		}
	}

	public String getLabelEcts() {
		return labelEcts;
	}
	public void setLabelEcts(String labelEcts) {
		this.labelEcts = labelEcts;
	}
	
	public boolean isUsaReferenteScambioPerLA() {
		return Common.CH_S.equals(getFlagReferenteScambioPerLA());
	}
	public boolean isUsaReferenteVicepresidenzaPerLA() {
		return Common.CH_V.equals(getFlagReferenteScambioPerLA());
	}
	public boolean isUsaReferenteSpecificoDellaMobilitaPerLA() {
		return Common.CH_M.equals(getFlagReferenteScambioPerLA());
	}
	public Character getFlagReferenteScambioPerLA() {
		if (flagReferenteScambioPerLA == null)
			return 'S';
		return flagReferenteScambioPerLA;
	}
	public void setFlagReferenteScambioPerLA(Character flagReferenteScambioPerLA) {
		this.flagReferenteScambioPerLA = flagReferenteScambioPerLA;
	}
	public boolean isValidazioneEsteraLaObbligatoria() {
		return Common.CH_S.equals(getFlagValidazioneLAObbligatoria());
	}
	public Character getFlagValidazioneLAObbligatoria() {
		if (flagValidazioneLAObbligatoria == null)
			return 'S';
		return flagValidazioneLAObbligatoria;
	}
	public void setFlagValidazioneLAObbligatoria(
			Character flagValidazioneLAObbligatoria) {
		this.flagValidazioneLAObbligatoria = flagValidazioneLAObbligatoria;
	}
	public boolean isCodiceCeeUfficiale() {
		return Common.CH_S.equals(getFlagCodiceCeeUfficiale());
	}
	public Character getFlagCodiceCeeUfficiale() {
		if (flagCodiceCeeUfficiale == null)
			return 'S';
		return flagCodiceCeeUfficiale;
	}
	public void setFlagCodiceCeeUfficiale(Character flagCodiceCeeUfficiale) {
		this.flagCodiceCeeUfficiale = flagCodiceCeeUfficiale;
	}
	
	public boolean isOverseas() {
		return getId().equals(ID_OVERSEAS);
	}

	public boolean isAltriAccordiDiAteneo() {
		return getId()!=null ? ID_ALTRI_ACCORDI_DI_ATENEO.equals(getId()) : false;
	}

	public boolean isAccordiDiSettore() {
		return getId()!=null ? ID_ACCORDI_DI_SETTORE.equals(getId()) : false;
	}
	
	public boolean isErasmus() {
		return isErasmusStudio() || isErasmusPlusStudio() || isErasmusPlusExtraUEStudio();
	}
	
	// Viene usato per stabilire i comportamento dell offerta rimane nelle regole erasmus 
	public boolean isOffertaErasmus() {
		return isErasmusStudio() || isErasmusPlusStudio() || isSwissEuropeanMobilityProgramme() || isErasmusPlusExtraUEStudio();
	}

	public boolean isEma2() {
		return getId().equals(ID_EMA2);
	}
	
	public boolean isErasmusPlacement() {
		return getId().equals(ID_ERASMUS_PLACEMENT) || getId().equals(ID_ERASMUS_PLUS_PLACEMENT);
	}

	public boolean isFieldWork() {
		boolean isFieldWork = false;
		if (getId()!=null) {
			isFieldWork = getId().equals(ID_FIELD_WORK);
		}
		return isFieldWork;
	}

	public boolean isErasmusAttivitaDidatticaSTA() {
		return getId().equals(ID_ERASMUS_ATTIVITA_DIDATTICA_STA);
	}
	public Character getFlagUniversitaAzienda() {
		if (flagUniversitaAzienda == null)
			return 'U';
		return flagUniversitaAzienda;
	}
	public void setFlagUniversitaAzienda(Character flagUniversitaAzienda) {
		this.flagUniversitaAzienda = flagUniversitaAzienda;
	}
	public boolean isScambioConUniversita() {
		return Common.CH_U.equals(getFlagUniversitaAzienda());
	}
	public boolean isScambioConAzienda() {
		return Common.CH_A.equals(getFlagUniversitaAzienda());
	}
	public SortedSet<SottoProgrammaNazione> getSottoProgrammaNazioni() {
		return sottoProgrammaNazioni;
	}
	public void setSottoProgrammaNazioni(
			SortedSet<SottoProgrammaNazione> sottoProgrammaNazioni) {
		this.sottoProgrammaNazioni = sottoProgrammaNazioni;
	}
	public List<Nazione> getNazioni() {
		List<Nazione> ret = new ArrayList<Nazione>();
		for (SottoProgrammaNazione spn: getSottoProgrammaNazioni())
			ret.add(spn.getNazione());
		return ret;
	}
	
	public List<Nazione> getNazioniAttive() {
		List<Nazione> ret = new ArrayList<Nazione>();
		for (SottoProgrammaNazione spn: getSottoProgrammaNazioni())
			if (spn.isAttiva())
				ret.add(spn.getNazione());
		return ret;
	}
	public Character getFlagAbbrProlOutgModificabili() {
		if (flagAbbrProlOutgModificabili == null)
			return 'N';
		return flagAbbrProlOutgModificabili;
	}
	public void setFlagAbbrProlOutgModificabili(
			Character flagAbbrProlOutgModificabili) {
		this.flagAbbrProlOutgModificabili = flagAbbrProlOutgModificabili;
	}
	public boolean isAbbrProlOutgModificabili() {
		return Common.CH_S.equals(getFlagAbbrProlOutgModificabili());
	}
	public Character getFlagEmilUfficiDiriAccettLa() {
		if (flagEmilUfficiDiriAccettLa == null)
			return 'N';
		return flagEmilUfficiDiriAccettLa;
	}
	public void setFlagEmilUfficiDiriAccettLa(Character flagEmilUfficiDiriAccettLa) {
		this.flagEmilUfficiDiriAccettLa = flagEmilUfficiDiriAccettLa;
	}
	public boolean isAttivaEmilUfficiDiriAccettLa() {
		return Common.CH_S.equals(getFlagEmilUfficiDiriAccettLa());
	}
	public Character getFlagVicepresidenzeInDisponibilita() {
		return flagVicepresidenzeInDisponibilita;
	}
	public void setFlagVicepresidenzeInDisponibilita(
			Character flagVicepresidenzeInDisponibilita) {
		this.flagVicepresidenzeInDisponibilita = flagVicepresidenzeInDisponibilita;
	}

	public boolean isErasmusStudio() {
		return getId().equals(ID_ERASMUS_STUDIO);
	}
	public boolean isErasmusPlusStudio() {
		return getId().equals(ID_ERASMUS_PLUS_STUDIO);
	}
	public boolean isErasmusPlusAttivitaDidatticaSTA() {
		return getId().equals(ID_ERASMUS_PLUS_ATTIVITA_DIDATTICA_STA);
	}
	public boolean isGruppoErasmus_studioOattDidatticaSTA(){
		 return isGruppoErasmus_studio() || isGruppoErasmus_attivitaDidatticaSTA();
	}
	public boolean isGruppoErasmus_studio() {
		 return isErasmusStudio() || isErasmusPlusStudio() || isErasmusPlusExtraUEStudio();
	}
	public boolean isGruppoErasmus_attivitaDidatticaSTA(){
		 return isErasmusAttivitaDidatticaSTA() || isErasmusPlusAttivitaDidatticaSTA();
	}
	public boolean isErasmusPlusPlacement() {
		return getId().equals(ID_ERASMUS_PLUS_PLACEMENT);
	}
	public boolean isErasmusPlusExtraUEStudio() {
		return getId().equals(ID_ERASMUS_PLUS_EXTRAUE_STUDIO);
	}
	public boolean isErasmusPlusExtraUESTA() {
		return getId().equals(ID_ERASMUS_PLUS_EXTRAUE_STA);
	}

	public boolean isSwissEuropeanMobilityProgramme() {
		return getId().equals(ID_SWISS_EUROPEAN_MOBILITY_PROGRAMME);
	}
	
	public boolean isSwissEuropeanMobilityProgrammeSTA() {
		return getId().equals(ID_SWISS_EUROPEAN_MOBILITY_PROGRAMME_STA);
	}
	
	public Character getFlagProvenienzaDaAccordo() {
		return flagProvenienzaDaAccordo;
	}
	public void setFlagProvenienzaDaAccordo(Character flagProvenienzaDaAccordo) {
		this.flagProvenienzaDaAccordo = flagProvenienzaDaAccordo;
	}
	public boolean isProvenienzaDaAccordo() {
		return Common.CH_S.equals(getFlagProvenienzaDaAccordo());
	}
	
	public Character getFlagConBorsa() {
		return flagConBorsa;
	}
	
	public void setFlagConBorsa(Character flagConBorsa) {
		this.flagConBorsa = flagConBorsa;
	}

	public boolean isConBorsa() {
		return Common.CH_S.equals(getFlagConBorsa());
	}
	
	public boolean isVisitingStudents() {
		return (getId() != null && getId().equals(ID_VISITING_STUDENTS));
	}
	
	public boolean isVisitingStaff() {
		return (getId() != null && getId().equals(ID_VISITING_STAFF));
	}
	
	public boolean isVisiting() {
		return isVisitingStudents() || isVisitingStaff();
	}
	
	public Character getFlagRichiedeSemestreSuAttEstereLa() {
		return flagRichiedeSemestreSuAttEstereLa;
	}
	
	public void setFlagRichiedeSemestreSuAttEstereLa(
			Character flagRichiedeSemestreSuAttEstereLa) {
		this.flagRichiedeSemestreSuAttEstereLa = flagRichiedeSemestreSuAttEstereLa;
	}
	
	public boolean isRichiedeSemestreSuAttEstereLa() {
		return Common.CH_S.equals(getFlagRichiedeSemestreSuAttEstereLa());
	}
	
	public Character getFlagCourseCatalogInLa() {
		return flagCourseCatalogInLa;
	}
	
	public void setFlagCourseCatalogInLa(Character flagCourseCatalogInLa) {
		this.flagCourseCatalogInLa = flagCourseCatalogInLa;
	}
	
	public boolean isCourseCatalogInLaRichiesto() {
		return Common.CH_S.equals(getFlagCourseCatalogInLa());
	}
	
	public Character getFlagCompetenzeLinguisticheInLa() {
		return flagCompetenzeLinguisticheInLa;
	}
	
	public void setFlagCompetenzeLinguisticheInLa(
			Character flagCompetenzeLinguisticheInLa) {
		this.flagCompetenzeLinguisticheInLa = flagCompetenzeLinguisticheInLa;
	}
	
	public boolean isCompetenzeLinguisticheInLaRichieste() {
		return Common.CH_S.equals(getFlagCompetenzeLinguisticheInLa());
	}
	
	public Character getSistemaPagamento() {
		return sistemaPagamento;
	}
	
	public void setSistemaPagamento(Character sistemaPagamento) {
		this.sistemaPagamento = sistemaPagamento;
	}
//	
//	public boolean isPagamentoCia() {
//		return Common.CH_I.equals(getSistemaPagamento());
//	}
//	
//	public boolean isPagamentoCsa() {
//		return Common.CH_S.equals(getSistemaPagamento());
//	}
//	
//	public boolean isPagamentoUgov() {
//		return Common.CH_U.equals(getSistemaPagamento());
//	}
//	
	public Character getFlagDurataOutgoingInGiorni() {
		return flagDurataOutgoingInGiorni;
	}
	
	public void setFlagDurataOutgoingInGiorni(Character flagDurataOutgoingInGiorni) {
		this.flagDurataOutgoingInGiorni = flagDurataOutgoingInGiorni;
	}
	
	public boolean isDurataOutgoingInGiorniAttiva() {
		return Common.CH_S.equals(getFlagDurataOutgoingInGiorni());
	}
	
	public Character getFlagTracciamentoModificheInLa() {
		return flagTracciamentoModificheInLa;
	}
	
	public void setFlagTracciamentoModificheInLa(
			Character flagTracciamentoModificheInLa) {
		this.flagTracciamentoModificheInLa = flagTracciamentoModificheInLa;
	}
	
	public boolean isTracciamentoModificheInLaAttivo() {
		return Common.CH_S.equals(getFlagTracciamentoModificheInLa());
	}
	
	public Character getFlagRilevaLivLinguistico() {
		return flagRilevaLivLinguistico;
	}
	public void setFlagRilevaLivLinguistico(Character flagRilevaLivLinguistico) {
		this.flagRilevaLivLinguistico = flagRilevaLivLinguistico;
	}
	public boolean isRilevaLivLinguistico() {
		return Common.CH_S.equals(flagRilevaLivLinguistico);
	}
	public Character getFlagGestionePeridoResiduo() {
		return flagGestionePeridoResiduo;
	}
	public void setFlagGestionePeridoResiduo(Character flagGestionePeridoResiduo) {
		this.flagGestionePeridoResiduo = flagGestionePeridoResiduo;
	}
	public boolean isGestionePeridoResiduo() {
		return Common.CH_S.equals(flagGestionePeridoResiduo);
	}
	public boolean isSemestriABuenosAires() {
		return getId().equals(ID_SEMESTRI_A_BUENOS_AIRES);
	}
	/* Punto unificato che determina se per il sottoprogramma le aperture della offerta di mobilita' 
	 * devono essere ristrette nel limite delle vicepresidenze che hanno approvato l'accordo 
	 * o se possono essere di qualsiasi vicepresidenza. 
	 * *TODO* *PV* Se per il Placement si vuole evitare la restrizione alle vicepresidenze dell' accordo
	 * 				bisogna modificare questo metodo
	 */
	public boolean isAperturaOffertaLiberaATutteLeVicepresidenze(){
		return  !(isErasmusPlacement() || isErasmusPlusStudio() || isSwissEuropeanMobilityProgramme() || isErasmusStudio());
	}
	
	public boolean isAnyErasmusPlusExtraUE() {
		return getId().equals(ID_ERASMUS_PLUS_EXTRAUE_STUDIO) || getId().equals(ID_ERASMUS_PLUS_EXTRAUE_STA);
	}

	public boolean isPrevistaStipulaConContrattoPartner() {
		return isErasmusPlusStudio() || isErasmusPlusAttivitaDidatticaSTA();
	}
	
	public boolean isPrevistaDichiarazioneScambioNonFirmata() {
		return "NF".equalsIgnoreCase(getFlagDichiarazioneStudenteOutgoing());
	}
	
	public Character getFlagCreaCandidaturaLingue() {
		return flagCreaCandidaturaLingue;
	}
	public void setFlagCreaCandidaturaLingue(Character flagCreaCandidaturaLingue) {
		this.flagCreaCandidaturaLingue = flagCreaCandidaturaLingue;
	}
	public boolean isCreaCandidaturaLingue(){
		return Common.CH_S.equals(flagCreaCandidaturaLingue);
	}
	public Character getFlagUploadContrattoFirmato() {
		return flagUploadContrattoFirmato;
	}
	public void setFlagUploadContrattoFirmato(Character flagUploadContrattoFirmato) {
		this.flagUploadContrattoFirmato = flagUploadContrattoFirmato;
	}
	public boolean isNoteInterneOffertaVisibili(){
		return !isOffertaErasmus();
	}
	public Character getTipoGestioneContratto() {
		return tipoGestioneContratto;
	}
	public void setTipoGestioneContratto(Character tipoGestioneContratto) {
		this.tipoGestioneContratto = tipoGestioneContratto;
	}
	public String getFlagDichiarazioneStudenteOutgoing() {
		return flagDichiarazioneStudenteOutgoing;
	}
	public void setFlagDichiarazioneStudenteOutgoing(String flagDichiarazioneStudenteOutgoing) {
		this.flagDichiarazioneStudenteOutgoing = flagDichiarazioneStudenteOutgoing;
	}
	public Character getFnzDocOriginaliConsegnati() {
		return fnzDocOriginaliConsegnati;
	}
	public void setFnzDocOriginaliConsegnati(Character fnzDocOriginaliConsegnati) {
		this.fnzDocOriginaliConsegnati = fnzDocOriginaliConsegnati;
	}
	/*
	 *A=funzione attiva,  N(o diversa da A)=non attiva
	 */
	public boolean isFnzDocOriginaliConsegnatiAttivo() {
		return Common.CH_A.equals(fnzDocOriginaliConsegnati);
	}
	
	public Integer getDurataMassimaScambio() {
		return durataMassimaScambio;
	}
	public void setDurataMassimaScambio(Integer durataMassimaScambio) {
		this.durataMassimaScambio = durataMassimaScambio;
	}
	public Integer getDurataMinimaScambio() {
		return durataMinimaScambio;
	}
	public void setDurataMinimaScambio(Integer durataMinimaScambio) {
		this.durataMinimaScambio = durataMinimaScambio;
	}
	public Character getFlagPassaporto() {
		return flagPassaporto;
	}
	public void setFlagPassaporto(Character flagPassaporto) {
		this.flagPassaporto = flagPassaporto;
	}
	public Character getFlagDocPassaporto() {
		return flagDocPassaporto;
	}
	public void setFlagDocPassaporto(Character flagDocPassaporto) {
		this.flagDocPassaporto = flagDocPassaporto;
	}
	public boolean isPassaportoGestito() {
		return !Common.CH_N.equals(flagPassaporto == null ? Common.CH_N : flagPassaporto);
	}
	public boolean isDocPassaportoGestito() {
		return !Common.CH_N.equals(flagDocPassaporto == null ? Common.CH_N : flagDocPassaporto);
	}
	public Character getFlagDocLAIncoming() {
		return flagDocLAIncoming;
	}
	public void setFlagDocLAIncoming(Character flagDocLAIncoming) {
		this.flagDocLAIncoming = flagDocLAIncoming;
	}
	public boolean isDocLAIncomingGestito() {
		return Common.CH_S.equals(flagDocLAIncoming);
	}
	
	public boolean isTesiAllEstero() {
		return getId().equals(ID_TESI_ESTERO);
	}
	
	public StrutturaAmministrativa getStrutturaAmministrativa() {
		return strutturaAmministrativa;
	}
	
	public void setStrutturaAmministrativa(StrutturaAmministrativa strutturaAmministrativa) {
		this.strutturaAmministrativa = strutturaAmministrativa;
	}
	
	public boolean isPrevistaGestioneVicepresidenzeSuAccordo() {
		return isErasmusPlusStudio() 
				|| isErasmusPlusAttivitaDidatticaSTA() 
				|| isErasmusPlusPlacement() 
				|| isSwissEuropeanMobilityProgramme() 
				|| isSwissEuropeanMobilityProgrammeSTA();
	}

	public SottoProgrammaStaffConfig getSottoProgrammaStaffConfig() {
		return sottoProgrammaStaffConfig;
	}

	public void setSottoProgrammaStaffConfig(SottoProgrammaStaffConfig sottoProgrammaStaffConfig) {
		this.sottoProgrammaStaffConfig = sottoProgrammaStaffConfig;
	}
}
