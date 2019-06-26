<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body class="">
        <div class="container">
                <div class="alert alert-success" role="alert">
                        <h2>アカウントを登録する</h2>
                </div>
                <div class="row">
                        <form class="col s12" action="sign-up.do" method="post">
                                <div class="form-group">
                                        <br>
                                        <button type="button" class="btn btn-outline-info" ><a href="javascript:city_selector.showDlg();" class="alert-link">図書館登録</a></button>
                                        
                         
                                        <div class="form-group">
                                                <label for="isbn">ほんのisbn</label>
                                                <input id="book-isbn" name="isbn" type="text" class="form-control" 
                                                placeholder="isbnを入力" autofocus required>
                                        </div>
                                        
                                        <div class="form-group">
                          
                                                <label for="user_name">Title</label>
                                                <input class="form-control" id="user_name" name="userName" type="text"
                                                placeholder="ほ" autofocus required>
                                        </div>
                                        <div class="form-group">
                                                <label for="password">Password</label>
                                                <input id="password1" name="password1" type="password"
                                                class="form-control" placeholder="パスワードを入力してください"　required>
                                        </div>
      
                                        <br>
                                        <button type="submit" class="btn btn-warning">本を登録</button>
                                     
                                        <p class="red-text darken-2">${error}</p>
                                        </form>
                                </div>
                        </div>
		</body>
</html>