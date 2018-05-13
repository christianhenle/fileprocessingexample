package reading.documents;

import com.google.common.collect.Table;

public interface SumQuantityByIdentifierStrategy {
	
	public Table<Integer, String, String> sumAmountByIdentifier(Table<Integer, String, String> arrayTable);

}
