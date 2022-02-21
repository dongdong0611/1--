<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
table,th,td {
  border : 1px solid black;
  border-collapse: collapse;
}
th,td {
  padding: 5px;
}
</style>
<body>

<p>원하는 관광지를 선택하세요.</p>
<table id="place"></table>

<script>
var x,xmlhttp,xmlDoc
xmlhttp = new XMLHttpRequest();
xmlhttp.open("GET", "destination.xml", false);
xmlhttp.send();
xmlDoc = xmlhttp.responseXML; 
x = xmlDoc.getElementsByTagName("PLACE");
table="<tr><th>장소</th><th>카테고리</th></tr>";
for (i = 0; i <x.length; i++) { 
  table += "<tr onclick='displayPlace(" + i + ")'><td>";
  table += x[i].getElementsByTagName("NAME")[0].childNodes[0].nodeValue;
  table += "</td><td>";
  table +=  x[i].getElementsByTagName("CATEGORY")[0].childNodes[0].nodeValue;
  table += "</td></tr>";
}
document.getElementById("place").innerHTML = table;

function displayPlace(i) {
  document.getElementById("show").innerHTML =
  "장소: " +
  x[i].getElementsByTagName("NAME")[0].childNodes[0].nodeValue +
  "<br>주소: " +
  x[i].getElementsByTagName("ADDRESS")[0].childNodes[0].nodeValue +
  "<br>카테고리: " + 
  x[i].getElementsByTagName("CATEGORY")[0].childNodes[0].nodeValue;
  "<br>장소ID: " + 
  x[i].getElementsByTagName("ID")[0].childNodes[0].nodeValue;
}
</script>

</body>
</html>

