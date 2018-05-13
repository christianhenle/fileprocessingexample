package reading.documents;

import java.io.InputStream;

import com.google.common.collect.Table;

public interface ReadTableStrategy {
	
	public Table<Integer, String, String> readTable(InputStream inputStream);

}
