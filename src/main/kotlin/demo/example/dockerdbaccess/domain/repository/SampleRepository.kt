package demo.example.dockerdbaccess.domain.repository

import demo.example.dockerdbaccess.domain.factory.SampleFactory
import demo.example.dockerdbaccess.domain.model.Sample
import demo.example.dockerdbaccess.persistence.repository.SampleEntityRepository
import org.springframework.stereotype.Repository

@Repository
class SampleRepository(private val entityRepository: SampleEntityRepository) {
    fun getSample(mailAddress: String): Sample {
        return SampleFactory().createSampleFromEntity(entityRepository.findByMailAddress(mailAddress)!!)
    }
}
