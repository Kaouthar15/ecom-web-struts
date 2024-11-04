//package controllers;
//
//
//import java.io.IOException;
////import java.nio.file.Paths;
////import jakarta.servlet.http.Part;
////import jakarta.servlet.ServletRequest;
////import java.io.File;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.apache.struts.action.Action;
//import org.apache.struts.action.ActionForm;
//import org.apache.struts.action.ActionForward;
//import org.apache.struts.action.ActionMapping;
//import models.Product;
//import services.ProductService;
//import services.CategoryService;
//
//
//public class ProductAction extends Action {
//
//    private ProductService productService = new ProductService();
//    private CategoryService categoryService = new CategoryService();
//
//    public ActionForward execute(ActionMapping mapping, ActionForm form,
//                                 HttpServletRequest request, HttpServletResponse response) throws Exception {
//        String action = request.getParameter("action");
//
//        if ("add".equalsIgnoreCase(action)) {
//        	System.out.println("add action");
//            return addProduct(request, mapping);
//        } else if ("edit".equalsIgnoreCase(action)) {
//        	System.out.println("edit action");
//            return editProduct(request, mapping);
//        } else if ("delete".equalsIgnoreCase(action)) {
//        	System.out.println("delete action");
//            return deleteProduct(request, mapping);
//        } else {
//        	System.out.println("else action");
//            return listProducts(request, mapping);
//        }
//    }
//
//    private ActionForward addProduct(HttpServletRequest request, ActionMapping mapping) throws IOException, ServletException {
//    	System.out.println("addProduct action");
//        String name = request.getParameter("name");
//        double price = Double.parseDouble(request.getParameter("price"));
//        Long categoryId = Long.parseLong(request.getParameter("id_category"));
//        String photo = uploadPhoto(request);  // Handle photo upload
//
//        Product product = new Product(name, price, photo, categoryId);
//        productService.addProduct(product);
//        return listProducts(request, mapping);
//    }
//
//    private ActionForward editProduct(HttpServletRequest request, ActionMapping mapping) throws IOException, ServletException {
//    	System.out.println("editProduct action");
//        Long id = Long.parseLong(request.getParameter("id"));
//        String name = request.getParameter("name");
//        double price = Double.parseDouble(request.getParameter("price"));
//        Long categoryId = Long.parseLong(request.getParameter("id_category"));
//        String photo = uploadPhoto(request);  // Handle photo upload if changed
//
//        Product product = new Product(id, name, price, photo, categoryId);
//        productService.updateProduct(product);
//        return listProducts(request, mapping);
//    }
//
//    private ActionForward deleteProduct(HttpServletRequest request, ActionMapping mapping) {
//    	System.out.println("deleteProduct action");
//        Long id = Long.parseLong(request.getParameter("id"));
//        productService.deleteProduct(id);
//        return listProducts(request, mapping);
//    }
//
//    private ActionForward listProducts(HttpServletRequest request, ActionMapping mapping) {
//    	System.out.println("listProducts action");
//        request.setAttribute("products", productService.getAllProducts());
//        request.setAttribute("categories", categoryService.getAllCategories());
//        return mapping.findForward("product");
//    }
//
//    private String uploadPhoto(HttpServletRequest request) throws IOException, ServletException {
//         System.out.println("uploadPhoto");
////         Part filePart = (Part) request.getPart("photo");
////         String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
////         @SuppressWarnings("deprecation")
////		String uploadPath = ((Object) getServlet()).getRealPath("") + File.separator + "images/products";
////         File file = new File(uploadPath, fileName);
////         filePart.write(file.getAbsolutePath());
////         return fileName; 
//         return "";
//    }
//}
