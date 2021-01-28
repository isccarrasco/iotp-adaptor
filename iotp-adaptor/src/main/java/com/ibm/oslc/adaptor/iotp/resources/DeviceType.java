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
 *     Russell Boykin       - initial API and implementation
 *     Alberto Giammaria    - initial API and implementation
 *     Chris Peters         - initial API and implementation
 *     Gianluca Bernardini  - initial API and implementation
 *       Sam Padgett          - initial API and implementation
 *     Michael Fiedler      - adapted for OSLC4J
 *     Jad El-khoury        - initial implementation of code generator (422448)
 *     Matthieu Helleboid   - Support for multiple Service Providers.
 *     Anass Radouani       - Support for multiple Service Providers.
 *
 * This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/
// End of user code

package com.ibm.oslc.adaptor.iotp.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.ws.rs.core.UriBuilder;

import org.eclipse.lyo.oslc4j.core.OSLC4JUtils;
import org.eclipse.lyo.oslc4j.core.exception.OslcCoreApplicationException;
import org.eclipse.lyo.oslc4j.core.annotation.OslcAllowedValue;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDescription;
import org.eclipse.lyo.oslc4j.core.annotation.OslcMemberProperty;
import org.eclipse.lyo.oslc4j.core.annotation.OslcName;
import org.eclipse.lyo.oslc4j.core.annotation.OslcNamespace;
import org.eclipse.lyo.oslc4j.core.annotation.OslcOccurs;
import org.eclipse.lyo.oslc4j.core.annotation.OslcPropertyDefinition;
import org.eclipse.lyo.oslc4j.core.annotation.OslcRange;
import org.eclipse.lyo.oslc4j.core.annotation.OslcReadOnly;
import org.eclipse.lyo.oslc4j.core.annotation.OslcRepresentation;
import org.eclipse.lyo.oslc4j.core.annotation.OslcResourceShape;
import org.eclipse.lyo.oslc4j.core.annotation.OslcTitle;
import org.eclipse.lyo.oslc4j.core.annotation.OslcValueType;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;
import org.eclipse.lyo.oslc4j.core.model.Link;
import org.eclipse.lyo.oslc4j.core.model.Occurs;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.Representation;
import org.eclipse.lyo.oslc4j.core.model.ValueType;
import org.eclipse.lyo.oslc4j.core.model.ResourceShape;
import org.eclipse.lyo.oslc4j.core.model.ResourceShapeFactory;

import com.ibm.oslc.adaptor.iotp.resources.Oslc_iotDomainConstants;
import com.ibm.oslc.adaptor.iotp.resources.Oslc_iotDomainConstants;
import com.ibm.oslc.adaptor.iotp.resources.Person;
import com.ibm.oslc.adaptor.iotp.resources.Person;
import com.ibm.oslc.adaptor.iotp.resources.DeviceInfo;
import com.ibm.oslc.adaptor.iotp.resources.DeviceTypeMapping;
import com.ibm.oslc.adaptor.iotp.resources.Discussion;
import com.ibm.oslc.adaptor.iotp.resources.LogicalInterface;
import com.ibm.oslc.adaptor.iotp.resources.MetaData;
import com.ibm.oslc.adaptor.iotp.resources.PhysicalInterface;

// Start of user code imports
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonPrimitive;
import org.eclipse.lyo.oslc4j.core.model.ServiceProvider;
import com.ibm.oslc.adaptor.iotp.servlet.ServiceProviderCatalogSingleton;
import com.ibm.oslc.adaptor.iotp.IotpServiceProviderInfo;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
// End of user code

// Start of user code preClassCode
// End of user code

