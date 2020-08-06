package demo.example.dockerdbaccess

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DockerDBAccessApplication

fun main(args: Array<String>) {
	runApplication<DockerDBAccessApplication>(*args)
}
