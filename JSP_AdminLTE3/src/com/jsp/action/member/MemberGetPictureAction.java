package com.jsp.action.member;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.utils.GetUploadPath;

public class MemberGetPictureAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fileName = request.getParameter("picture");
		String savedPath = GetUploadPath.getUploadPath("member.picture.upload");
		
		String filePath = savedPath+fileName;
		
		sendFile(request,response,filePath);
		
		
		return null;
	}
	
	private void sendFile(HttpServletRequest request, HttpServletResponse response, String filePath) throws ServletException, IOException {
		//보낼 파일 설정.
		File downloadFile = new File(filePath);
		FileInputStream inStream = new FileInputStream(downloadFile);
		
		ServletContext context = request.getSession().getServletContext();
		
		//파일 포맷으로 MIME를 결정한다.
		String mimeType = context.getMimeType(filePath);
		if(mimeType==null) {
			mimeType = "application/octet-stream";
		}
		System.out.println("MIME type:" + mimeType);
		
		//reponse 수정.
		response.setContentType(mimeType);
		response.setContentLength((int)downloadFile.length());
		
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",downloadFile.getName());
		response.setHeader(headerKey, headerValue);
		
		//파일 내보내기
		ServletOutputStream outStream = response.getOutputStream();
		byte[] buffer = new byte[4096];
		int bytesRead = -1;
		
		while((bytesRead = inStream.read(buffer))!=-1){
			outStream.write(buffer,0,bytesRead);
		}
		
		if(inStream!=null) inStream.close();
		if(outStream!=null) outStream.close();
	}

}
