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
package it.unibo.almarm.model.staff;

import it.unibo.almarm.util.Common;

import java.io.Serializable;
import java.util.Arrays;

public class FlussiDocentiAttiviStaffView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id; // identificativo del flusso esecuzione
	private Long idPartner;
	private Character direzione;
	private Long posti;
	private Long durata;
	private Long idAreaDisciplinare;
	private String codiceAreaDisciplinare;
	private String descrizioneAreaDisciplinare;
	private Long idUnitaMisuraDurata;
	private String descrizioneUnitaMisuraDurata;
	private Long idSottoProgramma;
	private String descrizioneSottoProgramma;
	private Long annoAccademico;
	private Long idReferenteInterno;
	private String nomeCognomeReferenteInterno;
	private String nomeCognomeReferenteEsterno;
	private Character flagBloccoInserimentoIncoming;
	private Character flagTeachingProgrammeInserimentoIncoming;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdPartner() {
		return idPartner;
	}

	public void setIdPartner(Long idPartner) {
		this.idPartner = idPartner;
	}

	public Character getDirezione() {
		return direzione;
	}

	public void setDirezione(Character direzione) {
		this.direzione = direzione;
	}

	public Long getPosti() {
		return posti;
	}

	public void setPosti(Long posti) {
		this.posti = posti;
	}

	public Long getDurata() {
		return durata;
	}

	public void setDurata(Long durata) {
		this.durata = durata;
	}

	public Long getIdAreaDisciplinare() {
		return idAreaDisciplinare;
	}

	public void setIdAreaDisciplinare(Long idAreaDisciplinare) {
		this.idAreaDisciplinare = idAreaDisciplinare;
	}

	public String getCodiceAreaDisciplinare() {
		return codiceAreaDisciplinare;
	}

	public void setCodiceAreaDisciplinare(String codiceAreaDisciplinare) {
		this.codiceAreaDisciplinare = codiceAreaDisciplinare;
	}

	public String getDescrizioneAreaDisciplinare() {
		return descrizioneAreaDisciplinare;
	}

	public void setDescrizioneAreaDisciplinare(String descrizioneAreaDisciplinare) {
		this.descrizioneAreaDisciplinare = descrizioneAreaDisciplinare;
	}

	public Long getIdUnitaMisuraDurata() {
		return idUnitaMisuraDurata;
	}

	public void setIdUnitaMisuraDurata(Long idUnitaMisuraDurata) {
		this.idUnitaMisuraDurata = idUnitaMisuraDurata;
	}

	public String getDescrizioneUnitaMisuraDurata() {
		return descrizioneUnitaMisuraDurata;
	}

	public void setDescrizioneUnitaMisuraDurata(String descrizioneUnitaMisuraDurata) {
		this.descrizioneUnitaMisuraDurata = descrizioneUnitaMisuraDurata;
	}

	public Long getIdSottoProgramma() {
		return idSottoProgramma;
	}

	public void setIdSottoProgramma(Long idSottoProgramma) {
		this.idSottoProgramma = idSottoProgramma;
	}

	public String getDescrizioneSottoProgramma() {
		return descrizioneSottoProgramma;
	}

	public void setDescrizioneSottoProgramma(String descrizioneSottoProgramma) {
		this.descrizioneSottoProgramma = descrizioneSottoProgramma;
	}

	public Long getAnnoAccademico() {
		return annoAccademico;
	}

	public void setAnnoAccademico(Long annoAccademico) {
		this.annoAccademico = annoAccademico;
	}

	public String getNomeCognomeReferenteInterno() {
		return nomeCognomeReferenteInterno;
	}

	public void setNomeCognomeReferenteInterno(String nomeCognomeReferenteInterno) {
		this.nomeCognomeReferenteInterno = nomeCognomeReferenteInterno;
	}

	public Long getIdReferenteInterno() {
		return idReferenteInterno;
	}

	public void setIdReferenteInterno(Long idReferenteInterno) {
		this.idReferenteInterno = idReferenteInterno;
	}

	public String getNomeCognomeReferenteEsterno() {
		return nomeCognomeReferenteEsterno;
	}
	
	public void setNomeCognomeReferenteEsterno(String nomeCognomeReferenteEsterno) {
		this.nomeCognomeReferenteEsterno = nomeCognomeReferenteEsterno;
	}

	public Character getFlagBloccoInserimentoIncoming() {
		return flagBloccoInserimentoIncoming;
	}

	public void setFlagBloccoInserimentoIncoming(Character flagBloccoInserimentoIncoming) {
		this.flagBloccoInserimentoIncoming = flagBloccoInserimentoIncoming;
	}

	public boolean isBloccoInserimentoIncoming() {
		return Common.CH_S.equals(getFlagBloccoInserimentoIncoming());
	}

	public Character getFlagTeachingProgrammeInserimentoIncoming() {
		return flagTeachingProgrammeInserimentoIncoming !=null ? flagTeachingProgrammeInserimentoIncoming : Common.CH_N;
	}

	public void setFlagTeachingProgrammeInserimentoIncoming(Character flagTeachingProgramme) {
		this.flagTeachingProgrammeInserimentoIncoming = flagTeachingProgramme;
	}

	public boolean isTeachingProgrammeInserimentoIncomingPrevisto() {
		boolean previsto = false;
		if (getFlagTeachingProgrammeInserimentoIncoming()!=null) {
			if (Arrays.asList(Common.CH_S, Common.CH_O).contains(getFlagTeachingProgrammeInserimentoIncoming()))
				previsto = true;
		}
		return previsto;
	}

	public boolean isTeachingProgrammeInserimentoIncomingObbligatorio() {
		boolean obbligatorio = false;
		if (Common.CH_O.equals(getFlagTeachingProgrammeInserimentoIncoming()))
			obbligatorio = true;
		return obbligatorio;
	}
}
