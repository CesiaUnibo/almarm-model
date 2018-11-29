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
package it.unibo.almarm.model.accordi;

import java.util.Comparator;

public class SottoProgrammaNazioneComparator implements Comparator<SottoProgrammaNazione>, java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	public int compare(SottoProgrammaNazione spn1, SottoProgrammaNazione spn2) {
		if (spn2 == null && spn2 == null)
			return 0;
		if (spn1 == null && spn2 != null)
			return 1;
		if (spn1 != null && spn2 == null)
			return -1;
		return spn1.getNazione().getDescrizioneOrig().compareTo(spn2.getNazione().getDescrizioneOrig());
	}
}
