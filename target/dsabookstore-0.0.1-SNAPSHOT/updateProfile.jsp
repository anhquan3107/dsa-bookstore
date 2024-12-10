<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Profile</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <div class="card">
        <div class="card-header bg-primary text-white">
            <h4>Edit Profile</h4>
        </div>
        <div class="card-body">
            <form action="SaveProfileServlet" method="post">
                <table class="table table-borderless">
                    <tbody>
                        <tr>
                            <td><label for="fullname" class="form-label">Full Name:</label></td>
                            <td>
                                <input type="text" id="fullname" name="fullname" 
                                       class="form-control" value="${sessionScope.userinfo.fullname}" required>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="email" class="form-label">Email:</label></td>
                            <td>
                                <input type="email" id="email" name="email" 
                                       class="form-control" value="${sessionScope.userinfo.email}" required>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="phone" class="form-label">Phone:</label></td>
                            <td>
                                <input type="text" id="phone" name="phone" 
                                       class="form-control" value="${sessionScope.userinfo.phone}" required>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="address" class="form-label">Address:</label></td>
                            <td>
                                <input type="text" id="address" name="address" 
                                       class="form-control" value="${sessionScope.userinfo.address}" required>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <div class="text-end">
                    <button type="submit" class="btn btn-success">Save Changes</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
