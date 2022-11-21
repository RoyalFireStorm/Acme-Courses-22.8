<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="teacher.help-request.label.status" path="status" readonly="true"/>
	<acme:input-textbox code="teacher.help-request.label.ticker" path="ticker" readonly="true"/>
	<acme:input-textbox code="teacher.help-request.label.statement" path="statement" readonly="true"/>
	<acme:input-money code="teacher.help-request.label.budget" path="budget" readonly="true"/>
	<acme:input-moment code="teacher.help-request.label.startDate" path="startDate" readonly="true"/>
	<acme:input-moment code="teacher.help-request.label.finishDate" path="finishDate" readonly="true"/>
	<acme:input-url code="teacher.help-request.label.link" path="link" readonly="true"/>
	
	<acme:button code="teacher.help-request.label.followUp" action="/teacher/follow-up/list?id=${id}"/>
</acme:form>