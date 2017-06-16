package guanxin.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{
	/**
	 * 该方法返回一个 request
	 * @return HttpServletRequest
	 */
	public HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
		
	}
	/**
	 * 返回一个Response
	 * @return
	 */
	public HttpServletResponse getResponse(){
		return ServletActionContext.getResponse();
	}
	/**
	 * 返回一个Session
	 * @return
	 */
	public HttpSession getSession(){
		return ServletActionContext.getRequest().getSession();
	}
	/**
	 * 返回一个PrintWriter
	 * @return
	 */
	public PrintWriter getOut(){
		try {
			return getResponse().getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
