<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout title="Add User">
    <t:errorMessage message="${errorMessage}"/>

    <t:form action="addUser">
        <t:textfield name="id" label="ID" required="true"/><br/>
        <t:textfield name="firstName" label="First Name" required="true"/><br/>
        <t:textfield name="lastName" label="Last Name" required="true"/><br/>
        <t:submit/>
    </t:form>
</t:layout>