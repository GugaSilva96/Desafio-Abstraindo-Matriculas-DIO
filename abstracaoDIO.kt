import java.time.LocalDate

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, val email: String, val dataNascimento: LocalDate) {
    fun exibirDetalhes() {
        println("Usuário: $nome - Email: $email - Data de Nascimento: $dataNascimento")
    }
}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na formação $nome.")
    }

    fun exibirDetalhes() {
        println("Formação: $nome - Nível: $nivel")
        println("Conteúdos:")
        conteudos.forEach { println("- ${it.nome}") }
        println("Inscritos: ${inscritos.size} alunos\n")
    }
}

fun main() {
    val formacaoKotlin = Formacao("Formação Kotlin Developer", Nivel.INTERMEDIARIO, listOf(
        ConteudoEducacional("Introdução ao Kotlin"),
        ConteudoEducacional("Programação Orientada a Objetos em Kotlin")
    ))

    val formacaoPython = Formacao("Formação Python Developer", Nivel.BASICO, listOf(
        ConteudoEducacional("Introdução ao Python"),
        ConteudoEducacional("Programação Orientada a Objetos em Python")
    ))

    val usuario1 = Usuario("Gustavo", "guga.h.costaesilva@gmail.com", LocalDate.of(1996, 11, 1))
    val usuario2 = Usuario("Lorena", "meuamor@gmail.com", LocalDate.of(1999, 6, 20))
    val usuario3 = Usuario("Nala", "meudog@gmail.com", LocalDate.of(2023, 12, 14))

    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)
    formacaoPython.matricular(usuario3)

    formacaoKotlin.exibirDetalhes()
    formacaoPython.exibirDetalhes()
    usuario1.exibirDetalhes()
    usuario2.exibirDetalhes()
    usuario3.exibirDetalhes()
}
