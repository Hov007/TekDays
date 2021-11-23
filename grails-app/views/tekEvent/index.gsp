<%@ page import="com.tekdays.TekEvent" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'tekEvent.label', default: 'TekEvent')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>

    <g:javascript>
        $(document).ready(function () {
            $('#dt').DataTable({
                sScrollY: "75%",
                sScrollX: "100%",
                bProcessing: true,
                bServerSide: true,
                sAjaxSource: "${createLink(controller: 'TekEvent', action: 'dataTablesRenderer')}",
                bJQueryUI: false,
                bAutoWidth: false,
                sPaginationType: "full_numbers",
                aLengthMenu: [[10, 25, 50, 100, 200], [10, 25, 50, 100, 200]],
                iDisplayLength: 10,
                bStateSave: true,
                aoColumnDefs: [
                    {
                         render: function (data, type, full, meta) {
                            if (full) {
                                return '<a href="${createLink(controller: 'TekEvent', action: 'show')}/'+ full[5] +'" class="btn">' + data + '</a>';
                            } else {
                                return data;
                            }
                        },
                        aTargets: [0]
                    },
                    {
                         visible: false,
                        aTargets: [5]
                    }
                ]
            });
        });
    </g:javascript>
</head>

<body>
<a href="#list-tekEvent" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                               default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-tekEvent" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table id="dt">
        <thead>
        <tr>
            <th id="lol">Name</th>
            <th>City</th>
            <th>Description</th>
            <th>Venue</th>
            <th>Start Date</th>
            <th></th>
        </tr>
        </thead>
        <tbody></tbody>
        <tfoot>
        <tr>
            <th>Name</th>
            <th>City</th>
            <th>Description</th>
            <th>Venue</th>
            <th>Start Date</th>
            <th></th>
        </tr>
        </tfoot>
    </table>
    <div class="pagination">
        <g:paginate total="${tekEventInstanceCount ?: 0}"/>
    </div>
</div>
</body>
</html>
