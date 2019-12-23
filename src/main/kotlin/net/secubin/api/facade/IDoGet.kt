package net.secubin.api.facade

import net.secubin.api.model.CryptMessageOut
import java.util.*

/**
 * Provides functionality to receive stored encrypted messages from a data storage.
 */
interface IDoGet {
    /**
     * Gets the encrypted message stored behind the given id. If no such message was found an empty
     * Optional will be returned.
     */
    fun get(id: String): Optional<CryptMessageOut>
}