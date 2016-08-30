<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>중심좌표 변경 이벤트 등록하기</title>
    
</head>
<body>
	<h4 style="text-align: center"> 학원 오시는 길!!</h4>
<div class="box" id="map" style="width:100%;height:500px;"></div>

<br /><br /><br /><br />
<p><em>지도 중심좌표가 변경되면 지도 정보가 표출됩니다</em></p> 
<p id="result"></p>

<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=d2d53c672f779a1dd3c8a000a24819c8"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new daum.maps.LatLng(37.552644, 126.937720), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 지도가 이동, 확대, 축소로 인해 중심좌표가 변경되면 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다
daum.maps.event.addListener(map, 'center_changed', function() {        
    
    // 지도의  레벨을 얻어옵니다
    var level = map.getLevel();
    
    // 지도의 중심좌표를 얻어옵니다 
    var latlng = map.getCenter(); 
    
    var message = '<p>지도 레벨은 ' + level + ' 이고</p>';
    message += '<p>중심 좌표는 위도 ' + latlng.getLat() + ', 경도 ' + latlng.getLng() + '입니다</p>'; 
    
    var resultDiv = document.getElementById('result');  
    resultDiv.innerHTML = message;
    
});
</script>
</body>
</html>