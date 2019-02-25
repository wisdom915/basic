<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>
            菜单管理
        </title>
        <#include "/common.ftl">
    </head>
    <body>
        <div class="x-nav">
            <span class="layui-breadcrumb">
              <a><cite>首页</cite></a>
              <a><cite>会员管理</cite></a>
              <a><cite>管理员列表</cite></a>
            </span>
            <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="javascript:location.replace(location.href);" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a>
        </div>
        <div class="x-body">
            <form class="layui-form" action="" style="width:80%">
                <div class="layui-form-pane" style="margin-top: 15px;">
                  <div class="layui-form-item">
                    <label class="layui-form-label">日期范围</label>
                    <div class="layui-input-inline">
                      <input class="layui-input" placeholder="开始日" id="LAY_demorange_s">
                    </div>
                    <div class="layui-input-inline">
                      <input class="layui-input" placeholder="截止日" id="LAY_demorange_e">
                    </div>
                    <div class="layui-input-inline">
                      <input type="text" name="username"  placeholder="请输入登录名" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-input-inline" style="width:80px">
                        <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                    </div>
                  </div>
                </div> 
            </form>
            <xblock>
                <@shiro.hasPermission name="menu:create">
                    <button class="layui-btn" onclick="menu_add('添加用户','admin-add.html','600','500')"><i class="layui-icon">&#xe608;</i>添加</button>
                </@shiro.hasPermission>
                <@shiro.hasPermission name="menu:update">
                 <button class="layui-btn" onclick="menu_add('修改用户','admin-add.html','600','500')"><i class="layui-icon">&#xe608;</i>修改</button>
                </@shiro.hasPermission>
                <@shiro.hasPermission name="menu:delete">
                   <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon">&#xe640;</i>删除</button>
                </@shiro.hasPermission>
            </xblock>
            <table class="layui-hide" id="userList" lay-filter="userList"></table>
        </div>
    </body>
</html>
<script>
    layui.use(['table'], function(){
        $ = layui.jquery;//jquery
        var table = layui.table;

        table.render({
            id:'userList'
            ,elem: '#userList'
            ,url:' userList'
            ,cols: [[
                {field:'id', width:80, title: 'ID', sort: true}
                ,{field:'username', width:100, title: '用户名'}
                ,{field:'email', width:80, title: '邮箱', sort: true}
                ,{field:'mobile', width:80, title: '手机号'}
            ]]
            ,page: true
        });
    });

    //批量删除提交
    function delAll () {
        layer.confirm('确认要删除吗？',function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
        });
    }
    /*添加*/
    function menu_add(title,url,w,h){
        x_menu_show(title,url,w,h);
    }

    /*停用*/
    function menu_stop(obj,id){
        layer.confirm('确认要停用吗？',function(index){
            //发异步把用户状态进行更改
            $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="menu_start(this,id)" href="javascript:;" title="启用"><i class="layui-icon">&#xe62f;</i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="layui-btn layui-btn-disabled layui-btn-mini">已停用</span>');
            $(obj).remove();
            layer.msg('已停用!',{icon: 5,time:1000});
        });
    }

    /*启用*/
    function menu_start(obj,id){
        layer.confirm('确认要启用吗？',function(index){
            //发异步把用户状态进行更改
            $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="menu_stop(this,id)" href="javascript:;" title="停用"><i class="layui-icon">&#xe601;</i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="layui-btn layui-btn-normal layui-btn-mini">已启用</span>');
            $(obj).remove();
            layer.msg('已启用!',{icon: 6,time:1000});
        });
    }
    //编辑
    function menu_edit (title,url,id,w,h) {
        x_menu_show(title,url,w,h);
    }
    /*删除*/
    function menu_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
            //发异步删除数据
            $(obj).parents("tr").remove();
            layer.msg('已删除!',{icon:1,time:1000});
        });
    }
</script>
