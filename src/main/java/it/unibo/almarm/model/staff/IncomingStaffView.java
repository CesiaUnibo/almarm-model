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

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import it.unibo.almarm.util.Common;

public class IncomingStaffView implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String cognome;
	private String nome;
	private Long idPartner;
	private String partnerDesc;
	private Long idNazione;
	private String nazioneDesc;
	private Date dataArrivo;
	private Date dataPartenza;
	private Character flagDataArrivoPrevista;
	private Character flagDataPartenzaPrevista;
	private Long durata;
	private Long idUnitaMisuraDurata;
	private String unitaMisuraDurata;
	private Long idReferenteInterno;
	private String cognomeReferenteInterno;
	private String nomeReferenteInterno;
	private Long idStrutturaOspitante;
	private String nomeStrutturaOspitante;
	private String stato;
	private Date dataDa;
	private Date dataA;
	private Character flagModificabileInAppStaff;
	private Long idDipartimento;
	private String nomeTipoMobilita;
	private String descrizioneMobilitaVisiting;
	private Date dataArrivoPerOrdinamento;
	private Long idAnagrafica;
    private Character flagHaGiaAssicurazione;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
	
	public String getNomeCognome() {
		return getNome() + " " + getCognome();
	}

	public Long getIdPartner() {
		return idPartner;
	}

	public void setIdPartner(Long idPartner) {
		this.idPartner = idPartner;
	}

	public String getPartnerDesc() {
		return partnerDesc;
	}

	public void setPartnerDesc(String partnerDesc) {
		this.partnerDesc = partnerDesc;
	}
	
	public Long getIdNazione() {
		return idNazione;
	}

	public void setIdNazione(Long idNazione) {
		this.idNazione = idNazione;
	}

	public String getNazioneDesc() {
		return nazioneDesc;
	}

	public void setNazioneDesc(String nazioneDesc) {
		this.nazioneDesc = nazioneDesc;
	}
	
	public String getNomeNazionePartner() {
		return getPartnerDesc() + " - " + getNazioneDesc();
	}

	public Date getDataArrivo() {
		return dataArrivo;
	}

	public void setDataArrivo(Date dataArrivo) {
		this.dataArrivo = dataArrivo;
	}

	public Date getDataPartenza() {
		return dataPartenza;
	}

	public void setDataPartenza(Date dataPartenza) {
		this.dataPartenza = dataPartenza;
	}

	public Character getFlagDataArrivoPrevista() {
		return flagDataArrivoPrevista;
	}

	public void setFlagDataArrivoPrevista(Character flagDataArrivoPrevista) {
		this.flagDataArrivoPrevista = flagDataArrivoPrevista;
	}
	
	public boolean isDataArrivoPrevista() {
		return Common.CH_S.equals(getFlagDataArrivoPrevista());
	}

	public Character getFlagDataPartenzaPrevista() {
		return flagDataPartenzaPrevista;
	}

	public void setFlagDataPartenzaPrevista(Character flagDataPartenzaPrevista) {
		this.flagDataPartenzaPrevista = flagDataPartenzaPrevista;
	}
	
	public boolean isDataPartenzaPrevista() {
		return Common.CH_S.equals(getFlagDataPartenzaPrevista());
	}

	public Long getDurata() {
		return durata;
	}

	public void setDurata(Long durata) {
		this.durata = durata;
	}

	public Long getIdUnitaMisuraDurata() {
		return idUnitaMisuraDurata;
	}

	public void setIdUnitaMisuraDurata(Long idUnitaMisuraDurata) {
		this.idUnitaMisuraDurata = idUnitaMisuraDurata;
	}
	
	public String getUnitaMisuraDurata() {
		return unitaMisuraDurata;
	}

	public void setUnitaMisuraDurata(String unitaMisuraDurata) {
		this.unitaMisuraDurata = unitaMisuraDurata;
	}

	public Long getIdReferenteInterno() {
		return idReferenteInterno;
	}

	public void setIdReferenteInterno(Long idReferenteInterno) {
		this.idReferenteInterno = idReferenteInterno;
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

	public String getNomeCognomeReferenteInterno() {
		return StringUtils.join(new String[]{getNomeReferenteInterno(), " ", getCognomeReferenteInterno()});
	}
	
	public Long getIdStrutturaOspitante() {
		return idStrutturaOspitante;
	}

	public void setIdStrutturaOspitante(Long idStrutturaOspitante) {
		this.idStrutturaOspitante = idStrutturaOspitante;
	}

	public String getNomeStrutturaOspitante() {
		return nomeStrutturaOspitante;
	}

	public void setNomeStrutturaOspitante(String nomeStrutturaOspitante) {
		this.nomeStrutturaOspitante = nomeStrutturaOspitante;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}
	
	public String getColorStato() {
		/*if (isRinuncia())
			return "Red";*/
		StatoIncomingStaff ssi = StatoIncomingStaff.get(getStato());
		if (ssi != null)
			return ssi.getColor();
		return "White";
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
		if (!(obj instanceof IncomingStaffView))
			return false;
		IncomingStaffView other = (IncomingStaffView) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getDurataLabel() {
		String ret = "";
		if (dataArrivo != null)
			ret += "dal " + Common.getDataFormattata(dataArrivo) + " ";
		if (dataPartenza != null)
			ret += "al " + Common.getDataFormattata(dataPartenza);
		else if (durata != null) {
			ret += "per " + durata + " ";
			if (unitaMisuraDurata != null)
				ret += unitaMisuraDurata;
		}
		return ret;
	}

	public Date getDataDa() {
		return dataDa;
	}

	public void setDataDa(Date dataDa) {
		this.dataDa = dataDa;
	}

	public Date getDataA() {
		return dataA;
	}

	public void setDataA(Date dataA) {
		this.dataA = dataA;
	}

	public Character getFlagModificabileInAppStaff() {
		return flagModificabileInAppStaff;
	}

	public void setFlagModificabileInAppStaff(Character flagModificabileInAppStaff) {
		this.flagModificabileInAppStaff = flagModificabileInAppStaff;
	}
	
	public boolean isModificabileInAppStaff() {
		return Common.CH_S.equals(getFlagModificabileInAppStaff());
	}

	public Long getIdDipartimento() {
		return idDipartimento;
	}

	public void setIdDipartimento(Long idDipartimento) {
		this.idDipartimento = idDipartimento;
	}

	public String getNomeTipoMobilita() {
		return nomeTipoMobilita;
	}

	public void setNomeTipoMobilita(String nomeTipoMobilita) {
		this.nomeTipoMobilita = nomeTipoMobilita;
	}

	public String getDescrizioneMobilitaVisiting() {
		return descrizioneMobilitaVisiting;
	}

	public void setDescrizioneMobilitaVisiting(String descrizioneMobilitaVisiting) {
		this.descrizioneMobilitaVisiting = descrizioneMobilitaVisiting;
	}

	public Date getDataArrivoPerOrdinamento() {
		return dataArrivoPerOrdinamento;
	}

	public void setDataArrivoPerOrdinamento(Date dataArrivoPerOrdinamento) {
		this.dataArrivoPerOrdinamento = dataArrivoPerOrdinamento;
	}

	public Long getIdAnagrafica() {
		return idAnagrafica;
	}

	public void setIdAnagrafica(Long idAnagrafica) {
		this.idAnagrafica = idAnagrafica;
	}

    public Character getFlagHaGiaAssicurazione() {
        return flagHaGiaAssicurazione;
    }

    public void setFlagHaGiaAssicurazione(Character flagHaGiaAssicurazione) {
        this.flagHaGiaAssicurazione = flagHaGiaAssicurazione;
    }
}
