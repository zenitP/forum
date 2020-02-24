<#macro login path>
<form action="${path}" method="post">
    <div><label> Имя пользователя: <input type="text" name="username" placeholder="Введите ваше имя..."/> </label></div>
    <div><label> Пароль пользователя: <input type="password" name="password" placeholder="Введите пароль..."/> </label></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/> <!-- только эти формы спринг будет воспринимать (сертификат)-->
    <div><input type="submit" value="Sign in"/></div>
</form>
</#macro>

<#macro logout>
<form action="logout" method="post">
    <input type="submit" value="Выйти"/>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
</form>
</#macro>