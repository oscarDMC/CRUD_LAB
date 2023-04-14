<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informacion de la Matricula</title>
    </head>
    <body>
        <h1>Informacion de la Matricula</h1>
        <form action="./MatriculaServlet" method="POST">
            <table>
                <tr>
                    <td>Codigo del Curso</td>
                    <td><input type="text" name="curso" value="${matri.curso}" /></td>
                </tr>
                <tr>
                    <td>Codigo del Estudiante</td>
                    <td><input type="text" name="estudiante" value="${matri.estudiante}" /></td>
                </tr>
                <tr>
                    <td>Nota</td>
                    <td><input type="text" name="matPrecio" value="${matri.matPrecio}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>Codigo del Curso</th>
            <th>Codigo del Estudiante</th>
            <th>MatPrecio</th>
                <c:forEach items="${allMatriculas}" var="matri">
                <tr>
                    <td>${matri.curso}</td>
                    <td>${matri.estudiante}</td>
                    <td>${matri.matPrecio}</td>
                </tr>
            </c:forEach> 
        </table>
    </body>
</html>
