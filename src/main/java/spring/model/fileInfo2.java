package spring.model;

public class fileInfo2 {

	String originalFilename; 
	byte[] fileSource; 
	long fileSize;
	
	
	
	
	public String getOriginalFilename() {
		return originalFilename;
	}
	public byte[] getFileSource() {
		return fileSource;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}
	public void setFileSource(byte[] fileSource) {
		this.fileSource = fileSource;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	
	
}
