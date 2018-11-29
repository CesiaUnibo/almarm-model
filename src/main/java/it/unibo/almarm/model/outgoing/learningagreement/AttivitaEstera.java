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
import it.unibo.almarm.util.Common;

import java.util.Comparator;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class AttivitaEstera implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private AttivitaEstera attivitaPrecedente;
	private String descrizione;
	private Float ectsProposti;
	private String votoConseguito;
	private Date dataConseguito;
	private Character flagRiconosciuta;
	private Integer votoRiconosciuto;
	private Float ectsRiconosciuti;
	private Persona autoreRiconoscimento;
	private Date dataRiconoscimento;
	private String noteRiconoscimento;
	private Character flagSvolta;
	private Character flagAggiuntaInRichiestaRiconoscimento;
	private Integer order;
	private String idAllegato;
	private String nomeAllegato;
	private Semestre semestre;
	private Character flagCopiataDaVersioneLaPrecedente;
	private String motivazioneModifica;
	private Character flagCancellata;
	
	private BloccoAttivita bloccoAttivita;
	
	// campi non persistiti
	private boolean attiva;
	private transient MultipartFile allegato;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AttivitaEstera getAttivitaPrecedente() {
		return attivitaPrecedente;
	}

	public void setAttivitaPrecedente(AttivitaEstera attivitaPrecedente) {
		this.attivitaPrecedente = attivitaPrecedente;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = StringUtils.trim(descrizione);
	}

	public Float getEctsProposti() {
		return ectsProposti;
	}
	
	public String getEctsPropostiString() {
		return Common.convertFloatToString(ectsProposti);
	}

	public void setEctsProposti(Float ectsProposti) {
		this.ectsProposti = ectsProposti;
	}

	public String getVotoConseguito() {
		return votoConseguito;
	}

	public void setVotoConseguito(String votoConseguito) {
		this.votoConseguito = votoConseguito;
	}

	public Date getDataConseguito() {
		return dataConseguito;
	}

	public void setDataConseguito(Date dataConseguito) {
		this.dataConseguito = dataConseguito;
	}

	public Character getFlagRiconosciuta() {
		if (flagRiconosciuta == null)
			return 'N';
		return flagRiconosciuta;
	}

	public void setFlagRiconosciuta(Character flagRiconosciuta) {
		this.flagRiconosciuta = flagRiconosciuta;
	}

	public Integer getVotoRiconosciuto() {
		return votoRiconosciuto;
	}

	public void setVotoRiconosciuto(Integer votoRiconosciuto) {
		this.votoRiconosciuto = votoRiconosciuto;
	}

	public Float getEctsRiconosciuti() {
		return ectsRiconosciuti;
	}

	public void setEctsRiconosciuti(Float ectsRiconosciuti) {
		this.ectsRiconosciuti = ectsRiconosciuti;
	}

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
		String ects = ectsRiconosciuti != null ? Common.convertFloatToString(ectsRiconosciuti) : (ectsProposti != null ? Common.convertFloatToString(ectsProposti) : "");
		String lblEcts = getBloccoAttivita() != null ? getBloccoAttivita().getLabelEcts() : "";
		return descrizione + (StringUtils.isNotBlank(ects) ? " - " + ects + " " + lblEcts : "");
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
		String l = "";
		boolean barrato = false;
		if (isAggiuntaInRichiestaRiconoscimento())
			l += " - Attività non presente in LA";
		if (isNonSvolta())
		{
			l += " - Attività non svolta";
			barrato = true;
		}
		else if (isDaNonRiconoscere())
		{
			l += " - Lo studente non richiede il riconoscimento";
			barrato = true;
		}
		else 
		{
			if (getVotoConseguito() != null)
				l += " - Voto: " + getVotoConseguito();
			if (getDataConseguito() != null)
				l += " - Data: " + Common.getDataFormattata(getDataConseguito());
		}
		String r = barrato ? "<span style=\"text-decoration: line-through;\">" + getLabel() + "</span>" : getLabel();
		return r + l;
	}

	public boolean isAttiva() {
		return attiva;
	}

	public void setAttiva(boolean attiva) {
		this.attiva = attiva;
	}
	
	public static class AttivitaEsteraComparator implements Comparator<AttivitaEstera>
	{
		public int compare(AttivitaEstera o1, AttivitaEstera o2) {
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

	public BloccoAttivita getBloccoAttivita() {
		return bloccoAttivita;
	}

	public void setBloccoAttivita(BloccoAttivita bloccoAttivita) {
		this.bloccoAttivita = bloccoAttivita;
	}
	
	public AttivitaEstera copy() {
		AttivitaEstera ae = new AttivitaEstera();
		ae.setAttivitaPrecedente(this);
		ae.setAutoreRiconoscimento(autoreRiconoscimento);
		ae.setDataConseguito(dataConseguito);
		ae.setDataRiconoscimento(dataRiconoscimento);
		ae.setDescrizione(descrizione);
		ae.setEctsProposti(ectsProposti);
		ae.setEctsRiconosciuti(ectsRiconosciuti);
		ae.setFlagRiconosciuta(flagRiconosciuta);
		ae.setNoteRiconoscimento(noteRiconoscimento);
		ae.setVotoConseguito(votoConseguito);
		ae.setVotoRiconosciuto(votoRiconosciuto);
		ae.setFlagSvolta(flagSvolta);
		ae.setFlagAggiuntaInRichiestaRiconoscimento(flagAggiuntaInRichiestaRiconoscimento);
		ae.setOrder(order);
		ae.setSemestre(semestre);
		if (this.getBloccoAttivita().getLearningAgreement().isApprovato())
			ae.setFlagCopiataDaVersioneLaPrecedente('S');
		else
		{
			ae.setFlagCopiataDaVersioneLaPrecedente(this.getFlagCopiataDaVersioneLaPrecedente());
			ae.setFlagCancellata(this.getFlagCancellata());
			ae.setMotivazioneModifica(this.getMotivazioneModifica());
		}
		return ae;
	}

	public Character getFlagSvolta() {
		if (flagSvolta == null)
			return Common.CH_D;
		return flagSvolta;
	}

	public void setFlagSvolta(Character flagSvolta) {
		this.flagSvolta = flagSvolta;
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
	
	public String getSvolgimentoLabel() {
		switch (getFlagSvolta()) {
		case 'D':
			return " ";
		case 'S':
			return "si, da riconoscere";
		case 'V':
			return "si, da non riconoscere";
		case 'N':
			return "no";
		}
		return "";
	}
	
	public boolean isNonSvolta() {
		return Common.CH_N.equals(getFlagSvolta());
	}
	
	public boolean isDaNonRiconoscere() {
		return Common.CH_V.equals(getFlagSvolta());
	}
	
	public boolean isDaRiconoscere() {
		return Common.CH_S.equals(getFlagSvolta());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		if (id == null)
		{
			result = prime * result
					+ ((descrizione == null) ? 0 : descrizione.hashCode());
			result = prime * result
					+ ((ectsProposti == null) ? 0 : ectsProposti.hashCode());
			return result;
		}
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AttivitaEstera))
			return false;
		AttivitaEstera other = (AttivitaEstera) obj;
		if (id != null)
			return id.equals(other.getId());
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (ectsProposti == null) {
			if (other.ectsProposti != null)
				return false;
		} else if (!ectsProposti.equals(other.ectsProposti))
			return false;
		return true;
	}
	
	// Ritorna una copia identica dell'attivita' a meno degli ID. Utilizzato per storicizzazione
	public AttivitaEstera clona() {
		AttivitaEstera clone = new AttivitaEstera();
		
		clone.setAttivitaPrecedente(this.getAttivitaPrecedente());
		clone.setDescrizione(this.getDescrizione());
		clone.setEctsProposti(this.getEctsProposti());
		clone.setVotoConseguito(this.getVotoConseguito());
		clone.setDataConseguito(this.getDataConseguito());
		clone.setFlagRiconosciuta(this.getFlagRiconosciuta());
		clone.setVotoRiconosciuto(this.getVotoRiconosciuto());
		clone.setEctsRiconosciuti(this.getEctsRiconosciuti());
		clone.setAutoreRiconoscimento(this.getAutoreRiconoscimento());
		clone.setDataRiconoscimento(this.getDataRiconoscimento());
		clone.setNoteRiconoscimento(this.getNoteRiconoscimento());
		clone.setFlagSvolta(this.getFlagSvolta());
		clone.setFlagAggiuntaInRichiestaRiconoscimento(this.getFlagAggiuntaInRichiestaRiconoscimento());
		clone.setOrder(this.getOrder());
		clone.setSemestre(this.getSemestre());
		clone.setFlagCopiataDaVersioneLaPrecedente(this.getFlagCopiataDaVersioneLaPrecedente());
		clone.setMotivazioneModifica(this.getMotivazioneModifica());
		clone.setFlagCancellata(this.getFlagCancellata());
		
		clone.setBloccoAttivita(this.getBloccoAttivita());
		
		return clone;
	}

	public String getIdAllegato() {
		return idAllegato;
	}

	public void setIdAllegato(String idAllegato) {
		this.idAllegato = idAllegato;
	}

	public String getNomeAllegato() {
		return nomeAllegato;
	}

	public void setNomeAllegato(String nomeAllegato) {
		this.nomeAllegato = nomeAllegato;
	}

	public MultipartFile getAllegato() {
		return allegato;
	}

	public void setAllegato(MultipartFile allegato) {
		this.allegato = allegato;
	}
	
	public String getSemestreLabel() {
		if (getSemestre() != null)
			return getSemestre().getNomeIng();
		return "";
	}

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
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
}
