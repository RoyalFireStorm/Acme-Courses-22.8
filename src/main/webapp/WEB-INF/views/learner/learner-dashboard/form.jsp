<%--
- form.jsp
-
- Copyright (C) 2012-2022 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

	<acme:message code="learner.learner-dashboard.form.label.avgTitle"/>	
	<table class="table table-sm">	
		<caption></caption>
		
		
	<jstl:if test="${empty averageBudgetByCurrencyAndStatus}">
	<acme:message code="learner.learner-dashboard.form.label.noMetric"/>	
	<br>
	<br>
	</jstl:if>	
		<jstl:forEach items="${averageBudgetByCurrencyAndStatus}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="learner.learner-dashboard.form.label.average"/>		
			<jstl:set var = "tuple" value = "${entry.key}"/>
			<jstl:set var = "split" value = "${fn:split(tuple, '->')}" />
			<acme:print value="${split[0]}"/>
			<acme:message code="learner.learner-dashboard.form.label.status"/>
			<acme:print value="${split[1]}"/>
			<acme:message code="learner.learner-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	</table>
	
	<acme:message code="learner.learner-dashboard.form.label.deviationTitle"/>		
	<table class="table table-sm">
		<caption></caption>
		
	<jstl:if test="${empty deviationBudgetByCurrencyAndStatus}">
	<acme:message code="learner.learner-dashboard.form.label.noMetric"/>	
	<br>
	<br>
	</jstl:if>
		<jstl:forEach items="${deviationBudgetByCurrencyAndStatus}" var="entry"> 
		<tr>	
			<th id="">
				<acme:message code="learner.learner-dashboard.form.label.deviation"/>		
				<jstl:set var = "tuple" value = "${entry.key}"/>
				<jstl:set var = "split" value = "${fn:split(tuple, '->')}" />
				<acme:print value="${split[0]}"/>
				<acme:message code="learner.learner-dashboard.form.label.status"/>		
				<acme:print value="${split[1]}"/>
				<acme:message code="learner.learner-dashboard.form.label.colon"/>		
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
			</td>		
		</tr>
		</jstl:forEach>
	</table>
	
	
	<acme:message code="learner.learner-dashboard.form.label.minTitle"/>
	<table class="table table-sm">	
		<caption></caption>
	<jstl:if test="${empty minBudgetByCurrencyAndStatus}">
	<acme:message code="learner.learner-dashboard.form.label.noMetric"/>	
	<br>
	<br>
	</jstl:if>
		<jstl:forEach items="${minBudgetByCurrencyAndStatus}" var="entry"> 
			<tr>	
				<th id="">
					<acme:message code="learner.learner-dashboard.form.label.min"/>		
					<jstl:set var = "tuple" value = "${entry.key}"/>
					<jstl:set var = "split" value = "${fn:split(tuple, '->')}" />
					<acme:print value="${split[0]}"/>
					<acme:message code="learner.learner-dashboard.form.label.status"/>		
					<acme:print value="${split[1]}"/>
					<acme:message code="learner.learner-dashboard.form.label.colon"/>		
				</th>
				<td style= "text-align:right;">
					<acme:print value="${entry.value}"/>
				</td>		
			</tr>
		</jstl:forEach>
	</table>		
	<acme:message code="learner.learner-dashboard.form.label.maxTitle"/>		
	<table class="table table-sm">	
		<caption></caption>
	<jstl:if test="${empty maxBudgetByCurrencyAndStatus}">
	<acme:message code="learner.learner-dashboard.form.label.noMetric"/>	
	<br>
	<br>
	</jstl:if>
		<jstl:forEach items="${maxBudgetByCurrencyAndStatus}" var="entry"> 
			<tr>	
				<th id="">
					<acme:message code="learner.learner-dashboard.form.label.max"/>		
					<jstl:set var = "tuple" value = "${entry.key}"/>
					<jstl:set var = "split" value = "${fn:split(tuple, '->')}" />
					<acme:print value="${split[0]}"/>
					<acme:message code="learner.learner-dashboard.form.label.status"/>		
					<acme:print value="${split[1]}"/>
					<acme:message code="learner.learner-dashboard.form.label.colon"/>		
				</th>
				<td style= "text-align:right;">
					<acme:print value="${entry.value}"/>
				</td>		
			</tr>
		</jstl:forEach>
	</table>
	<acme:message code="learner.learner-dashboard.form.label.absoluteTitle"/>		
	<table class="table table-sm">
		<caption></caption>
			<tr>	
				<th id="">
					<acme:message code="learner.learner-dashboard.form.label.totalNumberOfProposedHelpRequests"/>		
		
				</th>
				<td style= "text-align:right;">
					<acme:print value="${totalNumberOfProposedHelpRequests}"/>
				</td>		
			</tr>
			<tr>	
				<th id="">
					<acme:message code="learner.learner-dashboard.form.label.totalNumberOfAcceptedHelpRequests"/>
				</th>
				<td style= "text-align:right;">
					<acme:print value="${totalNumberOfAcceptedHelpRequests}"/>
				</td>		
			</tr>
			<tr>	
				<th id="">
					<acme:message code="learner.learner-dashboard.form.label.totalNumberOfDeniedHelpRequests"/>		
				</th>
				<td style= "text-align:right;">
					<acme:print value="${totalNumberOfDeniedHelpRequests}"/> 
				</td>		
			</tr>
	</table>