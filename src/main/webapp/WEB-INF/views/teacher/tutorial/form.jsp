<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="teacher.tutorial.label.title" path="title" readonly="true"/>
	<acme:input-textbox code="teacher.tutorial.label.ticker" path="ticker" readonly="true"/>
	<acme:input-textbox code="teacher.tutorial.label.abstractMessage" path="abstractMessage" readonly="true"/>
	<acme:input-money code="teacher.tutorial.label.cost" path="cost" readonly="true"/>
	<acme:input-url code="teacher.tutorial.label.link" path="link" readonly="true"/>
	<acme:input-textbox code="teacher.tutorial.label.type" path="type" readonly="true"/>
</acme:form>