package io.unity.framework.readers;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class DataReader {


    public static void main(String[] args) {

        DataReader dataReader = new DataReader();

        ArrayList list = new ArrayList();
        list.add("item Class");
        list.add("item Type");

        dataReader.getExcelDataForDataProvider("addNewUser.xlsx", 0, list);


    }


    @DataProvider(name = "SearchProvider")
    public Object[][] getExcelDataForDataProvider(String fileName, int sheetNo, ArrayList<String> columnName) {
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




                  /*  switch (cell.getCellType()) {
                        case STRING:
                            rowList.add(cell.getStringCellValue());
                            break;
                        case NUMERIC:
                            rowList.add(cell.getNumericCellValue());
                            break;
                        case BOOLEAN:
                            rowList.add(cell.getBooleanCellValue());
                            break;
                    }*/
                }
                collectionRow.add(rowList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int row = collectionRow.size();
        int column = columnName.size();


        System.out.println(row + "....." + column);
        System.out.println(collectionRow);


        Object[][] test = new Object[row][column];

        for (int i = 0; i < row; i++) {
            try {
                ArrayList collumList = collectionRow.get(i);
                if (collumList.size() != 0) {
                    for (int j = 0; j < column; j++) {
                        test[i][j] = collumList.get(j);
                    }
                }
            } catch (Exception e) {
                System.out.println("Failed To fetch Data");
            }

        }
        System.out.println(test);
        return test;
    }

}


