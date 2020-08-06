package demo.example.dockerdbaccess.presentation.api

import demo.example.dockerdbaccess.domain.service.SampleService
import demo.example.dockerdbaccess.presentation.dto.SampleDto
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("sample")
class SampleApi(private val sampleService: SampleService) {
    @GetMapping("{mailAddress}")
    fun getSample(@RequestParam("mailAddress") mailAddress: String ): SampleDto {
        val sample = sampleService.getSample(mailAddress)
        return SampleDto(sample)
    }
}
