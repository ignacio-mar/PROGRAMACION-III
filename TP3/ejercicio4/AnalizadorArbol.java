package practica3;
import tp1.ejercicio8.Queue;
import java.util.List;
import java.util.LinkedList;

public class AnalizadorArbol {
	
public static int devolverMaximoPromedio(GeneralTree<AreaEmpresa> arbol) {
	if(arbol.isEmpty() || arbol==null) {
		return 0;
	}
    GeneralTree<AreaEmpresa> aux;
    Queue<GeneralTree<AreaEmpresa>> cola=new Queue<GeneralTree<AreaEmpresa>>();
    cola.enqueue(arbol);
    cola.enqueue(null);
    int promedio=arbol.getData().getTardanza();
    int suma=0;
    int cant=0;
    while(!cola.isEmpty()) {
    	aux=cola.dequeue();
    	if(aux==null) {
    		if(cant>0) {
    		if(suma/cant >promedio) {
    			promedio=suma/cant;
    		}}
    		suma=0;
    		cant=0;
    		if(!cola.isEmpty()) {
    			cola.enqueue(null);
    		}
    	}else
    		if(aux!=null) {
    			List<GeneralTree<AreaEmpresa>> children=aux.getChildren();
    			for(GeneralTree<AreaEmpresa> child: children) {
    				cola.enqueue(child);
    				cant++;
    				suma+=child.getData().getTardanza();
    			}
    		}
    }
    return promedio;
}

}
