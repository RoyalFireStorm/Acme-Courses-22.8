<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="any.course.label.caption" path="caption" width="20%"/>
	<acme:list-column code="any.course.label.ticker" path="ticker" width="20%"/>
	<acme:list-column code="any.course.label.abstractMessage" path="abstractMessage" width="20%"/>
	<acme:list-column code="any.course.label.link" path="link" width="20%"/>
</acme:list>