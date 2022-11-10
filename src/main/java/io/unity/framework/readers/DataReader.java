package io.unity.framework.readers;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.google.common.collect.Lists;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataReader {


    public Object[][] getExcelDataForDataProvider(String fileName, int sheetNo) {
        ArrayList<ArrayList> collectionRow = new ArrayList();
        ArrayList<String> rowList = null;
        try {
            File file = new File("src/test/java/data/" + fileName);
            FileInputStream fis = new FileInputStream(file.getAbsoluteFile());

            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(sheetNo);
            Iterator<Row> itr = sheet.iterator();

            while (itr.hasNext()) {
                Row row = itr.next();
                rowList = new ArrayList();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    if (cell.getCellType().equals(CellType.STRING)) {
                        rowList.add(cell.getStringCellValue());
                    }

                    if (cell.getCellType().equals(CellType.NUMERIC)) {
                        rowList.add("" + cell.getNumericCellValue());
                    }

                    if (cell.getCellType().equals(CellType.BOOLEAN)) {
                        rowList.add("" + cell.getBooleanCellValue());
                    }

                }
                collectionRow.add(rowList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int row = collectionRow.size() - 1;
        int column = collectionRow.get(0).size();



        Object[][] test = new Object[row][column];

        for (int i = 0; i < row; i++) {
            try {
                ArrayList collumList = collectionRow.get(i + 1);
                if (collumList.size() != 0) {
                    for (int j = 0; j < column; j++) {
                        test[i][j] = collumList.get(j);
                    }
                }
            } catch (Exception e) {
                System.out.println("Failed To fetch Data");
            }

        }
        return test;
    }





    public List getColumnData(String ExcelFile, String SheetName, String column) {
        File file = new File("src/test/java/data/" + ExcelFile);
        Fillo fillo = new Fillo();
        List finalList = new ArrayList();
        Connection connection = null;
        try {
            connection = fillo.getConnection(file.getAbsolutePath());

            String strQuery = "Select * from \"" + SheetName + "\"";

            Recordset recordset = connection.executeQuery(strQuery);

            while (recordset.next()) {
                finalList.add(recordset.getField(column));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return finalList;
    }


    public Object[][] generateCombinationData(List lists) {
        List l = Lists.cartesianProduct(lists);
        Object[][] finalList = new Object[l.size()][lists.size()];

        for (int i = 0; i < l.size(); i++) {
            Object[] a = ((List) l.get(i)).toArray();
            for (int j = 0; j < a.length; j++) {
                finalList[i][j] = a[j];
            }
        }

        return finalList;
    }


}
