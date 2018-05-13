package reading.documents;

import com.google.common.collect.Table;

public interface RemoveRowStrategy {

	public Table<Integer, String, String> removeInvalideRow(Table<Integer, String, String> arrayTable);

}
