package demo.example.dockerdbaccess.persistence.repository

import demo.example.dockerdbaccess.persistence.entity.SampleEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SampleEntityRepository : JpaRepository<SampleEntity, UUID> {
    fun findByMailAddress(mailAddress: String): SampleEntity?
}
