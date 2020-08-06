package demo.example.dockerdbaccess.persistence.entity

import org.hibernate.annotations.Type
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "SAMPLE")
data class SampleEntity(
    @Id
    @Column(name = "ID")
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    var id: UUID? = null,

    @Column(name = "NAME", length = 100)
    var name: String? = null,

    @Column(name = "AGE")
    var age: Int? = null,

    @Column(name = "COUNTRY", length = 100)
    var country: String? = null,

    @Column(name = "MAIL_ADDRESS", nullable = false, length = 255)
    var mailAddress: String? = null
)
