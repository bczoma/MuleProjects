package com.mulesoft.connectors.sample.internal.source;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import org.mule.runtime.api.exception.MuleException;
import org.mule.runtime.api.metadata.TypedValue;
import org.mule.runtime.extension.api.annotation.metadata.MetadataKeyId;
import org.mule.runtime.extension.api.annotation.metadata.MetadataScope;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.ParameterGroup;
import org.mule.runtime.extension.api.annotation.source.ClusterSupport;
import org.mule.runtime.extension.api.annotation.source.EmitsResponse;
import org.mule.runtime.extension.api.annotation.source.SourceClusterSupport;
import org.mule.runtime.extension.api.runtime.source.Source;
import org.mule.runtime.extension.api.runtime.source.SourceCallback;

import com.mulesoft.connectors.sample.api.ActionIdentifier;
import com.mulesoft.connectors.sample.internal.metadata.OperationTypeKeysResolver;
import com.mulesoft.connectors.sample.internal.metadata.OutputOperationTypeResolver;

@MediaType(value = ANY, strict = false)
@EmitsResponse
@ClusterSupport(SourceClusterSupport.NOT_SUPPORTED)
@MetadataScope(	outputResolver = OutputOperationTypeResolver.class)
public class SampleSource extends Source<TypedValue<Object>, Object> {
	@ParameterGroup(name = "MetadataKey")
	@MetadataKeyId(OperationTypeKeysResolver.class)
	public ActionIdentifier identifier;
  
	@Parameter
	String otherArg;

	@Override
	public void onStart(SourceCallback<TypedValue<Object>, Object> sourceCallback) throws MuleException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		
	}
	

}
