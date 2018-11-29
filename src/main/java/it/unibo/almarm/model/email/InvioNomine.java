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
package it.unibo.almarm.model.email;

import java.util.Arrays;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class InvioNomine implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long idBando;
	private String testoBando;
	private Long idBandoPadre;
	private String nomeUniversitaPartner;
	private String codiceUniversitaPartner;
	private String indirizzoEmail;
	private String stato;
	private String percorsoExcel;
	private Date dataInserimento;
	private Date dataInvio;
	private Date dataRiscontro;
	private Date dataBloccoInvio;
	private Long idAccordoOperativo;
	private Integer numNomine;
	private Character flagConNomine;
	private String errMsg;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setIdBando(Long idBando) {
		this.idBando = idBando;
	}

	public Long getIdBando() {
		return idBando;
	}

	public void setTestoBando(String testoBando) {
		this.testoBando = testoBando;
	}

	public String getTestoBando() {
		return testoBando;
	}

	public void setIdBandoPadre(Long idBandoPadre) {
		this.idBandoPadre = idBandoPadre;
	}

	public Long getIdBandoPadre() {
		return idBandoPadre;
	}

	public void setNomeUniversitaPartner(String nomeUniversitaPartner) {
		this.nomeUniversitaPartner = nomeUniversitaPartner;
	}

	public String getNomeUniversitaPartner() {
		return nomeUniversitaPartner;
	}

	public void setIndirizzoEmail(String indirizzoEmail) {
		this.indirizzoEmail = indirizzoEmail;
	}

	public String getIndirizzoEmail() {
		if(StringUtils.isNotEmpty(indirizzoEmail))
			return StringUtils.join(Arrays.asList(indirizzoEmail.split(",")), "
");
		return null;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getStato() {
		return stato;
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
		if (getClass() != obj.getClass())
			return false;
		InvioNomine other = (InvioNomine) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void setPercorsoExcel(String percorsoExcel) {
		this.percorsoExcel = percorsoExcel;
	}

	public String getPercorsoExcel() {
		return percorsoExcel;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public Date getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInvio(Date dataInvio) {
		this.dataInvio = dataInvio;
	}

	public Date getDataInvio() {
		return dataInvio;
	}

	public void setDataRiscontro(Date dataRiscontro) {
		this.dataRiscontro = dataRiscontro;
	}

	public Date getDataRiscontro() {
		return dataRiscontro;
	}

	public void setCodiceUniversitaPartner(String codiceUniversitaPartner) {
		this.codiceUniversitaPartner = codiceUniversitaPartner;
	}

	public String getCodiceUniversitaPartner() {
		return codiceUniversitaPartner;
	}
	
	public String getColor() {
		return StatoInvioNomine.get(stato).getColor();
	}

	public String getColorDesc() {
		return StatoInvioNomine.get(stato).getValore();
	}
	
	public StatoInvioNomine getStatoInvioNomine() {
		return StatoInvioNomine.get(getStato());
	}
	
	public String getIndirizzoEmailPerInvio() {
		return indirizzoEmail;
	}

	public Long getIdAccordoOperativo() {
		return idAccordoOperativo;
	}

	public void setIdAccordoOperativo(Long idAccordoOperativo) {
		this.idAccordoOperativo = idAccordoOperativo;
	}

	public Date getDataBloccoInvio() {
		return dataBloccoInvio;
	}

	public void setDataBloccoInvio(Date dataBloccoInvio) {
		this.dataBloccoInvio = dataBloccoInvio;
	}

	public Integer getNumNomine() {
		return numNomine;
	}

	public void setNumNomine(Integer numNomine) {
		this.numNomine = numNomine;
	}

	public Character getFlagConNomine() {
		return flagConNomine;
	}

	public void setFlagConNomine(Character flagConNomine) {
		this.flagConNomine = flagConNomine;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
}
