package demo.example.dockerdbaccess.domain.service

import demo.example.dockerdbaccess.domain.model.Sample
import demo.example.dockerdbaccess.domain.repository.SampleRepository
import org.springframework.stereotype.Service

@Service
class SampleService(
    private val sampleRepository: SampleRepository) {

    fun getSample(mailAddress: String): Sample {
        return sampleRepository.getSample(mailAddress)
    }
}
