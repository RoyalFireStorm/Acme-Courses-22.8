<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="any.post.label.moment" path="moment" readonly="true"/>
	<acme:input-textbox code="any.post.label.caption" path="caption" readonly="true"/>
	<acme:input-select code="any.post.label.informational" path="informational" readonly="true">
		<acme:input-option code="any.post.label.informational.true" value="true" selected="${informational}"/>
		<acme:input-option code="any.post.label.informational.false" value="false" selected="${!informational}"/>
	</acme:input-select>
	<acme:input-money code="any.post.label.message" path="message" readonly="true"/>
	<acme:input-url code="any.post.label.link" path="link" readonly="true"/>
</acme:form>