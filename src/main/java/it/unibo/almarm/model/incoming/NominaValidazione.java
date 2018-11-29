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

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import it.unibo.almarm.model.attori.Persona;

/**
 * Informazioni sulla validazione della nomina
 *
 */
public class NominaValidazione implements Serializable {

	private static final long serialVersionUID = -7054501883442378498L;

	public enum StatoNominaValidazione {

		DA_VALIDARE("da validare", "Yellow"),

		VALIDATO("validato", "LightGreen"),

		RIFIUTATO("rifiutato", "Red");

		private final String valore;

		private final String color;

		StatoNominaValidazione(String valore, String color) {
			this.valore = valore;
			this.color = color;
		}

		public static StatoNominaValidazione getBy(String valore) {
			for (StatoNominaValidazione statoNominaValidazione : Arrays.asList(StatoNominaValidazione.values())) {
				if (statoNominaValidazione.getValore().equals(valore)) {
					return statoNominaValidazione;
				}
			}
			return StatoNominaValidazione.DA_VALIDARE;
		}

		public String getValore() {
			return valore;
		}

		public String getColor() { return color; }

		public String getMessageKey(){
			String stato = "null";
			if (StringUtils.isNotBlank(valore))
				stato = valore.toLowerCase().replace(" ", "");
			return "nominaValidazione.stato." + stato;
		}

	}
	
	private Long id;
	private Nomina nomina;
	
	private String statoValidazione;
	
	private Persona autoreValidazione;
	private Date dataValidazione;
	private String noteValidazione;
	
	private Persona autoreRifiuto;
	private Date dataRifiuto;
	private String noteRifiuto;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Nomina getNomina() {
		return nomina;
	}
	public void setNomina(Nomina nomina) {
		this.nomina = nomina;
	}
	public String getStatoValidazione() {
		return statoValidazione;
	}
	public void setStatoValidazione(String statoValidazione) {
		this.statoValidazione = statoValidazione;
	}
	public Persona getAutoreValidazione() {
		return autoreValidazione;
	}
	public void setAutoreValidazione(Persona autoreValidazione) {
		this.autoreValidazione = autoreValidazione;
	}
	public Date getDataValidazione() {
		return dataValidazione;
	}
	public void setDataValidazione(Date dataValidazione) {
		this.dataValidazione = dataValidazione;
	}
	public String getNoteValidazione() {
		return noteValidazione;
	}
	public void setNoteValidazione(String noteValidazione) {
		this.noteValidazione = noteValidazione;
	}
	public Persona getAutoreRifiuto() {
		return autoreRifiuto;
	}
	public void setAutoreRifiuto(Persona autoreRifiuto) {
		this.autoreRifiuto = autoreRifiuto;
	}
	public Date getDataRifiuto() {
		return dataRifiuto;
	}
	public void setDataRifiuto(Date dataRifiuto) {
		this.dataRifiuto = dataRifiuto;
	}
	public String getNoteRifiuto() {
		return noteRifiuto;
	}
	public void setNoteRifiuto(String noteRifiuto) {
		this.noteRifiuto = noteRifiuto;
	}

}
