<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

</head>
<body>
<c:forEach items="${products}" var="product">
    <div>
        <p>${product.name}</p>
        <p>${product.description}</p>
    </div>
</c:forEach>
</body>
</html>