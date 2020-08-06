package demo.example.dockerdbaccess.domain.factory

import demo.example.dockerdbaccess.domain.model.Sample
import demo.example.dockerdbaccess.persistence.entity.SampleEntity
import org.springframework.stereotype.Component

@Component
class SampleFactory {
    fun createSampleFromEntity(entity: SampleEntity): Sample {
        return Sample(
            entity.name!!,
            entity.age!!,
            entity.country!!,
            entity.mailAddress!!
        )
    }
}
