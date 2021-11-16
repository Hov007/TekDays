<%--
  Created by IntelliJ IDEA.
  User: hovhannes
  Date: 03.11.21
  Time: 14:50
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
{--<meta name="layout" content="main" />--}
<title>Login</title>
</head>
<body>
<g:if test="${flash.message}">
    <div class="message">${flash.message}</div>
</g:if>
<g:form action="validate">

    <input type="hidden" name="cName" value="${cName}">
    <input type="hidden" name="aName" value="${aName}">
    <table>
    <tr class="prop">
    <td class="name">
    <label for="username">User Name:</label>
    </td>
    <td class="value">
    <input type="text" id="username" name="username" value="">
    </td>
    </tr>
    <tr class="prop">
    <td class="name">
    <label for="password">Password:</label>
    </td>
        <td class="value">
            <input type="password" id="password" name="password" value="">
        </td>
    </tr>
        <tr>
            <td>
            </td>
            <td>
                <input type="submit" value="login"/>
            </td>
        </tr>
    </table>
</g:form>
</body>
</html>