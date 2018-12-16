<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Page Title</title>
    <link rel="stylesheet" type="text/css"  href="css/index.css" />
    <script type="text/javascript" src="js/index.js"></script>
</head>
<body>
    <div id="header">
        <div id="headertop">
            <span>知识管理</span>
            <ul>
                <li>&nbsp;&nbsp;列表显示&nbsp;&nbsp;</li>
                <li onclick="newopen(newfolder)">新建文件夹&nbsp;&nbsp;</li>
                <li onclick="newopen(newfile)">新建文件&nbsp;&nbsp;</li>
                <li onclick="newopen(upload)">上传文件&nbsp;&nbsp;</li>
                <li>zip批量文件&nbsp;&nbsp;</li>
                <li onclick="newopen(query)">查询&nbsp;&nbsp;</li>
            </ul>
        </div>
        <div id="headerpath">
            <span class="headerpathspan">当前路径:</span>
            <img src="img/file.png"/>
            <div id="path">
				<span id="currentpath">${currentPath}</span>
            </div>
            <img src="img/file.png"/>
            <span class="headerpathspan">属性</span>
        </div>
    </div>
    <div id="main">
        <div id="mainleft">
            <div id="mainlefttop">
                <img src="img/book.png"/>
                <span>知识管理</span>
            </div>
            <div id="mainleftmain">
                <ul id="sidenav">
                	<s:iterator value="folders" var="var" status="status">
                		<li class="folders"><img src="img/folder.png">&nbsp;<span onclick="listFile(${id})">${name}</span>
                			<ul <s:if test="folder.id==#var.id">style="display:block"</s:if>
                			<s:iterator value="#var.childrenFolder" var="var2" status="status">
                			<s:if test="folder.id==#var2.id">style="display:block"</s:if></s:iterator>>
								<s:iterator value="#var.childrenFolder" var="var2" status="status">
									<li><img src="img/folder.png">&nbsp;<span onclick="listFile(${id})">${name}</span>
										
									</li>
								</s:iterator>
							</ul>
                		</li>
                	</s:iterator>
                </ul>
            </div>
        </div>
        <div id="mainright">
            <table>
                <tr id="tableheader">
                    <th class="check"><input id="allchecked" type="checkbox" onclick="allSelect()"></th>
                    <th class="name">名称</th>
                    <th class="size">大小</th>
                    <th class="hits">点击</th>
                    <th class="updatetime">最后更新</th>
                    <th class="operation">操作</th>
                </tr>
                <s:iterator value="folderChildren" var="folder" status="status">
						<tr>
							<td><input class="allselects" name="selectFolders" type="checkbox" value="${id}"></td>
							<td colspan="3">&nbsp;&nbsp;<img src="img/folder.png"/>&nbsp;&nbsp;${name}</td>
							<td>&nbsp;&nbsp;<s:date name="updateTime" format="yyyy-MM-dd HH:mm" /> &nbsp;&nbsp;${updateUser.name}</td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;<span onclick="folderProperty('<s:property value="#folder"/>')">属性</span> &nbsp;&nbsp;重命名</td>
						</tr>
				</s:iterator>
				<s:if test="queryFiles.size != 0">
					<s:iterator value="queryFiles" var="file" status="status">
						<tr>
							<td><input class="allselects" name="selectFiles" type="checkbox" value="${id}"></td>
							<td>&nbsp;
								<s:if test="#file.type=='doc'||#file.type=='docx'"><img src="img/doc.png"/></s:if>
								<s:elseif test="#file.type=='ppt'"><img src="img/ppt.png"/></s:elseif>
								<s:elseif test="#file.type=='jpg'||#file.type=='JPG'"><img src="img/jpg.png"/></s:elseif>
								<s:elseif test="#file.type=='txt'"><img src="img/txt.png"/></s:elseif>
								<s:else><img src="img/png.png"/></s:else>
								&nbsp;${name}
							</td>
							<td align="right"><fmt:formatNumber value="${(size/1024)}" pattern="#0.0"/>KB</td>
							<td align="center">${hits}</td>
							<td>&nbsp;&nbsp;<s:date name="updateTime" format="yyyy-MM-dd HH:mm" /> &nbsp;&nbsp;${updateUser.name}</td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;<span onclick="fileProperty('<s:property value="#file"/>')">属性</span>&nbsp;&nbsp; 编辑&nbsp;&nbsp; 重命名&nbsp;&nbsp; 查看</td>
						</tr>
					</s:iterator>
				</s:if>
				<s:else>
					<s:iterator value="files" var="file" status="status">
						<tr>
							<td><input class="allselects" name="selectFiles" type="checkbox" value="${id}"></td>
							<td>&nbsp;
								<s:if test="#file.type=='doc'||#file.type=='docx'"><img src="img/doc.png"/></s:if>
								<s:elseif test="#file.type=='ppt'"><img src="img/ppt.png"/></s:elseif>
								<s:elseif test="#file.type=='jpg'||#file.type=='JPG'"><img src="img/jpg.png"/></s:elseif>
								<s:elseif test="#file.type=='txt'"><img src="img/txt.png"/></s:elseif>
								<s:else><img src="img/png.png"/></s:else>
								&nbsp;${name}
							</td>
							<td align="right"><fmt:formatNumber value="${(size/1024)}" pattern="#0.0"/>KB</td>
							<td align="center">${hits}</td>
							<td>&nbsp;&nbsp;<s:date name="updateTime" format="yyyy-MM-dd HH:mm" /> &nbsp;&nbsp;${updateUser.name}</td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;<span onclick="fileProperty('<s:property value="#file"/>')">属性</span>&nbsp;&nbsp; 编辑&nbsp;&nbsp; 重命名&nbsp;&nbsp; 查看</td>
						</tr>
					</s:iterator>
				</s:else>
			</table>
            <div id="mainrightbottom">
                <button>转存</button>
                <button onclick="deleteFile()">删除</button>
                <button onclick="downloadFile()">下载</button>
                <button onclick="newopen(historyo)">历史</button>
            </div>
        </div>
    </div>
    <div id="newfile" class="newwindow">
        <div class="newtop">
            <p class="newtitle">新建文件</p>
            <span onclick="add(addFile)">确定</span>
            <span class="close" onclick="newclose(newfile)">关闭</span>
        </div>
        <div class="newmain">
         	<form id="addFile" action="addFile.action">
            <table>
                <tr>
                    <td>文件主题</td>
                    <td><input name="file.theme" type="text"></td>
                </tr>
                <tr>
                    <td>文件类型</td>
                    <td>
                    	<select name="file.type">
                    		<option value ="doc">doc</option>
                    		<option value ="ppt">ppt</option>
                    		<option value ="JPG">jpg</option>
                    		<option value ="png">png</option>
                    		<option value ="docx">docx</option>
                    		<option value ="txt">txt</option>
                    	</select>
                    </td>
                </tr>
                <tr>
                    <td>关键字</td>
                    <td><input name="file.keyword" class="textarea" type="textarea"></td>
                </tr>
                <tr>
                    <td>所属文件夹</td>
                    <td>
                    	<select name="file.superiorFolder.id">
                    		<s:iterator value="allFolders" var="var" status="status">
                    			<option value = "${id}">${name}</option>
                    		</s:iterator>
                    	</select>
                    </td>
                </tr>
            </table>
            </form>
        </div>
    </div>
    <div id="newfolder" class="newwindow">
        <div class="newtop">
            <p class="newtitle">新建文件夹</p>
            <span onclick="add(addFolder)">保存</span>
            <span class="close" onclick="newclose(newfolder)">关闭</span>
        </div>
        <div class="newmain">
        	<form id="addFolder" action="addFolder.action">
            <table>
                <tr>
                    <td>文件夹名称</td>
                    <td><input name="folder.name" type="text"></td>
                </tr>
                <tr>
                    <td>关键字</td>
                    <td><input name="folder.keyword" class="textarea" type="textarea"></td>
                </tr> 
                <tr>
                    <td>上级文件夹</td>
                    <td>
						<select name="folder.superiorFolder.id">
							<option value="0" selected="selected">无</option >
                    		<s:iterator value="folders" status="status">
                    			<option value = "${id}">${name}</option>
                    		</s:iterator>
                    	</select>
                    </td>
                </tr>
            </table>
            </form>
        </div>
    </div>
    <div id="upload" class="newwindow">
        <div class="newtop">
            <p class="newtitle">文件上传</p>
            <span onclick="add(uploadForm)">确定</span>
            <span class="close" onclick="newclose(upload)">关闭</span>
        </div>
        <div class="newmain">
        	<form id="uploadForm" action="upload.action" method="post" enctype="multipart/form-data">
            <table>
                <tr>
                    <td>文件主题</td>
                    <td><input name="file.theme" type="text"></td>
                </tr>
                <tr>
                    <td>关键字</td>
                    <td><input name="file.keyword" class="textarea" type="textarea"></td>
                </tr>
                <tr>
                    <td>文件信息</td>
                    <td><input type="file" name="doc"></td>
                </tr>
                <tr>
                    <td>所属文件夹</td>
                    <td>
						<select name="file.superiorFolder.id">
                    		<s:iterator value="allFolders" var="var" status="status">
                    			<option value = "${id}">${name}</option>
                    		</s:iterator>
                    	</select>
                    </td>
                </tr>
            </table>
            </form>
        </div>
    </div>
    <div id="query" class="newwindow">
        <div class="newtop">
            <p id="querytitle">查询条件设置</p>
            <span onclick="add(queryFrom)">确定</span>
            <span class="close" onclick="newclose(query)">关闭</span>
        </div>
        <div id="querymain" class="newmain">
        	<s:form id="queryFrom" action="queryFile">
                <tr>
                    <td>文件名</td>
                    <td><input name="queryFile.name" type="text"></td>
                </tr>
                <tr>
                    <td>文件主题</td>
                    <td><input name="queryFile.theme" type="text"></td>
                </tr>
				<tr>
					<td>关键字</td>
					<td><input name="queryFile.keyword" id="querytextarea" class="textarea" type="textarea"></td>
				</tr>
				<s:doubleselect label="创建者" name="queryFile.createUser.department" list="userMap.keySet()" headerKey="" headerValue="请选择部门"
					doubleName="createUser.name" doubleList="userMap[top]" 
					doubleListKey="name" doubleListValue="name" >
				</s:doubleselect>
				<tr>
					<td>创建日期</td>
					<td><input id="querydate" name="beforeQueryDate" type="date"> &nbsp;至&nbsp; <input
						id="querydate2" name="afterQueryDate" type="date"></td>
				</tr>
			</s:form>
        </div>
    </div>
    <div id="historyo" class="newwindow">
        <div class="newtop">
            <p class="newtitle">历史记录</p>
            <span class="close" onclick="newclose(historyo)">关闭</span>
        </div>
        <div id="historytable">
            <table>
                <tr>
                    <th id="user">用户</th>
                    <th id="time">时间</th>
                    <th id="operation">操作</th>
                </tr>
				<s:iterator value="histories" status="status">
					<tr>
						<td>${user.name}</td>
						<td><s:date name="time" format="yyyy-MM-dd HH:mm" /></td>
						<td>${operation}</td>
					</tr>
				</s:iterator>
			</table>
        </div>
    </div>
    <div id="fileproperty" class="newwindow">
        <div class="newtop">
            <p class="newtitle">文件属性</p>
            <span class="close" onclick="newclose(fileproperty)">关闭</span>
        </div>
        <div class="newmain">
        	<table id="filetable">
                <tr>
                	<td>name:</td>
                	<td></td>
                </tr> 
                <tr>
                	<td>theme:</td>
                	<td></td>
                </tr>
                <tr>
                	<td>type:</td>
                	<td></td>
                </tr>
                <tr>
                	<td>keyword:</td>
                	<td></td>
                </tr>
                <tr>
                	<td>size:</td>
                	<td></td>
                </tr>
                <tr>
                	<td>hits:</td>
                	<td></td>
                </tr>
                <tr>
                	<td>createTime:</td>
                	<td></td>
                </tr>
                <tr>
                	<td>createUser:</td>
                	<td></td>
                </tr>
                <tr>
                	<td>updateTime:</td>
                	<td></td>
                </tr>
                <tr>
                	<td>updateUser:</td>
                	<td></td>
                </tr>
                <tr>
                	<td>superiorFolder:</td>
                	<td></td>
                </tr>
			</table>
        </div>
    </div>
    <div id="folderproperty" class="newwindow">
        <div class="newtop">
            <p class="newtitle">文件属性</p>
            <span class="close" onclick="newclose(folderproperty)">关闭</span>
        </div>
        <div class="newmain">
        	<table id="foldertable">
                <tr>
                	<td>name:</td>
                	<td></td>
                </tr> 
                <tr>
                	<td>keyword:</td>
                	<td></td>
                </tr>
                <tr>
                	<td>updateTime:</td>
                	<td></td>
                </tr>
                <tr>
                	<td>updateUser:</td>
                	<td></td>
                </tr>
                <tr>
                	<td>superiorFolder:</td>
                	<td></td>
                </tr>
			</table>
        </div>
    </div>
    <%-- <s:debug></s:debug> --%>
</body>
</html>