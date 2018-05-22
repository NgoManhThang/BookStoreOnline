package project01.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project01.ultis.CommonConstant;

@WebServlet(urlPatterns = { "/image"})
public class ImageDownloadController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileName = req.getParameter("fileName");
		File file = new File(CommonConstant.IMAGE_LOCATION + fileName);
		resp.setContentType("image/*");
		resp.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
		OutputStream out = resp.getOutputStream();
		try (FileInputStream in = new FileInputStream(file)) {
		    byte[] buffer = new byte[4096];
		    int length;
		    while ((length = in.read(buffer)) > 0) {
		        out.write(buffer, 0, length);
		    }
		}
		out.flush();
	}
}
