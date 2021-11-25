
<%@ page import="com.tekdays.Task" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'task.label', default: 'Task')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>

		<g:javascript>
			$(document).ready(function () {
            $('#dt').DataTable({
                sScrollY: "75%",
                sScrollX: "100%",
                paging: false,
                bProcessing: true,
                bServerSide: true,
                sAjaxSource: "${createLink(controller: 'Task', action: 'dataTablesRenderer')}",
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
                                return '<a href="${createLink(controller: 'TekEvent', action: 'show')}/'+ full[6] +'" class="btn">' + data + '</a>';
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
                        aTargets: [3]
                    },
                    {
                        render: function (data) {
                            if (data === "true") {
                                return "Yes";
                            } else {
                                return "No";
                            }
                        },
                        aTargets: [4]
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
		<a href="#list-task" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-task" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>

			<table class="display compact" id="dt">
				<thead>
				<tr>
					<th>Title</th>
					<th>Notes</th>
					<th>Assigned To</th>
					<th>Due Date</th>
					<th>Completed</th>
					<th>Event</th>
					<th></th>
				</tr>
				</thead>
				<tbody></tbody>
				<tfoot>
				<tr>
					<th>Title</th>
					<th>Notes</th>
					<th>Assigned To</th>
					<th>Due Date</th>
					<th>Completed</th>
					<th>Event</th>
					<th></th>
				</tr>
				</tfoot>
			</table>
%{--			<table>--}%
%{--			<thead>--}%
%{--					<tr>--}%
%{--					--}%
%{--						<g:sortableColumn property="title" title="${message(code: 'task.title.label', default: 'Title')}" />--}%
%{--					--}%
%{--						<g:sortableColumn property="notes" title="${message(code: 'task.notes.label', default: 'Notes')}" />--}%

%{--						<th><g:message code="task.assignedTo.label" default="Assigned To" /></th>--}%
%{--					--}%
%{--						<g:sortableColumn property="dueDate" title="${message(code: 'task.dueDate.label', default: 'Due Date')}" />--}%

%{--						<th><g:message code="task.completed.label" default="Completed" /></th>--}%

%{--						<th><g:message code="task.event.label" default="Event" /></th>--}%

%{--					</tr>--}%
%{--				</thead>--}%
%{--				<tbody>--}%
%{--				<g:each in="${taskInstanceList}" status="i" var="taskInstance">--}%
%{--					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">--}%
%{--					--}%
%{--						<td><g:link action="show" id="${taskInstance.id}">${fieldValue(bean: taskInstance, field: "title")}</g:link></td>--}%
%{--					--}%
%{--						<td>${fieldValue(bean: taskInstance, field: "notes")}</td>--}%
%{--					--}%
%{--						<td>${fieldValue(bean: taskInstance, field: "assignedTo")}</td>--}%
%{--					--}%
%{--						<td><g:formatDate date="${taskInstance.dueDate}" /></td>--}%

%{--					<td><g:formatBoolean boolean="${taskInstance?.completed}"--}%
%{--										 true="Yes" false="No"/></td>--}%

%{--						<td>${fieldValue(bean: taskInstance, field: "event")}</td>--}%
%{--					--}%
%{--					</tr>--}%
%{--				</g:each>--}%
%{--				</tbody>--}%
%{--			</table>--}%
			<div class="pagination">
				<g:paginate total="${taskInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
