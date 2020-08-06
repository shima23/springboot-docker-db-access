package demo.example.dockerdbaccess.presentation.dto

import demo.example.dockerdbaccess.domain.model.Sample

data class SampleDto(
    var name: String,
    var age: Int,
    var country: String,
    var mailAddress: String
) {
    constructor(sample: Sample): this(
        sample.name,
        sample.age,
        sample.country,
        sample.mailAddress
    )
}
