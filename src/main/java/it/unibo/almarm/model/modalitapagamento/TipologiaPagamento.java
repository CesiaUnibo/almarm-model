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
package it.unibo.almarm.model.modalitapagamento;

import org.apache.commons.lang3.StringUtils;
import org.regola.util.Ognl;

import it.unibo.almarm.util.Common;
import it.unibo.almarm.webapp.mvc.Lingua;

public class TipologiaPagamento implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final Long ID_TIPO_CC_ITALIANO = 4L;
	public static final Long ID_TIPO_CC_ESTERO_CON_IBAN = 5L;
	public static final Long ID_TIPO_CC_ESTERO_NO_IBAN = 6L;

		private Long id;
		private String descrizione;
		private Character tipoIban;
		private String nome;
		private Character flagAttivo;
		private String nomeIng;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getDescrizione() {
			return descrizione;
		}

		public void setDescrizione(String descrizione) {
			this.descrizione = descrizione;
		}
		
		public Character getTipoIban() {
			return tipoIban;
		}

		public void setTipoIban(Character tipoIban) {
			this.tipoIban = tipoIban;
		}
		
		/*
		 *  L'iban viene richiesto solo se è tipo pagamento 4 (CC italiano) 
		 */
		public boolean isIbanRichiesto() {
			return isContoItaliano() || isContoEsteroConIban();
		}
		
		public boolean isContoItaliano() {
			return ID_TIPO_CC_ITALIANO.equals(id);
		}
		
		public boolean isContoEsteroConIban() {
			return ID_TIPO_CC_ESTERO_CON_IBAN.equals(id);
		}
		
		public boolean isContoEsteroNoIban() {
			return ID_TIPO_CC_ESTERO_NO_IBAN.equals(id);
		}

		public String getNome() {
			return nome;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}

		public Character getFlagAttivo() {
			return flagAttivo;
		}

		public void setFlagAttivo(Character flagAttivo) {
			this.flagAttivo = flagAttivo;
		}

		public boolean isAttivo() {
			return Common.CH_S.equals(flagAttivo);
		}
		
		public boolean isPerCassa() {
			return id.equals(1L);
		}
		
		public boolean isSuCcEstero() {
			return id.equals(6L) || id.equals(5L);
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
			if (!(obj instanceof TipologiaPagamento))
				return false;
			TipologiaPagamento other = (TipologiaPagamento) obj;
			if (id == null) {
				if (other.getId() != null)
					return false;
			} else if (!id.equals(other.getId()))
				return false;
			return true;
		}
		
		public String getLocaleNome() {
			String suffisso = "";
			if (!StringUtils.isBlank(Lingua.getSuffissoNomeCampoDiModello()))
				suffisso = "Ing";
			Object propertyValue = Ognl.getValue("nome"+suffisso, this);
			if (propertyValue != null)
			{
				String val=(String)propertyValue;
				return val;
			}
			return "";
		}

		public String getNomeIng() {
			return nomeIng;
		}

		public void setNomeIng(String nomeIng) {
			this.nomeIng = nomeIng;
		}
		
}
