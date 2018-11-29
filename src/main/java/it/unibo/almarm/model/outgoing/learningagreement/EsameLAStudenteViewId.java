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

import it.unibo.almarm.util.Common;

import java.util.Objects;

public class EsameLAStudenteViewId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer pincode;
	private Integer carriera;
	private Integer annoAccademico;
	private String codCorso;
	private String codInd;
	private String codOri;
	private String codMateria;
	private String annoCorsoPrevisto;
	private String annoCorsoReale;
	private String codCorsoPadre;
	private String codIndPadre;
	private String codOriPadre;
	private String codMateriaPadre;
    private Float cfu;

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public Integer getCarriera() {
		return carriera;
	}

	public void setCarriera(Integer carriera) {
		this.carriera = carriera;
	}

	public Integer getAnnoAccademico() {
		return annoAccademico;
	}

	public void setAnnoAccademico(Integer annoAccademico) {
		this.annoAccademico = annoAccademico;
	}

	public String getCodCorso() {
		return codCorso;
	}

	public void setCodCorso(String codCorso) {
		this.codCorso = codCorso;
	}

	public String getCodInd() {
		return codInd;
	}

	public void setCodInd(String codInd) {
		this.codInd = codInd;
	}

	public String getCodOri() {
		return codOri;
	}

	public void setCodOri(String codOri) {
		this.codOri = codOri;
	}

	public String getCodMateria() {
		return codMateria;
	}

	public void setCodMateria(String codMateria) {
		this.codMateria = codMateria;
	}

	public String getAnnoCorsoPrevisto() {
		return annoCorsoPrevisto;
	}

	public void setAnnoCorsoPrevisto(String annoCorsoPrevisto) {
		this.annoCorsoPrevisto = annoCorsoPrevisto;
	}

	public String getAnnoCorsoReale() {
		return annoCorsoReale;
	}

	public void setAnnoCorsoReale(String annoCorsoReale) {
		this.annoCorsoReale = annoCorsoReale;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EsameLAStudenteViewId that = (EsameLAStudenteViewId) o;
        return Objects.equals(getPincode(), that.getPincode()) &&
                Objects.equals(getCarriera(), that.getCarriera()) &&
                Objects.equals(getAnnoAccademico(), that.getAnnoAccademico()) &&
                Objects.equals(getCodCorso(), that.getCodCorso()) &&
                Objects.equals(getCodInd(), that.getCodInd()) &&
                Objects.equals(getCodOri(), that.getCodOri()) &&
                Objects.equals(getCodMateria(), that.getCodMateria()) &&
                Objects.equals(getAnnoCorsoPrevisto(), that.getAnnoCorsoPrevisto()) &&
                Objects.equals(getAnnoCorsoReale(), that.getAnnoCorsoReale()) &&
                Objects.equals(getCodCorsoPadre(), that.getCodCorsoPadre()) &&
                Objects.equals(getCodIndPadre(), that.getCodIndPadre()) &&
                Objects.equals(getCodOriPadre(), that.getCodOriPadre()) &&
                Objects.equals(getCodMateriaPadre(), that.getCodMateriaPadre()) &&
                Objects.equals(getCfu(), that.getCfu());
	}

	@Override
    public int hashCode() {

        return Objects.hash(getPincode(), getCarriera(), getAnnoAccademico(), getCodCorso(), getCodInd(), getCodOri(), getCodMateria(), getAnnoCorsoPrevisto(), getAnnoCorsoReale(), getCodCorsoPadre(), getCodIndPadre(), getCodOriPadre(), getCodMateriaPadre(), getCfu());
    }

	@Override
	public String toString() {
		// lo faccio iniziare per "id" perchè gli identificativo html devono iniziare con una lettera
		return "id" + Common.idSeparator 
				+ pincode + Common.idSeparator 
				+ carriera + Common.idSeparator 
				+ annoAccademico + Common.idSeparator
				+ codCorso + Common.idSeparator
				+ codInd + Common.idSeparator
				+ codOri + Common.idSeparator
				+ codMateria + Common.idSeparator
				+ annoCorsoPrevisto + Common.idSeparator
				+ annoCorsoReale + Common.idSeparator
				+ codCorsoPadre + Common.idSeparator
				+ codIndPadre  + Common.idSeparator
				+ codOriPadre + Common.idSeparator
                + codMateriaPadre + Common.idSeparator
                + (cfu != null ? cfu.intValue() : "0");
	}
	
	public static EsameLAStudenteViewId getIdByString(String sid) {
		EsameLAStudenteViewId id = new EsameLAStudenteViewId();
		String[] el = sid.split(Common.idSeparator);
		id.setPincode(Integer.valueOf(el[1]));
		id.setCarriera(Integer.valueOf(el[2]));
		id.setAnnoAccademico(Integer.valueOf(el[3]));
		id.setCodCorso(el[4]);
		id.setCodInd(el[5]);
		id.setCodOri(el[6]);
		id.setCodMateria(el[7]);
		id.setAnnoCorsoPrevisto(el[8]);
		id.setAnnoCorsoReale(el[9]);
		id.setCodCorsoPadre(el[10]);
		id.setCodIndPadre(el[11]);
		id.setCodOriPadre(el[12]);
		id.setCodMateriaPadre(el[13]);
        id.setCfu(Float.valueOf(el[14]));
		return id;
	}

	public String getCodCorsoPadre() {
		return codCorsoPadre;
	}

	public void setCodCorsoPadre(String codCorsoPadre) {
		this.codCorsoPadre = codCorsoPadre;
	}

	public String getCodIndPadre() {
		return codIndPadre;
	}

	public void setCodIndPadre(String codIndPadre) {
		this.codIndPadre = codIndPadre;
	}

	public String getCodOriPadre() {
		return codOriPadre;
	}

	public void setCodOriPadre(String codOriPadre) {
		this.codOriPadre = codOriPadre;
	}

	public String getCodMateriaPadre() {
		return codMateriaPadre;
	}

	public void setCodMateriaPadre(String codMateriaPadre) {
		this.codMateriaPadre = codMateriaPadre;
	}

    public Float getCfu() {
        return cfu;
    }

    public void setCfu(Float cfu) {
        this.cfu = cfu;
    }
}
