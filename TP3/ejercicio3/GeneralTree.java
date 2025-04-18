package practica3;
import tp1.ejercicio8.Queue;
import java.util.List;
import java.util.LinkedList;


public class GeneralTree<T> {

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>();

	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}

	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}

	public boolean hasChildren() {
		return children != null && !children.isEmpty();
	}

	public boolean isEmpty() {
		return this.data == null && !hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren()) {
			List<GeneralTree<T>> children = this.getChildren();
			if (children.contains(child))
				children.remove(child);
		}
	}
	public int altura() {
		if( this.isEmpty()) {
			return 0;}
		GeneralTree<T> aux;
		Queue<GeneralTree<T>> cola=new Queue<GeneralTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		int nivel=-1;
		while(!cola.isEmpty()){
			aux=cola.dequeue();
			if(aux!=null) {
			List<GeneralTree<T>> children=aux.getChildren();
			for(GeneralTree<T> child: children) {
				cola.enqueue(child);
			}
		
		}else {
		if(aux==null) {
			nivel++;
			if(!cola.isEmpty()) {
			cola.enqueue(null);}
		}	
	}}
  return nivel;
	}
  
	public int nivel(T dato) {
		if(this.isEmpty()) {
			return -1;
		}
		GeneralTree<T> aux;
		Queue<GeneralTree<T>> cola=new Queue<GeneralTree<T>>();
				cola.enqueue(this);
				cola.enqueue(null);
				boolean condicion=false;
				int nivel=0;
				while(!cola.isEmpty() && !condicion) {
					aux=cola.dequeue();
					if(aux==null) {
						 nivel++;
						  if(!cola.isEmpty()) {
							cola.enqueue(null);
							}
				          }   
						  else {
						  if(aux.getData().equals(dato)) {
									condicion=true;	}	
						  else {
					      List<GeneralTree<T>> children=aux.getChildren();
					      for(GeneralTree<T> child: children) {
						     cola.enqueue(child);
					  }
					}
				   } 
			      }
				
				if(!condicion) {
					return -1;
				}else
					return nivel;
				
		
	}
	
public int ancho() {
	if(this.isEmpty()) {
		return 0;
	}
	GeneralTree<T> aux;
	Queue<GeneralTree<T>> cola=new Queue<GeneralTree<T>>();
	cola.enqueue(this);
	int max=1;
	int cant=0;
	cola.enqueue(null);
	while(!cola.isEmpty()) {
		aux=cola.dequeue();
		if(aux==null) {
			if(cant>max) {
				max=cant;
			}
			cant=0;
			if(!cola.isEmpty()) {
				cola.enqueue(null);
			}
		}
		else {
		   List<GeneralTree<T>> children=aux.getChildren();  
		   for(GeneralTree<T> child: children) {
			   cola.enqueue(child);
			   cant++;
		   }
		}
	}
	return max;
	
}
public boolean esAncestro(T a,T b) {
	if(this==null){
		return false;
		}
    boolean condicion=false;
	GeneralTree<T> arbol=devolverNodo(this,a);
	if(arbol!=null) {
		GeneralTree<T> arbol2=devolverNodo(arbol,b);
		if(arbol2!=null) {
			condicion=true;
		}
	}
	return condicion;
	
	}


private GeneralTree<T> devolverNodo(GeneralTree<T> arbol, T a) {
	
	if(arbol.getData()==a) {
		return arbol;
	}
	GeneralTree<T> nodo=null;
	if(arbol.hasChildren()) {
		for(GeneralTree<T> child:arbol.getChildren()) {
			nodo=devolverNodo(child,a);
			if(nodo!=null) {
				return nodo;
			}
		}
	}
	return null;
}

}	


