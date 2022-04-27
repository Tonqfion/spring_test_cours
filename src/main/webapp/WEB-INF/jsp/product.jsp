<jsp:useBean id="product" scope="request" type="com.cours.project_spring_test.model.Product"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

</head>
<body>
    <div>
        <p>${product.name}</p>
        <p>${product.description}</p>
    </div>
</body>
</html>