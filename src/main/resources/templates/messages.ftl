<#import "parts/common.ftl" as c>

<@c.page>
<div>Вы находитесь в теме: ${topics.name}</div>
<div>
    <form method="post" enctype="multipart/form-data">
        <input type="text" name="text" placeholder="Введите сообщение..."/>
        <input type="text" name="tag" placeholder="Тэг"/>
        <input type="file" name="file">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Добавить сообщение</button>
    </form>
</div>

<i>Список сообщений:</i>
<form method="get" action="/topics/${topics.id}/messages">
    <input type="text" name="filter2" value="${filter3?ifExists}" placeholder="Поиск по тэгу"/>
    <button type="submit">Найти</button>
</form>

<#list messages as message>
    <#if topics.id == message.topic.id>
    <div>
        <span>${message.text}</span>
        <span>${message.tag}</span>
        <strong>${message.authorName}</strong>
        <i>${message.date}</i>
        <div>
            <#if message.filename??>
            <img src="/images/${message.filename}">
            </#if>
        </div>
    </div>
    </#if>
<#else >
    <div>Нет сообщений. Будь первым :)</div>
</#list>

<a href="/topics">Выбрать другую тему</a>
</@c.page>
