package hs.kr.equus.user.domain.user.domain

import hs.kr.equus.user.domain.BaseUUIDEntity
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated

@Entity(name = "tbl_user")
class User(
    id: UUID?,

    @Column(columnDefinition = "char(11)", nullable = false, unique = true)
    val phoneNumber: String,

    @Column(columnDefinition = "char(60)", nullable = false)
    var password: String,

    @Column(columnDefinition = "char(5)", nullable = false)
    val name: String,

    @Column(columnDefinition = "bit(1) default 1", nullable = false)
    val isParent: Boolean,

    @Column(name = "receipt_code", nullable = true)
    var receiptCode: Long?,

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    val role: UserRole
) : BaseUUIDEntity(id) {

    fun changePassword(password: String) {
        this.password = password
    }

    fun changeReceiptCode(receiptCode: Long) {
        this.receiptCode = receiptCode
    }

    fun toUserCache(): UserCache {
        return UserCache(
            id = id,
            phoneNumber = phoneNumber,
            name = name,
            isParent = isParent,
            receiptCode = receiptCode,
            role = role,
            ttl = 60 * 10
        )
    }
}
