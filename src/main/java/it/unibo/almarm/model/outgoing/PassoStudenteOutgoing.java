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

public class PassoStudenteOutgoing implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String descrizione;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public static enum PassiStudenteOutgoing
	{
		ACCETTAZIONE_POSTO_SCAMBIO(1L),
		DEFINIZIONE_CARRIERA(2L),
		LEARNING_AGREEMENT(3L),
		CONTRATTO(4L),
		COMUNICAZIONE_DI_ARRIVO(5L),
		RICHIESTA_DI_PROLUNGAMENTO(6L),
		MODIFICA_LEARNING_AGREEMENT(7L),
		LEARNING_AGREEMENT_FIRMATO(8L),
		RICHIESTA_ABBREVIAZIONE_PERIODO(9L),
		COMUNICAZIONE_DI_RIENTRO(10L),
		DOCUMENTAZIONE_DI_RIENTRO(11L),
		RICHIESTA_DI_RICONOSCIMENTO(12L),
		RELAZIONE_FINALE(13L),
		QUESTIONARIO(14L),
		FIRMA_LEARNING_AGREEMENT(15L), 
		LEARNING_AGREEMENT_PROGETTO(16L),
		TRAINING_AGREEMENT(17L),
		TRAINING_AGREEMENT_FIRMATO(18L),
		RELAZIONE_INDIVIDUALE(19L),
		ACCORDO_PER_LA_MOBILITA(20L),
		TRAINING_AGREEMENT_FIRMATO_DURANTE_LO_SCAMBIO(21L),
		LEARNING_AGREEMENT_FOR_TRAINEESHIP_FIRMATO(22L), 
		MODALITA_DI_PAGAMENTO(23L),
		SCHEDA_ANAGRAFICA_FISCALE(24L);
				
		private java.lang.Long id;
		
		private PassiStudenteOutgoing(Long id) { this.id = id; }
		
		public Long getId() {
			return this.id;
		}
	}
}
