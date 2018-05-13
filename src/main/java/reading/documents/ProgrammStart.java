package reading.documents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import reading.documents.strategy1.ProcessingExampleExcel;
import reading.documents.strategy1.ReadTable;
import reading.documents.strategy1.RemoveRow;
import reading.documents.strategy1.SumQuantityByIdentifier;

public class ProgrammStart {

	public static void main(String[] args) throws FileNotFoundException {

		final String EXAMPLE_FILE = "./order.xlsx";

		BaseDocumentProcessingComponente baseDocumentProcessingComponente = new ProcessingExampleExcel(new ReadTable(),
				new RemoveRow(), new SumQuantityByIdentifier());
		FileInputStream fileInputStream = new FileInputStream(new File(EXAMPLE_FILE));

		baseDocumentProcessingComponente.processDocument(fileInputStream);

	}

}
