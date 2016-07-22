package com.matteopelucco.magnolia.logininfo.functions;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropsParser {

	private static final String PROPS_REGEX = "props\\['(.+?)'\\]";
	
	public static String parse(String str, Map<String, String> props) {
		
		Pattern pattern = Pattern.compile(PROPS_REGEX);
		Matcher matcher = pattern.matcher(str);
		
		
		StringBuilder builder = new StringBuilder();
		int i = 0;
		while (matcher.find()) {
		    String replacement = props.get(matcher.group(1));
		    builder.append(str.substring(i, matcher.start()));
		    if (replacement == null)
		        builder.append(matcher.group(0));
		    else
		        builder.append(replacement);
		    i = matcher.end();
		}
		builder.append(str.substring(i, str.length()));
		return builder.toString();
		
	}
}
