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

import it.unibo.almarm.model.accordi.Programma;
import it.unibo.almarm.model.accordi.SottoProgramma;
import it.unibo.almarm.model.attori.Ateneo;
import it.unibo.almarm.model.attori.Persona;
import it.unibo.almarm.model.attori.studenti.Corso;
import it.unibo.almarm.model.flussiscambio.PeriodoMobilita;
import it.unibo.almarm.model.flussiscambio.SottoTarget;
import it.unibo.almarm.model.flussiscambio.UnitaMisuraDurata;
import it.unibo.almarm.util.Common;
import it.unibo.almarm.webapp.mvc.OpzioneOffertaCommand;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Candidatura implements java.io.Serializable {

	public static enum FaseCandidatura
	{
		PRESENTAZIONE(1),
		AMMISSIONE(2),
		VERIFICA(3);
		
		private Integer valore;
		
		private FaseCandidatura(Integer v) { this.valore = v; }

		public Integer getValore() { return valore; }
	}

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Persona persona;
	private Integer carriera;
	private OffertaInDisponibilita offertaInDisponibilita;
	
	private Character flagAmmissibile;
	private BigDecimal punteggioOggettivo;
	private BigDecimal punteggioSoggettivo;
	private BigDecimal punteggioComplessivo;
	private BigDecimal punteggioOggettivoOriginale;
	private Character flagIdoneo;
	private Integer posizioneInGraduatoria1;
	private Integer posizioneInGraduatoria2;
	private Long pincode;
	private Date dataInserimento;
	private Date dataPresentazione;
	private String notePresentazione;
	private Character flagEsitoAccettazione;
	private Date dataAccettazione;
	private String stato;
	private Character flagStatoInGraduatoria;
	private Date dataAmmissione;
	private Persona autoreAmmissione;
	private Character flagCondizionata;
	private Integer annoDiCorso;
	private SottoTarget sottoTarget;
	private Integer priorita;
	private Integer numeroCarrieraMerito;
	private Integer periodo;
	private Character flagEmailInviata;
	private Date dataInvioEmail;
	private String noteAmmissione;
	private String noteInterne;
	private Character flagPerTesi;
	
	private Set<RequisitoCandidatura> requisitiCandidatura = new HashSet<RequisitoCandidatura>();
	private Set<CandidaturaOpzioneOfferta> opzioni = new HashSet<CandidaturaOpzioneOfferta>();

	private Character flagSubentro;
	private Date dataSubentro;
	private Persona autoreSubentro;
	private Integer posizioneInGraduatoriaOrig;
	private Character flagStatoInGraduatoriaOrig;
	private Integer posizioneInGraduatoria2Orig;
	private Character flagStatoInGraduatoria2Orig;
	private Character flagStatoInGraduatoria1Finale;
	private Integer posizioneInGraduatoria1Finale;
	
	private BigDecimal punteggio1;
	private BigDecimal punteggio2;
	private BigDecimal punteggio3;
	private BigDecimal punteggio4;
	
	/*private CandidaturaInfo candidaturaInfo;*/
	private Set<CandidaturaInfo> candidatureInfo = new HashSet<CandidaturaInfo>();
	
	private OpzioneOfferta opzioneOffertaVincitore;
	
	private Ateneo ateneoDestinazione;

	// TODO vedere se i seguenti servono tutti, nb: pincode e carriera ci sono gia'
	private String codCorso;
	private String codInd;
	private String codOri;
	private Corso corso;
	
	private CandidaturaDatiPlacement candidaturaDatiPlacement;
	private Long durataPrevista;
	private UnitaMisuraDurata unitaMisuraDurataPrevista;
	private BandoGruppo bandoGruppo;
	private String noteModificaPunteggioOggettivo;
	private Persona autoreAccettazione;
	private String noteValutazione;
	private CandidaturaDottorandiVisiting candidaturaDottorandiVisiting;
	private CandidaturaLingue candidaturaLingue;
	private Persona referenteInternoSpecifico;
	
	// Salva gli avvisi dati allo studente nell'accettazione
	private Integer giorniFruitiAccettati;
	private Character flagAvvisoPeriodoInCorsoInAccettazione;
	private Character flagAvvisoPeriodoFuturoInAccettazione;
	private Character flagLegataTitoloDoppioMultCong;

	// flagComeLaureato : S=si candida in qualita di neolaureato, N o null si candida in qualita di studente
	private Character flagComeLaureato;
	
	// Riassegnazione e CANDIDATURA di provenienza in caso di riassegnazione.
	private Character flagRiassegnazione;
	private Long idCandProvenienza;
	
	// campi calcolati
	private Boolean accettazioneAperta;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Integer getCarriera() {
		return carriera;
	}

	public void setCarriera(Integer carriera) {
		this.carriera = carriera;
	}

	public OffertaInDisponibilita getOffertaInDisponibilita() {
		return offertaInDisponibilita;
	}

	public void setOffertaInDisponibilita(
			OffertaInDisponibilita offertaInDisponibilita) {
		this.offertaInDisponibilita = offertaInDisponibilita;
	}

	public Character getFlagAmmissibile() {
		return flagAmmissibile;
	}

	public void setFlagAmmissibile(Character flagAmmissibile) {
		this.flagAmmissibile = flagAmmissibile;
	}

	public BigDecimal getPunteggioOggettivo() {
		return punteggioOggettivo;
	}

	public void setPunteggioOggettivo(BigDecimal punteggioOggettivo) {
		this.punteggioOggettivo = punteggioOggettivo;
		updatePunteggioComplessivo();
	}

	public BigDecimal getPunteggioSoggettivo() {
		return punteggioSoggettivo;
	}

	public void setPunteggioSoggettivo(BigDecimal punteggioSoggettivo) {
		this.punteggioSoggettivo = punteggioSoggettivo;
		updatePunteggioComplessivo();
	}

	public void updatePunteggioComplessivo() {
		this.punteggioComplessivo = (punteggioOggettivo != null ? punteggioOggettivo : BigDecimal.ZERO)
		.add(punteggioSoggettivo != null ? punteggioSoggettivo : BigDecimal.ZERO)
		.add(punteggio1 != null ? punteggio1 : BigDecimal.ZERO)
		.add(punteggio2 != null ? punteggio2 : BigDecimal.ZERO)
		.add(punteggio3 != null ? punteggio3 : BigDecimal.ZERO)
		.add(punteggio4 != null ? punteggio4 : BigDecimal.ZERO);
	}
	
	public BigDecimal getPunteggioComplessivo() {
		return punteggioComplessivo;
	}

	public void setPunteggioComplessivo(BigDecimal punteggioComplessivo) {
		this.punteggioComplessivo = punteggioComplessivo;
	}

	public Character getFlagIdoneo() {
		return flagIdoneo;
	}

	public void setFlagIdoneo(Character flagIdoneo) {
		this.flagIdoneo = flagIdoneo;
	}

	public Integer getPosizioneInGraduatoria1() {
		return posizioneInGraduatoria1;
	}

	public void setPosizioneInGraduatoria1(Integer posizioneInGraduatoria1) {
		this.posizioneInGraduatoria1 = posizioneInGraduatoria1;
	}
	
	public Integer getPosizioneInGraduatoria2() {
		return posizioneInGraduatoria2;
	}

	public void setPosizioneInGraduatoria2(Integer posizioneInGraduatoria2) {
		this.posizioneInGraduatoria2 = posizioneInGraduatoria2;
	}

	public Date getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public Date getDataPresentazione() {
		return dataPresentazione;
	}

	public void setDataPresentazione(Date dataPresentazione) {
		this.dataPresentazione = dataPresentazione;
	}

	public String getNotePresentazione() {
		return notePresentazione;
	}

	public void setNotePresentazione(String notePresentazione) {
		this.notePresentazione = notePresentazione;
	}

	public Character getFlagEsitoAccettazione() {
		return flagEsitoAccettazione;
	}

	public void setFlagEsitoAccettazione(Character flagEsitoAccettazione) {
		this.flagEsitoAccettazione = flagEsitoAccettazione;
	}

	public Date getDataAccettazione() {
		return dataAccettazione;
	}

	public void setDataAccettazione(Date dataAccettazione) {
		this.dataAccettazione = dataAccettazione;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public Date getDataAmmissione() {
		return dataAmmissione;
	}

	public void setDataAmmissione(Date dataAmmissione) {
		this.dataAmmissione = dataAmmissione;
	}

	public Persona getAutoreAmmissione() {
		return autoreAmmissione;
	}

	public void setAutoreAmmissione(Persona autoreAmmissione) {
		this.autoreAmmissione = autoreAmmissione;
	}

	public Character getFlagCondizionata() {
		if (flagCondizionata == null)
			return 'N';
		return flagCondizionata;
	}

	public void setFlagCondizionata(Character flagCondizionata) {
		this.flagCondizionata = flagCondizionata;
	}
	
	public boolean isCondizionata() {
		return Common.CH_S.equals(flagCondizionata);
	}

	public Integer getAnnoDiCorso() {
		return annoDiCorso;
	}

	public void setAnnoDiCorso(Integer annoDiCorso) {
		this.annoDiCorso = annoDiCorso;
	}

	public SottoTarget getSottoTarget() {
		return sottoTarget;
	}

	public void setSottoTarget(SottoTarget sottoTarget) {
		this.sottoTarget = sottoTarget;
	}

	public Set<RequisitoCandidatura> getRequisitiCandidatura() {
		return requisitiCandidatura;
	}

	public void setRequisitiCandidatura(
			Set<RequisitoCandidatura> requisitiCandidatura) {
		this.requisitiCandidatura = requisitiCandidatura;
	}

	public Map<Long, RequisitoCandidatura> getRequisitiMap() {
		Map<Long, RequisitoCandidatura> m = new HashMap<Long, RequisitoCandidatura>();
		for (RequisitoCandidatura r: requisitiCandidatura)
			m.put(r.getRequisitoOfferta().getId(), r);
		return m;
	}

	public Set<CandidaturaOpzioneOfferta> getOpzioni() {
		return opzioni;
	}

	public void setOpzioni(Set<CandidaturaOpzioneOfferta> opzioni) {
		this.opzioni = opzioni;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((opzioni == null) ? 0 : opzioni.hashCode());
		result = prime * result + ((persona == null) ? 0 : persona.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Candidatura))
			return false;
		Candidatura other = (Candidatura) obj;
		if (opzioni == null) {
			if (other.opzioni != null)
				return false;
		} else if (!opzioni.equals(other.opzioni))
			return false;
		if (persona == null) {
			if (other.persona != null)
				return false;
		} else if (!persona.equals(other.persona))
			return false;
		return true;
	}
	
	public void addOpzione(OpzioneOffertaCommand opzioneOfferta) {
		if (opzioni == null)
			opzioni = new HashSet<CandidaturaOpzioneOfferta>();
		CandidaturaOpzioneOfferta coo = new CandidaturaOpzioneOfferta();
		coo.setOpzioneOfferta(opzioneOfferta.getOpzioneOfferta());
		coo.setPriorita(opzioneOfferta.getPriorita());
		opzioni.add(coo );
	}
	
	public boolean isInserita() {
		return StatoCandidatura.INSERITA.getValore().equals(stato) || stato == null;
	}
	
	public boolean isPresentata() {
		return StatoCandidatura.PRESENTATA.getValore().equals(stato);
	}
	
	public boolean isAlmenoAmmessa() {
		return StatoCandidatura.AMMESSA.getValore().equals(stato) || StatoCandidatura.VALUTATA.getValore().equals(stato); 
	}

	public boolean isNonAmmessa() {
		return StatoCandidatura.NON_AMMESSA.getValore().equals(stato); 
	}

	public Integer getPriorita() {
		return priorita;
	}

	public void setPriorita(Integer priorita) {
		this.priorita = priorita;
	}
	
	public Boolean getPresentabilePerRequisitiCalcolati() {
		for (RequisitoCandidatura rc :requisitiCandidatura)
			if (rc.getRequisitoOfferta().isVisibileCandidato() 
					&& rc.getRequisitoOfferta().isCalcolato() 
					&& rc.isCalcoloNegativo())
				return false;
		return true;
	}
	
	public FaseCandidatura getFase() {
		if (flagAmmissibile != null)
			return FaseCandidatura.VERIFICA;
		if (dataPresentazione != null)
			return FaseCandidatura.AMMISSIONE;
		return FaseCandidatura.PRESENTAZIONE;
	}
	
	public boolean isFasePresentazione() {
		return getFase().equals(FaseCandidatura.PRESENTAZIONE);
	}
	
	public String getColor() {
		return StatoCandidatura.get(stato).getColor();
	}
	
	public String getColorDesc() {
		return StatoCandidatura.get(stato).getValore();
	}

	public Integer getNumeroCarrieraMerito() {
		return numeroCarrieraMerito;
	}

	public void setNumeroCarrieraMerito(Integer numeroCarrieraMerito) {
		this.numeroCarrieraMerito = numeroCarrieraMerito;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
	
	public boolean isAmmissibilePerOperatore() {
		for (RequisitoCandidatura rc: requisitiCandidatura)
			if ((!rc.getRequisitoOfferta().isCalcolato())
					&& rc.getRequisitoOfferta().isVisibileOperatore()
					&& rc.getRequisitoOfferta().isObbligatoriaVerificaInFase(getFase())
					&& (!rc.isRequisitoOpzione() || isOpzioneSelezionata(rc.getRequisitoOfferta().getIdOpzioneOfferta()))
					&& !rc.isRequisitoVerificato())
				if (!rc.getRequisitoOfferta().isAppartieneAGruppoEsclusione())
					return false;
				else
				{
					// se appartiene a un gruppo esclusione controllo se almeno uno degli altri requisiti del gruppo e' stato verificato
					boolean gruppoVerificato = false;
					for (RequisitoCandidatura rc2: requisitiCandidatura)
						if (!rc2.getId().equals(rc.getId()) 
								&& rc.getRequisitoOfferta().getGruppoEsclusione().equals(rc2.getRequisitoOfferta().getGruppoEsclusione())
								&& rc2.isRequisitoVerificato())
						{
							gruppoVerificato = true;
							break;
						}
					if (!gruppoVerificato)
						return false;
				}
		return true;
	}
	
	public boolean isOpzioneSelezionata(Long idOpzione) {
		for (CandidaturaOpzioneOfferta coo: getOpzioni())
			if (coo.getOpzioneOfferta().getId().equals(idOpzione))
				return true;
		return false;
	}
	
	public String getCognomeNomeCandidato() {
		return persona.getCognomeNome();
	}
	
	public String getNomeCognomeCandidato() {
		return persona.getNomeCognome();
	}

	public String getStatoInGraduatoria() {
		if (StatoCandidatura.INSERITA.getValore().equals(stato) || StatoCandidatura.PRESENTATA.getValore().equals(stato))
			return StatoCandidaturaInGraduatoria.NON_VALUTATO.getValore();
		if (!isAlmenoAmmessa())
			return "non ammessa";
		return StatoCandidaturaInGraduatoria.get(getFlagStatoInGraduatoria()).getValore();
	}
	
	public String getColorAccettazione(){
		if (Common.CH_S.equals(flagEsitoAccettazione))
			return "Green";
		if (Common.CH_N.equals(flagEsitoAccettazione))
			return "Red";
		return "White";
	}
	
	public String getColorAccettazioneDesc(){
		if (Common.CH_S.equals(flagEsitoAccettazione))
			return "Accettata";
		if (Common.CH_N.equals(flagEsitoAccettazione))
			return "Rifiutata";
		return "Da accettare";
	}
	
	public String getColorInGraduatoria() {
		if (!isAlmenoAmmessa())
			return "Grey";
		//return StatoCandidaturaInGraduatoria.get(getFlagStatoInGraduatoria()).getColor(flagSubentro);
		return StatoCandidaturaInGraduatoria.get(getFlagStatoInGraduatoria()).getColor(flagSubentro, flagRiassegnazione);
	}

	public Character getFlagStatoInGraduatoria() {
		if (flagStatoInGraduatoria == null
				&& getPunteggioSoggettivo() != null)
			return StatoCandidaturaInGraduatoria.IDONEO.getStatoDB();
		if (flagStatoInGraduatoria == null
				&& !isIdoneo())
			return StatoCandidaturaInGraduatoria.ESCLUSO.getStatoDB();
		if (flagStatoInGraduatoria != null 
				&& flagStatoInGraduatoria.equals(StatoCandidaturaInGraduatoria.ESCLUSO.getStatoDB()) 
				&& isIdoneo()
				&& getPunteggioSoggettivo() != null)
			return StatoCandidaturaInGraduatoria.IDONEO.getStatoDB();
		if (flagStatoInGraduatoria != null 
				&& flagStatoInGraduatoria.equals(StatoCandidaturaInGraduatoria.ESCLUSO.getStatoDB()) 
				&& isIdoneo()
				&& getPunteggioSoggettivo() == null)
			return StatoCandidaturaInGraduatoria.NON_VALUTATO.getStatoDB();
		return flagStatoInGraduatoria;
	}

	public void setFlagStatoInGraduatoria(Character flagStatoInGraduatoria) {
		this.flagStatoInGraduatoria = flagStatoInGraduatoria;
	}
	
	public boolean isIdoneo() {
		return Common.CH_S.equals(flagIdoneo);
	}
	
	public boolean isAccettata() {
		return Common.CH_S.equals(flagEsitoAccettazione);
	}
	
	public boolean isVincitore() {
		return StatoCandidaturaInGraduatoria.VINCITORE.getStatoDB().equals(getFlagStatoInGraduatoria()) && isAlmenoAmmessa();
	}
	
	public boolean isSubentratoVolontarioSenzaContributo() {
		return StatoCandidaturaInGraduatoria.SUBENTRATO_VOLONTARIO_SENZA_CONTRIBUTO.getStatoDB().equals(getFlagStatoInGraduatoria()) && isAlmenoAmmessa();
	}
	
	public boolean isVisualizzazioneGraduatoriaAttiva() {
		if (!isAlmenoAmmessa())
			return false;
		if (!getOffertaInDisponibilita().getDisponibilita().isChiusa())
			return false;
		return true;
	}
	
	public boolean isNonAccettata() {
		return Common.CH_N.equals(flagEsitoAccettazione) || StatoCandidaturaInGraduatoria.NON_ACCETTATO.getStatoDB().equals(getFlagStatoInGraduatoria());
	}
	
	public boolean isRinunciato() {
		return StatoCandidaturaInGraduatoria.RINUNCIATO.getStatoDB().equals(getFlagStatoInGraduatoria());
	}
	
	public boolean isEscluso() {
		return StatoCandidaturaInGraduatoria.ESCLUSO.getStatoDB().equals(getFlagStatoInGraduatoria());
	}
	
	public boolean isRespinto() {
		return StatoCandidaturaInGraduatoria.RESPINTO.getStatoDB().equals(getFlagStatoInGraduatoria());
	}
	
	public boolean isDaAccettare() {
		return flagEsitoAccettazione == null;
	}

	public Character getFlagSubentro() {
		return (flagSubentro==null) ? Common.CH_N : flagSubentro;
	}

	public void setFlagSubentro(Character flagSubentro) {
		this.flagSubentro = flagSubentro;
	}
	
	public String getFlagSubentroDesc() {
		return (flagSubentro==null) ? "" : flagSubentro.toString();
	}

	public boolean isSubentro() {
		return Common.CH_S.equals(flagSubentro);
	}
	
	public Date getDataSubentro() {
		return dataSubentro;
	}

	public void setDataSubentro(Date dataSubentro) {
		this.dataSubentro = dataSubentro;
	}

	public Persona getAutoreSubentro() {
		return autoreSubentro;
	}

	public void setAutoreSubentro(Persona autoreSubentro) {
		this.autoreSubentro = autoreSubentro;
	}

	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}
	
	public Bando getBando() {
		if (getOffertaInDisponibilita() != null && getOffertaInDisponibilita().getDisponibilita() != null)
			return getOffertaInDisponibilita().getDisponibilita().getBando();
		return null;
	}
	
	public Ateneo getAteneo() {
		return getOffertaInDisponibilita().getOfferta().getAteneo();
	}
	
	public String getDataInserimentoPresentazioneLbl() {
		String ret = "";
		if (dataInserimento != null)
			ret += Common.getDataOraFormattata(dataInserimento) + "<br/>";
		if (dataPresentazione != null)
			ret += Common.getDataOraFormattata(dataPresentazione); 
		return ret;
	}
	
	public boolean isRifiutata() {
		return Common.CH_N.equals(flagEsitoAccettazione);
	}

	public Integer getPosizioneInGraduatoriaOrig() {
		return posizioneInGraduatoriaOrig;
	}

	public void setPosizioneInGraduatoriaOrig(Integer posizioneInGraduatoriaOrig) {
		this.posizioneInGraduatoriaOrig = posizioneInGraduatoriaOrig;
	}

	public Character getFlagStatoInGraduatoriaOrig() {
		return flagStatoInGraduatoriaOrig;
	}

	public void setFlagStatoInGraduatoriaOrig(Character flagStatoInGraduatoriaOrig) {
		this.flagStatoInGraduatoriaOrig = flagStatoInGraduatoriaOrig;
	}
	
	public boolean isVincitoreInGraduatoriaOrig() {
		return StatoCandidaturaInGraduatoria.VINCITORE.getStatoDB().equals(getFlagStatoInGraduatoriaOrig());
	}

	public static class CandidaturaPosizioneGraduatiria1Comparator  implements Comparator<Candidatura>
	{
		public int compare(Candidatura o1, Candidatura o2) {
			if (o1 == null && o2 == null)
				return 0;
			return (o1.getPosizioneInGraduatoria1() == null ? new Integer(-1) : o1.getPosizioneInGraduatoria1()).compareTo(o2.getPosizioneInGraduatoria1() == null ? new Integer(-1) : o2.getPosizioneInGraduatoria1());
		}
	}
/*
	public CandidaturaInfo getCandidaturaInfo() {
		return candidaturaInfo;
	}

	public void setCandidaturaInfo(CandidaturaInfo candidaturaInfo) {
		this.candidaturaInfo = candidaturaInfo;
	}
*/
	public void setOpzioneOffertaVincitore(OpzioneOfferta opzioneOffertaVincitore) {
		this.opzioneOffertaVincitore = opzioneOffertaVincitore;
		if (opzioneOffertaVincitore != null && opzioneOffertaVincitore.getAteneo() != null)
			setAteneoDestinazione(opzioneOffertaVincitore.getAteneo());
	}

	public OpzioneOfferta getOpzioneOffertaVincitore() {
		return opzioneOffertaVincitore;
	}

	public void setAteneoDestinazione(Ateneo ateneoDestinazione) {
		this.ateneoDestinazione = ateneoDestinazione;
	}

	public Ateneo getAteneoDestinazione() {
		return ateneoDestinazione;
	}

	public void setFlagEmailInviata(Character flagEmailInviata) {
		this.flagEmailInviata = flagEmailInviata;
	}

	public Character getFlagEmailInviata() {
		return flagEmailInviata;
	}

	public void setDataInvioEmail(Date dataInvioEmail) {
		this.dataInvioEmail = dataInvioEmail;
	}

	public Date getDataInvioEmail() {
		return dataInvioEmail;
	}

	public Integer getPosizioneInGraduatoria2Orig() {
		return posizioneInGraduatoria2Orig;
	}

	public void setPosizioneInGraduatoria2Orig(Integer posizioneInGraduatoria2Orig) {
		this.posizioneInGraduatoria2Orig = posizioneInGraduatoria2Orig;
	}

	public Character getFlagStatoInGraduatoria2Orig() {
		return flagStatoInGraduatoria2Orig;
	}

	public void setFlagStatoInGraduatoria2Orig(Character flagStatoInGraduatoria2Orig) {
		this.flagStatoInGraduatoria2Orig = flagStatoInGraduatoria2Orig;
	}

	public Character getFlagStatoInGraduatoria1Finale() {
		return flagStatoInGraduatoria1Finale;
	}

	public void setFlagStatoInGraduatoria1Finale(Character flagStatoInGraduatoria1Finale) {
		this.flagStatoInGraduatoria1Finale = flagStatoInGraduatoria1Finale;
	}

	public Integer getPosizioneInGraduatoria1Finale() {
		return posizioneInGraduatoria1Finale;
	}

	public void setPosizioneInGraduatoria1Finale(Integer posizioneInGraduatoria1Finale) {
		this.posizioneInGraduatoria1Finale = posizioneInGraduatoria1Finale;
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

	public Corso getCorso() {
		return corso;
	}

	public void setCorso(Corso corso) {
		this.corso = corso;
	}
	
	public String getFacCorso() {
		String ret = "";
		if (getCorso() != null)
			ret += (getCorso().getCorsoView() != null ? getCorso().getCorsoView().getDescrizioneFacolta() : "") + " - " + getCorso().getDescrizione();
		return ret;
	}

	public Set<CandidaturaInfo> getCandidatureInfo() {
		return candidatureInfo;
	}

	public void setCandidatureInfo(Set<CandidaturaInfo> candidatureInfo) {
		this.candidatureInfo = candidatureInfo;
	}

	public CandidaturaInfo getCandidaturaInfoUnica() {
		return candidatureInfo != null  && !candidatureInfo.isEmpty() ? candidatureInfo.iterator().next() : null;
	}

	public List<CandidaturaInfo> getCandidatureInfoList() {
		List<CandidaturaInfo> l = new ArrayList<CandidaturaInfo>(candidatureInfo);
		Collections.sort(l, new CandidaturaInfoComparator());
		return l;
	}

	public String getNoteAmmissione() {
		return noteAmmissione;
	}

	public void setNoteAmmissione(String noteAmmissione) {
		this.noteAmmissione = noteAmmissione;
	}

	public CandidaturaDatiPlacement getCandidaturaDatiPlacement() {
		return candidaturaDatiPlacement;
	}

	public void setCandidaturaDatiPlacement(
			CandidaturaDatiPlacement candidaturaDatiPlacement) {
		this.candidaturaDatiPlacement = candidaturaDatiPlacement;
	}
	
	public boolean isPlacement() {
		return (getOffertaInDisponibilita() != null) ? getOffertaInDisponibilita().getDisponibilita().getBando().getSottoProgramma().isErasmusPlacement() : false;
	}

	public boolean isFieldWork() {
		return (getOffertaInDisponibilita() != null) ? getOffertaInDisponibilita().getDisponibilita().getBando().getSottoProgramma().isFieldWork() : false;
	}
	
	public boolean isCandidaturaSuOffertaPredefinita() {
		if (getOffertaInDisponibilita() != null && getOffertaInDisponibilita().getOfferta() != null)
			return getOffertaInDisponibilita().getOfferta().isPredefinita();
		return false;
	}

	public String getNoteInterne() {
		return noteInterne;
	}

	public void setNoteInterne(String noteInterne) {
		this.noteInterne = noteInterne;
	}

	public BigDecimal getPunteggio1() {
		return punteggio1;
	}

	public void setPunteggio1(BigDecimal punteggio1) {
		this.punteggio1 = punteggio1;
		updatePunteggioComplessivo();
	}

	public BigDecimal getPunteggio2() {
		return punteggio2;
	}

	public void setPunteggio2(BigDecimal punteggio2) {
		this.punteggio2 = punteggio2;
		updatePunteggioComplessivo();
	}

	public BigDecimal getPunteggio3() {
		return punteggio3;
	}

	public void setPunteggio3(BigDecimal punteggio3) {
		this.punteggio3 = punteggio3;
		updatePunteggioComplessivo();
	}

	public BigDecimal getPunteggio4() {
		return punteggio4;
	}

	public void setPunteggio4(BigDecimal punteggio4) {
		this.punteggio4 = punteggio4;
		updatePunteggioComplessivo();
	}

	public Long getDurataPrevista() {
		return durataPrevista;
	}

	public void setDurataPrevista(Long durataPrevista) {
		this.durataPrevista = durataPrevista;
	}

	public UnitaMisuraDurata getUnitaMisuraDurataPrevista() {
		return unitaMisuraDurataPrevista;
	}

	public void setUnitaMisuraDurataPrevista(
			UnitaMisuraDurata unitaMisuraDurataPrevista) {
		this.unitaMisuraDurataPrevista = unitaMisuraDurataPrevista;
	}
	
	public String getDurataPrevistaLabel() {
		if (getDurataPrevista() != null)
			return getDurataPrevista().toString() + " " + (getUnitaMisuraDurataPrevista() != null ? getUnitaMisuraDurataPrevista().getUnita() : "");
		return null;
	}

	/*
	 * 2016-03-22 Attenzione: per individuare il bando gruppo della candidatura usare il nuovo metodo getBandoGruppoCandidatura
	 */
	public BandoGruppo getBandoGruppo() {
		return bandoGruppo;
	}

	public void setBandoGruppo(BandoGruppo bandoGruppo) {
		this.bandoGruppo = bandoGruppo;
	}

	/*
	 * Ritorna il gruppo impostato sulla candidatura se non è nullo, altrimenti ritorna il gruppo della disponibilità 
	 * della candidatura se non nullo e se risulta abilitato ad essere assegnato alla candidatura.
	 * Ritorna null se nessun gruppo trovato oppure se esiste solo il gruppo sulla disponibilita'
	 * ma la tipologia di questo non e' abilitata ad essere assegnata in automatico  alla candidatura  
	 */
	public BandoGruppo getBandoGruppoCandidatura() {
		if (getBandoGruppo() != null)
			return getBandoGruppo();
		BandoGruppo bg=getOffertaInDisponibilita().getDisponibilita().getGruppoAssegnatoCandidatura();
		return bg;
	}
	
	public Boolean getAccettazioneAperta() {
		if (accettazioneAperta == null)
			throw new RuntimeException("La lettura di questo campo puo' essere fatta solo dopo aver impostato un valore. E' un campo calcolato.");
		return accettazioneAperta;
	}

	public void setAccettazioneAperta(Boolean accettazioneAperta) {
		this.accettazioneAperta = accettazioneAperta;
	}

	public BigDecimal getPunteggioOggettivoOriginale() {
		return punteggioOggettivoOriginale;
	}

	public void setPunteggioOggettivoOriginale(
			BigDecimal punteggioOggettivoOriginale) {
		this.punteggioOggettivoOriginale = punteggioOggettivoOriginale;
	}

	public String getNoteModificaPunteggioOggettivo() {
		return noteModificaPunteggioOggettivo;
	}

	public void setNoteModificaPunteggioOggettivo(
			String noteModificaPunteggioOggettivo) {
		this.noteModificaPunteggioOggettivo = noteModificaPunteggioOggettivo;
	}

	public Persona getAutoreAccettazione() {
		return autoreAccettazione;
	}

	public void setAutoreAccettazione(Persona autoreAccettazione) {
		this.autoreAccettazione = autoreAccettazione;
	}

	public String getNoteValutazione() {
		return noteValutazione;
	}

	public void setNoteValutazione(String noteValutazione) {
		this.noteValutazione = noteValutazione;
	}

	public CandidaturaDottorandiVisiting getCandidaturaDottorandiVisiting() {
		return candidaturaDottorandiVisiting;
	}

	public void setCandidaturaDottorandiVisiting(
			CandidaturaDottorandiVisiting candidaturaDottorandiVisiting) {
		this.candidaturaDottorandiVisiting = candidaturaDottorandiVisiting;
	}

	public CandidaturaLingue getCandidaturaLingue() {
		return candidaturaLingue;
	}

	public void setCandidaturaLingue(CandidaturaLingue candidaturaLingue) {
		this.candidaturaLingue = candidaturaLingue;
	}

	public SottoProgramma getSottoprogrammaOfferta () {
		if (getOffertaInDisponibilita() != null) {
			SottoProgramma spg = getOffertaInDisponibilita().getOfferta().getFlussoScambioEsecuzione().getScambioEsecuzione().getSottoProgramma();
			if (spg != null)
				spg.getNome();
			return spg;
		}
		return null;
	}

	public Integer getGiorniFruitiAccettati() {
		return giorniFruitiAccettati;
	}

	public void setGiorniFruitiAccettati(Integer giorniFruitiAccettati) {
		this.giorniFruitiAccettati = giorniFruitiAccettati;
	}
	
	public boolean isGestioneRilevazioneLinguistica () {
		return  getSottoprogrammaOfferta().isRilevaLivLinguistico();
	}

	public Offerta getOfferta() {
		return getOffertaInDisponibilita() != null ? getOffertaInDisponibilita().getOfferta() : null;	
	}

	public Character getFlagAvvisoPeriodoInCorsoInAccettazione() {
		return flagAvvisoPeriodoInCorsoInAccettazione;
	}

	public void setFlagAvvisoPeriodoInCorsoInAccettazione(
			Character flagAvvisoPeriodoInCorsoInAccettazione) {
		this.flagAvvisoPeriodoInCorsoInAccettazione = flagAvvisoPeriodoInCorsoInAccettazione;
	}

	public Character getFlagAvvisoPeriodoFuturoInAccettazione() {
		return flagAvvisoPeriodoFuturoInAccettazione;
	}

	public void setFlagAvvisoPeriodoFuturoInAccettazione(
			Character flagAvvisoPeriodoFuturoInAccettazione) {
		this.flagAvvisoPeriodoFuturoInAccettazione = flagAvvisoPeriodoFuturoInAccettazione;
	}

	public boolean isEsitiRequisitiVisibiliCandidato(){
	  // solo dopo le ammissioni e se il bando lo prevede 
	  return  this.dataPresentazione != null && this.flagAmmissibile != null 
			  	&&  this.getBando() != null && this.getBando().isVisualizzaEsitiValidazioneAStudente();
	}

	public Character getFlagLegataTitoloDoppioMultCong() {
		return flagLegataTitoloDoppioMultCong;
	}

	public void setFlagLegataTitoloDoppioMultCong(
			Character flagLegataTitoloDoppioMultCong) {
		this.flagLegataTitoloDoppioMultCong = flagLegataTitoloDoppioMultCong;
	}

	public boolean isLegataTitoloDoppioMultCong() {
		return Common.CH_S.equals(flagLegataTitoloDoppioMultCong);
	}
	
	public boolean isCandidaturaDiBandoGruppoCheAggiungePosti() {
		BandoGruppo bg = getBandoGruppoCandidatura();
		return (bg != null) && bg.isAggiungePosti();
	}

	public Character getFlagRiassegnazione() {
		return flagRiassegnazione;
	}

	public void setFlagRiassegnazione(Character flagRiassegnazione) {
		this.flagRiassegnazione = flagRiassegnazione;
	}

	// true  se si tratta di un ougoing riassegnato ad altra offerta
	public boolean isRiassegnazioneOutgoing(){
		return Common.CH_O.equals(getFlagRiassegnazione());
	}
	
	public Long getIdCandProvenienza() {
		return idCandProvenienza;
	}

	public void setIdCandProvenienza(Long idCandProvenienza) {
		this.idCandProvenienza = idCandProvenienza;
	}
	
	public Character getFlagComeLaureato() {
		return flagComeLaureato;
	}

	public void setFlagComeLaureato(Character flagComeLaureato) {
		this.flagComeLaureato = flagComeLaureato;
	}

	public boolean isComeLaureato() {
		return Common.CH_S.equals(getFlagComeLaureato());
	}
	
	public boolean isAttivaRilevazioneLingisticaInAccettazione(){
		if ((!getSottoprogrammaOfferta().isRilevaLivLinguistico()))
			return false;
	
		// NESSUNA DOMANDA RELATIVA AD OLS O LINGUA VERRA VISUALIZZATA ALLO STUDENTE IN ACCETTAZIONE
		// quindi non carico nessuna delle  strutture della pagina web relative a quella sezione
		if (!getBando().isSezioneOlsInAccettazione())
			return false;
		
		return true;
	}

	public String getNomeAteneoAzienda() {
		String nomeAteneoAzienda = getAteneoDestinazioneLabel();
		if (getBando()!=null) {
			if (getBando().getSottoProgramma()!=null) {
				if (getBando().getSottoProgramma().isScambioConAzienda()) {
					if (getCandidaturaDatiPlacement()!=null) {
						nomeAteneoAzienda = getCandidaturaDatiPlacement().getDenominazioneAzienda();
					}
				}
			}
		}
		return nomeAteneoAzienda;
	}
	
	public String getAteneoDestinazioneLabel() {
		Ateneo ateneo = getAteneoDestinazione();
		if (ateneo == null)
			return "";
		return ateneo.getCodiceNazionale() + " - " + ateneo.getRagioneSociale();
	}

	public Programma getProgrammaOfferta () {
		SottoProgramma spg = getSottoprogrammaOfferta();
		if (spg != null) {
			Programma pg = spg.getProgramma();
			if (pg != null)
				pg.getNome();
			return pg;
		}
		return null;
	}

	public PeriodoMobilita getPeriodoMobilita () {
		return getOffertaInDisponibilita() == null ? null 
				: getOffertaInDisponibilita().getOfferta().getFlussoScambioEsecuzione().getPeriodoMobilita();
	}

	public Long getDurataPrevistaDalFlusso() {
		return getOffertaInDisponibilita() != null ? getOffertaInDisponibilita().getOfferta().getFlussoScambioEsecuzione().getDurata() : null;
	}
	
	public String getDurataPrevistaDalFlussoLabel() {
		return getOffertaInDisponibilita() != null ? getOffertaInDisponibilita().getOfferta().getFlussoScambioEsecuzione().getDurata().toString() + " " + (getOffertaInDisponibilita().getOfferta().getFlussoScambioEsecuzione().getUnitaMisuraDurata() != null ? getOffertaInDisponibilita().getOfferta().getFlussoScambioEsecuzione().getUnitaMisuraDurata().getUnita() : "") : null;
	}
	
	public Long getDurataPrevistaDaDatiPlacement() {
		return getCandidaturaDatiPlacement() != null && getCandidaturaDatiPlacement().getDurata() != null ? new Long(getCandidaturaDatiPlacement().getDurata()) : null;
	}
	
	public String getDurataPrevistaDaDatiPlacementLabel() {
		return getCandidaturaDatiPlacement() != null ? (new Long(getCandidaturaDatiPlacement().getDurata())).toString() + " " + (getUnitaMisuraDurataPrevista() != null ? getUnitaMisuraDurataPrevista().getUnita() : getOfferta().getFlussoScambioEsecuzione().getUnitaMisuraDurata() != null ? getOfferta().getFlussoScambioEsecuzione().getUnitaMisuraDurata().getUnita() : "") : null;
	}

	public Long getDurataPrevistaScambio() {
		Long durata = getDurataPrevista(); 
		if (durata == null) {
			durata=getDurataPrevistaDaDatiPlacement();
			if (durata == null) {
				durata = getDurataPrevistaDalFlusso();
			}
		}
		return durata;
	}
	
	public String getDurataPrevistaScambioLabel() {
		String durata = getDurataPrevistaLabel(); 
		if (durata == null) {
			durata=getDurataPrevistaDaDatiPlacementLabel();
			if (durata == null) {
				durata = getDurataPrevistaDalFlussoLabel();
			}
		}
		return durata;
	}
	
	public boolean isScambioErasmusPlusStudio() {
		SottoProgramma spg = getSottoprogrammaOfferta();
		return spg != null ? spg.isErasmusPlusStudio() : false;
	}

	public boolean isProgrammaErasmusOSwissEU() {
		Programma pg = getProgrammaOfferta();
		return pg != null ? pg.isErasmus() : false;
	}

	//-------------------- REGOLE DI FUNZIONAMENTO SPECIFICHE ---------------------------------
	// 			Potrebbero anche essere spostate nella classe Offerta

	// ATTIVA x ERASMUS la regola di decuratazione a 6 mesi della durata prevista 
	// e dunque finaziata in anticipo per l' outgoing per le partenze II semestre  
	public boolean isAttivaRegolaDurataPrevPeriodoIISem() {
		PeriodoMobilita pm = getPeriodoMobilita();
		if (pm == null || pm.getAnnoAccademico() == null || (pm.getAnnoAccademico().intValue() < 2017))
			return false;
		
		SottoProgramma  spg = getSottoprogrammaOfferta();
		return  spg != null && (spg.isErasmusPlusStudio() || spg.isSwissEuropeanMobilityProgramme()); 
	}

	// ATTIVA x ERASMUS la regola di calcolo della durata per la borsa finanziabile con
	// fondi Erasmus che concede fino a 5 gioni(figurativi) per il completamento del mese.
	public boolean isAttivaCalcolaDurataErasmus() {
		PeriodoMobilita pm = getPeriodoMobilita();
		if (pm == null || pm.getAnnoAccademico() == null || (pm.getAnnoAccademico().intValue() < 2016))
			return false;
		
		SottoProgramma  spg = getSottoprogrammaOfferta();
		return 	this.isPlacement() 
				|| (   (pm.getAnnoAccademico().intValue() >= 2017)  
				    && (spg.isErasmusPlusStudio() || spg.isErasmusPlusExtraUEStudio())
				   );
	}

	public Persona getReferenteInternoSpecifico() {
		return referenteInternoSpecifico;
	}

	public void setReferenteInternoSpecifico(Persona referenteInternoSpecifico) {
		this.referenteInternoSpecifico = referenteInternoSpecifico;
	}

	public Character getFlagPerTesi() {
		if (flagPerTesi==null)
			return 'N';
		return flagPerTesi;
	}

	public boolean isPerTesi() {
		return Common.CH_S.equals(getFlagPerTesi());
	}

	public void setFlagPerTesi(Character flagPerTesi) {
		this.flagPerTesi = flagPerTesi;
	}

	public boolean isVisitingStudents() {
		return getBando().getSottoProgramma().isVisitingStudents();
	}
	
	public boolean isTesiAllEstero() {
		return getBando().isTesiAllEstero();
	}
	
	//------------------------------------------------------------------------------------------
	
}
