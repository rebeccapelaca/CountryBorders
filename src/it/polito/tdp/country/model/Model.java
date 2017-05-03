package it.polito.tdp.country.model;

import java.util.List;

import org.jgrapht.Graphs;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.BreadthFirstIterator;

import it.polito.tdp.db.CountryDao;

public class Model {
	
	private UndirectedGraph<Country, DefaultEdge> graph  ;
	
	public Model() {
		this.graph = new SimpleGraph<>(DefaultEdge.class) ;
	}
	
	public void creaGrafo() {
		
		CountryDao dao = new CountryDao() ;
		
		// crea i vertici del grafo
		Graphs.addAllVertices(graph, dao.listCountry()) ;
	
		System.out.println(graph);
		
		/*
		// crea gli archi del grafo -- versione 1
		for(Country c1: graph.vertexSet()) {
			for(Country c2: graph.vertexSet()) {
				if(!c1.equals(c2)) {
					if( dao.confinanti(c1, c2) ) {
						graph.addEdge(c1, c2) ;
					}
				}
			}
		}
		
		// crea gli archi del grafo -- versione 2
		for(Country c: graph.vertexSet()) {
			List<Country> adiacenti = dao.listAdiacenti(c) ;
			for(Country c2: adiacenti)
				graph.addEdge(c, c2) ;
		}
		
		// crea gli archi del grafo -- versione 3
		for(CountryPair cp = dao.listCoppieCountryAdiacenti()) {
			graph.addEdge(cp.getC1(), cp.getC2()) ;
		}
		*/
		
		/** esempio visita
		BreadthFirstIterator<Country, DefaultEdge> bfv =
				new BreadthFirstIterator<>(graph, c1) ;
		while(bfv.hasNext()) {
			//System.out.println(bfv.next());
			visited.add(bfv.next()) ;
		} **/
		
		
	}

}
