<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${command == 'show'}">
	<acme:input-textbox code="teacher.tutorial.label.title" path="title"/>
	<acme:input-textbox code="teacher.tutorial.label.ticker" path="ticker"/>
	<acme:input-textbox code="teacher.tutorial.label.abstractMessage" path="abstractMessage" />
	<acme:input-money code="teacher.tutorial.label.cost" path="cost" />
	<acme:input-url code="teacher.tutorial.label.link" path="link" />
	<acme:input-textbox code="teacher.tutorial.label.type" path="type" readonly="true"/>
	<acme:input-checkbox code="teacher.tutorial.label.published" path="isPublished"/>
	
	<acme:submit test="${command == 'create-theory'}" code="teacher.tutorial.button.create" action="/teacher/tutorial/create-theory"/>
	<acme:submit test="${command == 'create-lab'}" code="teacher.tutorial.button.create" action="/teacher/tutorial/create-lab"/>
	<acme:button test="${command == 'show'}" code="teacher.tutorial.button.update" action="/teacher/tutorial/update?id=${id}"/>
	<acme:submit test="${command == 'update'}" code="teacher.tutorial.button.update" action="/teacher/tutorial/update"/>
	<acme:submit test="${command == 'show'}" code="teacher.tutorial.button.delete" action="/teacher/tutorial/delete?id=${id}"/>
</acme:form>