<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div>Добавляем нового пользоваля:</div>
${message?ifExists}
<@l.login "/registration" />

<a href="/login">Авторизоваться -></a>
</@c.page>