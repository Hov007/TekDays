<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="layout" content="main" />
<title>Login</title>
</head>
<body>
<g:if test="${flash.message}">
    <div class="message">${flash.message}</div>
</g:if>
<g:form action="validate">
    <table>
    <tr class="prop">
    <td class="name">
    <label for="username">Full Name</label>
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
                <input type="submit" value="Sign Up"/>
            </td>
        </tr>
    </table>
</g:form>
</body>
</html>