package com.charlesmtnsdev.finpay_api.entity;

import com.charlesmtnsdev.finpay_api.enums.AuditAction;
import com.charlesmtnsdev.finpay_api.enums.AuditEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.type.PostgreSQLEnumJdbcType;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "audit_log_audit_id_seq")
    @SequenceGenerator(name = "audit_log_audit_id_seq", sequenceName = "audit_log_audit_id_seq", allocationSize = 1)
    private Long id;

    private Long entityId;

    @Enumerated(EnumType.STRING)
    @JdbcType(value = PostgreSQLEnumJdbcType.class)
    private AuditEntity entityType;

    @Enumerated(EnumType.STRING)
    @JdbcType(value = PostgreSQLEnumJdbcType.class)
    private AuditAction auditAction;

    private String oldStatus;

    private String newStatus;

    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public AuditEntity getEntityType() {
        return entityType;
    }

    public void setEntityType(AuditEntity entityType) {
        this.entityType = entityType;
    }

    public AuditAction getAuditAction() {
        return auditAction;
    }

    public void setAuditAction(AuditAction auditAction) {
        this.auditAction = auditAction;
    }

    public String getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(String oldStatus) {
        this.oldStatus = oldStatus;
    }

    public String getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "AuditLog{" +
                "id=" + id +
                ", entityId=" + entityId +
                ", entityType=" + entityType +
                ", auditAction=" + auditAction +
                ", oldStatus='" + oldStatus + '\'' +
                ", newStatus='" + newStatus + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AuditLog auditLog = (AuditLog) o;
        return Objects.equals(getId(), auditLog.getId()) && Objects.equals(getEntityId(), auditLog.getEntityId()) && getEntityType() == auditLog.getEntityType() && getAuditAction() == auditLog.getAuditAction() && Objects.equals(getOldStatus(), auditLog.getOldStatus()) && Objects.equals(getNewStatus(), auditLog.getNewStatus()) && Objects.equals(getCreatedAt(), auditLog.getCreatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEntityId(), getEntityType(), getAuditAction(), getOldStatus(), getNewStatus(), getCreatedAt());
    }
}
