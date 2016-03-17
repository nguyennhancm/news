package service.email.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 9/25/2015
 * Time: 12:14 PM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "file")
public class File implements Serializable{
    private String fileId;
    private String fileTypeId;
    private String fileName;
    private String statusId;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String userId;

    @Id
    @Column(name = "file_id", nullable = false, insertable = true, updatable = true, length = 20)
    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    @Basic
    @Column(name = "file_type_id", nullable = false, insertable = true, updatable = true, length = 20)
    public String getFileTypeId() {
        return fileTypeId;
    }

    public void setFileTypeId(String fileTypeId) {
        this.fileTypeId = fileTypeId;
    }

    @Basic
    @Column(name = "file_name", nullable = true, insertable = true, updatable = true, length = 255)
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Basic
    @Column(name = "status_id", nullable = true, insertable = true, updatable = true, length = 20)
    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column(name = "create_time", nullable = true, insertable = true, updatable = true)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time", nullable = true, insertable = true, updatable = true)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "user_id", nullable = true, insertable = true, updatable = true, length = 20)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        File file = (File) o;

        if (createTime != null ? !createTime.equals(file.createTime) : file.createTime != null) return false;
        if (fileId != null ? !fileId.equals(file.fileId) : file.fileId != null) return false;
        if (fileName != null ? !fileName.equals(file.fileName) : file.fileName != null) return false;
        if (fileTypeId != null ? !fileTypeId.equals(file.fileTypeId) : file.fileTypeId != null) return false;
        if (statusId != null ? !statusId.equals(file.statusId) : file.statusId != null) return false;
        if (updateTime != null ? !updateTime.equals(file.updateTime) : file.updateTime != null) return false;
        if (userId != null ? !userId.equals(file.userId) : file.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fileId != null ? fileId.hashCode() : 0;
        result = 31 * result + (fileTypeId != null ? fileTypeId.hashCode() : 0);
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
