package com.charlesmtnsdev.finpay_api.entity;

import com.charlesmtnsdev.finpay_api.enums.NotificationStatus;
import com.charlesmtnsdev.finpay_api.enums.NotificationType;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.type.PostgreSQLEnumJdbcType;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @Column(name = "notification_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notifications_notification_id_seq")
    @SequenceGenerator(name = "notifications_notification_id_seq", sequenceName = "notifications_notification_id_seq", allocationSize = 1)
    private Long id;

    private Long accountId;

    private Long paymentId;

    @Enumerated(EnumType.STRING)
    @JdbcType(value = PostgreSQLEnumJdbcType.class)
    private NotificationType type;

    private String message;

    @Enumerated(EnumType.STRING)
    @JdbcType(value = PostgreSQLEnumJdbcType.class)
    private NotificationStatus status;

    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotificationStatus getStatus() {
        return status;
    }

    public void setStatus(NotificationStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", paymentId=" + paymentId +
                ", type=" + type +
                ", message='" + message + '\'' +
                ", status=" + status +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getAccountId(), that.getAccountId()) && Objects.equals(getPaymentId(), that.getPaymentId()) && getType() == that.getType() && Objects.equals(getMessage(), that.getMessage()) && getStatus() == that.getStatus() && Objects.equals(getCreatedAt(), that.getCreatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAccountId(), getPaymentId(), getType(), getMessage(), getStatus(), getCreatedAt());
    }
}
