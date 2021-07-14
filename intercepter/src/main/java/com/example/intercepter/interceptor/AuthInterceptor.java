package com.example.intercepter.interceptor;

import com.example.intercepter.annotation.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        String url = request.getRequestURI();

        URI uri = UriComponentsBuilder.fromUriString(request.getRequestURI())
                .query(request.getQueryString())
                .build()
                .toUri();

        log.info("request url :{}",url);

        boolean hasAnnotaion = checkAnnotation(handler, Auth.class);
        log.info("has annotation : {}", hasAnnotaion);

        if(hasAnnotaion){
            String query = uri.getQuery();
            log.info("query : {}", query);
            if(query.equals("name=steve")){
                return true;
            }
            return false;

        }
        //여기서 만약 트루를 리턴하면 요청이 타고 들어가지만 false 라면 요청은 여기서 멈춤 이것을 이용하여 만약 권한 유무에 따라 요청을 변환할수도 있음
        return true;
    }

    private boolean checkAnnotation(Object handler, Class clazz){

        if (handler instanceof ResourceHttpRequestHandler){
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;

        if(null != handlerMethod.getMethodAnnotation(clazz) || null != handlerMethod.getBeanType().getAnnotation(clazz)){
            return true;
        }
        return false;
    }
}
