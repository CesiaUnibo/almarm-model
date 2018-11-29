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
package it.unibo.almarm.model.staff.outgoing;

import it.unibo.almarm.model.attori.Persona;
import it.unibo.almarm.util.Common;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;

public class OutgoingStaffView implements Serializable {
	private Long id;
    private Long idDgMissione;
    private Long idDgRichiestaMissione;
	private String idAnagraficaOutgoing;
    private String nome;
    private String cognome;
    private Long idStrutturaDiRiferimento;
    private Date dataInizio;
    private Date dataFine;
    private String stato;
    private String motivazione;
    private String descrizioneLuogo;
    private String descrizioneAreaGeografica;
    private Character flagRichiedeCompletamentoDati;
	private Character flagDatiCompleti;
	private String destinazionePerRicerca;
	private String nomePartner;
	private String nomeNazionePartner;
    private String statoCompletamentoDatiValue;
    private Character flagConPartner;
    private Long idAteneoDiDestinazione;
    private String nomeNuovoPartner;
    private Date dataUltimoAggiornamento;
    private String nomeCognomeAutoreUltimoAggiornamento;
    private Character flagDottorando;

    private String nomeStrutturaDiRiferimento;

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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNomeCognome() { return getNome() + " " +getCognome(); }

    public Long getIdStrutturaDiRiferimento() {
        return idStrutturaDiRiferimento;
    }

    public void setIdStrutturaDiRiferimento(Long idStrutturaDiRiferimento) {
        this.idStrutturaDiRiferimento = idStrutturaDiRiferimento;
    }

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getMotivazione() {
		return motivazione;
	}

	public void setMotivazione(String motivazione) {
		this.motivazione = motivazione;
	}

	public String getDestinazioneLabel() {
        if (StringUtils.isNotBlank(getNomePartner()))
            return getNomePartner() + (StringUtils.isNotBlank(getNomeNazionePartner()) ? " - " + getNomeNazionePartner() : "");
		if (StringUtils.equalsIgnoreCase(getDescrizioneLuogo(), getDescrizioneAreaGeografica()))
			return getDescrizioneLuogo();
		return getDescrizioneLuogo() + " - " + getDescrizioneAreaGeografica();
	}

	public String getPeriodoLabel() {
		return Common.getDataFormattata(getDataInizio()) + " - " + Common.getDataFormattata(getDataFine());
	}

	public String getColorStato() {
		return StatiOutgoingStaffView.get(getStato()).getColor();
	}

	public String getColorStatoCompletamentoDati() {
		return getStatoCompletamentoDati().getColor();
	}

	public String getDescrizioneLuogo() {
		return descrizioneLuogo;
	}

	public void setDescrizioneLuogo(String descrizioneLuogo) {
		this.descrizioneLuogo = descrizioneLuogo;
	}

	public String getDescrizioneAreaGeografica() {
		return descrizioneAreaGeografica;
	}

	public void setDescrizioneAreaGeografica(String descrizioneAreaGeografica) {
		this.descrizioneAreaGeografica = descrizioneAreaGeografica;
	}

	public Character getFlagRichiedeCompletamentoDati() {
		return flagRichiedeCompletamentoDati;
	}

	public void setFlagRichiedeCompletamentoDati(Character flagRichiedeCompletamentoDati) {
		this.flagRichiedeCompletamentoDati = flagRichiedeCompletamentoDati;
	}

    public boolean isCompletamentoDatiAmmesso() {
        return getStatoCompletamentoDati().isCompletamentoDatiAmmesso();
	}

	public String getIdAnagraficaOutgoing() {
		return idAnagraficaOutgoing;
	}

	public void setIdAnagraficaOutgoing(String idAnagraficaOutgoing) {
		this.idAnagraficaOutgoing = idAnagraficaOutgoing;
	}

    public Character getFlagDatiCompleti() {
        return flagDatiCompleti;
    }

    public void setFlagDatiCompleti(Character flagDatiCompleti) {
        this.flagDatiCompleti = flagDatiCompleti;
    }

    public boolean isDatiCompleti() {
        return Common.CH_S.equals(getFlagDatiCompleti());
    }

