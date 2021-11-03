package com.mulesoft.connectors.sample.internal.config;

import org.mule.runtime.api.lifecycle.Initialisable;
import org.mule.runtime.api.lifecycle.InitialisationException;
import org.mule.runtime.extension.api.annotation.Configuration;
import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.Sources;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;

import com.mulesoft.connectors.sample.internal.connection.provider.UnsecuredConnectionProvider;
import com.mulesoft.connectors.sample.internal.operation.SampleOperations;
import com.mulesoft.connectors.sample.internal.source.SampleSource;

@Configuration
@Operations({SampleOperations.class})
@Sources({ SampleSource.class })
@ConnectionProviders({UnsecuredConnectionProvider.class})
public class SampleConfiguration implements Initialisable {

  @Override
  public void initialise() throws InitialisationException {
  }
}
