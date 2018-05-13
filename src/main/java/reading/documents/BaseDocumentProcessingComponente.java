package reading.documents;

import java.io.InputStream;

import com.google.common.collect.Table;

public abstract class BaseDocumentProcessingComponente {
	
	public final void processDocument(InputStream inputStream){
		Table<Integer, String, String> arrayTable = readTable(inputStream);
		removeInvalideRow(arrayTable);
		mapDifferentIdentifierToInternalNumber(arrayTable);
		sumAmountByIdentifier(arrayTable);
		
	}
	
	protected abstract Table<Integer, String, String> readTable(InputStream inputStream);
	
	protected abstract Table<Integer, String, String> removeInvalideRow(Table<Integer, String, String> arrayTable);
	
	/*
	 * Optional Step
	 */
	protected Table<Integer, String, String> mapDifferentIdentifierToInternalNumber(Table<Integer, String, String> arrayTable){
		return arrayTable;
	}
	protected abstract Table<Integer, String, String> sumAmountByIdentifier(Table<Integer, String, String> arrayTable);
	

	

}
