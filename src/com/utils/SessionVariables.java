package com.utils;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session",proxyMode=ScopedProxyMode.TARGET_CLASS)
public class SessionVariables {
	  private int appRequests;

	  public int getAppRequests() {
	  	return appRequests;
	  }

	  public void setAppRequests() {
	  	appRequests++;
	  }
	    
}
