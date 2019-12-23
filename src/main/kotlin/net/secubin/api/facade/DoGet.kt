package net.secubin.api.facade

import net.secubin.api.model.CryptMessageOut
import org.springframework.stereotype.Service
import java.util.*

@Service
class DoGet : IDoGet {
    override fun get(id: String): Optional<CryptMessageOut> {
        TODO("not implemented")
    }
}