package com.mulesoft.connectors.sample.internal.metadata;

import java.util.HashSet;
import java.util.Set;

import org.mule.runtime.api.connection.ConnectionException;
import org.mule.runtime.api.metadata.MetadataContext;
import org.mule.runtime.api.metadata.MetadataKey;
import org.mule.runtime.api.metadata.MetadataKeyBuilder;
import org.mule.runtime.api.metadata.MetadataResolvingException;
import org.mule.runtime.api.metadata.resolving.FailureCode;
import org.mule.runtime.api.metadata.resolving.PartialTypeKeysResolver;

import com.mulesoft.connectors.sample.api.ActionIdentifier;

public class TypeKeysResolverOperationWithPartialFetch implements PartialTypeKeysResolver<ActionIdentifier> {

  @Override
	public String getCategoryName() {
		return "OperationWithPartialFetch";
	}

  @Override
  public Set<MetadataKey> getKeys(MetadataContext context) throws MetadataResolvingException, ConnectionException {
    Set<MetadataKey> keys = new HashSet<>();
    for(String service : getServices()){ 
      MetadataKeyBuilder key = MetadataKeyBuilder.newKey(service);
      keys.add(key.build());
    }
    return keys;
  }

  @Override
  public MetadataKey resolveChilds(MetadataContext context, ActionIdentifier key)
      throws MetadataResolvingException, ConnectionException {

    if(key.getService() == null){
      throw new MetadataResolvingException("Missing Service name. Cannot resolve Actions without a service",
                                         FailureCode.INVALID_METADATA_KEY);
    }

    MetadataKeyBuilder keyBuilder = MetadataKeyBuilder.newKey(key.getService()); 
    for(String action : getActions(key.getService())){
      keyBuilder.withChild(MetadataKeyBuilder.newKey(key.getService() + "-" + action).build()); 
    }
    return keyBuilder.build();
  }
  
  private String[] getServices() {
    String[] services = { "(Unspecified)", "Service1", "Service2" };
    return services;
  }
  
  private String[] getActions(String service) {
    String[] actions = { "(Unspecified)", service + "Action1", service + "Action2" };
    return actions;
  }
  
  
}