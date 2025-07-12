package baseDatos.Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class Excel {

	private static Workbook libro;
	private static XSSFWorkbook libroLectura;
	
	public static void main(String[] args) {
//		crearExcel();
//		leerExcel();
//		cargarExcel();
		cargarDB();
	}
	public static void cargarDB() {
		libro = new XSSFWorkbook();
		Sheet hoja= libro.createSheet("Reporte de productos");
		Conexion con= new Conexion();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Row fila0=hoja.createRow(0);
		String []cabeceras=new String[] {"Codigo","Nombre","Precio","Cantidad"};
		for (int i = 0; i < cabeceras.length; i++) {
			Cell celda=fila0.createCell(i);
			celda.setCellValue(cabeceras[i]);
		}
		int numFila= 1;
		try {
			Connection conexion=con.getConnection();
			ps=conexion.prepareStatement("select codigo,nombre,precio,cantidad from producto");
			rs=ps.executeQuery();
			int numCol =rs.getMetaData().getColumnCount();
			
			while(rs.next()) {
				Row filaDatos=hoja.createRow(numFila);
				for (int i = 0; i < numCol; i++) {
					Cell celda=filaDatos.createCell(i);
					
					if(i==0 || i==1)
						celda.setCellValue(rs.getString(i+1));
					else
						celda.setCellValue(rs.getDouble(i+1));
				}
				
				numFila++;
			}
			
			FileOutputStream archivo=new FileOutputStream("Productos.xlsx");
			libro.write(archivo);
			archivo.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	public static void cargarExcel() {
		Conexion con= new Conexion();
		PreparedStatement ps=null;
		try {
			Connection conexion=con.getConnection();
			FileInputStream archivo=new FileInputStream(new File("C:\\Users\\640 G5\\eclipse-workspace\\SistemasOperativos\\Excel.xlsx"));
			libroLectura = new XSSFWorkbook(archivo);
			XSSFSheet hojaLectura= libroLectura.getSheetAt(0);
			
			int numFilas=hojaLectura.getLastRowNum();
			
			for (int i = 1; i <= numFilas; i++) {
				Row fila= hojaLectura.getRow(i);
				ps=conexion.prepareStatement("insert into producto (codigo,nombre,precio,cantidad) values (?,?,?,?)");
				ps.setString(1, fila.getCell(0).getStringCellValue());
				ps.setString(2, fila.getCell(1).getStringCellValue());
				ps.setDouble(3, fila.getCell(2).getNumericCellValue());
				ps.setInt(4, (int)fila.getCell(3).getNumericCellValue());
				ps.executeUpdate();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void leerExcel() {
		try {
			FileInputStream archivo=new FileInputStream(new File("C:\\Users\\640 G5\\eclipse-workspace\\SistemasOperativos\\Excel.xlsx"));
			libroLectura = new XSSFWorkbook(archivo);
			XSSFSheet hojaLectura= libroLectura.getSheetAt(0);
			
			int numFilas=hojaLectura.getLastRowNum();
			
			for (int i = 0; i <= numFilas; i++) {
				Row fila= hojaLectura.getRow(i);
				int numCol=fila.getLastCellNum();
				for (int j = 0; j <numCol; j++) {
					Cell celda=fila.getCell(j);
					switch (celda.getCellTypeEnum().toString()) {
					case "NUMERIC":
						System.out.print(celda.getNumericCellValue()+"\t");
						break;
					case "STRING":
						System.out.print(celda.getStringCellValue()+"\t");
						break;
					case "FORMULA":
						System.out.print(celda.getCellFormula()+"\t");
						break;

					}
				}
				System.out.println();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void crearExcel() {
		libro = new XSSFWorkbook();
		Sheet hoja= libro.createSheet("hola java");
		Row fila0=hoja.createRow(0);
		fila0.createCell(0).setCellValue("hola");
		fila0.createCell(1).setCellValue(true);
		fila0.createCell(2).setCellValue(2.4);
		
		Cell celda=fila0.createCell(3);
		celda.setCellFormula(String.format("14+5", ""));
		Row fila1= hoja.createRow(1);
		fila1.createCell(0).setCellValue(4.5);
		fila1.createCell(1).setCellValue(15.7);
		
		Cell celda1=fila1.createCell(2);
		celda1.setCellFormula(String.format("A%d+B%d", 2,2));
		try {
			FileOutputStream archivo=new FileOutputStream("Excel.xlsx");
			libro.write(archivo);
			archivo.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	

}
