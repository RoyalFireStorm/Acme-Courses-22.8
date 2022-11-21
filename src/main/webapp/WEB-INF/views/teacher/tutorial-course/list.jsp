<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="teacher.tutorial.label.duration" path="duration" width="20%"/>
	<acme:list-column code="teacher.tutorial.label.timeUnit" path="timeUnit" width="20%"/>
	<acme:list-column code="teacher.tutorial.label.tutorial" path="tutorial.title" width="20%"/>
</acme:list>
<acme:button code="teacher.tutorial.button.create" action="/teacher/tutorial-course/create?id=${id}"/>

