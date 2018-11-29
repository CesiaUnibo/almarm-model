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

import java.util.Comparator;

import org.apache.commons.lang.StringUtils;

public class AttivitaEsteraComparator implements Comparator<AttivitaEstera>, java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	public int compare(AttivitaEstera o1, AttivitaEstera o2) {
		if (o1 == null && o2 == null)
			return 0;
		if (o1 == null && o2 != null)
			return 1;
		if (o1 != null && o2 == null)
			return -1;
		if (o1.isAggiuntaInRichiestaRiconoscimento() && !o2.isAggiuntaInRichiestaRiconoscimento())
			return 1;
		if (o2.isAggiuntaInRichiestaRiconoscimento() && !o1.isAggiuntaInRichiestaRiconoscimento())
			return -1;
		if (o1.getOrder() != null)
			return o1.getOrder().compareTo(o2.getOrder());
		if (o2.getOrder() != null)
			return o2.getOrder().compareTo(o1.getOrder());
		if (StringUtils.isBlank(o1.getDescrizione()) && StringUtils.isBlank(o2.getDescrizione()))
			return 0;
		if (StringUtils.isNotBlank(o1.getDescrizione()) && StringUtils.isNotBlank(o2.getDescrizione()))
			return o1.getDescrizione().compareTo(o2.getDescrizione());
		if (StringUtils.isNotBlank(o1.getDescrizione()))
			return 1;
		return -1;
	}
}
