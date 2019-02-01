package com.ibm.oslc.adaptor.iotp.resources;

import org.eclipse.lyo.oslc4j.core.annotation.OslcDescription;
import org.eclipse.lyo.oslc4j.core.annotation.OslcName;
import org.eclipse.lyo.oslc4j.core.annotation.OslcNamespace;
import org.eclipse.lyo.oslc4j.core.annotation.OslcOccurs;
import org.eclipse.lyo.oslc4j.core.annotation.OslcPropertyDefinition;
import org.eclipse.lyo.oslc4j.core.annotation.OslcReadOnly;
import org.eclipse.lyo.oslc4j.core.annotation.OslcResourceShape;
import org.eclipse.lyo.oslc4j.core.annotation.OslcTitle;
import org.eclipse.lyo.oslc4j.core.model.Occurs;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.ServiceProvider;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

@OslcName("ServiceProvider")
@OslcNamespace(OslcConstants.OSLC_CORE_NAMESPACE)
@OslcResourceShape(title = "OSLC Service Provider Resource Shape", describes = OslcConstants.TYPE_SERVICE_PROVIDER)
public class CustomServiceProvider extends ServiceProvider {

    public CustomServiceProvider() throws URISyntaxException {
        super();
        this.setGlobalConfigurationAware("compatible");
        this.setSupportContributionsToLinkIndexProvider(Boolean.TRUE);
        this.setSupportLinkDiscoveryViaLinkIndexProvider(Boolean.TRUE);
        this.setSupportOSLCSimpleQuery(Boolean.TRUE);
    }

    public void toCustomServiceProvider(ServiceProvider sp) {
        super.setDetails(sp.getDetails());
        super.setPrefixDefinitions(sp.getPrefixDefinitions());
        super.setServices(sp.getServices());
        super.setCreated(sp.getCreated());
        super.setDescription(sp.getDescription());
        super.setIdentifier(sp.getIdentifier());
        super.setOauthConfiguration(sp.getOauthConfiguration());
        super.setPublisher(sp.getPublisher());
        super.setTitle(sp.getTitle());
        super.setAbout(sp.getAbout());
        super.setTypes(sp.getTypes());
        super.setExtendedProperties(sp.getExtendedProperties());
    }

    private String globalConfigurationAware;
    private Boolean supportContributionsToLinkIndexProvider;
    private Boolean supportLinkDiscoveryViaLinkIndexProvider;
    private Boolean supportOSLCSimpleQuery;
    private final SortedSet<URI> consumerRegistry = new TreeSet<URI>();

    @OslcDescription("The globalConfigurationAware.")
    //@OslcOccurs(Occurs.ZeroOrOne)
    @OslcPropertyDefinition("http://jazz.net/xmlns/prod/jazz/process/1.0/" + "globalConfigurationAware")
    @OslcTitle("GlobalConfigurationAware")
    public String getGlobalConfigurationAware() {
        return globalConfigurationAware;
    }

    public void setGlobalConfigurationAware(String globalConfigurationAware) {
        this.globalConfigurationAware = globalConfigurationAware;
    }

    @OslcDescription("The supportContributionsToLinkIndexProvider.")
    @OslcOccurs(Occurs.ZeroOrOne)
    @OslcPropertyDefinition("http://jazz.net/xmlns/prod/jazz/process/1.0/" + "supportContributionsToLinkIndexProvider")
    @OslcTitle("supportContributionsToLinkIndexProvider")
    public Boolean getSupportContributionsToLinkIndexProvider() {
        return supportContributionsToLinkIndexProvider;
    }

    public void setSupportContributionsToLinkIndexProvider(Boolean supportContributionsToLinkIndexProvider) {
        this.supportContributionsToLinkIndexProvider = supportContributionsToLinkIndexProvider;
    }

    @OslcDescription("The supportLinkDiscoveryViaLinkIndexProvider.")
    @OslcOccurs(Occurs.ZeroOrOne)
    @OslcPropertyDefinition("http://jazz.net/xmlns/prod/jazz/process/1.0/" + "supportLinkDiscoveryViaLinkIndexProvider")
    @OslcTitle("supportLinkDiscoveryViaLinkIndexProvider")
    public Boolean getSupportLinkDiscoveryViaLinkIndexProvider() {
        return supportLinkDiscoveryViaLinkIndexProvider;
    }

    public void setSupportLinkDiscoveryViaLinkIndexProvider(Boolean supportLinkDiscoveryViaLinkIndexProvider) {
        this.supportLinkDiscoveryViaLinkIndexProvider = supportLinkDiscoveryViaLinkIndexProvider;
    }

    @OslcDescription("The supportOSLCSimpleQuery.")
    @OslcOccurs(Occurs.ZeroOrOne)
    @OslcPropertyDefinition("http://jazz.net/xmlns/prod/jazz/process/1.0/" + "supportOSLCSimpleQuery")
    @OslcTitle("supportOSLCSimpleQuery")
    public Boolean getSupportOSLCSimpleQuery() {
        return supportOSLCSimpleQuery;
    }

    public void setSupportOSLCSimpleQuery(Boolean supportOSLCSimpleQuery) {
        this.supportOSLCSimpleQuery = supportOSLCSimpleQuery;
    }

    @OslcDescription("new new")
    @OslcPropertyDefinition("http://jazz.net/xmlns/prod/jazz/process/1.0/" + "consumerRegistry")
    @OslcReadOnly
    @OslcTitle("Consumer Registry")
    public URI[] getConsumerRegistry() {
        return consumerRegistry.toArray(new URI[consumerRegistry.size()]);
    }

    public void setConsumerRegistry(final URI[] consumerRegistry) {
        this.consumerRegistry.clear();
        if (consumerRegistry != null) {
            this.consumerRegistry.addAll(Arrays.asList(consumerRegistry));
        }
    }
}
