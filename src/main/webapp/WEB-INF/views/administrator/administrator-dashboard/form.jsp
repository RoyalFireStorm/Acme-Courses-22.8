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



<acme:message code="administrator.administrator-dashboard.form.label.Title"/>		
	<table class="table table-sm">
		<caption></caption>
			<tr>
				<th id="">
					<acme:message code="administrator.administrator-dashboard.form.label.totalNumberTheoryTutorials"/>		
		
				</th>
				<td style= "text-align:right;">
					<acme:print value="${totalNumberTheoryTutorials}"/>
				</td>
			</tr>
			<tr>
				<th id="">
					<acme:message code="administrator.administrator-dashboard.form.label.totalNumberLabTutorials"/>		
		
				</th>
				<td style= "text-align:right;">
					<acme:print value="${totalNumberLabTutorials}"/>
				</td>	
			</tr>
			<tr>
				<th id="">
					<acme:message code="administrator.administrator-dashboard.form.label.totalNumberOfProposedHelpRequests"/>		
		
				</th>
				<td style= "text-align:right;">
					<acme:print value="${totalNumberOfProposedHelpRequests}"/>
				</td>		
			</tr>
			<tr>	
				<th id="">
					<acme:message code="administrator.administrator-dashboard.form.label.totalNumberOfAcceptedHelpRequests"/>
				</th>
				<td style= "text-align:right;">
					<acme:print value="${totalNumberOfAcceptedHelpRequests}"/>
				</td>		
			</tr>
			<tr>	
				<th id="">
					<acme:message code="administrator.administrator-dashboard.form.label.totalNumberOfDeniedHelpRequests"/>		
				</th>
				<td style= "text-align:right;">
					<acme:print value="${totalNumberOfDeniedHelpRequests}"/> 
				</td>		
			</tr>
	</table>

	<acme:message code="administrator.administrator-dashboard.form.label.TheoryTutorialTitle"/>	
	<table class="table table-sm">	
		<caption></caption>
		
		
	<jstl:if test="${empty averageCostByCurrencyTheoryTutorials}">
	<acme:message code="administrator.administrator-dashboard.form.label.noMetric"/>	
	<br>
	<br>
	</jstl:if>	
		<jstl:forEach items="${averageCostByCurrencyTheoryTutorials}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.averageTheoryTutorial"/>	
			<acme:print value="${entry.key}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	<jstl:if test="${empty deviationCostByCurrencyTheoryTutorials}">
	<acme:message code="administrator.administrator-dashboard.form.label.noMetric"/>	
	<br>
	<br>
	</jstl:if>	
		<jstl:forEach items="${deviationCostByCurrencyTheoryTutorials}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.deviationTheoryTutorial"/>	
			<acme:print value="${entry.key}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	<jstl:if test="${empty minCostByCurrencyTheoryTutorials}">
	<acme:message code="administrator.administrator-dashboard.form.label.noMetric"/>	
	<br>
	<br>
	</jstl:if>	
		<jstl:forEach items="${minCostByCurrencyTheoryTutorials}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.minTheoryTutorial"/>	
			<acme:print value="${entry.key}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	<jstl:if test="${empty maxCostByCurrencyTheoryTutorials}">
	<acme:message code="administrator.administrator-dashboard.form.label.noMetric"/>	
	<br>
	<br>
	</jstl:if>	
		<jstl:forEach items="${maxCostByCurrencyTheoryTutorials}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.maxTheoryTutorial"/>	
			<acme:print value="${entry.key}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	</table>
	
	<acme:message code="administrator.administrator-dashboard.form.label.LabTutorialTitle"/>	
	<table class="table table-sm">	
		<caption></caption>
		
		
	<jstl:if test="${empty averageCostByCurrencyLabTutorials}">
	<acme:message code="administrator.administrator-dashboard.form.label.noMetric"/>	
	<br>
	<br>
	</jstl:if>	
		<jstl:forEach items="${averageCostByCurrencyLabTutorials}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.averageLabTutorial"/>	
			<acme:print value="${entry.key}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	<jstl:if test="${empty deviationCostByCurrencyLabTutorials}">
	<acme:message code="administrator.administrator-dashboard.form.label.noMetric"/>	
	<br>
	<br>
	</jstl:if>	
		<jstl:forEach items="${deviationCostByCurrencyLabTutorials}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.deviationLabTutorial"/>	
			<acme:print value="${entry.key}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	<jstl:if test="${empty minCostByCurrencyLabTutorials}">
	<acme:message code="administrator.administrator-dashboard.form.label.noMetric"/>	
	<br>
	<br>
	</jstl:if>	
		<jstl:forEach items="${minCostByCurrencyLabTutorials}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.minLabTutorial"/>	
			<acme:print value="${entry.key}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	<jstl:if test="${empty maxCostByCurrencyLabTutorials}">
	<acme:message code="administrator.administrator-dashboard.form.label.noMetric"/>	
	<br>
	<br>
	</jstl:if>	
		<jstl:forEach items="${maxCostByCurrencyLabTutorials}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.maxLabTutorial"/>	
			<acme:print value="${entry.key}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	</table>
	
	<acme:message code="administrator.administrator-dashboard.form.label.HelpRequestTitle"/>	
	<table class="table table-sm">	
		<caption></caption>
		
		
	<jstl:if test="${empty averageBudgetByStatusHelpRequests}">
	<acme:message code="administrator.administrator-dashboard.form.label.noMetric"/>	
	<br>
	<br>
	</jstl:if>	
		<jstl:forEach items="${averageBudgetByStatusHelpRequests}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.averageHelpRequest"/>	
			<acme:print value="${entry.key}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	<jstl:if test="${empty deviationBudgetByStatusHelpRequests}">
	<acme:message code="administrator.administrator-dashboard.form.label.noMetric"/>	
	<br>
	<br>
	</jstl:if>	
		<jstl:forEach items="${deviationBudgetByStatusHelpRequests}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.deviationHelpRequest"/>	
			<acme:print value="${entry.key}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	<jstl:if test="${empty minBudgetByStatusHelpRequests}">
	<acme:message code="administrator.administrator-dashboard.form.label.noMetric"/>	
	<br>
	<br>
	</jstl:if>	
		<jstl:forEach items="${minBudgetByStatusHelpRequests}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.minHelpRequest"/>	
			<acme:print value="${entry.key}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	<jstl:if test="${empty maxBudgetByStatusHelpRequests}">
	<acme:message code="administrator.administrator-dashboard.form.label.noMetric"/>	
	<br>
	<br>
	</jstl:if>	
		<jstl:forEach items="${maxBudgetByStatusHelpRequests}" var="entry"> 	
		<tr>	
			<th id="">	
			<acme:message code="administrator.administrator-dashboard.form.label.maxHelpRequest"/>	
			<acme:print value="${entry.key}"/>
			<acme:message code="administrator.administrator-dashboard.form.label.colon"/>
			</th>
			<td style= "text-align:right;">
				<acme:print value="${entry.value}"/>
				
			</td>		
		</tr>
		</jstl:forEach>
	</table>
	
	