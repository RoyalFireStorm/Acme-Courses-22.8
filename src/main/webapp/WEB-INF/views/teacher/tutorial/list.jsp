<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="teacher.tutorial.label.title" path="title" width="20%"/>
	<acme:list-column code="teacher.tutorial.label.ticker" path="ticker" width="20%"/>
	<acme:list-column code="teacher.tutorial.label.abstractMessage" path="abstractMessage" width="20%"/>
	<acme:list-column code="teacher.tutorial.label.cost" path="cost" width="20%"/>
	<acme:list-column code="teacher.tutorial.label.link" path="link" width="20%"/>
	<acme:list-column code="teacher.tutorial.label.type" path="type" width="20%"/>
</acme:list>
<jstl:if test="${command == 'list-theory'}">
	<acme:button code="teacher.tutorial.button.create-theory" action="/teacher/tutorial/create-theory"/>
</jstl:if>

<jstl:if test="${command == 'list-lab'}">
	<acme:button code="teacher.tutorial.button.create-lab" action="/teacher/tutorial/create-lab"/>
</jstl:if>