package api.requests.common.ExcelOperation;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExcelReader {

String excelFile;

    public String getTestFilePath(String testFileName)  {
        List<String> result = null;
        try {

            Path path = (Path) Paths.get(System.getProperty("user.dir"));
            try (Stream<Path> walk = Files.walk(path)) {
                result = walk
                        .filter(p -> !Files.isDirectory(p))
                        .map(p -> p.toString())
                        .filter(f -> f.contains(testFileName))
                        .collect(Collectors.toList());
            }

        }catch (IOException e) {

        }
     return result.get(0);
}


    public Recordset getRecordsSet(String excelFileName, String sheetName, Map params)
    {

        String query = "Select * from " + sheetName + " where ";
        for(Object key : params.keySet())
        {
            query = query + key + "=" +"'"+params.get(key)+"'"+ " and ";

        }
        query = query.substring(0, query.length() -4).trim();


        Recordset recordset = null;
        Connection connection = null;
        Fillo fillo = new Fillo();


        try {
            connection = fillo.getConnection(getTestFilePath(excelFileName));
        } catch (FilloException e) {
            throw new RuntimeException(e);
        }

        try {
            recordset = connection.executeQuery(query);
        } catch (FilloException e) {
            throw new RuntimeException(e);
        }
        return  recordset;
    }

    public Recordset getRecordsSet2(String excelFileName, String sheetName, Map params)
    {

        String query = "Select * from " + sheetName + " where ";
        for(Object key : params.keySet())
        {
            query = query + key + "=" +"'"+params.get(key)+"'"+ " and ";
        }
        query = query.substring(0, query.length() -4).trim();

        Recordset recordset = null;
        Connection connection = null;
        Fillo fillo = new Fillo();


        try {
            connection = fillo.getConnection(getTestFilePath(excelFileName));
        } catch (FilloException e) {
            throw new RuntimeException(e);
        }

        try {
            recordset = connection.executeQuery(query);
        } catch (FilloException e) {
            throw new RuntimeException(e);
        }
        return  recordset;
    }

    public void writeIntoExcel(File FileName, String sheetName, Map<String, String> dataToSelect, String updatedColumn, String content) {

        try {
            Fillo fillo = new Fillo();
            Connection connection = fillo.getConnection(FileName.getAbsolutePath());

            String query = "Update " + sheetName + " Set " + updatedColumn + "= '" + content + "' where ";
            for (Object key : dataToSelect.keySet()) {
                query = query + key + "=" + "'" + dataToSelect.get(key) + "'" + " and ";
            }

            query = query.substring(0, query.length() - 4).trim();

            connection.executeUpdate(query);
            connection.close();

        } catch (Exception e) {
               e.printStackTrace();
        }

    }

    public String readFromToExcel(File FileName, String sheetName, Map<String, String> dataToSelect, String selectColumn) {
        String data = "";
        try {
            Fillo fillo = new Fillo();
            Connection connection = fillo.getConnection(FileName.getAbsolutePath());

            String query = " Select "+selectColumn+" from "+sheetName+" where ";
            for (Object key : dataToSelect.keySet()) {
                query = query + key + "=" + "'" + dataToSelect.get(key) + "'" + " and ";
            }

            query = query.substring(0, query.length() - 4).trim();

            Recordset recordset =  connection.executeQuery(query);
            while (recordset.next()){
                data = recordset.getField(selectColumn);
            }

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
