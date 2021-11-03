package com.mulesoft.connectors.sample.internal.extension;

import org.mule.runtime.extension.api.annotation.Configurations;
import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;
import org.mule.runtime.extension.api.annotation.license.RequiresEnterpriseLicense;

import com.mulesoft.connectors.sample.internal.config.SampleConfiguration;

@Extension(name = "Solace Sample Connector")
@Xml(prefix = "sample")
@Configurations({SampleConfiguration.class})
@RequiresEnterpriseLicense(allowEvaluationLicense = true)
public class SampleConnector {}
