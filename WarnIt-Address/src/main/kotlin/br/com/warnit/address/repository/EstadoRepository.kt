package br.com.warnit.address.repository

import org.springframework.data.repository.CrudRepository
import br.com.warnit.address.model.Estado
import org.springframework.transaction.annotation.Transactional
import java.util.*


interface EstadoRepository: CrudRepository<Estado, Long>{
    @Transactional(readOnly = true)
    fun findByNome(nome: String): Optional<Estado>
}