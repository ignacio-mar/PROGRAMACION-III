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
