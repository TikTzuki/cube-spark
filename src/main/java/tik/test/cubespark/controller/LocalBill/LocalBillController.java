package tik.test.cubespark.controller.LocalBill;
/*
 * xxminhmie
 * 
 * 
 * using HTTP methods for restful service
 * POST -> create new
 * GET -> read
 * PUT -> update
 * DELETE -> delete
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tik.test.cubespark.model.LocalBill.dto.LocalBillDTO;
import tik.test.cubespark.service.LocalBillService.ILocalBillService;

@CrossOrigin
@RestController
public class LocalBillController {
	
	@Autowired
	private ILocalBillService localBillService;
	
	@PostMapping(value = "/local-bill")
	public LocalBillDTO createNew(@RequestBody LocalBillDTO model) {
		return localBillService.save(model);
	}
	
	@PutMapping(value ="/local-bill/{bill_id}")
	public LocalBillDTO updateNew(@RequestBody LocalBillDTO model, @PathVariable("bill_id") Long id) {
		model.setId(id);
		
		return localBillService.save(model);
	}
	
	@DeleteMapping(value ="/new")
	public void deleteNew(@RequestBody String[] ids) {
		localBillService.delete(ids);
	}


}
