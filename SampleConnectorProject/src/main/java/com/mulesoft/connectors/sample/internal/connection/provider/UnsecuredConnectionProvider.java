package com.mulesoft.connectors.sample.internal.connection.provider;

import org.mule.runtime.api.lifecycle.Disposable;
import org.mule.runtime.api.lifecycle.Initialisable;
import org.mule.runtime.api.lifecycle.InitialisationException;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Summary;
import org.mule.runtime.api.connection.ConnectionException;
import org.mule.runtime.api.connection.ConnectionProvider;
import org.mule.runtime.api.connection.ConnectionValidationResult;

@DisplayName("Unsecured Connection Provider")
public class UnsecuredConnectionProvider implements ConnectionProvider<Object>, Initialisable, Disposable {
  /** @return the base uri of the REST API being consumed */
  @DisplayName("Base Uri")
  @Summary("Parameter base URI, each instance/tenant gets its own")
  @Parameter
  @Optional(
      defaultValue =
          "https://anypoint.mulesoft.com/mocking/api/v1/links/39824b58-e59a-4944-9a9c-8570db98ccdd")
  private String baseUri;

  /**
   * {@link OptionalTlsParameterGroup} references to a TLS config element. This will enable HTTPS
   * for this config.
   */

  @Override
  public void dispose() {
  }

  @Override
  public void initialise() throws InitialisationException {
  }

  @Override
  public Object connect() throws ConnectionException {
    return null;
  }

  @Override
  public void disconnect(Object connection) {
  }

  @Override
  public ConnectionValidationResult validate(Object connection) {
    return null;
  }
}
