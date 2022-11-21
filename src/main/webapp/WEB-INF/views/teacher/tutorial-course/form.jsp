<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${command == 'show'}">
	<acme:input-select code="teacher.tutorial.label.tutorial" path="tutorial.title">
		<jstl:forEach items="${tutorialList}" var="i">
			<acme:input-option code="${i.getTitle()}" value="${i.getId()}" selected="${i.getId() == item}"/>
		</jstl:forEach>
	</acme:input-select>
	<acme:input-double code="teacher.tutorial.label.duration" path="duration"/>
	<acme:input-select code="teacher.tutorial.label.time-unit" path="timeUnit">
		<acme:input-option code="teacher.tutorial.label.time-unit.MINUTES" value="MINUTES" selected="${timeUnit == 'MINUTES'}"/>
		<acme:input-option code="teacher.tutorial.label.time-unit.HOURS" value="HOURS" selected="${timeUnit == 'HOURS'}"/>
		<acme:input-option code="teacher.tutorial.label.time-unit.DAYS" value="DAYS" selected="${timeUnit == 'DAYS'}"/>
		<acme:input-option code="teacher.tutorial.label.time-unit.WEEKS" value="WEEKS" selected="${timeUnit == 'WEEKS'}"/>
		<acme:input-option code="teacher.tutorial.label.time-unit.MONTHS" value="MONTHS" selected="${timeUnit == 'MONTHS'}"/>
		<acme:input-option code="teacher.tutorial.label.time-unit.YEARS" value="YEARS" selected="${timeUnit == 'YEARS'}"/>
	</acme:input-select>
	
	<acme:submit test="${command == 'create'}" code="teacher.tutorial.button.create" action="/teacher/tutorial-course/create"/>
	<acme:button test="${command == 'show' && isPublished eq false}" code="teacher.tutorial.button.update" action="/teacher/tutorial/update?id=${id}"/>
	<acme:submit test="${command == 'update' && isPublished eq false}" code="teacher.tutorial.button.update" action="/teacher/tutorial/update?id=${course.id}"/>
	<acme:submit test="${command == 'show' && isPublished eq false}" code="teacher.tutorial.button.delete" action="/teacher/tutorial/delete?id=${id}"/>
</acme:form>