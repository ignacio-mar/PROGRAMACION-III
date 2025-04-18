package practica3;
import java.util.LinkedList;
import tp1.ejercicio8.Queue;
import java.util.List;
public class RecorridosAG {

public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a,Integer n){
    if(a==null || a.isEmpty()) {
    	return null;
    }
	List<Integer> lista= new LinkedList <Integer>();
    recorrerPreOrden(a,n,lista);
    if(lista.isEmpty()) {
    	return null;
    }
    return lista;
}

private void recorrerPreOrden(GeneralTree<Integer> a,Integer n,List<Integer> lista) {
	if(a.getData()%2!=0  &&  a.getData()>n) {
		lista.add(a.getData());
	}
	List<GeneralTree<Integer>> children= a.getChildren();
	for(GeneralTree<Integer> child: children) {
		recorrerPreOrden(child,n,lista);
	}
}
public List<Integer> numerosImparesMayoresQueEnOrden (GeneralTree <Integer> a,Integer n){
	if(a==null || a.isEmpty()) {
    	return null;
    }
	List<Integer> lista= new LinkedList <Integer>();
    recorrerEnOrden(a,n,lista);
    if(lista.isEmpty()) {
    	return null;
    }
    return lista;
}
	
private void recorrerEnOrden(GeneralTree<Integer> a,Integer n,List<Integer> lista) {
	List<GeneralTree<Integer>> children= a.getChildren(); 
	if(!children.isEmpty()) {
	recorrerEnOrden(children.get(0),n,lista);
}
if(a.getData()%2!=0  &&  a.getData()>n) {
	lista.add(a.getData());	
}
for(int i=1; i<children.size();i++) {
	recorrerEnOrden(children.get(i),n,lista);
}

}
public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a,Integer n){
	  if(a==null || a.isEmpty()) {
	    	return null;
	    }
		List<Integer> lista= new LinkedList <Integer>();
	    recorrerPostOrden(a,n,lista);
	    if(lista.isEmpty()) {
	    	return null;
	    }
	    return lista;
	}

	private void recorrerPostOrden(GeneralTree<Integer> a,Integer n,List<Integer> lista) {
		List<GeneralTree<Integer>> children= a.getChildren();
		for(GeneralTree<Integer> child: children) {
			recorrerPostOrden(child,n,lista);
			if(a.getData()%2!=0  &&  a.getData()>n) {
				lista.add(a.getData());
			}

		}
	}
public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a,Integer n){
	List<Integer> lista= new LinkedList<Integer>();
	GeneralTree<Integer> aux;
	Queue<GeneralTree<Integer>> cola= new Queue<GeneralTree<Integer>>();
	cola.enqueue(a);
	while(!cola.isEmpty()) {
		aux=cola.dequeue();
		if(aux.getData()%2!=0  &&  aux.getData()>n) {
			lista.add(aux.getData());}
		List<GeneralTree<Integer>> children=aux.getChildren();
		for(GeneralTree<Integer> child:children) {
			cola.enqueue(child);
		}
	}
	return lista;
		}
	


}
