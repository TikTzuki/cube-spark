package tik.test.cubespark.controller.LocalBill;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

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
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import tik.test.cubespark.model.LocalBill.dto.LocalBillDTO;
import tik.test.cubespark.model.LocalBill.entity.LocalBillEntity;
import tik.test.cubespark.service.LocalBillService.ILocalBillService;
import tik.test.cubespark.service.LocalBillService.LocalBillPDFExporter;

@CrossOrigin
@RestController
public class LocalBillController {
	
	@Autowired
	private ILocalBillService localBillService;
	
	@PostMapping(value = "/localbill")
	public LocalBillDTO createNew(@RequestBody LocalBillDTO model) {
		return localBillService.save(model);
	}
	
	@PutMapping(value ="/localbill/{bill_id}")
	public LocalBillDTO updateNew(@RequestBody LocalBillDTO model, @PathVariable("bill_id") Long id) {
		model.setId(id);
		
		return localBillService.save(model);
	}
	
	@DeleteMapping(value ="/localbill")
	public void deleteNew(@RequestBody String[] ids) {
		localBillService.delete(ids);
	}
	
	@RequestMapping(value = "/localbill/export", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> export() throws IOException {

        List<LocalBillEntity> localBillEntity = (List<LocalBillEntity>) localBillService.findAll();

        ByteArrayInputStream bis = LocalBillPDFExporter.export(localBillEntity);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=bill.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }


}
