<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="any.post.label.moment" path="moment" width="20%"/>
	<acme:list-column code="any.post.label.caption" path="caption" width="20%"/>
	<acme:list-column code="any.post.label.message" path="message" width="20%"/>
	<acme:list-column code="any.post.label.informational" path="informational" width="20%"/>
	<acme:list-column code="any.post.label.link" path="link" width="20%"/>
</acme:list>