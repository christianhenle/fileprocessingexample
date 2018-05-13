package reading.documents.strategy1;

import java.io.InputStream;

import com.google.common.collect.Table;

import reading.documents.BaseDocumentProcessingComponente;
import reading.documents.ReadTableStrategy;
import reading.documents.RemoveRowStrategy;
import reading.documents.SumQuantityByIdentifierStrategy;

public class ProcessingExampleExcel extends BaseDocumentProcessingComponente {

	private ReadTableStrategy readTableStrategy;
	private RemoveRowStrategy removeRowStrategy;
	private SumQuantityByIdentifierStrategy sumQuantityByIdentifierStrategy;
	
	
	public ProcessingExampleExcel(ReadTableStrategy readTableStrategy, RemoveRowStrategy removeRowStrategy, SumQuantityByIdentifierStrategy sumQuantityByIdentifierStrategy){
		this.readTableStrategy = readTableStrategy;
		this.removeRowStrategy = removeRowStrategy;
		this.sumQuantityByIdentifierStrategy = sumQuantityByIdentifierStrategy;
	}
	
	
	public static enum COLUMN_HEADERS {
		POSITION, MATERIALNUMBER, QUANTITY
	};

	@Override
	protected Table<Integer, String, String> readTable(InputStream inputStream) {
		return this.readTableStrategy.readTable(inputStream);
	}

	@Override
	protected Table<Integer, String, String> removeInvalideRow(Table<Integer, String, String> arrayTable) {
		return this.removeRowStrategy.removeInvalideRow(arrayTable);
	}

	@Override
	protected Table<Integer, String, String> sumAmountByIdentifier(Table<Integer, String, String> arrayTable) {
		return this.sumQuantityByIdentifierStrategy.sumAmountByIdentifier(arrayTable);
	}
}
