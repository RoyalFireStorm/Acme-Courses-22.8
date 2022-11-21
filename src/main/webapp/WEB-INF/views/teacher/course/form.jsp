<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${command == 'show'}">
	<acme:input-textbox code="teacher.course.label.caption" path="caption"/>
	<acme:input-textbox code="teacher.course.label.ticker" path="ticker"/>
	<acme:input-textbox code="teacher.course.label.abstractMessage" path="abstractMessage"/>
	<acme:input-url code="teacher.course.label.link" path="link"/>
	
	<acme:input-checkbox code="teacher.course.label.published" path="isPublished"/>
	
	<acme:submit test="${command == 'create'}" code="teacher.course.button.create-new" action="/teacher/course/create"/>
	<acme:button test="${command == 'show' && isPublished eq false}" code="teacher.course.button.update" action="/teacher/course/update?id=${id}"/>
	<acme:submit test="${command == 'update' && isPublished eq false}" code="teacher.course.button.update" action="/teacher/course/update"/>
	<acme:submit test="${command == 'show' && isPublished eq false}" code="teacher.course.button.delete" action="/teacher/course/delete?id=${id}"/>
	
	<acme:button test="${command == 'show'}" code="teacher.course.label.tutorials" action="/teacher/tutorial-course/list?id=${id}"/>
</acme:form>