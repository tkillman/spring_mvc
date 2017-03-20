<%@page contentType="text/html; charset=UTF-8" %>
<html>
<body>
<h2>Hello World!</h2>

<a href="hello.do">/hello.do</a><br>
<a href="article/newArticle.do">전송방식</a><br>
<a href="order/order.do">주문</a><br>


<a href="search/internal.do?query=abc&p=10">@RequestParam1</a><br>
<a href="search/external.do">@RequestParam2</a><br>
<a href="cookie/make.do">/cookie/make.do</a><br>
<a href="cookie/view.do">/cookie/view.do</a><br>
<a href="header/check.do">/header/check.do</a><br>
<a href="search/main.do">게임검색</a><br>


CreateAccountController
<a href="account/create.do">필수항목검사(유효성)</a><br>


CharacterInfoController

<a href="game/users/tk/characters/12">restful 사용예제</a>

</body>
</html>

