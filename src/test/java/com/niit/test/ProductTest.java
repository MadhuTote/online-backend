package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Dao.ProductDAO;
import com.niit.model.Product;

public class ProductTest {
	
	static ProductDAO productDAO;

	@BeforeClass
	public static void initialize() {
		AnnotationConfigApplicationContext configApplnContext = new AnnotationConfigApplicationContext();
		configApplnContext.scan("com.niit");
		configApplnContext.refresh();
		// SessionFactory
		// sessionFactory=(SessionFactory)configApplnContext.getBean("DBConfig.class");
		productDAO=(ProductDAO)configApplnContext.getBean("productDAO");	}

	@Test
	public void addProductTest()
    {
        Product product=new Product();
        product.setProductId(1001);
        product.setProductName("JMShirt");
        product.setProductDesc("John Miller Shirt");
        product.setStock(10);
        product.setPrice(800);
        product.setCatId(1001);
        product.setSupId(1001);
         
        assertTrue(productDAO.updateProduct(product));    }
	@Test
    public void updateProductTest()
    {
        Product product=new Product();
        product.setProductId(1002);
        product.setProductName("mobile");
        product.setProductDesc("iphone 7 with Best Price");
        product.setStock(20);
        product.setCatId(1003);
        product.setSupId(1004);
         
        assertTrue(productDAO.updateProduct(product));
    }
@Test
public void deleteProductTest()
{
    Product product=new Product();
    product.setProductId(1002);
    assertTrue(productDAO.deleteProduct(product));
}
@Test
public void retrieveProductTest()
{
    List<Product> listProduct=productDAO.retrieveProduct();
    assertNotNull("Problem in Retriving ",listProduct);
    this.show(listProduct);
}
 
public void show(List<Product> listProduct)
{
    for(Product product:listProduct)
    {
        System.out.println("Product ID:"+product.getProductId());
        System.out.println("Product Name:"+product.getProductName());
    }
}
@Test
public void getProductTest()
{
    Product product=productDAO.getProduct(1002);
    assertNotNull("Problem in Getting:",product);
    System.out.println("Product ID:"+product.getProductId());
    System.out.println("Product Name:"+product.getProductName());
}

}
