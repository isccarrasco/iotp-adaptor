package com.ibm.oslc.adaptor.iotp.servlet;

import com.ibm.oslc.adaptor.iotp.resources.CustomServiceProvider;
import com.ibm.oslc.adaptor.iotp.resources.DctermsDomainConstants;
import com.ibm.oslc.adaptor.iotp.resources.FoafDomainConstants;
import com.ibm.oslc.adaptor.iotp.resources.OslcDomainConstants;
import com.ibm.oslc.adaptor.iotp.resources.Oslc_amDomainConstants;
import com.ibm.oslc.adaptor.iotp.resources.Oslc_cmDomainConstants;
import com.ibm.oslc.adaptor.iotp.resources.Oslc_iotDomainConstants;
import com.ibm.oslc.adaptor.iotp.resources.Oslc_rmDomainConstants;
import com.ibm.oslc.adaptor.iotp.resources.RdfDomainConstants;
import com.ibm.oslc.adaptor.iotp.services.GlobalConfigurationService;
import org.eclipse.lyo.oslc4j.client.ServiceProviderRegistryURIs;
import org.eclipse.lyo.oslc4j.core.exception.OslcCoreApplicationException;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.PrefixDefinition;
import org.eclipse.lyo.oslc4j.core.model.Publisher;
import org.eclipse.lyo.oslc4j.core.model.ServiceProvider;
import org.eclipse.lyo.oslc4j.core.model.ServiceProviderFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class ConfigurationServiceProvidersFactory {

    private static Class<?>[] RESOURCE_CLASSES = { GlobalConfigurationService.class };

    public ConfigurationServiceProvidersFactory() {
        super();
    }

    public static CustomServiceProvider createServiceProvider(final String baseURI,
                                                              final String title,
                                                              final String description,
                                                              final Publisher publisher,
                                                              final Map<String,Object> parameterValueMap)
            throws URISyntaxException, OslcCoreApplicationException {

        final ServiceProvider sp = ServiceProviderFactory.createServiceProvider(baseURI,
                ServiceProviderRegistryURIs.getUIURI(),
                title,
                description,
                publisher,
                RESOURCE_CLASSES,
                parameterValueMap);

        final CustomServiceProvider serviceProvider = new CustomServiceProvider();
        serviceProvider.toCustomServiceProvider(sp);

        final PrefixDefinition[] prefixDefinitions = {
                new PrefixDefinition(OslcConstants.DCTERMS_NAMESPACE_PREFIX, new URI(OslcConstants.DCTERMS_NAMESPACE)),
                new PrefixDefinition(OslcConstants.OSLC_CORE_NAMESPACE_PREFIX, new URI(OslcConstants.OSLC_CORE_NAMESPACE)),
                new PrefixDefinition(OslcConstants.OSLC_DATA_NAMESPACE_PREFIX, new URI(OslcConstants.OSLC_DATA_NAMESPACE)),
                new PrefixDefinition(OslcConstants.RDF_NAMESPACE_PREFIX, new URI(OslcConstants.RDF_NAMESPACE)),
                new PrefixDefinition(OslcConstants.RDFS_NAMESPACE_PREFIX, new URI(OslcConstants.RDFS_NAMESPACE)),
                new PrefixDefinition(Oslc_amDomainConstants.ARCHITECTURE_MANAGEMENT_NAMSPACE_PREFIX, new URI(Oslc_amDomainConstants.ARCHITECTURE_MANAGEMENT_NAMSPACE)),
                new PrefixDefinition(Oslc_cmDomainConstants.CHANGE_MANAGEMENT_NAMSPACE_PREFIX, new URI(Oslc_cmDomainConstants.CHANGE_MANAGEMENT_NAMSPACE)),
                new PrefixDefinition(DctermsDomainConstants.DUBLIN_CORE_NAMSPACE_PREFIX, new URI(DctermsDomainConstants.DUBLIN_CORE_NAMSPACE)),
                new PrefixDefinition(FoafDomainConstants.FOAF_NAMSPACE_PREFIX, new URI(FoafDomainConstants.FOAF_NAMSPACE)),
                new PrefixDefinition(Oslc_iotDomainConstants.IOT_PLATFORM_NAMSPACE_PREFIX, new URI(Oslc_iotDomainConstants.IOT_PLATFORM_NAMSPACE)),
                new PrefixDefinition(OslcDomainConstants.OSLC_NAMSPACE_PREFIX, new URI(OslcDomainConstants.OSLC_NAMSPACE)),
                new PrefixDefinition(RdfDomainConstants.RDF_NAMSPACE_PREFIX, new URI(RdfDomainConstants.RDF_NAMSPACE)),
                new PrefixDefinition(Oslc_rmDomainConstants.REQUIREMENTS_MANAGEMENT_NAMSPACE_PREFIX, new URI(Oslc_rmDomainConstants.REQUIREMENTS_MANAGEMENT_NAMSPACE))
            };

        serviceProvider.setPrefixDefinitions(prefixDefinitions);

        return serviceProvider;

    }

}
