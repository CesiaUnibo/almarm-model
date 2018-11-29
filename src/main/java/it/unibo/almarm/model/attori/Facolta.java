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
package it.unibo.almarm.model.attori;

import java.util.Date;

public class Facolta  implements java.io.Serializable {
	
	private static final long serialVersionUID = 2L;
	
	private String id;
	private String descFac;
	private String descAbbFac;
	private String codFacNaz;
	private String codSede;
	private String utenteMatricola;
	private String formName;
	private Date dataOra;
	private String terminale;
	private Long codFacPers;
	private String codFacAlma;
	private String descrizionelov;	
	private Character attivaInterna;
 
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescFac() {
		return descFac;
	}

	public void setDescFac(String descFac) {
		this.descFac = descFac;
	}

	public String getDescAbbFac() {
		return descAbbFac;
	}

	public void setDescAbbFac(String descAbbFac) {
		this.descAbbFac = descAbbFac;
	}

	public String getCodFacNaz() {
		return codFacNaz;
	}

	public void setCodFacNaz(String codFacNaz) {
		this.codFacNaz = codFacNaz;
	}

	public String getCodSede() {
		return codSede;
	}

	public void setCodSede(String codSede) {
		this.codSede = codSede;
	}

	public String getUtenteMatricola() {
		return utenteMatricola;
	}

	public void setUtenteMatricola(String utenteMatricola) {
		this.utenteMatricola = utenteMatricola;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public Date getDataOra() {
		return dataOra;
	}

	public void setDataOra(Date dataOra) {
		this.dataOra = dataOra;
	}

	public String getTerminale() {
		return terminale;
	}

	public void setTerminale(String terminale) {
		this.terminale = terminale;
	}

	public Long getCodFacPers() {
		return codFacPers;
	}

	public void setCodFacPers(Long codFacPers) {
		this.codFacPers = codFacPers;
	}

	public String getCodFacAlma() {
		return codFacAlma;
	}

	public void setCodFacAlma(String codFacAlma) {
		this.codFacAlma = codFacAlma;
	}

	public String getDescrizionelov() {
		return descrizionelov;
	}

	public void setDescrizionelov(String descrizionelov) {
		this.descrizionelov = descrizionelov;
	}
	
	public Character getAttivaInterna() {
		return attivaInterna;
	}

	public void setAttivaInterna(Character attivaInterna) {
		this.attivaInterna = attivaInterna;
	}

	public boolean isAttivaInterna() {
		return (new Character('S')).equals(attivaInterna);
	}

	/** 
     * @return la descrizione con escape degli apici per l'utilizzo in javascript   
     */
    public String getDescrizioneEscaped() {
    	if(this.descFac != null) {
    		String descrizioneEscaped=this.descFac.replaceAll("\"", "");
    		descrizioneEscaped=descrizioneEscaped.replaceAll("'", "\\'");
    		return descrizioneEscaped;
    	}
    	else
    		return "";
    }
    
    public boolean isDottorato() {
    	return "DOTT".equals(id);
    }
    
	@Override
	public boolean equals(Object other)
	{
		if(other == this)
			return true;
		if(! (other instanceof Facolta) )
			return super.equals(other);
		return 	this.id.equals(((Facolta)other).getId())
					&& this.descFac.equals(((Facolta)other).getDescFac())
					&& this.codSede.equals(((Facolta)other).getCodSede());
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		
		result = 37 * result
				+ (getId() == null ? 0 : this.getId()
				.hashCode());
		result = 37 * result
				+ (getDescFac() == null ? 0 : this.getDescFac()
				.hashCode());		
		result = 37 * result
				+ (getCodSede() == null ? 0 : this.getCodSede()
				.hashCode());		
		return result;
	}

}
