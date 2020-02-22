package com.codenotfound.dto;

import java.sql.Blob;

import org.primefaces.model.UploadedFile;

public class FileuploadDto {

	private String id;

	private String documentName;

	private String documentFor;

	private String documentHolderName;

	private String documentCategory;

	private Blob documentFile;

	private UploadedFile file;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getDocumentFor() {
		return documentFor;
	}

	public void setDocumentFor(String documentFor) {
		this.documentFor = documentFor;
	}

	public String getDocumentHolderName() {
		return documentHolderName;
	}

	public void setDocumentHolderName(String documentHolderName) {
		this.documentHolderName = documentHolderName;
	}

	public String getDocumentCategory() {
		return documentCategory;
	}

	public void setDocumentCategory(String documentCategory) {
		this.documentCategory = documentCategory;
	}

	public Blob getDocumentFile() {
		return documentFile;
	}

	public void setDocumentFile(Blob documentFile) {
		this.documentFile = documentFile;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
