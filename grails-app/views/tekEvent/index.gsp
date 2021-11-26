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
                                return '<a href="${createLink(controller: 'TekEvent', action: 'show')}/'+ full[6] +'"class="btn">' + data + '</a>';
                            } else {
                                return data;
                            }
                        },
                        aTargets: [0]
                    },
                    {
                        render: function(data) {
                          if (data) {
                              let d = new Date(data);
                                month = '' + (d.getMonth() + 1),
                                day = '' + d.getDate(),
                                year = d.getFullYear();
                              if (month.length < 2)
                                    month = '0' + month;
                                if (day.length < 2)
                                    day = '0' + day;

                                return [year, month, day].join('/');
                          } else {
                              return "-";
                          }
                        },
                        aTargets: [4, 5]
                    },
                    {
                         visible: false,
                        aTargets: [6]
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
            <th id="lol"><g:message code="tekDays.Name"/></th>
            <th><g:message code="tekDays.City"/></th>
            <th><g:message code="tekDays.Description"/></th>
            <th><g:message code="tekDays.Venue"/></th>
            <th><g:message code="tekDays.Start"/></th>
            <th><g:message code="tekDays.Last"/></th>
            <th></th>
        </tr>
        </thead>
        <tbody></tbody>
        <tfoot>
        <tr>
            <th><g:message code="tekDays.City"/></th>
            <th><g:message code="tekDays.Description"/></th>
            <th><g:message code="tekDays.Venue"/></th>
            <th><g:message code="tekDays.Start"/></th>
            <th><g:message code="tekDays.Last"/></th>
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
