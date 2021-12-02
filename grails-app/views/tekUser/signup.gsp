<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
    <title>Sign up</title>
</head>

<body>
<g:if test="${flash.message}">
    <div class="message">${flash.message}</div>
</g:if>
<g:form action="register" method="POST">
    <table>
        <tr class="prop">
            <td class="name">
                <label for="fullName"><g:message code="tekUser.fullName.label"/></label>
            </td>
            <td class="value">
                <g:textField name="fullName" value="${tekUser?.fullName}" />
            </td>
        </tr>

        <tr class="prop">
            <td class="name">
                <label for="email"><g:message code="tekUser.email.label"/></label>
            </td>
            <td class="value">
                <g:textField name="email" value="${tekUser?.email}" />
            </td>
        </tr>
        <tr class="prop">
            <td class="name">
                <label for="userName"><g:message code="login.userName"/></label>
            </td>
            <td class="value">
                <g:textField name="userName" value="${tekUser?.userName}" />
            </td>
        </tr>
        <tr class="prop">
            <td class="name">
                <label for="password"><g:message code="login.password"/></label>
            </td>
            <td class="value">
                <g:passwordField name="password" value="${tekUser?.password}" />
            </td>
        </tr>
        <tr class="prop">
            <td class="name">
                <label for="password1"><g:message code="login.password1"/></label>
            </td>
            <td class="value">
                <input type="password" id="password1" name="password1" value="">
            </td>
        </tr>
        <tr>
            <td>
            </td>
            <td>
                <g:submitButton name="register" value="Sign up"/>
            </td>
        </tr>
    </table>
</g:form>
</body>
</html>