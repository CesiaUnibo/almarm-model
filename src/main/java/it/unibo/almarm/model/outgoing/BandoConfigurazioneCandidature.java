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

import it.unibo.almarm.util.Common;

import java.util.Date;

public class BandoConfigurazioneCandidature implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private static Integer VIS_NESSUNO = 0;
	private static Integer VIS_STUDENTE = 1;
	private static Integer VIS_OPERATORE = 2;
	private static Integer VIS_COMMISSIONE = 4;

	private Long id;
	private Bando bando;
	private Character iscrizioneAACorrenteObb;
	private Integer iscrizioneAACorrenteVis;
	private String iscrizioneAACorrenteSP;
	private Character mediaAritmeticaObb;
	private Character mediaAritmeticaAppl;
	private Integer mediaAritmeticaVis;
	private String mediaAritmeticaSP;
	private Date mediaAritmeticaData;
	private Character mediaPonderataObb;
	private Character mediaPonderataAppl;
	private Integer mediaPonderataVis;
	private String mediaPonderataSP;
	private Date mediaPonderataData;
	private Character mediaNormalizzataObb;
	private Character mediaNormalizzataAppl;
	private Integer mediaNormalizzataVis;
	private String mediaNormalizzataSP;
	private Date mediaNormalizzataData;
	private Character creditiObb;
	private Character creditiAppl;
	private Integer creditiVis;
	private String creditiSP;
	private Date creditiData;
	private Character annoCorsoObb;
	private Character annoCorsoAppl;
	private Integer annoCorsoVis;
	private String annoCorsoSP;
	private Character annoImmaObb;
	private Character annoImmaAppl;
	private Integer annoImmaVis;
	private String annoImmaSP;
	private Character tipoCorsoObb;
	private Character tipoCorsoAppl;
	private Integer tipoCorsoVis;
	private String tipoCorsoSP;
	private Character durataObb;
	private Character durataAppl;
	private Integer durataVis;
	private String durataSP;
	private Character sessioneLaureaObb;
	private Character sessioneLaureaAppl;
	private Integer sessioneLaureaVis;
	private String sessioneLaureaSP;
	
	private Character statoCarrieraObb;
	private Character statoCarrieraAppl;
	private Integer statoCarrieraVis;
	private String statoCarrieraSP;

	private Character votoLaureaObb;
	private Character votoLaureaAppl;
	private Integer votoLaureaVis;
	private String votoLaureaSP;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Bando getBando() {
		return bando;
	}

	public void setBando(Bando bando) {
		this.bando = bando;
	}

	public Character getIscrizioneAACorrenteObb() {
		if (iscrizioneAACorrenteObb == null)
			return 'N';
		return iscrizioneAACorrenteObb;
	}

	public void setIscrizioneAACorrenteObb(Character iscrizioneAACorrenteObb) {
		this.iscrizioneAACorrenteObb = iscrizioneAACorrenteObb;
	}

	public Integer getIscrizioneAACorrenteVis() {
		if (iscrizioneAACorrenteVis == null)
			return 0;
		return iscrizioneAACorrenteVis;
	}

	public void setIscrizioneAACorrenteVis(Integer iscrizioneAACorrenteVis) {
		this.iscrizioneAACorrenteVis = iscrizioneAACorrenteVis;
	}

	public String getIscrizioneAACorrenteSP() {
		return iscrizioneAACorrenteSP;
	}

	public void setIscrizioneAACorrenteSP(String iscrizioneAACorrenteSP) {
		this.iscrizioneAACorrenteSP = iscrizioneAACorrenteSP;
	}

	public Character getMediaAritmeticaObb() {
		if (mediaAritmeticaObb == null)
			return 'N';
		return mediaAritmeticaObb;
	}

	public void setMediaAritmeticaObb(Character mediaAritmeticaObb) {
		this.mediaAritmeticaObb = mediaAritmeticaObb;
	}

	public Character getMediaAritmeticaAppl() {
		return mediaAritmeticaAppl;
	}

	public void setMediaAritmeticaAppl(Character mediaAritmeticaAppl) {
		this.mediaAritmeticaAppl = mediaAritmeticaAppl;
	}

	public Integer getMediaAritmeticaVis() {
		if (mediaAritmeticaVis == null)
			return 0;
		return mediaAritmeticaVis;
	}

	public void setMediaAritmeticaVis(Integer mediaAritmeticaVis) {
		this.mediaAritmeticaVis = mediaAritmeticaVis;
	}

	public String getMediaAritmeticaSP() {
		return mediaAritmeticaSP;
	}

	public void setMediaAritmeticaSP(String mediaAritmeticaSP) {
		this.mediaAritmeticaSP = mediaAritmeticaSP;
	}

	public Date getMediaAritmeticaData() {
		return mediaAritmeticaData;
	}

	public void setMediaAritmeticaData(Date mediaAritmeticaData) {
		this.mediaAritmeticaData = mediaAritmeticaData;
	}

	public Character getMediaPonderataObb() {
		if (mediaPonderataObb == null)
			return 'N';
		return mediaPonderataObb;
	}

	public void setMediaPonderataObb(Character mediaPonderataObb) {
		this.mediaPonderataObb = mediaPonderataObb;
	}

	public Character getMediaPonderataAppl() {
		return mediaPonderataAppl;
	}

	public void setMediaPonderataAppl(Character mediaPonderataAppl) {
		this.mediaPonderataAppl = mediaPonderataAppl;
	}

	public Integer getMediaPonderataVis() {
		if (mediaPonderataVis == null)
			return 0;
		return mediaPonderataVis;
	}

	public void setMediaPonderataVis(Integer mediaPonderataVis) {
		this.mediaPonderataVis = mediaPonderataVis;
	}

	public String getMediaPonderataSP() {
		return mediaPonderataSP;
	}

	public void setMediaPonderataSP(String mediaPonderataSP) {
		this.mediaPonderataSP = mediaPonderataSP;
	}

	public Date getMediaPonderataData() {
		return mediaPonderataData;
	}

	public void setMediaPonderataData(Date mediaPonderataData) {
		this.mediaPonderataData = mediaPonderataData;
	}

	public Character getMediaNormalizzataObb() {
		if (mediaNormalizzataObb == null)
			return 'N';
		return mediaNormalizzataObb;
	}

	public void setMediaNormalizzataObb(Character mediaNormalizzataObb) {
		this.mediaNormalizzataObb = mediaNormalizzataObb;
	}

	public Character getMediaNormalizzataAppl() {
		return mediaNormalizzataAppl;
	}

	public void setMediaNormalizzataAppl(Character mediaNormalizzataAppl) {
		this.mediaNormalizzataAppl = mediaNormalizzataAppl;
	}

	public Integer getMediaNormalizzataVis() {
		if (mediaNormalizzataVis == null)
			return 0;
		return mediaNormalizzataVis;
	}

	public void setMediaNormalizzataVis(Integer mediaNormalizzataVis) {
		this.mediaNormalizzataVis = mediaNormalizzataVis;
	}

	public String getMediaNormalizzataSP() {
		return mediaNormalizzataSP;
	}

	public void setMediaNormalizzataSP(String mediaNormalizzataSP) {
		this.mediaNormalizzataSP = mediaNormalizzataSP;
	}

	public Date getMediaNormalizzataData() {
		return mediaNormalizzataData;
	}

	public void setMediaNormalizzataData(Date mediaNormalizzataData) {
		this.mediaNormalizzataData = mediaNormalizzataData;
	}

	public Character getCreditiObb() {
		if (creditiObb == null)
			return 'N';
		return creditiObb;
	}

	public void setCreditiObb(Character creditiObb) {
		this.creditiObb = creditiObb;
	}

	public Character getCreditiAppl() {
		return creditiAppl;
	}

	public void setCreditiAppl(Character creditiAppl) {
		this.creditiAppl = creditiAppl;
	}

	public Integer getCreditiVis() {
		if (creditiVis == null)
			return 0;
		return creditiVis;
	}

	public void setCreditiVis(Integer creditiVis) {
		this.creditiVis = creditiVis;
	}

	public String getCreditiSP() {
		return creditiSP;
	}

	public void setCreditiSP(String creditiSP) {
		this.creditiSP = creditiSP;
	}

	public Date getCreditiData() {
		return creditiData;
	}

	public void setCreditiData(Date creditiData) {
		this.creditiData = creditiData;
	}

	public Character getAnnoCorsoObb() {
		if (annoCorsoObb == null)
			return 'N';
		return annoCorsoObb;
	}

	public void setAnnoCorsoObb(Character annoCorsoObb) {
		this.annoCorsoObb = annoCorsoObb;
	}

	public Character getAnnoCorsoAppl() {
		return annoCorsoAppl;
	}

	public void setAnnoCorsoAppl(Character annoCorsoAppl) {
		this.annoCorsoAppl = annoCorsoAppl;
	}

	public Integer getAnnoCorsoVis() {
		if (annoCorsoVis == null)
			return 0;
		return annoCorsoVis;
	}

	public void setAnnoCorsoVis(Integer annoCorsoVis) {
		this.annoCorsoVis = annoCorsoVis;
	}

	public String getAnnoCorsoSP() {
		return annoCorsoSP;
	}

	public void setAnnoCorsoSP(String annoCorsoSP) {
		this.annoCorsoSP = annoCorsoSP;
	}

	public Character getAnnoImmaObb() {
		if (annoImmaObb == null)
			return 'N';
		return annoImmaObb;
	}

	public void setAnnoImmaObb(Character annoImmaObb) {
		this.annoImmaObb = annoImmaObb;
	}

	public Character getAnnoImmaAppl() {
		return annoImmaAppl;
	}

	public void setAnnoImmaAppl(Character annoImmaAppl) {
		this.annoImmaAppl = annoImmaAppl;
	}

	public Integer getAnnoImmaVis() {
		if (annoImmaVis == null)
			return 0;
		return annoImmaVis;
	}

	public void setAnnoImmaVis(Integer annoImmaVis) {
		this.annoImmaVis = annoImmaVis;
	}

	public String getAnnoImmaSP() {
		return annoImmaSP;
	}

	public void setAnnoImmaSP(String annoImmaSP) {
		this.annoImmaSP = annoImmaSP;
	}

	public Character getTipoCorsoObb() {
		if (tipoCorsoObb == null)
			return 'N';
		return tipoCorsoObb;
	}

	public void setTipoCorsoObb(Character tipoCorsoObb) {
		this.tipoCorsoObb = tipoCorsoObb;
	}

	public Character getTipoCorsoAppl() {
		return tipoCorsoAppl;
	}

	public void setTipoCorsoAppl(Character tipoCorsoAppl) {
		this.tipoCorsoAppl = tipoCorsoAppl;
	}

	public Integer getTipoCorsoVis() {
		if (tipoCorsoVis == null)
			return 0;
		return tipoCorsoVis;
	}

	public void setTipoCorsoVis(Integer tipoCorsoVis) {
		this.tipoCorsoVis = tipoCorsoVis;
	}

	public String getTipoCorsoSP() {
		return tipoCorsoSP;
	}

	public void setTipoCorsoSP(String tipoCorsoSP) {
		this.tipoCorsoSP = tipoCorsoSP;
	}

	public Character getDurataObb() {
		if (durataObb == null)
			return 'N';
		return durataObb;
	}

	public void setDurataObb(Character durataObb) {
		this.durataObb = durataObb;
	}

	public Character getDurataAppl() {
		return durataAppl;
	}

	public void setDurataAppl(Character durataAppl) {
		this.durataAppl = durataAppl;
	}

	public Integer getDurataVis() {
		if (durataVis == null)
			return 0;
		return durataVis;
	}

	public void setDurataVis(Integer durataVis) {
		this.durataVis = durataVis;
	}

	public String getDurataSP() {
		return durataSP;
	}

	public void setDurataSP(String durataSP) {
		this.durataSP = durataSP;
	}

	public Character getSessioneLaureaObb() {
		if (sessioneLaureaObb == null)
			return 'N';
		return sessioneLaureaObb;
	}

	public void setSessioneLaureaObb(Character sessioneLaureaObb) {
		this.sessioneLaureaObb = sessioneLaureaObb;
	}

	public Character getSessioneLaureaAppl() {
		return sessioneLaureaAppl;
	}

	public void setSessioneLaureaAppl(Character sessioneLaureaAppl) {
		this.sessioneLaureaAppl = sessioneLaureaAppl;
	}

	public Integer getSessioneLaureaVis() {
		if (sessioneLaureaVis == null)
			return 0;
		return sessioneLaureaVis;
	}

	public void setSessioneLaureaVis(Integer sessioneLaureaVis) {
		this.sessioneLaureaVis = sessioneLaureaVis;
	}

	public String getSessioneLaureaSP() {
		return sessioneLaureaSP;
	}

	public void setSessioneLaureaSP(String sessioneLaureaSP) {
		this.sessioneLaureaSP = sessioneLaureaSP;
	}
	
	public Character getStatoCarrieraObb() {
		if (statoCarrieraObb == null)
			return 'N';
		return statoCarrieraObb;
	}

	public void setStatoCarrieraObb(Character statoCarrieraObb) {
		this.statoCarrieraObb = statoCarrieraObb;
	}

	public Character getStatoCarrieraAppl() {
		return statoCarrieraAppl;
	}

	public void setStatoCarrieraAppl(Character statoCarrieraAppl) {
		this.statoCarrieraAppl = statoCarrieraAppl;
	}

	public Integer getStatoCarrieraVis() {
		if (statoCarrieraVis == null)
			return 0;
		return statoCarrieraVis;
	}

	public void setStatoCarrieraVis(Integer statoCarrieraVis) {
		this.statoCarrieraVis = statoCarrieraVis;
	}

	public String getStatoCarrieraSP() {
		return statoCarrieraSP;
	}

	public void setStatoCarrieraSP(String statoCarrieraSP) {
		this.statoCarrieraSP = statoCarrieraSP;
	}

	public Character getVotoLaureaObb() {
		if (votoLaureaObb == null)
			return 'N';
		return votoLaureaObb;
	}
	
	public void setVotoLaureaObb(Character votoLaureaObb) {
		this.votoLaureaObb = votoLaureaObb;
	}

	public Character getVotoLaureaAppl() {
		return votoLaureaAppl;
	}

	public void setVotoLaureaAppl(Character votoLaureaAppl) {
		this.votoLaureaAppl = votoLaureaAppl;
	}

	public Integer getVotoLaureaVis() {
		if (votoLaureaVis == null)
			return 0;
		return votoLaureaVis;
	}

	public void setVotoLaureaVis(Integer votoLaureaVis) {
		this.votoLaureaVis = votoLaureaVis;
	}

	public String getVotoLaureaSP() {
		return votoLaureaSP;
	}

	public void setVotoLaureaSP(String votoLaureaSP) {
		this.votoLaureaSP = votoLaureaSP;
	}

	public static boolean isApplicabileTutti(Character app) {
		return Common.CH_T.equals(app);
	}
	
	public static boolean isApplicabileStudente(Character app) {
		return Common.CH_S.equals(app);
	}
	
	public static boolean isApplicabilePreiscritti(Character app) {
		return Common.CH_P.equals(app);
	}
	
	public static boolean isVisibileANessuno(Integer vis) {
		return (VIS_NESSUNO.equals(vis));
	}
	
	public static boolean isVisibileAStudente(Integer vis) {
		return ((vis & VIS_STUDENTE) == VIS_STUDENTE);
	}
	
	public static boolean isVisibileAOperatore(Integer vis) {
		return ((vis & VIS_OPERATORE) == VIS_OPERATORE);
	}
	
	public static boolean isVisibileACommissione(Integer vis) {
		return ((vis & VIS_COMMISSIONE) == VIS_COMMISSIONE);
	}
}
