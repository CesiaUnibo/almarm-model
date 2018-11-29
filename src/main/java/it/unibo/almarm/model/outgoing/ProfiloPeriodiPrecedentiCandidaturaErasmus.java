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
package it.unibo.almarm.model.outgoing;

public class ProfiloPeriodiPrecedentiCandidaturaErasmus implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long    idCandidatura;
	private String  siglaCicloCandidatura;
	private boolean candConGestiPeriodoErasmus;
	private Integer giorniFruiti;
	private boolean periodoErasmusInCorso;
	private boolean periodoErasmusFuturo;
	private Integer giorniResidui;
	private Long durataScambio;
	private Integer requisitoPeriodoInFaseCandidaturaValidabile;
	
	public ProfiloPeriodiPrecedentiCandidaturaErasmus(Long idCandidatura){
		this.idCandidatura=idCandidatura;
	}
	
	public Long getIdCandidatura() {
		return idCandidatura;
	}
	public void setIdCandidatura(Long idCandidatura) {
		this.idCandidatura = idCandidatura;
	}
	public String getSiglaCicloCandidatura() {
		return siglaCicloCandidatura;
	}
	public void setSiglaCicloCandidatura(String siglaCicloCandidatura) {
		this.siglaCicloCandidatura = siglaCicloCandidatura;
	}
	public boolean isCandConGestiPeriodoErasmus() {
		return candConGestiPeriodoErasmus;
	}
	public void setCandConGestiPeriodoErasmus(boolean candConGestiPeriodoErasmus) {
		this.candConGestiPeriodoErasmus = candConGestiPeriodoErasmus;
	}

	public Integer getGiorniFruiti() {
		return giorniFruiti;
	}
	public void setGiorniFruiti(Integer giorniFruiti) {
		this.giorniFruiti = giorniFruiti;
	}
	public boolean isPeriodoErasmusInCorso() {
		return periodoErasmusInCorso;
	}
	public void setPeriodoErasmusInCorso(boolean periodoErasmusInCorso) {
		this.periodoErasmusInCorso = periodoErasmusInCorso;
	}
	public boolean isPeriodoErasmusFuturo() {
		return periodoErasmusFuturo;
	}
	public void setPeriodoErasmusFuturo(boolean periodoErasmusFuturo) {
		this.periodoErasmusFuturo = periodoErasmusFuturo;
	}
	
	public Integer getGiorniResidui() {
		return giorniResidui;
	}
	
	public Integer getMesiResidui() {
		return giorniResidui != null ? giorniResidui / 30 : null;
	}
	
	public void setGiorniResidui(Integer giorniResidui) {
		this.giorniResidui = giorniResidui;
	}

	public boolean isAlmeno12mesiResidui() {
		return  candConGestiPeriodoErasmus == false || (giorniResidui != null && giorniResidui.intValue() >= (30*12));
	}
	
	public boolean isResiduiMinori12Mesi() {
		   return candConGestiPeriodoErasmus == true && giorniResidui != null && (giorniResidui.intValue() < (30*12));
	}
	
	public boolean isResiduiMinori24Mesi() {
	   return candConGestiPeriodoErasmus == true && giorniResidui != null && (giorniResidui.intValue() < (30*24));
	}
	
	public Integer getRequisitoPeriodoInFaseCandidaturaValidabile() {
		return requisitoPeriodoInFaseCandidaturaValidabile;
	}

	public void setRequisitoPeriodoInFaseCandidaturaValidabile(
			Integer requisitoPeriodoInFaseCandidaturaValidabile) {
		this.requisitoPeriodoInFaseCandidaturaValidabile = requisitoPeriodoInFaseCandidaturaValidabile;
	}

	public boolean isReqPeriodoInFaseCandidaturaNonValido(){
    	return requisitoPeriodoInFaseCandidaturaValidabile != null && requisitoPeriodoInFaseCandidaturaValidabile.intValue()==0;
    }
	
	public Long getDurataScambio() {
		return durataScambio;
	}

	public void setDurataScambio(Long durataScambio) {
		this.durataScambio = durataScambio;
	}

	public boolean isResiduoInsufficiente(){
		return isReqPeriodoInFaseCandidaturaNonValido();
	}

	public boolean isResiduoMinoreDurata(){
		return  getGiorniFruiti()!=null && getGiorniResidui()!=null && getDurataScambio() != null
				&& (getGiorniResidui() < (getDurataScambio()*30L));
	}
	
	public Integer getGiorniFruitiErasmus(){
		return giorniFruiti == null ? 0 : giorniFruiti; 
	}
	public Integer getMesiFruitiErasmus(){
		return giorniFruiti == null ? 0 : giorniFruiti / 30; 
	}
	public Integer getGiorniOltreMesiFruitiErasmus(){
		return giorniFruiti == null ? 0 : giorniFruiti % 30; 
	}
}
