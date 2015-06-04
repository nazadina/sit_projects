package bsuir.controller;

import bsuir.model.pojo.Product;
import bsuir.model.service.ProductService;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping("/product")
    public String setupForm(Map<String, Object> map) {
        Product product = new Product();
        map.put("product", product);
        map.put("productList", productService.getAllProduct());
        return "product";
    }

    @RequestMapping(value = "/product.do", method = RequestMethod.POST)
    public String doActions(@ModelAttribute Product product, BindingResult result,
            @RequestParam String action, Map<String, Object> map) {
        Product productResult = new Product();
        int count = 0;
        for (Object listId : getListId()) {
            int i = (int) listId;
            if (i == product.getId()) {
                count++;
            }
        }
        switch (action.toLowerCase()) {
            case "add":
                productService.add(product);
                productResult = product;
                break;
            case "edit":
                if (count == 0) {
                    System.out.println("Edit: this id is not in the database");
                } else {
                    productService.edit(product);
                    productResult = product;
                    break;
                }
            case "delete":
                if (count == 0) {
                    System.out.println("Delete: this id is not in the database");
                } else {
                    productService.delete(product.getId());
                    productResult = new Product();
                    break;
                }
            case "search":
                Product searchProduct = productService.getProduct(product.getId());
                productResult = searchProduct != null ? searchProduct : new Product();
                break;
        }
        map.put("product", productResult);
        map.put("productList", productService.getAllProduct());
        return "product";
    }

    public List getListId() {
        Session session = sessionFactory.openSession();
        List lst = session.createQuery("select id from Product").list();
        return lst;
    }
}
