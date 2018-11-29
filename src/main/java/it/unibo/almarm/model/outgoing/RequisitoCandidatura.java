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

import it.unibo.almarm.model.outgoing.Candidatura.FaseCandidatura;
import it.unibo.almarm.util.Common;

import java.util.Comparator;


public class RequisitoCandidatura implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private RequisitoOfferta requisitoOfferta;
	private Character flagAutocertificato;
	private Character flagVerificato;
	private Float valore;
	private String idAllegato;
	private String nomeAllegato;
	private Character flagCalcolato;
	private String valoreStringa;
	
	// campi non persistiti
	private String messaggio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RequisitoOfferta getRequisitoOfferta() {
		return requisitoOfferta;
	}

	public void setRequisitoOfferta(RequisitoOfferta requisitoOfferta) {
		this.requisitoOfferta = requisitoOfferta;
	}

	public Character getFlagAutocertificato() {
		return flagAutocertificato;
	}

	public void setFlagAutocertificato(Character flagAutocertificato) {
		this.flagAutocertificato = flagAutocertificato;
	}

	public Character getFlagVerificato() {
		return flagVerificato;
	}

	public void setFlagVerificato(Character flagVerificato) {
		this.flagVerificato = flagVerificato;
	}

	public Float getValore() {
		return valore;
	}

	public void setValore(Float valore) {
		this.valore = valore;
	}
	
	public String getColor() {
		if (Common.CH_S.equals(flagAutocertificato) 
				|| Common.CH_S.equals(flagVerificato)
				|| (requisitoOfferta.isCalcolato() && isCalcoloPositivo()))
			return "Green";
		if (requisitoOfferta.isCalcolato() && isCalcoloNegativo())
			return "Red";
		return "White";
	}
	
	public String getColorDesc() {
		if (Common.CH_S.equals(flagAutocertificato))
			return "autocertificato";
		if (Common.CH_S.equals(flagVerificato))
			return "verificato";
		if (requisitoOfferta.isCalcolato() && isCalcoloPositivo())
			return "requisito soddisfatto";
		if (requisitoOfferta.isCalcolato() && isCalcoloNegativo())
			return "requisito non soddisfatto";
		return "da autocertificare";
	}
	
	
	public static class RequisitoCandidaturaComparator implements Comparator<RequisitoCandidatura> {

		public int compare(RequisitoCandidatura o1, RequisitoCandidatura o2) {
			if (o1 == null && o2 == null)
				return 0;
			if (o1 == null || o1.getRequisitoOfferta() == null || o1.getRequisitoOfferta().getPosizione() == null)
				return 1;
			if (o2 == null || o2.getRequisitoOfferta() == null || o2.getRequisitoOfferta().getPosizione() == null)
				return -1;
			if (o1.equals(o2))
				return 0;
			return o1.getRequisitoOfferta().getPosizione().compareTo(o2.getRequisitoOfferta().getPosizione());
		}
		
	}

	public boolean isAutocertificato() {
		return Common.CH_S.equals(flagAutocertificato);
	}

	public String getIdAllegato() {
		return idAllegato;
	}

	public void setIdAllegato(String idAllegato) {
		this.idAllegato = idAllegato;
	}

	public String getNomeAllegato() {
		return nomeAllegato;
	}

	public void setNomeAllegato(String nomeAllegato) {
		this.nomeAllegato = nomeAllegato;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}

	public Character getFlagCalcolato() {
		return flagCalcolato;
	}

	public void setFlagCalcolato(Character flagCalcolato) {
		this.flagCalcolato = flagCalcolato;
	}
	
	public Boolean isCalcoloPositivo() {
		return Common.CH_S.equals(flagCalcolato);
	}
	
	public Boolean isCalcoloNegativo() {
		return Common.CH_N.equals(flagCalcolato);
	}
	public boolean isRequisitoSoddisfatto()
	{
		return requisitoOfferta.isCalcolato() && (new Integer(1)).equals(valore);
	}
	public boolean isRequisitoNonSoddisfatto()
	{
		return requisitoOfferta.isCalcolato() && (new Integer(0)).equals(valore);
	}
	public boolean isRequisitoVerificato()
	{
		return Common.CH_S.equals(flagVerificato);
	}
	public boolean isRequisitoAutocertificato()
	{
		return Common.CH_S.equals(flagAutocertificato);
	}
	
	public boolean isRequisitoAssolto()
	{
		return requisitoOfferta.isCalcolato()
			|| isRequisitoAutocertificato()  
			|| isRequisitoVerificato()
			|| isRequisitoSoddisfatto();
	}
	
	public Integer getValoreInt() {
		if (valore != null)
			return valore.intValue();
		return null;
	}
	
	public void setValoreInt(Integer valore) {
		if (valore != null)
			this.valore = Float.valueOf(valore);
		else
			this.valore = null;
	}
	
	public String getColorVerificaPerAmmissione() {
		if (isRequisitoVerificato())
			return "Green";
		if (Common.CH_N.equals(flagVerificato))
			return "Red";
		if (getRequisitoOfferta().isObbligatoriaVerificaInFase(FaseCandidatura.AMMISSIONE) && !getRequisitoOfferta().isAppartieneAGruppoEsclusione())
			return "Yellow";
		if (getRequisitoOfferta().isObbligatoriaVerificaInFase(FaseCandidatura.AMMISSIONE) && getRequisitoOfferta().isAppartieneAGruppoEsclusione())
			return "Beige";
		return "White";
	}
	
	public String getColorVerificaPerAmmissioneDesc() {
		if (isRequisitoVerificato())
			return "Verificato";
		if (Common.CH_N.equals(flagVerificato))
			return "Rifiutato";
		if (getRequisitoOfferta().isObbligatoriaVerificaInFase(FaseCandidatura.AMMISSIONE))
			return "Da verificare obbligatoriamente";
		return "Da verificare";
	}
	
	public boolean isRequisitoOpzione() {
		if (getRequisitoOfferta() != null 
				&& getRequisitoOfferta().isDaOpzione())
			return true;
		return false;
	}

	public String getValoreStringa() {
		return valoreStringa;
	}

	public void setValoreStringa(String valoreStringa) {
		this.valoreStringa = valoreStringa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((requisitoOfferta == null) ? 0 : requisitoOfferta.hashCode());
		result = prime * result + ((valore == null) ? 0 : valore.hashCode());
		result = prime * result
				+ ((valoreStringa == null) ? 0 : valoreStringa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof RequisitoCandidatura))
			return false;
		RequisitoCandidatura other = (RequisitoCandidatura) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (requisitoOfferta == null) {
			if (other.requisitoOfferta != null)
				return false;
		} else if (!requisitoOfferta.equals(other.requisitoOfferta))
			return false;
		if (valore == null) {
			if (other.valore != null)
				return false;
		} else if (!valore.equals(other.valore))
			return false;
		if (valoreStringa == null) {
			if (other.valoreStringa != null)
				return false;
		} else if (!valoreStringa.equals(other.valoreStringa))
			return false;
		return true;
	}

	public boolean isDaVerificarePerAmmissione() {
		if (requisitoOfferta.isCalcolato())
			return false;
		if (isRequisitoVerificato())
			return false;
		if (Common.CH_N.equals(flagVerificato))
			return false;
		if (getRequisitoOfferta().isObbligatoriaVerificaInFase(FaseCandidatura.AMMISSIONE) && !getRequisitoOfferta().isAppartieneAGruppoEsclusione())
			return true;
		if (getRequisitoOfferta().isObbligatoriaVerificaInFase(FaseCandidatura.AMMISSIONE) && getRequisitoOfferta().isAppartieneAGruppoEsclusione())
			return false;
		return false;
	}
	
	public boolean isAllegatoCondizionatoVisibile() {
		if (!getRequisitoOfferta().isAllegatoCondizionato() || getValoreInt() == null)
			return false;
		return getRequisitoOfferta().getElencoValoriAllegatoRichiesto().contains(getValoreInt().toString());
	}

	public boolean isRifiutato() {
		if(requisitoOfferta.isCalcolato() && isCalcoloNegativo())
			return true;
		if (!requisitoOfferta.isCalcolato() && Common.CH_N.equals(flagVerificato))
			return true;
		return false;
	}
	
	public boolean isEsitoVerificaVisibileCandidato() {
		// Solo se la verifica del requisito e' gia avvenuta e se il requisto offerta prevede la visualizzazione esito al candidato
		// Per il momento non restringo ai soli casi di requisiti rifiutati (ora lo fa la pagina).
		return Common.CH_S.equals(getRequisitoOfferta().getFlagEsitoVisibileCandidato())  
				&& (    (requisitoOfferta.isCalcolato() && flagCalcolato != null) 
				     || (!requisitoOfferta.isCalcolato() && flagVerificato != null)
				   );
	}
}
