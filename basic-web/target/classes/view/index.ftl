<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Base后台管理系统</title>
        <#include "/common.ftl">
    </head>
    <body>
        <div class="layui-layout layui-layout-admin">
            <div class="layui-header header header-demo">
                <div class="layui-main">
                    <a class="logo" href="index.ftl">
                        Base后台管理系统
                    </a>
                    <ul class="layui-nav" lay-filter="">
                      <li class="layui-nav-item"><img src="${wz.contextPath}/static/images/logo.png" class="layui-circle" style="border: 2px solid #A9B7B7;" width="35px" alt=""></li>
                      <li class="layui-nav-item">
                        <a href="javascript:;">${currentUser.user.nickname}</a>
                        <dl class="layui-nav-child"> <!-- 二级菜单 -->
                          <dd><a href="">个人信息</a></dd>
                          <dd><a href="">切换帐号</a></dd>
                          <dd><a href="logout">退出</a></dd>
                        </dl>
                      </li>
                      <li class="layui-nav-item">
                        <a href="" title="消息">
                            <i class="layui-icon" style="top: 1px;">&#xe63a;</i>
                        </a>
                      </li>
                      <li class="layui-nav-item x-index"><a href="/">前台首页</a></li>
                    </ul>
                </div>
            </div>
            <#--freemarker宏定义菜单模板-->
            <#macro tree data start end>
                <#if (start=="start")>
	                <li class="layui-nav-item">
                </#if>
                <#list data as child>
                    <#if child.children?size gt 0>
                        <a class="" href="javascript:;">
                            <i class="layui-icon" style="top: 3px;">&#xe613;</i><cite>${child.name}</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <#list child.children as children>
                                <dd class="">
                                    <a href="javascript:;" _href="${children.url}"><cite>${children.name}</cite></a>
                                </dd>
                            </#list>
                        </dl>
                    <#else>
                    <a class="" href="javascript:;">
                        <i class="layui-icon" style="top: 3px;">&#xe613;</i><cite>${child.name}</cite>
                    </a>
                    </#if>
                </#list>
                <#if (end=="end")>
			        </li>
                </#if>
            </#macro>
            <#--freemarker宏定义菜单模板-->
            <div class="layui-side layui-bg-black x-side">
                <div class="layui-side-scroll">
                    <ul class="layui-nav layui-nav-tree site-demo-nav" lay-filter="side">
                       <#-- <li class="layui-nav-item">
                            <a class="javascript:;" href="javascript:;">
                                <i class="layui-icon" style="top: 3px;">&#xe613;</i><cite>管理员管理</cite>
                            </a>
                            <dl class="layui-nav-child">
                                <dd class="">
                                    <a href="javascript:;" _href="./admin-list.html">
                                        <cite>管理员列表</cite>
                                    </a>
                                </dd>
                            </dl>
                        </li>-->
                        <@tree data=menus start="start" end="end"/>
                    </ul>
                </div>
            </div>
            <div class="layui-tab layui-tab-card site-demo-title x-main" lay-filter="x-tab" lay-allowclose="true">
                <div class="x-slide_left"></div>
                <ul class="layui-tab-title">
                    <li class="layui-this">
                        我的桌面
                        <i class="layui-icon layui-unselect layui-tab-close">ဆ</i>
                    </li>
                </ul>
                <div class="layui-tab-content site-demo site-demo-body">
                    <div class="layui-tab-item layui-show">
                        <iframe frameborder="0" src="/druid/index.html" class="x-iframe"></iframe>
                    </div>
                </div>
            </div>
            <div class="site-mobile-shade">
            </div>
        </div>
    </body>
</html>