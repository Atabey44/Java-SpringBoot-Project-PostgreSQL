package kodlamaio.malatya.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.malatya.business.abstracts.ProductService;
import kodlamaio.malatya.core.utilities.results.DataResult;
import kodlamaio.malatya.core.utilities.results.Result;
import kodlamaio.malatya.entities.concretes.Product;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

	private ProductService productService;
	
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall")
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
	}
	
	@PostMapping("/add")
		public Result add(@RequestBody Product product) {
		return this.productService.add(product);
		}
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		return this.productService.getByProductName(productName);
	}
	
	@GetMapping("getByProductNameAndCategory")
	public DataResult<Product> getByProductNameAndCategory(@RequestParam String productName, @RequestParam int categoryId){
		return this.productService.getByProductNameAndCategory(productName, categoryId);
	}
	
	@GetMapping("getByProductNameOrCategory")
	public DataResult<List<Product>> getByProductNameOrCategory(@RequestParam String productName, @RequestParam int categoryId){
		return this.productService.getByProductNameOrCategory(productName, categoryId);
	}
	
	@GetMapping("getByCategoryIn")
	public DataResult<List<Product>> getByCategoryIn(List<Integer> categoryId){
		return this.productService.getByCategoryIn(categoryId);
	}
	
	@GetMapping("getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(String productName){
		return this.productService.getByProductNameContains(productName);
	}
	
	@GetMapping("getByProductNameStartsWith")
	public DataResult<List<Product>> getByProductNameStartsWith(String productName){
		return this.productService.getByProductNameStartsWith(productName);
	}

	@GetMapping("getByNameAndCategory")
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId){
		return this.productService.getByNameAndCategory(productName, categoryId);
	}
	
	@GetMapping("/getAllPage")
	public DataResult<List<Product>> getAll(int pageNo, int pageSize){
		return this.productService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("/getAllAsc")
	public DataResult <List<Product>> getAllSorted(){
		return this.productService.getAllSorted();
	}

}
	
