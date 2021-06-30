package com.mulesoft.connectors.sample.internal.metadata;

import java.util.HashSet;
import java.util.Set;

import org.mule.runtime.api.connection.ConnectionException;
import org.mule.runtime.api.metadata.MetadataContext;
import org.mule.runtime.api.metadata.MetadataKey;
import org.mule.runtime.api.metadata.MetadataKeyBuilder;
import org.mule.runtime.api.metadata.MetadataResolvingException;
import org.mule.runtime.api.metadata.resolving.TypeKeysResolver;

public class OperationTypeKeysResolver implements TypeKeysResolver {

	@Override
	public String getCategoryName() {
		return "test";
	}

	@Override
  public Set<MetadataKey> getKeys(MetadataContext context) throws MetadataResolvingException, ConnectionException {
    Set<MetadataKey> keys = new HashSet<>();
    String[] services = { "Service1", "Service2" };
    String[] actions = { "Action1", "Action2" };
    for(String service : services){
      MetadataKeyBuilder key = MetadataKeyBuilder.newKey(service);
      for(String action : actions){
        key.withChild(MetadataKeyBuilder.newKey(action).build());
      }
      keys.add(key.build());
    }
    return keys;
  }

}