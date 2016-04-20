package cl.ubb.agil;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.hamcrest.CoreMatchers.is;


@SuppressWarnings("unused")
public class ProductoTest {
	
	Producto prod;
	Categoria cat;
	
	@Test
	
	public void StockBajoConStockQuinceStockMinCincoStockMaxCincuenta(){
		Categoria categoria = new Categoria ("bebidas" , "015");
		Producto producto= new Producto ("fanta", 5, 50, categoria);
		producto.stock=15;
		
		boolean vof=producto.isBajoStock();
		
		assertFalse(vof);
		
		
		
	}
	
	
	

}
