package ioc.liturgical.ws.constants;

import ioc.liturgical.ws.models.db.forms.ReferenceCreateForm;
import ioc.liturgical.ws.models.ws.forms.AuthorizationCreateForm;
import ioc.liturgical.ws.models.ws.forms.DomainCreateForm;
import ioc.liturgical.ws.models.ws.forms.LabelCreateForm;
import ioc.liturgical.ws.models.ws.forms.UserCreateForm;
import ioc.liturgical.ws.models.ws.forms.UserPasswordChangeForm;
import net.ages.alwb.utils.core.datastores.json.models.AbstractModel;

/**
 * Enumerates classes that are a form for creating a new doc.
 * 
 *  The restriction filters are applied by the WsDatastoreManager.getNewDocForms() method
 *  when a forms list is requested by a user.  
 *  
 *  If the form restriction is WS_ADMIN,
 * then only a user that is a web service admin is allowed to use it.
 * 
 * If it is restricted to ALL_DOMAINS_ADMIN, then only someone with
 * that authorization or higher (i.e. a WS_ADMIN) can use it.
 * 
 * If it is restricted to DOMAIN_ADMIN, then only someone with that
 * authorization or higher (i.e. ALL_DOMAINS_ADMIN, WS_ADMIN) can use it.
 * 
 * 
 * @author mac002
 *
 */
public enum NEW_FORM_CLASSES {
	NEW_AUTHORIZATION(
			"authorization"
			, new AuthorizationCreateForm()
			, ADMIN_ENDPOINTS.AUTHORIZATION_NEW
			, RESTRICTION_FILTERS.NONE
			)
	, NEW_DOMAIN(
			"domain"
			, new DomainCreateForm()
			, ADMIN_ENDPOINTS.DOMAINS_NEW
			, RESTRICTION_FILTERS.ALL_DOMAINS_ADMIN
			)
	, NEW_LABEL(
			"label"
			, new LabelCreateForm()
			, ADMIN_ENDPOINTS.LABELS_NEW
			, RESTRICTION_FILTERS.ALL_DOMAINS_ADMIN
			)
	, NEW_REFERENCE(
			"reference"
			, new ReferenceCreateForm()
			, ADMIN_ENDPOINTS.REFERENCES_NEW
			, RESTRICTION_FILTERS.ALL_DOMAINS_ADMIN
			)
	, NEW_USER(
			"user"
			, new UserCreateForm()
			, ADMIN_ENDPOINTS.USERS_NEW
			, RESTRICTION_FILTERS.DOMAIN_ADMIN)
	;

	public AbstractModel obj;
	public ADMIN_ENDPOINTS endpoint;
	public String name;
	public RESTRICTION_FILTERS restriction;
	
	/**
	 * 
	 * @param name of the form
	 * @param obj an instance of the form
	 * @param endpoint that is used with this form
	 * @param restriction what type of role is allowed to use this form
	 */
	private NEW_FORM_CLASSES(
			String name
			 , AbstractModel obj
			 , ADMIN_ENDPOINTS endpoint
			 , RESTRICTION_FILTERS restriction
			) {
		this.name = name;
		this.obj = obj;
		this.endpoint = endpoint;
		this.restriction = restriction;
	}
	
	/**
	 * Get the path to use for handling an http post
	 * @return
	 */
	public String toPostPath() {
		return this.endpoint.toLibraryPath() + "/" + this.name;
	}
}