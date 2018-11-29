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

public class Diritti {
	public static enum DirittiGestioneUniversita
	{
		UNI_VIS,
		UNI_INS,
		UNI_MOD,
		UFFICIO_INS,
		UFFICIO_MOD,
		UFFICIO_DEL,
		REF_INS,
		REF_MOD,
		REF_DEL
	}
	
	public static enum DirittiGestioneAccordoIstituzionali
	{
		ACC_IST_VIS,
		ACC_IST_VIS_HP,
		RINNOVO_ACC_IST,
		ACC_IST_EXP
	}
	
	public static enum DirittiGestioneAccordiOperativi
	{
		ACC_OP_VIS,
		ACC_OP_VIS_HP,
		RINNOVO_ACC_OP,
		ACC_OP_REFERENTI_MOD,
		ACC_OP_CREA_ANNUALIZZAZIONE,
		SCAMBIO_INS,
		SCAMBIO_DEL,
		SCAMBIO_MOD,
		SCAMBIO_MOD_FAC,
		ACC_OP_RINN_VIS,
		ACC_OP_RINN_VIS_HP,
		ESEC_ACC_INS,
		DATI_INVIO_RINNOVO_MOD,
		STAMPA_DOC_RINNOVO_ACC,
		ESEC_ACC_DEL,
		ESEC_ACC_CAPABILITY_DOC_MOD,
		ACC_OP_PROROGA_MOD,
		INVIO_EMAIL_MASS_RINNOVO,
		ESEC_ACC_RIFIUTA_RINNOVA_SPOSTA_OFF,
		ESEC_ACC_VIS_DATI_ITER,
		ACC_OP_EXP, 
		ACC_OP_CREA_COTUTELA_INT
	}
	
	public static enum DirittiGestioneNomine
	{
		NOMINE_VIS,
		NOMINE_VIS_HP,
		NOMINA_INS,
		NOMINA_MOD,
		NOMINA_DEL,
		NOMINA_SEND_MAIL,
		NOMINA_COTUTELE_DOTTO_INS,
		NOMINA_GEST_VAL
	}
	
	public static enum DirittiGestioneIncoming
	{
		INCOMING_VIS,
		INCOMING_VIS_HP,
		INCOMING_STAMPE,
		INCOMING_CREA_CARRIERA,
		STAMPA_MASSIVA_INCOMING,
		INCOMING_ISCRIVI_AA_ERASMUS,
		INCOMING_INVIA_EMAIL_TR,
		STAMPA_AUTOCERT_ARRIVO_IMMIGRAZIONE_INCOMING,
		MOD_MODALITA_PAGAMENTO,
		INCOMING_CREA_MINI_CARRIERA,
		INCOMING_CREA_MINI_CARRIERA_EST,
		RINUNCIA_INCOMING
	}
	
	public static enum DirittiGestioneProgrammi
	{
		PROGR_VIS,
		PROGR_MOD /* INSERT, UPDATE, DELETE */
	}
	
	public static enum DirittiGestioneCredenziali
	{
		CREA_CREDENZIALI
	}
	
	public static enum DirittiGestioneGenerale
	{
		IMPERSONAMENTO,
		IMPERSONAMENTO_STUDENTE,
		ISCR_P_LING_VIS,
		VISUALIZZAZIONE_UTENTI_CONTESTI,
		GESTIONE_UTENTI_CONTESTI,
		GESTIONE_UTENTI_CONTESTI_COMPLETA,
		ESECUZIONE_JOB
	}
	
	public static enum DirittiGestioneCandidature
	{
		CANDIDATURE_VIS,
		GRADUATORIE_VIS,
		CALCOLO_OGGETTIVO,
		ASSEGNA_SUBENTRO
	}
	
	public static enum DirittiGestioneBandi
	{
		BANDI_VIS,
		BANDI_MOD
	}

	public static enum DirittiGestioneOfferte
	{
		OFFERTE_VIS,
		OFFERTE_MOD,
		OFFERTE_MOD_SUPER,
		PREVIEW_OFFERTE,
		PREVIEW_CANDIDATURE
	}
	
	public static enum DirittiGestioneStudentiOutgoing
	{
		STUD_OUTGOING_VIS,
		STUDENTI_OUTGOING_VIS_HP,
		STUD_OUT_STAMPA_CONTR,
		MOD_MODALITA_PAGAMENTO,
		OUTGOING_CREA_MINI_CARRIERA,
		OUTGOING_CREA_MINI_CARRIERA_EST,
		PRESENTA_RICHIESTA_RICONOSCIMENTO,
		RICHIESTA_RICONOSCIMENTO_VIS_HP,
		VALIDA_TR,
		UPLOAD_TR, 
		ANNULLA_VALIDAZIONE_TR,
		PRESENTA_RICHIESTA_RICONOSCIMENTO_NO_LIMITS,
		ANNULLA_VALIDAZIONE_RICH_PROL,
		VALIDA_RICH_PROL,
		MONITOR_LA_RR_VIS, 
		INVII_NOMINE,
		RICHIESTA_RICONOSCIMENTO_MONITOR_VIS_HP, 
		STUD_OUT_VALIDA_CONTRATTO_FIRMATO,
		STUD_OUT_ANNULLA_VALIDAZIONE_CONTRATTO_FIRMATO, 
		STUD_OUT_CARICA_CONTRATTO_FIRMATO,
		STUD_OUTGOING_TUTTI_BANDI
	}
	
	public static enum DirittiGestioneLearningAgreement
	{
		LEARNING_AGREEMENT_INS,
		LEARNING_AGREEMENT_VIS_HP,
		INVIO_EMAIL_MASS_PRES_LA, 
		VALIDA_LA_FIRMATO,
		STAMPA_LA_EPLUS,
		LEARNING_AGREEMENT_MONITOR_VIS_HP
	}
	
	public static enum DirittiGestionePagamenti
	{
		PAGAMENTI_COMPLETO,
		PAGAMENTI_VISUALIZZAZIONE,
		INSERIMENTO_RESTITUZIONI
	}
	
	public static enum DirittiGestionePagamentiIncoming
	{
		PAGAMENTI_INCOMING_COMPLETO,
		INSERIMENTO_RESTITUZIONI_INCOMING
	}
	
	public static enum DirittiGestioneTrasparenza
	{
		TRASPARENZA_GRUPPI_COMPLETO
	}
	
	public static enum DirittiGestioneStaff
	{
		STAFF_COMPLETO
	}
}
