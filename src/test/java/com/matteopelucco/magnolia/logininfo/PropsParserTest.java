package com.matteopelucco.magnolia.logininfo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.matteopelucco.magnolia.logininfo.functions.PropsParser;


public class PropsParserTest {

	@Test 
	public void parserTest(){
		
		// preparing virtual props
		HashMap<String,String> props = new HashMap<String,String>();
		props.put("magnolia.servername", "MYIRONISTHEBEST");
		props.put("magnolia.home", "/var/lib/demo");
		
		// preparing test cases
		Map<String, String> testCases = new LinkedHashMap<String, String>();
		testCases.put("ServerName is: props['magnolia.servername'];", "ServerName is: MYIRONISTHEBEST;");
		testCases.put("props['magnolia.home'] is MagnoliaHome", "/var/lib/demo is MagnoliaHome");
		testCases.put("mixing props['magnolia.servername'] togheter props['magnolia.home']", "mixing MYIRONISTHEBEST togheter /var/lib/demo");
		
		for (String test : testCases.keySet()){
			Assert.assertEquals(PropsParser.parse(test, props), testCases.get(test));
		}
	}
}
