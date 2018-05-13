package reading.documents.strategy1;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.Table;

import reading.documents.SumQuantityByIdentifierStrategy;
import reading.documents.strategy1.ProcessingExampleExcel.COLUMN_HEADERS;

public class SumQuantityByIdentifier implements SumQuantityByIdentifierStrategy {

	@Override
	public Table<Integer, String, String> sumAmountByIdentifier(Table<Integer, String, String> arrayTable) {
		final Map<String, String> rowsWithdoubledMaterialNrList = new HashMap<>();
		String materialNumber = null;
		Integer quantityFromTable = null;
		
		for (int rowKey = 1; rowKey <= arrayTable.rowKeySet().size(); rowKey++) {
			materialNumber = arrayTable.get(rowKey, COLUMN_HEADERS.MATERIALNUMBER.toString());
			quantityFromTable = Integer.parseInt(arrayTable.get(rowKey, COLUMN_HEADERS.QUANTITY.toString()));
			if (rowsWithdoubledMaterialNrList.containsKey(materialNumber)) {
				String quantitySumUntilNow = rowsWithdoubledMaterialNrList.get(materialNumber);
				Integer newQunatity = Integer.parseInt(quantitySumUntilNow) + quantityFromTable;
				rowsWithdoubledMaterialNrList.put(materialNumber, newQunatity.toString());
			} else {
				rowsWithdoubledMaterialNrList.put(materialNumber, quantityFromTable.toString());
			}
		}
		arrayTable.clear();
		
		Integer rowKey = 1;
		for(String materialNr : rowsWithdoubledMaterialNrList.keySet()){
			arrayTable.put(rowKey, COLUMN_HEADERS.POSITION.toString(), rowKey.toString());
			arrayTable.put(rowKey, COLUMN_HEADERS.MATERIALNUMBER.toString(), materialNr);
			arrayTable.put(rowKey, COLUMN_HEADERS.QUANTITY.toString(), rowsWithdoubledMaterialNrList.get(materialNr));
			
			rowKey++;
		}
		System.out.println(arrayTable);
		
		return arrayTable;
	}

}
