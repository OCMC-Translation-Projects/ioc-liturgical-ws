package ioc.liturgical.ws.constants;

import ioc.liturgical.ws.constants.Constants;

/**
 * Enum for REST endpoints for the Database api.
 * Used to give info to requestor about what endpoints are available.
 * The order in which they are listed below is the order in which they
 * will appear in the list in the UI.  So add new ones at the appropriate
 * position in the enum list!
 * 
 *               
 * @author mac002
 *
 */
public enum ENDPOINTS_DB_API {
	ANIMALS(
			"animals"
			, ENDPOINT_TYPES.ONTOLOGY
			, "Animals"
			,"Endpoint for animal docs"
			)
	, BEINGS(
			"beings"
			, ENDPOINT_TYPES.ONTOLOGY
			, "Beings"
			,"Endpoint for being docs"
			)
	, CONCEPTS(
			"concepts"
			, ENDPOINT_TYPES.ONTOLOGY
			, "Concepts"
			,"Endpoint for abstract concept docs"
			)
	, DOCS(
			""
			, ENDPOINT_TYPES.NODE
			, ""
			,"Endpoint for generic docs"
			)
	, DOMAINS(
			"domains"
			, ENDPOINT_TYPES.NODE
			, "domain"
			,"Endpoint for domains."
			)
	, DROPDOWNS_DOMAINS(
			"domains"
			, ENDPOINT_TYPES.DROPDOWNS
			, "domain"
			,"Endpoint for dropdown values for domains."
			)
	, DROPDOWNS_RELATIONSHIPS(
			"relationships"
			, ENDPOINT_TYPES.DROPDOWNS
			, "domain"
			,"Endpoint for dropdown values to search properties of relationships."
			)
	, DROPDOWNS_TEXTS(
			"texts"
			, ENDPOINT_TYPES.DROPDOWNS
			, "domain"
			,"Endpoint for dropdown values to search docs of type text."
			)
	, GROUPS(
			"groups"
			, ENDPOINT_TYPES.ONTOLOGY
			, "Groups"
			,"Endpoint for group docs"
			)
	, HUMANS(
			"humans"
			, ENDPOINT_TYPES.ONTOLOGY
			, "Humans"
			,"Endpoint for human docs"
			)
	, LABELS(
			"labels"
			, ENDPOINT_TYPES.NODE
			, "label"
			,"Endpoint for labels."
			)
	, LINKS(
			""
			, ENDPOINT_TYPES.RELATIONSHIP
			, ""
			,"Generic Endpoint for Relationships with properties"
			)
	, LINK_REFERS_TO_ANIMAL(
			RELATIONSHIP_TYPES.REFERS_TO_ANIMAL.typename.toLowerCase()
			, ENDPOINT_TYPES.RELATIONSHIP
			, RELATIONSHIP_TYPES.REFERS_TO_ANIMAL.typename
			,"Endpoint for text refers to an animal"
			)
	, LINK_REFERS_TO_BEING(
			RELATIONSHIP_TYPES.REFERS_TO_BEING.typename.toLowerCase()
			, ENDPOINT_TYPES.RELATIONSHIP
			, RELATIONSHIP_TYPES.REFERS_TO_BEING.typename
			,"Endpoint for text refers to a being"
			)
	, LINK_REFERS_TO_BIBLICAL_TEXT(
			"refers_to_biblical_text"
			, ENDPOINT_TYPES.RELATIONSHIP
			, RELATIONSHIP_TYPES.REFERS_TO_BIBLICAL_TEXT.typename
			,"Endpoint for text refers to a biblical text"
			)
	, LINK_REFERS_TO_CONCEPT(
			RELATIONSHIP_TYPES.REFERS_TO_CONCEPT.typename.toLowerCase()
			, ENDPOINT_TYPES.RELATIONSHIP
			, RELATIONSHIP_TYPES.REFERS_TO_CONCEPT.typename
			,"Endpoint for text refers to a concept"
			)
	, LINK_REFERS_TO_EVENT(
			RELATIONSHIP_TYPES.REFERS_TO_EVENT.typename.toLowerCase()
			, ENDPOINT_TYPES.RELATIONSHIP
			, RELATIONSHIP_TYPES.REFERS_TO_EVENT.typename
			,"Endpoint for text refers to an event"
			)
	, LINK_REFERS_TO_GROUP(
			RELATIONSHIP_TYPES.REFERS_TO_GROUP.typename.toLowerCase()
			, ENDPOINT_TYPES.RELATIONSHIP
			, RELATIONSHIP_TYPES.REFERS_TO_GROUP.typename
			,"Endpoint for text refers to a group of something."
			)
	, LINK_REFERS_TO_HUMAN(
			RELATIONSHIP_TYPES.REFERS_TO_HUMAN.typename.toLowerCase()
			, ENDPOINT_TYPES.RELATIONSHIP
			, RELATIONSHIP_TYPES.REFERS_TO_HUMAN.typename
			,"Endpoint for text refers to a human being"
			)
	, LINK_REFERS_TO_OBJECT(
			RELATIONSHIP_TYPES.REFERS_TO_OBJECT.typename.toLowerCase()
			, ENDPOINT_TYPES.RELATIONSHIP
			, RELATIONSHIP_TYPES.REFERS_TO_OBJECT.typename
			,"Endpoint for text refers to a human object"
			)
	, LINK_REFERS_TO_PLACE(
			RELATIONSHIP_TYPES.REFERS_TO_PLACE.typename.toLowerCase()
			, ENDPOINT_TYPES.RELATIONSHIP
			, RELATIONSHIP_TYPES.REFERS_TO_PLACE.typename
			,"Endpoint for text refers to a place"
			)
	, LINK_REFERS_TO_PLANT(
			RELATIONSHIP_TYPES.REFERS_TO_PLANT.typename.toLowerCase()
			, ENDPOINT_TYPES.RELATIONSHIP
			, RELATIONSHIP_TYPES.REFERS_TO_PLANT.typename
			,"Endpoint for text refers to a plant"
			)
	, OBJECTS(
			"objects"
			, ENDPOINT_TYPES.ONTOLOGY
			, "objects"
			,"Endpoint for object docs"
			)
	, PLACES(
			"places"
			, ENDPOINT_TYPES.ONTOLOGY
			, "Places"
			,"Endpoint for place docs"
			)
	, PLANTS(
			"plants"
			, ENDPOINT_TYPES.ONTOLOGY
			, "Plants"
			,"Endpoint for plant docs"
			)
	, ROLES(
			"roles"
			, ENDPOINT_TYPES.ONTOLOGY
			, "Roles"
			,"Endpoint for role docs"
			)
	, TEXTS(
			"texts"
			, ENDPOINT_TYPES.NODE
			, "Text"
			,"Endpoint for text docs"
			)
	;

