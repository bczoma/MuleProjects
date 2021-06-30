package com.mulesoft.connectors.sample.internal.operation;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import org.mule.runtime.extension.api.annotation.metadata.MetadataKeyId;
import org.mule.runtime.extension.api.annotation.metadata.OutputResolver;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.ParameterGroup;

import com.mulesoft.connectors.sample.api.ActionIdentifier;
import com.mulesoft.connectors.sample.internal.metadata.OperationTypeKeysResolver;
import com.mulesoft.connectors.sample.internal.metadata.OutputOperationTypeResolver;

public class SampleOperations {

  @OutputResolver(output = OutputOperationTypeResolver.class)
  @MediaType(value = ANY, strict = false)
  public Object sampleOperation( @ParameterGroup(name = "MetadataKey") @MetadataKeyId(OperationTypeKeysResolver.class) ActionIdentifier identifier,
                        String otherArg){
    return null;
  }
}
