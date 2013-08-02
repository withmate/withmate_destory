<%@ page import="net.withmate.user.Users" %>



<div class="fieldcontain ${hasErrors(bean: usersInstance, field: 'email', 'error')} ">
	<label for="email">
		<g:message code="users.email.label" default="Email" />
		
	</label>
	<g:textField name="email" value="${usersInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usersInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="users.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${usersInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usersInstance, field: 'passwd', 'error')} ">
	<label for="passwd">
		<g:message code="users.passwd.label" default="Passwd" />
		
	</label>
	<g:textField name="passwd" value="${usersInstance?.passwd}"/>
</div>

