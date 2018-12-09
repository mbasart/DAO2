package edu.upc.eetac.dsa;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeDAOImplTest {
    IEmployeeDAO employeeDAO;

    @Test
    public void addEmployeeDB(){
        this.employeeDAO = EmployeeDAOImpl.getInstance();
        this.employeeDAO.addEmployee("Meritxell","Basart",33333);
        this.employeeDAO.clear();
    }

}