	public String pathPrefix = Constants.EXTERNAL_DATASTORE_API_PATH;
	public String name = "";
	public String label = "";
	public String pathname = "";
	public ENDPOINT_TYPES type = null;
	public String description = "";
	
	/**
	 * 
	 * @param name - endpoint name as appears in the REST API
	 * @param type - node or relationship
	 * @param label - name used in database, e.g. node label or relationship type name
	 * @param description
	 */
	private ENDPOINTS_DB_API(
			String name
			, ENDPOINT_TYPES type
			, String label
			, String description
			) {
		this.name = name;
		this.type = type;
		this.label = label;
		this.description = description;
		pathname = pathPrefix;
		switch (type) {
		case DROPDOWNS:
			pathname = pathname + Constants.EXTERNAL_DATASTORE_DROPDOWNS_PATH;
			break;
		case NODE:
			pathname = pathname + Constants.EXTERNAL_DATASTORE_NODE_PATH;
			break;
		case ONTOLOGY:
			pathname = pathname + Constants.EXTERNAL_DATASTORE_ONTOLOGY_PATH;
			break;
		case RELATIONSHIP:
			pathname = pathname + Constants.EXTERNAL_DATASTORE_RELATIONSHIP_PATH;
			break;
		default: // node
			pathname = pathname + Constants.EXTERNAL_DATASTORE_NODE_PATH;
			break;
		}
		pathname = pathname + (this.name.length() > 0 ? "/" : "" ) + this.name;
	}

	/**
	 * Returns a REST path that expects a specific key
	 * @return
	 */
	public String toLibraryTopicKeyPath() {
		return this.pathname + Constants.PATH_LIBRARY_TOPIC_KEY_WILDCARD;
	}
	
	/**
	 * 
	 * @return
	 */
	public String toLibraryTopicPath() {
		return this.pathname + Constants.PATH_LIBRARY_TOPIC_WILDCARD;
	}
	/**
	 * 
	 * @return
	 */
	public String toLibraryPath() {
		return this.pathname + Constants.PATH_LIBRARY_WILDCARD;
	}
	
}
