package guru.spring.services.mapservices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import guru.spring.domain.DomainObject;


public abstract class AbstractMapService {

	protected Map<Integer, DomainObject> domainMap;

	
	public AbstractMapService() {
		domainMap = new HashMap<>();
//		loadDomainObjects();
	}
	
	public List<DomainObject> listAll() {
		return new ArrayList<>(domainMap.values());
	}
	
	public DomainObject getById(Integer id) {
		return domainMap.get(id);
	}
	
	public DomainObject saveOrUpdate(DomainObject obj) {
		if (obj != null) {
			if (obj.getId() == null) {
				obj.setId(getNextKey());
			}
			domainMap.put(obj.getId(), obj);
			return obj;
		} else {
			throw new RuntimeException("DomainObject can't be null!");
		}		
	}
	
	public void delete(Integer id) {
		domainMap.remove(id);
	}

	private Integer getNextKey() {
		Integer max = 1;
		try {
			max = Collections.max(domainMap.keySet()) + 1;
		} catch (Exception e) { /* suppress */	}
		System.out.println("max=" +  max);
		return max;
	}
	
	/*
	 * Load objects into map
	 */
//	protected abstract void loadDomainObjects();
}
