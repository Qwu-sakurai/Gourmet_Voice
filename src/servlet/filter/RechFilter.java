package servlet.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class RechFilter
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST,
				DispatcherType.FORWARD,
				DispatcherType.INCLUDE,
				DispatcherType.ERROR
		}
					, urlPatterns = { "/*" })
public class RechFilter implements Filter {

    /**
     * Default constructor.
     */
    public RechFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");

		chain.doFilter(request, response);

		// リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
