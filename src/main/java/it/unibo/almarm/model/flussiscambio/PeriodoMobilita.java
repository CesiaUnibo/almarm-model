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
package it.unibo.almarm.model.flussiscambio;

import it.unibo.almarm.util.Common;

import java.util.Comparator;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class PeriodoMobilita  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	public static Long ID_PERIODO_FINE_FACOLTA = 3L;
	public static Long ID_PERIODO_INIZIO_CONTRATTO_PARTNER_ERASMUS = 5L;
	public static Long ID_PERIODO_FINE_MODIFICA_SCAMBI_SU_ANNUALIZZ_ERASMUS = 3L;
	public static Long ID_PERIODO_FINE_DATI_INVIO_RINNOVO_SU_ANNUALIZZAZIONI = 3L;
	
	private Long id;
	private Date dataInizio;
	private Date dataFine;
	private Long durata;
	private Integer annoAccademico;
	private String nome;
	private Character flagCreaAnnualizzazione;
	private PeriodoMobilita periodoMobilitaPrecedente;
	private Character flagProroghe;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Long getDurata() {
		return durata;
	}
	public void setDurata(Long durata) {
		this.durata = durata;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Character getFlagCreaAnnualizzazione() {
		return flagCreaAnnualizzazione;
	}
	
	public void setFlagCreaAnnualizzazione(Character flagCreaAnnualizzazione) {
		this.flagCreaAnnualizzazione = flagCreaAnnualizzazione;
	}
	
	public boolean isCreaAnnualizzazione()	{
		return Common.CH_S.equals(flagCreaAnnualizzazione);
	}
	
	public PeriodoMobilita getPeriodoMobilitaPrecedente() {
		return periodoMobilitaPrecedente;
	}
	
	public void setPeriodoMobilitaPrecedente(
			PeriodoMobilita periodoMobilitaPrecedente) {
		this.periodoMobilitaPrecedente = periodoMobilitaPrecedente;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataInizio == null) ? 0 : dataInizio.hashCode());
		result = prime * result
				+ ((dataFine == null) ? 0 : dataFine.hashCode());
		result = prime * result + ((durata == null) ? 0 : durata.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof PeriodoMobilita))
			return false;
		PeriodoMobilita other = (PeriodoMobilita) obj;
		if (dataInizio == null) {
			if (other.getDataInizio() != null)
				return false;
		} else if (!dataInizio.equals(other.getDataInizio()))
			return false;
		if (dataFine == null) {
			if (other.getDataFine() != null)
				return false;
		} else if (!dataFine.equals(other.getDataFine()))
			return false;
		if (durata == null) {
			if (other.getDurata() != null)
				return false;
		} else if (!durata.equals(other.getDurata()))
			return false;
		return true;
	}
	
	public String getLabel() {
		return nome;
	}
	public Integer getAnnoAccademico() {
		return annoAccademico;
	}
	public void setAnnoAccademico(Integer annoAccademico) {
		this.annoAccademico = annoAccademico;
	}
	
	public String getAnnoAccademicoLabel() {
		return getAALabel(annoAccademico);
	}

	public String getAnnoAccademicoLabelCorta() {
		return getAALabelCorta(annoAccademico);
	}

	private String getAALabel(Integer aa){
		return aa.toString() + " - " + new Integer(aa + 1).toString();
	}
	private String getAALabelCorta(Integer aa){
		return aa.toString() + "/" + StringUtils.substring((new Integer(aa + 1).toString()), 2);
	}
	
	public static class PeriodoMobilitaComparator  implements Comparator<PeriodoMobilita>
	{
		public int compare(PeriodoMobilita o1, PeriodoMobilita o2) {
			if (o1 == null && o2 == null)
				return 0;
			return o1.getAnnoAccademico().compareTo(o2.getAnnoAccademico());
		}
	}

	public static class PeriodoMobilitaComparatorDesc  implements Comparator<PeriodoMobilita>
	{
		public int compare(PeriodoMobilita o1, PeriodoMobilita o2) {
			if (o1 == null && o2 == null)
				return 0;
			return -1 * o1.getAnnoAccademico().compareTo(o2.getAnnoAccademico());
		}
	}
	
	public Character getFlagProroghe() {
		return flagProroghe;
	}
	public void setFlagProroghe(Character flagProroghe) {
		this.flagProroghe = flagProroghe;
	}
	public boolean isProroghe() {
		return Common.CH_S.equals(flagProroghe);
	}
	
	public Integer getAnnoAccademocpPrecedente(){
		return annoAccademico==null ? null : new Integer(annoAccademico.intValue() - 1); 
	}
	public String getAnnoAccademicoPrecedenteLabel() {
		return getAALabel(getAnnoAccademocpPrecedente());
	}

	public String getAnnoAccademicoPrecedenteLabelCorta() {
		return getAALabelCorta(getAnnoAccademocpPrecedente());
	}

	public boolean isPeriodoCanonicoIscrizioniTerminato() {
		boolean terminato = true;
		if (getAnnoAccademico()!=null) {
			terminato = Common.isPeriodoCanonicoIscrizioniDidatticaTerminato(getAnnoAccademico());
		}
		return terminato;
	}

	public boolean isPeriodoCanonicoIscrizioniAAPrecAperto(){
		Integer aaPrec = getAnnoAccademocpPrecedente();
		return aaPrec == null ? false : Common.isPeriodoCanonicoIscrizioniDidatticaAperto(aaPrec);
	}
}
