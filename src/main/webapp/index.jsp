<%@page contentType="text/html; charset=UTF-8" %>
<html>
<body>
<h2>Hello World!</h2>

<a href="hello.do">/hello.do</a><br>
<a href="article/newArticle.do">전송방식</a><br>
<a href="order/order.do">주문</a><br>

SearchController
<a href="search/internal.do?query=abc&p=10">@RequestParam1</a>
<a href="search/external.do">@RequestParam2</a><br>

<a href="cookie/view.do">/cookie/view.do</a><br>
<a href="header/check.do">/header/check.do</a><br>
<a href="search/main.do">게임검색</a><br>

</body>
</html>

