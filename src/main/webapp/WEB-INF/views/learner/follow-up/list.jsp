<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="learner.follow-up.label.sequenceNumber" path="sequenceNumber" width="20%"/>
	<acme:list-column code="learner.follow-up.label.moment" path="moment" width="20%"/>
	<acme:list-column code="learner.follow-up.label.message" path="message" width="20%"/>
	<acme:list-column code="learner.follow-up.label.link" path="link" width="20%"/>
</acme:list>