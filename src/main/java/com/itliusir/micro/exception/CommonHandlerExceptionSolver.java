package com.itliusir.micro.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.itliusir.micro.model.ResponseInfo;
import net.sf.json.JSONObject;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CommonHandlerExceptionSolver implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception e) {
		try {
			ResponseInfo err = new ResponseInfo();
			if(e instanceof MicroException){  //处理自定义异常
				err.setMessage(e.getCause()+"");
			}else{
				err.setStatus(1);
			}
			err.setMessage(e.getMessage());
			
			response.addHeader("Content-Type", "application/json;charset=UTF-8");
			response.setStatus(200);
			response.getWriter().write(JSONObject.fromObject(err).toString());
		} catch (Exception e2) {
			e.printStackTrace();
		}
		
		return new ModelAndView();
	}

}
