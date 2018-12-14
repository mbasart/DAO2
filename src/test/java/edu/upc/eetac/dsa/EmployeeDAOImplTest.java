package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.model.Employee;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeDAOImplTest {
    IEmployeeDAO employeeDAO;

    @Test
    public void addEmployeeDB(){
        this.employeeDAO = EmployeeDAOImpl.getInstance();

        //this.employeeDAO.addEmployee("Meritxell","Basart",33333);
        //this.employeeDAO.addEmployee("Carles","Martinez",2222);
        this.employeeDAO.addEmployee("Sergi","Lucas",2222);

        this.employeeDAO.clear();
    }

    @Test
    public void selectEmployeeDB(){
        this.employeeDAO = EmployeeDAOImpl.getInstance();
        this.employeeDAO.getEmployee(2);
        //String nameEm = this.employeeDAO.getEmployee(2).getName();
        //Assert.assertEquals("Meritxell", this.employeeDAO.getEmployee(2).getName());
    }

}