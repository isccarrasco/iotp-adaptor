// Start of user code Copyright
/*******************************************************************************
 * Copyright (c) 2012 IBM Corporation and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompanies this distribution.
 *
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *
 *     Michael Fiedler     - initial API and implementation for Bugzilla adapter
 *     Jad El-khoury       - initial implementation of code generator (https://bugs.eclipse.org/bugs/show_bug.cgi?id=422448)
 *     Jim Amsden          - Support for UI Preview (494303)
 *
 * This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/
// End of user code

package com.ibm.oslc.adaptor.iotp.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.UriBuilder;

import org.apache.wink.json4j.JSONObject;
import org.eclipse.lyo.oslc4j.provider.json4j.JsonHelper;
import org.eclipse.lyo.oslc4j.core.OSLC4JUtils;
import org.eclipse.lyo.oslc4j.core.annotation.OslcCreationFactory;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDialog;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDialogs;
import org.eclipse.lyo.oslc4j.core.annotation.OslcQueryCapability;
import org.eclipse.lyo.oslc4j.core.annotation.OslcService;
import org.eclipse.lyo.oslc4j.core.model.Compact;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.OslcMediaType;
import org.eclipse.lyo.oslc4j.core.model.Preview;
import org.eclipse.lyo.oslc4j.core.model.ServiceProvider;
import org.eclipse.lyo.oslc4j.core.model.Link;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;

import com.ibm.oslc.adaptor.iotp.CE4IoTConnectorManager;
import com.ibm.oslc.adaptor.iotp.CE4IoTConnectorConstants;
import com.ibm.oslc.adaptor.iotp.resources.Oslc_bmxDomainConstants;
import com.ibm.oslc.adaptor.iotp.resources.Oslc_bmxDomainConstants;
import com.ibm.oslc.adaptor.iotp.resources.Oslc_bmxDomainConstants;
import com.ibm.oslc.adaptor.iotp.resources.Oslc_cmDomainConstants;
import com.ibm.oslc.adaptor.iotp.resources.Oslc_rmDomainConstants;
import com.ibm.oslc.adaptor.iotp.servlet.ServiceProviderCatalogSingleton;
import com.ibm.oslc.adaptor.iotp.resources.App;
import com.ibm.oslc.adaptor.iotp.resources.CFService;
import com.ibm.oslc.adaptor.iotp.resources.ChangeRequest;
import com.ibm.oslc.adaptor.iotp.resources.Discussion;
import com.ibm.oslc.adaptor.iotp.resources.Flow;
import com.ibm.oslc.adaptor.iotp.resources.NodeREDApp;
import com.ibm.oslc.adaptor.iotp.resources.Person;
import com.ibm.oslc.adaptor.iotp.resources.Requirement;
import com.ibm.oslc.adaptor.iotp.resources.Resource;
import com.ibm.oslc.adaptor.iotp.resources.Space;

// Start of user code imports
import com.ibm.oslc.adaptor.iotp.BmxServiceProviderInfo;
import org.eclipse.lyo.oslc4j.core.OSLC4JUtils;
// End of user code

// Start of user code pre_class_code
// End of user code
@OslcService(Oslc_bmxDomainConstants.BLUEMIX_DOMAIN)
@Path("bmx/{bmxId}/resources")
public class BluemixService
{
    @Context private HttpServletRequest httpServletRequest;
    @Context private HttpServletResponse httpServletResponse;
    @Context private UriInfo uriInfo;

    // Start of user code class_attributes
    // End of user code

    // Start of user code class_methods
	// End of user code

    public BluemixService()
    {
        super();
    }

    @OslcQueryCapability
    (
        title = "SpaceQueryCapability",
        label = "Space Query Capability",
        resourceShape = OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_bmxDomainConstants.PATH_SPACE,
        resourceTypes = {Oslc_bmxDomainConstants.TYPE_SPACE},
        usages = {}
    )
    @GET
    @Path("space")
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON, OslcMediaType.TEXT_TURTLE})
    public Space[] querySpaces(
                                                    @PathParam("bmxId") final String bmxId ,
                                                     @QueryParam("oslc.where") final String where,
                                                     @QueryParam("page") final String pageString,
                                                    @QueryParam("limit") final String limitString) throws IOException, ServletException
    {
        int page=0;
        int limit=20;
        if (null != pageString) {
            page = Integer.parseInt(pageString);
        }
        if (null != limitString) {
            limit = Integer.parseInt(limitString);
        }

        // Start of user code querySpaces
        // Here additional logic can be implemented that complements main action taken in CE4IoTConnectorManager
        // End of user code

        final List<Space> resources = CE4IoTConnectorManager.querySpaces(httpServletRequest, bmxId, where, page, limit);
        return resources.toArray(new Space [resources.size()]);
    }

    @GET
    @Path("space")
    @Produces({ MediaType.TEXT_HTML })
    public Response querySpacesAsHtml(
                                    @PathParam("bmxId") final String bmxId ,
                                       @QueryParam("oslc.where") final String where,
                                       @QueryParam("page") final String pageString,
                                    @QueryParam("limit") final String limitString) throws ServletException, IOException
    {
        int page=0;
        int limit=20;
        if (null != pageString) {
            page = Integer.parseInt(pageString);
        }
        if (null != limitString) {
            limit = Integer.parseInt(limitString);
        }

        // Start of user code querySpacesAsHtml
        // End of user code

        final List<Space> resources = CE4IoTConnectorManager.querySpaces(httpServletRequest, bmxId, where, page, limit);

        if (resources!= null) {
            httpServletRequest.setAttribute("resources", resources);
            // Start of user code querySpacesAsHtml_setAttributes
            // End of user code

            httpServletRequest.setAttribute("queryUri",
                    uriInfo.getAbsolutePath().toString() + "?oslc.paging=true");
            if (resources.size() > limit) {
                resources.remove(resources.size() - 1);
                httpServletRequest.setAttribute("nextPageUri",
                        uriInfo.getAbsolutePath().toString() + "?oslc.paging=true&amp;page=" + (page + 1));
            }
            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/com/ibm/oslc/adaptor/iotp/spacescollection.jsp");
            rd.forward(httpServletRequest,httpServletResponse);
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @OslcQueryCapability
    (
        title = "NodeREDQueryCapability",
        label = "Node-RED App Query Capability",
        resourceShape = OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_bmxDomainConstants.PATH_NODEREDAPP,
        resourceTypes = {Oslc_bmxDomainConstants.TYPE_NODEREDAPP},
        usages = {}
    )
    @GET
    @Path("noderedapp")
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON, OslcMediaType.TEXT_TURTLE})
    public NodeREDApp[] queryNodeREDApps(
                                                    @PathParam("bmxId") final String bmxId ,
                                                     @QueryParam("oslc.where") final String where,
                                                     @QueryParam("page") final String pageString,
                                                    @QueryParam("limit") final String limitString) throws IOException, ServletException
    {
        int page=0;
        int limit=20;
        if (null != pageString) {
            page = Integer.parseInt(pageString);
        }
        if (null != limitString) {
            limit = Integer.parseInt(limitString);
        }

        // Start of user code queryNodeREDApps
        // Here additional logic can be implemented that complements main action taken in CE4IoTConnectorManager
        // End of user code

        final List<NodeREDApp> resources = CE4IoTConnectorManager.queryNodeREDApps(httpServletRequest, bmxId, where, page, limit);
        return resources.toArray(new NodeREDApp [resources.size()]);
    }

    @GET
    @Path("noderedapp")
    @Produces({ MediaType.TEXT_HTML })
    public Response queryNodeREDAppsAsHtml(
                                    @PathParam("bmxId") final String bmxId ,
                                       @QueryParam("oslc.where") final String where,
                                       @QueryParam("page") final String pageString,
                                    @QueryParam("limit") final String limitString) throws ServletException, IOException
    {
        int page=0;
        int limit=20;
        if (null != pageString) {
            page = Integer.parseInt(pageString);
        }
        if (null != limitString) {
            limit = Integer.parseInt(limitString);
        }

        // Start of user code queryNodeREDAppsAsHtml
        // End of user code

        final List<NodeREDApp> resources = CE4IoTConnectorManager.queryNodeREDApps(httpServletRequest, bmxId, where, page, limit);

        if (resources!= null) {
            httpServletRequest.setAttribute("resources", resources);
            // Start of user code queryNodeREDAppsAsHtml_setAttributes
            // End of user code

            httpServletRequest.setAttribute("queryUri",
                    uriInfo.getAbsolutePath().toString() + "?oslc.paging=true");
            if (resources.size() > limit) {
                resources.remove(resources.size() - 1);
                httpServletRequest.setAttribute("nextPageUri",
                        uriInfo.getAbsolutePath().toString() + "?oslc.paging=true&amp;page=" + (page + 1));
            }
            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/com/ibm/oslc/adaptor/iotp/noderedappscollection.jsp");
            rd.forward(httpServletRequest,httpServletResponse);
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @OslcDialog
    (
         title = "BmxSelectionDialog",
         label = "BmxSelectionDialog",
         uri = "bmx/{bmxId}/resources/selector",
         hintWidth = "525px",
         hintHeight = "325px",
         resourceTypes = {Oslc_bmxDomainConstants.TYPE_NODEREDAPP, Oslc_cmDomainConstants.TYPE_CHANGEREQUEST, Oslc_rmDomainConstants.TYPE_REQUIREMENT},
         usages = {}
    )
    @GET
    @Path("selector")
    @Consumes({ MediaType.TEXT_HTML, MediaType.WILDCARD })
    public void NodeREDAppAndChangeRequestAndRequirementSelector(
        @QueryParam("terms") final String terms
        , @PathParam("bmxId") final String bmxId
        ) throws ServletException, IOException
    {
        try {
            // Start of user code NodeREDAppAndChangeRequestAndRequirementSelector_init
            // End of user code

            httpServletRequest.setAttribute("selectionUri",uriInfo.getAbsolutePath().toString());
            // Start of user code NodeREDAppAndChangeRequestAndRequirementSelector_setAttributes
            // End of user code

            if (terms != null ) {
                httpServletRequest.setAttribute("terms", terms);
                final List<AbstractResource> resources = CE4IoTConnectorManager.NodeREDAppAndChangeRequestAndRequirementSelector(httpServletRequest, bmxId, terms);
                if (resources!= null) {
                            httpServletRequest.setAttribute("resources", resources);
                            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/com/ibm/oslc/adaptor/iotp/noderedappandchangerequestandrequirementselectorresults.jsp");
                            rd.forward(httpServletRequest, httpServletResponse);
                }
                //a empty search should return an empty list and not NULL!
                throw new WebApplicationException(Status.NOT_FOUND);

            } else {
                try {
                    RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/com/ibm/oslc/adaptor/iotp/noderedappandchangerequestandrequirementselector.jsp");
                    rd.forward(httpServletRequest, httpServletResponse);
                } catch (Exception e) {
                    throw new ServletException(e);
                }
            }
        } catch (Exception e) {
            throw new WebApplicationException(e);
        }
    }

    @GET
    @Path("spaces/{spaceId}")
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON, OslcMediaType.TEXT_TURTLE})
    public Space getSpace(
                @PathParam("bmxId") final String bmxId, @PathParam("spaceId") final String spaceId
        ) throws IOException, ServletException, URISyntaxException
    {
        // Start of user code getResource_init
        // End of user code

        final Space aSpace = CE4IoTConnectorManager.getSpace(httpServletRequest, bmxId, spaceId);

        if (aSpace != null) {
            // Start of user code getSpace
            // End of user code
            httpServletResponse.addHeader(CE4IoTConnectorConstants.HDR_OSLC_VERSION, CE4IoTConnectorConstants.OSLC_VERSION_V2);
            return aSpace;
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("spaces/{spaceId}")
    @Produces({ MediaType.TEXT_HTML })
    public Response getSpaceAsHtml(
        @PathParam("bmxId") final String bmxId, @PathParam("spaceId") final String spaceId
        ) throws ServletException, IOException, URISyntaxException
    {
        // Start of user code getSpaceAsHtml_init
        // End of user code

        final Space aSpace = CE4IoTConnectorManager.getSpace(httpServletRequest, bmxId, spaceId);

        if (aSpace != null) {
            httpServletRequest.setAttribute("aSpace", aSpace);
            // Start of user code getSpaceAsHtml_setAttributes
            // Redirect to the Bluemix Platform dashboard for the resource
	    		try {
	                String iotDashboardURI = "https://console.bluemix.net/dashboard/apps?space="+aSpace.getTitle();
	                httpServletResponse.sendRedirect(iotDashboardURI);
	                return Response.ok().build();
	    		} catch (Exception e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
            // End of user code

            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/com/ibm/oslc/adaptor/iotp/space.jsp");
            rd.forward(httpServletRequest,httpServletResponse);
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("spaces/{spaceId}")
    @Produces({OslcMediaType.APPLICATION_X_OSLC_COMPACT_XML})
    public Compact getSpaceCompact(
        @PathParam("bmxId") final String bmxId, @PathParam("spaceId") final String spaceId
        ) throws ServletException, IOException, URISyntaxException
    {
        String iconUri = OSLC4JUtils.getPublicURI() + "/images/ui_preview_icon.gif";
        String smallPreviewHintHeight = "10em";
        String smallPreviewHintWidth = "45em";
        String largePreviewHintHeight = "20em";
        String largePreviewHintWidth = "45em";

        // Start of user code getSpaceCompact_init
        //TODO: adjust the preview height & width values from the default values provided above.
        // End of user code

        final Space aSpace = CE4IoTConnectorManager.getSpace(httpServletRequest, bmxId, spaceId);

        if (aSpace != null) {
            final Compact compact = new Compact();

            compact.setAbout(aSpace.getAbout());
            compact.setTitle(aSpace.toString());

            compact.setIcon(new URI(iconUri));

            //Create and set attributes for OSLC preview resource
            final Preview smallPreview = new Preview();
            smallPreview.setHintHeight(smallPreviewHintHeight);
            smallPreview.setHintWidth(smallPreviewHintWidth);
            smallPreview.setDocument(UriBuilder.fromUri(aSpace.getAbout()).path("smallPreview").build());
            compact.setSmallPreview(smallPreview);

            //Use the HTML representation of a change request as the large preview as well
            final Preview largePreview = new Preview();
            largePreview.setHintHeight(largePreviewHintHeight);
            largePreview.setHintWidth(largePreviewHintWidth);
            largePreview.setDocument(aSpace.getAbout());
            compact.setLargePreview(largePreview);
            httpServletResponse.addHeader(CE4IoTConnectorConstants.HDR_OSLC_VERSION, CE4IoTConnectorConstants.OSLC_VERSION_V2);
            return compact;
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("spaces/{spaceId}/smallPreview")
    @Produces({ MediaType.TEXT_HTML })
    public void getSpaceAsHtmlSmallPreview(
        @PathParam("bmxId") final String bmxId, @PathParam("spaceId") final String spaceId
        ) throws ServletException, IOException, URISyntaxException
    {
        // Start of user code getSpaceAsHtmlSmallPreview_init
        // End of user code

        final Space aSpace = CE4IoTConnectorManager.getSpace(httpServletRequest, bmxId, spaceId);

        if (aSpace != null) {
            httpServletRequest.setAttribute("aSpace", aSpace);
            // Start of user code getSpaceAsHtmlSmallPreview_setAttributes
            // End of user code

            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/com/ibm/oslc/adaptor/iotp/spacesmallpreview.jsp");
            httpServletResponse.addHeader(CE4IoTConnectorConstants.HDR_OSLC_VERSION, CE4IoTConnectorConstants.OSLC_VERSION_V2);
            rd.forward(httpServletRequest, httpServletResponse);
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }
    @GET
    @Path("nodeREDApps/{nodeREDAppId}")
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON, OslcMediaType.TEXT_TURTLE})
    public NodeREDApp getNodeREDApp(
                @PathParam("bmxId") final String bmxId, @PathParam("nodeREDAppId") final String nodeREDAppId
        ) throws IOException, ServletException, URISyntaxException
    {
        // Start of user code getResource_init
        // End of user code

        final NodeREDApp aNodeREDApp = CE4IoTConnectorManager.getNodeREDApp(httpServletRequest, bmxId, nodeREDAppId);

        if (aNodeREDApp != null) {
            // Start of user code getNodeREDApp
            // End of user code
            httpServletResponse.addHeader(CE4IoTConnectorConstants.HDR_OSLC_VERSION, CE4IoTConnectorConstants.OSLC_VERSION_V2);
            return aNodeREDApp;
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("nodeREDApps/{nodeREDAppId}")
    @Produces({ MediaType.TEXT_HTML })
    public Response getNodeREDAppAsHtml(
        @PathParam("bmxId") final String bmxId, @PathParam("nodeREDAppId") final String nodeREDAppId
        ) throws ServletException, IOException, URISyntaxException
    {
        // Start of user code getNodeREDAppAsHtml_init
        // End of user code

        final NodeREDApp aNodeREDApp = CE4IoTConnectorManager.getNodeREDApp(httpServletRequest, bmxId, nodeREDAppId);

        if (aNodeREDApp != null) {
            httpServletRequest.setAttribute("aNodeREDApp", aNodeREDApp);
            // Start of user code getNodeREDAppAsHtml_setAttributes
            // Redirect to the Bluemix Platform dashboard for the resource
			try {
	            String iotDashboardURI = "https://console.bluemix.net/apps/"+aNodeREDApp.getIdentifier();
	            httpServletResponse.sendRedirect(iotDashboardURI);
	            return Response.ok().build();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            // End of user code

            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/com/ibm/oslc/adaptor/iotp/noderedapp.jsp");
            rd.forward(httpServletRequest,httpServletResponse);
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("nodeREDApps/{nodeREDAppId}")
    @Produces({OslcMediaType.APPLICATION_X_OSLC_COMPACT_XML})
    public Compact getNodeREDAppCompact(
        @PathParam("bmxId") final String bmxId, @PathParam("nodeREDAppId") final String nodeREDAppId
        ) throws ServletException, IOException, URISyntaxException
    {
        String iconUri = OSLC4JUtils.getPublicURI() + "/images/ui_preview_icon.gif";
        String smallPreviewHintHeight = "10em";
        String smallPreviewHintWidth = "45em";
        String largePreviewHintHeight = "20em";
        String largePreviewHintWidth = "45em";

        // Start of user code getNodeREDAppCompact_init
        //TODO: adjust the preview height & width values from the default values provided above.
        // End of user code

        final NodeREDApp aNodeREDApp = CE4IoTConnectorManager.getNodeREDApp(httpServletRequest, bmxId, nodeREDAppId);

        if (aNodeREDApp != null) {
            final Compact compact = new Compact();

            compact.setAbout(aNodeREDApp.getAbout());
            compact.setTitle(aNodeREDApp.toString());

            compact.setIcon(new URI(iconUri));

            //Create and set attributes for OSLC preview resource
            final Preview smallPreview = new Preview();
            smallPreview.setHintHeight(smallPreviewHintHeight);
            smallPreview.setHintWidth(smallPreviewHintWidth);
            smallPreview.setDocument(UriBuilder.fromUri(aNodeREDApp.getAbout()).path("smallPreview").build());
            compact.setSmallPreview(smallPreview);

            //Use the HTML representation of a change request as the large preview as well
            final Preview largePreview = new Preview();
            largePreview.setHintHeight(largePreviewHintHeight);
            largePreview.setHintWidth(largePreviewHintWidth);
            largePreview.setDocument(aNodeREDApp.getAbout());
            compact.setLargePreview(largePreview);
            httpServletResponse.addHeader(CE4IoTConnectorConstants.HDR_OSLC_VERSION, CE4IoTConnectorConstants.OSLC_VERSION_V2);
            return compact;
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("nodeREDApps/{nodeREDAppId}/smallPreview")
    @Produces({ MediaType.TEXT_HTML })
    public void getNodeREDAppAsHtmlSmallPreview(
        @PathParam("bmxId") final String bmxId, @PathParam("nodeREDAppId") final String nodeREDAppId
        ) throws ServletException, IOException, URISyntaxException
    {
        // Start of user code getNodeREDAppAsHtmlSmallPreview_init
        // End of user code

        final NodeREDApp aNodeREDApp = CE4IoTConnectorManager.getNodeREDApp(httpServletRequest, bmxId, nodeREDAppId);

        if (aNodeREDApp != null) {
            httpServletRequest.setAttribute("aNodeREDApp", aNodeREDApp);
            // Start of user code getNodeREDAppAsHtmlSmallPreview_setAttributes
            // End of user code

            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/com/ibm/oslc/adaptor/iotp/noderedappsmallpreview.jsp");
            httpServletResponse.addHeader(CE4IoTConnectorConstants.HDR_OSLC_VERSION, CE4IoTConnectorConstants.OSLC_VERSION_V2);
            rd.forward(httpServletRequest, httpServletResponse);
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }
    @DELETE
    @Path("spaces/{spaceId}")
    public Response deleteSpace(
                @PathParam("bmxId") final String bmxId, @PathParam("spaceId") final String spaceId
        ) throws IOException, ServletException, URISyntaxException
    {
        // Start of user code deleteSpace_init
        // End of user code
        final Space aResource = CE4IoTConnectorManager.getSpace(httpServletRequest, bmxId, spaceId);

        if (aResource != null) {
            // Start of user code deleteSpace
            // End of user code
            boolean deleted = CE4IoTConnectorManager.deleteSpace(httpServletRequest, bmxId, spaceId);
            if (deleted)
                return Response.ok().header(CE4IoTConnectorConstants.HDR_OSLC_VERSION, CE4IoTConnectorConstants.OSLC_VERSION_V2).build();
            else
                throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @DELETE
    @Path("nodeREDApps/{nodeREDAppId}")
    public Response deleteNodeREDApp(
                @PathParam("bmxId") final String bmxId, @PathParam("nodeREDAppId") final String nodeREDAppId
        ) throws IOException, ServletException, URISyntaxException
    {
        // Start of user code deleteNodeREDApp_init
        // End of user code
        final NodeREDApp aResource = CE4IoTConnectorManager.getNodeREDApp(httpServletRequest, bmxId, nodeREDAppId);

        if (aResource != null) {
            // Start of user code deleteNodeREDApp
            // End of user code
            boolean deleted = CE4IoTConnectorManager.deleteNodeREDApp(httpServletRequest, bmxId, nodeREDAppId);
            if (deleted)
                return Response.ok().header(CE4IoTConnectorConstants.HDR_OSLC_VERSION, CE4IoTConnectorConstants.OSLC_VERSION_V2).build();
            else
                throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @PUT
    @Path("spaces/{spaceId}")
    @Consumes({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON, OslcMediaType.TEXT_TURTLE})
    public Response updateSpace(
            @HeaderParam("If-Match") final String eTagHeader,
            @PathParam("bmxId") final String bmxId, @PathParam("spaceId") final String spaceId ,
            final Space aResource
        ) throws IOException, ServletException
    {
        // Start of user code updateSpace_init
        // End of user code
        final Space originalResource = CE4IoTConnectorManager.getSpace(httpServletRequest, bmxId, spaceId);

        if (originalResource != null) {
            try {
                final String originalETag = CE4IoTConnectorManager.getETagFromSpace(originalResource);

                if ((eTagHeader == null) || (originalETag.equals(eTagHeader))) {
                    // Start of user code updateSpace
                    // End of user code
                    final Space updatedResource = CE4IoTConnectorManager.updateSpace(httpServletRequest, aResource, bmxId, spaceId);
                    httpServletResponse.setHeader("ETag", CE4IoTConnectorManager.getETagFromSpace(updatedResource));
                    return Response.ok().header(CE4IoTConnectorConstants.HDR_OSLC_VERSION, CE4IoTConnectorConstants.OSLC_VERSION_V2).build();
                }
                else {
                    throw new WebApplicationException(Status.PRECONDITION_FAILED);
                }

            } catch (Exception e) {
                e.printStackTrace();
                throw new WebApplicationException(e);
            }

        }
        else {
            throw new WebApplicationException(Status.NOT_FOUND);
        }
    }

    @PUT
    @Path("nodeREDApps/{nodeREDAppId}")
    @Consumes({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON, OslcMediaType.TEXT_TURTLE})
    public Response updateNodeREDApp(
            @HeaderParam("If-Match") final String eTagHeader,
            @PathParam("bmxId") final String bmxId, @PathParam("nodeREDAppId") final String nodeREDAppId ,
            final NodeREDApp aResource
        ) throws IOException, ServletException
    {
        // Start of user code updateNodeREDApp_init
        // End of user code
        final NodeREDApp originalResource = CE4IoTConnectorManager.getNodeREDApp(httpServletRequest, bmxId, nodeREDAppId);

        if (originalResource != null) {
            try {
                final String originalETag = CE4IoTConnectorManager.getETagFromNodeREDApp(originalResource);

                if ((eTagHeader == null) || (originalETag.equals(eTagHeader))) {
                    // Start of user code updateNodeREDApp
                    // End of user code
                    final NodeREDApp updatedResource = CE4IoTConnectorManager.updateNodeREDApp(httpServletRequest, aResource, bmxId, nodeREDAppId);
                    httpServletResponse.setHeader("ETag", CE4IoTConnectorManager.getETagFromNodeREDApp(updatedResource));
                    return Response.ok().header(CE4IoTConnectorConstants.HDR_OSLC_VERSION, CE4IoTConnectorConstants.OSLC_VERSION_V2).build();
                }
                else {
                    throw new WebApplicationException(Status.PRECONDITION_FAILED);
                }

            } catch (Exception e) {
                e.printStackTrace();
                throw new WebApplicationException(e);
            }

        }
        else {
            throw new WebApplicationException(Status.NOT_FOUND);
        }
    }

}