/**
 * <html>
 * <body>
 *  <P> Copyright JasonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason  https://github.com/Jasonandy/springboot-wx</p>
 *  </body>
 * </html>
 */
package cn.ucaner.wx.app.gateway.annotation.support;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import cn.ucaner.wx.app.gateway.annotation.LoginUser;

/**
* @Package：cn.ucaner.wx.app.gateway.annotation.support   
* @ClassName：LoginUserHandlerMethodArgumentResolver   
* @Description：   <p>  SpringMVC3.1引入了HandlerMethodArgumentResolver接口,Spring调用该接口实现Controller的参数装配 </p>
* <code> 对参数进行判断,达到鉴权的效果 or 考虑采用 filter的方式 判断 是否放行  SpringMvc </code>
* @Author： - Jason   
* @CreatTime：2018年11月2日 上午9:27:27   
* @Modify By：   
* @ModifyTime：  2018年11月2日
* @Modify marker：   
* @version    V1.0
 */
public class LoginUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
	
	/**
	 * 登录的cookie标志位
	 */
    public static final String LOGIN_TOKEN_KEY = "loginToken";

    /**
     * 符合阿里的代码规约一点 养成良好的编码习惯
     */
    public static final  String LOGIN_FLAG = "jasonandy@hotmail.com";
    
    /**
     * 对传入的参数进行处理
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        /**
         * 这里其实就是对代码进行判断 看是不是有  loginUse这么一个注解  如果有的话 就需要做处理
         */
        return parameter.getParameterType().isAssignableFrom(String.class) && parameter.hasParameterAnnotation(LoginUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer container,NativeWebRequest request, WebDataBinderFactory factory) throws Exception {

    	//这里做是否登录的逻辑判断
    	
        return LOGIN_FLAG;
    }
}
