package com.matteopelucco.magnolia.logininfo.functions;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.matteopelucco.magnolia.logininfo.LoginInfoModule;

import info.magnolia.init.MagnoliaConfigurationProperties;
import info.magnolia.objectfactory.Components;

public class LogininfoTemplatingFunction {


	public LogininfoTemplatingFunction() {
	}

	public String getLoginSummary() {
		final String loginSummary = Components.getComponent(LoginInfoModule.class).getLoginSummary();
		return PropsParser.parse(StringUtils.defaultIfEmpty(loginSummary, ""), getMagnoliaProperties());
	}

	public String getLoginDetail() {
		final String loginDetail = Components.getComponent(LoginInfoModule.class).getLoginDetail();
		return PropsParser.parse(StringUtils.defaultIfEmpty(loginDetail, ""), getMagnoliaProperties());
	}


	public String getMagnoliaProperty(final String propertyName, final String defaultValue) {
		final MagnoliaConfigurationProperties configurationProperties = Components.getComponent(MagnoliaConfigurationProperties.class);
		final String property = configurationProperties.getProperty(propertyName);
		if (property != null) {
			return property;
		}

		return defaultValue;
	}

	public Map<String, String> getMagnoliaProperties() {

		final MagnoliaConfigurationProperties configurationProperties = Components.getComponent(MagnoliaConfigurationProperties.class);
		Map<String, String> properties = new LinkedHashMap<String, String>();
		for (String key : configurationProperties.getKeys()) {
			properties.put(key, configurationProperties.getProperty(key));
		}
		return properties;
	}
}