// Start of user code classAnnotations
// End of user code
@OslcNamespace(Oslc_iotDomainConstants.DEVICETYPE_NAMESPACE)
@OslcName(Oslc_iotDomainConstants.DEVICETYPE_LOCALNAME)
@OslcResourceShape(title = "DeviceType Resource Shape", describes = Oslc_iotDomainConstants.DEVICETYPE_TYPE)
public class DeviceType
    extends Resource
    implements IDeviceType
{
    // Start of user code attributeAnnotation:deviceTypeMappings
    // End of user code
    private HashSet<Link> deviceTypeMappings = new HashSet<Link>();
    // Start of user code attributeAnnotation:physicalInterface
    // End of user code
    private Link physicalInterface = new Link();
    // Start of user code attributeAnnotation:logicalInterfaces
    // End of user code
    private HashSet<Link> logicalInterfaces = new HashSet<Link>();
    // Start of user code attributeAnnotation:deviceInfo
    // End of user code
    private DeviceInfo deviceInfo = new DeviceInfo();
    // Start of user code attributeAnnotation:metaData
    // End of user code
    private MetaData metaData = new MetaData();
    // Start of user code attributeAnnotation:classId
    // End of user code
    private String classId;
    
    // Start of user code classAttributes
    // End of user code
    // Start of user code classMethods
	private static DateFormat createDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
	private static DateFormat updateDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    public DeviceType(final HttpServletRequest httpServletRequest, final IotpServiceProviderInfo info, final String id, JsonElement deviceTypeE, JsonElement physicalInterfaceE, JsonElement logicalInterfacesE) throws URISyntaxException {
		super(id, deviceTypeE.getAsJsonObject());
		// Rules: Don't set anything where there is no value.
		// E.g. if there is no representation, don't set the value.

		// Set some inherited oslc_am:Resource properties that need to be set by the subclass
		setTitle(id);
		// IoT Platform resources need to be marked with rdf:types that the CLM apps can link to
		// All cross-server links are fixed and hard-coded, so we have to do this to create any links
		// This is also influenced by where the links can be stored - either directly or as backlinks
		//getTypes().add(new URI("http://open-services.net/ns/cm#ChangeRequest"));		
		//getTypes().add(new URI("http://open-services.net/ns/rm#Requirement"));		
		getTypes().add(new URI("http://aras.com/ns/itemType#ProductType"));		


		// Note that there must be a service provider since we are creating an instance of an resource
		// Therefore there will be no need to refresh the catalog
		ServiceProvider serviceProvider = ServiceProviderCatalogSingleton.getIotpServiceProvider(httpServletRequest, info.iotId);
		HashSet<URI> serviceProviders = new HashSet<URI>();
		serviceProviders.add(serviceProvider.getAbout());
		setServiceProvider(serviceProviders);
		setAbout(constructURI(info.iotId, id));
		try {
			setInstanceShape(createResourceShape().getAbout());
		} catch (OslcCoreApplicationException e) {
		}

		JsonObject deviceTypeO = deviceTypeE.getAsJsonObject();
		JsonElement element = deviceTypeO.get("description");
		if (element != null) this.setDescription(element.getAsString());
		element = deviceTypeO.get("classId");
		if (element != null) this.setClassId(element.getAsString());
		
		try {
			element = deviceTypeO.get("createdDateTime");
			if (element != null) this.setCreated(createDateFormat.parse(element.getAsString()));
			element = deviceTypeO.get("updatedDateTime");
			if (element != null) this.setModified(updateDateFormat.parse(element.getAsString()));
		} catch (ParseException exc) {
			// the updated format is the same as the created format when the device type is first deployed
			try {
				if (this.getModified() == null) this.setModified(createDateFormat.parse(element.getAsString()));
			} catch (ParseException e) {				
			}
		}
		
		if (physicalInterfaceE != null) {
			String physicalInterfaceId = physicalInterfaceE.getAsJsonObject().get("id").getAsString();
			Link link = PhysicalInterface.constructLink(info.iotId, physicalInterfaceId);
			link.setLabel(physicalInterfaceId);
			this.setPhysicalInterface(link);			
		}
		
		if (logicalInterfacesE != null) {
			HashSet<Link> links = new HashSet<Link>();
			for (JsonElement li: logicalInterfacesE.getAsJsonArray()) {
				String logicalInterfaceId = li.getAsJsonObject().get("id").getAsString();
				Link link = LogicalInterface.constructLink(info.iotId, logicalInterfaceId);
				link.setLabel(logicalInterfaceId);
				links.add(link);
			}
			this.setLogicalInterfaces(links);			
		}

		if (deviceTypeO.has("deviceInfo")) {
            JsonObject devInfo = deviceTypeO.get("deviceInfo").getAsJsonObject();
            if (element != null) {
                element = devInfo.get("serialNumber");
                if (element != null) deviceInfo.setSerialNumber(element.getAsString());
                element = devInfo.get("manufacturer");
                if (element != null) deviceInfo.setManufacturer(element.getAsString());
                element = devInfo.get("model");
                if (element != null) deviceInfo.setModel(element.getAsString());
                element = devInfo.get("deviceClass");
                if (element != null) deviceInfo.setDeviceClass(element.getAsString());
                element = devInfo.get("description");
                if (element != null) deviceInfo.setDescription(element.getAsString());
                element = devInfo.get("fwVersion");
                if (element != null) deviceInfo.setFwVersion(element.getAsString());
                element = devInfo.get("hwVersion");
                if (element != null) deviceInfo.setHwVersion(element.getAsString());
                element = devInfo.get("descriptiveLocation");
                if (element != null) deviceInfo.setDescriptiveLocation(element.getAsString());
            }
        }

		
		element = deviceTypeO.get("metadata");
		if (element != null) {
			for (Map.Entry<String, JsonElement> entry : element.getAsJsonObject().entrySet()) {
				MetaProperty prop = new MetaProperty();
				prop.setName(entry.getKey());
				prop.setValue(entry.getValue().getAsString());
				metaData.addMetaProperties(prop);
			}
		}
    }
    
    public JsonElement toJson() {
		JsonObject json = super.toJson().getAsJsonObject();
		
		json.addProperty("description", getDescription());
		json.addProperty("id", getIdentifier());
		json.addProperty("classId", getClassId());

		// Logical and physical interface refs are fixed query URLs and should not be included in the JSON
		
		if (deviceInfo != null) {
			JsonObject deviceInfoJson = new JsonObject();
			if (deviceInfo.getSerialNumber() != null) deviceInfoJson.addProperty("serialNumber", deviceInfo.getSerialNumber());
			if (deviceInfo.getManufacturer() != null) deviceInfoJson.addProperty("manufacturer", deviceInfo.getManufacturer());
			if (deviceInfo.getModel() != null) deviceInfoJson.addProperty("model", deviceInfo.getModel());
			if (deviceInfo.getDeviceClass() != null) deviceInfoJson.addProperty("deviceClass", deviceInfo.getDeviceClass());
			if (deviceInfo.getDescription() != null) deviceInfoJson.addProperty("description", deviceInfo.getDescription());
			if (deviceInfo.getFwVersion() != null) deviceInfoJson.addProperty("fwVersion", deviceInfo.getFwVersion());
			if (deviceInfo.getHwVersion() != null) deviceInfoJson.addProperty("hwVersion", deviceInfo.getHwVersion());
			if (deviceInfo.getDescriptiveLocation() != null) deviceInfoJson.addProperty("descriptiveLocation", deviceInfo.getDescriptiveLocation());
			json.add("deviceInfo", deviceInfoJson);
		}
		
		if (metaData != null && metaData.getMetaProperties().size() > 0)  {
			JsonObject metaDataJson = new JsonObject();
			for (MetaProperty prop : metaData.getMetaProperties()) {
				metaDataJson.addProperty(prop.getName(), prop.getValue());
			}
			json.add("metadata", metaDataJson);
		}
		return json;
    }
    // End of user code
    public DeviceType()
           throws URISyntaxException
    {
        super();
    
        // Start of user code constructor1
        // End of user code
    }
    
    public DeviceType(final URI about)
           throws URISyntaxException
    {
        super(about);
    
        // Start of user code constructor2
        // End of user code
    }
    
    /**
    * @deprecated Use the methods in class {@link com.ibm.oslc.adaptor.iotp.CE4IoTConnectorResourcesFactory} instead.
    */
    @Deprecated
    public DeviceType(final String iotId, final String deviceTypeId)
           throws URISyntaxException
    {
        this (constructURI(iotId, deviceTypeId));
        // Start of user code constructor3
        // End of user code
    }
    
    /**
    * @deprecated Use the methods in class {@link com.ibm.oslc.adaptor.iotp.CE4IoTConnectorResourcesFactory} instead.
    */
    @Deprecated
    public static URI constructURI(final String iotId, final String deviceTypeId)
    {
        String basePath = OSLC4JUtils.getServletURI();
        Map<String, Object> pathParameters = new HashMap<String, Object>();
        pathParameters.put("iotId", iotId);
        pathParameters.put("deviceTypeId", deviceTypeId);
        String instanceURI = "iotp/{iotId}/resources/deviceTypes/{deviceTypeId}";
    
        final UriBuilder builder = UriBuilder.fromUri(basePath);
        return builder.path(instanceURI).buildFromMap(pathParameters);
    }
    
    /**
    * @deprecated Use the methods in class {@link com.ibm.oslc.adaptor.iotp.CE4IoTConnectorResourcesFactory} instead.
    */
    @Deprecated
    public static Link constructLink(final String iotId, final String deviceTypeId , final String label)
    {
        return new Link(constructURI(iotId, deviceTypeId), label);
    }
    
    /**
    * @deprecated Use the methods in class {@link com.ibm.oslc.adaptor.iotp.CE4IoTConnectorResourcesFactory} instead.
    */
    @Deprecated
    public static Link constructLink(final String iotId, final String deviceTypeId)
    {
        return new Link(constructURI(iotId, deviceTypeId));
    }
    
    public static ResourceShape createResourceShape() throws OslcCoreApplicationException, URISyntaxException {
        return ResourceShapeFactory.createResourceShape(OSLC4JUtils.getServletURI(),
        OslcConstants.PATH_RESOURCE_SHAPES,
        Oslc_iotDomainConstants.DEVICETYPE_PATH,
        DeviceType.class);
    }
    
    
    public String toString()
    {
        return toString(false);
    }
    
    public String toString(boolean asLocalResource)
    {
        String result = "";
        // Start of user code toString_init
        // End of user code
    
        if (asLocalResource) {
            result = result + "{a Local DeviceType Resource} - update DeviceType.toString() to present resource as desired.";
            // Start of user code toString_bodyForLocalResource
            // End of user code
        }
        else {
            result = getAbout().toString();
        }
    
        // Start of user code toString_finalize
        result = getTitle();
        // End of user code
    
        return result;
    }
    
    public String toHtml()
    {
        return toHtml(false);
    }
    
    public String toHtml(boolean asLocalResource)
    {
        String result = "";
        // Start of user code toHtml_init
        // End of user code
    
        if (asLocalResource) {
            result = toString(true);
            // Start of user code toHtml_bodyForLocalResource
            // End of user code
        }
        else {
            result = "<a href=\"" + getAbout() + "\" class=\"oslc-resource-link\">" + toString() + "</a>";
        }
    
        // Start of user code toHtml_finalize
        // End of user code
    
        return result;
    }
    
    public void addDeviceTypeMappings(final Link deviceTypeMappings)
    {
        this.deviceTypeMappings.add(deviceTypeMappings);
    }
    
    public void addLogicalInterfaces(final Link logicalInterfaces)
    {
        this.logicalInterfaces.add(logicalInterfaces);
    }
    
    
    // Start of user code getterAnnotation:deviceTypeMappings
    // End of user code
    @OslcName("deviceTypeMappings")
    @OslcPropertyDefinition(Oslc_iotDomainConstants.IOT_PLATFORM_NAMSPACE + "deviceTypeMappings")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcRange({Oslc_iotDomainConstants.DEVICETYPEMAPPING_TYPE})
    @OslcReadOnly(false)
    @OslcTitle("deviceTypeMappings")
    public HashSet<Link> getDeviceTypeMappings()
    {
        // Start of user code getterInit:deviceTypeMappings
        // End of user code
        return deviceTypeMappings;
    }
    
    // Start of user code getterAnnotation:physicalInterface
    // End of user code
    @OslcName("physicalInterface")
    @OslcPropertyDefinition(Oslc_iotDomainConstants.IOT_PLATFORM_NAMSPACE + "physicalInterface")
    @OslcOccurs(Occurs.ZeroOrOne)
    @OslcValueType(ValueType.Resource)
    @OslcRange({Oslc_iotDomainConstants.PHYSICALINTERFACE_TYPE})
    @OslcReadOnly(false)
    @OslcTitle("physicalInterface")
    public Link getPhysicalInterface()
    {
        // Start of user code getterInit:physicalInterface
        // End of user code
        return physicalInterface;
    }
    
    // Start of user code getterAnnotation:logicalInterfaces
    // End of user code
    @OslcName("logicalInterfaces")
    @OslcPropertyDefinition(Oslc_iotDomainConstants.IOT_PLATFORM_NAMSPACE + "logicalInterfaces")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcRange({Oslc_iotDomainConstants.LOGICALINTERFACE_TYPE})
    @OslcReadOnly(false)
    @OslcTitle("applicationInterfaces")
    public HashSet<Link> getLogicalInterfaces()
    {
        // Start of user code getterInit:logicalInterfaces
        // End of user code
        return logicalInterfaces;
    }
    
    // Start of user code getterAnnotation:deviceInfo
    // End of user code
    @OslcName("deviceInfo")
    @OslcPropertyDefinition(Oslc_iotDomainConstants.IOT_PLATFORM_NAMSPACE + "deviceInfo")
    @OslcOccurs(Occurs.ZeroOrOne)
    @OslcValueType(ValueType.LocalResource)
    @OslcRange({Oslc_iotDomainConstants.DEVICEINFO_TYPE})
    @OslcReadOnly(false)
    @OslcTitle("deviceInfo")
    public DeviceInfo getDeviceInfo()
    {
        // Start of user code getterInit:deviceInfo
        // End of user code
        return deviceInfo;
    }
    
    // Start of user code getterAnnotation:metaData
    // End of user code
    @OslcName("metaData")
    @OslcPropertyDefinition(Oslc_iotDomainConstants.IOT_PLATFORM_NAMSPACE + "metaData")
    @OslcOccurs(Occurs.ZeroOrOne)
    @OslcValueType(ValueType.LocalResource)
    @OslcRange({Oslc_iotDomainConstants.METADATA_TYPE})
    @OslcReadOnly(false)
    @OslcTitle("metaData")
    public MetaData getMetaData()
    {
        // Start of user code getterInit:metaData
        // End of user code
        return metaData;
    }
    
    // Start of user code getterAnnotation:classId
    // End of user code
    @OslcName("classId")
    @OslcPropertyDefinition(Oslc_iotDomainConstants.IOT_PLATFORM_NAMSPACE + "classId")
    @OslcOccurs(Occurs.ZeroOrOne)
    @OslcValueType(ValueType.String)
    @OslcReadOnly(false)
    @OslcTitle("classId")
    public String getClassId()
    {
        // Start of user code getterInit:classId
        // End of user code
        return classId;
    }
    
    
    // Start of user code setterAnnotation:deviceTypeMappings
    // End of user code
    public void setDeviceTypeMappings(final HashSet<Link> deviceTypeMappings )
    {
        // Start of user code setterInit:deviceTypeMappings
        // End of user code
        this.deviceTypeMappings.clear();
        if (deviceTypeMappings != null)
        {
            this.deviceTypeMappings.addAll(deviceTypeMappings);
        }
    
        // Start of user code setterFinalize:deviceTypeMappings
        // End of user code
    }
    
    // Start of user code setterAnnotation:physicalInterface
    // End of user code
    public void setPhysicalInterface(final Link physicalInterface )
    {
        // Start of user code setterInit:physicalInterface
        // End of user code
        this.physicalInterface = physicalInterface;
    
        // Start of user code setterFinalize:physicalInterface
        // End of user code
    }
    
    // Start of user code setterAnnotation:logicalInterfaces
    // End of user code
    public void setLogicalInterfaces(final HashSet<Link> logicalInterfaces )
    {
        // Start of user code setterInit:logicalInterfaces
        // End of user code
        this.logicalInterfaces.clear();
        if (logicalInterfaces != null)
        {
            this.logicalInterfaces.addAll(logicalInterfaces);
        }
    
        // Start of user code setterFinalize:logicalInterfaces
        // End of user code
    }
    
    // Start of user code setterAnnotation:deviceInfo
    // End of user code
    public void setDeviceInfo(final DeviceInfo deviceInfo )
    {
        // Start of user code setterInit:deviceInfo
        // End of user code
        this.deviceInfo = deviceInfo;
    
        // Start of user code setterFinalize:deviceInfo
        // End of user code
    }
    
    // Start of user code setterAnnotation:metaData
    // End of user code
    public void setMetaData(final MetaData metaData )
    {
        // Start of user code setterInit:metaData
        // End of user code
        this.metaData = metaData;
    
        // Start of user code setterFinalize:metaData
        // End of user code
    }
    
    // Start of user code setterAnnotation:classId
    // End of user code
    public void setClassId(final String classId )
    {
        // Start of user code setterInit:classId
        // End of user code
        this.classId = classId;
    
        // Start of user code setterFinalize:classId
        // End of user code
    }
    
    
    static public String deviceTypeMappingsToHtmlForCreation (final HttpServletRequest httpServletRequest)
    {
        String s = "";
    
        // Start of user code "Init:deviceTypeMappingsToHtmlForCreation(...)"
        // End of user code
    
        s = s + "<label for=\"deviceTypeMappings\">deviceTypeMappings: </LABEL>";
    
        // Start of user code "Mid:deviceTypeMappingsToHtmlForCreation(...)"
        // End of user code
    
        // Start of user code "Finalize:deviceTypeMappingsToHtmlForCreation(...)"
        // End of user code
    
        return s;
    }
    
    static public String physicalInterfaceToHtmlForCreation (final HttpServletRequest httpServletRequest)
    {
        String s = "";
    
        // Start of user code "Init:physicalInterfaceToHtmlForCreation(...)"
        // End of user code
    
        s = s + "<label for=\"physicalInterface\">physicalInterface: </LABEL>";
    
        // Start of user code "Mid:physicalInterfaceToHtmlForCreation(...)"
        // End of user code
    
        // Start of user code "Finalize:physicalInterfaceToHtmlForCreation(...)"
        // End of user code
    
        return s;
    }
    
    static public String logicalInterfacesToHtmlForCreation (final HttpServletRequest httpServletRequest)
    {
        String s = "";
    
        // Start of user code "Init:logicalInterfacesToHtmlForCreation(...)"
        // End of user code
    
        s = s + "<label for=\"logicalInterfaces\">logicalInterfaces: </LABEL>";
    
        // Start of user code "Mid:logicalInterfacesToHtmlForCreation(...)"
        // End of user code
    
        // Start of user code "Finalize:logicalInterfacesToHtmlForCreation(...)"
        // End of user code
    
        return s;
    }
    
    static public String deviceInfoToHtmlForCreation (final HttpServletRequest httpServletRequest)
    {
        String s = "";
    
        // Start of user code "Init:deviceInfoToHtmlForCreation(...)"
        // End of user code
    
        s = s + "<label for=\"deviceInfo\">deviceInfo: </LABEL>";
    
        // Start of user code "Mid:deviceInfoToHtmlForCreation(...)"
        // End of user code
    
        // Start of user code "Finalize:deviceInfoToHtmlForCreation(...)"
        // End of user code
    
        return s;
    }
    
    static public String metaDataToHtmlForCreation (final HttpServletRequest httpServletRequest)
    {
        String s = "";
    
        // Start of user code "Init:metaDataToHtmlForCreation(...)"
        // End of user code
    
        s = s + "<label for=\"metaData\">metaData: </LABEL>";
    
        // Start of user code "Mid:metaDataToHtmlForCreation(...)"
        // End of user code
    
        // Start of user code "Finalize:metaDataToHtmlForCreation(...)"
        // End of user code
    
        return s;
    }
    
    static public String classIdToHtmlForCreation (final HttpServletRequest httpServletRequest)
    {
        String s = "";
    
        // Start of user code "Init:classIdToHtmlForCreation(...)"
        // End of user code
    
        s = s + "<label for=\"classId\">classId: </LABEL>";
    
        // Start of user code "Mid:classIdToHtmlForCreation(...)"
        // End of user code
    
        s= s + "<input name=\"classId\" type=\"text\" style=\"width: 400px\" id=\"classId\" >";
        // Start of user code "Finalize:classIdToHtmlForCreation(...)"
        // End of user code
    
        return s;
    }
    
    
    public String deviceTypeMappingsToHtml()
    {
        String s = "";
    
        // Start of user code deviceTypeMappingstoHtml_mid
        // End of user code
    
        try {
            s = s + "<ul>";
            for(Link next : deviceTypeMappings) {
                s = s + "<li>";
                s = s + (new DeviceTypeMapping (next.getValue())).toHtml(false);
                s = s + "</li>";
            }
            s = s + "</ul>";
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        // Start of user code deviceTypeMappingstoHtml_finalize
        // End of user code
    
        return s;
    }
    
    public String physicalInterfaceToHtml()
    {
        String s = "";
    
        // Start of user code physicalInterfacetoHtml_mid
        // End of user code
    
        try {
            if ((physicalInterface == null) || (physicalInterface.getValue() == null)) {
                s = s + "<em>null</em>";
            }
            else {
                s = s + (new PhysicalInterface (physicalInterface.getValue())).toHtml(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        // Start of user code physicalInterfacetoHtml_finalize
        // End of user code
    
        return s;
    }
    
    public String logicalInterfacesToHtml()
    {
        String s = "";
    
        // Start of user code logicalInterfacestoHtml_mid
        // End of user code
    
        try {
            s = s + "<ul>";
            for(Link next : logicalInterfaces) {
                s = s + "<li>";
                s = s + (new LogicalInterface (next.getValue())).toHtml(false);
                s = s + "</li>";
            }
            s = s + "</ul>";
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        // Start of user code logicalInterfacestoHtml_finalize
        // End of user code
    
        return s;
    }
    
    public String deviceInfoToHtml()
    {
        String s = "";
    
        // Start of user code deviceInfotoHtml_mid
        // End of user code
    
        try {
            if (deviceInfo == null) {
                s = s + "<em>null</em>";
            }
            else {
                s = s + deviceInfo.toHtml(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        // Start of user code deviceInfotoHtml_finalize
        // End of user code
    
        return s;
    }
    
    public String metaDataToHtml()
    {
        String s = "";
    
        // Start of user code metaDatatoHtml_mid
        // End of user code
    
        try {
            if (metaData == null) {
                s = s + "<em>null</em>";
            }
            else {
                s = s + metaData.toHtml(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        // Start of user code metaDatatoHtml_finalize
        // End of user code
    
        return s;
    }
    
    public String classIdToHtml()
    {
        String s = "";
    
        // Start of user code classIdtoHtml_mid
        // End of user code
    
        try {
            if (classId == null) {
                s = s + "<em>null</em>";
            }
            else {
                s = s + classId.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        // Start of user code classIdtoHtml_finalize
        // End of user code
    
        return s;
    }
    
    
}
