package com.ibm.oslc.adaptor.iotp.services;

import com.ibm.oslc.adaptor.iotp.IotpServiceProviderInfo;
import com.ibm.oslc.adaptor.iotp.resources.Oslc_amDomainConstants;
import com.ibm.oslc.adaptor.iotp.resources.Oslc_cmDomainConstants;
import com.ibm.oslc.adaptor.iotp.resources.Oslc_rmDomainConstants;
import com.ibm.oslc.adaptor.iotp.resources.Resource;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDialog;
import org.eclipse.lyo.oslc4j.core.annotation.OslcService;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.OslcMediaType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@OslcService(OslcConstants.OSLC_CORE_DOMAIN)
@Path("/oslc_config")
public class GlobalConfigurationService {

    private static final Logger logger = Logger.getLogger(GlobalConfigurationService.class.getName());

    @Context private HttpServletRequest httpServletRequest;
    @Context private HttpServletResponse httpServletResponse;
    @Context private UriInfo uriInfo;

    private static final String server = "https://46.101.127.78:8443"; // iotp server
    private static final String client = "https://46.101.127.78:9443"; // clm server
    private static final String ipAddress = "46.101.127.78";
    //private static final String iotpApp = server+"/iotp";
    private static final String iotpApp = server+"/iotp-0.0.1-SNAPSHOT";

    public GlobalConfigurationService() {
        super();
    }

