<%--
    博客顶部部分
    包括：顶部菜单，主要菜单(包括搜索按钮)，面包屑
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%--导航 start--%>
<header id="masthead" class="site-header">
    <%--顶部菜单 start--%>
    <nav id="top-header">
        <div class="top-nav">
            <div class="user-login">
                <c:choose>
                    <c:when test="${sessionScope.user == null}">
                        <a href="/login">登录</a>
                        <a href="/regist">注册</a>
                    </c:when>
                    <c:otherwise>
                        <a href="/">${sessionScope.user.userNickname},</a>
                    </c:otherwise>
                </c:choose>
                <script type="text/javascript">today = new Date();
                    var day;
                    var date;
                    var hello;
                    hour = new Date().getHours();
                    if (hour < 6) {
                        hello = '凌晨好！';
                    } else if (hour < 9) {
                        hello = '早上好！';
                    } else if (hour < 12) {
                        hello = '上午好！';
                    } else if (hour < 14) {
                        hello = '中午好！';
                    } else if (hour < 17) {
                        hello = '下午好！';
                    } else if (hour < 19) {
                        hello = '傍晚好！';
                    } else if (hour < 22) {
                        hello = '晚上好！';
                    } else {
                        hello = '夜深了！ ';
                    }
                    document.write(' ' + hello);
                </script>
                <script type="text/javascript">
                    var d, s = "现在是：";
                    var x = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");
                    d = new Date();
                    s += d.getFullYear() + "年" + (d.getMonth() + 1) + "月" + d.getDate() + "日 ";
                    s += x[d.getDay()];
                    document.writeln(s);
                </script>
            </div>
            <%--<div class="menu-topmenu-container">--%>
                <%--<ul id="menu-topmenu" class="top-menu">--%>
                    <%--<c:forEach items="${menus}" var="m">--%>
                        <%--<li class="menu-item">--%>
                        <%--<c:if test="${m.menuLevel==1}">--%>
                                <%--<a href="${m.menuUrl}" >--%>
                                    <%--<i class="${m.menuIcon}"></i>--%>
                                    <%--<span class="font-text">${m.menuName}&nbsp;</span>&nbsp;--%>
                                <%--</a>--%>
                            <%--</c:if>--%>
                        <%--</li>--%>
                    <%--</c:forEach>--%>
                <%--</ul>--%>
            <%--</div>--%>
        </div>
    </nav><!-- #top-header -->
    <%--顶部菜单 end--%>

    <%--主要菜单 satrt--%>
    <div id="menu-box">
        <div id="top-menu">
                <span class="nav-search">
                    <i class="fa fa-search"></i>
                </span>
            <div class="logo-site"><h1 class="site-title">
                <a href="/" title="${options.optionSiteTitle}">${options.optionSiteTitle}</a>
            </h1>
                <p class="site-description">${options.optionSiteDescrption}</p>
            </div><!-- .logo-site -->
            <div id="site-nav-wrap">
                <div id="sidr-close">
                    <a href="#sidr-close" class="toggle-sidr-close">×</a>
                </div>
                <nav id="site-nav" class="main-nav">
                    <a href="#sidr-main" id="navigation-toggle" class="bars">
                        <i class="fa fa-bars"></i>
                    </a>
                    <div class="menu-pcmenu-container">
                        <ul id="menu-pcmenu" class="down-menu nav-menu sf-js-enabled sf-arrows">

                            <li>
                                <a href="/">
                                    <i class="fa-home fa"></i>
                                    <span class="font-text">首页</span>
                                </a>
                            </li>

                            <c:forEach items="${categories}" var="category">
                                <c:if test="${category.categoryPid==0}">
                                    <li>
                                        <a href="/category/${category.categoryId}">
                                            <i class="${category.categoryIcon}"></i>
                                            <span class="font-text">${category.categoryName}&nbsp;</span>
                                        </a>
                                        <ul class="sub-menu">
                                            <c:forEach items="${categories}" var="cate">
                                                <c:if test="${cate.categoryPid==category.categoryId}">
                                                    <li>
                                                        <a href="/category/${cate.categoryId}" target="_blank">${cate.categoryName}</a>
                                                    </li>
                                                </c:if>
                                            </c:forEach>
                                        </ul>
                                    </li>
                                </c:if>
                            </c:forEach>
                            <%--主要菜单其余部分--%>
                            <c:forEach items="${menus}" var="m">
                                <c:if test="${m.menuLevel == 2}">
                                    <li>
                                        <a href="${m.menuUrl}">
                                            <i class="${m.menuIcon}"></i>
                                            <span class="font-text">${m.menuName}&nbsp;</span>
                                        </a>
                                    </li>
                                </c:if>
                            </c:forEach>
                        </ul>
                    </div>
                </nav>
            </div>
            <div class="clear"></div>
        </div><!-- #top-menu -->
    </div><!-- #menu-box -->
    <%--主要菜单 satrt--%>

</header><!-- #masthead -->
<%--导航 end start--%>

<%--搜索框 start--%>
<div id="search-main">
    <div class="searchbar">
        <form method="get" id="searchform" action="/search" accept-charset="UTF-8">
            <span>
                <input type="text" value="" name="keywords" id="s" placeholder="输入搜索内容"required="">
                <button type="submit" id="searchsubmit">搜索</button>
            </span>
        </form>
    </div>
    <div class="clear"></div>
</div>
<%--搜索框 end--%>

<rapid:block name="breadcrumb"></rapid:block>


