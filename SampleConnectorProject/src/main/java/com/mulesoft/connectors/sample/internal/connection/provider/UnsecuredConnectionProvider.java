package com.mulesoft.connectors.sample.internal.connection.provider;

import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.ParameterGroup;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Summary;
import org.mule.runtime.extension.api.connectivity.NoConnectivityTest;

import com.mulesoft.connectivity.rest.commons.api.connection.BaseConnectionProvider;
import com.mulesoft.connectivity.rest.commons.api.connection.OptionalTlsParameterGroup;
import com.mulesoft.connectivity.rest.commons.api.connection.TlsParameterGroup;

@Alias("unsecured")
@DisplayName("Unsecured Connection Provider")
public class UnsecuredConnectionProvider extends BaseConnectionProvider
    implements NoConnectivityTest {
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
  @ParameterGroup(name = "tls")
  private OptionalTlsParameterGroup tlsConfig;

  /** @return the base uri of the REST API being consumed */
  @Override
  public String getBaseUri() {
    return this.baseUri;
  }

  /**
   * {@link TlsParameterGroup} that configures TLS and allows to switch between HTTP and HTTPS
   * protocols.
   *
   * @return an optional {@link TlsParameterGroup}
   */
  @Override
  public java.util.Optional<TlsParameterGroup> getTlsConfig() {
    return java.util.Optional.ofNullable(this.tlsConfig);
  }
}
