package com.matteopelucco.magnolia.logininfo.callback;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import com.matteopelucco.magnolia.logininfo.functions.LogininfoTemplatingFunction;

import info.magnolia.cms.security.auth.callback.FormClientCallback;
import info.magnolia.context.WebContext;
import info.magnolia.init.MagnoliaConfigurationProperties;
import info.magnolia.objectfactory.Components;

public class LogininfoFormClientCallback extends FormClientCallback{

	LogininfoTemplatingFunction infofn;
	
	@Inject
    public LogininfoFormClientCallback(MagnoliaConfigurationProperties configurationProperties, Provider<WebContext> webContextProvider) {
		super(configurationProperties, webContextProvider);
		infofn = Components.getComponent(LogininfoTemplatingFunction.class);
    }

	/**
	 * Need to add a custom templating function
	 */
    protected Map<String, Object> getTemplateContext() {
        
    	Map<String, Object> tplCtx = super.getTemplateContext();

    	tplCtx.put("infofn", infofn);
    	tplCtx.put("props", infofn.getMagnoliaProperties());

        return tplCtx;
    }
}
