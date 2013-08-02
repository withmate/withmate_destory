
<%@ page import="net.withmate.user.Users" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'users.label', default: 'Users')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-users" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-users" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="email" title="${message(code: 'users.email.label', default: 'Email')}" />
					
						<g:sortableColumn property="name" title="${message(code: 'users.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="passwd" title="${message(code: 'users.passwd.label', default: 'Passwd')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${usersInstanceList}" status="i" var="usersInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${usersInstance.id}">${fieldValue(bean: usersInstance, field: "email")}</g:link></td>
					
						<td>${fieldValue(bean: usersInstance, field: "name")}</td>
					
						<td>${fieldValue(bean: usersInstance, field: "passwd")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${usersInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
