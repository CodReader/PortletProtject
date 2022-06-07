<%@ include file="/init.jsp" %>


<p>
    <b><%!
    %><liferay-ui:message key="testactionmethod.caption"/></b>
</p>

<portlet:defineObjects/>

<portlet:actionURL name="actionMethod1" var="sampleActionMethodURL">
</portlet:actionURL>

<aui:form action="<%=sampleActionMethodURL%>" method="POST">

    <br/>


    <c:forEach var="Horse" items="${horses}" varStatus="status">


            <aui:input type="radio" name="horse" value="${Horse}"/>

            <aui:input type="radio" name="horse" value="${Horse}"/>

            <aui:input type="radio" name="horse" value="${Horse}"/>

            <aui:input type="radio" name="horse" value="${Horse}"/>

            <aui:input type="radio" name="horse" value="${Horse}"/>

            <aui:input type="radio" name="horse" value="${Horse}"/>

            <aui:input type="radio" name="horse" value="${Horse}"/>

            <aui:input type="radio" name="horse" value="${Horse}"/>



    </c:forEach>

    <br/>
    Choose your horse and make a bet
    <br/>

    Bet: <aui:input type="number" name="bet"/>

    <aui:button type="submit"/>

</aui:form>

<form>

    <p><b>Bet:</b>
        ${bet}
    </p>
    <p><b>Horse number:</b>
        ${horse}
    </p>
</form>