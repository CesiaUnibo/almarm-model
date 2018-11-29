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

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import edu.emory.mathcs.backport.java.util.Collections;
import it.unibo.almarm.model.accordi.AccordoOperativo;
import it.unibo.almarm.model.attori.Ateneo;
import it.unibo.almarm.model.flussiscambio.FlussoScambioEsecuzione;
import it.unibo.almarm.model.flussiscambio.PeriodoMobilita;
import it.unibo.almarm.model.lingue.Lingua;
import it.unibo.almarm.util.Common;

public class Offerta implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private FlussoScambioEsecuzione flussoScambioEsecuzione;
	private Long posti;
	private Integer	posizione;
	private String note;
	private String noteInterne;
	private Character perStudio;
	private Character perTirocinio;
	private Character perPreparazioneTesi;
	private Set<RegolaOfferta> regole = new HashSet<RegolaOfferta>();
	private Set<OpzioneOfferta> opzioniOfferta = new HashSet<OpzioneOfferta>();
	private Set<RequisitoOfferta> requisitiOfferta = new HashSet<RequisitoOfferta>();
	private Integer maxOpzioni;
	private String allegato;
	private String idAllegato;
	
	// CHG 13076
	private Character flagColloquioObbligatorio;
	private Character flagSitoRecapitiIstituzionale;
	private String sitoWebRecapiti;
	private Date dataInserimento;
	private Date dataUltimaModifica;
	
	private Lingua linguaPrimaria;
	private Lingua linguaSecondaria;
	private String modalitaColloquio;
	private String altreNoteStudenti;
	private String altreNoteStudentiEn;
	private Character flagAttiva;
	private Character flagAperturaATutteLeFacolta;
	private Long idCopiataDa;
	private Character flagPredefinita;
	private TirocinioErasmusPlacement tirocinioErasmusPlacement;
	// 2013 --
	private String stato;
	private Long idAutoreInserimento;
	private Character flagCancellata; // TODO : per completare l'ndipendenza di aggiornamento della disponibilita
	private Date dataAttivazione;
	private Long idAutoreAttivazione;
	private Long idAutoreUltimaModifica;
	private GestioneOfferta gestioneOfferta;
	// --
	
	// Caampi non persistiti
	private Integer progressivo;
	private String sitoRecapitiInserito;
	private String sitoRecapitiIstituzionale;
	private boolean recapitiPrevalorizzati;
	private transient MultipartFile fileAllegato;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public FlussoScambioEsecuzione getFlussoScambioEsecuzione() {
		return flussoScambioEsecuzione;
	}
	public void setFlussoScambioEsecuzione(
			FlussoScambioEsecuzione flussoScambioEsecuzione) {
		this.flussoScambioEsecuzione = flussoScambioEsecuzione;
	}
	public Long getPosti() {
		return posti;
	}
	public void setPosti(Long posti) {
		this.posti = posti;
	}
	public Integer getPosizione() {
		return posizione;
	}
	public void setPosizione(Integer posizione) {
		this.posizione = posizione;
	}
	public Set<RegolaOfferta> getRegole() {
		return regole;
	}
	public void setRegole(Set<RegolaOfferta> regole) {
		this.regole = regole;
	}

	public Integer getProgressivo() {
		return progressivo;
	}
	public void setProgressivo(Integer progressivo) {
		this.progressivo = progressivo;
	}
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getNoteInterne() {
		return noteInterne;
	}
	public void setNoteInterne(String noteInterne) {
		this.noteInterne = noteInterne;
	}
	public boolean isNoteInterneValide() {
		return StringUtils.isNotBlank(noteInterne);
	}
	
	public Character getPerStudio() {
		if (perStudio == null)
			return 'N';
		return perStudio;
	}
	public void setPerStudio(Character perStudio) {
		this.perStudio = perStudio;
	}
	public Character getPerTirocinio() {
		if (perTirocinio == null)
			return 'N';
		return perTirocinio;
	}
	public void setPerTirocinio(Character perTirocinio) {
		this.perTirocinio = perTirocinio;
	}
	public Character getPerPreparazioneTesi() {
		if (perPreparazioneTesi == null)
			return 'N';
		return perPreparazioneTesi;
	}
	public void setPerPreparazioneTesi(Character perPreparazioneTesi) {
		this.perPreparazioneTesi = perPreparazioneTesi;
	}

	public boolean isTipiAttivitaValid()
	{
		return Common.CH_S.equals(perStudio) || Common.CH_S.equals(perTirocinio) || Common.CH_S.equals(perPreparazioneTesi); 
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((posizione == null) ? 0 : posizione.hashCode());
		result = prime * result + ((posti == null) ? 0 : posti.hashCode());
		result = prime * result
				+ ((progressivo == null) ? 0 : progressivo.hashCode());
		result = prime * result + ((perStudio == null) ? 0 : perStudio.hashCode());
		result = prime * result + ((perTirocinio == null) ? 0 : perTirocinio.hashCode());
		result = prime * result + ((perPreparazioneTesi == null) ? 0 : perPreparazioneTesi.hashCode());
		result = prime * result + ((dataInserimento == null) ? 0 : dataInserimento.hashCode());
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Offerta))
			return false;
		Offerta other = (Offerta) obj;
		if (posizione == null) {
			if (other.posizione != null)
				return false;
		} else if (!posizione.equals(other.posizione))
			return false;
		if (posti == null) {
			if (other.posti != null)
				return false;
		} else if (!posti.equals(other.posti))
			return false;
		if (progressivo == null) {
			if (other.progressivo != null)
				return false;
		} else if (!progressivo.equals(other.progressivo))
			return false;
		if (dataInserimento == null) {
			if (other.dataInserimento != null)
				return false;
		} else if (!dataInserimento.equals(other.dataInserimento))
			return false;
		if (perStudio == null) {
			if (other.perStudio != null)
				return false;
		} else if (!perStudio.equals(other.perStudio))
			return false;
		if (perTirocinio == null) {
			if (other.perTirocinio != null)
				return false;
		} else if (!perTirocinio.equals(other.perTirocinio))
			return false;
		if (perPreparazioneTesi == null) {
			if (other.perPreparazioneTesi != null)
				return false;
		} else if (!perPreparazioneTesi.equals(other.perPreparazioneTesi))
			return false;
		if (regole == null) {
			if (other.regole != null)
				return false;
		} else if (!regole.equals(other.regole))
			return false;
		return true;
	}

	public static class OffertaComparator implements Comparator<Offerta>
	{
		public int compare(Offerta o1, Offerta o2) {
			if (o1 == null && o2 == null)
				return 0;
			if (o1 == null)
				return 1;
			if (o2 == null)
				return -1;
			if (o1.getPosizione()==null)
				return 1;
			if (o2.getPosizione()==null)
				return -1;
			return (o1.getPosizione().compareTo(o2.getPosizione()));
		}
	}

	public static class OffertaProgressivoComparator implements Comparator<Offerta>
	{
		public int compare(Offerta o1, Offerta o2) {
			if (o1 == null && o2 == null)
				return 0;
			if (o1 == null)
				return 1;
			if (o2 == null)
				return -1;
			if ((o1.getProgressivo()==null) &&  (o2.getProgressivo()==null))
			{
				if ((o1.getId()==null) &&  (o2.getId()==null))
					return 0;
					
				if (o1.getId()==null) 
					return 1;
				
				if (o2.getId()==null) 
					return -1;
				return (o1.getId().compareTo(o2.getId()));
			}
			if (o1.getProgressivo()==null)
				return 1;
			if (o2.getProgressivo()==null)
				return -1;
			return (o1.getProgressivo().compareTo(o2.getProgressivo()));
		}
	}

	public Set<OpzioneOfferta> getOpzioniOfferta() {
		return opzioniOfferta;
	}
	public void setOpzioniOfferta(Set<OpzioneOfferta> opzioniOfferta) {
		this.opzioniOfferta = opzioniOfferta;
	}
	public Set<RequisitoOfferta> getRequisitiOfferta() {
		return requisitiOfferta;
	}
	public void setRequisitiOfferta(Set<RequisitoOfferta> requisitiOfferta) {
		this.requisitiOfferta = requisitiOfferta;
	}
	
	public Ateneo getAteneoReferente() {
		if (flussoScambioEsecuzione == null || flussoScambioEsecuzione.getAccordoOperativo() == null)
			return null;
		return flussoScambioEsecuzione.getAccordoOperativo().getAteneoPartnerReferente();
	}
	
	public Ateneo getAteneoBeneficiario() {
		if (flussoScambioEsecuzione == null || flussoScambioEsecuzione.getScambioEsecuzione() == null || flussoScambioEsecuzione.getScambioEsecuzione().getScambioAccordo() == null)
			return null;
		return flussoScambioEsecuzione.getScambioEsecuzione().getScambioAccordo().getBeneficiario();
	}
	
	public Ateneo getAteneo() {
		Ateneo ateneo = getAteneoBeneficiario();
		if (ateneo == null)
			return getAteneoReferente();
		return ateneo;
	}

	public AccordoOperativo getAccordoOperativo() {
		return (flussoScambioEsecuzione != null && flussoScambioEsecuzione.getAccordoOperativo() != null
			   ? flussoScambioEsecuzione.getAccordoOperativo(): null);
	}
	
	public String getTipiAttivitaLabel() {
		String s = "";
		if (Common.CH_S.equals(perStudio))
			s += "studio, ";
		if (Common.CH_S.equals(perTirocinio))
			s += "tirocinio, ";
		if (Common.CH_S.equals(perPreparazioneTesi))
			s += "preparazione tesi, ";
		if (StringUtils.isNotBlank(s))
			s = s.substring(0, s.length() -2);
		return s;
	}
	public Integer getMaxOpzioni() {
		return maxOpzioni;
	}
	public void setMaxOpzioni(Integer maxOpzioni) {
		this.maxOpzioni = maxOpzioni;
	}
	public String getAllegato() {
		return allegato;
	}
	public void setAllegato(String allegato) {
		this.allegato = allegato;
	}
	public String getIdAllegato() {
		return idAllegato;
	}
	public void setIdAllegato(String idFileAllegato) {
		this.idAllegato = idFileAllegato;
	}
	public String getPathAllegato() {
		/*
		 * Prima del 2017, il campo idAllegato non esisteva 
		 * dal momento che i file allegati erano caricati a mano.
		 * In questi casi, il path corrisponde al nome dell'allegato.
		 * Nei casi in cui invece l'allegato e' caricato tramite a
		 * applicativo, l'id esiste e nello storage dei file 
		 * il file e' memorizzato come idAllegato + "_" + nomeAllegato.
		 */
		String prefix = "";
		if (getIdAllegato()!=null)
			prefix = getIdAllegato() + "_";
		return prefix + getAllegato();
	}
	public Character getFlagColloquioObbligatorio() {
		return flagColloquioObbligatorio==null ? Common.CH_N : flagColloquioObbligatorio;
	}
	public void setFlagColloquioObbligatorio(Character flagColloquioObbligatorio) {
		this.flagColloquioObbligatorio = flagColloquioObbligatorio;
	}
	public Character getFlagSitoRecapitiIstituzionale() {
		return flagSitoRecapitiIstituzionale==null ? Common.CH_S : flagSitoRecapitiIstituzionale;
	}
	public void setFlagSitoRecapitiIstituzionale(
			Character flagSitoRecapitiIstituzionale) {
		this.flagSitoRecapitiIstituzionale = flagSitoRecapitiIstituzionale;
	}
	public String getSitoWebRecapiti() {
		return sitoWebRecapiti;
	}
	public void setSitoWebRecapiti(String sitoWebRecapiti) {
		this.sitoWebRecapiti = sitoWebRecapiti;
	}
	public boolean isColloquioObbligatorio() {
		return Common.CH_S.equals(getFlagColloquioObbligatorio());
	}
	public boolean isSitoRecapitiIstituzionale() {
		return Common.CH_S.equals(getFlagSitoRecapitiIstituzionale());
	}	
	public Date getDataInserimento() {
		return dataInserimento;
	}
	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}
	public Date getDataUltimaModifica() {
		return dataUltimaModifica;
	}
	public void setDataUltimaModifica(Date dataUltimaModifica) {
		this.dataUltimaModifica = dataUltimaModifica;
	}
	public String getSitoRecapitiInserito() {
		return sitoRecapitiInserito;
	}
	public void setSitoRecapitiInserito(String sitoRecapitiInserito) {
		this.sitoRecapitiInserito = sitoRecapitiInserito;
	}
	public String getSitoRecapitiIstituzionale() {
		return sitoRecapitiIstituzionale;
	}
	public void setSitoRecapitiIstituzionale(String sitoRecapitiIstituzionale) {
		this.sitoRecapitiIstituzionale = sitoRecapitiIstituzionale;
	}
	public boolean isRecapitiPrevalorizzati() {
		return recapitiPrevalorizzati;
	}
	public void setRecapitiPrevalorizzati(boolean recapitiPrevalorizzati) {
		this.recapitiPrevalorizzati = recapitiPrevalorizzati;
	}
	public Lingua getLinguaPrimaria() {
		return linguaPrimaria;
	}
	public void setLinguaPrimaria(Lingua linguaPrimaria) {
		this.linguaPrimaria = linguaPrimaria;
	}
	public Lingua getLinguaSecondaria() {
		return linguaSecondaria;
	}
	public void setLinguaSecondaria(Lingua linguaSecondaria) {
		this.linguaSecondaria = linguaSecondaria;
	}
	public String getModalitaColloquio() {
		return modalitaColloquio;
	}
	public void setModalitaColloquio(String modalitaColloquio) {
		this.modalitaColloquio = modalitaColloquio;
	}
	public String getLingueLbl() {
		String ret = "";
		if (linguaPrimaria != null)
			ret = linguaPrimaria.getNome();
		if (linguaSecondaria != null)
			ret += (linguaPrimaria != null ? "<br/>" : "") + linguaSecondaria.getNome();
		return ret;
	}
	
	public List<String[]> getElencoRegoleEspanseOld() {
		List<String[]> l = new ArrayList<String[]>();
		for (RegolaOfferta ro: regole)
		{
			if (ro.isTuttiCorsi())
			{
				for (RegolaOffertaTipoCds rotc: ro.getTipiCds())
				{
					String txt = "Tutti i corsi di " + rotc.getTipoCdsOfferta().getDescrizione() + " per iscritti al ";
					if (Common.CH_S.equals(rotc.getFlagAnno1()))
						txt += "1" + ((char)176) +" ";
					if (Common.CH_S.equals(rotc.getFlagAnno2()))
						txt += "2" + ((char)176) +" ";
					if (Common.CH_S.equals(rotc.getFlagAnno3()))
						txt += "3" + ((char)176) +" ";
					if (Common.CH_S.equals(rotc.getFlagAnno4()))
						txt += "4" + ((char)176) +" ";
					if (Common.CH_S.equals(rotc.getFlagAnno5()))
						txt += "5" + ((char)176) +" ";
					// il sesto anno lo visualizziamo solo per medicina
					if ((ro.getFacolta() != null && ro.getFacolta().getId().equals("0065") && Common.CH_S.equals(rotc.getFlagAnno6())) || (ro.getVicepresidenza() != null && ro.getVicepresidenza().getId().equals(15L) && Common.CH_S.equals(rotc.getFlagAnno6())))
						txt += "6" + ((char)176) +" ";
					txt += "anno";
					if (rotc.getTipoCdsOfferta().getSigla().equals("Dott"))
						l.add(new String[]{"Dottorati", txt});
					else
						l.add(new String[]{ro.getFacolta() != null ? ro.getFacolta().getDescFac() : ro.getVicepresidenza() != null ? ro.getVicepresidenza().getDescrizione() : ro.getDipartimento() != null ? ro.getDipartimento().getDescrizione() : "", txt});
				}
			}
			else
			{
				for (RegolaOffertaCorso roc: ro.getCorsi())
				{
					String txt = "Corso " + roc.getCorsoDesc() + " - Anni di iscrizione: ";
					for (RegolaOffertaTipoCds rotc: ro.getTipiCds())
						if (roc.getCorso().getSiglaTipoCds().equals(rotc.getTipoCdsOfferta().getSigla()))
						{
							if (Common.CH_S.equals(rotc.getFlagAnno1()))
								txt += "1" + ((char)176) +" ";
							if (Common.CH_S.equals(rotc.getFlagAnno2()))
								txt += "2" + ((char)176) +" ";
							if (Common.CH_S.equals(rotc.getFlagAnno3()))
								txt += "3" + ((char)176) +" ";
							if (Common.CH_S.equals(rotc.getFlagAnno4()))
								txt += "4" + ((char)176) +" ";
							if (Common.CH_S.equals(rotc.getFlagAnno5()))
								txt += "5" + ((char)176) +" ";
							// il sesto anno lo visualizziamo solo per medicina
							if ((ro.getFacolta() != null && ro.getFacolta().getId().equals("0065") && Common.CH_S.equals(rotc.getFlagAnno6())) || (ro.getVicepresidenza() != null && ro.getVicepresidenza().getId().equals(15L) && Common.CH_S.equals(rotc.getFlagAnno6())))
								txt += "6" + ((char)176) +" "; 
						}							
					l.add(new String[]{ro.getFacolta() != null ? ro.getFacolta().getDescFac() : ro.getVicepresidenza() != null ? ro.getVicepresidenza().getDescrizione() : ro.getDipartimento() != null ? ro.getDipartimento().getDescrizione() : "", txt});
				}
			}
		}
		Collections.sort(l, new StringArrComparator());
		return l;
	}
	
	private static class StringArrComparator implements Comparator<String[]>
	{
		public int compare(String[] o1, String[] o2) {
			if (o1 == null && o2 == null)
				return 0;
			if (o1 == null)
				return 1;
			if (o2 == null)
				return -1;
			if (o1[0].equals(o2[0]))
				return o1[1].compareTo(o2[1]);
			return o1[0].compareTo(o2[0]);
		}
	}

	public String getAltreNoteStudenti() {
		return altreNoteStudenti;
	}
	public void setAltreNoteStudenti(String altreNoteStudenti) {
		this.altreNoteStudenti = altreNoteStudenti;
	}
	public String getAltreNoteStudentiEn() {
		return altreNoteStudentiEn;
	}
	public void setAltreNoteStudentiEn(String altreNoteStudentiEn) {
		this.altreNoteStudentiEn = altreNoteStudentiEn;
	}

	// solo lettrura : se manca il locale En torna quello It
	public String getAltreNoteStudentiEnDefaultIfEmpty() {
		return StringUtils.isBlank(altreNoteStudentiEn)?altreNoteStudenti:altreNoteStudentiEn;
	}
	// solo lettrura : se manca il locale En torna quello It
	public String getAltreNoteStudentiItDefaultIfEmpty() {
		return (StringUtils.isBlank(altreNoteStudenti)&&(!StringUtils.isBlank(altreNoteStudentiEn))) ? altreNoteStudentiEn : altreNoteStudenti;
	}
	
	public boolean isNotBlankAltreNoteStudenti(){
		return 	StringUtils.isNotBlank(altreNoteStudenti) || StringUtils.isNotBlank(altreNoteStudentiEn);
	}
	
	public boolean isAnnualizzazioneRinnovata() {
		if (getFlussoScambioEsecuzione() != null && getFlussoScambioEsecuzione().getScambioEsecuzione() != null && getFlussoScambioEsecuzione().getScambioEsecuzione().getEsecuzioneAccordo() != null
				&& getFlussoScambioEsecuzione().getScambioEsecuzione().getEsecuzioneAccordo().isRinnovato())
			return true;
		return false;
	}
	
	public boolean isAnnualizzazioneInRinnovo() {
		if (getFlussoScambioEsecuzione() != null && getFlussoScambioEsecuzione().getScambioEsecuzione() != null && getFlussoScambioEsecuzione().getScambioEsecuzione().getEsecuzioneAccordo() != null
				&& getFlussoScambioEsecuzione().getScambioEsecuzione().getEsecuzioneAccordo().isInRinnovo())
			return true;
		return false;
	}

	public Character getFlagAttiva() {
		return flagAttiva == null ? new Character('S') : flagAttiva;
	}

	public void setFlagAttiva(Character flagAttiva) {
		this.flagAttiva = flagAttiva;
	}

	@Deprecated
	public boolean isAttiva() {
		return !(new Character('N')).equals(flagAttiva);
	}
	// sostituisce il precedente;
	public boolean isAttivabileSuRibando() {
		return !(new Character('N')).equals(flagAttiva);
	}

	public String getAreaDisciplinareLabel() {
		if (flussoScambioEsecuzione != null 
				&& flussoScambioEsecuzione.getAreaDisciplinare() != null )
			return flussoScambioEsecuzione.getAreaDisciplinare().getDescrizione();
		return "";
	}
	public Character getFlagAperturaATutteLeFacolta() {
		if (flagAperturaATutteLeFacolta == null)
			return 'N';
		return flagAperturaATutteLeFacolta;
	}
	public void setFlagAperturaATutteLeFacolta(Character flagAperturaATutteLeFacolta) {
		this.flagAperturaATutteLeFacolta = flagAperturaATutteLeFacolta;
	}
	
	public boolean isApertaATutteLeFacolta() {
		return Common.CH_S.equals(getFlagAperturaATutteLeFacolta());
	}
	public Long getIdCopiataDa() {
		return idCopiataDa;
	}
	public void setIdCopiataDa(Long idCopiataDa) {
		this.idCopiataDa = idCopiataDa;
	}
	public boolean isCopiataDa(){
		return idCopiataDa!=null;
	}
	
	public Character getFlagPredefinita() {
		if (flagPredefinita == null)
			return 'S';
		return flagPredefinita;
	}
	public void setFlagPredefinita(Character flagPredefinita) {
		this.flagPredefinita = flagPredefinita;
	}
	public boolean isPredefinita() {
		return Common.CH_S.equals(getFlagPredefinita());
	}
	public TirocinioErasmusPlacement getTirocinioErasmusPlacement() {
		return tirocinioErasmusPlacement;
	}
	public void setTirocinioErasmusPlacement(
			TirocinioErasmusPlacement tirocinioErasmusPlacement) {
		this.tirocinioErasmusPlacement = tirocinioErasmusPlacement;
	}
	
	public String getDurataLabel() {
		if (getFlussoScambioEsecuzione() != null && getFlussoScambioEsecuzione().getDurata() != null && getFlussoScambioEsecuzione().getUnitaMisuraDurata() != null)
			return getFlussoScambioEsecuzione().getDurata().toString() + " " + getFlussoScambioEsecuzione().getUnitaMisuraDurata().getUnita();
		return "";
	}
	
	public PeriodoMobilita getPeriodoMobilita() {
		return getFlussoScambioEsecuzione().getScambioEsecuzione().getEsecuzioneAccordo().getPeriodoMobilita();
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public Long getIdAutoreInserimento() {
		return idAutoreInserimento;
	}
	public void setIdAutoreInserimento(Long idAutoreInserimento) {
		this.idAutoreInserimento = idAutoreInserimento;
	}
	public Character getFlagCancellata() {
		return flagCancellata;
	}
	public void setFlagCancellata(Character flagCancellata) {
		this.flagCancellata = flagCancellata;
	}
	public boolean isCancellata(){
		return Common.CH_S.equals(flagCancellata);
	}
	public boolean isProposta(){
		return "proposta".equals(getStato());
	}
	public Date getDataAttivazione() {
		return dataAttivazione;
	}
	public void setDataAttivazione(Date dataAttivazione) {
		this.dataAttivazione = dataAttivazione;
	}
	public Long getIdAutoreAttivazione() {
		return idAutoreAttivazione;
	}
	public void setIdAutoreAttivazione(Long idAutoreAttivazione) {
		this.idAutoreAttivazione = idAutoreAttivazione;
	}
	public Long getIdAutoreUltimaModifica() {
		return idAutoreUltimaModifica;
	}
	public void setIdAutoreUltimaModifica(Long idAutoreUltimaModifica) {
		this.idAutoreUltimaModifica = idAutoreUltimaModifica;
	}
	public GestioneOfferta getGestioneOfferta() {
		return gestioneOfferta;
	}
	public void setGestioneOfferta(GestioneOfferta gestioneOfferta) {
		this.gestioneOfferta = gestioneOfferta;
	}

	public GestioneOfferta addGestioneOfferta(){
		if (getGestioneOfferta() == null) {
			GestioneOfferta go = new  GestioneOfferta();
			go.setOfferta(this);
			this.setGestioneOfferta(go);
		}
		return getGestioneOfferta();
	}
	public MultipartFile getFileAllegato() {
		return fileAllegato;
	}
	public void setFileAllegato(MultipartFile fileAllegato) {
		this.fileAllegato = fileAllegato;
	}
}
