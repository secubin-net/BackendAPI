package net.secubin.api.facade

import net.secubin.api.model.CryptMessage
import org.springframework.stereotype.Service

@Service
class DoStore : IDoStore {
    override fun store(message: CryptMessage): String {
        TODO("not implemented")
    }
}