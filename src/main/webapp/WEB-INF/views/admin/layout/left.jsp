<%--
  Created by IntelliJ IDEA.
  User: sousic
  Date: 2016-09-09
  Time: 오후 5:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<div class="left_col scroll-view">
    <div class="navbar nav_title" style="border: 0;">
        <a href="index.html" class="site_title"><i class="fa fa-paw"></i> <span>Gentellela Alela!</span></a>
    </div>

    <div class="clearfix"></div>

    <!-- menu profile quick info -->
    <div class="profile">
        <div class="profile_pic">
            <img src="/resources/images/img.jpg" alt="..." class="img-circle profile_img">
        </div>
        <div class="profile_info">
            <span>환영합니다.</span>
            <h2>${nickname}</h2>
        </div>
    </div>
    <!-- /menu profile quick info -->

    <br />

    <!-- sidebar menu -->
    <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
        <div class="menu_section">
            <h3>General</h3>
            <ul class="nav side-menu">
                <!-- 메뉴 -->
                <li><a><i class="fa fa-list"></i>Home <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                        <li><a href="${adminPath}/member/list">회원목록</a></li>
                        <li><a href="${adminPath}/member/history">로그인기록</a></li>
                    </ul>
                </li>

                <li><a><i class="fa fa-table"></i>게시판 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                        <li><a href="${adminPath}/board/manager/list">게시판관리</a></li>
                    </ul>
                </li>
                <%--
                <li><a><i class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                        <li><a href="index.html">Dashboard</a></li>
                        <li><a href="index2.html">Dashboard2</a></li>
                        <li><a href="index3.html">Dashboard3</a></li>
                    </ul>
                </li>
                <li><a><i class="fa fa-edit"></i> Forms <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                        <li><a href="form.html">General Form</a></li>
                        <li><a href="form_advanced.html">Advanced Components</a></li>
                        <li><a href="form_validation.html">Form Validation</a></li>
                        <li><a href="form_wizards.html">Form Wizard</a></li>
                        <li><a href="form_upload.html">Form Upload</a></li>
                        <li><a href="form_buttons.html">Form Buttons</a></li>
                    </ul>
                </li>
                <li><a><i class="fa fa-desktop"></i> UI Elements <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                        <li><a href="general_elements.html">General Elements</a></li>
                        <li><a href="media_gallery.html">Media Gallery</a></li>
                        <li><a href="typography.html">Typography</a></li>
                        <li><a href="icons.html">Icons</a></li>
                        <li><a href="glyphicons.html">Glyphicons</a></li>
                        <li><a href="widgets.html">Widgets</a></li>
                        <li><a href="invoice.html">Invoice</a></li>
                        <li><a href="inbox.html">Inbox</a></li>
                        <li><a href="calendar.html">Calendar</a></li>
                    </ul>
                </li>
                <li><a><i class="fa fa-table"></i> Tables <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                        <li><a href="tables.html">Tables</a></li>
                        <li><a href="tables_dynamic.html">Table Dynamic</a></li>
                    </ul>
                </li>
                <li><a><i class="fa fa-bar-chart-o"></i> Data Presentation <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                        <li><a href="chartjs.html">Chart JS</a></li>
                        <li><a href="chartjs2.html">Chart JS2</a></li>
                        <li><a href="morisjs.html">Moris JS</a></li>
                        <li><a href="echarts.html">ECharts</a></li>
                        <li><a href="other_charts.html">Other Charts</a></li>
                    </ul>
                </li>
                <li><a><i class="fa fa-clone"></i>Layouts <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                        <li><a href="fixed_sidebar.html">Fixed Sidebar</a></li>
                        <li><a href="fixed_footer.html">Fixed Footer</a></li>
                    </ul>
                </li>
                --%>
            </ul>
        </div>
</div>
