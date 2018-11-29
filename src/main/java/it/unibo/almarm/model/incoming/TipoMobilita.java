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
package it.unibo.almarm.model.incoming;

import it.unibo.almarm.model.flussiscambio.Target;
import it.unibo.almarm.util.Common;

public class TipoMobilita implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	public static final long STUDENTE_DI_SCAMBIO=1L;
	private static final long ISCRIZIONE_AD_UN_CORSO=2L;
	private static final long STUDENTE_SENZA_PIANO_DI_STUDIO=3L;
	private static final long STUDENTE_TITOLO_CONGIUNTO=4L;
	public static final long DOTTORATO_DI_SCAMBIO=5L;
	private static final long DOTTORATO_IN_ISCRIZIONE=6L;
	public  static final long DOTTORATO_IN_COTUTELA=7L;
	private static final long POST_DOC=8L;
	private static final long STAFF=9L;
	private static final long TEACHING_STAFF=10L;
	private static final long DOTTORATO_DI_SCAMBIO_SENZA_PIANO=11L;
	private static final long ALTRO=12L;
	
	private Long id;
	private String nome;
	private Character flagIscrizioneCds;
	private Character flagPianoDiStudio;
	private Character flagDottorati;
	private Target target;
	private Character flagStrutturaAppartenenza;
	private Character flagCredenzialiUnibo;
	private Character flagReferenteInterno;
	private Character flagSoloScuoleODipartimenti;
	private Character flagGestioneFoto;
	private ImportoRate importoRate;
	private Character flagPassaporto;
	private Character flagDocPassaporto;
	private Character flagDocLAIncoming;

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

	public Character getFlagIscrizioneCds() {
		return flagIscrizioneCds;
	}

	public void setFlagIscrizioneCds(Character flagIscrizioneCds) {
		this.flagIscrizioneCds = flagIscrizioneCds;
	}

	public Character getFlagPianoDiStudio() {
		return flagPianoDiStudio;
	}

	public void setFlagPianoDiStudio(Character flagPianoDiStudio) {
		this.flagPianoDiStudio = flagPianoDiStudio;
	}
	
	public boolean isIscrizioneOTitoloCongiunto() {
		return id != null && (id.equals(ISCRIZIONE_AD_UN_CORSO) || id.equals(STUDENTE_TITOLO_CONGIUNTO));
	}
	
	public boolean isStudenteDiScambio() {
		return id != null && id.equals(STUDENTE_DI_SCAMBIO);
	}
	
	public boolean isStudenteSenzaPianoDiStudio() {
		return id != null && id.equals(STUDENTE_SENZA_PIANO_DI_STUDIO);
	}
	
	public boolean isDottoratoDiScambio() {
		return id != null && id.equals(DOTTORATO_DI_SCAMBIO);
	}
	
	public boolean isDottoratoDiScambioSenzaPiano() {
		return id != null && id.equals(DOTTORATO_DI_SCAMBIO_SENZA_PIANO);
	}
	
	public boolean isDottoratoInIscrizione() {
		return id != null && id.equals(DOTTORATO_IN_ISCRIZIONE);
	}

	public boolean isDottoratoInCotutela() {
		return id != null && id.equals(DOTTORATO_IN_COTUTELA);
	}
	
	@Override
	public String toString() {
		return id != null ? id.toString() : "";
	}
	
	public boolean getIscrizioneCdsAttiva() {
		return Common.CH_S.equals(flagIscrizioneCds);
	}

	public Character getFlagDottorati() {
		return flagDottorati;
	}

	public void setFlagDottorati(Character flagDottorati) {
		this.flagDottorati = flagDottorati;
	}
	
	public boolean isDottorato() {
		return Common.CH_S.equals(getFlagDottorati());
	}

	public Target getTarget() {
		return target;
	}

	public void setTarget(Target target) {
		this.target = target;
	}

	public Character getFlagStrutturaAppartenenza() {
		return flagStrutturaAppartenenza;
	}

	public void setFlagStrutturaAppartenenza(Character flagStrutturaAppartenenza) {
		this.flagStrutturaAppartenenza = flagStrutturaAppartenenza;
	}
	
	public boolean isStrutturaAppartenenzaAttivo() {
		return Common.CH_S.equals(getFlagStrutturaAppartenenza());
	}

	public Character getFlagCredenzialiUnibo() {
		return flagCredenzialiUnibo;
	}

	public void setFlagCredenzialiUnibo(Character flagCredenzialiUnibo) {
		this.flagCredenzialiUnibo = flagCredenzialiUnibo;
	}
	
	public boolean isCredenzialiUniboAttivo() {
		return Common.CH_S.equals(getFlagCredenzialiUnibo());
	}

	public Character getFlagReferenteInterno() {
		return flagReferenteInterno;
	}

	public void setFlagReferenteInterno(Character flagReferenteInterno) {
		this.flagReferenteInterno = flagReferenteInterno;
	}
	
	public boolean isReferenteInternoAttivo() {
		return Common.CH_S.equals(getFlagReferenteInterno());
	}
	
	public boolean isPostDoc() {
		return id != null && getId().equals(POST_DOC);
	}
	
	public boolean isStaff() {
		return id != null && getId().equals(STAFF);
	}
	
	public boolean isTeachingStaff() {
		return id != null && getId().equals(TEACHING_STAFF);
	}
	
	public boolean isAltro() {
		return id != null && getId().equals(ALTRO);
	}
	
	public Character getCategoria() {
		if (isPostDoc() || isStaff() || isTeachingStaff() || isAltro())
			return 'P';
		if (isDottoratoDiScambio() || isDottoratoInIscrizione() || isDottoratoInCotutela() || isDottoratoDiScambioSenzaPiano())
			return 'D';
		if (isStudenteDiScambio() || isIscrizioneOTitoloCongiunto() || isStudenteSenzaPianoDiStudio())
			return 'S';
		return null;
	}
	
	public ImportoRate getImportoRate() {
		return importoRate;
	}

	public void setImportoRate(ImportoRate importoRate) {
		this.importoRate = importoRate;
	}

	public Character getFlagSoloScuoleODipartimenti() {
		return flagSoloScuoleODipartimenti;
	}

	public void setFlagSoloScuoleODipartimenti(Character flagSoloScuoleODipartimenti) {
		this.flagSoloScuoleODipartimenti = flagSoloScuoleODipartimenti;
	}
	
	public boolean isSoloScuoleODipartimenti() {
		return Common.CH_S.equals(getFlagSoloScuoleODipartimenti());
	}
	
	public Character getFlagGestioneFoto() {
		return flagGestioneFoto;
	}

	public void setFlagGestioneFoto(Character flagGestioneFoto) {
		this.flagGestioneFoto = flagGestioneFoto;
	}
	
	public boolean isGestioneFotoAbilitata() {
		return Common.CH_S.equals(getFlagGestioneFoto());
	}
	
	public boolean isStudente() {
		return isStudenteDiScambio() || isIscrizioneOTitoloCongiunto() || isStudenteSenzaPianoDiStudio();
	}
	
	public Character getFlagPassaporto() {
		return flagPassaporto;
	}

	public void setFlagPassaporto(Character flagPassaporto) {
		this.flagPassaporto = flagPassaporto;
	}

	public boolean isPassaportoGestito() {
		return !Common.CH_N.equals(flagPassaporto == null ? Common.CH_N : flagPassaporto);
	}
	public boolean isPassaportoObbligatorio() {
		return Common.CH_S.equals(flagPassaporto);
	}

	public Character getFlagDocPassaporto() {
		return flagDocPassaporto;
	}
	public void setFlagDocPassaporto(Character flagDocPassaporto) {
		this.flagDocPassaporto = flagDocPassaporto;
	}

	public boolean isDocPassaportoGestito() {
		return !Common.CH_N.equals(flagDocPassaporto == null ? Common.CH_N : flagDocPassaporto);
	}
	public boolean isDocPassaportoObbligatorio() {
		return Common.CH_S.equals(flagDocPassaporto);
	}

	public Character getFlagDocLAIncoming() {
		return flagDocLAIncoming;
	}

	public void setFlagDocLAIncoming(Character flagDocLAIncoming) {
		this.flagDocLAIncoming = flagDocLAIncoming;
	}
	
	public boolean isDocLAIncomingGestito() {
		return Common.CH_S.equals(flagDocLAIncoming);
	}

    public boolean isStudenteODottorando() {
        return isStudente() || isDottorato();
    }
}
