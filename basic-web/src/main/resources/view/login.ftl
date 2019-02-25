<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Base后台管理登录</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${wz.contextPath}/static/admin2.0/css/font.css">
	<link rel="stylesheet" href="${wz.contextPath}/static/admin2.0/css/xadmin.css">
    <script type="text/javascript" src="${wz.contextPath}/static/js/jquery.min.js"></script>
    <script src="${wz.contextPath}/static/admin2.0/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${wz.contextPath}/static/admin2.0/js/xadmin.js"></script>
</head>
<body class="login-bg">
    
    <div class="login layui-anim layui-anim-up">
        <div class="message">Base后台管理登录</div>
        <div id="darkbannerwrap"></div>
        
        <form method="post" class="layui-form" action="index">
            <input name="username" placeholder="用户名"  type="text" lay-verify="username" class="layui-input" >
            <hr class="hr15">
            <input name="password" placeholder="密码"  type="password" lay-verify="password" class="layui-input">
            <hr class="hr15">
            <div class="layui-inline">
                <label class="layui-form-label" style="width:60px;padding: 9px 0px;text-align: left;">验证码：</label>
                <div class="layui-input-inline">
                    <input type="text" name="code" style="width:150px;height:35px;" autocomplete="off" lay-verify="code"   class="layui-input">
                </div>
                <div class="layui-input-inline">
                    <img src="" id="code" style="cursor: pointer;">
                </div>
            </div>
            <div class="layui-inline" style="">
                <label class="layui-form-label" style="width:50px;padding: 9px 0px;text-align: left;">记住我</label>
                <div class="layui-input-inline" style="height: 38px;line-height: 38px;">
                    <input type="checkbox" value="true" name="rememberMe" lay-skin="switch">
                </div>
            </div>
            <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
            <hr class="hr20" >
        </form>
    </div>

    <script>
    $(function() {
        layui.use(['form','layer'], function(){
              var form = layui.form;
              var layer = layui.layer;
              // layer.msg('玩命卖萌中', function(){
              //   //关闭后的操作
              //   });
              //监听提交
              /*form.on('submit(login)', function(data){
                layer.msg(JSON.stringify(data.field),function(){
                    location.href='index'
                });
                return false;
              });*/
             form.render();

            form.verify({
                username:function(val){
                    if(val.trim()==''){
                        return "用户名不能为空";
                    }
                }
                ,password:function(val){
                    if(val.trim()==''){
                        return "密码不能为空";
                    }
                },code:function(val){
                    if(val.trim()==''){
                        return '验证码不能为空';
                    }
                }
            });


            var msg='${message}';
            if(msg.trim()!=""){
                layer.msg(msg, {icon: 5,anim:6,offset: 't'});
            }
            $("#code").click(function(){
                var url = "/getCode?"+new Date().getTime();
                this.src = url;
            }).click().show();
            $('#code').on('mouseover',function(){
                layer.tips('点击刷新验证码', this,{time:1000});
            });
        });
    });
    </script>
</body>
</html>