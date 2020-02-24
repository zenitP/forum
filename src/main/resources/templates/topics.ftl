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
            <input type="hidden" name="_csrf" value="${_csrf.token}"/> <!-- только для post-запросов -->
            <button type="submit">Добавить тему</button>
        </form>
    </div>

    <!--3 поработать над этим-->
    <i>Список тем для обсуждения (чувствительный к регистру)</i>
    <form method="get" action="/topics"> <!-- по имени @PostMapping("filter")-->

        <input type="text" name="filter" value="${f}" placeholder="Поиск темы"/> <!-- поле name для @RequestParam, а "model"   /// f?ifExists равносильно в контроллере тому, что там default значение ="" -->
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