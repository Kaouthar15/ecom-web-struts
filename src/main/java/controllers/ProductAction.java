package controllers;

import models.Product;
import services.ProductService;
import services.CategoryService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.io.File;

public class ProductAction extends Action {

    private ProductService productService = new ProductService();
    private CategoryService categoryService = new CategoryService();

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");

        if ("add".equalsIgnoreCase(action)) {
            return addProduct(request, mapping);
        } else if ("edit".equalsIgnoreCase(action)) {
            return editProduct(request, mapping);
        } else if ("delete".equalsIgnoreCase(action)) {
            return deleteProduct(request, mapping);
        } else {
            return listProducts(request, mapping);
        }
    }

    private ActionForward addProduct(HttpServletRequest request, ActionMapping mapping) {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        Long categoryId = Long.parseLong(request.getParameter("id_category"));
        String photo = uploadPhoto(request);  // Handle photo upload

        Product product = new Product(name, price, photo, categoryId);
        productService.addProduct(product);
        return listProducts(request, mapping);
    }

    private ActionForward editProduct(HttpServletRequest request, ActionMapping mapping) {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        Long categoryId = Long.parseLong(request.getParameter("id_category"));
        String photo = uploadPhoto(request);  // Handle photo upload if changed

        Product product = new Product(id, name, price, photo, categoryId);
        productService.updateProduct(product);
        return listProducts(request, mapping);
    }

    private ActionForward deleteProduct(HttpServletRequest request, ActionMapping mapping) {
        Long id = Long.parseLong(request.getParameter("id"));
        productService.deleteProduct(id);
        return listProducts(request, mapping);
    }

    private ActionForward listProducts(HttpServletRequest request, ActionMapping mapping) {
        request.setAttribute("products", productService.getAllProducts());
        request.setAttribute("categories", categoryService.getAllCategories());
        return mapping.findForward("product");
    }

    private String uploadPhoto(HttpServletRequest request) {
        // Implement photo upload logic here, save the file to "images/products/"
        // and return the filename to store in the database.
        // Example:
        // Part filePart = request.getPart("photo");
        // String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        // String uploadPath = getServletContext().getRealPath("") + File.separator + "images/products";
        // File file = new File(uploadPath, fileName);
        // filePart.write(file.getAbsolutePath());
        // return fileName;
        return ""; // Return the filename
    }
}
