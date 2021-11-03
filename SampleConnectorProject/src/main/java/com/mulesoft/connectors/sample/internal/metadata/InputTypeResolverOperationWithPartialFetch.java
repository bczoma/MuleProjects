package com.mulesoft.connectors.sample.internal.metadata;

import org.mule.metadata.api.model.MetadataType;
import org.mule.metadata.json.api.JsonTypeLoader;
import org.mule.runtime.api.connection.ConnectionException;
import org.mule.runtime.api.metadata.MetadataContext;
import org.mule.runtime.api.metadata.MetadataResolvingException;
import org.mule.runtime.api.metadata.resolving.FailureCode;
import org.mule.runtime.api.metadata.resolving.InputTypeResolver;

import com.mulesoft.connectors.sample.api.ActionIdentifier;

public class InputTypeResolverOperationWithPartialFetch implements InputTypeResolver<ActionIdentifier> {

	@Override
	public String getCategoryName() {
		return "OperationWithPartialFetch";
	}

	@Override
	public MetadataType getInputMetadata(MetadataContext context, ActionIdentifier key)
	    throws MetadataResolvingException, ConnectionException {
    if (key != null) {
      // Just a sample schema using the keys
      String schema = "{\"definitions\":{},\"$schema\":\"http://json-schema.org/draft-07/schema#\",\"$id\":\"http://example.com/root.json\",\"type\":\"object\",\"title\":\"Test\",\"required\":[\""
      		+ "Input"
      		+ "\",\""
      		+ key.getService()
      		+ "\"],\"properties\":{\""
      		+ "Input"
      		+ "\":{\"$id\":\"#/properties/"
      		+ "Input"
      		+ "\",\"type\":\"string\",\"title\":\"The Distance Schema\",\"default\":\"\",\"examples\":[\"1.49\"],\"pattern\":\"^(.*)$\"},\""
      		+ key.getService()
      		+ "\":{\"$id\":\"#/properties/"
      		+ key.getService()
      		+ "\",\"type\":\"string\",\"title\":\"The Distance_label Schema\",\"default\":\"\",\"examples\":[\"miles\"],\"pattern\":\"^(.*)$\"}}}";
      
      return new JsonTypeLoader(schema).load("http://demo.attributes")
          .orElseThrow(() -> new MetadataResolvingException("No Metadata is available for the User Attributes",
                                                            FailureCode.NO_DYNAMIC_TYPE_AVAILABLE));
    } else {
      return context.getTypeBuilder().nullType().build();
    }
	}

}