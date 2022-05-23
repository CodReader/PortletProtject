<%@ page import="com.bogdan.lifray.daoapp.api.Horse" %>
<%@ page import="com.bogdan.liferay.horsesapp.portlet.TestActionMethodPortlet" %>
<%@ include file="/init.jsp" %>


<%--<%=session.setAttribute("Horse", Horse)%>--%>
<p>
    <b><%!
    %><liferay-ui:message key="testactionmethod.caption"/></b>
</p>

<portlet:defineObjects/>

<portlet:actionURL name="actionMethod1" var="sampleActionMethodURL">
</portlet:actionURL>



<aui:form action="<%=sampleActionMethodURL%>" method="POST">

    <br/>


    <aui:input type="radio" name="horseType" value= "${Horse}" /> ${Horse}

    <aui:input type="radio" name="horseType" value="horse 2"/> horse2

    <aui:input type="radio" name="horseType" value="horse 3"/> horse3

    <aui:input type="radio" name="horseType" value="horse 4 "/> horse4

    <aui:input type="radio" name="horseType" value="horse 5"/> horse5

    <aui:input type="radio" name="horseType" value="horse 6"/> horse6

    <aui:input type="radio" name="horseType" value="horse 7"/> horse7

    <aui:input type="radio" name="horseType" value="horse 8"/> horse8

    <br/>
    Choose your horse and make a bet
    <br/>

    Bet: <aui:input type="number" name="bet"/>

    <aui:button type="submit" />

</aui:form>

<form>

    <p><b>Bet:</b>
        ${bet}
    </p>
    <p><b>Horse number:</b>
        ${horseType}
       <%-- <%= request.getParameter("horseType")%>--%>
    </p>
</form>