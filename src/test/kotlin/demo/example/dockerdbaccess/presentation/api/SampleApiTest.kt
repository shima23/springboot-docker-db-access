package demo.example.dockerdbaccess.presentation.api

import com.ninja_squad.dbsetup.DbSetup
import com.ninja_squad.dbsetup.Operations
import com.ninja_squad.dbsetup.Operations.insertInto
import com.ninja_squad.dbsetup.destination.DataSourceDestination
import com.ninja_squad.dbsetup.operation.Operation
import demo.example.dockerdbaccess.domain.model.Sample
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*
import javax.sql.DataSource

@SpringBootTest
class SampleApiTest {

    @Autowired
    private lateinit var sampleApi: SampleApi

    @Autowired
    private lateinit var dataSource: DataSource

    @BeforeEach
    fun beforeTest() {
        val operations = Operations.sequenceOf(Operations.deleteAllFrom("sample"))
        DbSetup(DataSourceDestination(dataSource), operations).launch()
    }

    @Test
    fun sampleApiTest() {
        val sample = Sample("Taro Yamada", 30, "Japan", "xxxxx@example.com")
        insertSample(sample)
        val response = sampleApi.getSample("xxxxx@example.com")
        assertThat(response.name).isEqualTo(sample.name)
        assertThat(response.age).isEqualTo(sample.age)
        assertThat(response.country).isEqualTo(sample.country)
        assertThat(response.mailAddress).isEqualTo(sample.mailAddress)
    }

    private fun insertSample(sample: Sample) {
        val dest = DataSourceDestination(dataSource)
        val operations : Operation =
            insertInto("sample")
                .row()
                .column("id", UUID.randomUUID())
                .column("name", sample.name)
                .column("age",  sample.age)
                .column("country", sample.country)
                .column("mail_address", sample.mailAddress)
                .end()
                .build()
        DbSetup(dest, operations).launch()
    }
}
