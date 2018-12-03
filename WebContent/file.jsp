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
                <li onclick="newopen(newfolder)">新建文件夹&nbsp;&nbsp;</li>
                <li onclick="newopen(newfile)">新建文件&nbsp;&nbsp;</li>
                <li onclick="newopen(upload)">上传文件&nbsp;&nbsp;</li>
                <li>zip批量文件&nbsp;&nbsp;</li>
                <li onclick="newopen(query)">查询&nbsp;&nbsp;</li>
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
                    <li class="folders"><span>菜单1</span>
                        <ul>
                            <li><a href="#">菜单1-0</a></li>
                            <li><a href="#">菜单1-1</a></li>
                        </ul>
                    </li>
                    <li class="folders"><span>菜单2</span>
                        <ul>
                            <li><a href="#">菜单2-0</a></li>
                            <li><a href="#">菜单2-1</a></li>
                        </ul>
                    </li>
                    <li class="folders"><span>菜单3</span>
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
                    <td><input type="checkbox"></td>
                    <td>OA办公系统功能介绍.doc</td>
                    <td>170.0KB</td>
                    <td>19</td>
                    <td>2012-05-08 22:13 赵华威</td>
                    <td><a href="www.baidu.com">属性</a>&nbsp;<a>重命名</a></td>
                </tr>
                <tr>
                    <td><input type="checkbox"></td>
                    <td>OA办公系统功能介绍.doc</td>
                    <td>170.0KB</td>
                    <td>19</td>
                    <td>2012-05-08 22:13 赵华威</td>
                    <td><a href="www.baidu.com">属性</a>&nbsp;<a>重命名</a></td>
                </tr>
            </table>
            <div id="mainrightbottom">
                <button>转存</button>
                <button>删除</button>
                <button>下载</button>
                <button onclick="newopen(historyo)">历史</button>
            </div>
        </div>
    </div>
    <div id="newfile" class="newwindow">
        <div class="newtop">
            <p class="newtitle">新建文件</p>
            <span>确定</span>
            <span class="close" onclick="newclose(newfile)">关闭</span>
        </div>
        <div class="newmain">
            <table>
                <tr>
                    <td>文件主题</td>
                    <td><input type="text"></td>
                </tr>
                <tr>
                    <td>文件类型</td>
                    <td><select name="types"></select></td>
                </tr>
                <tr>
                    <td>关键字</td>
                    <td><input class="textarea" type="textarea"></td>
                </tr>
                <tr>
                    <td>所属文件夹</td>
                    <td><input type="text"></td>
                </tr>
            </table>
        </div>
    </div>
    <div id="newfolder" class="newwindow">
        <div class="newtop">
            <p class="newtitle">新建文件夹</p>
            <span>保存</span>
            <span class="close" onclick="newclose(newfolder)">关闭</span>
        </div>
        <div class="newmain">
            <table>
                <tr>
                    <td>文件夹名称</td>
                    <td><input type="text"></td>
                </tr>
                <tr>
                    <td>关键字</td>
                    <td><input class="textarea" type="textarea"></td>
                </tr>
                <tr>
                    <td>上级文件夹</td>
                    <td><input type="text"></td>
                </tr>
            </table>
        </div>
    </div>
    <div id="upload" class="newwindow">
        <div class="newtop">
            <p class="newtitle">文件上传</p>
            <span>确定</span>
            <span class="close" onclick="newclose(upload)">关闭</span>
        </div>
        <div class="newmain">
            <table>
                <tr>
                    <td>文件主题</td>
                    <td><input type="text"></td>
                </tr>
                <tr>
                    <td>关键字</td>
                    <td><input class="textarea" type="textarea"></td>
                </tr>
                <tr>
                    <td>文件信息</td>
                    <td><input type="file" value="附件上传"></td>
                </tr>
                <tr>
                    <td>所属文件夹</td>
                    <td><input type="text"></td>
                </tr>
            </table>
        </div>
    </div>
    <div id="query" class="newwindow">
        <div class="newtop">
            <p id="querytitle">查询条件设置</p>
            <span>确定</span>
            <span class="close" onclick="newclose(query)">关闭</span>
        </div>
        <div class="newmain">
            <table>
                <tr>
                    <td>文件名</td>
                    <td><input type="text"></td>
                </tr>
                <tr>
                    <td>文件主题</td>
                    <td><input type="text"></td>
                </tr>
                <tr>
                    <td>关键字</td>
                    <td><input id="querytextarea" class="textarea" type="textarea"></td>
                </tr>
                <tr>
                    <td>文件信息</td>
                    <td><input type="file" value="附件上传"></td>
                </tr>
                <tr>
                    <td>创建者</td>
                    <td>
                        <select class="queryselect">
                            <option  disabled selected hidden>请选择部门</option>
                        </select>
                        &nbsp;
                        <select class="queryselect">
                            <option  disabled selected hidden>请选择人员</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>创建日期</td>
                    <td>
                        <input id="querydate" type="date">
                        &nbsp;至&nbsp;
                        <input id="querydate2" type="date">
                    </td>
                </tr>
            </table>
        </div>
    </div>
    <div id="historyo" class="newwindow">
        <div class="newtop">
            <p class="newtitle">历史记录</p>
            <span>确定</span>
            <span class="close" onclick="newclose(historyo)">关闭</span>
        </div>
        <div id="historytable">
            <table>
                <tr>
                    <th id="user">用户</th>
                    <th id="time">时间</th>
                    <th id="operation">操作</th>
                </tr>
                <tr>
                    <td>管理员</td>
                    <td>2018-05-17</td>
                    <td>查看</td>
                </tr>
            </table>
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