    public String getDestinazionePerRicerca() {
        return destinazionePerRicerca;
    }

    public void setDestinazionePerRicerca(String destinazionePerRicerca) {
        this.destinazionePerRicerca = destinazionePerRicerca;
    }

    public String getNomePartner() {
        return nomePartner;
    }

    public void setNomePartner(String nomePartner) {
        this.nomePartner = nomePartner;
    }

    public String getNomeNazionePartner() {
        return nomeNazionePartner;
    }

    public void setNomeNazionePartner(String nomeNazionePartner) {
        this.nomeNazionePartner = nomeNazionePartner;
    }

    public String getStatoCompletamentoDatiValue() {
        return statoCompletamentoDatiValue;
    }

    public void setStatoCompletamentoDatiValue(String statoCompletamentoDatiValue) {
        this.statoCompletamentoDatiValue = statoCompletamentoDatiValue;
    }

    public StatiCompletamentoDatiOutgoingStaff getStatoCompletamentoDati() {
        return StatiCompletamentoDatiOutgoingStaff.get(getStatoCompletamentoDatiValue());
//        if (!StatiOutgoingStaffView.get(getStato()).equals(StatiOutgoingStaffView.MOBILITA_EFFETTUATA))
//            return StatiCompletamentoDatiOutgoingStaff.NON_DEFINITO;
//        if (isDatiCompleti())
//            return StatiCompletamentoDatiOutgoingStaff.COMPLETI;
//        if (isRichiedeCompletamentoDati())
//            return StatiCompletamentoDatiOutgoingStaff.COMPLETAMENTO_RICHIESTO;
//        return StatiCompletamentoDatiOutgoingStaff.COMPLETAMENTO_POSSIBILE;
    }

    public String getNomeStrutturaDiRiferimento() {
        return nomeStrutturaDiRiferimento;
    }

    public void setNomeStrutturaDiRiferimento(String nomeStrutturaDiRiferimento) {
        this.nomeStrutturaDiRiferimento = nomeStrutturaDiRiferimento;
    }

    public Character getFlagConPartner() {
        return flagConPartner;
    }

    public void setFlagConPartner(Character flagConPartner) {
        this.flagConPartner = flagConPartner;
    }

    public boolean isConPartner() {
        return Common.CH_S.equals(getFlagConPartner());
    }

    public Long getIdAteneoDiDestinazione() {
        return idAteneoDiDestinazione;
    }

    public void setIdAteneoDiDestinazione(Long idAteneoDiDestinazione) {
        this.idAteneoDiDestinazione = idAteneoDiDestinazione;
    }

    public String getNomeNuovoPartner() {
        return nomeNuovoPartner;
    }

    public void setNomeNuovoPartner(String nomeNuovoPartner) {
        this.nomeNuovoPartner = nomeNuovoPartner;
    }

    public Date getDataUltimoAggiornamento() {
        return dataUltimoAggiornamento;
    }

    public void setDataUltimoAggiornamento(Date dataUltimoAggiornamento) {
        this.dataUltimoAggiornamento = dataUltimoAggiornamento;
    }

    public String getNomeCognomeAutoreUltimoAggiornamento() {
        return nomeCognomeAutoreUltimoAggiornamento;
    }

    public void setNomeCognomeAutoreUltimoAggiornamento(String nomeCognomeAutoreUltimoAggiornamento) {
        this.nomeCognomeAutoreUltimoAggiornamento = nomeCognomeAutoreUltimoAggiornamento;
    }

    public Long getIdDgMissione() {
        return idDgMissione;
    }

    public void setIdDgMissione(Long idDgMissione) {
        this.idDgMissione = idDgMissione;
    }

    public Long getIdDgRichiestaMissione() {
        return idDgRichiestaMissione;
    }

    public void setIdDgRichiestaMissione(Long idDgRichiestaMissione) {
        this.idDgRichiestaMissione = idDgRichiestaMissione;
    }

    public Character getFlagDottorando() {
        return flagDottorando;
    }

    public void setFlagDottorando(Character flagDottorando) {
        this.flagDottorando = flagDottorando;
    }
}
