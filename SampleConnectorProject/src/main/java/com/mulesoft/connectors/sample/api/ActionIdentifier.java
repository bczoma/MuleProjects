package com.mulesoft.connectors.sample.api;

import org.mule.runtime.extension.api.annotation.metadata.MetadataKeyPart;
import org.mule.runtime.extension.api.annotation.param.Parameter;

public class ActionIdentifier {

  @Parameter
  @MetadataKeyPart(order = 1) 
  private String service;

  @Parameter
  @MetadataKeyPart(order = 2) 
  private String action;

  public String getService() {
    return service;
  }

  public String getAction() {
    return action;
  }

  public void setService(String service) {
    this.service = service;
  }

  public void setAction(String action) {
    this.action = action;
  }
}