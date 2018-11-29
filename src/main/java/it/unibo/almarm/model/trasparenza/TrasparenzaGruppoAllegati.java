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
package it.unibo.almarm.model.trasparenza;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class TrasparenzaGruppoAllegati implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private TrasparenzaGruppo gruppoTrasparenza;
    private String nome;
    private String nomeFile;
    private String contentType;
    private String descrizione;
    private Date dataInserimento;
    private Long ordina;
    private byte[] fileAllegato;
    
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public TrasparenzaGruppo getGruppoTrasparenza() {
		return gruppoTrasparenza;
	}

	public void setGruppoTrasparenza(TrasparenzaGruppo gruppoTrasparenza) {
		this.gruppoTrasparenza = gruppoTrasparenza;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public byte[] getFileAllegato() {
		return fileAllegato;
	}

	public void setFileAllegato(byte[] fileAllegato) {
		this.fileAllegato = fileAllegato;
	}

	public void setFile(MultipartFile file) throws Exception {
		setNomeFile(file.getOriginalFilename());
		setContentType(file.getContentType());
		this.fileAllegato = file.getBytes();
	}

	public String getNomeFile() {
		return nomeFile;
	}

	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Long getOrdina() {
		return ordina;
	}

	public void setOrdina(Long ordina) {
		this.ordina = ordina;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataInserimento == null) ? 0 : dataInserimento.hashCode());
		result = prime * result + ((gruppoTrasparenza == null) ? 0 : gruppoTrasparenza.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((nomeFile == null) ? 0 : nomeFile.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TrasparenzaGruppoAllegati))
			return false;
		TrasparenzaGruppoAllegati other = (TrasparenzaGruppoAllegati) obj;
		if (dataInserimento == null) {
			if (other.dataInserimento != null)
				return false;
		} else if (!dataInserimento.equals(other.dataInserimento))
			return false;
		if (gruppoTrasparenza == null) {
			if (other.gruppoTrasparenza != null)
				return false;
		} else if (!gruppoTrasparenza.equals(other.gruppoTrasparenza))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (nomeFile == null) {
			if (other.nomeFile != null)
				return false;
		} else if (!nomeFile.equals(other.nomeFile))
			return false;
		return true;
	}
}
