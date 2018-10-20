package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class UpLoadController {
	
	@RequestMapping(value="toUploadPage")
	public String toUploadPage() {
		return "/ImgUploadTest";
	}
	
	@RequestMapping(value="uploadImg")
	public String uploadImg(Model model,MultipartFile file) throws IllegalStateException, IOException {
		//上传图片的原始名称
		String originalFileFileName = null;
		if(file != null) {
			originalFileFileName = file.getOriginalFilename();
		}
		//新的文件名称
		String newFileNamme = null;
		//上传图片
		if(!StringUtils.isEmpty(originalFileFileName)) {
			//存储图片的物理地址
			//这个地方的路径结尾必须要以\\结尾
			String pic_path = "E:\\test\\upload\\";
			//新的图片名称
			newFileNamme = UUID.randomUUID()+originalFileFileName.substring(originalFileFileName.lastIndexOf("."));
			//创建新的文件
			File newFile = new File(pic_path+newFileNamme);
			//将内存中的数据写入磁盘
			file.transferTo(newFile);
		}
		//回显刚刚上传的图片名称
		model.addAttribute("image", newFileNamme);
		//重回到上传页面
		return "/ImgUploadTest";
	}
	
}
