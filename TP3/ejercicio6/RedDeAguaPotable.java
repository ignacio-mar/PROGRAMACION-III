package practica3;
import java.util.List;
import java.util.LinkedList;


public class RedDeAguaPotable {
		private GeneralTree<String> arbol;
		
		public RedDeAguaPotable(GeneralTree<String> arbol) {
			this.arbol=arbol;
			
		}
		public double minimoCaudal(double caudal) {
			return recorrer2(this.arbol,caudal);
		}
		private double recorrer2(GeneralTree<String> arbol,double caudal) {
			
			if(arbol==null ||arbol.isEmpty()) {
				return 0;
			}
			if(arbol.hasChildren()) {
				List<GeneralTree<String>> children=arbol.getChildren();
				int cant=children.size();
			    double dato;
			    double min=999999;
			for(GeneralTree<String> child: children) { 
				dato=recorrer2(child,caudal/cant);
			    if(dato<min) {
			    	min=dato;
			    }
			    }
			return min;
			}else
		
			return caudal;
		}
		/*public double minimoCaudal(double caudal) {
			return  minimoCaudal_private(caudal, this.arbol); //le mando el arbol (variable de la clase)
		}
		
		private double minimoCaudal_private(double caudal, GeneralTree<String> a) { //se envia como parametro el caudal inicial

			 
		  if(a.isLeaf()) //caso base si es una hoja --> retorno caudal 
			 return caudal;
		 
		 double caudalMinimo = 9999999;
		 
		 int cantNodos = a.getChildren().size(); //cantidad de hijos del NODO
		 
		 for(GeneralTree<String> child: a.getChildren()) { //por cada elemento (child) de la lista de hijos
			double  caudalHijo =  minimoCaudal_private(caudal/cantNodos, child); 
			if(caudalHijo<caudalMinimo) //la comparacion se hace entre nodos hermanos
				caudalMinimo = caudalHijo;
		 }
		 
		 return caudalMinimo ;
		 
		}*/

	
}
