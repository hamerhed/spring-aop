package pl.hamerhed.aspects.modifier;

import java.util.List;
import java.util.Map;

public interface Converter {
	public Map<String, String> getMap(List<String> list);
}
