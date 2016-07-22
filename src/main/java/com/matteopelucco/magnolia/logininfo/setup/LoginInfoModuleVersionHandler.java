package com.matteopelucco.magnolia.logininfo.setup;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.matteopelucco.magnolia.logininfo.functions.LogininfoTemplatingFunction;

import info.magnolia.cms.security.auth.callback.FormClientCallback;
import info.magnolia.jcr.util.PropertyUtil;
import info.magnolia.module.DefaultModuleVersionHandler;
import info.magnolia.module.InstallContext;
import info.magnolia.module.delta.ArrayDelegateTask;
import info.magnolia.module.delta.IsAuthorInstanceDelegateTask;
import info.magnolia.module.delta.SetPropertyTask;
import info.magnolia.module.delta.Task;
import info.magnolia.repository.RepositoryConstants;

public class LoginInfoModuleVersionHandler extends DefaultModuleVersionHandler{

	
	private static final Logger log = LoggerFactory.getLogger(LoginInfoModuleVersionHandler.class);
	
	private static final String FORM_NODEPATH = "/server/filters/securityCallback/clientCallbacks/form";
	
	private static final String LOGINFORM_PROPERTYNAME = "loginForm";
	private static final String CLASS_PROPERTYNAME = "class";
	private static final String LOGININFO_CLASS = "com.matteopelucco.magnolia.logininfo.callback.LogininfoFormClientCallback";
	private static final String LOGININFO_LOGINFORM = "/defaultMagnoliaLoginForm/login_info.html";

	public LoginInfoModuleVersionHandler() {
		// still nothing here..
	}
	
	
	public List<Task> getBasicInstallTasks(InstallContext installContext){
		List<Task> standardTasks = super.getBasicInstallTasks(installContext);
		
		standardTasks.add(
				new ArrayDelegateTask("Setting LoginInfo properties", 
						new SetPropertyTask(RepositoryConstants.CONFIG, FORM_NODEPATH, CLASS_PROPERTYNAME, LOGININFO_CLASS),
						new SetPropertyTask(RepositoryConstants.CONFIG, FORM_NODEPATH, LOGINFORM_PROPERTYNAME, LOGININFO_LOGINFORM)
				));
		return standardTasks;
	}
	
}

