<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="teacher.help-request.label.status" path="status" width="20%"/>
	<acme:list-column code="teacher.help-request.label.ticker" path="ticker" width="20%"/>
	<acme:list-column code="teacher.help-request.label.statement" path="statement" width="20%"/>
	<acme:list-column code="teacher.help-request.label.budget" path="budget" width="20%"/>
	<acme:list-column code="teacher.help-request.label.startDate" path="startDate" width="20%"/>
	<acme:list-column code="teacher.help-request.label.finishDate" path="finishDate" width="20%"/>
	<acme:list-column code="teacher.help-request.label.link" path="link" width="20%"/>
</acme:list>