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


