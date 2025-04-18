package practica3;

public class Navidad {
	private GeneralTree<Integer> arbol;
	public Navidad(GeneralTree<Integer> arbol) {
		this.arbol=arbol;
	}
	public String esAbetoNavidenio() {
		
		return recorrer(this.arbol);
		
		}
	
	private String recorrer(GeneralTree<Integer> a) {
		if(a==null || a.isEmpty()) {
			return "no";
		}
		if(a.getChildren().size()>=3) {
			int cant=0;
			String mensaje;
			for(GeneralTree<Integer> child: a.getChildren()) {
				if(child.isLeaf()) {
					cant++;
				}else { 
				mensaje=recorrer(child);
				if(mensaje.equals("no")) {
					return "no";
				}}
			}
			if (cant>=3) {
				return "si";
			}else return "no";
			
		}else 
			return "no";
				
	}

}
