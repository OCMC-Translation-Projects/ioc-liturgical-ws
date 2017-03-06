package ioc.liturgical.ws.controllers.ldp;

import static spark.Spark.get;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ioc.liturgical.ws.constants.Constants;
import ioc.liturgical.ws.manager.ldp.LdpManager;
import ioc.liturgical.ws.models.ResultJsonObjectArray;

public class LdpController {
	
    private Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    
	/**
	 * returns a JsonObject with the Liturgical Properties of a specified date,
	 * or today's date if the date parameter is empty.
	 * 
	 * @param manager
	 */
	public LdpController(LdpManager manager) {
		
		get(Constants.INTERNAL_LITURGICAL_DAY_PROPERTIES_API_PATH + "/ldp" , (request, response) -> {
			response.type(Constants.UTF_JSON);
			String calendarType = request.queryParams("t"); // calendar types - see LITURGICAL_CALENDAR_TYPE enum for values
			String date = request.queryParams("d"); // date ISO String, ex: "2016-11-19T12:00:00.000Z" 
			boolean noType = (calendarType == null || calendarType.length() < 0);
			boolean noDate = (date == null || date.length() < 0);
			ResultJsonObjectArray result = null;
			if (noType && noDate) {
				result = manager.getLdpForToday();
			} else {
				if (noType) {
		        	result = manager.getLdpForToday(calendarType);
				} else {
		        	result = manager.getLdpForDate(
		        			date
		        			, calendarType
		        			);
				}
			}
			return result.toJsonString();
		});
	}

}
