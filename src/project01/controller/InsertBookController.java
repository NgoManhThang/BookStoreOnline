package project01.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import project01.model.BookDto;
import project01.service.BookService;
import project01.serviceImpl.BookServiceImpl;
import project01.ultis.CommonConstant;
import project01.ultis.Function;

@WebServlet(urlPatterns = { "/insertBook" })
@MultipartConfig(maxFileSize = 1073741824)
public class InsertBookController extends HttpServlet{
	
	private BookService bookService;
	
	@Override
	public void init() throws ServletException {
		bookService = new BookServiceImpl();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		try {
			String bookName = "";
			String price = "";
			String description = "";
			String author = "";
			String quantity = "";
			String pathImage = "";
			String category = "";
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
			diskFileItemFactory.setRepository(new File("D:/Project_java_web/Project01/WebContent"));
			ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
			List<FileItem> fileItems = fileUpload.parseRequest(req);
			for(FileItem fileItem : fileItems) {
				if(!fileItem.isFormField()) {
					if(fileItem.getFieldName().equals("bookPicture")) {
						String fileName = Function.generateUniqueFileName()+"_"+fileItem.getName();
						File file = new File(CommonConstant.IMAGE_LOCATION+fileName);
						fileItem.write(file);
						pathImage = fileName;
					}
				}
				if(fileItem.isFormField()) {
					if(fileItem.getFieldName().equals("bookName")) {
						bookName = fileItem.getString("UTF-8");
					}
					else if(fileItem.getFieldName().equals("bookPrice")) {
						price = fileItem.getString();
					}
					else if(fileItem.getFieldName().equals("bookDecription")) {
						description = fileItem.getString("UTF-8");
					}
					else if(fileItem.getFieldName().equals("bookAuthor")) {
						author = fileItem.getString("UTF-8");
					}
					else if(fileItem.getFieldName().equals("bookQuantity")) {
						quantity = fileItem.getString();
					}
					else if(fileItem.getFieldName().equals("category")) {
						category = fileItem.getString();
					}
				}
			}
			
			BookDto bookDto = new BookDto(0L, bookName, price, description, pathImage, quantity, author, category);
			
			bookService.insertBook(bookDto);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/pages/insert-book.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/pages/insert-book.jsp");
		dispatcher.forward(req, resp);
	}
}
