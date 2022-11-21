<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list readonly="true">
	<acme:list-column code="any.blink.label.moment" path="moment" width="20%"/>
	<acme:list-column code="any.blink.label.caption" path="caption" width="20%"/>
	<acme:list-column code="any.blink.label.author" path="author" width="20%"/>
	<acme:list-column code="any.blink.label.message" path="message" width="20%"/>
	<acme:list-column code="any.blink.label.email" path="email" width="20%"/>
</acme:list>

<acme:button code="any.blink.button.create" action="/any/blink/create"/>
