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

<p>���ϴ� �������� �����ϼ���.</p>
<table id="place"></table>

<script>
var x,xmlhttp,xmlDoc
xmlhttp = new XMLHttpRequest();
xmlhttp.open("GET", "destination.xml", false);
xmlhttp.send();
xmlDoc = xmlhttp.responseXML; 
x = xmlDoc.getElementsByTagName("PLACE");
table="<tr><th>���</th><th>ī�װ�</th></tr>";
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
  "���: " +
  x[i].getElementsByTagName("NAME")[0].childNodes[0].nodeValue +
  "<br>�ּ�: " +
  x[i].getElementsByTagName("ADDRESS")[0].childNodes[0].nodeValue +
  "<br>ī�װ�: " + 
  x[i].getElementsByTagName("CATEGORY")[0].childNodes[0].nodeValue;
  "<br>���ID: " + 
  x[i].getElementsByTagName("ID")[0].childNodes[0].nodeValue;
}
</script>

</body>
</html>

