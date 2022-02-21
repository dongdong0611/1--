<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>여행 플랜 만들기</title>
<style>
div {border: 1px dotted black; display:inline-block;}
#left {
 width: 75%; 
}
#right {
flex-grow: 1;
}
</style>
</head>
<body>
<h3> 여행 플랜 만들기</h3>
<hr>
<div style=" width:100%; display:flex; ">
	<div id="left">
		<button type="button" onclick="loadDoc('place/0001.txt', myFunction)">관광지A</button><br>
		<button type="button" onclick="loadDoc('place/0002.txt', myFunction)">숙소B </button><br>
		<button type="button" onclick="loadDoc('place/0003.txt', myFunction)">음식점C</button><br>
		<img src="image/sample.jpg">
	</div>
	<div id="right">
		
	</div>
</div>
<script>
function loadDoc(url, cFunction) {
  var xhttp;
  xhttp=new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      cFunction(this);
    }
  };
  xhttp.open("GET", url, true);
  xhttp.send();
}
function myFunction(xhttp) {
  document.getElementById("right").innerHTML =
  xhttp.responseText;
}
</script>
</body>
</html>