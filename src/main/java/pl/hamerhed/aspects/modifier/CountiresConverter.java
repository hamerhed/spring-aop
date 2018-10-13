package pl.hamerhed.aspects.modifier;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class CountiresConverter implements Converter{

	public Map<String, String> getMap(List<String> list) {
		if(list == null || list.size() == 0) return Collections.emptyMap();
		return list.stream().collect(Collectors.toMap(k -> k, v -> v));
	}
	

}
