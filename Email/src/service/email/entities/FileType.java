package service.email.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 9/25/2015
 * Time: 7:33 AM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "file_type")
public class FileType implements Serializable{
    private String fileTypeId;
    private String typeName;
    private String extension;

    @Id
    @Column(name = "file_type_id", nullable = false, insertable = true, updatable = true, length = 20)
    public String getFileTypeId() {
        return fileTypeId;
    }

    public void setFileTypeId(String fileTypeId) {
        this.fileTypeId = fileTypeId;
    }

    @Basic
    @Column(name = "type_name", nullable = true, insertable = true, updatable = true, length = 255)
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Basic
    @Column(name = "extension", nullable = true, insertable = true, updatable = true, length = 255)
    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileType fileType = (FileType) o;

        if (extension != null ? !extension.equals(fileType.extension) : fileType.extension != null) return false;
        if (fileTypeId != null ? !fileTypeId.equals(fileType.fileTypeId) : fileType.fileTypeId != null) return false;
        if (typeName != null ? !typeName.equals(fileType.typeName) : fileType.typeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fileTypeId != null ? fileTypeId.hashCode() : 0;
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        result = 31 * result + (extension != null ? extension.hashCode() : 0);
        return result;
    }
}
