package br.sc.senac.dw.rex;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import br.sc.senac.dw.rex.controller.IndexController;


public class IndexFiltro implements Filter {
	
	private final IndexController indexController;
	
	@Inject
	public IndexFiltro(IndexController indexController) {
		super();
		this.indexController = indexController;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		this.indexController.setDoIndex(true);
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
