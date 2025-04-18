package practica3;
import java.util.List;
import java.util.ArrayList;

public class Caminos {
private GeneralTree<Integer> arbol;
public Caminos(GeneralTree<Integer> arbol) {
	this.arbol=arbol;
}
public List<Integer> caminoAHojaMasLejana(){
	List<Integer> lista=new ArrayList<>();
	List<Integer> camino=new ArrayList<>();
	
	recorrer(camino,lista,this.arbol);
	return camino;
}
private static void recorrer(List<Integer> camino,List<Integer> lista,GeneralTree<Integer> a){
	
	lista.add(a.getData());
	
	if(a.isLeaf()) {
		if(lista.size()>camino.size()) {
			for(Integer e: camino) {
				camino.remove(e);
			}
			for(Integer e: lista ) {
				camino.add(e);
			}
		}}
		else {
		for(GeneralTree<Integer> child: a.getChildren())	{
		recorrer(camino,lista,child);
		 lista.remove(child.getData());
		//lista.remove(lista.size()-2);
		}
		
	
	}
	}
}

