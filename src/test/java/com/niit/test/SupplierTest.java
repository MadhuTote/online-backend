package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.Dao.SupplierDAO;
import com.niit.model.Category;
import com.niit.model.Supplier;

public class SupplierTest {
	
	static SupplierDAO supplierDAO;

	@BeforeClass
	public static void initialize() {
		AnnotationConfigApplicationContext configApplnContext = new AnnotationConfigApplicationContext();
		configApplnContext.scan("com.niit");
		configApplnContext.refresh();
		// SessionFactory
		// sessionFactory=(SessionFactory)configApplnContext.getBean("DBConfig.class");
		supplierDAO=(SupplierDAO)configApplnContext.getBean("supplierDAO");	}

	@Test
	public void addSupplierTest()
    {
        Supplier supplier=new Supplier();
        supplier.setSupId(1001);
        supplier.setSupName("JMohan");
        supplier.setSupAddress("sion");
         
        assertTrue(supplierDAO.updateSupplier(supplier));    }
	@Test
    public void updateSupplierTest()
    {
        Supplier supplier=new Supplier();
        supplier.setSupId(1001);
        supplier.setSupName("JMohan");
        supplier.setSupAddress("Sion Best Place ");
         
        assertTrue(supplierDAO.updateSupplier(supplier));
    }
@Test
public void deleteCategoryTest()
{
    Supplier supplier=new Supplier();
    supplier.setSupId(1002);
    assertTrue(supplierDAO.deleteSupplier(supplier));
}
@Test
public void retrieveCategoryTest()
{
    List<Supplier> listSupplier=supplierDAO.retrieveSupplier();
    assertNotNull("Problem in Retriving ",listSupplier);
    this.show(listSupplier);
}
 
public void show(List<Supplier> listSupplier)
{
    for(Supplier supplier:listSupplier)
    {
        System.out.println("Supplier ID:"+supplier.getSupId());
        System.out.println("Supplier Name:"+supplier.getSupName());
    }
}
@Test
public void getSupplierTest()
{
    Supplier supplier=supplierDAO.getSupplier(1001);
    assertNotNull("Problem in Getting:",supplier);
    System.out.println("Supplier ID:"+supplier.getSupId());
    System.out.println("Supplier Name:"+supplier.getSupName());
}

}