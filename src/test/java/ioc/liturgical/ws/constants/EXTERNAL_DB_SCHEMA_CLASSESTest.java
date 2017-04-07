package ioc.liturgical.ws.constants;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.gson.Gson;
import ioc.liturgical.ws.constants.EXTERNAL_DB_SCHEMA_CLASSES;

import ioc.liturgical.ws.models.db.forms.AnimalCreateForm;
import ioc.liturgical.ws.models.db.forms.LinkRefersToAnimalCreateForm;
import ioc.liturgical.ws.models.db.supers.LTK;
import ioc.liturgical.ws.models.db.supers.LTKDb;

public class EXTERNAL_DB_SCHEMA_CLASSESTest {

	@Test
	public void test() {
		try {
			EXTERNAL_DB_SCHEMA_CLASSES animal = EXTERNAL_DB_SCHEMA_CLASSES.ANIMAL;
		} catch (Exception e) {
			e.printStackTrace();
		}
		LinkRefersToAnimalCreateForm l = new LinkRefersToAnimalCreateForm(" "," "," ");
		AnimalCreateForm f = new AnimalCreateForm("Duck");
		f.setSound("quack");
		String json = f.toJsonString();
		String validate = EXTERNAL_DB_SCHEMA_CLASSES.validate(json);
		assertTrue(validate.length() < 1);
		Gson gson = new Gson();
		LTK ltk = gson.fromJson(json, LTK.class);
		try {
			LTKDb tkDb = gson.fromJson(
					json
					, EXTERNAL_DB_SCHEMA_CLASSES
					.classForSchemaName(
							ltk.get_valueSchemaId())
					.ltkDb.getClass()
					);
			tkDb.setCreatedBy("bigmac");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
