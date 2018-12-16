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
	var id = document.getElementsByName('selectFiles');
	var value = new Array();
	for(var i = 0; i < id.length; i++) {
		if(id[i].checked)
			value.push(id[i].value);
	}
	if(value.length > 0)
		/*window.location='deleteFile?deleteFiles='+value.toString();*/
		var deleteFiles='deleteFile?deleteFiles='+value.toString();
	deleteFolder(deleteFiles);
}
function deleteFolder(deleteFiles){
	var id = document.getElementsByName('selectFolders');
	var value = new Array();
	for(var i = 0; i < id.length; i++) {
		if(id[i].checked)
			value.push(id[i].value);
	}
	if(deleteFiles==null){
		if(value.length > 0){
			window.location='deleteFile?deleteFolders='+value.toString();
		}
	}	
	else{
		if(value.length > 0){
			deleteFiles += "&deleteFolders="+value.toString();
			window.location=deleteFiles;
		}
		else {
			window.location=deleteFiles;
		}
	}		
}
function add(a) {
	a.submit();
}
function downloadFile(){
	var id = document.getElementsByName('selectFiles');
	var value = new Array();
	for(var i = 0; i < id.length; i++) {
		if(id[i].checked)
			value.push(id[i].value);
	}
	if(value.length > 1)
		alert("一次只能下载一个文件");
	if(value.length == 1)
	   window.location='download?downloadFiles='+value.toString();
}
function allSelect(){
	var all = document.getElementsByClassName("allselects");
	var allchecked = document.getElementById("allchecked");
	if(allchecked.checked==true){
		for(var i=0;i<all.length;i++){
            all[i].checked=true;
        }
    }else{
        for(var i=0;i<all.length;i++){
        	all[i].checked=false;
        }
    }
}
function fileProperty(file){
	var fileObject = JSON.parse(file);
	var table = document.getElementById("filetable");
	document.getElementById("fileproperty").style.display = "block";
	table.rows[0].cells[1].innerHTML=fileObject.name;
	table.rows[1].cells[1].innerHTML=fileObject.theme;
	table.rows[2].cells[1].innerHTML=fileObject.type;
	table.rows[3].cells[1].innerHTML=fileObject.keyword;
	table.rows[4].cells[1].innerHTML=fileObject.size;
	table.rows[5].cells[1].innerHTML=fileObject.hits;
	table.rows[6].cells[1].innerHTML=fileObject.createTime;
	table.rows[7].cells[1].innerHTML=fileObject.createUser;
	table.rows[8].cells[1].innerHTML=fileObject.updateTime;
	table.rows[9].cells[1].innerHTML=fileObject.updateUser;
	table.rows[10].cells[1].innerHTML=fileObject.superiorFolder;
}
function folderProperty(folder){
	var folderObject = JSON.parse(folder);
	var table = document.getElementById("foldertable");
	document.getElementById("folderproperty").style.display = "block";
	table.rows[0].cells[1].innerHTML=folderObject.name;
	table.rows[1].cells[1].innerHTML=folderObject.keyword;
	table.rows[2].cells[1].innerHTML=folderObject.updateTime;
	table.rows[3].cells[1].innerHTML=folderObject.updateUser;
	table.rows[4].cells[1].innerHTML=folderObject.superiorFolder;
}