window.onload = function() {
	sidenav();
}
function sidenav() {
	var navWrap = document.getElementById("sidenav");
	var nav1s = navWrap.getElementsByClassName("folders");
	var nav2s = navWrap.getElementsByTagName("ul");
	for (var i = 0, len = nav1s.length; i < len; i++) {
		nav1s[i].onclick = (function(i) {
			return function() {
				for (var j = 0; j < len; j++) {
					nav2s[j].style.display = "none";
				}
				nav2s[i].style.display = "block";
			}
		})(i)
	}
}
function newclose(a) {
	a.style.display = "none";
}
function newopen(a) {
	a.style.display = "block";
}
function listFile(folderId) {
	window.location.href="index?folder.id="+folderId;
}
function deleteFile(){
	var id = document.getElementsByName('deleteFiles');
	var value = new Array();
	for(var i = 0; i < id.length; i++) {
		if(id[i].checked)
			value.push(id[i].value);
	}
	window.location='deleteFile?deleteFiles='+value.toString();
}
function add(a) {
	console.log(a);
	a.submit();
}