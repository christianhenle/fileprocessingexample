package reading.documents.strategy1;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Table;

import reading.documents.RemoveRowStrategy;
import reading.documents.strategy1.ProcessingExampleExcel.COLUMN_HEADERS;

public class RemoveRow implements RemoveRowStrategy {

	@Override
	public Table<Integer, String, String> removeInvalideRow(Table<Integer, String, String> arrayTable) {
		for (int rowKey = 1; rowKey <= arrayTable.rowKeySet().size(); rowKey++) {
			if (StringUtils.isAnyEmpty(arrayTable.get(rowKey, COLUMN_HEADERS.POSITION.toString()),
					arrayTable.get(rowKey, COLUMN_HEADERS.MATERIALNUMBER.toString()),
					arrayTable.get(rowKey, COLUMN_HEADERS.QUANTITY.toString()))) {
				arrayTable.remove(rowKey, COLUMN_HEADERS.POSITION.toString());
				arrayTable.remove(rowKey, COLUMN_HEADERS.MATERIALNUMBER.toString());
				arrayTable.remove(rowKey, COLUMN_HEADERS.QUANTITY.toString());
			}
			// TODO checkNumeric Quantity because addition in next step
		}

		return arrayTable;
	}

}
