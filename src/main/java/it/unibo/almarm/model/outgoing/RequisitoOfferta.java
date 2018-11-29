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

import java.util.ArrayList;
import java.util.List;

import it.unibo.almarm.model.outgoing.Candidatura.FaseCandidatura;
import it.unibo.almarm.model.profilazione.ProfiloStudente;
import it.unibo.almarm.util.Common;

public class RequisitoOfferta implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private TipoRequisito tipoRequisito;
	private String descrizione;
	private Character modalita;
	private Character flagRichiedeAllegato;
	private String nomeAllegato;
	private Integer faseAutocertificazione;
	private Integer faseVerifica;
	private Character flagVisibileCandidato;
	private Character flagVisibileOperatore;
	private Character flagVisibileCommissione;
	private Float soglia;
	private Float posizione;
	private GruppoRequisiti gruppoRequisiti;
	private Character applicabilita;
	private String nomeProceduraCalcoloAutomatico;
	private Integer gruppoEsclusione;
	private Integer gruppoInclusione;
	private String valoriAllegatoRichiesto;
	private Character flagGruppoEsclusioneEsclusivo;
	
	private Long idOfferta;
	private Long idOpzioneOfferta;
	private Long idBando;
	private Long idDisponibilita;
	private Long idSottoProgramma;
	private Character flagEsitoVisibileCandidato;
	private Character tipoSpeciale;
	private String valoreSpeciale;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoRequisito getTipoRequisito() {
		return tipoRequisito;
	}

	public void setTipoRequisito(TipoRequisito tipoRequisito) {
		this.tipoRequisito = tipoRequisito;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Character getModalita() {
		return modalita;
	}

	public void setModalita(Character modalita) {
		this.modalita = modalita;
	}

	public Character getFlagRichiedeAllegato() {
		if (flagRichiedeAllegato == null)
			return 'N';
		return flagRichiedeAllegato;
	}

	public void setFlagRichiedeAllegato(Character flagRichiedeAllegato) {
		this.flagRichiedeAllegato = flagRichiedeAllegato;
	}

	public String getNomeAllegato() {
		return nomeAllegato;
	}

	public void setNomeAllegato(String nomeAllegato) {
		this.nomeAllegato = nomeAllegato;
	}

	public Integer getFaseAutocertificazione() {
		return faseAutocertificazione;
	}

	public void setFaseAutocertificazione(Integer faseAutocertificazione) {
		this.faseAutocertificazione = faseAutocertificazione;
	}

	public Integer getFaseVerifica() {
		return faseVerifica;
	}

	public void setFaseVerifica(Integer faseVerifica) {
		this.faseVerifica = faseVerifica;
	}

	public Character getFlagVisibileCandidato() {
		return flagVisibileCandidato;
	}

	public void setFlagVisibileCandidato(Character flagVisibileCandidato) {
		this.flagVisibileCandidato = flagVisibileCandidato;
	}

	public Character getFlagVisibileOperatore() {
		return flagVisibileOperatore;
	}

	public void setFlagVisibileOperatore(Character flagVisibileOperatore) {
		this.flagVisibileOperatore = flagVisibileOperatore;
	}

	public Character getFlagVisibileCommissione() {
		return flagVisibileCommissione;
	}

	public void setFlagVisibileCommissione(Character flagVisibileCommissione) {
		this.flagVisibileCommissione = flagVisibileCommissione;
	}

	/*
	 * Requisiti aggiunti nella fase di validazione e che devono essere visualizzati
	 * al candidato a processo di validazione concluso (quando tutti i controlli 
	 * sono terminati),  cioè ad ammissioni effettuate.
	 */
	public boolean isVisibileCandidatoDopoAmmissioni() {
		return Common.CH_A.equals(flagVisibileCandidato);
	}

	public Float getSoglia() {
		return soglia;
	}

	public void setSoglia(Float soglia) {
		this.soglia = soglia;
	}
	
	public String getSogliaLabel() {
		if (soglia == null)
			return "";
		String str = soglia.toString();
		if (str.endsWith(".0"))
			str = str.substring(0, str.length() - 2);
		return str;
	}
	
	public boolean isRichiedeAllegato() {
		return Common.CH_S.equals(flagRichiedeAllegato);
	}
	
	public boolean isPermetteAllegato() {
		return Common.CH_O.equals(flagRichiedeAllegato);
	}
	
	public boolean isAllegatoCondizionato() {
		return Common.CH_C.equals(flagRichiedeAllegato);
	}
	
	public boolean isRichiedeValore() {
		return tipoRequisito.isRichiedeValore();
	}
	
	public boolean isTipoEnumerazione() {
		return tipoRequisito.isTipoEnumerazione();
	}
	
	public boolean isTipoEnumerazioneRadio() {
		return tipoRequisito.isTipoEnumerazioneRadio();
	}
	
	public boolean isTipoIntervallo() {
		return tipoRequisito.isTipoIntervallo();
	}
	
	public boolean isTipoStringa() {
		return tipoRequisito.isTipoStringa();
	}
	public boolean isTipoLabel() {
		return tipoRequisito.isTipoLabel();
	}
	
	public List<String> getValori() {
		return tipoRequisito.getValori();
	}
	
	public boolean isAutocertificazioneObbligatoria() {
		return faseAutocertificazione != null;
	}
	
	public boolean isAutocertificazioneObbligatoriaInPresentazione() {
		return faseAutocertificazione.equals(FaseCandidatura.PRESENTAZIONE.getValore());
	}
	
	public boolean isVisibileCandidato() {
		return Common.CH_S.equals(flagVisibileCandidato);
	}

	public boolean isVisibileOperatore() {
		return Common.CH_S.equals(flagVisibileOperatore);
	}
	
	public Float getPosizione() {
		return posizione;
	}

	public void setPosizione(Float posizione) {
		this.posizione = posizione;
	}

	public GruppoRequisiti getGruppoRequisiti() {
		return gruppoRequisiti;
	}

	public void setGruppoRequisiti(GruppoRequisiti gruppoRequisiti) {
		this.gruppoRequisiti = gruppoRequisiti;
	}
	
	public boolean isCalcolato() {
		return Common.CH_C.equals(modalita);
	}

	public Character getApplicabilita() {
		return applicabilita;
	}

	public void setApplicabilita(Character applicabilita) {
		this.applicabilita = applicabilita;
	}
	
	public boolean studenteCompatibile(ProfiloStudente profiloStudente, boolean isVotoLaureaPrecedenteConosciuto) {
		return studenteCompatibile(profiloStudente.getCarrieraMerito(), isVotoLaureaPrecedenteConosciuto);
	}
	
	public boolean studenteCompatibile(Integer carrieraMerito, boolean isVotoLaureaPrecedenteConosciuto) {
		if (Common.CH_T.equals(applicabilita))
			return true;
		if (Common.CH_S.equals(applicabilita) 
				&& carrieraMerito != null)
			return true;
		else if (Common.CH_P.equals(applicabilita)
				&& carrieraMerito == null)
			return true;
		if (Common.CH_X.equals(applicabilita))
		{
			if (getTipoRequisito().getId().equals(TipoRequisito.getIdTipoVotoLaurea()) && carrieraMerito == null && !isVotoLaureaPrecedenteConosciuto)
				return true;
			if (getTipoRequisito().getId().equals(TipoRequisito.getIdTipoBaseVotoLaurea()) && carrieraMerito == null && !isVotoLaureaPrecedenteConosciuto)
				return true;
		}
		return false;
	}

	public String getNomeProceduraCalcoloAutomatico() {
		return nomeProceduraCalcoloAutomatico;
	}

	public void setNomeProceduraCalcoloAutomatico(
			String nomeProceduraCalcoloAutomatico) {
		this.nomeProceduraCalcoloAutomatico = nomeProceduraCalcoloAutomatico;
	}
	
	public Long getIdOfferta() {
		return idOfferta;
	}

	public void setIdOfferta(Long idOfferta) {
		this.idOfferta = idOfferta;
	}

	public Long getIdOpzioneOfferta() {
		return idOpzioneOfferta;
	}

	public void setIdOpzioneOfferta(Long idOpzioneOfferta) {
		this.idOpzioneOfferta = idOpzioneOfferta;
	}

	public Long getIdBando() {
		return idBando;
	}

	public void setIdBando(Long idBando) {
		this.idBando = idBando;
	}

	public Long getIdDisponibilita() {
		return idDisponibilita;
	}

	public void setIdDisponibilita(Long idDisponibilita) {
		this.idDisponibilita = idDisponibilita;
	}

	public boolean isObbligatoriaAutocertificazioneInFase(FaseCandidatura fase) {
		if (faseAutocertificazione != null)
			return faseAutocertificazione <= fase.getValore();
		return false;
	}
	
	public boolean isObbligatoriaVerificaInFase(FaseCandidatura fase) {
		if (faseVerifica != null)
			return faseVerifica <= fase.getValore();
		return false;
	}
	
	public boolean isDaOpzione() {
		return getIdOpzioneOfferta() != null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((applicabilita == null) ? 0 : applicabilita.hashCode());
		result = prime * result
				+ ((descrizione == null) ? 0 : descrizione.hashCode());
		result = prime * result + ((idBando == null) ? 0 : idBando.hashCode());
		result = prime * result
				+ ((idDisponibilita == null) ? 0 : idDisponibilita.hashCode());
		result = prime * result
				+ ((idOfferta == null) ? 0 : idOfferta.hashCode());
		result = prime
				* result
				+ ((idOpzioneOfferta == null) ? 0 : idOpzioneOfferta.hashCode());
		result = prime * result
				+ ((modalita == null) ? 0 : modalita.hashCode());
		result = prime * result
				+ ((tipoRequisito == null) ? 0 : tipoRequisito.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof RequisitoOfferta))
			return false;
		RequisitoOfferta other = (RequisitoOfferta) obj;
		if (applicabilita == null) {
			if (other.applicabilita != null)
				return false;
		} else if (!applicabilita.equals(other.applicabilita))
			return false;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (idBando == null) {
			if (other.idBando != null)
				return false;
		} else if (!idBando.equals(other.idBando))
			return false;
		if (idDisponibilita == null) {
			if (other.idDisponibilita != null)
				return false;
		} else if (!idDisponibilita.equals(other.idDisponibilita))
			return false;
		if (idOfferta == null) {
			if (other.idOfferta != null)
				return false;
		} else if (!idOfferta.equals(other.idOfferta))
			return false;
		if (idOpzioneOfferta == null) {
			if (other.idOpzioneOfferta != null)
				return false;
		} else if (!idOpzioneOfferta.equals(other.idOpzioneOfferta))
			return false;
		if (modalita == null) {
			if (other.modalita != null)
				return false;
		} else if (!modalita.equals(other.modalita))
			return false;
		if (tipoRequisito == null) {
			if (other.tipoRequisito != null)
				return false;
		} else if (!tipoRequisito.equals(other.tipoRequisito))
			return false;
		return true;
	}

	public Integer getGruppoEsclusione() {
		return gruppoEsclusione;
	}

	public void setGruppoEsclusione(Integer gruppoEsclusione) {
		this.gruppoEsclusione = gruppoEsclusione;
	}
	
	public boolean isAppartieneAGruppoEsclusione() {
		return getGruppoEsclusione() != null;
	}

	public Integer getGruppoInclusione() {
		return gruppoInclusione;
	}

	public void setGruppoInclusione(Integer gruppoInclusione) {
		this.gruppoInclusione = gruppoInclusione;
	}
	
	public boolean isAppartieneAGruppoInclusione() {
		return getGruppoInclusione() != null;
	}
	
	public boolean isModalitaAutocertificazione() {
		return Common.CH_A.equals(getModalita());
	}

	public String getValoriAllegatoRichiesto() {
		return valoriAllegatoRichiesto;
	}

	public void setValoriAllegatoRichiesto(String valoriAllegatoRichiesto) {
		this.valoriAllegatoRichiesto = valoriAllegatoRichiesto;
	}
	
	public List<String> getElencoValoriAllegatoRichiesto() {
		List<String> ret = new ArrayList<String>();
		if (getValoriAllegatoRichiesto() != null)
			for (String v: getValoriAllegatoRichiesto().split(","))
				ret.add(v);
		return ret;
	}

	public Character getFlagGruppoEsclusioneEsclusivo() {
		return flagGruppoEsclusioneEsclusivo;
	}

	public void setFlagGruppoEsclusioneEsclusivo(
			Character flagGruppoEsclusioneEsclusivo) {
		this.flagGruppoEsclusioneEsclusivo = flagGruppoEsclusioneEsclusivo;
	}
	
	public boolean isGruppoEsclusioneEsclusivo() {
		return Common.CH_S.equals(getFlagGruppoEsclusioneEsclusivo());
	}

	public Long getIdSottoProgramma() {
		return idSottoProgramma;
	}

	public void setIdSottoProgramma(Long idSottoProgramma) {
		this.idSottoProgramma = idSottoProgramma;
	}

	public Character getFlagEsitoVisibileCandidato() {
		return flagEsitoVisibileCandidato;
	}

	public void setFlagEsitoVisibileCandidato(Character flagEsitoVisibileCandidato) {
		this.flagEsitoVisibileCandidato = flagEsitoVisibileCandidato;
	}
	
	public boolean isReqIscrizioneAACorrente(){
	   return (new Long (434L)).equals(this.getId()) 
		   || (new Long (440L)).equals(this.getId());
	}


	public Character getTipoSpeciale() {
		return tipoSpeciale;
	}

	public void setTipoSpeciale(Character tipoSpeciale) {
		this.tipoSpeciale = tipoSpeciale;
	}

	public String getValoreSpeciale() {
		return valoreSpeciale;
	}

	public void setValoreSpeciale(String valoreSpeciale) {
		this.valoreSpeciale = valoreSpeciale;
	}
}
