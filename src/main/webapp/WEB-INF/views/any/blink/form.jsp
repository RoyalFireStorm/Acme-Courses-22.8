<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="any.blink.label.caption" path="caption"/>
	<acme:input-textbox code="any.blink.label.author" path="author"/>
	<acme:input-textarea code="any.blink.label.message" path="message"/>
	<acme:input-email code="any.blink.label.email" path="email"/>
	
	<jstl:if test="${command == 'create' }">
		<acme:input-checkbox code="any.blink.label.confirmation" path="confirmation"/>
		<acme:submit code="any.blink.form.button.create" action="/any/blink/create"/>
	</jstl:if>
</acme:form>