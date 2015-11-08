/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wb.control;

import java.awt.Container;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author anuruddha
 */
public class MyiReportViewer extends javax.swing.JInternalFrame  {

    public static int i;
    
     public MyiReportViewer() {
        this(null, null);
    }
     
  

    
    public MyiReportViewer(String fileName) {
        this(fileName, null);
    }

    public MyiReportViewer(String fileName, HashMap parameter) {
     super("Veiw Report");
        try {
           i=5;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            i=10;
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nwsdb", "root", "123");
            i=15;
            JasperReport jr = JasperCompileManager.compileReport(fileName);
            i=50;
            JasperPrint jp = JasperFillManager.fillReport(jr, parameter, con);
            i=70;
            JRViewer jv = new JRViewer(jp);
            i=90;
            Container c = getContentPane();
            i=99;
            c.add(jv);
    
            i=100;
           // JRDocxExporter je = new JRDocxExporter();
          //  je.setParameter(JRExporterParameter.JASPER_PRINT, jp);
          //  je.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "./Docs/a.docx");
         //   je.exportReport();
    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        setBounds(10, 10, 1000, 680);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    
    
    public MyiReportViewer(String fileName, HashMap parameter, String saveAs) {
     super("Veiw Report");
        try {
            i=5;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            i=10;
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nwsdb", "root", "123");
            i=15;
            JasperReport jr = JasperCompileManager.compileReport(fileName);
            i=50;
            JasperPrint jp = JasperFillManager.fillReport(jr, parameter, con);
            i=70;
            JRViewer jv = new JRViewer(jp);
            i=90;
            Container c = getContentPane();
            i=99;
            c.add(jv);
    
            i=100;
            JRDocxExporter je = new JRDocxExporter();
            je.setParameter(JRExporterParameter.JASPER_PRINT, jp);
            je.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "./src/Docs/"+saveAs);
            je.exportReport();
       
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        setBounds(10, 10, 935, 456);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }


    public static void main(String[] args) {
        // TODO code application logic here
    }
}
