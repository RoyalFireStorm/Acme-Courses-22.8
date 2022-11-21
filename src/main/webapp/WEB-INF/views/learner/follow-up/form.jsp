<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="learner.follow-up.label.sequenceNumber" path="sequenceNumber" readonly="true"/>
	<acme:input-moment code="learner.follow-up.label.moment" path="moment" readonly="true"/>
	<acme:input-textbox code="learner.follow-up.label.message" path="message" readonly="true"/>
	<acme:input-url code="learner.follow-up.label.link" path="link" readonly="true"/>
</acme:form>