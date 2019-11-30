package com.fcdaeseung;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fcdaeseung.dao.IMaterialDao;
import com.fcdaeseung.dao.IStyleDao;
import com.fcdaeseung.dto.Material;
import com.fcdaeseung.dto.Style;

@RestController
@CrossOrigin
public class FcRestController {
	@Autowired
	IStyleDao styleDao;
	@Autowired
	IMaterialDao materialDao;
	
	@GetMapping(path="/style")
	public Map<String, Object> style(){
		Map<String, Object> result = new HashMap<>();
		List<Style> styleList = styleDao.listStyle();
		result.put("resultSuccese",true);
		result.put("length",styleList.size());
		result.put("styleList", styleList);
		return result;
	}
	
	@GetMapping(path="/material")
	public Map<String, Object> material(){
		Map<String, Object> result = new HashMap<>();
		List<Material> materialList = materialDao.listMaterial();
		if(materialList == null) {
			result.put("resultSuccese",false);
			return result;
		}
		result.put("resultSuccese",true);
		result.put("length",materialList.size());
		result.put("styleList", materialList);
		return result;
	}
}