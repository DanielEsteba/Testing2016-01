package cl.ubb.agil;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.hamcrest.CoreMatchers.is;


@SuppressWarnings("unused")
public class ProductoTest {
	
	Categoria cat = new Categoria ("bebidas" , "015");
	Producto prod= new Producto ("fanta", 5, 50, cat);
	Existencia exis[]=new Existencia[10];
	
	@Test
	
	public void StockBajoConStock10StockMinimo5StockMaximo50(){
		cat = new Categoria ("bebidas" , "015");
		prod = new Producto ("fanta", 5, 50, cat);
		Existencia existencia[]=new Existencia[10];
		prod.stock=15;
		
		boolean vof=prod.isBajoStock();
		
		assertFalse(vof);
		
	}
	
	@Test
	public void StockBajoConStock0Minimo5Maximo50(){
		prod=new Producto("bebidas",5,50,cat);
		boolean vof=prod.isBajoStock();
		assertFalse(!vof);
	
	}
	
	@Test
	public void StockBajoConStock5Minimo5Maximo50(){
		prod=new Producto("bebidas",5,50,cat);
		for(int i=0;i<1;i++){
			exis[i]=new Existencia(" "+i);
		}
		for(int i=0;i<1;i++){
			prod.existencias[i]=exis[i];
		}
		prod.stock=5;
		boolean vof=prod.isBajoStock();
		assertFalse(vof);
	}
	
	
	@Test
	public void getCodigoProximaExistenciaConStockMayorA0YCategoriaNula()throws ExcepcionDeProducto{
		prod=new Producto("bebidas",5,50);
		Existencia exis=new Existencia("1");	
		prod.existencias[0]=exis;
		prod.stock=1;
		String m=prod.getCodigoProximaExistencia();
		assertFalse(m.equals("aaa-1"));
	
	}
	
	@Test
	public void getCodigoProximaExistenciaConStockMayorA0YCategoriaNoNula()throws ExcepcionDeProducto{
		prod=new Producto("bebidas",5,50,cat);
		Existencia exis=new Existencia("1");
		prod.existencias[0]=exis;
		prod.stock=1;
		String m=prod.getCodigoProximaExistencia();
		assertFalse(m.equals("001-1"));
	}
	
	@Test (expected=ExcepcionDeProducto.class)
	public void getCodigoProximaExistenciaConStockIgualA0() throws ExcepcionDeProducto{
		prod=new Producto("bebidas",5,50);
		prod.getCodigoProximaExistencia();
		
	}
	
	@Test
	public void setNombreConNombreValido(){
		prod=new Producto("",5,50);
		String name="DEVT";
		prod.setNombre(name);
		assertTrue(name.equals(prod.nombre));
	}
	
	
	@Test
	public void setCategoriaConNombreInCorrecto(){
		prod=new Producto("lacteos",5,50);
		Categoria cate=new Categoria("fanta","005");
		prod.setCategoria(cate);
		assertEquals(prod.categoria, cate);
		
	}
	
	@Test
	public void setCategoriaConNombreValido(){
		prod=new Producto("bebidas",5,50);
		Categoria cate=new Categoria("fanta","001");
		prod.setCategoria(cate);
		assertEquals(prod.categoria, cate);
	}
	
	@Test
	public void getCategoriaEntregaCategoriaCorrectamente(){
		prod=new Producto("bebidas",5,50,cat);
		Categoria cate;
		cate=prod.getCategoria();
		assertEquals(prod.categoria,cate);
	}
	
	
	
	
		
	
	
	
	
	
	

}
