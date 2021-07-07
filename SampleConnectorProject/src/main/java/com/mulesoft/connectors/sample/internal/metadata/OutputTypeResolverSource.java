package com.mulesoft.connectors.sample.internal.metadata;

import org.mule.metadata.api.model.MetadataType;
import org.mule.metadata.json.api.JsonTypeLoader;
import org.mule.runtime.api.connection.ConnectionException;
import org.mule.runtime.api.metadata.MetadataResolvingException;
import org.mule.runtime.api.metadata.resolving.FailureCode;
import org.mule.runtime.api.metadata.resolving.OutputTypeResolver;
import org.mule.runtime.api.metadata.MetadataContext;

import com.mulesoft.connectors.sample.api.ActionIdentifier;

public class OutputTypeResolverSource implements OutputTypeResolver<ActionIdentifier>{

	@Override
	public String getCategoryName() {
		return "Source";
	}

	@Override
	public MetadataType getOutputType(MetadataContext context, ActionIdentifier key)
	    throws MetadataResolvingException, ConnectionException {
    if (key != null) {
      // Just a sample schema using the keys
      String schema = "{\"definitions\":{},\"$schema\":\"http://json-schema.org/draft-07/schema#\",\"$id\":\"http://example.com/root.json\",\"type\":\"object\",\"title\":\"Test\",\"required\":[\""
      		+ key.getAction()
      		+ "\",\""
      		+ key.getService()
      		+ "\"],\"properties\":{\""
      		+ key.getAction()
      		+ "\":{\"$id\":\"#/properties/"
      		+ key.getAction()
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