    @GET
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON, OslcMediaType.TEXT_TURTLE})
    public Response getData() {
        StringBuilder builder = new StringBuilder();
        builder.append("<rdf:RDF\n" +
                "    xmlns:dcterms=\"http://purl.org/dc/terms/\"\n" +
                "    xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n" +
                "    xmlns:oslc=\"http://open-services.net/ns/core#\"\n" +
                "    xmlns:vvc=\"http://jazz.net/ns/vvc#\">\n" +
                "    <oslc:ServiceProviderCatalog rdf:about=\""+iotpApp+"/services/oslc_config\">\n" +
                "        <oslc:serviceProvider>\n" +
                "            <oslc:ServiceProvider rdf:about=\""+iotpApp+"/services/oslc_config/components\">\n" +
                "                <oslc:details rdf:resource=\""+iotpApp+"/services/oslc_config/components\"/>\n" +
                "                <dcterms:title>RM Configuration Management Service Provider</dcterms:title>\n" +
                "            </oslc:ServiceProvider>\n" +
                "        </oslc:serviceProvider>\n" +
                "        <oslc:domain rdf:resource=\"http://open-services.net/ns/config#\"/>\n" +
                "        <dcterms:description>Configuration Services Provided by the RM application.</dcterms:description>\n" +
                "        <dcterms:title>RM Configuration Management Services Catalog</dcterms:title>\n" +
                "    </oslc:ServiceProviderCatalog>\n" +
                "</rdf:RDF>");

        String responseBody = builder.toString();

	logger.info("Return from getData()");

        return Response.ok().entity(responseBody).header("max-age", 0).header("pragma", "no-cache")
                .header("Cache-Control", "no-cache").header("OSLC-Core-Version", 2.0)
                .header("Content-Length", responseBody.getBytes().length).type(OslcMediaType.APPLICATION_RDF_XML)
                .build();

    }

    @GET
    @Path("components")
    public Response getComponents() {
        StringBuilder builder = new StringBuilder();
        builder.append("<rdf:RDF\n" +
                "    xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n" +
                "    xmlns:oslc=\"http://open-services.net/ns/core#\"\n" +
                "    xmlns:vvc=\"http://jazz.net/ns/vvc#\"\n" +
                "    xmlns:dcterms=\"http://purl.org/dc/terms/\">\n" +
                "  <oslc:ServiceProvider>\n" +
                "    <oslc:service>\n" +
                "      <oslc:Service>\n" +
                "        <oslc:selectionDialog>\n" +
                "            <oslc:Dialog>\n" +
                "              <dcterms:title>RM Component Configuration Picker</dcterms:title>\n" +
                "              <oslc:label>RM Component Configuration Picker</oslc:label>\n" +
                "              <oslc:dialog rdf:resource=\""+iotpApp+"/services/oslc_config/selection\"/>\n" +
                "              <oslc:hintWidth>600px</oslc:hintWidth>\n" +
                "              <oslc:hintHeight>500px</oslc:hintHeight>\n" +
                "              <oslc:resourceType rdf:resource=\"http://jazz.net/ns/vvc#Configuration\"/>\n" +
                "              <oslc:usage rdf:resource=\"http://jazz.net/ns/vvc#Configuration\"/>\n" +
                "            </oslc:Dialog>\n" +
                "          </oslc:selectionDialog>\n" +
                "        </oslc:Service>\n" +
                "      </oslc:service>\n" +
                "    </oslc:ServiceProvider>\n" +
                "</rdf:RDF>");

        String responseBody = builder.toString();
	
	logger.info("Return from getComponents()");

        return Response.ok().entity(responseBody).header("max-age", 0).header("pragma", "no-cache")
                .header("Cache-Control", "no-cache").header("OSLC-Core-Version", 2.0)
                .header("Content-Length", responseBody.getBytes().length).type(OslcMediaType.APPLICATION_RDF_XML)
                .build();

    }

    @GET
    @Path("component/ldpc")
    public Response getComponent(@QueryParam("project") String project) {

        StringBuilder builder = new StringBuilder();
        builder.append("<rdf:RDF\n" +
                "    xmlns:dcterms=\"http://purl.org/dc/terms/\"\n" +
                "    xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n" +
                "    xmlns:oslc=\"http://open-services.net/ns/core#\"\n" +
                "    xmlns:vvc=\"http://jazz.net/ns/vvc#\"\n" +
                "    xmlns:j.0=\"http://open-services.net/ns/config#\"\n" +
                "    xmlns:ldp=\"http://www.w3.org/ns/ldp#\" >\n" +
                "    <rdf:Description rdf:about=\""+server+"/services/oslc_config/component/ldpc?project=_h0IhEB9VEem7Xs_lJDl6YQ\">\n" +
                "        <rdf:type rdf:resource=\"http://www.w3.org/ns/ldp#BasicContainer\"/>\n" +
                "        <ldp:contains rdf:resource=\""+server+"/services/oslc_config/component/_iCuWsB9VEem7Xs_lJDl6YQ\"/>\n" +
                "    </rdf:Description>\n" +
                "    <rdf:Description rdf:about=\""+server+"/services/oslc_config/component/_iCuWsB9VEem7Xs_lJDl6YQ\">\n" +
                "        <rdf:type rdf:resource=\"http://open-services.net/ns/config#Component\"/>\n" +
                "        <dcterms:title>CLM1-RM-Fabio</dcterms:title>\n" +
                "    </rdf:Description>\n" +
                "</rdf:RDF>");
        String responseBody = builder.toString();

	logger.info("Return from getComponent()");

        return Response.ok().entity(responseBody).header("max-age", 0).header("pragma", "no-cache")
                .header("Cache-Control", "no-cache").header("OSLC-Core-Version", 2.0)
                .header("Content-Length", responseBody.getBytes().length).type(OslcMediaType.APPLICATION_RDF_XML)
                .build();

    }

    @GET
    @Path("publisher")
    public Response getPublisher() {
        StringBuilder builder = new StringBuilder();
        builder.append("<rdf:RDF xmlns:jfs=\"http://jazz.net/xmlns/prod/jazz/jfs/1.0/\"\n" +
                "   xmlns:oslc=\"http://open-services.net/ns/core#\"\n" +
                "   xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n" +
                "   xmlns:dcterms=\"http://purl.org/dc/terms/\">\n" +
                "   <oslc:Publisher  rdf:about=\""+iotpApp+"/services/oslc_config/publisher\">\n" +
                "       <dcterms:title>IOTP-Adaptor Project</dcterms:title>\n" +
                "       <jfs:nonLocalizedTitle>PV Requirements Management</jfs:nonLocalizedTitle>\n" +
                "       <dcterms:description>This application provides the capabilities to create and manage requirements " +
                "                            and trace them to modeling, testing, and change and configuration management. " +
                "                            You can define, elicit, capture, elaborate, discuss, and review requirements and " +
                "                            supporting artifacts.</dcterms:description>\n" +
                "       <dcterms:identifier>http://rm.provider.local</dcterms:identifier>\n" +
                "       <jfs:version>6.0.6</jfs:version>\n" +
                "       <oslc:icon rdf:resource=\"http://rm.provider.local/ecke_oben.gif\"/>\n" +
                "       <jfs:instanceName>/iotp</jfs:instanceName>\n" +
                "   </oslc:Publisher >\n" +
                "</rdf:RDF>");
        String responseBody = builder.toString();

	logger.info("Return from getPublisher()");

        return Response.ok().entity(responseBody).header("max-age", 0).header("pragma", "no-cache")
                .header("Cache-Control", "no-cache").header("OSLC-Core-Version", 2.0)
                .header("Content-Length", responseBody.getBytes().length).type(OslcMediaType.APPLICATION_RDF_XML)
                .build();
    }

    @OslcDialog(title = "Configuration SelectionDialog", label = "Configuration Selection Dialog",
            uri = "oslc_config/selection", hintWidth = "525px", hintHeight = "325px",
            resourceTypes = {Oslc_rmDomainConstants.REQUIREMENT_TYPE, Oslc_cmDomainConstants.CHANGEREQUEST_TYPE, Oslc_amDomainConstants.RESOURCE_TYPE},
            usages = {"http://open-services.net/ns/am#IoTPSelectionDialog"})
    @GET
    @Path("selection")
    @Consumes({ MediaType.TEXT_HTML, MediaType.WILDCARD })
    public void getHtmlDialog(@QueryParam("stream") final String stream
    ) throws ServletException, IOException {

        try {

            httpServletRequest.setAttribute("selectionUri",""+iotpApp+"/services/oslc_config/selection");

            if (stream != null ) {
                httpServletRequest.setAttribute("stream", stream);

                final List<AbstractResource> resources = new ArrayList<>();

                IotpServiceProviderInfo serviceProviderInfo;
                serviceProviderInfo = new IotpServiceProviderInfo();
                serviceProviderInfo.name = "gc";
                serviceProviderInfo.iotId = serviceProviderInfo.name;
                serviceProviderInfo.platformBase = "config";
                serviceProviderInfo.apiVersion = "1.0";

                Resource resource = new Resource();
                resource.setTitle("IoTP Stream Example 1");
                resource.setAbout(new URI(""+iotpApp+"/services/oslc_config/stream/1"));
                resources.add(resource);

                resource = new Resource();
                resource.setTitle("IoTP Stream Example 2");
                resource.setAbout(new URI(""+iotpApp+"/services/oslc_config/stream/2"));
                resources.add(resource);

                resource = new Resource();
                resource.setTitle("IoTP Stream Example 3");
                resource.setAbout(new URI(""+iotpApp+"/services/oslc_config/stream/3"));
                resources.add(resource);

                if (resources != null) {
                    httpServletRequest.setAttribute("resources", resources);
                    RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/com/ibm/oslc/adaptor/iotp/configurationselectiondialogselectorresults.jsp");
                    rd.forward(httpServletRequest, httpServletResponse);
                }
                //a empty search should return an empty list and not NULL!
                throw new WebApplicationException(Response.Status.NOT_FOUND);

            } else {
                try {
                    RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/com/ibm/oslc/adaptor/iotp/configurationselectiondialogselector.jsp");
                    rd.forward(httpServletRequest, httpServletResponse);
                } catch (Exception e) {
                    throw new ServletException(e);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(e);
        } finally{
		logger.info("Return from getHtmlDialog()");
	}

    }

    @GET
    @Path("stream/{streamid}")
    public Response getStream(@PathParam("streamid") String streamid) {
        StringBuilder builder = new StringBuilder();
        builder.append("<rdf:RDF\n" +
                "    xmlns:dcterms=\"http://purl.org/dc/terms/\"\n" +
                "    xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n" +
                "    xmlns:oslc=\"http://open-services.net/ns/core#\"\n" +
                "    xmlns:oslc_config=\"http://open-services.net/ns/config#\"\n" +
                "    xmlns:j.0=\"http://jazz.net/ns/rm/dng/config#\"\n" +
                "    xmlns:acc=\"http://open-services.net/ns/core/acc#\"\n" +
                "    xmlns:process=\"http://jazz.net/ns/process#\">\n" +
                "  <oslc_config:Configuration rdf:about=\""+iotpApp+"/services/oslc_config/stream/" + streamid + "\">\n" +
                "    <dcterms:identifier>" + streamid + "</dcterms:identifier>\n" +
                "    <oslc_config:selections rdf:resource=\""+iotpApp+"/services/oslc_config/configSelections/stream/" + streamid + "\"/>\n" +
                "    <dcterms:title rdf:parseType=\"Literal\">IoTP Adaptor Initial Stream : Ex-" + streamid + "</dcterms:title>\n" +
                "    <dcterms:created rdf:datatype=\"http://www.w3.org/2001/XMLSchema#dateTime\">2019-02-15T20:01:22.388Z</dcterms:created>\n" +
                "    <oslc:serviceProvider rdf:resource=\""+iotpApp+"/services/oslc_config/oslc_rm/"+ streamid +"/services.xml\"/>\n" +
                "    <rdf:type rdf:resource=\"http://open-services.net/ns/config#Stream\"/>\n" +
                "    <process:projectArea rdf:resource=\""+iotpApp+"/services/catalog/singleton\"/>\n" +
                "    <j.0:changesets rdf:resource=\""+iotpApp+"/services/oslc_config/stream/" + streamid + "/changesets\"/>\n" +
                "    <dcterms:creator rdf:resource=\""+client+"/jts/users/koneksys\"/>\n" +
                "    <oslc_config:component rdf:resource=\""+iotpApp+"/services/catalog/singleton\"/>\n" +
                "    <dcterms:description></dcterms:description>\n" +
                "    <acc:accessContext rdf:resource=\""+iotpApp+"/services/oslc_config/stream/acclist/" + streamid + "\"/>\n" +
                "    <oslc_config:acceptedBy rdf:resource=\"http://open-services.net/ns/config#Configuration\"/>\n" +
                "    <oslc_config:baselines rdf:resource=\""+iotpApp+"/services/oslc_config/stream/" + streamid + "/baselines\"/>\n" +
                "  </oslc_config:Configuration>\n" +
                "</rdf:RDF>");

        String responseBody = builder.toString();

	logger.info("Return from getStream()");

        return Response.ok().entity(responseBody).header("max-age", 0).header("pragma", "no-cache")
                .header("Cache-Control", "no-cache").header("OSLC-Core-Version", 2.0)
                .header("Content-Length", responseBody.getBytes().length).type(OslcMediaType.APPLICATION_RDF_XML)
                .build();

    }

    @GET
    @Path("configSelections/stream/{streamid}")
    public Response getConfigSelections(@PathParam("streamid") String streamid) {
        StringBuilder builder = new StringBuilder();
        builder.append("<rdf:RDF\n" +
                "    xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n" +
                "    xmlns:oslc_config=\"http://open-services.net/ns/config#\"\n" +
                "    xmlns:ldp=\"http://www.w3.org/ns/ldp#\">\n" +
                "  <ldp:DirectContainer rdf:about=\""+iotpApp+"/services/oslc_config/configSelections/stream/_d4bccDFcEem2yvMwWQFZKg\">\n" +
                "    <oslc_config:selects rdf:resource=\""+client+"/rm/versionedShapes/_iBduoTFcEem2yvMwWQFZKg/configuration/cm/stream/_d4bccDFcEem2yvMwWQFZKg\"/>\n" +
                "    <oslc_config:selects rdf:resource=\""+client+"/rm/versionedShapes/_iBdumzFcEem2yvMwWQFZKg/configuration/cm/stream/_d4bccDFcEem2yvMwWQFZKg\"/>\n" +
                "    <ldp:membershipResource rdf:resource=\""+client+"/rm/configSelections/stream/_d4bccDFcEem2yvMwWQFZKg\"/>\n" +
                "    <oslc_config:selects rdf:resource=\""+client+"/rm/versionedShapes/_iBduojFcEem2yvMwWQFZKg/configuration/cm/stream/_d4bccDFcEem2yvMwWQFZKg\"/>\n" +
                "    <oslc_config:selects rdf:resource=\""+client+"/rm/versionedShapes/_iBduqDFcEem2yvMwWQFZKg/configuration/cm/stream/_d4bccDFcEem2yvMwWQFZKg\"/>\n" +
                "    <oslc_config:selects rdf:resource=\""+client+"/rm/versionedShapes/_iBdupzFcEem2yvMwWQFZKg/configuration/cm/stream/_d4bccDFcEem2yvMwWQFZKg\"/>\n" +
                "    <oslc_config:selects rdf:resource=\""+client+"/rm/versionedShapes/_iBduoDFcEem2yvMwWQFZKg/configuration/cm/stream/_d4bccDFcEem2yvMwWQFZKg\"/>\n" +
                "    <ldp:hasMemberRelation rdf:resource=\"http://open-services.net/ns/config#selects\"/>\n" +
                "    <oslc_config:selects rdf:resource=\""+client+"/rm/versionedShapes/_iBduqjFcEem2yvMwWQFZKg/configuration/cm/stream/_d4bccDFcEem2yvMwWQFZKg\"/>\n" +
                "    <oslc_config:selects rdf:resource=\""+client+"/rm/versionedShapes/_iBduozFcEem2yvMwWQFZKg/configuration/cm/stream/_d4bccDFcEem2yvMwWQFZKg\"/>\n" +
                "    <oslc_config:selects rdf:resource=\""+client+"/rm/versionedShapes/_iBdunzFcEem2yvMwWQFZKg/configuration/cm/stream/_d4bccDFcEem2yvMwWQFZKg\"/>\n" +
                "    <oslc_config:selects rdf:resource=\""+client+"/rm/versionedShapes/_iBduqzFcEem2yvMwWQFZKg/configuration/cm/stream/_d4bccDFcEem2yvMwWQFZKg\"/>\n" +
                "    <oslc_config:selects rdf:resource=\""+client+"/rm/versionedShapes/_iBdupjFcEem2yvMwWQFZKg/configuration/cm/stream/_d4bccDFcEem2yvMwWQFZKg\"/>\n" +
                "    <oslc_config:selects rdf:resource=\""+client+"/rm/versionedShapes/_iBdunTFcEem2yvMwWQFZKg/configuration/cm/stream/_d4bccDFcEem2yvMwWQFZKg\"/>\n" +
                "    <oslc_config:selects rdf:resource=\""+client+"/rm/versionedShapes/_iBdunDFcEem2yvMwWQFZKg/configuration/cm/stream/_d4bccDFcEem2yvMwWQFZKg\"/>\n" +
                "    <rdf:type rdf:resource=\"http://open-services.net/ns/config#Selections\"/>\n" +
                "    <oslc_config:selects rdf:resource=\""+client+"/rm/versionedShapes/_iBdupTFcEem2yvMwWQFZKg/configuration/cm/stream/_d4bccDFcEem2yvMwWQFZKg\"/>\n" +
                "    <oslc_config:selects rdf:resource=\""+client+"/rm/versionedShapes/_iBdunjFcEem2yvMwWQFZKg/configuration/cm/stream/_d4bccDFcEem2yvMwWQFZKg\"/>\n" +
                "    <oslc_config:selects rdf:resource=\""+client+"/rm/versionedShapes/_iBdumjFcEem2yvMwWQFZKg/configuration/cm/stream/_d4bccDFcEem2yvMwWQFZKg\"/>\n" +
                "    <oslc_config:selects rdf:resource=\""+client+"/rm/versionedShapes/_iBdupDFcEem2yvMwWQFZKg/configuration/cm/stream/_d4bccDFcEem2yvMwWQFZKg\"/>\n" +
                "    <oslc_config:selects rdf:resource=\""+client+"/rm/versionedShapes/_iBduqTFcEem2yvMwWQFZKg/configuration/cm/stream/_d4bccDFcEem2yvMwWQFZKg\"/>\n" +
                "  </ldp:DirectContainer>\n" +
                "</rdf:RDF>\n");

        String responseBody = builder.toString();

	logger.info("Return from getConfigSelections()");

        return Response.ok().entity(responseBody).header("max-age", 0).header("pragma", "no-cache")
                .header("Cache-Control", "no-cache").header("OSLC-Core-Version", 2.0)
                .header("Content-Length", responseBody.getBytes().length).type(OslcMediaType.APPLICATION_RDF_XML)
                .build();
    }

    @GET
    @Path("project")
    public Response getProject() {
        StringBuilder builder = new StringBuilder();
        builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "  <oslc_rm:ServiceDescriptor " +
                "   xmlns:oslc_rm=\"http://open-services.net/xmlns/rm/1.0/\" " +
                "   xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" " +
                "   rdf:about=\""+iotpApp+"/services/oslc_config/oslc_rm/\"+ streamid +\"/services.xml\">\n" +
                "    <oslc_rm:links>\n" +
                "      <oslc_rm:LinkCreationServices>\n" +
                "        <oslc_rm:validatedByLinkFactory rdf:resource=\""+client+"/rm/links/oslc/validatedByLinks\"/>\n" +
                "        <oslc_rm:implementedByLinkFactory rdf:resource=\""+client+"/rm/links/oslc/implementedByLinks\"/>\n" +
                "      </oslc_rm:LinkCreationServices>\n" +
                "    </oslc_rm:links>\n" +
                "    <oslc_rm:collections>\n" +
                "      <oslc_rm:CollectionSelectionDialog>\n" +
                "        <oslc_rm:heightHint>550px</oslc_rm:heightHint>\n" +
                "        <oslc_rm:widthHint>800px</oslc_rm:widthHint>\n" +
                "        <oslc_rm:widget rdf:resource=\""+client+"/rm/pickers/com.ibm.rdm.web.CollectionPicker?projectURL=https%3A%2F%2F"+ipAddress+"%3A9443%2Frm%2Frm-projects%2F_dm_uMDFcEem2yvMwWQFZKg\"/>\n" +
                "        <dc:title xmlns:dc=\"http://purl.org/dc/terms/\">Collection Selection</dc:title>\n" +
                "      </oslc_rm:CollectionSelectionDialog>\n" +
                "    </oslc_rm:collections>\n" +
                "    <oslc_rm:requirements>\n" +
                "      <oslc_rm:SelectionDialog>\n" +
                "        <oslc_rm:heightHint>550px</oslc_rm:heightHint>\n" +
                "        <oslc_rm:widthHint>800px</oslc_rm:widthHint>\n" +
                "        <oslc_rm:widget rdf:resource=\""+client+"/rm/pickers/com.ibm.rdm.web.RRCPicker?projectURL=https%3A%2F%2F"+ipAddress+"%3A9443%2Frm%2Frm-projects%2F_dm_uMDFcEem2yvMwWQFZKg\"/>\n" +
                "        <dc:title xmlns:dc=\"http://purl.org/dc/terms/\">Requirement Selection</dc:title>\n" +
                "      </oslc_rm:SelectionDialog>\n" +
                "    </oslc_rm:requirements>\n" +
                "    <dc:description xmlns:dc=\"http://purl.org/dc/terms/\">Service Descriptor for Project: CLM2-RM1-TC3-mario</dc:description>\n" +
                "    <dc:title xmlns:dc=\"http://purl.org/dc/terms/\">CLM2-RM1-TC3-mario</dc:title>\n" +
                "  </oslc_rm:ServiceDescriptor>");
        String responseBody = builder.toString();

	logger.info("Return from getProject()");

        return Response.ok().entity(responseBody).header("max-age", 0).header("pragma", "no-cache")
                .header("Cache-Control", "no-cache").header("OSLC-Core-Version", 2.0)
                .header("Content-Length", responseBody.getBytes().length).type(OslcMediaType.APPLICATION_RDF_XML)
                .build();
    }

    @GET
    @Path("oslc_rm/{streamid}/services.xml")
    public Response getService(@PathParam("streamid") String streamid) {
        StringBuilder builder = new StringBuilder();
        builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "  <oslc_rm:ServiceDescriptor " +
                "   xmlns:oslc_rm=\"http://open-services.net/xmlns/rm/1.0/\" " +
                "   xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" " +
                "   rdf:about=\""+iotpApp+"/services/oslc_config/oslc_rm/\"+ streamid +\"/services.xml\">\n" +
                "    <oslc_rm:links>\n" +
                "      <oslc_rm:LinkCreationServices>\n" +
                "        <oslc_rm:validatedByLinkFactory rdf:resource=\""+client+"/rm/links/oslc/validatedByLinks\"/>\n" +
                "        <oslc_rm:implementedByLinkFactory rdf:resource=\""+client+"/rm/links/oslc/implementedByLinks\"/>\n" +
                "      </oslc_rm:LinkCreationServices>\n" +
                "    </oslc_rm:links>\n" +
                "    <oslc_rm:collections>\n" +
                "      <oslc_rm:CollectionSelectionDialog>\n" +
                "        <oslc_rm:heightHint>550px</oslc_rm:heightHint>\n" +
                "        <oslc_rm:widthHint>800px</oslc_rm:widthHint>\n" +
                "        <oslc_rm:widget rdf:resource=\""+client+"/rm/pickers/com.ibm.rdm.web.CollectionPicker?projectURL=https%3A%2F%2F"+ipAddress+"%3A9443%2Frm%2Frm-projects%2F_dm_uMDFcEem2yvMwWQFZKg\"/>\n" +
                "        <dc:title xmlns:dc=\"http://purl.org/dc/terms/\">Collection Selection</dc:title>\n" +
                "      </oslc_rm:CollectionSelectionDialog>\n" +
                "    </oslc_rm:collections>\n" +
                "    <oslc_rm:requirements>\n" +
                "      <oslc_rm:SelectionDialog>\n" +
                "        <oslc_rm:heightHint>550px</oslc_rm:heightHint>\n" +
                "        <oslc_rm:widthHint>800px</oslc_rm:widthHint>\n" +
                "        <oslc_rm:widget rdf:resource=\""+client+"/rm/pickers/com.ibm.rdm.web.RRCPicker?projectURL=https%3A%2F%2F"+ipAddress+"%3A9443%2Frm%2Frm-projects%2F_dm_uMDFcEem2yvMwWQFZKg\"/>\n" +
                "        <dc:title xmlns:dc=\"http://purl.org/dc/terms/\">Requirement Selection</dc:title>\n" +
                "      </oslc_rm:SelectionDialog>\n" +
                "    </oslc_rm:requirements>\n" +
                "    <dc:description xmlns:dc=\"http://purl.org/dc/terms/\">Service Descriptor for Project: CLM2-RM1-TC3-mario</dc:description>\n" +
                "    <dc:title xmlns:dc=\"http://purl.org/dc/terms/\">CLM2-RM1-TC3-mario</dc:title>\n" +
                "  </oslc_rm:ServiceDescriptor>");

        String responseBody = builder.toString();

	logger.info("Return from getService()");

        return Response.ok().entity(responseBody).header("max-age", 0).header("pragma", "no-cache")
                .header("Cache-Control", "no-cache").header("OSLC-Core-Version", 2.0)
                .header("Content-Length", responseBody.getBytes().length).type(OslcMediaType.APPLICATION_RDF_XML)
                .build();

    }

    @GET
    @Path("stream/acclist/{streamid}")
    public Response getAccList(@PathParam("streamid") String streamid) {
        StringBuilder builder = new StringBuilder();
        builder.append("{\n" +
                "    \"@context\": {\n" +
                "        \"acc\": \"http:\\/\\/open-services.net\\/ns\\/core\\/acc#\",\n" +
                "        \"broader\": \"http:\\/\\/www.w3.org\\/2004\\/02\\/skos\\/core#broader\",\n" +
                "        \"clm_acc\": \"http:\\/\\/jazz.net\\/ns\\/clm\\/acc#\",\n" +
                "        \"contextId\": \"http:\\/\\/jazz.net\\/ns\\/clm\\/acc#contextId\",\n" +
                "        \"description\": \"http:\\/\\/purl.org\\/dc\\/terms\\/description\",\n" +
                "        \"id\": \"@id\",\n" +
                "        \"isPublic\": \"http:\\/\\/jazz.net\\/ns\\/clm\\/acc#isPublic\",\n" +
                "        \"title\": \"http:\\/\\/purl.org\\/dc\\/terms\\/title\",\n" +
                "        \"tool\": \"http:\\/\\/jazz.net\\/ns\\/clm\\/acc#tool\",\n" +
                "        \"type\": \"@type\"\n" +
                "    },\n" +
                "    \"@graph\": [\n" +
                "        {\n" +
                "            \"id\": \"https:\\/\\/"+client+":9443\\/rm\\/acclist\",\n" +
                "            \"tool\": {\n" +
                "                \"@id\": \"clm_acc:Rm\"\n" +
                "            },\n" +
                "            \"type\": \"acc:AccessContextList\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"contextId\": \"_MsFggALeEemG5v5KJUYxpQ\",\n" +
                "            \"description\": \"\",\n" +
                "            \"id\": \"https:\\/\\/"+client+":9443\\/rm\\/acclist#_MsFggALeEemG5v5KJUYxpQ\",\n" +
                "            \"isPublic\": false,\n" +
                "            \"title\": \"CLM2 RM PA-1A\",\n" +
                "            \"type\": [\n" +
                "                \"acc:AccessContext\",\n" +
                "                \"clm_acc:ProjectAreaContext\"\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"contextId\": \"_mhlIwBjgEem2Z4Ia58vF_A\",\n" +
                "            \"description\": \"\",\n" +
                "            \"id\": \"https:\\/\\/"+client+":9443\\/rm\\/acclist#_mhlIwBjgEem2Z4Ia58vF_A\",\n" +
                "            \"isPublic\": false,\n" +
                "            \"title\": \"Victor CLM2 playground with Configurations\",\n" +
                "            \"type\": [\n" +
                "                \"acc:AccessContext\",\n" +
                "                \"clm_acc:ProjectAreaContext\"\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"contextId\": \"_keVUYBntEemODtq02xa0dw\",\n" +
                "            \"description\": \"\",\n" +
                "            \"id\": \"https:\\/\\/"+client+":9443\\/rm\\/acclist#_keVUYBntEemODtq02xa0dw\",\n" +
                "            \"isPublic\": false,\n" +
                "            \"title\": \"Victor RM-CLM2 Demo Project without configs\",\n" +
                "            \"type\": [\n" +
                "                \"acc:AccessContext\",\n" +
                "                \"clm_acc:ProjectAreaContext\"\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"contextId\": \"_FeovwBnyEemODtq02xa0dw\",\n" +
                "            \"description\": \"\",\n" +
                "            \"id\": \"https:\\/\\/"+client+":9443\\/rm\\/acclist#_FeovwBnyEemODtq02xa0dw\",\n" +
                "            \"isPublic\": false,\n" +
                "            \"title\": \"Victor RM-CLM2 Demo Project WITH configs\",\n" +
                "            \"type\": [\n" +
                "                \"acc:AccessContext\",\n" +
                "                \"clm_acc:ProjectAreaContext\"\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"contextId\": \"_h0IhEB9VEem7Xs_lJDl6YQ\",\n" +
                "            \"description\": \"\",\n" +
                "            \"id\": \"https:\\/\\/"+client+":9443\\/rm\\/acclist#_h0IhEB9VEem7Xs_lJDl6YQ\",\n" +
                "            \"isPublic\": false,\n" +
                "            \"title\": \"CLM1-RM-Fabio\",\n" +
                "            \"type\": [\n" +
                "                \"acc:AccessContext\",\n" +
                "                \"clm_acc:ProjectAreaContext\"\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"contextId\": \"_dm_uMDFcEem2yvMwWQFZKg\",\n" +
                "            \"description\": \"CLM2-RM1-TC3-mario\",\n" +
                "            \"id\": \"https:\\/\\/"+client+":9443\\/rm\\/acclist#_dm_uMDFcEem2yvMwWQFZKg\",\n" +
                "            \"isPublic\": false,\n" +
                "            \"title\": \"CLM2-RM1-TC3-mario\",\n" +
                "            \"type\": [\n" +
                "                \"acc:AccessContext\",\n" +
                "                \"clm_acc:ProjectAreaContext\"\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}");


        String responseBody = builder.toString();

	logger.info("Return from getAccList()");

        return Response.ok().entity(responseBody).header("max-age", 0).header("pragma", "no-cache")
                .header("Cache-Control", "no-cache").header("OSLC-Core-Version", 2.0)
                .header("Content-Length", responseBody.getBytes().length).type(OslcMediaType.APPLICATION_JSON_LD)
                .build();
    }

}

