package reading.documents.strategy1;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import reading.documents.ReadTableStrategy;
import reading.documents.strategy1.ProcessingExampleExcel.COLUMN_HEADERS;


public class ReadTable implements ReadTableStrategy {

	@Override
	public Table<Integer, String, String> readTable(InputStream inputStream) {
		Workbook workbook = null;
		final Table<Integer, String, String> arrayTable = HashBasedTable.create();
		try {
			workbook = new XSSFWorkbook(inputStream);
			Sheet firstSheert = workbook.getSheetAt(0);
			final int positionCellRow = 0;
			final int positionCellMaterialNr = 1;
			final int positionCellQuantity = 2;

			final DataFormatter dataFormatter = new DataFormatter();

			for (int rowIndex = 1; rowIndex <= firstSheert.getLastRowNum(); rowIndex++) {
				Row row = firstSheert.getRow(rowIndex);
				Cell positionCell = row.getCell(positionCellRow);
				arrayTable.put(rowIndex, COLUMN_HEADERS.POSITION.toString(),
						dataFormatter.formatCellValue(positionCell));

				Cell positionMaterialNr = row.getCell(positionCellMaterialNr);
				arrayTable.put(rowIndex, COLUMN_HEADERS.MATERIALNUMBER.toString(),
						dataFormatter.formatCellValue(positionMaterialNr));

				Cell positionQuantity = row.getCell(positionCellQuantity);
				arrayTable.put(rowIndex, COLUMN_HEADERS.QUANTITY.toString(),
						dataFormatter.formatCellValue(positionQuantity));
			}
			workbook.close();

		} catch (IOException e) {

		} finally {
			closeStream(workbook);
		}
		return arrayTable;
	}

	private static void closeStream(Workbook workbook) {
		if (workbook != null) {
			try {
				workbook.close();
			} catch (final IOException ioException) {
			}
		}
	}

}
