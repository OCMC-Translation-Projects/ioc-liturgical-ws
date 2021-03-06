package net.ages.alwb.utils.transformers.adapters;

import static org.junit.Assert.*;

import org.junit.Test;
import org.ocmc.ioc.liturgical.schemas.models.LDOM.AgesIndexTableData;

public class AgesIndexHtmlToReactTableDataTest {

	@Test
	public void test() {
		AgesWebsiteIndexToReactTableData ages = new AgesWebsiteIndexToReactTableData(true);
		try {
			AgesIndexTableData data = ages.toReactTableDataFromHtml();
			System.out.println(data.toJsonString());
			assertTrue(data != null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
