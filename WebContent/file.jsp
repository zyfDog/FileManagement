<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Page Title</title>
    <link rel="stylesheet" type="text/css"  href="css/file.css" />
    <script type="text/javascript" src="js/file.js"></script>
</head>
<body>
    <div id="header">
        <div id="headertop">
            <span>知识管理</span>
            <ul>
                <li>&nbsp;&nbsp;列表显示&nbsp;&nbsp;</li>
                <li>新建文件夹&nbsp;&nbsp;</li>
                <li>新建文件&nbsp;&nbsp;</li>
                <li>新建文件&nbsp;&nbsp;</li>
                <li>上传文件&nbsp;&nbsp;</li>
                <li>zip批量文件&nbsp;&nbsp;</li>
                <li>查询&nbsp;&nbsp;</li>
            </ul>
        </div>
        <div id="headerpath">
            <span>当前路径:</span>
            <img src="img/file.png"/>
            <div id="path">

            </div>
            <img src="img/file.png"/>
            <span>属性</span>
        </div>
    </div>
    <div id="main">
        <div id="mainleft">
            <div id="mainlefttop">
                <img src="img/book.png"/>
                <span>知识管理</span>
            </div>
            <div id="mianleftmain">
                <ul id="sidenav">
                    <li><span>菜单1</span>
                        <ul>
                            <li><a href="#">菜单1-0</a></li>
                            <li><a href="#">菜单1-1</a></li>
                        </ul>
                    </li>
                        <li><span>菜单2</span>
                        <ul>
                            <li><a href="#">菜单2-0</a></li>
                            <li><a href="#">菜单2-1</a></li>
                        </ul>
                    </li>
                    <li><span>菜单3</span>
                        <ul>
                            <li><a href="#">菜单3-0</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <div id="mainright">
            <table>
                <tr id="tableheader">
                    <th class="check"><input type="checkbox"></th>
                    <th class="name">名称</th>
                    <th class="size">大小</th>
                    <th class="hits">点击</th>
                    <th class="updatetime">最后更新</th>
                    <th class="operation">操作</th>
                </tr>
                <tr>
                    <th><input type="checkbox"></th>
                    <th>OA办公系统功能介绍.doc</th>
                    <th>170.0KB</th>
                    <th>19</th>
                    <th>2012-05-08 22:13 赵华威</th>
                    <th><a href="www.baidu.com">属性</a>&nbsp;<a>重命名</a></th>
                </tr>
                <tr>
                    <th><input type="checkbox"></th>
                    <th>OA办公系统功能介绍.doc</th>
                    <th>170.0KB</th>
                    <th>19</th>
                    <th>2012-05-08 22:13 赵华威</th>
                    <th><a href="www.baidu.com">属性</a>&nbsp;<a>重命名</a></th>
                </tr>
            </table>
            <div id="mainrightbottom">
                <button>转存</button>
                <button>删除</button>
                <button>下载</button>
                <button>历史</button>
            </div>
        </div>
    </div>
</body>
</html>


<%-- <s:iterator value="files" status="status">
				<tr>
					<td>${name}</td>
					<td>${size}</td>
					<td>${hits}</td>
					<td>${updateTime}</td>
					<td>操作</td>
				</tr>
			</s:iterator> --%>