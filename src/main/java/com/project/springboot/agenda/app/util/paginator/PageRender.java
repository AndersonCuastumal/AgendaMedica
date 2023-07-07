package com.project.springboot.agenda.app.util.paginator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;



public class PageRender<T> {
	private String url;
	private Page<T> page;
	private int totalPaginas;
	private int numElementosPorPagina;
	private int paginaActual;
	private List<PageItem> paginas;
	
	
	public PageRender(String url,Page<T> page) {
		this.url=url;
		this.page=page;
		this.paginas=new ArrayList<PageItem>();
		
		numElementosPorPagina=page.getSize();
		totalPaginas=page.getTotalPages();
		paginaActual=page.getNumber()+1;
		int desde,hasta;
		if(totalPaginas<=numElementosPorPagina) {
			desde=1;
			hasta=totalPaginas;
		}else {
			if(paginaActual<=numElementosPorPagina/2) {
				desde=1;
				hasta=numElementosPorPagina;
			}else if(paginaActual>=totalPaginas-numElementosPorPagina/2) {
				desde=totalPaginas-numElementosPorPagina+1;
				hasta=numElementosPorPagina;
			}else {
				desde=paginaActual-numElementosPorPagina/2;
				hasta=numElementosPorPagina;
			}
		}
		
		// Vamos a empezar a llenar las paginas con cada de los items y si es actual o no comienza en cero y menor que el hasta
		for(int i=0;i<hasta;i++) {
			paginas.add(new PageItem(desde+i,paginaActual==desde+i));
		}
		
	}


	public String getUrl() {
		return url;
	}


	public int getTotalPaginas() {
		return totalPaginas;
	}


	public int getPaginaActual() {
		return paginaActual;
	}


	public List<PageItem> getPaginas() {
		return paginas;
	}
	
	//Creamos dos metodos para consultar si es la primera o ultima pagina, o si tiene pagina siguiente o atras
	
	public boolean isFirst() { // Ir a la primera pagina
		return page.isFirst();
	}
	
	public boolean isLast() { // Ir a la ultima pagina
		return page.isLast();
	}
	public boolean isHasNext() { // Ir a la siguiente pagina
		return page.hasNext();
	}
	
	public boolean isHasPrevious() { // Ir a la anterior pagina
		return page.hasPrevious();
	}
}
