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
import it.unibo.almarm.model.attori.Ateneo;
import it.unibo.almarm.model.attori.Campus;
import it.unibo.almarm.model.attori.Persona;
import it.unibo.almarm.model.attori.Struttura;
import it.unibo.almarm.model.luoghi.Nazione;
import it.unibo.almarm.util.Common;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

public class StudenteIncomingView implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Persona persona;
	private Ateneo ateneo;
	private Nazione nazioneAteneo;
	private SottoProgramma sottoProgramma;
	private AccordoOperativo accordoOperativo;
	private Campus campus;
	private String nome;
	private String cognome;
	private String matricola;
	private String codiceErasmusAteneo;
	private String nomeAteneo;
	private String stato;
	private Character flagProlungamento;
	private Date dataRegistrazione;
	private String codFac;
	private String cognomeReferenteInterno;
	private Character flagRinuncia;
	private Date dataArrivo;
	private Long idPeriodo;
	private Character flagDottorato;
	private String codiceErasmusAteneoProvenienza;
	private String ateneoProvenienza;
	private TipoMobilita tipoMobilita;
	private Nazione nazioneAteneoProvenienza;
	private Struttura strutturaAppartenenza;
	private Long idReferenteInterno;
	private String areaDisciplinare;
	private Long idNomina;
	private Integer annoAccademico;
	
	private Set<ReferenteIncomingView> referentiIncoming = new HashSet<ReferenteIncomingView>();
	
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

	public Ateneo getAteneo() {
		return ateneo;
	}

	public void setAteneo(Ateneo ateneo) {
		this.ateneo = ateneo;
	}

	public Nazione getNazioneAteneo() {
		return nazioneAteneo;
	}

	public void setNazioneAteneo(Nazione nazioneAteneo) {
		this.nazioneAteneo = nazioneAteneo;
	}

	public SottoProgramma getSottoProgramma() {
		return sottoProgramma;
	}

	public void setSottoProgramma(SottoProgramma sottoProgramma) {
		this.sottoProgramma = sottoProgramma;
	}

	public Campus getCampus() {
		return campus;
	}

	public void setCampus(Campus campus) {
		this.campus = campus;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getCodiceErasmusAteneo() {
		return codiceErasmusAteneo;
	}

	public void setCodiceErasmusAteneo(String codiceErasmusAteneo) {
		this.codiceErasmusAteneo = codiceErasmusAteneo;
	}

	public String getNomeAteneo() {
		return nomeAteneo;
	}

	public void setNomeAteneo(String nomeAteneo) {
		this.nomeAteneo = nomeAteneo;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public Character getFlagProlungamento() {
		return flagProlungamento;
	}

	public void setFlagProlungamento(Character flagProlungamento) {
		this.flagProlungamento = flagProlungamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof StudenteIncomingView))
			return false;
		StudenteIncomingView other = (StudenteIncomingView) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public String getAteneoLabel() {
		String citta = ateneo.getSedeLegale() != null && ateneo.getSedeLegale().getLocalita() != null ? ateneo.getSedeLegale().getLocalita().getLocalita() : "";
		return StringUtils.defaultIfEmpty(codiceErasmusAteneo, "") + " - " + StringUtils.defaultIfEmpty(nomeAteneo, "") + "<br/>" + citta + " - " + StringUtils.defaultIfEmpty(nazioneAteneo.getNazione(), "");
	}
	
	public String getColor() {
		if (isRinuncia())
			return "Red";
		StatoStudenteIncoming ssi = StatoStudenteIncoming.get(getStato());
		if (ssi != null)
			return ssi.getColor();
		return "White";
	}
	
	public String getColorDesc() {
		if (isRinuncia())
			return "Lo studente ha rinunciato";
		StatoStudenteIncoming ssi = StatoStudenteIncoming.get(getStato());
		if (ssi != null)
			return ssi.getValore();
		return "";
	}

	public AccordoOperativo getAccordoOperativo() {
		return accordoOperativo;
	}

	public void setAccordoOperativo(AccordoOperativo accordoOperativo) {
		this.accordoOperativo = accordoOperativo;
	}

	public Date getDataRegistrazione() {
		return dataRegistrazione;
	}

	public void setDataRegistrazione(Date dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
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
	
	public Character getFlagRinuncia() {
		if (flagRinuncia == null)
			return 'N';
		return flagRinuncia;
	}
	
	public void setFlagRinuncia(Character flagRinuncia) {
		this.flagRinuncia = flagRinuncia;
	}
	
	public boolean isRinuncia() {
		return (new Character('S')).equals(flagRinuncia);
	}

	public Date getDataArrivo() {
		return dataArrivo;
	}

	public void setDataArrivo(Date dataArrivo) {
		this.dataArrivo = dataArrivo;
	}

	public Long getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(Long idPeriodo) {
		this.idPeriodo = idPeriodo;
	}
	
	public Character getFlagDottorato() {
		if (flagDottorato == null)
			return 'N';
		return flagDottorato;
	}
	
	public void setFlagDottorato(Character flagDottorato) {
		this.flagDottorato = flagDottorato;
	}
	
	public boolean isDottorato() {
		return Common.CH_S.equals(getFlagDottorato());
	}

	public String getAteneoProvenienza() {
		return ateneoProvenienza;
	}

	public void setAteneoProvenienza(String ateneoProvenienza) {
		this.ateneoProvenienza = ateneoProvenienza;
	}

	public String getCodiceErasmusAteneoProvenienza() {
		return codiceErasmusAteneoProvenienza;
	}

	public void setCodiceErasmusAteneoProvenienza(
			String codiceErasmusAteneoProvenienza) {
		this.codiceErasmusAteneoProvenienza = codiceErasmusAteneoProvenienza;
	}

	public Nazione getNazioneAteneoProvenienza() {
		return nazioneAteneoProvenienza;
	}

	public void setNazioneAteneoProvenienza(Nazione nazioneAteneoProvenienza) {
		this.nazioneAteneoProvenienza = nazioneAteneoProvenienza;
	}

	public TipoMobilita getTipoMobilita() {
		return tipoMobilita;
	}

	public void setTipoMobilita(TipoMobilita tipoMobilita) {
		this.tipoMobilita = tipoMobilita;
	}

	public Struttura getStrutturaAppartenenza() {
		return strutturaAppartenenza;
	}

	public void setStrutturaAppartenenza(Struttura strutturaAppartenenza) {
		this.strutturaAppartenenza = strutturaAppartenenza;
	}

	public Long getIdReferenteInterno() {
		return idReferenteInterno;
	}

	public void setIdReferenteInterno(Long idReferenteInterno) {
		this.idReferenteInterno = idReferenteInterno;
	}

	public String getAreaDisciplinare() {
		return areaDisciplinare;
	}

	public void setAreaDisciplinare(String areaDisciplinare) {
		this.areaDisciplinare = areaDisciplinare;
	}
	
	public Long getIdNomina() {
		return idNomina;
	}

	public void setIdNomina(Long idNomina) {
		this.idNomina = idNomina;
	}

	public Set<ReferenteIncomingView> getReferentiIncoming() {
		return referentiIncoming;
	}

	public void setReferentiIncoming(Set<ReferenteIncomingView> referentiIncoming) {
		this.referentiIncoming = referentiIncoming;
	}

	public Integer getAnnoAccademico() {
		return annoAccademico;
	}

	public void setAnnoAccademico(Integer annoAccademico) {
		this.annoAccademico = annoAccademico;
	}

	public  String getAnnoAccLabelCorta() {
		return /*"A.A. " +*/ Common.getAALabelCorta(annoAccademico);
	}
}
