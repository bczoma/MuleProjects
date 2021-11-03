package com.mulesoft.connectors.sample.internal.operation;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import org.mule.runtime.api.metadata.TypedValue;
import org.mule.runtime.extension.api.annotation.metadata.MetadataKeyId;
import org.mule.runtime.extension.api.annotation.metadata.OutputResolver;
import org.mule.runtime.extension.api.annotation.metadata.TypeResolver;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Content;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.ParameterGroup;

import com.mulesoft.connectors.sample.api.ActionIdentifier;
import com.mulesoft.connectors.sample.internal.config.SampleConfiguration;
import com.mulesoft.connectors.sample.internal.metadata.InputTypeResolverOperationWithPartialFetch;
import com.mulesoft.connectors.sample.internal.metadata.OutputTypeResolverOperationWithPartialFetch;
import com.mulesoft.connectors.sample.internal.metadata.TypeKeysResolverOperationWithPartialFetch;

public class SampleOperations {

  
  /*
   * Partial Fetching Demo
   * 
   * Refer to https://docs.mulesoft.com/mule-sdk/1.1/multi-level-metadata#partial-fetching
   */
  
  
  @OutputResolver(output = OutputTypeResolverOperationWithPartialFetch.class)
  @MediaType(value = ANY, strict = false)
  public Object partialFetchingWorksOperation( /* NO @Config SampleConfiguration configuration, */
      @ParameterGroup(name = "MetadataKey") @MetadataKeyId(TypeKeysResolverOperationWithPartialFetch.class) ActionIdentifier identifier,
      @Content(primary = true) @TypeResolver(InputTypeResolverOperationWithPartialFetch.class) TypedValue<Object> otherArg){
    return null;
  }
  
  @OutputResolver(output = OutputTypeResolverOperationWithPartialFetch.class)
  @MediaType(value = ANY, strict = false)
  public Object partialFetchingDoesNotWorkOperation( @Config SampleConfiguration configuration,
      @ParameterGroup(name = "MetadataKey") @MetadataKeyId(TypeKeysResolverOperationWithPartialFetch.class) ActionIdentifier identifier,
      @Content(primary = true) @TypeResolver(InputTypeResolverOperationWithPartialFetch.class) TypedValue<Object> otherArg){
    return null;
  }
}
