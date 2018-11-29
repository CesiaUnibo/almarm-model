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
package it.unibo.almarm.model.profilazione;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Contesto extends it.kion.plitvice.autorizzazioni.model.Contesto {

	private static final long serialVersionUID = 1L;
    private static final Long ID_CONTESTO_SOLA_VISUALIZZAZIONE_VISITING = 133L;
    private static final Long ID_CONTESTO_SEMESTRIBUENOSAIRES = 134L;

	private String nome;
	private Set<RegolaContesto> regoleContesto = new HashSet<RegolaContesto>();
	private String codFac;
	private String siglaPolo;
	private Long idUsd;
	private Set<ContestoDipartimento> contestoDipartimenti = new HashSet<ContestoDipartimento>();
	private Set<ContestoVicepresidenza> contestoVicepresidenze = new HashSet<ContestoVicepresidenza>();
	private Set<ContestoCorsoView> contestoCorsi = new HashSet<ContestoCorsoView>();
    private Set<ContestoSottoprogramma> contestoSottoprogrammi = new HashSet<>();

	private boolean personale = false;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<RegolaContesto> getRegoleContesto() {
		return regoleContesto;
	}

	public void setRegoleContesto(Set<RegolaContesto> regoleContesto) {
		this.regoleContesto = regoleContesto;
	}

	public boolean isPersonale() {
		return personale;
	}

	public void setPersonale(boolean personale) {
		this.personale = personale;
	}

	public String getCodFac() {
		return codFac;
	}

	public void setCodFac(String codFac) {
		this.codFac = codFac;
	}

	public String getSiglaPolo() {
		return siglaPolo;
	}

	public void setSiglaPolo(String siglaPolo) {
		this.siglaPolo = siglaPolo;
	}

	public Long getIdUsd() {
		return idUsd;
	}

	public void setIdUsd(Long idUsd) {
		this.idUsd = idUsd;
	}

	public Set<ContestoDipartimento> getContestoDipartimenti() {
		return contestoDipartimenti;
	}

	public void setContestoDipartimenti(
			Set<ContestoDipartimento> contestoDipartimenti) {
		this.contestoDipartimenti = contestoDipartimenti;
	}

	public Set<ContestoVicepresidenza> getContestoVicepresidenze() {
		return contestoVicepresidenze;
	}

	public void setContestoVicepresidenze(
			Set<ContestoVicepresidenza> contestoVicepresidenze) {
		this.contestoVicepresidenze = contestoVicepresidenze;
	}

	public List<Long> getIdsVicepresidenze() {
		if (getContestoVicepresidenze() != null && !getContestoVicepresidenze().isEmpty())
		{
			List<Long> l = new ArrayList<Long>();
			for (ContestoVicepresidenza cv: getContestoVicepresidenze())
				l.add(cv.getIdVicepresidenza());
			return l;
		}
		return null;
	}
	
	public List<Long> getIdsDipartimenti() {
		if (getContestoDipartimenti() != null && !getContestoDipartimenti().isEmpty())
		{
			List<Long> l = new ArrayList<Long>();
			for (ContestoDipartimento cd: getContestoDipartimenti())
				l.add(cd.getIdDipartimento());
			return l;
		}
		return null;
	}
	
	public List<Long> getIdsAnagraficheDipartimenti() {
		if (getContestoDipartimenti() != null && !getContestoDipartimenti().isEmpty())
		{
			List<Long> l = new ArrayList<Long>();
			for (ContestoDipartimento cd: getContestoDipartimenti()) {
				l.add(cd.getDipartimento().getIdAnagrafica());
			}
			return l;
		}
		return null;
	}
	
	public boolean isVicepresidenzaImpostata() {
		return getContestoVicepresidenze() != null && !getContestoVicepresidenze().isEmpty();
	}
	
	public boolean isDipartimentoImpostato() {
		return getContestoDipartimenti() != null && !getContestoDipartimenti().isEmpty();
	}

	public Set<ContestoCorsoView> getContestoCorsi() {
		return contestoCorsi;
	}

	public void setContestoCorsi(Set<ContestoCorsoView> contestoCorsi) {
		this.contestoCorsi = contestoCorsi;
		// sfoglio per problemi di lazy loading nei casi di impersonamento
		if (this.contestoCorsi != null && ! this.contestoCorsi.isEmpty())
			for (ContestoCorsoView cc: this.contestoCorsi)
				cc.getCodCorso();
	}
	
	public List<String> getElencoCorsi() {
		List<String> ret = new ArrayList<String>();
		if (contestoCorsi != null)
			for (ContestoCorsoView cc :contestoCorsi)
				ret.add(cc.getCodCorso());
		return ret;
	}

    /**
     * Al momento ne esiste uno solo quindi lo gestiamo sull'Id. Se aumentano mettiamo un flag nella tabella.
     * Impedisce l'accesso ad AlmaRM per utenti su questo contesto.
     *
     * @return
     */
    public boolean isNonValidoPerAlmaRM() {
        return isVisualizzazioneStaffIncoming();
    }

    public boolean isVisualizzazioneStaffIncoming() {
        return getId() != null && getId().equals(ID_CONTESTO_SOLA_VISUALIZZAZIONE_VISITING);
    }

    public Set<ContestoSottoprogramma> getContestoSottoprogrammi() {
        return contestoSottoprogrammi;
    }

    public void setContestoSottoprogrammi(Set<ContestoSottoprogramma> contestoSottoprogrammi) {
        this.contestoSottoprogrammi = contestoSottoprogrammi;
    }

    public List<Long> getIdsSottoProgrammi() {
        List<Long> idsSottoProgrammi = new ArrayList<>();
        if (getContestoSottoprogrammi() != null)
            for (ContestoSottoprogramma contestoSottoprogramma : getContestoSottoprogrammi())
                idsSottoProgrammi.add(contestoSottoprogramma.getIdSottoProgramma());
        return idsSottoProgrammi;
    }

    public boolean isSemestriBuenosAires() {
        return getId() != null && getId().equals(ID_CONTESTO_SEMESTRIBUENOSAIRES);
    }
}
