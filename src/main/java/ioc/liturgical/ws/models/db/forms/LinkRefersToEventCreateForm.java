package ioc.liturgical.ws.models.db.forms;

import com.google.gson.annotations.Expose;

import ioc.liturgical.ws.annotations.UiWidget;
import ioc.liturgical.ws.constants.Constants;
import ioc.liturgical.ws.constants.ONTOLOGY_TOPICS;
import ioc.liturgical.ws.constants.RELATIONSHIP_TYPES;
import ioc.liturgical.ws.models.db.supers.LTKLinkCreateForm;

import com.github.reinert.jjschema.Attributes;

/**
 * This class provides a POJO for use in web forms to create or update a reference
 * @author mac002
 *
 */
@Attributes(title = "Reference to an Event", description = "This is a doc that records information about a reference made in a text to some event.")
public class LinkRefersToEventCreateForm extends LTKLinkCreateForm {
	
	private static double serialVersion = 1.1;
	private static String schema = LinkRefersToEventCreateForm.class.getSimpleName();
	private static RELATIONSHIP_TYPES type = RELATIONSHIP_TYPES.REFERS_TO_EVENT;
	private static ONTOLOGY_TOPICS ontoTopic = ONTOLOGY_TOPICS.EVENT;

	@UiWidget(Constants.UI_WIDGET_TEXTAREA)
	@Attributes(required = false, description = "Word or phrase that makes the reference")
	@Expose public String referredByPhrase = "";

	@UiWidget(Constants.UI_WIDGET_TEXTAREA)
	@Attributes(required = false, description = "Comments on the reference")
	@Expose public String comments = "";

	public LinkRefersToEventCreateForm(
			String library
			, String topic
			, String key
			) {
		super(
				library
				, topic
				, key
				, LinkRefersToEventCreateForm.schema
				,  LinkRefersToEventCreateForm.serialVersion
				, LinkRefersToEventCreateForm.type
				, LinkRefersToEventCreateForm.ontoTopic
				);
	}
	
	public String getReferredByPhrase() {
		return referredByPhrase;
	}

	public void setReferredByPhrase(String referredByPhrase) {
		this.referredByPhrase = referredByPhrase;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}