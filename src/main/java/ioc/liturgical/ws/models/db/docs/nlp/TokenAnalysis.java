package ioc.liturgical.ws.models.db.docs.nlp;

import com.google.gson.annotations.Expose;

import ioc.liturgical.ws.constants.Constants;
import ioc.liturgical.ws.constants.db.external.LIBRARIES;
import ioc.liturgical.ws.constants.db.external.TOPICS;
import ioc.liturgical.ws.models.db.forms.TokenAnalysisCreateForm;
import ioc.liturgical.ws.models.db.supers.LTKDb;
import net.ages.alwb.utils.core.misc.AlwbGeneralUtils;

import com.github.reinert.jjschema.Attributes;

/**
 * Holds information about the grammatical analysis of a token from a text.
 * A token can be a word or a punctuation mark.
 * 
 * TODO: Note that the long-term solution is to store such information using the
 * NLP model  corresponding to the part-of-speech of the token.
 * 
 * So, this is just a temporary solution.
 * 
 * @author mac002
 *
 */
@Attributes(title = "Token Analysis", description = "Grammatical analysis of a token")
public class TokenAnalysis extends LTKDb {
	
	private static String schema = TokenAnalysis.class.getSimpleName();
	private static double version = 1.1;
	private static TOPICS ontoTopic = TOPICS.WORD_GRAMMAR;

    @Expose String dependsOn = "";
    @Expose String token = "";
    @Expose String lemma = "";
    @Expose String gloss = "";
    @Expose String label = "";
    @Expose String gCase = "";
    @Expose String gender = "";
    @Expose String mood = "";
    @Expose String number = "";
    @Expose String person = "";
    @Expose String pos = "";
    @Expose String tense = "";
    @Expose String voice = "";
    @Expose String grammar = "";
    @Expose String seq = "";

	public TokenAnalysis(
			String topic
			, String key
			) {
		super(
				LIBRARIES.LINGUISTICS.toSystemDomain()
				, topic
				, key
				, schema
				,  version
				, ontoTopic
				);
		this.seq = this.toSeq();
	}

	public TokenAnalysis(
			String topic
			, String key
			, TokenAnalysisCreateForm form
			) {
		super(
				LIBRARIES.LINGUISTICS.toSystemDomain()
				, topic
				, key
				, schema
				,  version
				, ontoTopic
				);
		this.dependsOn = form.getDependsOn();
		this.gCase = form.getgCase();
		this.gender = form.getGender();
		this.gloss = form.getGloss();
		this.grammar = form.getGrammar();
		this.label = form.getLabel();
		this.lemma = form.getLemma();
		this.mood = form.getMood();
		this.number = form.getNumber();
		this.person = form.getPerson();
		this.pos = form.getPos();
		this.tense = form.getTense();
		this.voice = form.getVoice();
		this.tags = form.getTags();
		this.seq = this.toSeq();
	}

	private String toSeq() {
		return 
				this.library 
				+ Constants.ID_DELIMITER 
				+ this.topic 
				+ Constants.ID_DELIMITER 
				+ AlwbGeneralUtils.padNumber(
						"0"
						, 3
						, Integer.parseInt(this.key )
				);

	}

	public String getDependsOn() {
		return dependsOn;
	}

	public void setDependsOn(String dependsOn) {
		this.dependsOn = dependsOn;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getLemma() {
		return lemma;
	}

	public void setLemma(String lemma) {
		this.lemma = lemma;
	}

	public String getGloss() {
		return gloss;
	}

	public void setGloss(String gloss) {
		this.gloss = gloss;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getgCase() {
		return gCase;
	}

	public void setgCase(String gCase) {
		this.gCase = gCase;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMood() {
		return mood;
	}

	public void setMood(String mood) {
		this.mood = mood;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getTense() {
		return tense;
	}

	public void setTense(String tense) {
		this.tense = tense;
	}

	public String getVoice() {
		return voice;
	}

	public void setVoice(String voice) {
		this.voice = voice;
	}

	public String getGrammar() {
		return grammar;
	}

	public void setGrammar(String grammar) {
		this.grammar = grammar;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

}
