<!DOCTYPE html>
<%--Start of user code "Copyright"
--%>
<%--
 Copyright (c) 2011, 2012, 2017 IBM Corporation and others.

 All rights reserved. This program and the accompanying materials
 are made available under the terms of the Eclipse Public License v1.0
 and Eclipse Distribution License v. 1.0 which accompanies this distribution.

 The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 and the Eclipse Distribution License is available at
 http://www.eclipse.org/org/documents/edl-v10.php.

 Contributors:

  Sam Padgett     - initial API and implementation
  Michael Fiedler - adapted for OSLC4J
  Jad El-khoury   - initial implementation of code generator (422448)
  Frédéric Loiret - Switch the template to Bootstrap (519699)

 This file is generated by org.eclipse.lyo.oslc4j.codegenerator
--%>
<%--End of user code--%>

<%--Start of user code "body"
--%>
<%--TODO: Replace/adjust this default content as necessary.
All manual changes in this "protected" user code area will NOT be overwritten upon subsequent code generations.
To revert to the default generated content, delete all content in this file, and then re-generate.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@page import="org.eclipse.lyo.oslc4j.core.model.ServiceProvider"%>
<%@page import="java.util.List" %>
<%@page import="com.ibm.oslc.adaptor.iotp.resources.Device"%>
<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.JsonArray"%>
<%@page import="com.google.gson.JsonPrimitive"%>
<%@page import="java.util.Map"%>

<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>

<%
  Device aDevice = (Device) request.getAttribute("aDevice");
  JsonObject deviceData = aDevice.getDeviceData(request);
%>

<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title><%= aDevice.toString(false) %></title>

  <link href="<c:url value="/static/css/bootstrap-4.0.0-beta.min.css"/>" rel="stylesheet">
  <link href="<c:url value="/static/css/adaptor.css"/>" rel="stylesheet">

  <script src="<c:url value="/static/js/jquery-3.2.1.min.js"/>"></script>
  <script src="<c:url value="/static/js/popper-1.11.0.min.js"/>"></script>
  <script src="<c:url value="/static/js/bootstrap-4.0.0-beta.min.js"/>"></script>
</head>

<body>

<!-- Begin page content -->
<div>
        <div>
          <dl class="row">
            <dt class="col-sm-3">description</dt>
            <dd class="col-sm-9"><%= aDevice.descriptionToHtml()%></dd>
<% for (Map.Entry<String, JsonElement> e : deviceData.entrySet()) { %>  
			<dt class="col-sm-3"><%= e.getKey() %> </dt>
			<dt class="col-sm-9"><%= e.getValue().toString() %> <dd>
<% } %>         
            <dt class="col-sm-3">deviceInfo</dt>
            <dd class="col-sm-9"><%= aDevice.deviceInfoToHtml()%></dd>
            <dt class="col-sm-3">metaData</dt>
            <dd class="col-sm-9"><%= aDevice.metaDataToHtml()%></dd>
            <dt class="col-sm-3">created</dt>
            <dd class="col-sm-9"><%= aDevice.createdToHtml()%></dd>
          </dl>
        </div>
      </div>
</body>
</html>
<%--End of user code--%>