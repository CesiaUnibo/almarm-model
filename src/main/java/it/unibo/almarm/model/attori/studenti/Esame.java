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
package it.unibo.almarm.model.attori.studenti;


import it.unibo.almarm.util.Common;

import java.util.Date;

public class Esame implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private EsameId id;
	
    private Character annoCorso;
    private String idMateria;
    private String nomeMateria;
    private String codCorso;
    
	private String corrispondenza;
    private Date dataEsame;
    private Long voto;
    private Character flagLode = 'N';
    private String giudizio;
	private Integer crediti;
	
	public EsameId getId() {
		return id;
	}
	public void setId(EsameId id) {
		this.id = id;
	}
	public Character getAnnoCorso() {
		return annoCorso;
	}
	public void setAnnoCorso(Character annoCorso) {
		this.annoCorso = annoCorso;
	}
	public String getIdMateria() {
		return idMateria;
	}
	public void setIdMateria(String idMateria) {
		this.idMateria = idMateria;
	}
	public String getNomeMateria() {
		return nomeMateria;
	}
	public void setNomeMateria(String nomeMateria) {
		this.nomeMateria = nomeMateria;
	}
	public String getCodCorso() {
		return codCorso;
	}
	public void setCodCorso(String codCorso) {
		this.codCorso = codCorso;
	}
	public String getCorrispondenza() {
		return corrispondenza;
	}
	public void setCorrispondenza(String corrispondenza) {
		this.corrispondenza = corrispondenza;
	}
	public Date getDataEsame() {
		return dataEsame;
	}
	public void setDataEsame(Date dataEsame) {
		this.dataEsame = dataEsame;
	}
	public Long getVoto() {
		return voto;
	}
	public void setVoto(Long voto) {
		this.voto = voto;
	}
	public Boolean getLode() {
		return Common.CH_S.equals(getFlagLode());
	}
	public void setLode(Boolean lode) {
		if (lode)
			setFlagLode('S');
		else
			setFlagLode('N');
	}
	public String getGiudizio() {
		return giudizio;
	}
	public void setGiudizio(String giudizio) {
		this.giudizio = giudizio;
	}
	public Integer getCrediti() {
		return crediti;
	}
	public void setCrediti(Integer crediti) {
		this.crediti = crediti;
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
		if (!(obj instanceof Esame))
			return false;
		Esame other = (Esame) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public Character getFlagLode() {
		return flagLode;
	}
	public void setFlagLode(Character flagLode) {
		this.flagLode = flagLode;
	}

}
