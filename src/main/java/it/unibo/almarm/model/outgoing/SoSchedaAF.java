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

import java.util.Date;

import it.unibo.almarm.model.attori.Persona;
import it.unibo.almarm.util.Common;

public class SoSchedaAF implements java.io.Serializable {

		private static final long serialVersionUID = 1L;
		
		public static Character V_SCHEDA_ASSENTE = Common.CH_A;
		public static Character V_DA_VALIDARE = Common.CH_U;
		public static Character V_VALIDATA = Common.CH_V;
		public static Character V_RIFIUTATA = Common.CH_R;

		private Long id;
		private StudenteOutgoing studenteOutgoing;
		private String idDocumento;
		private String nomeDocumento;
		private String nomeSottoCartellaDocumento;
		private Date dataUpload;
		private Persona autoreUpload;
		private Character tipoAutoreUpload;
		private Character flagValidazione;
		private Date dataValidazione;
		private Persona autoreValidazione;
		private String noteValidazione;

		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public StudenteOutgoing getStudenteOutgoing() {
			return studenteOutgoing;
		}
		public void setStudenteOutgoing(StudenteOutgoing studenteOutgoing) {
			this.studenteOutgoing = studenteOutgoing;
		}
		public String getIdDocumento() {
			return idDocumento;
		}
		public void setIdDocumento(String idDocumento) {
			this.idDocumento = idDocumento;
		}
		public String getNomeDocumento() {
			return nomeDocumento;
		}
		public void setNomeDocumento(String nomeDocumento) {
			this.nomeDocumento = nomeDocumento;
		}
		public String getNomeSottoCartellaDocumento() {
			return nomeSottoCartellaDocumento;
		}
		public void setNomeSottoCartellaDocumento(String nomeSottoCartellaDocumento) {
			this.nomeSottoCartellaDocumento = nomeSottoCartellaDocumento;
		}
		public Date getDataUpload() {
			return dataUpload;
		}
		public void setDataUpload(Date dataUpload) {
			this.dataUpload = dataUpload;
		}
		public Persona getAutoreUpload() {
			return autoreUpload;
		}
		public void setAutoreUpload(Persona autoreUpload) {
			this.autoreUpload = autoreUpload;
		}
		public Character getTipoAutoreUpload() {
			return tipoAutoreUpload;
		}
		public void setTipoAutoreUpload(Character tipoAutoreUpload) {
			this.tipoAutoreUpload = tipoAutoreUpload;
		}
		public Character getFlagValidazione() {
			return flagValidazione;
		}
		public void setFlagValidazione(Character flagValidazione) {
			this.flagValidazione = flagValidazione;
		}
		public Date getDataValidazione() {
			return dataValidazione;
		}
		public void setDataValidazione(Date dataValidazione) {
			this.dataValidazione = dataValidazione;
		}
		public Persona getAutoreValidazione() {
			return autoreValidazione;
		}
		public void setAutoreValidazione(Persona autoreValidazione) {
			this.autoreValidazione = autoreValidazione;
		}
		public String getNoteValidazione() {
			return noteValidazione;
		}
		public void setNoteValidazione(String noteValidazione) {
			this.noteValidazione = noteValidazione;
		}
		public boolean isAssente() {
			return V_SCHEDA_ASSENTE.equals(flagValidazione);
		}
		public boolean isDaValidare() {
			return V_DA_VALIDARE.equals(flagValidazione);
		}
		public boolean isValidata() {
			return V_VALIDATA.equals(flagValidazione);
		}
		public boolean isRifiutata() {
			return V_RIFIUTATA.equals(flagValidazione);
		}

}
