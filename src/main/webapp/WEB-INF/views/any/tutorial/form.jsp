<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="any.tutorial.label.title" path="title" readonly="true"/>
	<acme:input-textbox code="any.tutorial.label.ticker" path="ticker" readonly="true"/>
	<acme:input-textbox code="any.tutorial.label.abstractMessage" path="abstractMessage" readonly="true"/>
	<acme:input-money code="any.tutorial.label.cost" path="cost" readonly="true"/>
	<acme:input-url code="any.tutorial.label.link" path="link" readonly="true"/>
	<acme:input-select code="any.tutorial.label.type" path="type" readonly="true">
		<acme:input-option code="any.tutorial.label.type.LAB" value="LAB" selected="${type == 'LAB'}"/>
		<acme:input-option code="any.tutorial.label.type.THEORY" value="THEORY" selected="${type == 'THEORY'}"/>
	</acme:input-select>
</acme:form>