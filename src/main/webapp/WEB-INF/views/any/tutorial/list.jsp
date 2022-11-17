<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="any.tutorial.label.title" path="title" width="20%"/>
	<acme:list-column code="any.tutorial.label.ticker" path="ticker" width="20%"/>
	<acme:list-column code="any.tutorial.label.abstractMessage" path="abstractMessage" width="20%"/>
	<acme:list-column code="any.tutorial.label.cost" path="cost" width="20%"/>
	<acme:list-column code="any.tutorial.label.link" path="link" width="20%"/>
</acme:list>