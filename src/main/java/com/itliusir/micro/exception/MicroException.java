package com.itliusir.micro.exception;

import org.apache.commons.logging.LogFactory;

/**
 * 项目级异常处理类
 *
 */
public class MicroException extends Exception {

	static final long serialVersionUID = 1L;
		
	private String error = null;

	private int errLevel = 1;
	
	private int code = 1;
	
	public int getCode() {
		return code;
	}

	public MicroException(Exception e) {
		super(e.getMessage(), e);
		LogFactory.getLog(getClass()).error(e.getMessage(), e);
	}
	
	public MicroException(Throwable cause) {
		super(cause);
	}

	/**
	 * 该构造方法适合作为自定义逻辑异常，不建议作为异常捕获使用 
	 * @param msg
	 */
	public MicroException(String msg) {
		super(msg);
	}
	/**
	 * 带错误头信息的构造函数
	 * @param msg
	 * @param error
	 * @param errLevel
	 */
	public MicroException(String msg, String error, int errLevel) {
		super(msg);
		this.error = error;
		this.errLevel = errLevel;
	}
	
	public MicroException(String error, String cause) {
		super(cause);
		this.error = error;
	}
	
	public MicroException(String msg, int errLevel) {
		super(msg);
		this.errLevel = errLevel;
	}
	
	public MicroException(int code, String msg) {
		super(msg);
		this.code = code;
	}

	/**
	 * 托管服务平台异常异常捕获推荐使用方法
	 * @param msg 自定义异常信息，用于前台页面展示
	 * @param e 异常对象
	 */
	public MicroException(int code, String msg, Exception e) {
		super(msg, e);
		this.code = code;
		LogFactory.getLog(getClass()).error(msg,e);
	}
	
	public MicroException(String msg, Throwable cause) {
		super(msg, cause);
		LogFactory.getLog(getClass()).error(cause);
	}
	/**
	 * 方法
	 */
	public String getMessage() {
		return super.getMessage();
	}
	
	public Throwable getCause() {
		return super.getCause();
	}
	
	public String getError() {
		return error;
	}	

	public int getErrLevel() {
		return this.errLevel;
	}
}
