<%@page contentType="text/html; charset=UTF-8" %>
<html>
<body>
<h2>Hello World!</h2>

HelloController
<a href="hello.do">/hello.do</a><br>

 NewArticleController
<a href="article/newArticle.do">전송방식</a><br>

OrderController
<a href="order/order.do">주문</a><br>

SearchController
<a href="search/internal.do?query=abc&p=10">@RequestParam1</a><br>

SearchController
<a href="search/external.do">@RequestParam2</a><br>

CookieController
<a href="cookie/make.do">/cookie/make.do</a><br>

CookieController
<a href="cookie/view.do">/cookie/view.do</a><br>

HeaderController
<a href="header/check.do">/header/check.do</a><br>

SearchController
<a href="search/main.do">게임검색</a><br>

CreateAccountController
<a href="account/create.do">필수항목검사(유효성)</a><br>


CharacterInfoController

<a href="game/users/characters/12">restful 사용예제</a>

<a href="game/users/character">test</a><br>


LoginController
<a href="login/login.do">유효성 검사 어노테이션 사용</a><br>


QueryLogController
<a href="log/query.do">달력형식</a><br>

ReportSubmissionController
<a href="report/submission.do">파일 업로드</a><br>


EventController 
<a href="event/list.do">인터셉트 예제</a><br>


ArithmeticOperatorController
<a href="math/divide.do">예외처리</a><br>


SimpleConverterController
<a href="test/simpleTest.do">requestBody</a><br>


SimpleConverterController
<a href="test/simpleTest1.do">requestBody1</a><br>


SimpleConverterController
<a href="test/simpleTest2.do">requestBody2</a><br>


CityController
<a href="city/city.do">도시검사</a><br>

ViewResolver
<a href="jsp/hello.do">viewResolver</a><br>



</body>
</html>

