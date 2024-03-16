<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User List</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
            color: #1b6d85;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            color: #1b6d85;
            padding: 8px;
        }

        th {
            background-color: #9b9b9b;
            color: #1b6d85;
        }
    </style>
</head>
<body>

<h2>User List</h2>

<table id="user-table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Password</th>
    </tr>
    </thead>
    <tbody id="user-table-body">
    <!-- This is where the table rows will be dynamically added -->
    </tbody>
</table>

<script>
    fetch('/users') // 使用fetch函數向API端點發送GET請求
        .then(response => response.json()) // 解析API的JSON響應
        .then(data => {
            // 在這裡使用獲取到的資料
            console.log(data); // 在控制台輸出資料，確保資料正確獲取到
            const userTableBody = document.getElementById('user-table-body');
            // 清空原有內容
            userTableBody.innerHTML = '';
            // 遍歷資料，將每個用戶的資訊添加到表格中
            data.forEach(user => {
                const row = document.createElement('tr');
                row.innerHTML = `
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
            `;
                userTableBody.appendChild(row);
            });
        })
        .catch(error => {
            console.error('Error fetching user data:', error);
        });
</script>

</body>
</html>
