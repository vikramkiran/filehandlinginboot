package com.app.filehandling;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploading {

	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)

	public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException {

		System.out.println("uploaded successfully...1");
		File file1 = new File("D:/work/" + file.getOriginalFilename());
		System.out.println("uploaded successfully...2");
		file1.createNewFile();
		System.out.println("uploaded successfully...3");
		FileOutputStream fileOutputStream = new FileOutputStream(file1);

		fileOutputStream.write(file.getBytes());

		fileOutputStream.close();

		return "uploaded successfully...";
	}

}
