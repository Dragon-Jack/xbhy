package com.dfbz.xbhy.utils;

import com.google.code.kaptcha.servlet.KaptchaServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(value = "/pic",initParams = {
        @WebInitParam(name = "kaptcha.border.color",value = "blue"),    //边框颜射
        @WebInitParam(name = "kaptcha.textproducer.font.color",value = "blue"),     //字体颜色
        @WebInitParam(name = "kaptcha.word.impl",value = "com.google.code.kaptcha.text.impl.DefaultWordRenderer"),//文字渲染器
		@WebInitParam(name = "kaptcha.session.key",value = "code"),//设置session的key名字
})
public class pic extends KaptchaServlet {


}
