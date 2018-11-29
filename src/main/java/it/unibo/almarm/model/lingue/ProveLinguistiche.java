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
package it.unibo.almarm.model.lingue;

public enum ProveLinguistiche {
	OVERSEAS(1L, "Overseas"),
	ERASMUS_PLACEMENT(2L, "Erasmus+ mobilita' per Tirocinio"),
	ERASMUS(3L, "Erasmus+ mobilità per Studio"),
	OVERSEAS_E_ERASMUS_PLACEMENT(4L, "Overseas - Erasmus+ Mobilita' per tirocinio"),
	ERASMUS_STUDIO_E_PLACEMENT(5L, "Erasmus+ Mobilita' per studio - Erasmus+ Mobilita' per tirocinio"),
	OVERSEAS_E_FIELD_WORK(6L, "Overseas - Field Work");
	
	private Long valore;
	private String nome;
	
	private ProveLinguistiche(Long val, String n) { this.valore = val; this.nome = n;}
	
	public Long getValore() {return valore;}
	
	public String getNome() {return nome;}
	
	public static ProveLinguistiche get(Long id) {
		for (ProveLinguistiche pl: values())
			if (pl.getValore().equals(id))
				return pl;
		return null;
	}
}
