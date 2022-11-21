<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="administrator.post.label.caption" path="caption" />
	<acme:input-select code="administrator.post.label.informational" path="informational" >
		<acme:input-option code="administrator.post.label.informational.true" value="true" selected="${informational}"/>
		<acme:input-option code="administrator.post.label.informational.false" value="false" selected="${!informational}"/>
	</acme:input-select>
	<acme:input-textbox code="administrator.post.label.message" path="message" />
	<acme:input-url code="administrator.post.label.link" path="link" />
	
	<jstl:if test="${command == 'create' }">
		<acme:input-checkbox code="administrator.post.label.confirmation" path="confirmation"/>
		<acme:submit code="administrator.post.form.button.create" action="/administrator/post/create"/>
	</jstl:if>
</acme:form>