<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="any.course.label.caption" path="caption" readonly="true"/>
	<acme:input-textbox code="any.course.label.ticker" path="ticker" readonly="true"/>
	<acme:input-textbox code="any.course.label.abstractMessage" path="abstractMessage" readonly="true"/>
	<acme:input-url code="any.course.label.link" path="link" readonly="true"/>
	
	<acme:button code="any.course.label.tutorials" action="/any/tutorial/list-by-course?id=${id}"/>
</acme:form>