<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>


<@c.page>
    <div>
        <@l.logout/>
        <span><a href="/user">Список пользователей</a></span>
    </div>
    <div>
        <form method="post">
            <input type="text" name="name" placeholder="Тема"/>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/> 
            <button type="submit">Добавить тему</button>
        </form>
    </div>

    <i>Список тем для обсуждения (чувствительный к регистру)</i>
    <form method="get" action="/topics"> <!-- по имени @PostMapping("filter")-->

        <input type="text" name="filter" value="${f}" placeholder="Поиск темы"/> 
        <button type="submit">Найти</button>
    </form>

    <#list topics as topic>
        <div>
            <a href="/topics/${topic.id}/messages">${topic.name}</a>
        </div>

    <#else >
        Темы не найдены :)
    </#list>
</@c.page>
