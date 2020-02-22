package com.codenotfound.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.UploadedFile;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.codenotfound.dto.FileuploadDto;
import com.codenotfound.entity.Fileupload;
import com.codenotfound.repo.FileuploadRepo;

@Controller
@Named
@ViewScoped
public class FileuploadController {

	private FileuploadDto fileuploadDto = new FileuploadDto();

	private UploadedFile file;
	@Autowired
	private FileuploadRepo fileuploadRepo;

	public void uploadFile() {
		if (fileuploadDto.getFile() != null) {
			
			Fileupload fileupload =new Fileupload();
			BeanUtils.copyProperties(fileuploadDto, fileupload);
			
			fileupload.setDocumentFile(fileuploadDto.getFile().getContents());
			
			fileuploadRepo.save(fileupload);
			
			FacesMessage message = new FacesMessage("Succesful",
					fileuploadDto.getFile().getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public FileuploadDto getFileuploadDto() {
		return fileuploadDto;
	}

	public void setFileuploadDto(FileuploadDto fileuploadDto) {
		this.fileuploadDto = fileuploadDto;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

}
