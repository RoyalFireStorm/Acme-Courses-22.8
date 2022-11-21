<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="teacher.course.label.caption" path="caption" width="20%"/>
	<acme:list-column code="teacher.course.label.ticker" path="ticker" width="20%"/>
	<acme:list-column code="teacher.course.label.abstractMessage" path="abstractMessage" width="20%"/>
	<acme:list-column code="teacher.course.label.link" path="link" width="20%"/>
</acme:list>